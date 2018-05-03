package com.revature.gambit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.gambit.entities.Location;
import com.revature.gambit.repository.LocationRepo;

@Service
public class LocationService {

	LocationRepo locationRepo;

	// Constructor
	@Autowired
	public LocationService(LocationRepo locationRepo) {
		this.locationRepo = locationRepo;
	}

	public LocationService() {
	}

	/**
	 * This method utilizes Spring's JPA repository interface to query the database
	 * for all known locations. NOTE: This returns all buildings even deactivated
	 * locations.
	 * 
	 * @author Stephen Lovick | 1803-USF-MAR05
	 * @return Returns a list of ALL rooms in the Database
	 */
	public List<Location> findAllLocation() {
		return locationRepo.findAll();
	}

	/**
	 * This method utilizes Spring's JPA repository interface, to locate a location
	 * by it locationId
	 * 
	 * @author Stephen Lovick | 1803-USF-MAR05
	 * @param id
	 *            - Long: locationId
	 * @return
	 */
	public Location findLocationByID(Long id) {
		return locationRepo.findLocationByLocationId(id);
	}

	/**
	 * This method utilizes Spring's JPA repository to persist the building to the
	 * database.
	 * 
	 * @author Stephen Lovick | 1803-USF-MAR05
	 * @param building
	 *            - location object to be added to the database with a locationId of
	 *            null.
	 * @return On success the location that was passed with a locationId of null
	 *         will be returned with a non null value. On failure the room will be
	 *         returned with a null value for buildingId.
	 */
	public Location saveLocation(Location location) {
		if (location.getLocationId() == null) {
			location.setActive(true);
			return locationRepo.saveAndFlush(location);
		} else {
			location.setLocationId(null);
			return location;
		}
	}

	/**
	 * This method utilizes Spring's JPA repository to locate a building by location
	 * change the location object's field of active to false, then saves and returns
	 * the entity's changes
	 * 
	 * @author Stephen Lovick | 1803-USF-MAR05
	 * @param id 
	 * @return On success it will return the Location with the field active set to
	 *         false.
	 */
	public Location deactivateLocation(Long id) {
		Location deactivating = locationRepo.findLocationByLocationId(id);
		deactivating.setActive(false);
		return locationRepo.saveAndFlush(deactivating);

	}

	/**
	 * This method utilizes Spring's JPA repository to update an existing room
	 * record in the database.
	 * @author Stephen Lovick | 1803-USF-MAR05
	 * @param location
	 * @return On success the location will be returned with the changes
	 *         made to the object. On failure a null location object will be
	 *         returned.
	 */
	public Location updateLocation(Location location) {
		Location check = findLocationByID(location.getLocationId());
		if (check != null) {
			return locationRepo.saveAndFlush(location);
		}
		return check;
	}

}

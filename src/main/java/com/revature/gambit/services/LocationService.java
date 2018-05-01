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
	 * Returns all Locations in the database.
	 * 
	 * @author Stephen Lovick | 1803-MAR05-USF
	 * @return List of Locations
	 */
	public List<Location> findAllLocation() {
		return locationRepo.findAll();
	}

	/**
	 * Finds the location by the Id number;
	 * 
	 * @author Stephen Lovick | 1803-MAR05-USF
	 * @param id
	 * @return On Success it returns the queried location. On failure it returns
	 *         null.
	 */
	public Location findLocationByID(Long id) {
		return locationRepo.findLocationByLocationId(id);
	}

	/**
	 * Saves the location and returns it after being written to the database.
	 * 
	 * @author Stephen Lovick | 1803-MAR05-USF
	 * @param location
	 * @return
	 */
	public Location saveLocation(Location location) {
		return locationRepo.saveAndFlush(location);
	}

	/**
	 * Deactivates the location with the specified LocationID
	 * 
	 * @param id
	 * @return
	 */
	public Location deactivateLocation(Long locationId) {
		Location deactivating = locationRepo.findLocationByLocationId(locationId.longValue());
		deactivating.setActive(false);
		return locationRepo.saveAndFlush(deactivating);

	}

	public Location updateLocation(Location location) {
		Location check = findLocationByID(location.getLocationId());
		if(check != null) {
			return locationRepo.saveAndFlush(location);
		}
		return check;
	}

}

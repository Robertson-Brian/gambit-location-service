package com.revature.gambit.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.gambit.entities.Building;
import com.revature.gambit.entities.Location;
import com.revature.gambit.repository.LocationRepo;

@Service
public class LocationService {

	LocationRepo repository;

	// Constructor
	@Autowired
	public LocationService(LocationRepo repository) {
		this.repository = repository;
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
		return repository.findAll();
	}

	/**
	 * Finds the location by the Id number;
	 * 
	 * @author Stephen Lovick | 1803-MAR05-USF
	 * @param id
	 * @return On Success it returns the queried location. On failure it returns
	 *         null.
	 */
	public Location findLocationByID(Integer id) {
		Optional<Location> result = Optional.of(repository.findLocationByLocationId(id.longValue()));
		if (result.isPresent()) {
			return result.get();
		} else {
			return null;
		}

	}

	/**
	 * Saves the location and returns it after being written to the database.
	 * 
	 * @author Stephen Lovick | 1803-MAR05-USF
	 * @param location
	 * @return
	 */
	public Location saveLocation(Location location) {
		return repository.saveAndFlush(location);
	}

	/**
	 * Deactivates the location with the specified LocationID
	 * 
	 * @param id
	 * @return
	 */
	public Location deactivateLocation(Integer locationId) {
		Location deactivating = repository.findLocationByLocationId(locationId.longValue());
		deactivating.setActive(false);
		return repository.saveAndFlush(deactivating);
	}

	/*-----------------------------Building---------------------------*/
	/**
	 * Returns all Buildings from repository.
	 * 
	 * @author Stephen Lovick | 1803-MAR05-USF
	 * @return
	 */
	public List<Building> findAllBuilding() {
		return repository.findAllBuilding();
	}

	/**
	 * Find all building at a location by LocationId.
	 * 
	 * @author Stephen Lovick | 1803-MAR05-USF
	 * @param id
	 * @return
	 */
	public List<Building> findBuildingByLocationId(Integer id) {
		return repository.findAllBuildingByLocationId(id.longValue());
	}

	/**
	 * Find a building by BuildingId.
	 * 
	 * @param id
	 * @return
	 */
	public Building findBuildingByBuildingID(Integer id) {
		return repository.findBuildingByBuildingId(id.longValue());
	}

	/**
	 * Saves and flushes changes to a building.
	 * 
	 * @param building
	 * @return
	 */
	public Building saveBuilding(Building building) {
		return repository.saveAndFlush(building);
	}

	// public Building deactivateBuilding(Integer id) {
	// Building deactivating = repository.findBuildingByBuildingId(id.longValue());
	// return null;
	// }

}

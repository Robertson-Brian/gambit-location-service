package com.revature.gambit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.gambit.entities.Location;
import com.revature.gambit.services.LocationService;

public class LocationControllerImpl implements LocationController {
	
	LocationService locationService;
	
	@Autowired
	public LocationControllerImpl(LocationService locationService) {
		this.locationService = locationService;
	}

	@Override
	public List<Location> getAllLocations() {
		return locationService.findAllLocation();
	}

	@Override
	public Location getLocationByID(Integer id) {
		return locationService.findLocationByID(id);
	}

	@Override
	public Location createLocation(Location location) {
		return locationService.saveLocation(location);
	}

	@Override
	public Location updateLocation(Integer id, Location location) {
		return locationService.saveLocation(location);
	}

	@Override
	public Location deleteLocationByID(Integer id) {
		return locationService.deactivateLocation(id);
	}

	
}

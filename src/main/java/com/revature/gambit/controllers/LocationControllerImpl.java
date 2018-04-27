package com.revature.gambit.controllers;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.Location;

import com.revature.gambit.services.LocationService;

public class LocationControllerImpl implements LocationController {
	
	LocationService locationService;
	
	@Autowired
	public LocationControllerImpl(LocationService locationService) {
		this.locationService = locationService;
	}

	@Override
	public Optional<Set<Location>> getAllLocations() {
		return locationService.findAllLocation();
	}

	@Override
	public Optional<Location> getLocationByID(Integer id) {
		return locationService.findLocationByID(id);
	}

	@Override
	public Optional<Location> createLocation(Location location) {
		return locationService.saveLocation(location);
	}

	@Override
	public Optional<Location> updateLocation(Integer id, Location location) {
		return locationService.saveLocation(location);
	}

	@Override
	public Optional<Location> deleteLocationByID(Integer id) {
		return locationService.deactivateLocation();
	}

	
}

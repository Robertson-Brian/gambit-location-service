/**
 * Location Service Controller Interface: Add Methods here See LocationControllerImpl
 * @author Stephen Lovick | 1803-USF-MAR05
 * @author Jake Trump
 * Handles all endpoint request to location services backend.
 */
package com.revature.gambit.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.revature.gambit.entities.Location;

public interface LocationController {

	List<Location> getAllLocations();

	Location getLocationByID(@PathVariable(name = "id") Long id);

	Location createLocation(@RequestBody Location location);

	Location updateLocation(@PathVariable(name = "id") Long id, @RequestBody Location location);

	Location deleteLocationByID(@PathVariable(name = "id") Long id);
	
}

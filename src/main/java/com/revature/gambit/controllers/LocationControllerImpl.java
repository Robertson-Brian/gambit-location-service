package com.revature.gambit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.gambit.entities.Location;
import com.revature.gambit.services.LocationService;

@CrossOrigin
@RestController
@RequestMapping("location")
public class LocationControllerImpl implements LocationController {

	LocationService locationService;

	// Constructor
	@Autowired
	public LocationControllerImpl(LocationService locationService) {
		this.locationService = locationService;
	}

	public LocationControllerImpl() {
	}

	/*----------------------------------Location--------------------------------*/
	/**
	 * HTTP GET getAllLocations - Handles request to Location Service API retrieve
	 * all locations
	 * 
	 * @author Stephen Lovick | 1803-USF-MAR05
	 * @author Jake Trump | 1803-USF-MAR05
	 * @param id
	 * @return On success it real the queried location. On Failure it returns a
	 *         location object with an ID of "-1" and all other fields with the
	 *         value of "Do Not Exist"
	 */
	@Override
	@GetMapping("/")
	public List<Location> getAllLocations() {
		return locationService.findAllLocation();
	}

	/**
	 * HTTP GET getLocationById - Handles request to Location Service API retrieve
	 * an individual location by ID.
	 * 
	 * @author Stephen Lovick | 1803-USF-MAR05
	 * @author Jake Trump | 1803-USF-MAR05
	 * @param id
	 * @return On success it real the queried location. On Failure it returns a
	 *         location object with an ID of "-1" and all other fields with the
	 *         value of "Do Not Exist"
	 */
	@Override
	@GetMapping("/{id}")
	public Location getLocationByID(@PathVariable(name = "id") Long id) {
		return locationService.findLocationByID(id);
	}

	/**
	 * HTTP POST createLocation - Handles requests to Location Service API to create
	 * a new location
	 * 
	 * @author Stephen Lovick | 1803-USF-MAR05
	 * @author Jake Trump | 1803-USF-MAR05
	 * @param location
	 *            from the request body
	 * @return On success the method returns the created location with a non
	 *         negative ID field. On failure the method returns a location object
	 *         with an ID of -1 and all other fields with the value of "Do Not
	 *         Exist"
	 */
	@Override
	@PostMapping("/")
	public Location createLocation(@RequestBody Location location) {
		return locationService.saveLocation(location);
	}

	/**
	 * HTTP PUT updateLocation - Handles request to Location Service API to update
	 * an existing location.
	 * 
	 * @author Stephen Lovick | 1803-USF-MAR05
	 * @author Jake Trump | 1803-USF-MAR05
	 * 
	 * @param id:
	 *            from the URI address
	 * @return
	 */
	@Override
	@PutMapping("/{id}")
	public Location updateLocation(@PathVariable(name = "id") Long id, Location location) {
		return locationService.saveLocation(location);
	}

	/**
	 * HTTP DELETE deleteLocationById - Handles request to Location Service API to
	 * place an existing location inactive
	 * 
	 * @author Stephen Lovick | 1803-USF-MAR05
	 * @author Jake Trump | 1803-USF-MAR05
	 * 
	 * @param id:
	 *            from the URI address
	 * @return
	 */
	@Override
	@DeleteMapping("/{id}")
	public Location deleteLocationByID(@PathVariable(name = "id") Long id) {
		return locationService.deactivateLocation(id);
	}
	
}

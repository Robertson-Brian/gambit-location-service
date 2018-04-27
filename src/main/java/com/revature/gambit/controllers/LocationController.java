/**
 * Location Service Controller Interface
 * @author Stephen Lovick | 1803-USF-MAR05
 * @author Jake Trump
 * Handles all endpoint request to location services backend.
 */
package com.revature.gambit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("location")
public class LocationController {
	
	LocationService locationService;

	@Autowired
	public LocationController(LocationService locationService) {
		this.locationService = locationService;
	}
	
	/*Get Methods/Read Methods*/
	/**
	 * getAllLocations - Handles request to Location Service API retrieve all
	 * locations
	 * 
	 * @author Stephen Lovick | 1803-USF-MAR05
	 * @author Jake Trump | 1803-USF-MAR05
	 * @param id
	 * @return On success it real the queried location. On Failure it returns a
	 *         location object with an ID of "-1" and all other fields with the
	 *         value of "Do Not Exist"
	 */
	@GetMapping("/")
	public List<Location> getAllLocations() {
		return locationService.findAllLocation();
	}

	/**
	 * getLocationById - Handles request to Location Service API retrieve an
	 * individual location by ID.
	 * 
	 * @author Stephen Lovick | 1803-USF-MAR05
	 * @author Jake Trump | 1803-USF-MAR05
	 * @param id
	 * @return On success it real the queried location. On Failure it returns a
	 *         location object with an ID of "-1" and all other fields with the
	 *         value of "Do Not Exist"
	 */
	@GetMapping("/{id}")
	Location getLocationByID(@PathVariable(name = "id") Integer id){
		return locationService.findLocationByID(id);
	}

	/* Post Methods/Create Methods */
	/**
	 * createLocation - Handles requests to Location Service API to create a new
	 * location
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
	@PostMapping("/")
	Location createLocation(@RequestBody Location location){
		return locationService.saveLocation(location);
	}

	/*Put Methods/Update*/
	/**
	 * updateLocation - Handles request to Location Service API to update an
	 * existing location.
	 * 
	 * @author Stephen Lovick | 1803-USF-MAR05
	 * @author Jake Trump | 1803-USF-MAR05
	 * 
	 * @param id:
	 *            from the URI address
	 * @return
	 */
	@PutMapping("/{id}")
	Location updateLocation(@PathVariable(name = "id") Integer id, @RequestBody Location location){
		return locationService.saveLocation(location);
	}

	/*Delete Methods*/
	/**
	 * deleteLocationById - Handles request to Location Service API to place an
	 * existing location inactive
	 * 
	 * @author Stephen Lovick | 1803-USF-MAR05
	 * @author Jake Trump | 1803-USF-MAR05
	 * 
	 * @param id:
	 *            from the URI address
	 * @return
	 */
	@DeleteMapping("/{id}")
	Location deleteLocationByID(@PathVariable(name = "id") Integer id){
		return locationService.deactivateLocation(id);
	}
	
	

}

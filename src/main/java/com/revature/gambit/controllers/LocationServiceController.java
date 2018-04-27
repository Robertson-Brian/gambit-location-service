/**
 * Location Service Controller Interface
 * @author Stephen Lovick | 1803-USF-MAR05
 * @author Jake Trump
 * Handles all endpoint request to location services backend.
 */
package com.revature.gambit.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.parsing.Location;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")
public interface LocationServiceController {
	//TODO : Change return object prototypes

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
	// HTTP Get Requests
	@GetMapping("/")
	Optional<List<Object>> getAllLocations();

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
	Optional<Object> getLocationByID(@PathVariable(name = "id") Integer id);

	/**
	 * createLocation - Handles requests to Location Service API to create a new
	 * location
	 * 
	 * @author Stephen Lovick | 1803-USF-MAR05
	 * @author Jake Trump | 1803-USF-MAR05
	 * @param location from the request body
	 * @return On success the method returns the created location with a non
	 *         negative ID field. On failure the method returns a location object
	 *         with an ID of -1 and all other fields with the value of "Do Not
	 *         Exist"
	 */
	// HTTP Post Requests
	@PostMapping("/")
	Optional<Location> createLocation(@RequestBody Location location);

	/**
	 * updateLocation - Handles request to Location Service API to update an
	 * existing location.
	 * 
	 * @author Stephen Lovick | 1803-USF-MAR05
	 * @author Jake Trump | 1803-USF-MAR05
	 * 
	 * @param id: from the URI address 
	 * @return
	 */
	// HTTP Put Requests
	@PutMapping("/{id}")
	Optional<Location> updateLocation(@PathVariable(name = "id") Integer id, @RequestBody Location location);

	/**
	 * deleteLocationById - Handles request to Location Service API to place an
	 * existing location inactive
	 * 
	 * @author Stephen Lovick | 1803-USF-MAR05
	 * @author Jake Trump | 1803-USF-MAR05
	 * 
	 * @param id: from the URI address 
	 * @return
	 */
	// HTTP Delete Requests
	@DeleteMapping("/{id}")
	Optional<Location> deleteLocationByID(@PathVariable(name = "id") Integer id);

}

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
import org.springframework.web.bind.annotation.*;

import com.revature.gambit.entities.Building;
import com.revature.gambit.entities.Location;
import com.revature.gambit.entities.Room;
import com.revature.gambit.entities.Unavailabilities;
import com.revature.gambit.services.LocationService;

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
	public Location getLocationByID(@PathVariable(name = "id") Integer id) {
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
	public Location updateLocation(@PathVariable(name = "id") Integer id, Location location) {
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
	public Location deleteLocationByID(@PathVariable(name = "id") Integer id) {
		return locationService.deactivateLocation(id);
	}

	/*----------------------------------------buildings-----------------------------------*/
	/**
	 * HTTP GET getAllBuildings - Handles request to Location Service API to get all
	 * buildings
	 * 
	 * @author Stephen Lovick | 1803-USF-MAR05
	 * @author Jake Trump | 1803-USF-MAR05
	 * 
	 * @return On success a list of buildings
	 */
	@Override
	@GetMapping("/building")
	public List<Building> getAllBuildings() {
		return locationService.findAllBuilding();
	}

	/**
	 * HTTP GET getLocationById - Handles request to Location Service API retrieve
	 * all buildings from an individual location by ID.
	 * 
	 * @author Stephen Lovick | 1803-USF-MAR05
	 * @author Jake Trump | 1803-USF-MAR05
	 * @param id
	 * @return On success it will return the queried location. On Failure it returns
	 *         a location object with an ID of "-1" and all other fields with the
	 *         value of "Do Not Exist"
	 */
	@Override
	@GetMapping("/{id}/building")
	public List<Building> getAllBuildingsFromLocation(@PathVariable(name = "id") Integer id) {
		return locationService.findBuildingByLocationId(id);
	}

	/**
	 * HTTP POST - buildingById - Handles request to Location Service API to
	 * retrieve a building by id.
	 * 
	 * @author Stephen Lovick | 1803-USF-MAR05
	 * @author Jake Trump | 1803-USF-MAR05
	 * @param id
	 * @return On success will return the queried building
	 */
	@Override
	@GetMapping("/building/{id}")
	public Building getBuildingById(@PathVariable(name = "id") Integer id) {
		return locationService.findBuildingByBuildingID(id);
	}

	/**
	 * HTTP POST - createBuilding - Handles request to Location Service API to
	 * create a new building
	 * 
	 * @author Stephen Lovick | 1803-USF-MAR05
	 * @author Jake Trump | 1803-USF-MAR05
	 * @param id
	 */
	@Override
	@PostMapping("building")
	public Building createBuilding(@RequestBody Building building) {
		return locationService.saveBuilding(building);
	}

	/**
	 * HTTP PUT - updateBuilding - Handle request to Location Service API to update
	 * an existing building.
	 * 
	 * @author Stephen Lovick | 1803-USF-MAR05
	 * @author Jake Trump | 1803-USF-MAR05
	 * @param id
	 * 
	 */
	@Override
	@PutMapping("building/{id}")
	public Building updateBuilding(@PathVariable(name = "id")Integer id, @RequestBody Building building) {
		return locationService.saveBuilding(building);
	}

	/**
//	 * HTTP DELETE - deleteBuildingByID - Handles request to Location Service API to
//	 * update an existing building.
//	 * @author Stephen Lovick | 1803-USF-MAR05
//	 * @author Jake Trump | 1803-USF-MAR05
//	 * @param id
//	 */
//	@Override
//	@DeleteMapping("building/{id}")
//	public Building deleteBuildingByID(@PathVariable(name = "id") Integer id) {
//		return locationService.deactivateBuilding(id);
//	}

	/*---------------------------------------Rooms---------------------------------*/
	/**
	 * HTTP GET getAllRooms - Handles request to Location Service API to get all
	 * rooms.
	 * 
	 * @author Stephen Lovick | 1803-USF-MAR05
	 * @author Jake Trump | 1803-USF-MAR05
	 * 
	 * @return On success a list of buildings
	 */
	@Override
	@GetMapping("/room")
	public List<Room> getAllRooms() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping("/{id}/room")
	public List<Room> getRoomsByLocation(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping("/building/{id}/room")
	public List<Room> getRoomsByBuilding(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * HTTP GET getRoomById - Handles request to Location Service API retrieve an
	 * individual room by ID.
	 * 
	 * @author Stephen Lovick | 1803-USF-MAR05
	 * @author Jake Trump | 1803-USF-MAR05
	 * @param id
	 * @return On success it real the queried location. On Failure it returns a
	 *         location object with an ID of "-1" and all other fields with the
	 *         value of "Do Not Exist"
	 */
	@Override
	@GetMapping("/room/{id}")
	public Room getRoomByID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * HTTP POST createRoom - Handles requests to Location Service API to create a
	 * new location
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
	@PostMapping("/room")
	public Room createRoom(Room room) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@PutMapping("/room/{id}")
	public Room updateRoom(Integer id, Room room) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	@DeleteMapping("/room/{id}")
//	public Room deleteRoomByID(Integer id) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	/*-----------------------------------Unavailabilities--------------------------------*/
	/**
	 * HTTP GET getAllUnavailabilites - Handles request to Location Service API to
	 * get all unavailabilites
	 * 
	 * @author Stephen Lovick | 1803-USF-MAR05
	 * @author Jake Trump | 1803-USF-MAR05
	 * 
	 * @return On success a list of buildings
	 */
	@Override
	@GetMapping("/unavailabilities")
	public List<Unavailabilities> getAllUnavailabilities() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * HTTP POST createUnavailabilities - Handles requests to Location Service API
	 * to create a new unavailabilities
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
	@PostMapping("/unavaiibilities")
	public Unavailabilities createUnavailabilities() {
		// TODO Auto-generated method stub
		return null;
	}

	// @Override
	// public Unavailabilities updateUnavailabilities(Integer id, Unavailabilities
	// unavailabilities) {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// @Override
	// public Unavailabilities deleteUnavailabilities(Integer id) {
	// // TODO Auto-generated method stub
	// return null;
	// }

}

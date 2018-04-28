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

import com.revature.gambit.entities.Building;
import com.revature.gambit.entities.Location;
import com.revature.gambit.entities.Room;
import com.revature.gambit.entities.Unavailabilities;

public interface LocationController {

	List<Location> getAllLocations();

	Location getLocationByID(@PathVariable(name = "id") Integer id);

	Location createLocation(@RequestBody Location location);

	Location updateLocation(@PathVariable(name = "id") Integer id, @RequestBody Location location);

	Location deleteLocationByID(@PathVariable(name = "id") Integer id);

	/*---------------------------------Buildings--------------------------------------*/
	List<Building> getAllBuildings();

	List<Building> getAllBuildingsFromLocation(@PathVariable(name = "id") Integer id);

	Building getBuildingById(@PathVariable(name = "id") Integer id);

	Building createBuilding(@RequestBody Building building);

	Building updateLocation(@PathVariable(name = "id") Integer id, @RequestBody Building Building);

	Building deleteBuildingByID(@PathVariable(name = "id") Integer id);

	/*--------------------------------Rooms-----------------------------------------*/
	List<Room> getAllRooms();

//	List<Room> getRoomsByLocation(@PathVariable(name = "id") Integer id);

	List<Room> getRoomsByBuilding(@PathVariable(name = "id") Long id);

	Room getRoomByID(@PathVariable(name = "id") Integer id);

	Room createRoom(@RequestBody Room room);

	Room updateRoom(@RequestBody Room room);

//	Room deleteRoomByID(@PathVariable(name = "id") Integer id);
	
	/*-------------------------------Availability----------------------------------*/
	
	List<Unavailabilities>getAllUnavailabilities();
	Unavailabilities createUnavailabilities();
	Unavailabilities updateUnavailabilities(@PathVariable(name = "id") Integer id, @RequestBody Unavailabilities unavailabilities);
	Unavailabilities deleteUnavailabilities(@PathVariable(name = "id") Integer id);


}

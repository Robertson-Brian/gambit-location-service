	package com.revature.gambit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.gambit.entities.Building;
import com.revature.gambit.entities.Location;
import com.revature.gambit.entities.Room;
import com.revature.gambit.repository.BuildingRepo;
import com.revature.gambit.repository.LocationRepo;
import com.revature.gambit.repository.RoomRepo;

@Service
public class LocationService {

	LocationRepo locationRepo;
	RoomRepo roomRepo;
	BuildingRepo buildingRepo;

	// Constructor
	@Autowired
	public LocationService(LocationRepo locationRepo, BuildingRepo buildingRepo,RoomRepo roomRepo) {
		this.locationRepo = locationRepo;
		this.buildingRepo = buildingRepo;
		this.roomRepo = roomRepo;

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
	public Location findLocationByID(Integer id) {
		Optional<Location> result = Optional.of(locationRepo.findLocationByLocationId(id.longValue()));
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
		return locationRepo.saveAndFlush(location);
	}

	/**
	 * Deactivates the location with the specified LocationID
	 * 
	 * @param id
	 * @return
	 */
	public Location deactivateLocation(Integer locationId) {
		Location deactivating = locationRepo.findLocationByLocationId(locationId.longValue());
		deactivating.setActive(false);
		return locationRepo.saveAndFlush(deactivating);

	}

	/*-----------------------------Building---------------------------*/
	/**
	 * Returns all Buildings from repository.
	 * 
	 * @author Stephen Lovick | 1803-MAR05-USF
	 * @return
	 */
	public List<Building> findAllBuilding() {
		System.out.println(buildingRepo.findAll());
		return buildingRepo.findAll();
	}

	/**
	 * Find all building at a location by LocationId.
	 * 
	 * @author Stephen Lovick | 1803-MAR05-USF
	 * @param id
	 * @return
	 */
	public List<Building> findBuildingByLocationId(Integer id) {
		return buildingRepo.findByLocationId(id.longValue());
	}

	/**
	 * Find a building by BuildingId.
	 * 
	 * @param id
	 * @return
	 */
	public Building findBuildingByBuildingID(Integer id) {
		return buildingRepo.findByBuildingId(id.longValue());
	}

	/**
	 * Saves and flushes changes to a building.
	 * 
	 * @param building
	 * @return
	 */
	public Building saveBuilding(Building building) {
		return buildingRepo.saveAndFlush(building);
	}
	
//*********************ROOMS****************************************	
	
	public List<Room> findAllRoom() {
		return roomRepo.findAll();
	}
	
	public Room findRoom(int id) {
		Optional<Room> result = Optional.of(roomRepo.findRoomByRoomId(id));
		if (result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}
	
	public List<Room> findRoomsByBuilding(Long id) {
		return roomRepo.findAllByBuildingIdOrderByRoomNumber(id);
	}
	
	public Room saveRoom(Room room) {
		return roomRepo.saveAndFlush(room);
	}
	
	public Room updateRoom(Room room) {
		Room check = roomRepo.findRoomByRoomId(room.getRoomId());
		if(check != null) {
			roomRepo.saveAndFlush(room);
			return room;
		}else {
			return check;
		}
	}
	
	

	// public Building deactivateBuilding(Integer id) {
	// Building deactivating = repository.findBuildingByBuildingId(id.longValue());
	// return null;
	// }

}

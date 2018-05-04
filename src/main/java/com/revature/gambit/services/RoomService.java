/**
 * RoomService - Handles the postprocessing of the RoomControllerImpl
 */
package com.revature.gambit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.gambit.entities.Room;
import com.revature.gambit.repository.RoomRepo;

@Service
public class RoomService {

	private RoomRepo roomRepo;

	@Autowired
	public RoomService(RoomRepo roomRepo) {
		this.roomRepo = roomRepo;
	}

	public RoomService() {
	}

	/**
	 * This method utilizes Spring's JPA repository interface to query the database
	 * for all known rooms. NOTE: This returns all rooms even rooms at deactivated
	 * locations.
	 * 
	 * @author Jake Trump | 1803-USF-MAR05
	 * @return Returns a list of ALL rooms in the Database
	 */
	public List<Room> findAllRoom() {
		return roomRepo.findAll();
	}

	/**
	 * This method utilizes Spring's JPA repository interface, to locate the room by
	 * the rooms location id.
	 * 
	 * @author Jake Trump | 1803-USF-MAR05
	 * @param id
	 *            - Long: roomId
	 * @return
	 */
	public Room findRoom(Long id) {
		return roomRepo.findRoomByRoomId(id);
	}

	/**
	 * This method utilizes Spring's JPA repository interface, to locate rooms
	 * associated with a specific building id.
	 * 
	 * @author Jake Trump | 1803-USF-MAR05
	 * @param id
	 * @return
	 */
	public List<Room> findRoomsByBuilding(Long id) {
		return roomRepo.findAllByBuildingIdOrderByRoomNumber(id);
	}

	/**
	 * This method utilizes Spring's JPA repository to persist the room to the
	 * database.
	 * 
	 * @author Jake Trump | 1803-USF-MAR05
	 * @param room
	 *            - Room object to be added to the database with a null value of
	 *            roomId.
	 * @return On success the room that was passed with a roomId of null will be
	 *         returned with a non null value. On failure the room will be returned
	 *         with a null value for roomId
	 */
	public Room saveRoom(Room room) {
		if (room.getRoomId() != null) {
			room.setRoomId(null);
			return room;
		} else {
			return roomRepo.saveAndFlush(room);
		}
	}

	/**
	 * This method utilizes Spring's JPA repository to update an existing room
	 * record in the database.
	 * 
	 * @param room
	 * @return On success the room the room will be returned with the changes made
	 *         to the document. On failure a null room object will be returned.
	 */
	public Room updateRoom(Room room) {
		Room check = roomRepo.findRoomByRoomId(room.getRoomId());
		if (check != null) {
			return roomRepo.saveAndFlush(room);
		} else {
			return check;
		}
	}

}

package com.revature.gambit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.gambit.entities.Room;
import com.revature.gambit.services.RoomService;

@CrossOrigin
@RestController
@RequestMapping("room")
public class RoomControllerImpl implements RoomController{
	
	RoomService roomService;
	
	@Autowired
	public RoomControllerImpl(RoomService roomService) {
		this.roomService = roomService;
	}
	
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
		return roomService.findAllRoom();
	}
	
	@Override
	@GetMapping("/building/{id}/room")
	public List<Room> getRoomsByBuilding(@PathVariable(name="id") Long id) {
		return roomService.findRoomsByBuilding(id);
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
	public Room getRoomByID(@PathVariable(name = "id") Long id) {
		return roomService.findRoom(id);
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
	public Room createRoom(@RequestBody Room room) {
		return roomService.saveRoom(room);
	}

	@Override
	@PutMapping("/room")
	public Room updateRoom(@RequestBody Room room) {
		return roomService.updateRoom(room);
	}

//	@Override
//	@DeleteMapping("/room/{id}")
//	public Room deleteRoomByID(Long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}


}

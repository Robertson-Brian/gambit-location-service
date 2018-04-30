package com.revature.gambit.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.revature.gambit.entities.Room;

public interface RoomController {
	List<Room> getAllRooms();

//	List<Room> getRoomsByLocation(@PathVariable(name = "id") Long id);

	List<Room> getRoomsByBuilding(@PathVariable(name = "id") Long id);

	Room getRoomByID(@PathVariable(name = "id") Long id);

	Room createRoom(@RequestBody Room room);

	Room updateRoom(@RequestBody Room room);

	//	Room deleteRoomByID(@PathVariable(name = "id") Long id);
	//Room deleteRoomByID(@PathVariable(name = "id") Long id);

}

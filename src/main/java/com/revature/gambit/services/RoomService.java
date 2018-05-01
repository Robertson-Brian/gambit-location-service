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

	public List<Room> findAllRoom() {
		return roomRepo.findAll();
	}

	public Room findRoom(Long id) {
		 return roomRepo.findRoomByRoomId(id);
	}

	public List<Room> findRoomsByBuilding(Long id) {
		return roomRepo.findAllByBuildingIdOrderByRoomNumber(id);
	}

	public Room saveRoom(Room room) {
		return roomRepo.saveAndFlush(room);
	}

	public Room updateRoom(Room room) {
		Room check = roomRepo.findRoomByRoomId(room.getRoomId());
		if (check != null) {
			roomRepo.saveAndFlush(room);
			return room;
		} else {
			return check;
		}
	}

}

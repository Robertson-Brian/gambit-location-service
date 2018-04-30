package com.revature.gambit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.gambit.entities.Room;
import com.revature.gambit.repository.RoomRepo;

@Service
public class RoomService {

	private RoomRepo roomRepo;

	public RoomService(RoomRepo roomRepo) {
		this.roomRepo = roomRepo;
	}

	public RoomService() {
	}

	public List<Room> findAllRoom() {
		return roomRepo.findAll();
	}

	public Room findRoom(Long id) {
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
		if (check != null) {
			roomRepo.saveAndFlush(room);
			return room;
		} else {
			return check;
		}
	}

}

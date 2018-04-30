package com.revature.gambit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.gambit.entities.Room;

@Repository
public interface RoomRepo extends JpaRepository<Room, Integer>{
	
	Room findRoomByRoomId(Long id);
	
	List<Room> findAllByBuildingIdOrderByRoomNumber(Long id);


}

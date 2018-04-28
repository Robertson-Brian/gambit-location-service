package com.revature.gambit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.gambit.entities.Location;

public interface LocationRepo extends JpaRepository<Location, Long>{

	Location findLocationByLocationId(Long id);

}

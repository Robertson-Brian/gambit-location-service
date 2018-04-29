package com.revature.gambit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.gambit.entities.Location;

@Repository
public interface LocationRepo extends JpaRepository<Location, Long>{

	Location findLocationByLocationId(Long id);

}

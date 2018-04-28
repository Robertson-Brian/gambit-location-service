package com.revature.gambit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.gambit.entities.Building;
import com.revature.gambit.entities.Location;

public interface LocationRepo extends JpaRepository<Location, Long>{

	Location findLocationByLocationId(Long id);

	List<Building> findAllBuilding();

	List<Building> findAllBuildingByLocationId(long longValue);

	Building findBuildingByBuildingId(long longValue);

	Building saveAndFlush(Building building);


}

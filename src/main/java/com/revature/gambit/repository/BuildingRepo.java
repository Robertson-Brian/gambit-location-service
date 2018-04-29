package com.revature.gambit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.gambit.entities.Building;

@Repository
public interface BuildingRepo extends JpaRepository<Building, Long>{

	List<Building> findByLocationId(Long longValue);

	Building findByBuildingId(Long longValue);

}

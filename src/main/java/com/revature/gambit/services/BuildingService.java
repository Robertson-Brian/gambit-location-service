package com.revature.gambit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.gambit.entities.Building;
import com.revature.gambit.repository.BuildingRepo;


@Service
public class BuildingService {

	private BuildingRepo buildingRepo;

	@Autowired
	public BuildingService(BuildingRepo buildingRepo) {
		this.buildingRepo = buildingRepo;
	}

	public BuildingService() {

	}

	/**
	 * Returns all Buildings from repository.
	 * 
	 * @author Stephen Lovick | 1803-MAR05-USF
	 * @return
	 */
	public List<Building> findAllBuilding() {
		return buildingRepo.findAll();
	}

	/**
	 * Find all building at a location by LocationId.
	 * 
	 * @author Stephen Lovick | 1803-MAR05-USF
	 * @param id
	 * @return
	 */
	public List<Building> findBuildingByLocationId(Long id) {
		return buildingRepo.findByLocationId(id.longValue());
	}

	/**
	 * Find a building by BuildingId.
	 * 
	 * @param id
	 * @return
	 */
	public Building findBuildingByBuildingID(Long id) {
		return buildingRepo.findByBuildingId(id.longValue());
	}

	/**
	 * Saves and flushes changes to a building.
	 * 
	 * @param building
	 * @return
	 */
	public Building saveBuilding(Building building) {
		return buildingRepo.saveAndFlush(building);
	}

}

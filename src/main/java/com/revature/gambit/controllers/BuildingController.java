package com.revature.gambit.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.revature.gambit.entities.Building;

public interface BuildingController {

	List<Building> getAllBuildings();

	List<Building> getAllBuildingsFromLocation(@PathVariable(name = "id") Long id);

	Building getBuildingById(@PathVariable(name = "id") Long id);

	Building createBuilding(@RequestBody Building building);

	Building updateBuilding(@PathVariable(name = "id") Long id, @RequestBody Building Building);

	//Building deleteBuildingByID(@PathVariable(name = "id") Long id);

}

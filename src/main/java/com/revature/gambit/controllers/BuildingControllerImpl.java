package com.revature.gambit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.gambit.entities.Building;
import com.revature.gambit.services.BuildingService;

@CrossOrigin
@RestController
@RequestMapping("building")
public class BuildingControllerImpl implements BuildingController {
	
	private BuildingService buildingService;
	
	@Autowired
	public  BuildingControllerImpl(BuildingService buildingService) {
		this.buildingService = buildingService;
	}
	
	public BuildingControllerImpl() { }
	
	/**
	 * HTTP GET getAllBuildings - Handles request to Location Service API to get all
	 * buildings
	 * 
	 * @author Stephen Lovick | 1803-USF-MAR05
	 * @author Jake Trump | 1803-USF-MAR05
	 * 
	 * @return On success a list of buildings
	 */
	@Override
	@GetMapping("/")
	public List<Building> getAllBuildings() {
		return buildingService.findAllBuilding();
	}

	/**
	 * HTTP GET getLocationById - Handles request to Location Service API retrieve
	 * all buildings from an individual location by ID.
	 * 
	 * @author Stephen Lovick | 1803-USF-MAR05
	 * @author Jake Trump | 1803-USF-MAR05
	 * @param id
	 * @return On success it will return the queried location. On Failure it returns
	 *         a location object with an ID of "-1" and all other fields with the
	 *         value of "Do Not Exist"
	 */
	@Override
	@GetMapping("/location/{id}")
	public List<Building> getAllBuildingsFromLocation(@PathVariable(name = "id") Long id) {
		return buildingService.findBuildingByLocationId(id);
	}

	/**
	 * HTTP POST - buildingById - Handles request to Location Service API to
	 * retrieve a building by id.
	 * 
	 * @author Stephen Lovick | 1803-USF-MAR05
	 * @author Jake Trump | 1803-USF-MAR05
	 * @param id
	 * @return On success will return the queried building
	 */
	@Override
	@GetMapping("/{id}")
	public Building getBuildingById(@PathVariable(name = "id") Long id) {
		return buildingService.findBuildingByBuildingID(id);
	}

	/**
	 * HTTP POST - createBuilding - Handles request to Location Service API to
	 * create a new building
	 * 
	 * @author Stephen Lovick | 1803-USF-MAR05
	 * @author Jake Trump | 1803-USF-MAR05
	 * @param id
	 */
	@Override
	@PostMapping("/")
	public Building createBuilding(@RequestBody Building building) {
		return buildingService.saveBuilding(building);
	}

	/**
	 * HTTP PUT - updateBuilding - Handle request to Location Service API to update
	 * an existing building.
	 * 
	 * @author Stephen Lovick | 1803-USF-MAR05
	 * @author Jake Trump | 1803-USF-MAR05
	 * @param id
	 * 
	 */
	@Override
	@PutMapping("/{id}")
	public Building updateBuilding(@PathVariable(name = "id")Long id, @RequestBody Building building) {
		return buildingService.saveBuilding(building);
	}

	/**
	 * HTTP DELETE - deleteBuildingByID - Handles request to Location Service API to
	 * update an existing building.
	 * @author Stephen Lovick | 1803-USF-MAR05
	 * @author Jake Trump | 1803-USF-MAR05
	 * @param id
	 */
//	@Override
//	@DeleteMapping("building/{id}")
//	public Building deleteBuildingByID(@PathVariable(name = "id") Long id) {
//		return buildingService.deactivateBuilding(id);
//	}



}

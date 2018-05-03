/**
 * Building Service - handles the postprocessing of BuildingControllerImpl.
 */
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
	 * This method utilizes Spring's JPA repository interface to query the database
	 * for all known buildings. NOTE: This returns all buildings even rooms at deactivated
	 * locations.
	 * 
	 * @author Stephen Lovick | 1803-USF-MAR05
	 * @return Returns a list of ALL rooms in the Database
	 */
	public List<Building> findAllBuilding() {
		return buildingRepo.findAll();
	}

	/**
	 * This method utilizes Spring's JPA repository interface, to locate buildings
	 * associated with a specific location id.
	 * 
	 * @author Stephen Lovick | 1803-USF-MAR05
	 * @param id
	 *            - Long: locationId
	 * @return
	 */
	public List<Building> findBuildingByLocationId(Long id) {
		return buildingRepo.findByLocationId(id.longValue());
	}

	/**
	 * This method utilizes Spring's JPA repository interface, to locate the
	 * building by the buildingId
	 * 
	 * @author Stephen Lovick | 1803-USF-MAR05
	 * @param id
	 *            - Long: buildingId
	 * @return
	 */
	public Building findBuildingByBuildingID(Long id) {
		return buildingRepo.findByBuildingId(id.longValue());
	}

	/**
	 * This method utilizes Spring's JPA repository to persist the building to the
	 * database.
	 * 
	 * @author Stephen Lovick | 1803-USF-MAR05
	 * @param building
	 *            - building object to be added to the database with a buildingId of
	 *            null.
	 * @return On success the room that was passed with a buildingId of null will be
	 *         returned with a non null value. On failure the room will be returned
	 *         with a null value for buildingId.
	 */
	public Building saveBuilding(Building building) {
		if (building.getBuildingId() != null) {
			building.setBuildingId(null);
			return building;
		} else {
			return buildingRepo.saveAndFlush(building);
		}
	}

	/**
	 * This method utilizes Spring's JPA repository to update an existing room
	 * record in the database.
	 * @author Stephen Lovick | 1803-USF-MAR05
	 * @param building
	 * @return On success the building the room will be returned with the changes
	 *         made to the document. On failure a null building object will be
	 *         returned.
	 */
	public Building updateBuilding(Building building) {
		Building check = findBuildingByBuildingID(building.getBuildingId());
		if (check != null) {
			return buildingRepo.saveAndFlush(building);
		} else {
			return check;
		}
	}

	// public Building deactivateBuilding(Long id) {
	// Building deactivate = buildingRepo.getOne(id);
	// }

}

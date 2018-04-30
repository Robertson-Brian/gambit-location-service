package com.revature.serviceTest;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.revature.gambit.entities.Location;
import com.revature.gambit.repository.BuildingRepo;
import com.revature.gambit.repository.LocationRepo;
import com.revature.gambit.repository.RoomRepo;
import com.revature.gambit.repository.UnavailRepository;
import com.revature.gambit.services.LocationService;

public class LocationTest {
	private LocationService serviceTest;
	private LocationRepo locationRepo;
	private BuildingRepo buildingRepo;
	private RoomRepo roomRepo;
	private UnavailRepository unavailRepo;
	private Location location;
	
	@Before
	public void setUp() throws Exception {
		this.serviceTest = new LocationService(locationRepo, buildingRepo, roomRepo, unavailRepo);
		this.location = new Location(2L,"6789 Test Drive", "Tampa", "Florida", "33410", "USF",true);
	}

	@Test
	public void testFindAllLocation() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testFindLocationByID() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSaveLocation() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testDeactivateLocation() {
		fail("Not yet implemented"); // TODO
	}

}

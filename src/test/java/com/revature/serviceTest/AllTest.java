package com.revature.serviceTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({
	LocationTest.class,
	BuildingTest.class,
	RoomTest.class,
	UnavailabilitiesTest.class
})
public class AllTest {


}

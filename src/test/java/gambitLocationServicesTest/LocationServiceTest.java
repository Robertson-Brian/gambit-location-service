package gambitLocationServicesTest;


/**
 * 
 */
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.gambit.entities.Location;
import com.revature.gambit.repository.LocationRepo;
import com.revature.gambit.services.LocationService;

/**
 * @author Lovick
 *
 */
public class LocationServiceTest {

	private static LocationService locationServiceTest;
	private static LocationRepo locationRepo;
	private List<Location> locationList;
	private Location loc1;
	private Location loc2;
	private Location loc3;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		locationRepo = spy(LocationRepo.class);
		locationServiceTest = spy(new LocationService(locationRepo));
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		locationServiceTest = null;
		locationRepo = null;		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		loc1 = new Location(1L, "1 Test Street", "Corpus Christ", "Texas", "78412", "TAMUCC", true);
		loc2 = new Location(2L, "2 Test Street", "San Antonio", "Texas", "78250", "TAMUCC", true);
		loc3 = new Location(3L, "3 Test Street", "Dallas", "Texas", "78003", "TAMUCC", true);
		locationList = new ArrayList<Location>();
		locationList.add(loc1);
		locationList.add(loc2);
		locationList.add(loc3);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		loc1 = null;
		loc2 = null;
		loc3 = null;
		locationList = null;
	}

	/**
	 * Test method for
	 * {@link com.revature.gambit.services.LocationService#findAllLocation()}.
	 */
	@Test
	public void testFindAllLocation() {
		when(locationRepo.findAll()).thenReturn(locationList);
		assertNotNull(locationServiceTest.findAllLocation());
	}

	/**
	 * Test method for
	 * {@link com.revature.gambit.services.LocationService#findLocationByID(java.lang.Long)}.
	 */
	@Test
	public void testFindLocationByID() {
		when(locationRepo.findLocationByLocationId(1L)).thenReturn(loc1);
		assertSame(locationServiceTest.findLocationByID(1L),loc1);
	}

	/**
	 * Test method for
	 * {@link com.revature.gambit.services.LocationService#saveLocation(com.revature.gambit.entities.Location)}.
	 */
	@Test
	public void testSaveLocationWithNullID() {
		Location newLocation = new Location(null, "4 test street", "Paris", "Texas", "75994", "University of West Texas", null);
		when(locationRepo.saveAndFlush(newLocation)).thenReturn(newLocation);
		assertTrue(locationServiceTest.saveLocation(newLocation).getActive());
	}
	
	@Test
	public void testSaveLocationWithoutNullID() {
		Location test = locationServiceTest.saveLocation(loc1);
		assertNull(test.getLocationId());
		assertNull(test.getActive());
	}

	/**
	 * Test method for
	 * {@link com.revature.gambit.services.LocationService#deactivateLocation(java.lang.Long)}.
	 */
	@Test
	public void testDeactivateLocation() {
		Location newLocation = new Location(4L, "4 test street", "Paris", "Texas", "75994", "University of West Texas", true);
		when(locationRepo.findLocationByLocationId(4L)).thenReturn(newLocation);
		when(locationRepo.saveAndFlush(newLocation)).thenReturn(newLocation);
		assertFalse(locationServiceTest.deactivateLocation(4L).getActive());
	}

	/**
	 * Test method for
	 * {@link com.revature.gambit.services.LocationService#updateLocation(com.revature.gambit.entities.Location)}.
	 */
	@Test
	public void testUpdateLocation() {
		when(locationRepo.findLocationByLocationId(loc1.getLocationId())).thenReturn(loc1);
		when(locationRepo.saveAndFlush(loc1)).thenReturn(loc1);
		assertSame(loc1,locationServiceTest.updateLocation(loc1));
	}
	
	@Test
	public void testLocationNotFoundLocationUpdate() {
		when(locationRepo.findLocationByLocationId(null)).thenReturn(null);
		loc3.setLocationId(null);
		assertNull(locationServiceTest.updateLocation(loc3));
		
	}

}

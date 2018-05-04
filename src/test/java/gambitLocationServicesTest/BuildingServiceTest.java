/**
 * 
 */
package gambitLocationServicesTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.revature.gambit.entities.Building;
import com.revature.gambit.repository.BuildingRepo;
import com.revature.gambit.services.BuildingService;

/**
 * @author Lovick
 *
 */
public class BuildingServiceTest {

	private BuildingService buildingServiceTest;
	private BuildingRepo buildingRepo;
	private static List<Building> buildingListTest;
	private static Building build1;
	private static Building build2;
	private static Building build3;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		build1 = new Building(1L, "1 Test Street", "bldg A1", 1L);
		build2 = new Building(2L, "2 Test Street", "bldg A2", 1L);
		build3 = new Building(3L, "3 Test Street", "bldg A3", 1L);
		buildingListTest = new ArrayList<Building>();
		buildingListTest.add(build1);
		buildingListTest.add(build2);
		buildingListTest.add(build3);
	}

	@Before
	public void setUp() throws Exception {
		buildingRepo = mock(BuildingRepo.class);
		buildingServiceTest = spy(new BuildingService(buildingRepo));
	}

	/**
	 * Test method for
	 * {@link com.revature.gambit.services.BuildingService#findAllBuilding()}.
	 */
	@Test
	public void testFindAllBuilding() {
		when(buildingServiceTest.findAllBuilding()).thenReturn(buildingListTest);
		assertNotNull(buildingServiceTest.findAllBuilding());
	}

	/**
	 * Test method for
	 * {@link com.revature.gambit.services.BuildingService#saveBuilding(com.revature.gambit.entities.Building)}.
	 */
	@Test
	public void testSaveBuildingWithNullBuildingId() {
		Building newBuilding = new Building(null, "4455 Test Avenue", "65B", 1L);
		Integer listSize = buildingListTest.size();
		when(buildingServiceTest.saveBuilding(newBuilding)).thenAnswer(new Answer<Building>() {
			public Building answer(InvocationOnMock invocation) throws Throwable {
				Building returnBuilding = (Building) invocation.getArgument(0);
				returnBuilding.setBuildingId(listSize.longValue() + 1);
				buildingListTest.add(returnBuilding);
				return (Building) invocation.getArgument(0);
			}
		});
		assertNotNull(buildingServiceTest.saveBuilding(newBuilding).getBuildingId());
	}

	@Test
	public void testSaveBuildingWithNonNullBuildingId() {
		Building newBuilding = new Building(1L, "4455 Test Avenue", "65B", 1L);
		when(buildingServiceTest.saveBuilding(newBuilding)).thenReturn(newBuilding);
		assertNull(buildingServiceTest.saveBuilding(newBuilding).getBuildingId());

	}

//	/**
//	 * Test method for {@link com.revature.gambit.services.BuildingService#updateBuilding(com.revature.gambit.entities.Building)}.
//	 */
//	@Test
//	public void testUpdateBuildingWithBuildingId() {
//		Integer testIndex = BuildingServiceTest.buildingListTest.size();
//		Building test = buildingListTest.get(testIndex-1);
//		test.setStreetAddress("LZZZZZZZZZZZZZZZZZZZZZz");
//		when(buildingServiceTest.updateBuilding(test)).thenAnswer(new Answer<Building>() {
//			public Building answer(InvocationOnMock invocation) {
//				Building inBldg = (Building)invocation.getArgument(0);
//				for (Building building : buildingListTest) {
//					if(building.getBuildingId() == inBldg.getBuildingId()) {
//						building = inBldg;
//						return building;
//					}
//				}
//				return null;
//			}
//		});
//		assertNotNull(buildingServiceTest.updateBuilding(test));
//		
//	}

}

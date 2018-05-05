/**
 * 
 */
package gambitLocationServicesTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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
	private static List<Building> buildingList;
	private static Building build1;
	private static Building build2;
	private static Building build3;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		build1 = new Building(1L, "1 Test Street", "bldg A1", 1L);
		build2 = new Building(2L, "2 Test Street", "bldg A2", 1L);
		build3 = new Building(3L, "3 Test Street", "bldg A3", 1L);
		buildingList = new ArrayList<Building>();
		buildingList.add(build1);
		buildingList.add(build2);
		buildingList.add(build3);
	}

	@Before
	public void setUp() throws Exception {
		buildingRepo = spy(BuildingRepo.class);
		buildingServiceTest = spy(new BuildingService(buildingRepo));
	}

	/**
	 * Test method for
	 * {@link com.revature.gambit.services.BuildingService#findAllBuilding()}.
	 */
	@Test
	public void testFindAllBuilding() {
		when(buildingServiceTest.findAllBuilding()).thenReturn(buildingList);
		assertNotNull(buildingServiceTest.findAllBuilding());
	}

	/**
	 * Test method for
	 * {@link com.revature.gambit.services.BuildingService#saveBuilding(com.revature.gambit.entities.Building)}.
	 */
	@Test
	public void testSaveBuildingWithNullBuildingId() {
		Building newBuilding = new Building(null, "4455 Test Avenue", "65B", 1L);
		Integer listSize = buildingList.size();
		when(buildingServiceTest.saveBuilding(newBuilding)).thenAnswer(new Answer<Building>() {
			public Building answer(InvocationOnMock invocation) throws Throwable {
				Building returnBuilding = (Building) invocation.getArgument(0);
				returnBuilding.setBuildingId(listSize.longValue() + 1);
				buildingList.add(returnBuilding);
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

	/**
	 * Test method for
	 * {@link com.revature.gambit.services.BuildingService#updateBuilding(com.revature.gambit.entities.Building)}.
	 */
	@Test
	public void testUpdateBuildingWithBuildingId() {
		Building test = new Building(1L, "4455 Test Avenue", "65B", 1L);
		when(buildingServiceTest.findBuildingByBuildingID(test.getBuildingId())).thenReturn(test);
		when(buildingRepo.saveAndFlush(test)).thenReturn(test);
		when(buildingServiceTest.updateBuilding(test)).thenReturn(test);
		assertNotNull(buildingServiceTest.updateBuilding(test));
	}

	@Test
	public void testUpdateBuildingWithoutBuildingId() {
		Building newBuilding = new Building(null, "4455 Test Avenue", "65B", 1L);
		when(buildingServiceTest.findBuildingByBuildingID(newBuilding.getBuildingId())).thenReturn(null);
		when(buildingServiceTest.updateBuilding(newBuilding)).thenReturn(newBuilding);
		System.out.println(buildingServiceTest.updateBuilding(newBuilding));
		assertNull(buildingServiceTest.updateBuilding(newBuilding));
	}
	
	@Test
	public void testFindBuildingByLocation() {
		Long testId =1L;
		when(buildingRepo.findByLocationId(testId)).thenReturn(buildingList);
		assertNotNull(buildingServiceTest.findBuildingByLocationId(1L));
		
	}

}

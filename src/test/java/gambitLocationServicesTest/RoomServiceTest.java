/**
 * 
 */
package gambitLocationServicesTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.gambit.entities.Room;
import com.revature.gambit.repository.RoomRepo;
import com.revature.gambit.services.RoomService;

/**
 * @author Lovick
 *
 */
public class RoomServiceTest {

	private static RoomRepo roomRepo;
	private static RoomService roomService;
	private List<Room> roomList;
	private Room room1;
	private Room room2;
	private Room room3;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		roomRepo = mock(RoomRepo.class);
		roomService = spy(new RoomService(roomRepo));
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		roomService = null;
		roomRepo = null;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		room1 = new Room(1L, "32B", 1L, 40);
		room2 = new Room(2L, "32B", 2L, 20);
		room3 = new Room(3L, "32B", 3L, 40);
		roomList = new ArrayList<Room>();
		roomList.add(room1);
		roomList.add(room2);
		roomList.add(room3);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		room1 = null;
		room2 = null;
		room3 = null;
		roomList = null;
	}

	/**
	 * Test method for
	 * {@link com.revature.gambit.services.RoomService#findAllRoom()}.
	 */
	@Test
	public void testFindAllRoom() {
		when(roomRepo.findAll()).thenReturn(roomList);
		assertNotNull(roomService.findAllRoom());
	}

	/**
	 * Test method for
	 * {@link com.revature.gambit.services.RoomService#findRoom(java.lang.Long)}.
	 */
	@Test
	public void testFindRoom() {
		when(roomRepo.findRoomByRoomId(room1.getRoomId())).thenReturn(room1);
		assertSame(room1, roomService.findRoom(room1.getRoomId()));
	}

	/**
	 * Test method for
	 * {@link com.revature.gambit.services.RoomService#findRoomsByBuilding(java.lang.Long)}.
	 */
	@Test
	public void testFindRoomsByBuilding() {
		when(roomRepo.findAllByBuildingIdOrderByRoomNumber(1L)).thenReturn(roomList);
		assertNotNull(roomService.findRoomsByBuilding(1L));
	}

	/**
	 * Test method for
	 * {@link com.revature.gambit.services.RoomService#saveRoom(com.revature.gambit.entities.Room)}.
	 */
	@Test
	public void testSaveRoomWithNullRoomId() {
		room1.setRoomId(null);
		when(roomRepo.saveAndFlush(room1)).thenReturn(room2);
		assertNotNull(roomService.saveRoom(room1).getRoomId());
		
	}
	@Test
	public void testSaveRoomWithRoomId() {
		assertNull(roomService.saveRoom(room1).getRoomId());
	}

	/**
	 * Test method for
	 * {@link com.revature.gambit.services.RoomService#updateRoom(com.revature.gambit.entities.Room)}.
	 */
	@Test
	public void testUpdateRoomWithExistingRoom() {
		when(roomRepo.findRoomByRoomId(1L)).thenReturn(room1);
		when(roomRepo.saveAndFlush(room1)).thenReturn(room1);
		assertNotNull(roomService.updateRoom(room1));
	}
	@Test
	public void testUpdateRoomWithNonExistinRoom() {
		when(roomRepo.findRoomByRoomId(1L)).thenReturn(null);
		assertNull(roomService.updateRoom(room1));
	}

}

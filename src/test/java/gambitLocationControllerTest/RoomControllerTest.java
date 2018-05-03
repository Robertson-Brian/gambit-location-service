package gambitLocationControllerTest;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.revature.gambit.entities.Room;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class RoomControllerTest {
	
	private Room testRoom;
	private Map<String,String> header;

	@Before
	public void setUp() throws Exception{
		RestAssured.baseURI = "http://localhost:8090";
		RestAssured.basePath = "/rooms";
		this.testRoom = new Room(null,"111",1L,25);
		this.header = new HashMap<String,String>();
		this.header.put("Content-type", "application/json");

	}

	@Test
	public void getAllRoomsTest() {
		 RestAssured.get("/").then().assertThat().statusCode(200).and().log().all(true);
	}
	
	@Test
	public void getRoomThatExistByIdTest() {
		Integer id = 1;
		int test = given().get("/"+id.toString()).andReturn().asString().length();
		assertNotEquals(test, 0);
	}
	
	@Test
	public void getRoomThatDoesNotExistByIdTest() {
		Integer id = 0;
		int test = given().get("/" + id.toString()).andReturn().asString().length();
		assertEquals(test, 0);
	}
	
	@Test
	public void createRoomTest() throws JSONException {
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.headers(this.header);
		httpRequest.body(testRoom);
		Response response = httpRequest.post("/");
		Assert.assertEquals(200, response.statusCode());
	}
	
	@Test
	public void updateRoomTest() {
		testRoom.setRoomId(1L);
		testRoom.setRoomNumber("testing");
		Room responseRoom = given()
				.headers(this.header)
				.body(testRoom)
				.put("/"+testRoom.getRoomId().toString())
				.andReturn().as(Room.class);
		Assert.assertEquals(responseRoom,testRoom);
	}
	

}

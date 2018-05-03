package gambitLocationControllerTest;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.revature.gambit.entities.Building;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BuildingControllerTest {
	
	private Building testBuilding;
	private Map<String,String> header;

	@Before
	public void setUp() throws Exception {
		RestAssured.baseURI = "http://localhost:8090/buildings/";
		testBuilding = new Building(null, "98 Cherry Coke Lane", "98", 1L);
		this.header = new HashMap<String,String>();
		this.header.put("Content-type", "application/json");
	}

	@Test
	public void getAllBuildingsTest() {
		List<Building> testAll = Arrays.asList(given().get().body().as(Building[].class));
		assertNotEquals(0, testAll.size());
		
	}
	
	@Test
	public void getBuildingThatExistByIdTest() {
		Integer id = 1;
		int test = given().get(id.toString()).andReturn().asString().length();
		assertNotEquals(0,test);
	}
	
	@Test
	public void getBuildingThatDoesNotExist() {
		Integer id = 0;
		int test = given().get(id.toString()).andReturn().asString().length();
		Assert.assertEquals(0, test);
	}

	@Test
	public void createBuildingTest() {
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.headers(this.header);
		httpRequest.body(testBuilding);
		Response response = httpRequest.post();
		Assert.assertEquals(200, response.statusCode());
	}
	
	@Test
	public void updateBuildingTest() {
		testBuilding.setBuildingId(1L);
		testBuilding.setStreetAddress("Testing");
		Building responseBuilding = given()
				.headers(this.header)
				.body(testBuilding)
				.put(testBuilding.getBuildingId().toString())
				.andReturn()
				.as(Building.class);
		Assert.assertEquals(responseBuilding, testBuilding);
	}
}

package gambitLocationControllerTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.revature.gambit.entities.Location;

import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LocationControllerTest {

	private Location testLocation;
	private Map<String,String> header;

	@Before
	public void setUp() throws Exception {
		RestAssured.baseURI = "http://localhost:8090/locations";
		this.testLocation = new Location(null, "8080 Apache Drive", "Seattle", "Washington", "78855", "South", true);
		this.header = new HashMap<String,String>();
		this.header.put("Content-type", "application/json");

	}

	 @Test
	 public void getAllLocationTest() {
	 RestAssured.get("/").then().assertThat().statusCode(200).and().log().all(true);
	 }

	@Test
	public void getLocationThatExistByIdTest() {
		Integer id = 1;
		int test = given().get("/"+id.toString()).andReturn().asString().length();
		assertNotEquals(test, 0);
	}

	@Test
	public void getLocationThatDoesNotExistByIdTest() {
		Integer id = 0;
		int test = given().get("/" + id.toString()).andReturn().asString().length();
		assertEquals(test, 0);
	}

	@Test
	public void createLocationTest() {
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.header("Content-type", "application/json");
		httpRequest.body(testLocation);
		Response response = httpRequest.post("/");
		Assert.assertEquals(200, response.statusCode());
	}
	
	@Test
	public void updateLocationTest() {
		testLocation.setLocationId(1L);
		testLocation.setCompany("Testing");
		Location responseLocation = given()
				.headers(this.header)
				.body(testLocation)
				.put("/"+testLocation.getLocationId().toString())
				.andReturn().as(Location.class);
		Assert.assertEquals(responseLocation,testLocation);
	}
	
	@Test
	public void deleteLocationTest() {
		List<Location> counter = Arrays.asList(given().headers(this.header).get("/").andReturn().as(Location[].class));
		Integer removeItem = counter.size();
		given().headers(this.header).delete("/"+removeItem.toString()).then().assertThat().body("active", new ResponseAwareMatcher<Response>() {
			@Override
			public Matcher<Boolean> matcher(Response response) {return equalTo(Boolean.FALSE);}
		});
	}

}

package gambitLocationControllerTest;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertNotEquals;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.revature.gambit.entities.Unavailabilities;

import io.restassured.RestAssured;

public class UnavailControllerTest {

    private Unavailabilities testUnavailibility;
    private Map<String, String> header;
    private Timestamp startDate = null;
    private Timestamp endDate = null;

    @Before
    public void setUp() throws Exception {
        RestAssured.baseURI = "http://localhost:8090/unavailabilities";
        this.header = new HashMap<String, String>();
        this.header.put("Content-type", "application/json");
        this.startDate = Timestamp.valueOf("2020-10-02 12:00:00");
        this.endDate = Timestamp.valueOf("2020-12-02 12:00:00");
        this.testUnavailibility = new Unavailabilities(null, startDate, endDate, null, "Testing", 1L);
    }

    @Test
    public void getAllUnavailibilitiesTest() {
        given().get("/").then().assertThat().statusCode(200).and().log().all(true);
    }

    @Test
    public void createUnavailibilitiesTest() {
        Long testId = given().headers(this.header)
        		.body(testUnavailibility).post("/")
        		.andReturn().as(Unavailabilities.class)
                .getUnavailabilityId();
        assertNotEquals(null, testId);

    }

}
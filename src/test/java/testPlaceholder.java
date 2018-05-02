import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class testPlaceholder {
	
	@Test
	public void givenURL_Verify200_On_Success() {
		get("http://localhost:8080/locations/").then().statusCode(200);
	}
}

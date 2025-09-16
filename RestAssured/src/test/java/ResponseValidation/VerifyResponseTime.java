package ResponseValidation;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class VerifyResponseTime {
	
	@Test
	public void verifyResponseTime() {
		Response resp = given()
		                 .get("http://49.249.28.218:8091/projects");
		
					long timeTaken = resp.time();
					System.out.println(timeTaken);
					
					resp.then().assertThat().time(Matchers.lessThan(900L));
					
					resp.then().assertThat().time(Matchers.greaterThan(300L));
					
					resp.then().assertThat().time(Matchers.both(Matchers.lessThan(900L)).and(Matchers.greaterThan(300L)));
					
					
					
					
					
					
					
}
}
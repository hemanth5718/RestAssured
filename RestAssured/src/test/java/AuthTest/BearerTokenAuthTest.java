package AuthTest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class BearerTokenAuthTest {

	@Test
	public void sampleTest() {
		given()
		.auth().oauth2("token")
		.log().all()
		.when()
		.get("http://49.249.29.5:8091/login")
		.then()
		.log().all();
	}
}

package AuthTest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class Auth2_0_Test {

	@Test
	public void sampleTest() {
		given()
		.formParam("client_id", "")
		.formParam("client_secret", "")
		.formParam("grant_type", "")
		.when()
		.post("url")
		.then()
		.log().all();
	}
}

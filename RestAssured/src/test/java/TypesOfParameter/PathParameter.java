package TypesOfParameter;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class PathParameter {

	@Test
	public void samepleTest(){
		given()
		.pathParam("projectId", "NH_PROJ_067")
		.when()
		.get("http://49.249.28.218:8091/project/{projectId}")
		.then()
		.log().all();
	}
}

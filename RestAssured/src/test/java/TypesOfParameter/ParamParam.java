package TypesOfParameter;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class ParamParam {
	
	@Test
	public void samepleTest(){
		given()
		.param("teamSize", 0)
		.when()
		.get("http://49.249.28.218:8091/project")
		.then()
		.log().all();
	}

}

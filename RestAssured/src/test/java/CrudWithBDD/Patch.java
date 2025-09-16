package CrudWithBDD;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Patch {
	
	@Test
	public void patchTest() {
		
		JSONObject jsonObj = new JSONObject();
		
		
		jsonObj.put("projectName", "samsung_13");
		
		given()
		.contentType(ContentType.JSON)
		.body(jsonObj.toJSONString())
		.when()
		.patch("http://49.249.28.218:8091/project/NH_PROJ_036")
		.then()
		.assertThat().statusCode(200)
		.log().all();
		
	}

}

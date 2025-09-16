package CrudWithBDD;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Put {
	
	@Test
	public void PutTest() {
		
		JSONObject jsonObj = new JSONObject();
		
		jsonObj.put("createdBy", "hemanth123");
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize", 0);
		jsonObj.put("projectName", "samsung_123");
		
		given()
		.contentType(ContentType.JSON)
		.body(jsonObj.toJSONString())
		.when()
		.put("http://49.249.28.218:8091/project/NH_PROJ_036")
		.then()
		.assertThat().statusCode(200)
		.log().all();
		
	}

}

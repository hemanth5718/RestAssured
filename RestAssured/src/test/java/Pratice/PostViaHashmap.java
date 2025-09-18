package Pratice;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostViaHashmap {
	
	@Test
	public void postViaHashmap() {
		
		HashMap<String, Object> map = new HashMap();
		map.put("createdBy", "hemanth");
		map.put("status", "Created");
		map.put("teamSize", 0);
		map.put("projectName", "samsung1");
		
		given()
		.contentType(ContentType.JSON)
		.body(map)
		.when()
		.post("http://49.249.28.218:8091/addProject")
		.then()
		.assertThat().statusCode(201)
		.log().all();

	}

}

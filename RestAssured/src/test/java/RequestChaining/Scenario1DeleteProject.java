package RequestChaining;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import PojoClass.Utility.ProjectPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Scenario1DeleteProject {
	
	@Test
	public void postDataToServer() {
		
		//APi-1 ==> add a project inside server
		Random random = new Random();
		int ranNum = random.nextInt(5000);
		
		//create and object to pojo class
		ProjectPojo pobj = new ProjectPojo("BCC_"+ranNum, "Created", "Deepak", 0);
		
	Response resp = given()
			.contentType(ContentType.JSON)
			.body(pobj)
			.when()
			.post("http://49.249.28.218:8091/addProject");
			resp.then()
			.assertThat().statusCode(201)
			.log().all();
			
			//capture project name from response
		String projectId = resp.jsonPath().get("projectId");
			System.out.println(projectId);
			
			//API-2 delete project
			given()
			.delete("http://49.249.28.218:8091/project/"+projectId)
			.then()
			.log().all();
			
	}

}























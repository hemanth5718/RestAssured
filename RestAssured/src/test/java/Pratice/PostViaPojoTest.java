package Pratice;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import PojoClass.Utility.ProjectPojo;
import io.restassured.http.ContentType;

public class PostViaPojoTest {
	@Test
	public void postDataToServer() {
		//create an object to pojo class
		Random random = new Random();
		int ran = random.nextInt(5000);
		
		ProjectPojo pobj = new ProjectPojo("bba6"+ ran, "Created", "hemanth",0);

		given()
		.contentType(ContentType.JSON)
		.body(pobj)
		.when()
		.post("http://49.249.28.218:8091/addProject")
		.then()
		.assertThat().statusCode(201)
		.log().all();
		
	}

}

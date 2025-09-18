package RequestChaining;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import PojoClass.Utility.EmployeePojo;
import PojoClass.Utility.ProjectPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Scenario_2_AddEmployeToProject {
	
	@Test
	public void sampleTest() {
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
				String projName = resp.jsonPath().get("projectName");
					System.out.println(projName);
										
			//APi-2 add employee to same project	
					
		EmployeePojo empObj = new EmployeePojo("Architect", "09/03/1975", "hemanth@gmail.com",
				"user_"+ranNum, 17, "9876541230", projName, "ROLE_EMPLOYEE","user_"+ranNum);
		given()
		.contentType(ContentType.JSON)
		.body(empObj)
		.when()
		.post("http://49.249.28.218:8091/employees")
		.then()
		.assertThat().statusCode(201)
		.log().all();
					
	}

}











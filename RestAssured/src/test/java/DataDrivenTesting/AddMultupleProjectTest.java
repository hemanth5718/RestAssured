package DataDrivenTesting;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class AddMultupleProjectTest {
	@Test
	public void sampleTest() {
		
		String pName = "Google"; 
		String status = "Created";
		String reqBody = "{\r\n"
				+ "  \"createdBy\": \"Hemanth\",\r\n"
				+ "  \"projectName\": \""+pName+"\",\r\n"
				+ "  \"status\": \""+status+"\",\r\n"
				+ "  \"teamSize\": 0\r\n"
				+ "}";
		given()
		.contentType(ContentType.JSON)
		.body(reqBody)
		.when()
		.post("https://49.249.28.218:8091/addProject")
		.then()
		.log().all();
	}
	@DataProvider
	public Object[][] getData() {
		Object[][] objarr = new Object[3][2];
		objarr[0][0] = "AirMandya_1";
		objarr[0][1] = "Created";
		
		objarr[1][0] = "AirMandya_2";
		objarr[1][1] = "Created";
		
		objarr[2][0] = "AirMandya_3";
		objarr[2][1] = "Created";
		return objarr;
	}
	

}

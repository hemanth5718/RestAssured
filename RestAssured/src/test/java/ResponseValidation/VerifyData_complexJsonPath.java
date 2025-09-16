package ResponseValidation;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

public class VerifyData_complexJsonPath {
	@Test
	public void sampleTest() {
		
		Response resp = given()
                .get("http://49.249.28.218:8091/projects-paginated");
		
		resp.then()
		.log().all();
		
	List<String> list	=JsonPath.read(resp.asString(),".content[*].projectName");

	for(String data: list) {
		System.out.println(data);
	}
	List<String> list1	=JsonPath.read(resp.asString(),".content[*].[?(@.projectName=='Ninja8650')].projectId");
	String actualResult = list1.get(0);

	Assert.assertEquals(actualResult, "NH_PROJ_222");
	
	//extract firstProjectID
	
	
		
	}

}

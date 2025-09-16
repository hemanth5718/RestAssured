package ResponseValidation;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class VerifyResponseBodyViaJsonPath {
	@Test
	public void verifyBody() {
		Response resp = given().get("http://49.249.28.218:8091/projects-paginated");

		resp.then().log().all();
		
		
		int data = resp.jsonPath().get("numberOfElements");
		System.out.println(data);

		boolean data1 = resp.jsonPath().get("pageable.sort.unsorted");
		System.out.println(data1);

		String data3 = resp.jsonPath().get("content[0].projectId");
		System.out.println(data3);

		resp.then().assertThat().body("numberOfElements", Matchers.equalTo(20));

		resp.then().assertThat().body("pageable.sort.unsorted", Matchers.equalTo(true));

		//resp.then().assertThat().body("content[0].projectId", Matchers.equalTo("NH_PROJ_211"));
		
		ArrayList<String> lst = resp.jsonPath().get("content.projectId");
		System.out.println(lst);

	}

}

package CrudWithBDD;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class Delete {
	
	@Test
	public void deleteTest() {
		
		given()
		.delete("http://49.249.28.218:8091/project/NH_PROJ_030")
		.then()
		.assertThat().statusCode(204)
		.log().all();
	}

}

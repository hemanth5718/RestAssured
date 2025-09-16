package CrudWithBDD;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class ReadTest {
	@Test
	public void read() {
		given().get("http://49.249.28.218:8091/projects")
		.then()
		.assertThat().statusCode(200)
		.log().all();
	}

}

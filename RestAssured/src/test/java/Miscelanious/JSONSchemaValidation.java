package Miscelanious;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import PojoClass.Utility.ProjectPojo;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.Random;

public class JSONSchemaValidation {
	
	@Test
	public void jsonSchema() {
		Random rnum = new Random();
		int random = rnum.nextInt(5000);
		ProjectPojo pobj = new ProjectPojo("lemon"+random,"Created" ,"hemanth",0);
	Response resp = given()
		.contentType(ContentType.JSON)
		.body(pobj)
		.when()
		.post("http://49.249.28.218:8091/addProject");
		resp.then().log().all();
		resp.then().body(JsonSchemaValidator.matchesJsonSchema(new File("./config_env_data/jsonSchema.json")));
		
		resp.then().body("msg", Matchers.instanceOf(String.class));
	}

}

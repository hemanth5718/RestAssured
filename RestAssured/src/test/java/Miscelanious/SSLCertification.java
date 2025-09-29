package Miscelanious;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class SSLCertification {
	

	@Test
	public void sslCertification() {
				
		
		JSONObject jobj = new JSONObject();
		jobj.put("city", "Bangalore");
		jobj.put("country", "India");
		jobj.put("email", "hemanthg899@gmail.com");
		jobj.put("firstName", "hemanth");
		jobj.put("gender", "MALE");
		jobj.put("lastName", "gowda");
		jobj.put("password", "hemanth@1234");
		jobj.put("phone", "9874563210");
		jobj.put("state", "Karnataka");
		jobj.put("zoneId", "ALPHA");
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.relaxedHTTPSValidation()
		.when()
		.post("https://www.shoppersstack.com/shopping//shoppers")
		.then()
		.assertThat().statusCode(201)
		.log().all();
	}

}

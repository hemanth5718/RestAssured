package Miscelanious;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class WireMock {

	@Test
	public void debitCardTest() {
		
		JSONObject jobj = new JSONObject();
		jobj.put("debitCardNum", "1234567887654321");
		jobj.put("cvv", "543");
		jobj.put("expDate", "28/30");
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.post("http://localhost:9999/debitCard")
		.then().log().all();
	}
}

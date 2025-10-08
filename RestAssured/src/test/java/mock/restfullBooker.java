package mock;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import POJO.BookingDatesPOJO;
import POJO.createPojo;
import POJO.updatePojo;
import genericUtility.JsonUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class restfullBooker {
	String bookingID;
	@Test
	public void create() {
		
		JsonUtility jslib = new JsonUtility();
		
		BookingDatesPOJO bookingdates = new BookingDatesPOJO("2018-01-01", "2019-01-01");
		createPojo pobj = new createPojo("hemanth1", "gowda1", 142, true, bookingdates ,"Breakfast");
			
		 Response resp = given()
		.contentType(ContentType.JSON)
		.body(pobj)
		.when()
		.post("https://restful-booker.herokuapp.com/booking");
		resp.then()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
		
		 bookingID = jslib.getDataOnJsonPath(resp, ".bookingid");		
		System.out.println(bookingID);
	}
	
	@Test(dependsOnMethods = "create")
	public void partialUpdate() {
		
		updatePojo upObj = new updatePojo("james", "brown");
		
		given()
		.contentType(ContentType.JSON)
		.body(upObj)
		.pathParam("id", bookingID)
		.auth().preemptive().basic("admin", "password123")
		.when()
		.patch("https://restful-booker.herokuapp.com/booking/{id}")
		.then()
		.contentType(ContentType.JSON)
		.statusCode(200)
		.log().all();
		
	}

}

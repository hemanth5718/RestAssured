package RequestChaining;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class Scenario_3_getPayrollInfo {
	@Test
	public void sampleTest() {
		
		//api-1 auth 
		given()
		.formParam("client_id", "ninza-client")
		.formParam("client_secret", "gPQBf1Yxew50MccMhzos1GefIyiSnXzM")
		.formParam("grant_type", "client_credentials")
		.when()
		.post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token")
		.then()
		.log().all();
		
		//APi=2 get payroll info
		/*
		 * given() .get("http://49.249.28.218:8091/admin/payrolls") .then()
		 * .log().all();
		 */
		
	}

}

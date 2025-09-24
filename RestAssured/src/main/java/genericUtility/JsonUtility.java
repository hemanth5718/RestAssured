package genericUtility;

import static io.restassured.RestAssured.given;

import java.util.List;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

public class JsonUtility {
	public String getDataOnJsonPath(Response resp, String jsonXpath)
	{
		List<Object> list = JsonPath.read(resp.asString(), jsonXpath);
		return list.get(0).toString();
	}
	
	public String getDataOnXmlPath(Response resp, String xmlXpath) {
		return resp.xmlPath().getString(xmlXpath);
	}
	
	public boolean verifyDataOnJsonPath(Response resp,String jsonXpath,String expectedData) {
		List<String> list = JsonPath.read(resp.asString(), jsonXpath);
		boolean flag = false;
		for(String str : list) {
			if(str.equals(expectedData)) {
				System.out.println(expectedData+"is available==Pass");
				flag=true;
			}
		}
		if(flag==false) {
			System.out.println(expectedData+"is not available==fail");

		}
		return flag;
	}
	
	public String getAcessToken() {
		Response resp = given()
						.formParam("client_id", "")
						.formParam("client_secret", "")
						.formParam("grant_type", "")
						.when()
						.post("");
						resp.then()
						.log().all();
						String token = resp.jsonPath().get("access_token");
						return token;
	}
	
	
	
	
	
	
	
	
	
	
	

}

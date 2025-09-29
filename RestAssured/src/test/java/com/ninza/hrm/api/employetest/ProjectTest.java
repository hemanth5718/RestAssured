 package com.ninza.hrm.api.employetest;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import PojoClass.Utility.ProjectPojo;
import genericUtility.DataBaseUtility;
import genericUtility.FileUtility;
import genericUtility.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ProjectTest {
	
	JavaUtility jlib = new JavaUtility();
	FileUtility flib= new FileUtility();
	DataBaseUtility dlib = new DataBaseUtility();
	ProjectPojo pObj;
	@Test
	public void addSingleprojectWithCreatedTest() throws Throwable
	{
		String BaseUrl = flib.getDataFromPropertiesFile("BASEUri");
		String expSuccMsg="Successfully Added";
		String projectName = "ADC_"+jlib.getRandomNumber();
		
		pObj= new ProjectPojo(projectName,"Created","hemanth",0);
		
		Response resp=  given()
						.contentType(ContentType.JSON)
						.body(pObj)
						.when()
						.post(BaseUrl+"/addProject");
		
				resp.then()
				.assertThat().statusCode(200)
				.assertThat().contentType(ContentType.JSON)
				.assertThat().time(Matchers.lessThan(3000L))
				.log().all();
				
				String actMsg = resp.jsonPath().getString("msg");
				Assert.assertEquals(expSuccMsg, actMsg);
				
				
		
		
	}

}

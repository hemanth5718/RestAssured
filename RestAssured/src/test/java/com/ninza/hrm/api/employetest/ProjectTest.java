 package com.ninza.hrm.api.employetest;

import static io.restassured.RestAssured.given;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import BaseApiClass.BaseApiClass;
import PojoClass.Utility.ProjectPojo;
import endPoints.IEndPoint;
import io.restassured.response.Response;

public class ProjectTest extends BaseApiClass {
	
	ProjectPojo pObj;
	String BaseUrl;
	
	@Test
	public void addSingleprojectWithCreatedTest() throws Throwable
	{
		BaseUrl = flib.getDataFromPropertiesFile("BASEUri");
		String dbURI = flib.getDataFromPropertiesFile("DbUrl");
		String dbUN = flib.getDataFromPropertiesFile("Db_Username");
		String dbPsw = flib.getDataFromPropertiesFile("Db_Password");
		String expSuccMsg="Successfully Added";
		String	 projectName = "ADC_"+jlib.getRandomNumber();
		
		pObj= new ProjectPojo(projectName,"Created","hemanth",0);
		
		//verify the projectName in API 
		Response resp=  given()
						.spec(specReqObj)
						.body(pObj)
						.when()
						.post(IEndPoint.ADDproj);
		
				resp.then()
				.assertThat().statusCode(201)
				.assertThat().time(Matchers.lessThan(3000L))
				.spec(SpecResObj)
				.log().all();
				
				String actMsg = resp.jsonPath().getString("msg");
				Assert.assertEquals(expSuccMsg, actMsg);
				
				//verify the projectName in DB
				boolean flag = false;
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			Connection con = DriverManager.getConnection(dbURI, dbUN, dbPsw);
			ResultSet result = con.createStatement().executeQuery("select * from project");
			while(result.next()) {
				if(result.getString(4).equals(projectName)) {
					flag= true;
					break;
				}
			}
			con.close();
			Assert.assertTrue(flag,"Project in DB is not verified");		
		
	}


	@Test(dependsOnMethods = "addSingleprojectWithCreatedTest")
	public void createDuplicateProjectTest() throws Throwable {
		  given()
				.spec(specReqObj)
				.body(pObj)
				.when()
				.post(IEndPoint.ADDproj)
				.then()
		.assertThat().statusCode(409)
		.assertThat().time(Matchers.lessThan(3000L))
		.spec(SpecResObj)
		.log().all();
	
		
	}
	

}















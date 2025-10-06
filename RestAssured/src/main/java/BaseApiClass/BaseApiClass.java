package BaseApiClass;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import genericUtility.DataBaseUtility;
import genericUtility.FileUtility;
import genericUtility.JavaUtility;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseApiClass {
	public JavaUtility jlib = new JavaUtility();
	public FileUtility flib= new FileUtility();
	public DataBaseUtility dlib = new DataBaseUtility();
	public static RequestSpecification specReqObj;
	public static ResponseSpecification SpecResObj;
	
	@BeforeSuite
	public void configBS() throws Throwable
	{
		dlib.getDBconnection();
		System.out.println("=======connect to DB======");
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setContentType(ContentType.JSON);
		builder.setBaseUri(flib.getDataFromPropertiesFile("BASEUri"));
		  specReqObj = builder.build();
		  
		  ResponseSpecBuilder resBuilder= new ResponseSpecBuilder();
		  resBuilder.expectContentType(ContentType.JSON);
		   SpecResObj = resBuilder.build();
		  
		
	}
	
	@AfterSuite
	public void configAS() throws Throwable
	{
		dlib.closeDbconnect();
		System.out.println("=======disconnected to DB======");

	}

}

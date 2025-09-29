package com.ninza.hrm.api.employetest;

import static io.restassured.RestAssured.given;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Random;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import PojoClass.Utility.EmployeePojo;
import PojoClass.Utility.ProjectPojo;
import genericUtility.DataBaseUtility;
import genericUtility.FileUtility;
import genericUtility.JavaUtility;
import io.restassured.http.ContentType;

public class EmployeeTest {
	JavaUtility jlib = new JavaUtility();
	FileUtility flib= new FileUtility();
	DataBaseUtility dlib = new DataBaseUtility();
	ProjectPojo pObj;
	String BaseUrl;
	
	@Test
	public void addEmployeeTest() throws Throwable {
		
	
		String projectName="BCC_"+jlib.getRandomNumber();
		String userName = "user_"+jlib.getRandomNumber();
		BaseUrl = flib.getDataFromPropertiesFile("BASEUri");
		
		//create and object to pojo class
		ProjectPojo pobj = new ProjectPojo(projectName, "Created", "Deepak", 0);
		
			given()
			.contentType(ContentType.JSON)
			.body(pobj)
			.when()
			.post(BaseUrl+"/addProject")
			.then()
			.log().all();
			
								
	//APi-2 add employee to same project	
			
EmployeePojo empObj = new EmployeePojo("Architect", "09/03/1975", "hemanth@gmail.com",
		userName, 17, "9876541230", projectName, "ROLE_EMPLOYEE",userName);
				given()
				.contentType(ContentType.JSON)
				.body(empObj)
				.when()
				.post("http://49.249.28.218:8091/employees")
				.then()
				.assertThat().contentType(ContentType.JSON)
				.assertThat().statusCode(201)
				.and()
				.time(Matchers.lessThan(3000L))
				.log().all();
				
				//verify EMP DB
				boolean flag = false;
				Driver driverRef = new Driver();
				DriverManager.registerDriver(driverRef);
				Connection con = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
				ResultSet result = con.createStatement().executeQuery("select * from employee");
				while(result.next()) {
					if(result.getString(5).equals(userName)) {
						flag= true;
						break;
					}
				}
				con.close();
				Assert.assertTrue(flag,"Employee in DB is not verified");
		
	}
	
	
	@Test
	public void addEmpWithoutEmailTest() {
		
		
		Random random = new Random();
		int ranNum = random.nextInt(5000);
		String projectName="BCC_"+ranNum;
		String userName = "user_"+ranNum;
		
		//create and object to pojo class
		ProjectPojo pobj = new ProjectPojo(projectName, "Created", "Deepak", 0);
		
			given()
			.contentType(ContentType.JSON)
			.body(pobj)
			.when()
			.post("http://49.249.28.218:8091/addProject")
			.then()
			.log().all();
			
								
	//APi-2 add employee to same project	
			
EmployeePojo empObj = new EmployeePojo("Architect", "09/03/1975", "",
		userName, 17, "9876541230", projectName, "ROLE_EMPLOYEE",userName);
				given()
				.contentType(ContentType.JSON)
				.body(empObj)
				.when()
				.post("http://49.249.28.218:8091/employees")
				.then()
				.assertThat().contentType(ContentType.JSON)
				.assertThat().statusCode(500)
				.log().all();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

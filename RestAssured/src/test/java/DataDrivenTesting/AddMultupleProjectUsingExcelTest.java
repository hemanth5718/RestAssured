package DataDrivenTesting;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtility.ExcelUtility;
import io.restassured.http.ContentType;

public class AddMultupleProjectUsingExcelTest {
	@Test(dataProvider = "getData")
	public void sampleTest(String pName, String status) {
		
		String reqBody = "{\r\n"
				+ "  \"createdBy\": \"Hemanth\",\r\n"
				+ "  \"projectName\": \""+pName+"\",\r\n"
				+ "  \"status\": \""+status+"\",\r\n"
				+ "  \"teamSize\": 0\r\n"
				+ "}";
		given()
		.contentType(ContentType.JSON)
		.body(reqBody)
		.when()
		.post("http://49.249.28.218:8091/addProject")
		.then()
		.log().all();
	}
	@DataProvider
	public Object[][] getData() throws Throwable {
		ExcelUtility elib = new ExcelUtility();
		int count = elib.getLastRowCount("Sheet1");
		Object[][] objarr = new Object[count][2];
		
		for(int i=0; i<count; i++) {
			objarr[i][0]= elib.getDataFromExcel("Sheet1", i+1, 0);
			objarr[i][1]= elib.getDataFromExcel("Sheet1", i+1, 1);
		}
		
		return objarr;
	}
	

}

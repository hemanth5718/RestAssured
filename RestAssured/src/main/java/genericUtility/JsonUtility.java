package genericUtility;

import java.util.List;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

public class JsonUtility {
	public String getDataOnJsonPath(Response resp, String jsonXpath)
	{
		List<Object> list = JsonPath.read(resp.asString(), jsonXpath);
		return list.get(0).toString();
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
	
	
}

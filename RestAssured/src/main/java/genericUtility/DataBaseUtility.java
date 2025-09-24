package genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	static Connection con;

	public void getDBconnection(String url, String username, String password) throws Throwable {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
		}
	}

	public void closeDbconnect() throws Throwable {
		try {
			con.close();
		} catch (Exception e) {
		}
	}

	public ResultSet executeSelectQuery(String query) throws Throwable {
		ResultSet result = null;
		try {
			Statement stat = con.createStatement();
			result = stat.executeQuery(query);
		} catch (Exception e) {
		}
		return result;
	}

	public int executeNonSelectQuery(String query) {
		int result = 0;
		try {
			Statement stat = con.createStatement();
			result = stat.executeUpdate(query);
		} catch (Exception e) {
		}
		return result;

	}
	
	public static String executeQueryVerifyAndGetData(String query,int columnIndex,String expectedData) throws Throwable {
		ResultSet result = null;
		boolean flag= false;
			try {
				result=con.createStatement().executeQuery(query);
			} catch (Exception e) {
				e.printStackTrace();
			}
				
		while(result.next()) {
			if(result.getString(columnIndex).equals(expectedData)) {
				flag=true;
				break;
			}
		}
		if (flag) {
			System.out.println(expectedData + "==> data verified in data base table");
			return expectedData;
		}else {
			System.out.println(expectedData + "==> data not verified in data base table");
			return expectedData;
		}
	}

	public void getDBconnection() throws Throwable {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
		} catch (Exception e) {
		}
	}

}

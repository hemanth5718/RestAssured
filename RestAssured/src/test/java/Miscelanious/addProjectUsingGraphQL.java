package Miscelanious;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class addProjectUsingGraphQL {
	@Test
	public void getProjectUsingGraph() {
		
		String query="{ getAllProjects{ projectId projectName status } }";
		
		given()
		.contentType(ContentType.JSON)
		.body(query)
		.when()
		.post("http://49.249.28.218:8091/getAll")
		.then()
		.log().all();
	}
	
	@Test
	public void getProjectStatus() {
	String query="{ getAllProjects{ projectId projectName  } }";
		
		given()
		.contentType(ContentType.JSON)
		.body(query)
		.when()
		.post("http://49.249.28.218:8091/getAll")
		.then()
		.log().all();
	}
	
	@Test
	public void addProject() {
String query="mutation { addProject( projectName: \"samsung12326\", teamSize: 0, createdBy: \"hemanth6161\", createdOn: \"2024-07-05\", status: \"Created\" ) { projectId projectName teamSize createdBy createdOn status } }";
		
		given()
		.contentType(ContentType.JSON)
		.body(query)
		.when()
		.post("http://49.249.28.218:8091/addProject-graphql")
		.then()
		.assertThat().statusCode(201)
		.log().all();
	}
	
	@Test
	public void getProjectByPID() {
  String query="{ findProject(projectId:\"NH_PROJ_2320\"){ projectId projectName status createdBy teamSize } }";
		
		given()
		.contentType(ContentType.JSON)
		.body(query)
		.when()
		.post("http://49.249.28.218:8091/getProjectByProjectId")
		.then()
		.log().all();
	}

	}
	
	
	
	
	
	
	
	
	
	



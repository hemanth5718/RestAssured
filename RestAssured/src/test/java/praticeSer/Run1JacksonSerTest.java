package praticeSer;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

class Project{ //pojo class [plain old java object]
	private String ProjectName;
	private String createdBy;
	private int teamSize;
	private String status;
	
	private Project() {}
	
	public Project(String projectName, String createdBy, int teamSize, String status) {
		super();
		ProjectName = projectName;
		this.createdBy = createdBy;
		this.teamSize = teamSize;
		this.status = status;
	}

	public String getProjectName() {
		return ProjectName;
	}

	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}


public class Run1JacksonSerTest {

	public static void main(String[] args) throws Throwable, DatabindException, IOException {
		Project Pobj = new Project("Orange123", "hemanth", 0, "Created");
		
		ObjectMapper objM = new ObjectMapper();
		objM.writeValue(new File("./project.json"), Pobj);
		System.out.println("======END======");
	}
	
}

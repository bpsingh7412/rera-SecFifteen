package in.gov.projectalteration.model.transaction;

import java.util.List;

import in.gov.projectalteration.model.AllotteeDetailModel;

public class AllotteeResponceModel {

	private Long projectId;
	private String projectName;

	private List<AllotteeDetailModel> allotteeList;

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<AllotteeDetailModel> getAllotteeList() {
		return allotteeList;
	}

	public void setAllotteeList(List<AllotteeDetailModel> allotteeList) {
		this.allotteeList = allotteeList;
	}

}

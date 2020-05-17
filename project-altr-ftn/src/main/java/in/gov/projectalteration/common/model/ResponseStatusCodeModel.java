package in.gov.projectalteration.common.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;



public class ResponseStatusCodeModel implements Serializable {

	private static final long serialVersionUID = 1463124437645744569L;

	private String registrationNo;
	private String promoterName;
	private String projectName;
	private String projectType;
	private Long projectCost;
	private String status;
	private String stateName;
	private Date submissionDate;
	private Calendar projectStatrDate;
	private Calendar projectEndDate;
	
	
	public Date getSubmissionDate() {
		return submissionDate;
	}
	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}
	public String getRegistrationNo() {
		return registrationNo;
	}
	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}
	public String getPromoterName() {
		return promoterName;
	}
	public void setPromoterName(String promoterName) {
		this.promoterName = promoterName;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectType() {
		return projectType;
	}
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	public Long getProjectCost() {
		return projectCost;
	}
	public void setProjectCost(Long projectCost) {
		this.projectCost = projectCost;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public Calendar getProjectStatrDate() {
		return projectStatrDate;
	}
	public void setProjectStatrDate(Calendar projectStatrDate) {
		this.projectStatrDate = projectStatrDate;
	}
	public Calendar getProjectEndDate() {
		return projectEndDate;
	}
	public void setProjectEndDate(Calendar projectEndDate) {
		this.projectEndDate = projectEndDate;
	}

	

}

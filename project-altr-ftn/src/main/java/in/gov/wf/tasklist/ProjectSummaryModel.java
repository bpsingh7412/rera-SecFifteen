package in.gov.wf.tasklist;

import java.util.Calendar;

import in.gov.projectalteration.model.ProjectAlterationModel;
import in.gov.wf.util.DateUtil;

public class ProjectSummaryModel {

	private Long projectId;
	private Long projectRegId;
	private String projectName;
	private String projectType;
	private String promotorType;
	private String promotorName;
	private Long projectCost;
	private String status;
	private String statusName;
	private String submissionDate;
	private String projectStartDate;
	private String projectEndDate;
	private String paymentStatus;
	private String ackNo;
	private String registrationNo;
	private String wfoId;
	private String team;
	private Calendar lastModifiedOn;
	private String alterationType;
	
	public ProjectSummaryModel(){
		
	}
	
	
	public ProjectSummaryModel(ProjectAlterationModel project){
		this.projectId=project.getId();
		this.wfoId=project.getWfoId();
		this.ackNo=project.getProjectAltAckNo();
		this.registrationNo=project.getProjectAltRegistrationNo();
		this.projectName=project.getProjectName();
		this.projectType=project.getProjectType();
		this.submissionDate=DateUtil.getDateStr(project.getAppSubmissionDate());		
		this.statusName=project.getStateName();
		this.status=project.getStateCode();
		this.team=project.getTpTeam();
		this.promotorName=project.getPromoterName();
		this.promotorType=project.getPromoterType();
		this.projectStartDate=DateUtil.getDateStr(project.getProjectDetailModel().getStartDate());
		this.projectEndDate=DateUtil.getDateStr(project.getProjectDetailModel().getCompletionDate());
		this.projectCost=project.getProjectDetailModel().getTotalProjectCost();
		this.lastModifiedOn=project.getLastModifiedOn();
		this.projectRegId=project.getProjectRegId();
		this.alterationType=project.getAlterationType();
	}
	
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public Long getProjectRegId() {
		return projectRegId;
	}
	public void setProjectRegId(Long projectRegId) {
		this.projectRegId = projectRegId;
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
	public String getPromotorType() {
		return promotorType;
	}
	public void setPromotorType(String promotorType) {
		this.promotorType = promotorType;
	}
	public String getPromotorName() {
		return promotorName;
	}
	public void setPromotorName(String promotorName) {
		this.promotorName = promotorName;
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

	
	public String getStatusName() {
		return statusName;
	}


	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}


	public String getWfoId() {
		return wfoId;
	}


	public void setWfoId(String wfoId) {
		this.wfoId = wfoId;
	}


	public String getTeam() {
		return team;
	}


	public void setTeam(String team) {
		this.team = team;
	}


	public String getSubmissionDate() {
		return submissionDate;
	}
	public void setSubmissionDate(String submissionDate) {
		this.submissionDate = submissionDate;
	}
	public String getProjectStatrDate() {
		return projectStartDate;
	}
	public void setProjectStatrDate(String projectStatrDate) {
		this.projectStartDate = projectStatrDate;
	}
	public String getProjectEndDate() {
		return projectEndDate;
	}
	public void setProjectEndDate(String projectEndDate) {
		this.projectEndDate = projectEndDate;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getAckNo() {
		return ackNo;
	}
	public void setAckNo(String ackNo) {
		this.ackNo = ackNo;
	}
	public String getRegistrationNo() {
		return registrationNo;
	}
	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}


	public Calendar getLastModifiedOn() {
		return lastModifiedOn;
	}


	public void setLastModifiedOn(Calendar lastModifiedOn) {
		this.lastModifiedOn = lastModifiedOn;
	}


	public String getProjectStartDate() {
		return projectStartDate;
	}


	public void setProjectStartDate(String projectStartDate) {
		this.projectStartDate = projectStartDate;
	}


	public String getAlterationType() {
		return alterationType;
	}


	public void setAlterationType(String alterationType) {
		this.alterationType = alterationType;
	}
	
	
	
}

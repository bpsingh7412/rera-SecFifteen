package in.gov.projectalteration.model;

import java.util.Date;

public class ProjectRegistrationModel {

	private Long promoterId;

	private String promoteremailId;
	
	private String promoterName;
	private String projectName;
	
	private String promoterType;
	
	private String projRegNo;
	
	private String promoterMobileNo;
	

	
	private String projectAckNo;
	
	private String projectAltAckNo;
	

	private Date appSubmissionDate;
	
	private String projectStatus;

	private String status;



	private ProjectDetailModel projectDetailsModel;
	
	private ProjectAlterationModel projectAltDetailsModel;

	public Long getPromoterId() {
		return promoterId;
	}

	public void setPromoterId(Long promoterId) {
		this.promoterId = promoterId;
	}

	public String getPromoteremailId() {
		return promoteremailId;
	}

	public void setPromoteremailId(String promoteremailId) {
		this.promoteremailId = promoteremailId;
	}

	public String getPromoterName() {
		return promoterName;
	}

	public void setPromoterName(String promoterName) {
		this.promoterName = promoterName;
	}

	public String getPromoterType() {
		return promoterType;
	}

	public void setPromoterType(String promoterType) {
		this.promoterType = promoterType;
	}

	public String getProjRegNo() {
		return projRegNo;
	}

	public void setProjRegNo(String projRegNo) {
		this.projRegNo = projRegNo;
	}

	public String getPromoterMobileNo() {
		return promoterMobileNo;
	}

	public void setPromoterMobileNo(String promoterMobileNo) {
		this.promoterMobileNo = promoterMobileNo;
	}

	public String getProjectAckNo() {
		return projectAckNo;
	}

	public void setProjectAckNo(String projectAckNo) {
		this.projectAckNo = projectAckNo;
	}

	public Date getAppSubmissionDate() {
		return appSubmissionDate;
	}

	public void setAppSubmissionDate(Date appSubmissionDate) {
		this.appSubmissionDate = appSubmissionDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	public ProjectDetailModel getProjectDetailsModel() {
		return projectDetailsModel;
	}

	public void setProjectDetailsModel(ProjectDetailModel projectDetailsModel) {
		this.projectDetailsModel = projectDetailsModel;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectAltAckNo() {
		return projectAltAckNo;
	}

	public void setProjectAltAckNo(String projectAltAckNo) {
		this.projectAltAckNo = projectAltAckNo;
	}

	public String getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	public ProjectAlterationModel getProjectAltDetailsModel() {
		return projectAltDetailsModel;
	}

	public void setProjectAltDetailsModel(ProjectAlterationModel projectAltDetailsModel) {
		this.projectAltDetailsModel = projectAltDetailsModel;
	}

	

}

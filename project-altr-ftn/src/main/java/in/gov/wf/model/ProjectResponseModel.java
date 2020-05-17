package in.gov.wf.model;

import java.util.Calendar;
import java.util.Date;

import in.gov.projectalteration.model.ProjectAlterationModel;


public class ProjectResponseModel implements WFEntity {

	private Long promoterId;

	private Long projectId;
	private String projRegNo;

	
	private String projectAckNo;

	
	private Date appSubmissionDate;

	
	private String status;

	
	private Calendar approvedOn;

	
	private Calendar expireDate;

	
	private Calendar lastUpdatedOn;

	
	private String approvedBy;
	
	private String stateCode;
	
	private String stateName;
	
	private String processName;
	
	private String tpTeam;
	private String tpSrTeam;
	private String finTeam;
	private String legalTeam;
	
	private String wfoId;
	
	private String finState;
	
	private String tpState;
	
	private String legalState;
	
	private Long createdBy;
	
	private String createdByName;
	
	private Long lastUpdatedBy;
	
	private String lastUpdatedByName;
	
	private Long formOne;
	
	private Long formTwo;
	private Long formThree;

	
	
	public ProjectResponseModel(){}
	public ProjectResponseModel(ProjectAlterationModel project){
		this.processName=project.getProcessName();
		this.approvedBy=project.getApprovedBy();
		this.approvedOn=project.getApprovedOn();
		this.appSubmissionDate=project.getAppSubmissionDate();
		this.createdBy=project.getCreatedBy();
		this.createdByName=project.getCreatedByName();
		
		this.promoterId=project.getPromoterId();
		this.stateCode=project.getStateCode();
		this.stateName=project.getStateName();
		this.status=project.getStatus();
		this.tpTeam=project.getTpTeam();
		this.finTeam=project.getFinTeam();
		this.legalTeam=project.getLegalTeam();
		this.tpState=project.getTpState();
		this.wfoId=project.getWfoId();
	}
	
	
	
	
	
	
	public Long getPromoterId() {
		return promoterId;
	}
	public void setPromoterId(Long promoterId) {
		this.promoterId = promoterId;
	}
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public String getProjRegNo() {
		return projRegNo;
	}
	public void setProjRegNo(String projRegNo) {
		this.projRegNo = projRegNo;
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
	public Calendar getApprovedOn() {
		return approvedOn;
	}
	public void setApprovedOn(Calendar approvedOn) {
		this.approvedOn = approvedOn;
	}
	public Calendar getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Calendar expireDate) {
		this.expireDate = expireDate;
	}
	public String getApprovedBy() {
		return approvedBy;
	}
	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}
	public Long getFormOne() {
		return formOne;
	}
	public void setFormOne(Long formOne) {
		this.formOne = formOne;
	}
	public Long getFormTwo() {
		return formTwo;
	}
	public void setFormTwo(Long formTwo) {
		this.formTwo = formTwo;
	}
	public Long getFormThree() {
		return formThree;
	}
	public void setFormThree(Long formThree) {
		this.formThree = formThree;
	}
	public Long getCreatedBy() {
		return createdBy;
	}
	public String getCreatedByName() {
		return createdByName;
	}
	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	public String getLastUpdatedByName() {
		return lastUpdatedByName;
	}
	public Calendar getLastUpdatedOn() {
		return lastUpdatedOn;
	}
	public void setLastUpdatedOn(Calendar lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getProcessName() {
		return processName;
	}
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	
	public String getWfoId() {
		return wfoId;
	}
	public void setWfoId(String wfoId) {
		this.wfoId = wfoId;
	}
	public String getFinState() {
		return finState;
	}
	public void setFinState(String finState) {
		this.finState = finState;
	}
	public String getTpState() {
		return tpState;
	}
	public void setTpState(String tpState) {
		this.tpState = tpState;
	}
	public String getLegalState() {
		return legalState;
	}
	public void setLegalState(String legalState) {
		this.legalState = legalState;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	public void setCreatedByName(String createdByName) {
		this.createdByName = createdByName;
	}
	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	public void setLastUpdatedByName(String lastUpdatedByName) {
		this.lastUpdatedByName = lastUpdatedByName;
	}
	@Override
	public Long getId() {
	
		return projectId;
	}
	@Override
	public Calendar getCreatedOn() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setCreatedOn(Calendar cal) {
		// TODO Auto-generated method stub
		
	}
	public String getTpTeam() {
		return tpTeam;
	}
	public void setTpTeam(String tpTeam) {
		this.tpTeam = tpTeam;
	}
	public String getTpSrTeam() {
		return tpSrTeam;
	}
	public void setTpSrTeam(String tpSrTeam) {
		this.tpSrTeam = tpSrTeam;
	}
	public String getFinTeam() {
		return finTeam;
	}
	public void setFinTeam(String finTeam) {
		this.finTeam = finTeam;
	}
	public String getLegalTeam() {
		return legalTeam;
	}
	public void setLegalTeam(String legalTeam) {
		this.legalTeam = legalTeam;
	}
	
	
	
}

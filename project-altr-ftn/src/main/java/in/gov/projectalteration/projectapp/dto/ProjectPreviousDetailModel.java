package in.gov.projectalteration.projectapp.dto;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ProjectPreviousDetailModel implements Serializable {

	private static final long serialVersionUID = -6578755590737365502L;

	private Long pervProjectRegId;

	private Long projectRegId;

	private Long projectAppRegId;

	private String projectName;

	private String projectDescription;

	private String projectCurrentStatus;

	private String typeOfLand;

	private Boolean ifDelayed;

	private String noOfMonthDelayed;

	private Boolean ifOngoing;

	private Date expectedCompletionDate;// expectedCompletionDate

	private String stateCode;

	private String stateName;

	private String distCode;

	private String distName;

	private String talukaName;

	private String talukaCode;

	private Long completionDocId;

	private String projectAddress;

	private String isCasesPending;

	private String caseDetails;

	private String isPaymentPending;

	private Integer pendingAmount;

	private String pendingAmountCase;

	private String isProjectFromGujreraFlag;

	private Long projectCompletionCertid;

	private String projectCompletionCertUId;

	public void setProjectAppRegId(Long projectAppRegId) {
		this.projectAppRegId = projectAppRegId;
	}

	public Long getProjectAppRegId() {
		return projectAppRegId;
	}

	public void setIsCasesPending(String isCasesPending) {
		this.isCasesPending = isCasesPending;
	}

	public String getIsCasesPending() {
		return isCasesPending;
	}

	public String getCaseDetails() {
		return caseDetails;
	}

	public void setCaseDetails(String caseDetails) {
		this.caseDetails = caseDetails;
	}

	public String getIsPaymentPending() {
		return isPaymentPending;
	}

	public void setIsPaymentPending(String isPaymentPending) {
		this.isPaymentPending = isPaymentPending;
	}

	private String projectAddrPinCode;

	private Calendar createdOn;

	private Calendar modifiedOn;

	private String modifiedBy;

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public String getProjectCurrentStatus() {
		return projectCurrentStatus;
	}

	public void setProjectCurrentStatus(String projectCurrentStatus) {
		this.projectCurrentStatus = projectCurrentStatus;
	}

	public String getTypeOfLand() {
		return typeOfLand;
	}

	public void setTypeOfLand(String typeOfLand) {
		this.typeOfLand = typeOfLand;
	}

	public Boolean getIfDelayed() {
		return ifDelayed;
	}

	public void setIfDelayed(Boolean ifDelayed) {
		this.ifDelayed = ifDelayed;
	}

	public String getNoOfMonthDelayed() {
		return noOfMonthDelayed;
	}

	public void setNoOfMonthDelayed(String noOfMonthDelayed) {
		this.noOfMonthDelayed = noOfMonthDelayed;
	}

	public Boolean getIfOngoing() {
		return ifOngoing;
	}

	public void setIfOngoing(Boolean ifOngoing) {
		this.ifOngoing = ifOngoing;
	}

	public Date getExpectedCompletionDate() {
		return expectedCompletionDate;
	}

	public void setExpectedCompletionDate(Date expectedCompletionDate) {
		this.expectedCompletionDate = expectedCompletionDate;
	}

	public Long getPervProjectRegId() {
		return pervProjectRegId;
	}

	public void setPervProjectRegId(Long pervProjectRegId) {
		this.pervProjectRegId = pervProjectRegId;
	}

	public String getProjectAddress() {
		return projectAddress;
	}

	public void setProjectAddress(String projectAddress) {
		this.projectAddress = projectAddress;
	}

	public String getProjectAddrPinCode() {
		return projectAddrPinCode;
	}

	public void setProjectAddrPinCode(String projectAddrPinCode) {
		this.projectAddrPinCode = projectAddrPinCode;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Integer getPendingAmount() {
		return pendingAmount;
	}

	public void setPendingAmount(Integer pendingAmount) {
		this.pendingAmount = pendingAmount;
	}

	public Calendar getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Calendar createdOn) {
		this.createdOn = createdOn;
	}

	public Calendar getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Calendar modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public Long getProjectRegId() {
		return projectRegId;
	}

	public void setProjectRegId(Long projectRegId) {
		this.projectRegId = projectRegId;
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

	public String getDistCode() {
		return distCode;
	}

	public void setDistCode(String distCode) {
		this.distCode = distCode;
	}

	public String getDistName() {
		return distName;
	}

	public void setDistName(String distName) {
		this.distName = distName;
	}

	public Long getCompletionDocId() {
		return completionDocId;
	}

	public void setCompletionDocId(Long completionDocId) {
		this.completionDocId = completionDocId;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getIsProjectFromGujreraFlag() {
		return isProjectFromGujreraFlag;
	}

	public void setIsProjectFromGujreraFlag(String isProjectFromGujreraFlag) {
		this.isProjectFromGujreraFlag = isProjectFromGujreraFlag;
	}

	public String getPendingAmountCase() {
		return pendingAmountCase;
	}

	public void setPendingAmountCase(String pendingAmountCase) {
		this.pendingAmountCase = pendingAmountCase;
	}

	public Long getProjectCompletionCertid() {
		return projectCompletionCertid;
	}

	public void setProjectCompletionCertid(Long projectCompletionCertid) {
		this.projectCompletionCertid = projectCompletionCertid;
	}

	public String getProjectCompletionCertUId() {
		return projectCompletionCertUId;
	}

	public void setProjectCompletionCertUId(String projectCompletionCertUId) {
		this.projectCompletionCertUId = projectCompletionCertUId;
	}

	public String getTalukaName() {
		return talukaName;
	}

	public void setTalukaName(String talukaName) {
		this.talukaName = talukaName;
	}

	public String getTalukaCode() {
		return talukaCode;
	}

	public void setTalukaCode(String talukaCode) {
		this.talukaCode = talukaCode;
	}

}

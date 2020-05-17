package in.gov.projectalteration.projectapp.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;

import in.gov.projectalteration.model.BlocksModel;
import in.gov.projectalteration.model.ProjectAlterationModel;

public class ProjectAppRegistrationModel implements Serializable {

	private static final long serialVersionUID = -986682253404597394L;

	private Long projAppId;

	private Long projRegId;

	/* promoter Details */
	private Long promoterId;

	private String promoteremailId;

	private String promoterName;

	private String promoterType;

	private String projRegNo;

	private String promoterMobileNo;

	private String projectAckNo;

	private Date appSubmissionDate;

	private String status;

	private Calendar approvedOn;
	private Calendar expireDate;

	private Calendar lastUpdatedOn;

	private String approvedBy;

	private List<ProjectPreviousDetailModel> previousProjectDetailsSet;

	private ProjectAppDetailModel projectDetailsModel;

	private String esignStatus;

	/***********************************************************************
	 * Professionals
	 ***********************************************************************/

	private List<ProjectDevelopmentDetailModel> developmentDetailSet;

	private List<ProjectBlocksModel> blockList;

	private ProjectAppFormOneDetail projectFormOne;

	private ProjectAppFormTwoDetail projectFormTwo;

	private ProjectAppFormThreeDetail projectFormThree;

	private ProjectAppDocumentModel projectDocModel;

	private ProjectAppFinDocumentModel projectFinDocModel;

	private ProjectAppPaymentDetailModel paymentDetailsModel;

	private Calendar createdOn;

	private ProjectAppBankDetails bankDetails;

	private List<ProjectAppBankDetails> bankLogs;

	private Long certificateId;

	private String certificateUid;

	private String stateCode;
	private String stateName;
	private String processName;

	private String wfoId;
	private String finTeam;
	private String legalTeam;
	private String tpSrTeam;
	private String finState;
	private String tpState;
	private String legalState;
	private Long createdBy;
	private String createdByName;
	private Long lastUpdatedBy;
	private String lastUpdatedByName;
	private String tpTeam;

	public List<ProjectAppBankDetails> getBankLogs() {
		return bankLogs;
	}

	public void setBankLogs(List<ProjectAppBankDetails> bankLogs) {
		this.bankLogs = bankLogs;
	}

	public ProjectAppFinDocumentModel getProjectFinDocModel() {
		return projectFinDocModel;
	}

	public void setProjectFinDocModel(ProjectAppFinDocumentModel projectFinDocModel) {
		this.projectFinDocModel = projectFinDocModel;
	}

	public Long getCertificateId() {
		return certificateId;
	}

	public void setCertificateId(Long certificateId) {
		this.certificateId = certificateId;
	}

	public String getCertificateUid() {
		return certificateUid;
	}

	public void setCertificateUid(String certificateUid) {
		this.certificateUid = certificateUid;
	}

	public Long getProjAppId() {
		return projAppId;
	}

	public void setProjAppId(Long projRegId) {
		this.projAppId = projRegId;
	}

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

	public Calendar getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	public void setLastUpdatedOn(Calendar lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public List<ProjectPreviousDetailModel> getPreviousProjectDetailsSet() {
		return previousProjectDetailsSet;
	}

	public void setPreviousProjectDetailsSet(List<ProjectPreviousDetailModel> previousProjectDetailsSet) {
		this.previousProjectDetailsSet = previousProjectDetailsSet;
	}

	public ProjectAppDetailModel getProjectDetailsModel() {
		return projectDetailsModel;
	}

	public void setProjectDetailsModel(ProjectAppDetailModel projectDetailsModel) {
		this.projectDetailsModel = projectDetailsModel;
	}

	public String getEsignStatus() {
		return esignStatus;
	}

	public void setEsignStatus(String esignStatus) {
		this.esignStatus = esignStatus;
	}

	
	public List<ProjectDevelopmentDetailModel> getDevelopmentDetailSet() {
		return developmentDetailSet;
	}

	public void setDevelopmentDetailSet(List<ProjectDevelopmentDetailModel> developmentDetailSet) {
		this.developmentDetailSet = developmentDetailSet;
	}

	public List<ProjectBlocksModel> getBlockList() {
		return blockList;
	}

	public void setBlockList(List<ProjectBlocksModel> blockList) {
		this.blockList = blockList;
	}

	public ProjectAppFormOneDetail getProjectFormOne() {
		return projectFormOne;
	}

	public void setProjectFormOne(ProjectAppFormOneDetail projectFormOne) {
		this.projectFormOne = projectFormOne;
	}

	public ProjectAppFormTwoDetail getProjectFormTwo() {
		return projectFormTwo;
	}

	public void setProjectFormTwo(ProjectAppFormTwoDetail projectFormTwo) {
		this.projectFormTwo = projectFormTwo;
	}

	public ProjectAppFormThreeDetail getProjectFormThree() {
		return projectFormThree;
	}

	public void setProjectFormThree(ProjectAppFormThreeDetail projectFormThree) {
		this.projectFormThree = projectFormThree;
	}

	public ProjectAppDocumentModel getProjectDocModel() {
		return projectDocModel;
	}

	public void setProjectDocModel(ProjectAppDocumentModel projectDocModel) {
		this.projectDocModel = projectDocModel;
	}

	public ProjectAppPaymentDetailModel getPaymentDetailsModel() {
		return paymentDetailsModel;
	}

	public void setPaymentDetailsModel(ProjectAppPaymentDetailModel paymentDetailsModel) {
		this.paymentDetailsModel = paymentDetailsModel;
	}

	public Calendar getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Calendar createdOn) {
		this.createdOn = createdOn;
	}

	// Returning only year of application submission date
	public int getAppSubmissionYear() {
		Calendar c = Calendar.getInstance();
		int year = 0;
		if (appSubmissionDate != null) {
			c.setTime(appSubmissionDate);
		}
//		c.getTime().getYear()
		year = c.get(Calendar.YEAR);
		return year;
	}

	public ProjectAppBankDetails getBankDetails() {
		return bankDetails;
	}

	public void setBankDetails(ProjectAppBankDetails bankDetails) {
		this.bankDetails = bankDetails;
	}

	public Long getProjRegId() {
		return projRegId;
	}

	public void setProjRegId(Long projRegId) {
		this.projRegId = projRegId;
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

	public String getTpSrTeam() {
		return tpSrTeam;
	}

	public void setTpSrTeam(String tpSrTeam) {
		this.tpSrTeam = tpSrTeam;
	}

	public String getTpTeam() {
		return tpTeam;
	}

	public void setTpTeam(String tpTeam) {
		this.tpTeam = tpTeam;
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

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedByName() {
		return createdByName;
	}

	public void setCreatedByName(String createdByName) {
		this.createdByName = createdByName;
	}

	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public String getLastUpdatedByName() {
		return lastUpdatedByName;
	}

	public void setLastUpdatedByName(String lastUpdatedByName) {
		this.lastUpdatedByName = lastUpdatedByName;
	}

	public static ProjectAppRegistrationModel populate(ProjectAlterationModel model) {
		ProjectAppRegistrationModel obj = new ProjectAppRegistrationModel();

		 obj.setApprovedBy(model.getApprovedBy());
		 obj.setApprovedOn(model.getApprovedOn());
		 obj.setAppSubmissionDate(model.getAppSubmissionDate());

		// obj.setBankDetails(bankDetails);
		// obj.setBankLogs(bankLogs);
		List<BlocksModel> blkList = model.getBlockList();
		List<ProjectBlocksModel> newList = new ArrayList<>();
		BeanUtils.copyProperties(blkList, newList);
		obj.setBlockList(newList);

		// obj.setCertificateId(model.getCertificateId()); //project certificate
		// obj.setCertificateUid(certificateUid);
		
		// obj.setDevelopmentDetailSet(dev);

		
		// obj.setExpireDate(expireDate);
		// obj.setFinState(finState);
		// obj.setFinTeam(finTeam);
		// obj.setLastUpdatedBy(lastUpdatedBy);
		// obj.setLastUpdatedByName(lastUpdatedByName);
		// obj.setLastUpdatedOn(lastUpdatedOn);
		// obj.setLegalState(legalState);
		// obj.setLegalTeam(legalTeam);
		// obj.setOtherPromoterDetails(otherPromoterDetails);
		// obj.setPaymentDetailsModel(paymentDetailsModel);
		// obj.setPreviousProjectDetailsSet(previousProjectDetailsSet);
		obj.setProcessName(model.getProcessName());
		obj.setProjRegId(model.getProjectRegId());
		// obj.setProjAppId(projRegId);
		
		obj.setProjectAckNo(model.getProjectAltAckNo());
		obj.setPromoterId(model.getPromoterId());
		obj.setPromoterName(model.getPromoterName());
		obj.setPromoterType(model.getPromoterType());
		obj.setPromoteremailId(model.getPromoteremailId());
		
		// obj.setProjectAgentDetailSet(model.getProjectAgentDetailSet());
		// obj.setProjectDetailsModel(projectDetailsModel);
		// obj.setProjectDocModel(projectDocModel);
		// obj.setProjectFinDocModel(projectFinDocModel);
		// obj.setProjectFormOne(projectFormOne);
		// obj.setProjectFormTwo(projectFormTwo);
		// obj.setProjectFormThree(projectFormThree);

		// obj.setTpSrTeam(tpSrTeam);
		// obj.setTpState(tpState);
		// obj.setTpTeam(tpTeam);

		return obj;
	}

}

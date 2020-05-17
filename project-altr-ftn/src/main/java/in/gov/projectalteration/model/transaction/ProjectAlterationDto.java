package in.gov.projectalteration.model.transaction;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import in.gov.projectalteration.model.ProjectAlterationModel;
import in.gov.wf.util.DateUtil;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class ProjectAlterationDto implements Serializable {

	private static final long serialVersionUID = -6678637072624865895L;

	private Long projectAltrId;
	private Long projectRegId;
	private String projectName;
	private String projectType;
	private String projectStageOneAltAckNo;
	/* promoter Details */
	private Long promoterId;
	private String promoteremailId;
	private String promoterName;
	private String promoterType;
	private String promoterMobileNo;
	private String jointDevelopmentFlag;
	private String projectAltAckNo;
	private Calendar startDate;
	private Calendar completionDate;

	private String status;
	private String stateName;
	private String stateCode;

	private String tpState;
	private String legalState;
	private String finState;
	private Calendar createdOn;
	private String alterationType;
	private String wfoId;
	private String stageOneStatus;
	
	private String stageTwoStatus;

	public String getWfoId() {
		return wfoId;
	}

	public void setWfoId(String wfoId) {
		this.wfoId = wfoId;
	}

	public Long getProjectAltrId() {
		return projectAltrId;
	}

	public void setProjectAltrId(Long projectAltrId) {
		this.projectAltrId = projectAltrId;
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

	public String getPromoterMobileNo() {
		return promoterMobileNo;
	}

	public void setPromoterMobileNo(String promoterMobileNo) {
		this.promoterMobileNo = promoterMobileNo;
	}

	public String getJointDevelopmentFlag() {
		return jointDevelopmentFlag;
	}

	public void setJointDevelopmentFlag(String jointDevelopmentFlag) {
		this.jointDevelopmentFlag = jointDevelopmentFlag;
	}

	public String getProjectAltAckNo() {
		return projectAltAckNo;
	}

	public void setProjectAltAckNo(String projectAltAckNo) {
		this.projectAltAckNo = projectAltAckNo;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public Calendar getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(Calendar completionDate) {
		this.completionDate = completionDate;
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

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
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

	public String getFinState() {
		return finState;
	}

	public void setFinState(String finState) {
		this.finState = finState;
	}

	public Calendar getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Calendar createdOn) {
		this.createdOn = createdOn;
	}

	public static ProjectAlterationDto populate(ProjectAlterationModel project) {
		ProjectAlterationDto obj = new ProjectAlterationDto();
		obj.setStatus(project.getStatus());
		obj.setPromoterName(project.getPromoterName());
		obj.setPromoterType(project.getPromoterType());
		obj.setProjectRegId(project.getProjectRegId());
		obj.setProjectType(project.getProjectType());
		obj.setStateName(project.getStateName());
		obj.setStateCode(project.getStateCode());
		obj.setLegalState(project.getLegalState());
		obj.setProjectName(project.getProjectName());
		obj.setStartDate(project.getProjectDetailModel().getStartDate());
		obj.setCompletionDate(project.getProjectDetailModel().getCompletionDate());
		obj.setCreatedOn(project.getCreatedOn());
		obj.setStateCode(project.getStateCode());
		obj.setStateName(project.getStateName());
		obj.setProjectAltAckNo(project.getProjectAltAckNo());
		obj.setProjectAltrId(project.getProjectAltrId());
		obj.setPromoterId(project.getPromoterId());
		obj.setAlterationType(project.getAlterationType());
		if(null!=project.getStageOneStatus())
		{
			obj.setStageOneStatus(project.getStageOneStatus());
		}
		if(null!=project.getStageTwoStatus())
		{
			obj.setStageTwoStatus(project.getStageTwoStatus());
		}
		if(null!=project.getProjectStageOneAltAckNo())
		{
			obj.setProjectStageOneAltAckNo(project.getProjectStageOneAltAckNo());
		}
		if(null!=project.getWfoId())
		{
			obj.setWfoId(project.getWfoId());
		}
		return obj;
	}

	public String getAlterationType() {
		return alterationType;
	}

	public void setAlterationType(String alterationType) {
		this.alterationType = alterationType;
	}

	public String getStageOneStatus() {
		return stageOneStatus;
	}

	public void setStageOneStatus(String stageOneStatus) {
		this.stageOneStatus = stageOneStatus;
	}

	public String getStageTwoStatus() {
		return stageTwoStatus;
	}

	public void setStageTwoStatus(String stageTwoStatus) {
		this.stageTwoStatus = stageTwoStatus;
	}

	public String getProjectStageOneAltAckNo() {
		return projectStageOneAltAckNo;
	}

	public void setProjectStageOneAltAckNo(String projectStageOneAltAckNo) {
		this.projectStageOneAltAckNo = projectStageOneAltAckNo;
	}

}
package in.gov.projectalteration.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import in.gov.projectaltsection15.model.Setion15StageOneModel;
import in.gov.projectaltsection15.model.Setion15StageTwoModel;
import in.gov.projectaltsection15.model.StageTwoPaymentModel;
import in.gov.wf.model.WFEntity;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity(name = "ProjectAlterationModel")
@Table(name = "TT_PROJECT_ALTERATION")
public class ProjectAlterationModel implements Serializable,WFEntity {
	private static final long serialVersionUID = -6678637072624865895L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PROJECT_ALTR_ID")
	private Long projectAltrId;

	// @NotEmpty(message="Project Id should not be empty.")
	@Column(name = "PROJECT_REG_ID")
	private Long projectRegId;

	@NotBlank(message = "Project name should not be blank.")
	@Column(name = "PROJECT_NAME")
	private String projectName;

	@Column(name = "PROJECT_TYPE")
	private String projectType;
	
	@Column(name = "ALTERATION_TYPE")
	private String alterationType;
	
	@Column(name = "STAGE_ONE_STATUS")
	private String stageOneStatus;
	
	@Column(name = "STAGE_TWO_STATUS")
	private String stageTwoStatus;

	/* promoter Details */
	@Column(name = "PMTR_ID")
	private Long promoterId;

	@Column(name = "PMTR_EMAIL_ID")
	private String promoteremailId;

	@Column(name = "PMTR_NAME")
	private String promoterName;

	@Column(name = "PRMTR_TYPE")
	private String promoterType;

	@Column(name = "PR_MOBILE_NO")
	private String promoterMobileNo;

	@Column(name = "PR_JOINTDEVELOPEMNT")
	private String jointDevelopmentFlag;

	@Column(name = "PR_ACK_NO")
	private String projectAltAckNo;
	
	@Column(name = "PR_ACK_STAGE_ONE_NO")
	private String projectStageOneAltAckNo;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "PRJ_ALT_ID_DTL_FK")
	private ProjectDetailModel projectDetailModel;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "PRJ_ALT_ID_ALLOTEE_FK")
	List<AllotteeDetailModel> allotteeList;

	/*************************************************
	 * Document
	 *************************************************/
	
	/***********************************************************************
	 * Professionals
	 ***********************************************************************/
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "PRJ_ALT_BLOCK_ID_FK")
	private List<BlocksModel> blockList;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "PRJ_ALT_ID_FORM1_FK")
	private FormOneModel formOneModel;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)

	@JoinColumn(name = "PRJ_REG_ID_FORM2_FK")
	private FormTwoModel formTwoModel;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)

	@JoinColumn(name = "PRJ_ALT_ID_FORM3_FK")
	private FormThreeModel formThreeModel;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY,orphanRemoval=true)
	@JoinColumn(name = "PRJ_ALT_ID_FORM3_MOF_FK")
	private MofFormThreeModel projectFormThreeMof;
	
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "PRJ_ALT_PAYMENT_ID_FK")
	private ProjectAlterationPaymentDetailsModel paymentDetailsModel;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "PRJ_ALT_STAGE_TWO_ID_FK")
	private StageTwoPaymentModel stageTwoPayment;

    
	@Column(name = "ALTR_STATUS", length = 50)
	private String altrStatus;

	@Column(name = "PRO_ALT_APP_NO")
	private String applicationNo;

	@Column(name = "PROJECT_ALT_REG_NO")
	private String projectAltRegistrationNo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "APP_SUBMISSION_DATE")
	private Date appSubmissionDate;

	@Column(name = "FINANCE_APPROVED_BY")
	private String financeApprovedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FINANCE_APPROVED_ON")
	private Calendar financeApprovedOn;

	private String approvedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "APPROVED_ON")
	private Calendar approvedOn;


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_ON")
	private Calendar createdOn;

	@Column(name = "CREATED_BY_ID")
	private Long createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_MODIFIED_ON")
	private Calendar lastModifiedOn;

	@Column(name = "STATUS")
	private String status;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "PRJ_ALT_ID_SETION_15_SONE_FK")
	private List<Setion15StageOneModel> stageOneList;

	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "PRJ_ALT_ID_SETION_15_STWO_FK")
	private List<Setion15StageTwoModel> stageTwoList;
	
	@Column(name = "PR_STATE_CODE", length=25)
	private String stateCode;
	@Column(name = "PR_STATE_NAME", length=75)
	private String stateName;
	@Column(name = "PR_PNAME" , length=25)
	private String processName;
	
	@Column(name = "WFOID" , length=50)
	private String wfoId;
	@Column(name = "FIN_TEAM" , length=25)
	private String finTeam;
	@Column(name = "LG_TEAM" , length=25)
	private String legalTeam;
	@Column(name = "TPSR_TEAM" , length=25)
	private String tpSrTeam;
	@Column(name = "PR_FIN_STATE" , length=25)
	private String finState;
	@Column(name = "PR_TP_STATE" , length=25)
	private String tpState;
	@Column(name = "PR_LG_STATE" , length=25)
	private String legalState;

	@Column(name = "CREATED_BY" , length=100)
	private String createdByName;
	@Column(name = "PR_LAST_UPDATE_BY")
	private Long lastUpdatedBy;
	@Column(name = "PR_LAST_UPDATE_BY_NAME" , length=100)
	private String lastUpdatedByName;
	@Column(name = "PR_TEAM" , length=25)
	private String tpTeam;
	
	@Transient
	private String CahngeLandAreaFlag;
	
	
    public MofFormThreeModel getProjectFormThreeMof() {
		return projectFormThreeMof;
	}

	public void setProjectFormThreeMof(MofFormThreeModel projectFormThreeMof) {
		this.projectFormThreeMof = projectFormThreeMof;
	}
	
	public void setCahngeLandAreaFlag(String cahngeLandAreaFlag) {
		CahngeLandAreaFlag = cahngeLandAreaFlag;
	}
	
	public String getCahngeLandAreaFlag() {
		return CahngeLandAreaFlag;
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

	public String getProjectAltAckNo() {
		return projectAltAckNo;
	}

	public void setProjectAltAckNo(String projectAltAckNo) {
		this.projectAltAckNo = projectAltAckNo;
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
	
	public List<BlocksModel> getBlockList() {
		return blockList;
	}

	public void setBlockList(List<BlocksModel> blockList) {
		this.blockList = blockList;
	}

	public FormOneModel getFormOneModel() {
		return formOneModel;
	}

	public void setFormOneModel(FormOneModel formOneModel) {
		this.formOneModel = formOneModel;
	}

	public FormTwoModel getFormTwoModel() {
		return formTwoModel;
	}

	public void setFormTwoModel(FormTwoModel formTwoModel) {
		this.formTwoModel = formTwoModel;
	}

	public FormThreeModel getFormThreeModel() {
		return formThreeModel;
	}

	public void setFormThreeModel(FormThreeModel formThreeModel) {
		this.formThreeModel = formThreeModel;
	}

	public ProjectAlterationPaymentDetailsModel getPaymentDetailsModel() {
		return paymentDetailsModel;
	}

	public void setPaymentDetailsModel(ProjectAlterationPaymentDetailsModel paymentDetailsModel) {
		this.paymentDetailsModel = paymentDetailsModel;
	}

	public String getAltrStatus() {
		return altrStatus;
	}

	public void setAltrStatus(String altrStatus) {
		this.altrStatus = altrStatus;
	}

	public String getApplicationNo() {
		return applicationNo;
	}

	public void setApplicationNo(String applicationNo) {
		this.applicationNo = applicationNo;
	}

	public String getProjectAltRegistrationNo() {
		return projectAltRegistrationNo;
	}

	public void setProjectAltRegistrationNo(String projectAltRegistrationNo) {
		this.projectAltRegistrationNo = projectAltRegistrationNo;
	}

	public Date getAppSubmissionDate() {
		return appSubmissionDate;
	}

	public void setAppSubmissionDate(Date appSubmissionDate) {
		this.appSubmissionDate = appSubmissionDate;
	}

	public String getFinanceApprovedBy() {
		return financeApprovedBy;
	}

	public void setFinanceApprovedBy(String financeApprovedBy) {
		this.financeApprovedBy = financeApprovedBy;
	}

	public Calendar getFinanceApprovedOn() {
		return financeApprovedOn;
	}

	public void setFinanceApprovedOn(Calendar financeApprovedOn) {
		this.financeApprovedOn = financeApprovedOn;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public Calendar getApprovedOn() {
		return approvedOn;
	}

	public void setApprovedOn(Calendar approvedOn) {
		this.approvedOn = approvedOn;
	}

	public Calendar getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Calendar createdOn) {
		this.createdOn = createdOn;
	}



	public Calendar getLastModifiedOn() {
		return lastModifiedOn;
	}

	public void setLastModifiedOn(Calendar lastModifiedOn) {
		this.lastModifiedOn = lastModifiedOn;
	}




	public ProjectDetailModel getProjectDetailModel() {
		return projectDetailModel;
	}

	public void setProjectDetailModel(ProjectDetailModel projectDetailModel) {
		this.projectDetailModel = projectDetailModel;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	@Override
	public Long getId() {
		
		return this.projectAltrId;
	}

	@Override
	public Calendar getLastUpdatedOn() {
		// TODO Auto-generated method stub
		return this.lastModifiedOn;
	}

	@Override
	public void setLastUpdatedOn(Calendar cal) {
		this.lastModifiedOn=cal;
		
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

	public String getAlterationType() {
		return alterationType;
	}

	public void setAlterationType(String alterationType) {
		this.alterationType = alterationType;
	}

	public List<AllotteeDetailModel> getAllotteeList() {
		return allotteeList;
	}

	public void setAllotteeList(List<AllotteeDetailModel> allotteeList) {
		this.allotteeList = allotteeList;
	}

	public List<Setion15StageOneModel> getStageOneList() {
		return stageOneList;
	}

	public void setStageOneList(List<Setion15StageOneModel> stageOneList) {
		this.stageOneList = stageOneList;
	}

	public List<Setion15StageTwoModel> getStageTwoList() {
		return stageTwoList;
	}

	public void setStageTwoList(List<Setion15StageTwoModel> stageTwoList) {
		this.stageTwoList = stageTwoList;
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

	public StageTwoPaymentModel getStageTwoPayment() {
		return stageTwoPayment;
	}

	public void setStageTwoPayment(StageTwoPaymentModel stageTwoPayment) {
		this.stageTwoPayment = stageTwoPayment;
	}


	
	

}
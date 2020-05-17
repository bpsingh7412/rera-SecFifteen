package in.gov.projectaltsection15.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity(name = "Setion15StageOneModel")
@Table(name = "TL_PRJ_SECTION_15_STAGE_ONE")
public class Setion15StageOneModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1803590463071163237L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "PRJ_ALT_ID_SETION_15_SONE_FK")
	private Long projectAltrId;

	@Column(name = "REASON_FOR_TRANSFER")
	private String reaasonForTransfer;
	
	@Column(name = "OTHER_REASON",length=2000)
	private String otherReason;


	@Column(name = "ALLOTTEE_CONTENT_NOT_DOC_ID")
	private Long aloContentNotDocId;
	
	@Column(name = "ALLOTTEE_CONTENT_NOT_DOC_UID")
	private String aloContentNotDocUId;
	
	/*
	 * @Column(name = "PD_AUD_BAL_SHEET_DOC_1_ID") private Long
	 * auditedBalSheetDoc1Id;
	 * 
	 * @Column(name = "PD_AUD_BAL_SHEET_DOC_1_UID", length = 100) private String
	 * auditedBalSheetDoc1UId;
	 * 
	 * @Column(name = "PD_AUD_BAL_SHEET_DOC_2_ID") private Long
	 * auditedBalSheetDoc2_Id;
	 * 
	 * @Column(name = "PD_AUD_BAL_SHEET_DOC_2_UID", length = 100) private String
	 * auditedBalSheetDoc2_UId;
	 * 
	 * @Column(name = "PD_AUD_BAL_SHEET_DOC_3_ID") private Long
	 * auditedBalSheetDoc3Id;
	 * 
	 * @Column(name = "PD_AUD_BAL_SHEET_DOC_3_UID", length = 100) private String
	 * auditedBalSheetDoc3UId;
	 */

	@Column(name = "PD_AUDITED_BAL_SHEET_YEAR_DOC_1_ID")
	private Long auditedBalSheetYear1Id;

	@Column(name = "PD_AUDITED_BAL_SHEET_YEAR_DOC_1_UID", length = 100)
	private String auditedBalSheetYear1UId;

	@Column(name = "PD_AUDITED_BAL_SHEET_YEAR_DOC_2_ID")
	private Long auditedBalSheetYear2Id;

	@Column(name = "PD_AUDITED_BAL_SHEET_YEAR_DOC_2_UID", length = 100)
	private String auditedBalSheetYear2UId;

	@Column(name = "PD_AUDITED_BAL_SHEET_YEAR_DOC_3_ID")
	private Long auditedBalSheetYear3Id;

	@Column(name = "PD_AUDITED_BAL_SHEET_YEAR_DOC_3_UID", length = 100)
	private String auditedBalSheetYear3UId;

	/*
	 * @Column(name = "PD_AUD_PROFIT_LOSS_DOC_1_ID") private Long
	 * auditedProfitLossSheetDoc1Id;
	 * 
	 * @Column(name = "PD_AUD_PROFIT_LOSS_DOC_1_UID", length = 100) private String
	 * auditedProfitLossSheetDoc1UId;
	 * 
	 * @Column(name = "PD_AUD_PROFIT_LOSS_DOC_2_ID") private Long
	 * auditedProfitLossSheetDoc2Id;
	 * 
	 * @Column(name = "PD_AUD_PROFIT_LOSS_DOC_2_UID", length = 100) private String
	 * auditedProfitLossSheetDoc2UId;
	 * 
	 * @Column(name = "PD_AUD_PROFIT_LOSS_DOC_3_ID") private Long
	 * auditedProfitLossSheetDoc3Id;
	 * 
	 * @Column(name = "PD_AUD_PROFIT_LOSS_DOC_3_UID", length = 100) private String
	 * auditedProfitLossSheetDoc3UId;
	 */

	@Column(name = "PD_AUD_PROFIT_LOSS_YEAR_DOC_1_ID")
	private Long auditedProfitLossSheetYear1Id;

	@Column(name = "PD_AUD_PROFIT_LOSS_YEAR_DOC_1_UID", length = 100)
	private String auditedProfitLossSheetYear1UId;

	@Column(name = "PD_AUD_PROFIT_LOSS_YEAR_DOC_2_ID")
	private Long auditedProfitLossSheetYear2Id;

	@Column(name = "PD_AUD_PROFIT_LOSS_YEAR_DOC_2_UID")
	private String auditedProfitLossSheetYear2UId;

	@Column(name = "PD_AUD_PROFIT_LOSS_YEAR_DOC_3_ID")
	private Long auditedProfitLossSheetYear3Id;
	
	@Column(name = "PD_AUD_PROFIT_LOSS_YEAR_DOC_3_UID")
	private String auditedProfitLossSheetYear3UId;
	
	@Column(name = "PD_CASH_FLOW_STM_YEAR_DOC_1_ID")
	private Long cashFlowStmtYear1Id;

	@Column(name = "PD_CASH_FLOW_STM_YEAR_DOC_1_UID", length = 100)
	private String cashFlowStmtYear1UId;

	@Column(name = "PD_CASH_FLOW_STM_YEAR_DOC_2_ID")
	private Long cashFlowStmtYear2Id;

	@Column(name = "PD_CASH_FLOW_STM_YEAR_DOC_2_UID", length = 100)
	private String cashFlowStmtYear2UId;

	@Column(name = "PD_CASH_FLOW_STM_YEAR_DOC_3_ID")
	private Long cashFlowStmtYear3Id;

	@Column(name = "PD_CASH_FLOW_STM_YEAR_DOC_3_UID", length = 100)
	private String cashFlowStmtYear3UId;
	
	@Column(name = "PD_TRANSFER_AGGREMENT_ID")
	private Long transferAggrementDocId;

	@Column(name = "PD_TRANSFER_AGGREMENT_UID")
	private String transferAggrementDocUId;
	

	
	
	/*
	 * @Column(name = "PD_AUD_REPORT_DOC_1_ID") private Long auditedReportDoc1Id;
	 * 
	 * @Column(name = "PD_AUD_REPORT_DOC_1_UID") private String
	 * auditedReportDoc1UId;
	 * 
	 * @Column(name = "PD_AUD_REPORT_DOC_2_ID") private Long auditedReportDoc2Id;
	 * 
	 * @Column(name = "PD_AUD_REPORT_DOC_2_UID") private String
	 * auditedReportDoc2UId;
	 * 
	 * @Column(name = "PD_AUD_REPORT_DOC_3_ID") private Long auditedReportDoc3Id;
	 * 
	 * @Column(name = "PD_AUD_REPORT_DOC_3_UID") private String
	 * auditedReportDoc3UId;
	 */

	@Column(name = "PD_AUD_REPORT_YEAR_DOC_1_ID")
	private Long auditedReportYear1Id;

	@Column(name = "PD_AUD_REPORT_YEAR_DOC_1_UID")
	private String auditedReportYear1UId;

	@Column(name = "PD_AUD_REPORT_YEAR_DOC_2_ID")
	private Long auditedReportYear2Id;

	@Column(name = "PD_AUD_REPORT_YEAR_DOC_2_UID")
	private String auditedReportYear2UId;

	@Column(name = "PD_AUD_REPORT_YEAR_DOC_3_ID")
	private Long auditedReportYear3Id;

	@Column(name = "PD_AUD_REPORT_YEAR_DOC_3_UID")
	private String auditedReportYear3UId;
	
	
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
	
	@Column(name = "PR_ADDRESS")
	private String promoterAddress;
	
	@Column(name = "INTENDING_PRO_PAN")
	private String intendingPromoterPanNumber;
	
	@Column(name = "PROMOTER_PIN_CODE")
	private String promoterPinCode;
	
	@Column(name = "STATE_NAME")
	private String stateName;
	
	@Column(name = "DISTRICT_NAME")
	private String districtName;
	
	@Column(name = "TALUKA_NAME")
	private String talukaName;
	
	@Column(name = "ADDRESS_1")
	private String addLine1;
	
	@Column(name = "ADDRESS_2")
	private String addLine2;
	

	
	
	
	
	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getTalukaName() {
		return talukaName;
	}

	public void setTalukaName(String talukaName) {
		this.talukaName = talukaName;
	}

	public String getAddLine1() {
		return addLine1;
	}

	public void setAddLine1(String addLine1) {
		this.addLine1 = addLine1;
	}

	public String getAddLine2() {
		return addLine2;
	}

	public void setAddLine2(String addLine2) {
		this.addLine2 = addLine2;
	}

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_ON", updatable=false)
	private Calendar createdOn;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modifiedOn")
	private java.util.Calendar modifiedOn;

	@Column(name = "ERST_PROMO_AFFIDAVIT_DOC_ID")
	private Long ersPromaffidavitDocId;
	
	@Column(name = "ERST_PROMO_AFFIDAVIT_DOC_UID")
	private String ersPromaffidavitDocUId;
	
	@Column(name = "INTEND_PROMO_AFFIDAVIT_DOC_ID")
	private Long intendPromaffidavitDocId;
	
	@Column(name = "INTEND_PROMO_AFFIDAVIT_DOC_UID")
	private String intendPromaffidavitDocUId;
	
	@Column(name = "ENCUMBRANCE_DOC_ID")
	private Long encumbranceDocId;

	@Column(name = "ENCUMBRANCE_DOC_UID")
	private String encumbranceDocUId;
	
	@Column(name = "INTEND_EXPERIENCE_DOC_ID")
	private Long intendExperienceCertDocId;

	@Column(name = "INTEND_EXPERIENCE_DOC_UID")
	private String intendExperienceCertDocUId;

	@Column(name = "DIRECTORS_REPORT_YEAR_DOC_1_ID")
	private Long directersReportYear1Id;

	@Column(name = "DIRECTORS_REPORT_YEAR_DOC_1_UID")
	private String directersReportYear1UId;

	@Column(name = "DIRECTORS_REPORT_YEAR_DOC_2_ID")
	private Long directersReportYear2Id;

	@Column(name = "DIRECTORS_REPORT_YEAR_DOC_2_UID")
	private String directersReportYear2UId;

	@Column(name = "DIRECTORS_REPORT_YEAR_DOC_3_ID")
	private Long directersReportYear3Id;

	@Column(name = "DIRECTORS_REPORT_YEAR_DOC_3_UID")
	private String directersReportYear3UId;
	
	@Column(name = "ITR_RETURN_DOC_ID")
	private Long itrReturnDocId;

	@Column(name = "ITR_RETURN_DOC_UID")
	private String itrReturnDocUId;
	
	@Column(name = "ITR_RETURN_DOC_YEAR1_ID")
	private Long itrReturnDocYear1Id;

	@Column(name = "ITR_RETURN_DOC_YEAR1_UID")
	private String itrReturnDocYear1UId;
	
	@Column(name = "ITR_RETURN_DOC_YEAR2_ID")
	private Long itrReturnDocYear2Id;

	@Column(name = "ITR_RETURN_DOC_YEAR2_UID")
	private String itrReturnDocYear2UId;
	
	@Column(name = "ITR_RETURN_DOC_YEAR3_ID")
	private Long itrReturnDocYear3Id;

	@Column(name = "ITR_RETURN_DOC_YEAR3_UID")
	private String itrReturnDocYear3UId;	
	
	@Column(name = "FINANCIAL_YEAR_ONE") 		
	private String fYear1;
	
	@Column(name = "FINANCIAL_YEAR_TWO") 		
	private String fYear2;
	
	@Column(name = "FINANCIAL_YEAR_THREE") 		
	private String fYear3;
	
	@Column(name = "LAWYER_PAN_NO") 		
	private String lawyerPanNo;
	
	@Column(name = "ENC_CERT_DOC_ISSUER_DATE")
	private String encumbranceCertificateDocIssuanceDate;

	@Column(name = "ENC_CERT_DOC_ISSUER_NAME")
	private String encumbranceCertificateDocIssuerName;
	
	@Column(name = "ENC_CERT_DOC_CONTACT")
	private String encumbranceCertificateDocContact;
	
	public String getfYear1() {
		return fYear1;
	}

	public void setfYear1(String fYear1) {
		this.fYear1 = fYear1;
	}

	public String getfYear2() {
		return fYear2;
	}

	public void setfYear2(String fYear2) {
		this.fYear2 = fYear2;
	}

	public String getfYear3() {
		return fYear3;
	}

	public void setfYear3(String fYear3) {
		this.fYear3 = fYear3;
	}

	public Long getItrReturnDocId() {
		return itrReturnDocId;
	}

	public void setItrReturnDocId(Long itrReturnDocId) {
		this.itrReturnDocId = itrReturnDocId;
	}

	public String getItrReturnDocUId() {
		return itrReturnDocUId;
	}

	public void setItrReturnDocUId(String itrReturnDocUId) {
		this.itrReturnDocUId = itrReturnDocUId;
	}

	public Long getErsPromaffidavitDocId() {
		return ersPromaffidavitDocId;
	}

	public void setErsPromaffidavitDocId(Long ersPromaffidavitDocId) {
		this.ersPromaffidavitDocId = ersPromaffidavitDocId;
	}

	public String getErsPromaffidavitDocUId() {
		return ersPromaffidavitDocUId;
	}

	public void setErsPromaffidavitDocUId(String ersPromaffidavitDocUId) {
		this.ersPromaffidavitDocUId = ersPromaffidavitDocUId;
	}

	public Long getIntendPromaffidavitDocId() {
		return intendPromaffidavitDocId;
	}

	public void setIntendPromaffidavitDocId(Long intendPromaffidavitDocId) {
		this.intendPromaffidavitDocId = intendPromaffidavitDocId;
	}

	public String getIntendPromaffidavitDocUId() {
		return intendPromaffidavitDocUId;
	}

	public void setIntendPromaffidavitDocUId(String intendPromaffidavitDocUId) {
		this.intendPromaffidavitDocUId = intendPromaffidavitDocUId;
	}

	public Long getEncumbranceDocId() {
		return encumbranceDocId;
	}

	public void setEncumbranceDocId(Long encumbranceDocId) {
		this.encumbranceDocId = encumbranceDocId;
	}

	public String getEncumbranceDocUId() {
		return encumbranceDocUId;
	}

	public void setEncumbranceDocUId(String encumbranceDocUId) {
		this.encumbranceDocUId = encumbranceDocUId;
	}

	public Long getIntendExperienceCertDocId() {
		return intendExperienceCertDocId;
	}

	public void setIntendExperienceCertDocId(Long intendExperienceCertDocId) {
		this.intendExperienceCertDocId = intendExperienceCertDocId;
	}

	public String getIntendExperienceCertDocUId() {
		return intendExperienceCertDocUId;
	}

	public void setIntendExperienceCertDocUId(String intendExperienceCertDocUId) {
		this.intendExperienceCertDocUId = intendExperienceCertDocUId;
	}

	public Long getDirectersReportYear1Id() {
		return directersReportYear1Id;
	}

	public void setDirectersReportYear1Id(Long directersReportYear1Id) {
		this.directersReportYear1Id = directersReportYear1Id;
	}

	public String getDirectersReportYear1UId() {
		return directersReportYear1UId;
	}

	public void setDirectersReportYear1UId(String directersReportYear1UId) {
		this.directersReportYear1UId = directersReportYear1UId;
	}

	public Long getDirectersReportYear2Id() {
		return directersReportYear2Id;
	}

	public void setDirectersReportYear2Id(Long directersReportYear2Id) {
		this.directersReportYear2Id = directersReportYear2Id;
	}

	public String getDirectersReportYear2UId() {
		return directersReportYear2UId;
	}

	public void setDirectersReportYear2UId(String directersReportYear2UId) {
		this.directersReportYear2UId = directersReportYear2UId;
	}

	public Long getDirectersReportYear3Id() {
		return directersReportYear3Id;
	}

	public void setDirectersReportYear3Id(Long directersReportYear3Id) {
		this.directersReportYear3Id = directersReportYear3Id;
	}

	public String getDirectersReportYear3UId() {
		return directersReportYear3UId;
	}

	public void setDirectersReportYear3UId(String directersReportYear3UId) {
		this.directersReportYear3UId = directersReportYear3UId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProjectAltrId() {
		return projectAltrId;
	}

	public void setProjectAltrId(Long projectAltrId) {
		this.projectAltrId = projectAltrId;
	}

	public String getReaasonForTransfer() {
		return reaasonForTransfer;
	}

	public void setReaasonForTransfer(String reaasonForTransfer) {
		this.reaasonForTransfer = reaasonForTransfer;
	}

	public Long getAloContentNotDocId() {
		return aloContentNotDocId;
	}

	public void setAloContentNotDocId(Long aloContentNotDocId) {
		this.aloContentNotDocId = aloContentNotDocId;
	}

	public String getAloContentNotDocUId() {
		return aloContentNotDocUId;
	}

	public void setAloContentNotDocUId(String aloContentNotDocUId) {
		this.aloContentNotDocUId = aloContentNotDocUId;
	}

	public Long getAuditedBalSheetYear1Id() {
		return auditedBalSheetYear1Id;
	}

	public void setAuditedBalSheetYear1Id(Long auditedBalSheetYear1Id) {
		this.auditedBalSheetYear1Id = auditedBalSheetYear1Id;
	}

	public String getAuditedBalSheetYear1UId() {
		return auditedBalSheetYear1UId;
	}

	public void setAuditedBalSheetYear1UId(String auditedBalSheetYear1UId) {
		this.auditedBalSheetYear1UId = auditedBalSheetYear1UId;
	}

	public Long getAuditedBalSheetYear2Id() {
		return auditedBalSheetYear2Id;
	}

	public void setAuditedBalSheetYear2Id(Long auditedBalSheetYear2Id) {
		this.auditedBalSheetYear2Id = auditedBalSheetYear2Id;
	}

	public String getAuditedBalSheetYear2UId() {
		return auditedBalSheetYear2UId;
	}

	public void setAuditedBalSheetYear2UId(String auditedBalSheetYear2UId) {
		this.auditedBalSheetYear2UId = auditedBalSheetYear2UId;
	}

	public Long getAuditedBalSheetYear3Id() {
		return auditedBalSheetYear3Id;
	}

	public void setAuditedBalSheetYear3Id(Long auditedBalSheetYear3Id) {
		this.auditedBalSheetYear3Id = auditedBalSheetYear3Id;
	}

	public String getAuditedBalSheetYear3UId() {
		return auditedBalSheetYear3UId;
	}

	public void setAuditedBalSheetYear3UId(String auditedBalSheetYear3UId) {
		this.auditedBalSheetYear3UId = auditedBalSheetYear3UId;
	}

	public Long getAuditedProfitLossSheetYear1Id() {
		return auditedProfitLossSheetYear1Id;
	}

	public void setAuditedProfitLossSheetYear1Id(Long auditedProfitLossSheetYear1Id) {
		this.auditedProfitLossSheetYear1Id = auditedProfitLossSheetYear1Id;
	}

	public String getAuditedProfitLossSheetYear1UId() {
		return auditedProfitLossSheetYear1UId;
	}

	public void setAuditedProfitLossSheetYear1UId(String auditedProfitLossSheetYear1UId) {
		this.auditedProfitLossSheetYear1UId = auditedProfitLossSheetYear1UId;
	}

	public Long getAuditedProfitLossSheetYear2Id() {
		return auditedProfitLossSheetYear2Id;
	}

	public void setAuditedProfitLossSheetYear2Id(Long auditedProfitLossSheetYear2Id) {
		this.auditedProfitLossSheetYear2Id = auditedProfitLossSheetYear2Id;
	}

	public String getAuditedProfitLossSheetYear2UId() {
		return auditedProfitLossSheetYear2UId;
	}

	public void setAuditedProfitLossSheetYear2UId(String auditedProfitLossSheetYear2UId) {
		this.auditedProfitLossSheetYear2UId = auditedProfitLossSheetYear2UId;
	}

	public Long getAuditedProfitLossSheetYear3Id() {
		return auditedProfitLossSheetYear3Id;
	}

	public void setAuditedProfitLossSheetYear3Id(Long auditedProfitLossSheetYear3Id) {
		this.auditedProfitLossSheetYear3Id = auditedProfitLossSheetYear3Id;
	}

	public String getAuditedProfitLossSheetYear3UId() {
		return auditedProfitLossSheetYear3UId;
	}

	public void setAuditedProfitLossSheetYear3UId(String auditedProfitLossSheetYear3UId) {
		this.auditedProfitLossSheetYear3UId = auditedProfitLossSheetYear3UId;
	}

	public Long getCashFlowStmtYear1Id() {
		return cashFlowStmtYear1Id;
	}

	public void setCashFlowStmtYear1Id(Long cashFlowStmtYear1Id) {
		this.cashFlowStmtYear1Id = cashFlowStmtYear1Id;
	}

	public String getCashFlowStmtYear1UId() {
		return cashFlowStmtYear1UId;
	}

	public void setCashFlowStmtYear1UId(String cashFlowStmtYear1UId) {
		this.cashFlowStmtYear1UId = cashFlowStmtYear1UId;
	}

	public Long getCashFlowStmtYear2Id() {
		return cashFlowStmtYear2Id;
	}

	public void setCashFlowStmtYear2Id(Long cashFlowStmtYear2Id) {
		this.cashFlowStmtYear2Id = cashFlowStmtYear2Id;
	}

	public String getCashFlowStmtYear2UId() {
		return cashFlowStmtYear2UId;
	}

	public void setCashFlowStmtYear2UId(String cashFlowStmtYear2UId) {
		this.cashFlowStmtYear2UId = cashFlowStmtYear2UId;
	}

	public Long getCashFlowStmtYear3Id() {
		return cashFlowStmtYear3Id;
	}

	public void setCashFlowStmtYear3Id(Long cashFlowStmtYear3Id) {
		this.cashFlowStmtYear3Id = cashFlowStmtYear3Id;
	}

	public String getCashFlowStmtYear3UId() {
		return cashFlowStmtYear3UId;
	}

	public void setCashFlowStmtYear3UId(String cashFlowStmtYear3UId) {
		this.cashFlowStmtYear3UId = cashFlowStmtYear3UId;
	}

	public Long getTransferAggrementDocId() {
		return transferAggrementDocId;
	}

	public void setTransferAggrementDocId(Long transferAggrementDocId) {
		this.transferAggrementDocId = transferAggrementDocId;
	}

	public String getTransferAggrementDocUId() {
		return transferAggrementDocUId;
	}

	public void setTransferAggrementDocUId(String transferAggrementDocUId) {
		this.transferAggrementDocUId = transferAggrementDocUId;
	}

	public Long getAuditedReportYear1Id() {
		return auditedReportYear1Id;
	}

	public void setAuditedReportYear1Id(Long auditedReportYear1Id) {
		this.auditedReportYear1Id = auditedReportYear1Id;
	}

	public String getAuditedReportYear1UId() {
		return auditedReportYear1UId;
	}

	public void setAuditedReportYear1UId(String auditedReportYear1UId) {
		this.auditedReportYear1UId = auditedReportYear1UId;
	}

	public Long getAuditedReportYear2Id() {
		return auditedReportYear2Id;
	}

	public void setAuditedReportYear2Id(Long auditedReportYear2Id) {
		this.auditedReportYear2Id = auditedReportYear2Id;
	}

	public String getAuditedReportYear2UId() {
		return auditedReportYear2UId;
	}

	public void setAuditedReportYear2UId(String auditedReportYear2UId) {
		this.auditedReportYear2UId = auditedReportYear2UId;
	}

	public Long getAuditedReportYear3Id() {
		return auditedReportYear3Id;
	}

	public void setAuditedReportYear3Id(Long auditedReportYear3Id) {
		this.auditedReportYear3Id = auditedReportYear3Id;
	}

	public String getAuditedReportYear3UId() {
		return auditedReportYear3UId;
	}

	public void setAuditedReportYear3UId(String auditedReportYear3UId) {
		this.auditedReportYear3UId = auditedReportYear3UId;
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

	public Calendar getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Calendar createdOn) {
		this.createdOn = createdOn;
	}

	public java.util.Calendar getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(java.util.Calendar modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public String getPromoterAddress() {
		return promoterAddress;
	}

	public void setPromoterAddress(String promoterAddress) {
		this.promoterAddress = promoterAddress;
	}

	public String getOtherReason() {
		return otherReason;
	}

	public void setOtherReason(String otherReason) {
		this.otherReason = otherReason;
	}

	public String getLawyerPanNo() {
		return lawyerPanNo;
	}

	public void setLawyerPanNo(String lawyerPanNo) {
		this.lawyerPanNo = lawyerPanNo;
	}

	public String getEncumbranceCertificateDocIssuanceDate() {
		return encumbranceCertificateDocIssuanceDate;
	}

	public void setEncumbranceCertificateDocIssuanceDate(String encumbranceCertificateDocIssuanceDate) {
		this.encumbranceCertificateDocIssuanceDate = encumbranceCertificateDocIssuanceDate;
	}

	public String getEncumbranceCertificateDocIssuerName() {
		return encumbranceCertificateDocIssuerName;
	}

	public void setEncumbranceCertificateDocIssuerName(String encumbranceCertificateDocIssuerName) {
		this.encumbranceCertificateDocIssuerName = encumbranceCertificateDocIssuerName;
	}

	public String getEncumbranceCertificateDocContact() {
		return encumbranceCertificateDocContact;
	}

	public void setEncumbranceCertificateDocContact(String encumbranceCertificateDocContact) {
		this.encumbranceCertificateDocContact = encumbranceCertificateDocContact;
	}

	public Long getItrReturnDocYear1Id() {
		return itrReturnDocYear1Id;
	}

	public void setItrReturnDocYear1Id(Long itrReturnDocYear1Id) {
		this.itrReturnDocYear1Id = itrReturnDocYear1Id;
	}

	public String getItrReturnDocYear1UId() {
		return itrReturnDocYear1UId;
	}

	public void setItrReturnDocYear1UId(String itrReturnDocYear1UId) {
		this.itrReturnDocYear1UId = itrReturnDocYear1UId;
	}

	public Long getItrReturnDocYear2Id() {
		return itrReturnDocYear2Id;
	}

	public void setItrReturnDocYear2Id(Long itrReturnDocYear2Id) {
		this.itrReturnDocYear2Id = itrReturnDocYear2Id;
	}

	public String getItrReturnDocYear2UId() {
		return itrReturnDocYear2UId;
	}

	public void setItrReturnDocYear2UId(String itrReturnDocYear2UId) {
		this.itrReturnDocYear2UId = itrReturnDocYear2UId;
	}

	public Long getItrReturnDocYear3Id() {
		return itrReturnDocYear3Id;
	}

	public void setItrReturnDocYear3Id(Long itrReturnDocYear3Id) {
		this.itrReturnDocYear3Id = itrReturnDocYear3Id;
	}

	public String getItrReturnDocYear3UId() {
		return itrReturnDocYear3UId;
	}

	public void setItrReturnDocYear3UId(String itrReturnDocYear3UId) {
		this.itrReturnDocYear3UId = itrReturnDocYear3UId;
	}

	public String getIntendingPromoterPanNumber() {
		return intendingPromoterPanNumber;
	}

	public void setIntendingPromoterPanNumber(String intendingPromoterPanNumber) {
		this.intendingPromoterPanNumber = intendingPromoterPanNumber;
	}

	public String getPromoterPinCode() {
		return promoterPinCode;
	}

	public void setPromoterPinCode(String promoterPinCode) {
		this.promoterPinCode = promoterPinCode;
	}

	
	
}

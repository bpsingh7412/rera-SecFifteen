package in.gov.projectaltsection15.model;

import java.io.Serializable;
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
import javax.persistence.Table;

@Entity(name = "Setion15StageTwoModel")
@Table(name = "TL_PRJ_SECTION_15_STAGE_TWO")
public class Setion15StageTwoModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1803590463071163237L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long stageTwoId;

	@Column(name = "PRJ_ALT_ID_SETION_15_STWO_FK")
	private Long projectAltrId;

	@Column(name = "AFFIDAVIT_DOC_ID")
	private Long affidavitDocId;
	
	@Column(name = "AFFIDAVIT_DOC_UID")
	private String affidavitDocUId;

	@Column(name = "FORMB_DOC_ID")
	private Long formBDocId;
	
	@Column(name = "FORMB_DOC_UID")
	private String formBDocUId;	

	@Column(name = "FORMB1_DOC_ID")
	private Long formB1DocId;
	
	@Column(name = "FORMB1_DOC_UID")
	private String formB1DocUId;	
	
	@Column(name = "FORMB2_DOC_ID")
	private Long formB2DocId;
	
	@Column(name = "FORMB2_DOC_UID")
	private String formB2DocUId;	
	
	@Column(name = "LAND_DOC_ID")
	private Long landDocId;
	
	@Column(name = "LAND_DOC_UID")
	private String landDocUId;	

	@Column(name = "AFS_DOC_ID")
	private Long afsDocId;
	
	@Column(name = "AFS_DOC_UID")
	private String afsDocUId;	

	@Column(name = "SALE_DEED_DOC_ID")
	private Long saleDeedDocId;
	
	@Column(name = "SALE_DEED_DOC_UID")
	private String saleDeedDocUId;
	
	@Column(name = "ALLOTMENT_DOC_ID")
	private Long allotmentDocId;
	
	@Column(name = "ALLOTMENT_DOC_UID")
	private String allotmentDocUId;
	
	@Column(name = "AMENDED_TITLE_DOC_ID")
	private Long amendedTitleDocId;
	
	@Column(name = "AMENDED_TITLE_DOC_UID")
	private String amendedTitleDocUId;

	@Column(name = "AMENDED_BUILDING_DOC_ID")
	private Long amendedBuildingDocId;
	
	@Column(name = "AMENDED_BUILDING_DOC_UID")
	private String amendedBuildingDocUId;
	
	@Column(name = "BCR_ACK_NO")
	private String bcrAckNo;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "STAGE_TWO_BANK_NEW_PRM_FK")
	private List<ProjectSection15BankDetails> newPrmoBankDtl;	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "STAGE_TWO_AUTH_SIGN_FK")
	private List<AuthorizedSignatoryDtlModel> authSignList;	

	
	@Column(name = "PRJ_HEAD_PHOTO_DOC_ID")
	private Long prjHeadPhotoDocId;
	
	@Column(name = "PRJ_HEAD_PHOTO_DOC_UID")
	private String prjHeadPhotoDocUId;
	
	@Column(name = "DRAFT_VOUCHER_DOC_ID")
	private Long draftVoucherDocId;
	
	@Column(name = "DRAFT_VOUCHER_DOC_UID")
	private String draftVoucherDocUId;

	@Column(name = "EXECUTED_AGGREMENT_DOC_ID")
	private Long executedAggrementDocId;
	
	@Column(name = "EXECUTED_AGGREMENT_DOC_UID")
	private String executedAggrementDocUId;

	@Column(name = "ENCUMBRANCE_DOC_ID")
	private Long encumbranceDocId;

	@Column(name = "ENCUMBRANCE_DOC_UID")
	private String encumbranceDocUId;
	
	@Column(name = "SEVEN_TWELVE_DOC_ID")
	private Long sevenTwelveDocId;

	@Column(name = "SEVEN_TWELVE_DOC_UID")
	private String sevenTwelveDocUId;
	
	@Column(name = "TITLE_CLEARANCE_DOC_ID")
	private Long titleClearanceDocId;

	@Column(name = "TITLE_CLEARANCE_DOC_UID")
	private String titleClearanceDocUId;
	
	@Column(name = "TITLE_REPORT_DOC_ID")
	private Long titleReportDocId;

	@Column(name = "TITLE_REPORT_DOC_UID")
	private String titleReportDocUId;
	
	@Column(name = "REG_DEV_AGG_DOC_ID")
	private Long regDevAggrementDocId;

	@Column(name = "REG_DEV_AGG_DOC_UID")
	private String regDevAggrementUId;
	
	@Column(name = "PER_FOR_ALO_DOC_ID")
	private Long perForAlloDocId;

	@Column(name = "PER_FOR_ALO_DOC_UID")
	private String perForAlloDocUId;
	
	@Column(name = "PER_FOR_SALE_AGR_DOC_ID")
	private Long perForSaleAgrDocId;

	@Column(name = "PER_FOR_SALE_AGR_DOC_UID")
	private String perForSaleAgrDocUId;
	
	@Column(name = "PER_FOR_SALE_DEED_DOC_ID")
	private Long perForSaleDeedDocId;

	@Column(name = "PER_FOR_SALE_DEED_DOC_UID")
	private String perForSaleDeedDocUId;
	
	@Column(name = "LAND_PROMOTER_PAN_NO")
	private String landPromoterPanNo;
	
	@Column(name = "LAND_ISSUANCE_DATE")
	private String landIssuanceDate;
	
	@Column(name = "LAND_ISSUANCE_DOC_NAME")
	private String landDocIssuerName;
	
	@Column(name = "LAND_DOC_CONTACT")
	private String landDocContact;
	
	@Column(name = "FORM_PROMOTER_PAN")
	private String formPromoterPanNo;
	
	@Column(name = "DECL_FORM_DOC_ISSU_DATE")
	private String declarationFormbDocIssuanceDate;
	
	@Column(name = "DECL_FORM_ISSU_NAME")
	private String declarationFormbIssuerName;
	
	@Column(name = "DECL_FORM_ISSU_CONTACT")
	private String declarationFormbIssuerCONTACT;
	
	@Column(name = "FORM_B1_PROMOTER_PAN")
	private String formB1PromoterPanNo;
	
	@Column(name = "DECL_FORMB1_ISSURANCE")
	private String declarationFormB1Issurance;
	
	@Column(name = "DECL_FORMB1_ISSURANCE_NAME")
	private String declarationFormB1IssurName;
	
	@Column(name = "DECL_FORMB1_ISSURANCE_CONTACT")
	private String declarationFormB1Contact;
	
	@Column(name = "DECL_FORMB2_ISSURANCE")
	private String declarationFormB2Issurance;

	@Column(name = "DECL_FORMB2_ISSURANCE_NAME")
	private String declarationFormB2IssurName;
	
	@Column(name = "DECL_FORMB2_LAND_NAME")
	private String declarationFormB2LandName;
	
	@Column(name = "DECL_FORMB2_CONTACT")
	private String declarationFormB2Contact;
	
	@Column(name = "LAWYER_PAN_NO")
	private String lawyerPanNo;
	
	@Column(name = "ENC_CERT_DOC_ISSUR_DATE")
	private String encumbranceCertificateDocIssuanceDate;
	
	@Column(name = "ENC_CERT_DOC_ISSUR_NAME")
	private String encumbranceCertificateDocIssuerName;
	
	@Column(name = "ENC_CERT_DOC_ISSUR_CONTACT")
	private String encumbranceCertificateDocContact;
	
	@Column(name = "TITLE_CLR_LAWYER_PAN")
	private String titleClearLawyerPanNo;
	
	@Column(name = "TITLE_CLR_CERT_ISSU_DATE")
	private String titleClearanceCertificateIssuanceDate;
	
	@Column(name = "TITLE_CLR_CERT_ISSU_NAME")
	private String titleClearanceCertificateIssuerName;
	
	@Column(name = "TITLE_CLR_CERT_ISSU_CONTACT")
	private String titleClearanceCertificateContact;
	
	@Column(name = "TITLE_LAWYER_PAN")
	private String titleLawyerPanNo;
	
	@Column(name = "TITLE_REPORT_ISSUE_DATE")
	private String titleReportIssueDate;
	
	@Column(name = "TITLE_REPORT_ISSUE_NAME")
	private String titleReportIssuerName;
	
	@Column(name = "TITLE_REPORT_CONTACT")
	private String titleReportContact;
	
	@Column(name = "PROP_CARD_FLAG")
	private String propertyCardIdFlag;
	
	@Column(name = "PROP_CARD_ID_THREE")
	private Long propertyCardId3;
	
	@Column(name = "PROP_CARD_UID_THREE")
	private String propertyCardUId3;
	
	@Column(name = "PROP_CARD_ID")
	private Long propertyCardId;
	
	@Column(name = "PROP_CARD_UID")
	private String propertyCardUId;
	
	@Column(name = "PROP_CARD_ID_TWO")
	private Long propertyCardId2;
	
	@Column(name = "PROP_CARD_UID_TWO")
	private String propertyCardUId2;
	
	@Column(name = "FORM_B2_PROMOTER_PAN")
	private String formB2PromoterPanNo;
		
	//project-summary
	
	public Long getPrjHeadPhotoDocId() {
		return prjHeadPhotoDocId;
	}

	public void setPrjHeadPhotoDocId(Long prjHeadPhotoDocId) {
		this.prjHeadPhotoDocId = prjHeadPhotoDocId;
	}

	public String getPrjHeadPhotoDocUId() {
		return prjHeadPhotoDocUId;
	}

	public void setPrjHeadPhotoDocUId(String prjHeadPhotoDocUId) {
		this.prjHeadPhotoDocUId = prjHeadPhotoDocUId;
	}

	public Long getDraftVoucherDocId() {
		return draftVoucherDocId;
	}

	public void setDraftVoucherDocId(Long draftVoucherDocId) {
		this.draftVoucherDocId = draftVoucherDocId;
	}

	public String getDraftVoucherDocUId() {
		return draftVoucherDocUId;
	}

	public void setDraftVoucherDocUId(String draftVoucherDocUId) {
		this.draftVoucherDocUId = draftVoucherDocUId;
	}

	public Long getExecutedAggrementDocId() {
		return executedAggrementDocId;
	}

	public void setExecutedAggrementDocId(Long executedAggrementDocId) {
		this.executedAggrementDocId = executedAggrementDocId;
	}

	public String getExecutedAggrementDocUId() {
		return executedAggrementDocUId;
	}

	public void setExecutedAggrementDocUId(String executedAggrementDocUId) {
		this.executedAggrementDocUId = executedAggrementDocUId;
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

	public Long getSevenTwelveDocId() {
		return sevenTwelveDocId;
	}

	public void setSevenTwelveDocId(Long sevenTwelveDocId) {
		this.sevenTwelveDocId = sevenTwelveDocId;
	}

	public String getSevenTwelveDocUId() {
		return sevenTwelveDocUId;
	}

	public void setSevenTwelveDocUId(String sevenTwelveDocUId) {
		this.sevenTwelveDocUId = sevenTwelveDocUId;
	}

	public Long getTitleClearanceDocId() {
		return titleClearanceDocId;
	}

	public void setTitleClearanceDocId(Long titleClearanceDocId) {
		this.titleClearanceDocId = titleClearanceDocId;
	}

	public String getTitleClearanceDocUId() {
		return titleClearanceDocUId;
	}

	public void setTitleClearanceDocUId(String titleClearanceDocUId) {
		this.titleClearanceDocUId = titleClearanceDocUId;
	}

	public Long getTitleReportDocId() {
		return titleReportDocId;
	}

	public void setTitleReportDocId(Long titleReportDocId) {
		this.titleReportDocId = titleReportDocId;
	}

	public String getTitleReportDocUId() {
		return titleReportDocUId;
	}

	public void setTitleReportDocUId(String titleReportDocUId) {
		this.titleReportDocUId = titleReportDocUId;
	}

	public Long getRegDevAggrementDocId() {
		return regDevAggrementDocId;
	}

	public void setRegDevAggrementDocId(Long regDevAggrementDocId) {
		this.regDevAggrementDocId = regDevAggrementDocId;
	}

	public String getRegDevAggrementUId() {
		return regDevAggrementUId;
	}

	public void setRegDevAggrementUId(String regDevAggrementUId) {
		this.regDevAggrementUId = regDevAggrementUId;
	}

	public Long getPerForAlloDocId() {
		return perForAlloDocId;
	}

	public void setPerForAlloDocId(Long perForAlloDocId) {
		this.perForAlloDocId = perForAlloDocId;
	}

	public String getPerForAlloDocUId() {
		return perForAlloDocUId;
	}

	public void setPerForAlloDocUId(String perForAlloDocUId) {
		this.perForAlloDocUId = perForAlloDocUId;
	}

	public Long getPerForSaleAgrDocId() {
		return perForSaleAgrDocId;
	}

	public void setPerForSaleAgrDocId(Long perForSaleAgrDocId) {
		this.perForSaleAgrDocId = perForSaleAgrDocId;
	}

	public String getPerForSaleAgrDocUId() {
		return perForSaleAgrDocUId;
	}

	public void setPerForSaleAgrDocUId(String perForSaleAgrDocUId) {
		this.perForSaleAgrDocUId = perForSaleAgrDocUId;
	}

	public Long getPerForSaleDeedDocId() {
		return perForSaleDeedDocId;
	}

	public void setPerForSaleDeedDocId(Long perForSaleDeedDocId) {
		this.perForSaleDeedDocId = perForSaleDeedDocId;
	}

	public String getPerForSaleDeedDocUId() {
		return perForSaleDeedDocUId;
	}

	public void setPerForSaleDeedDocUId(String perForSaleDeedDocUId) {
		this.perForSaleDeedDocUId = perForSaleDeedDocUId;
	}

	public Long getProjectAltrId() {
		return projectAltrId;
	}

	public void setProjectAltrId(Long projectAltrId) {
		this.projectAltrId = projectAltrId;
	}

	public Long getAffidavitDocId() {
		return affidavitDocId;
	}

	public void setAffidavitDocId(Long affidavitDocId) {
		this.affidavitDocId = affidavitDocId;
	}

	public String getAffidavitDocUId() {
		return affidavitDocUId;
	}

	public void setAffidavitDocUId(String affidavitDocUId) {
		this.affidavitDocUId = affidavitDocUId;
	}

	public Long getFormBDocId() {
		return formBDocId;
	}

	public void setFormBDocId(Long formBDocId) {
		this.formBDocId = formBDocId;
	}

	public String getFormBDocUId() {
		return formBDocUId;
	}

	public void setFormBDocUId(String formBDocUId) {
		this.formBDocUId = formBDocUId;
	}

	public Long getFormB1DocId() {
		return formB1DocId;
	}

	public void setFormB1DocId(Long formB1DocId) {
		this.formB1DocId = formB1DocId;
	}

	public String getFormB1DocUId() {
		return formB1DocUId;
	}

	public void setFormB1DocUId(String formB1DocUId) {
		this.formB1DocUId = formB1DocUId;
	}

	public Long getFormB2DocId() {
		return formB2DocId;
	}

	public void setFormB2DocId(Long formB2DocId) {
		this.formB2DocId = formB2DocId;
	}

	public String getFormB2DocUId() {
		return formB2DocUId;
	}

	public void setFormB2DocUId(String formB2DocUId) {
		this.formB2DocUId = formB2DocUId;
	}

	public Long getLandDocId() {
		return landDocId;
	}

	public void setLandDocId(Long landDocId) {
		this.landDocId = landDocId;
	}

	public String getLandDocUId() {
		return landDocUId;
	}

	public void setLandDocUId(String landDocUId) {
		this.landDocUId = landDocUId;
	}

	public Long getAfsDocId() {
		return afsDocId;
	}

	public void setAfsDocId(Long afsDocId) {
		this.afsDocId = afsDocId;
	}

	public String getAfsDocUId() {
		return afsDocUId;
	}

	public void setAfsDocUId(String afsDocUId) {
		this.afsDocUId = afsDocUId;
	}

	public Long getSaleDeedDocId() {
		return saleDeedDocId;
	}

	public void setSaleDeedDocId(Long saleDeedDocId) {
		this.saleDeedDocId = saleDeedDocId;
	}

	public String getSaleDeedDocUId() {
		return saleDeedDocUId;
	}

	public void setSaleDeedDocUId(String saleDeedDocUId) {
		this.saleDeedDocUId = saleDeedDocUId;
	}

	public Long getAllotmentDocId() {
		return allotmentDocId;
	}

	public void setAllotmentDocId(Long allotmentDocId) {
		this.allotmentDocId = allotmentDocId;
	}

	public String getAllotmentDocUId() {
		return allotmentDocUId;
	}

	public void setAllotmentDocUId(String allotmentDocUId) {
		this.allotmentDocUId = allotmentDocUId;
	}

	public Long getAmendedTitleDocId() {
		return amendedTitleDocId;
	}

	public void setAmendedTitleDocId(Long amendedTitleDocId) {
		this.amendedTitleDocId = amendedTitleDocId;
	}

	public String getAmendedTitleDocUId() {
		return amendedTitleDocUId;
	}

	public void setAmendedTitleDocUId(String amendedTitleDocUId) {
		this.amendedTitleDocUId = amendedTitleDocUId;
	}

	public Long getAmendedBuildingDocId() {
		return amendedBuildingDocId;
	}

	public void setAmendedBuildingDocId(Long amendedBuildingDocId) {
		this.amendedBuildingDocId = amendedBuildingDocId;
	}

	public String getAmendedBuildingDocUId() {
		return amendedBuildingDocUId;
	}

	public void setAmendedBuildingDocUId(String amendedBuildingDocUId) {
		this.amendedBuildingDocUId = amendedBuildingDocUId;
	}

	public String getBcrAckNo() {
		return bcrAckNo;
	}

	public void setBcrAckNo(String bcrAckNo) {
		this.bcrAckNo = bcrAckNo;
	}

	public List<ProjectSection15BankDetails> getNewPrmoBankDtl() {
		return newPrmoBankDtl;
	}

	public void setNewPrmoBankDtl(List<ProjectSection15BankDetails> newPrmoBankDtl) {
		this.newPrmoBankDtl = newPrmoBankDtl;
	}

	public Long getStageTwoId() {
		return stageTwoId;
	}

	public void setStageTwoId(Long stageTwoId) {
		this.stageTwoId = stageTwoId;
	}

	public List<AuthorizedSignatoryDtlModel> getAuthSignList() {
		return authSignList;
	}

	public void setAuthSignList(List<AuthorizedSignatoryDtlModel> authSignList) {
		this.authSignList = authSignList;
	}

	public String getLandIssuanceDate() {
		return landIssuanceDate;
	}

	public void setLandIssuanceDate(String landIssuanceDate) {
		this.landIssuanceDate = landIssuanceDate;
	}

	public String getLandDocIssuerName() {
		return landDocIssuerName;
	}

	public void setLandDocIssuerName(String landDocIssuerName) {
		this.landDocIssuerName = landDocIssuerName;
	}

	public String getLandDocContact() {
		return landDocContact;
	}

	public void setLandDocContact(String landDocContact) {
		this.landDocContact = landDocContact;
	}
	
	public String getDeclarationFormbDocIssuanceDate() {
		return declarationFormbDocIssuanceDate;
	}

	public void setDeclarationFormbDocIssuanceDate(String declarationFormbDocIssuanceDate) {
		this.declarationFormbDocIssuanceDate = declarationFormbDocIssuanceDate;
	}

	public String getDeclarationFormbIssuerName() {
		return declarationFormbIssuerName;
	}

	public void setDeclarationFormbIssuerName(String declarationFormbIssuerName) {
		this.declarationFormbIssuerName = declarationFormbIssuerName;
	}

	public String getDeclarationFormbIssuerCONTACT() {
		return declarationFormbIssuerCONTACT;
	}

	public void setDeclarationFormbIssuerCONTACT(String declarationFormbIssuerCONTACT) {
		this.declarationFormbIssuerCONTACT = declarationFormbIssuerCONTACT;
	}

	public String getDeclarationFormB1Issurance() {
		return declarationFormB1Issurance;
	}

	public void setDeclarationFormB1Issurance(String declarationFormB1Issurance) {
		this.declarationFormB1Issurance = declarationFormB1Issurance;
	}

	public String getDeclarationFormB1IssurName() {
		return declarationFormB1IssurName;
	}

	public void setDeclarationFormB1IssurName(String declarationFormB1IssurName) {
		this.declarationFormB1IssurName = declarationFormB1IssurName;
	}

	public String getDeclarationFormB1Contact() {
		return declarationFormB1Contact;
	}

	public void setDeclarationFormB1Contact(String declarationFormB1Contact) {
		this.declarationFormB1Contact = declarationFormB1Contact;
	}

	public String getDeclarationFormB2Issurance() {
		return declarationFormB2Issurance;
	}

	public void setDeclarationFormB2Issurance(String declarationFormB2Issurance) {
		this.declarationFormB2Issurance = declarationFormB2Issurance;
	}

	public String getDeclarationFormB2IssurName() {
		return declarationFormB2IssurName;
	}

	public void setDeclarationFormB2IssurName(String declarationFormB2IssurName) {
		this.declarationFormB2IssurName = declarationFormB2IssurName;
	}

	public String getDeclarationFormB2LandName() {
		return declarationFormB2LandName;
	}

	public void setDeclarationFormB2LandName(String declarationFormB2LandName) {
		this.declarationFormB2LandName = declarationFormB2LandName;
	}

	public String getDeclarationFormB2Contact() {
		return declarationFormB2Contact;
	}

	public void setDeclarationFormB2Contact(String declarationFormB2Contact) {
		this.declarationFormB2Contact = declarationFormB2Contact;
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

	public String getTitleClearLawyerPanNo() {
		return titleClearLawyerPanNo;
	}

	public void setTitleClearLawyerPanNo(String titleClearLawyerPanNo) {
		this.titleClearLawyerPanNo = titleClearLawyerPanNo;
	}

	public String getTitleClearanceCertificateIssuanceDate() {
		return titleClearanceCertificateIssuanceDate;
	}

	public void setTitleClearanceCertificateIssuanceDate(String titleClearanceCertificateIssuanceDate) {
		this.titleClearanceCertificateIssuanceDate = titleClearanceCertificateIssuanceDate;
	}

	public String getTitleClearanceCertificateIssuerName() {
		return titleClearanceCertificateIssuerName;
	}

	public void setTitleClearanceCertificateIssuerName(String titleClearanceCertificateIssuerName) {
		this.titleClearanceCertificateIssuerName = titleClearanceCertificateIssuerName;
	}

	public String getTitleClearanceCertificateContact() {
		return titleClearanceCertificateContact;
	}

	public void setTitleClearanceCertificateContact(String titleClearanceCertificateContact) {
		this.titleClearanceCertificateContact = titleClearanceCertificateContact;
	}

	public String getTitleLawyerPanNo() {
		return titleLawyerPanNo;
	}

	public void setTitleLawyerPanNo(String titleLawyerPanNo) {
		this.titleLawyerPanNo = titleLawyerPanNo;
	}

	public String getTitleReportIssueDate() {
		return titleReportIssueDate;
	}

	public void setTitleReportIssueDate(String titleReportIssueDate) {
		this.titleReportIssueDate = titleReportIssueDate;
	}

	public String getTitleReportIssuerName() {
		return titleReportIssuerName;
	}

	public void setTitleReportIssuerName(String titleReportIssuerName) {
		this.titleReportIssuerName = titleReportIssuerName;
	}

	public String getTitleReportContact() {
		return titleReportContact;
	}

	public void setTitleReportContact(String titleReportContact) {
		this.titleReportContact = titleReportContact;
	}

	public String getPropertyCardIdFlag() {
		return propertyCardIdFlag;
	}

	public void setPropertyCardIdFlag(String propertyCardIdFlag) {
		this.propertyCardIdFlag = propertyCardIdFlag;
	}

	public Long getPropertyCardId3() {
		return propertyCardId3;
	}

	public void setPropertyCardId3(Long propertyCardId3) {
		this.propertyCardId3 = propertyCardId3;
	}

	public String getPropertyCardUId3() {
		return propertyCardUId3;
	}

	public void setPropertyCardUId3(String propertyCardUId3) {
		this.propertyCardUId3 = propertyCardUId3;
	}

	public Long getPropertyCardId() {
		return propertyCardId;
	}

	public void setPropertyCardId(Long propertyCardId) {
		this.propertyCardId = propertyCardId;
	}

	public String getPropertyCardUId() {
		return propertyCardUId;
	}

	public void setPropertyCardUId(String propertyCardUId) {
		this.propertyCardUId = propertyCardUId;
	}

	public Long getPropertyCardId2() {
		return propertyCardId2;
	}

	public void setPropertyCardId2(Long propertyCardId2) {
		this.propertyCardId2 = propertyCardId2;
	}

	public String getPropertyCardUId2() {
		return propertyCardUId2;
	}

	public void setPropertyCardUId2(String propertyCardUId2) {
		this.propertyCardUId2 = propertyCardUId2;
	}

	public String getLandPromoterPanNo() {
		return landPromoterPanNo;
	}

	public void setLandPromoterPanNo(String landPromoterPanNo) {
		this.landPromoterPanNo = landPromoterPanNo;
	}

	public String getFormPromoterPanNo() {
		return formPromoterPanNo;
	}

	public void setFormPromoterPanNo(String formPromoterPanNo) {
		this.formPromoterPanNo = formPromoterPanNo;
	}

	public String getFormB1PromoterPanNo() {
		return formB1PromoterPanNo;
	}

	public void setFormB1PromoterPanNo(String formB1PromoterPanNo) {
		this.formB1PromoterPanNo = formB1PromoterPanNo;
	}

	public String getFormB2PromoterPanNo() {
		return formB2PromoterPanNo;
	}

	public void setFormB2PromoterPanNo(String formB2PromoterPanNo) {
		this.formB2PromoterPanNo = formB2PromoterPanNo;
	}



	

	
}

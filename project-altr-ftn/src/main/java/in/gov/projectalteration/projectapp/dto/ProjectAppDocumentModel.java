package in.gov.projectalteration.projectapp.dto;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;


public class ProjectAppDocumentModel implements Serializable {

	private static final long serialVersionUID = 5363287295758943111L;

	private Long docId;

	private Long projectRegId;

	private Long projectDocdId;

	private Long performaForSaleOfAgreementId;

	private String performaForSaleOfAgreementUId;

	private Long auditorsDoc1Id;

	private String auditorsDoc1UId;

	private Long auditorsDoc2Id;

	private String auditorsDoc2UId;

	private Long auditorsDoc3Id;

	private String auditorsDoc3UId;

	private Long incomeTaxReturn1Id;

	private String incomeTaxReturn1UId;

	private Long incomeTaxReturn2Id;

	private String incomeTaxReturn2UId;

	private Long incomeTaxReturn3Id;

	private String incomeTaxReturn3UId;

	private Long projectSpecificDocId;

	private String projectSpecificDocUId;

	private Long directorReportDoc1Id;

	private String directorReportDoc1UId;

	private Long directorReportDoc2Id;

	private String directorReportDoc2UId;

	private Long directorReportDoc3Id;

	private String directorReportDoc3UId;

	private Long directorReportYear1Id;

	private String directorReportYear1UId;

	private Long directorReportYear2Id;

	private String directorReportYear2UId;

	private Long directorReportYear3Id;

	private String directorReportYear3UId;

	private Long panCardDocId;

	private String panCardDocUId;

	private Long photoGraphDocId;

	private String photoGraphDocUId;

	private Long commencementCertDocId;

	private String commencementCertDocUId;

	private Long approveSacPlanDocId;

	private String approveSacPlanDocUId;

	private Long approveLayoutPlanDocId;

	private String approveLayoutPlanDocUId;

	private Long agreementFileDocId;

	private String agreementFileDocUId;

	/* meta data */
	private Long landLocationFileDocId;

	private String landLocationFileDocUId;

	private Calendar landIssuanceDate;

	private String landDocIssuerName;

	private String landDocContact;

	private Long encumbranceCertificateDocId;
	private String encumbranceCertificateDocUId;

	private Calendar encumbranceCertificateDocIssuanceDate;

	private String encumbranceCertificateDocIssuerName;

	private String encumbranceCertificateDocContact;
	/******************************************/

	private Long sanctionedLayoutPlanDocId;

	private String sanctionedLayoutPlanDocUId;

	private Long areaDevelopmentDocId;

	private String areaDevelopmentDocUId;

	private Long performaOfAllotmentLetterDocId;

	private String performaOfAllotmentLetterDocUId;

	private Long brochureOfCurrentProjectDocId;

	@Column(name = "PD_BROCH_CURR_PROJ_DOC_UID", length = 200)
	private String brochureOfCurrentProjectDocUId;

	@Column(name = "PD_PROJ_REALATED_DOC_ID")
	private Long projectRelatedDocId;

	@Column(name = "PD_PROJ_REALATED_DOC_UID", length = 200)
	private String projectRelatedDocUId;

	/* meta data */
	@Column(name = "PD_DECLR_FORM_B_DOC_ID")
	private Long declarationFormbDocId;

	@Column(name = "PD_DECLR_FORM_B_DOC_UID", length = 200)
	private String declarationFormbDocUId;

	@Column(name = "PD_DECLR_FORM_B_ISSUANCE_DATE")
	private Calendar declarationFormbDocIssuanceDate;

	@Column(name = "PD_DECLR_FORM_B_ISSUER_NAME", length = 200)
	private String declarationFormbIssuerName;

	@Column(name = "PD_DECLR_FORM_B_ISSUER_CONTACT", length = 12)
	private String declarationFormbIssuerCONTACT;

	@Column(name = "DECLARATIONFORMB1_ID")
	private Long declarationFormB1Id;
	@Column(name = "DECLARATIONFORMB1_UID", length = 200)
	private String declarationFormB1UId;
	@Column(name = "DECLARATIONFORMB1_ISSURANCE_DATE")
	private Calendar declarationFormB1Issurance;

	@Column(name = "DECLARATIONFORMB1_ISSUERNAME")
	private String declarationFormB1IssurName;

	@Column(name = "DECLARATIONFORMB1_CONTACT", length = 12)
	private String declarationFormB1Contact;

	@Column(name = "DECLARATIONFORMB2_ID")
	private Long declarationFormB2Id;

	private String declarationFormB2UId;
	private Calendar declarationFormB2Issurance;

	private String declarationFormB2IssurName;

	private String declarationFormB2Contact;

	private String approvedBuildingPlanPlottingPlanUId;

	private Long approvedBuildingPlanPlottingPlanId;

	private Long allNOCsfromAuthoritiesId;

	private String allNOCsfromAuthoritiesUId;

	private Long PerformaforSaledeed;

	private String PerformaforSaledeedUId;

	private String ProjectphotoUId;// (JPG only)
	private Long ProjectphotoId;

	private Long titleClearanceCertificateId;

	private String titleClearanceCertificateUId;

	private Calendar titleClearanceCertificateIssuanceDate;
	private String titleClearanceCertificateIssuerName;
	private String titleClearanceCertificateContact;

	private Long titleReportId;

	private String titleReportUId;

	private Calendar titleReportIssueDate;
	private String titleReportIssuerName;
	private String titleReportContact;

	private Long developmentAgreementId;
	private String developmentAgreementUId;
	private Calendar developmentAgreementIssueDate;
	private String developmentAgreementIssuerName;
	private String developmentAgreementContact;

	private String propertyCardIdFlag;

	private Long propertyCardId; // 7/12, Property card or Gam namoona no 2^
	private String propertyCardUId; // 7/12, Property card or Gam namoona no 2^

	private Long propertyCardId2; // 7/12, Property card or Gam namoona no 2^
	private String propertyCard2UId; // 7/12, Property card or Gam namoona no 2^

	private Long buCertificateId;
	private String buCertificateUId;

	private Long ganttchartForm1AId;
	private String ganttchartForm1AUId;

	public Long getDocId() {
		return docId;
	}

	public void setDocId(Long docId) {
		this.docId = docId;
	}

	public Long getProjectRegId() {
		return projectRegId;
	}

	public void setProjectRegId(Long projectRegId) {
		this.projectRegId = projectRegId;
	}

	public Long getProjectDocdId() {
		return projectDocdId;
	}

	public void setProjectDocdId(Long projectDocdId) {
		this.projectDocdId = projectDocdId;
	}

	public Long getPerformaForSaleOfAgreementId() {
		return performaForSaleOfAgreementId;
	}

	public void setPerformaForSaleOfAgreementId(Long performaForSaleOfAgreementId) {
		this.performaForSaleOfAgreementId = performaForSaleOfAgreementId;
	}

	public String getPerformaForSaleOfAgreementUId() {
		return performaForSaleOfAgreementUId;
	}

	public void setPerformaForSaleOfAgreementUId(String performaForSaleOfAgreementUId) {
		this.performaForSaleOfAgreementUId = performaForSaleOfAgreementUId;
	}

	public Long getAuditorsDoc1Id() {
		return auditorsDoc1Id;
	}

	public void setAuditorsDoc1Id(Long auditorsDoc1Id) {
		this.auditorsDoc1Id = auditorsDoc1Id;
	}

	public String getAuditorsDoc1UId() {
		return auditorsDoc1UId;
	}

	public void setAuditorsDoc1UId(String auditorsDoc1UId) {
		this.auditorsDoc1UId = auditorsDoc1UId;
	}

	public Long getAuditorsDoc2Id() {
		return auditorsDoc2Id;
	}

	public void setAuditorsDoc2Id(Long auditorsDoc2Id) {
		this.auditorsDoc2Id = auditorsDoc2Id;
	}

	public String getAuditorsDoc2UId() {
		return auditorsDoc2UId;
	}

	public void setAuditorsDoc2UId(String auditorsDoc2UId) {
		this.auditorsDoc2UId = auditorsDoc2UId;
	}

	public Long getAuditorsDoc3Id() {
		return auditorsDoc3Id;
	}

	public void setAuditorsDoc3Id(Long auditorsDoc3Id) {
		this.auditorsDoc3Id = auditorsDoc3Id;
	}

	public String getAuditorsDoc3UId() {
		return auditorsDoc3UId;
	}

	public void setAuditorsDoc3UId(String auditorsDoc3UId) {
		this.auditorsDoc3UId = auditorsDoc3UId;
	}

	public Long getIncomeTaxReturn1Id() {
		return incomeTaxReturn1Id;
	}

	public void setIncomeTaxReturn1Id(Long incomeTaxReturn1Id) {
		this.incomeTaxReturn1Id = incomeTaxReturn1Id;
	}

	public String getIncomeTaxReturn1UId() {
		return incomeTaxReturn1UId;
	}

	public void setIncomeTaxReturn1UId(String incomeTaxReturn1UId) {
		this.incomeTaxReturn1UId = incomeTaxReturn1UId;
	}

	public Long getIncomeTaxReturn2Id() {
		return incomeTaxReturn2Id;
	}

	public void setIncomeTaxReturn2Id(Long incomeTaxReturn2Id) {
		this.incomeTaxReturn2Id = incomeTaxReturn2Id;
	}

	public String getIncomeTaxReturn2UId() {
		return incomeTaxReturn2UId;
	}

	public void setIncomeTaxReturn2UId(String incomeTaxReturn2UId) {
		this.incomeTaxReturn2UId = incomeTaxReturn2UId;
	}

	public Long getIncomeTaxReturn3Id() {
		return incomeTaxReturn3Id;
	}

	public void setIncomeTaxReturn3Id(Long incomeTaxReturn3Id) {
		this.incomeTaxReturn3Id = incomeTaxReturn3Id;
	}

	public String getIncomeTaxReturn3UId() {
		return incomeTaxReturn3UId;
	}

	public void setIncomeTaxReturn3UId(String incomeTaxReturn3UId) {
		this.incomeTaxReturn3UId = incomeTaxReturn3UId;
	}

	public Long getProjectSpecificDocId() {
		return projectSpecificDocId;
	}

	public void setProjectSpecificDocId(Long projectSpecificDocId) {
		this.projectSpecificDocId = projectSpecificDocId;
	}

	public String getProjectSpecificDocUId() {
		return projectSpecificDocUId;
	}

	public void setProjectSpecificDocUId(String projectSpecificDocUId) {
		this.projectSpecificDocUId = projectSpecificDocUId;
	}

	public Long getDirectorReportDoc1Id() {
		return directorReportDoc1Id;
	}

	public void setDirectorReportDoc1Id(Long directorReportDoc1Id) {
		this.directorReportDoc1Id = directorReportDoc1Id;
	}

	public String getDirectorReportDoc1UId() {
		return directorReportDoc1UId;
	}

	public void setDirectorReportDoc1UId(String directorReportDoc1UId) {
		this.directorReportDoc1UId = directorReportDoc1UId;
	}

	public Long getDirectorReportDoc2Id() {
		return directorReportDoc2Id;
	}

	public void setDirectorReportDoc2Id(Long directorReportDoc2Id) {
		this.directorReportDoc2Id = directorReportDoc2Id;
	}

	public String getDirectorReportDoc2UId() {
		return directorReportDoc2UId;
	}

	public void setDirectorReportDoc2UId(String directorReportDoc2UId) {
		this.directorReportDoc2UId = directorReportDoc2UId;
	}

	public Long getDirectorReportDoc3Id() {
		return directorReportDoc3Id;
	}

	public void setDirectorReportDoc3Id(Long directorReportDoc3Id) {
		this.directorReportDoc3Id = directorReportDoc3Id;
	}

	public String getDirectorReportDoc3UId() {
		return directorReportDoc3UId;
	}

	public void setDirectorReportDoc3UId(String directorReportDoc3UId) {
		this.directorReportDoc3UId = directorReportDoc3UId;
	}

	public Long getDirectorReportYear1Id() {
		return directorReportYear1Id;
	}

	public void setDirectorReportYear1Id(Long directorReportYear1Id) {
		this.directorReportYear1Id = directorReportYear1Id;
	}

	public String getDirectorReportYear1UId() {
		return directorReportYear1UId;
	}

	public void setDirectorReportYear1UId(String directorReportYear1UId) {
		this.directorReportYear1UId = directorReportYear1UId;
	}

	public Long getDirectorReportYear2Id() {
		return directorReportYear2Id;
	}

	public void setDirectorReportYear2Id(Long directorReportYear2Id) {
		this.directorReportYear2Id = directorReportYear2Id;
	}

	public String getDirectorReportYear2UId() {
		return directorReportYear2UId;
	}

	public void setDirectorReportYear2UId(String directorReportYear2UId) {
		this.directorReportYear2UId = directorReportYear2UId;
	}

	public Long getDirectorReportYear3Id() {
		return directorReportYear3Id;
	}

	public void setDirectorReportYear3Id(Long directorReportYear3Id) {
		this.directorReportYear3Id = directorReportYear3Id;
	}

	public String getDirectorReportYear3UId() {
		return directorReportYear3UId;
	}

	public void setDirectorReportYear3UId(String directorReportYear3UId) {
		this.directorReportYear3UId = directorReportYear3UId;
	}

	public Long getPanCardDocId() {
		return panCardDocId;
	}

	public void setPanCardDocId(Long panCardDocId) {
		this.panCardDocId = panCardDocId;
	}

	public String getPanCardDocUId() {
		return panCardDocUId;
	}

	public void setPanCardDocUId(String panCardDocUId) {
		this.panCardDocUId = panCardDocUId;
	}

	public Long getPhotoGraphDocId() {
		return photoGraphDocId;
	}

	public void setPhotoGraphDocId(Long photoGraphDocId) {
		this.photoGraphDocId = photoGraphDocId;
	}

	public String getPhotoGraphDocUId() {
		return photoGraphDocUId;
	}

	public void setPhotoGraphDocUId(String photoGraphDocUId) {
		this.photoGraphDocUId = photoGraphDocUId;
	}

	public Long getCommencementCertDocId() {
		return commencementCertDocId;
	}

	public void setCommencementCertDocId(Long commencementCertDocId) {
		this.commencementCertDocId = commencementCertDocId;
	}

	public String getCommencementCertDocUId() {
		return commencementCertDocUId;
	}

	public void setCommencementCertDocUId(String commencementCertDocUId) {
		this.commencementCertDocUId = commencementCertDocUId;
	}

	public Long getApproveSacPlanDocId() {
		return approveSacPlanDocId;
	}

	public void setApproveSacPlanDocId(Long approveSacPlanDocId) {
		this.approveSacPlanDocId = approveSacPlanDocId;
	}

	public String getApproveSacPlanDocUId() {
		return approveSacPlanDocUId;
	}

	public void setApproveSacPlanDocUId(String approveSacPlanDocUId) {
		this.approveSacPlanDocUId = approveSacPlanDocUId;
	}

	public Long getApproveLayoutPlanDocId() {
		return approveLayoutPlanDocId;
	}

	public void setApproveLayoutPlanDocId(Long approveLayoutPlanDocId) {
		this.approveLayoutPlanDocId = approveLayoutPlanDocId;
	}

	public String getApproveLayoutPlanDocUId() {
		return approveLayoutPlanDocUId;
	}

	public void setApproveLayoutPlanDocUId(String approveLayoutPlanDocUId) {
		this.approveLayoutPlanDocUId = approveLayoutPlanDocUId;
	}

	public Long getAgreementFileDocId() {
		return agreementFileDocId;
	}

	public void setAgreementFileDocId(Long agreementFileDocId) {
		this.agreementFileDocId = agreementFileDocId;
	}

	public String getAgreementFileDocUId() {
		return agreementFileDocUId;
	}

	public void setAgreementFileDocUId(String agreementFileDocUId) {
		this.agreementFileDocUId = agreementFileDocUId;
	}

	public Long getLandLocationFileDocId() {
		return landLocationFileDocId;
	}

	public void setLandLocationFileDocId(Long landLocationFileDocId) {
		this.landLocationFileDocId = landLocationFileDocId;
	}

	public String getLandLocationFileDocUId() {
		return landLocationFileDocUId;
	}

	public void setLandLocationFileDocUId(String landLocationFileDocUId) {
		this.landLocationFileDocUId = landLocationFileDocUId;
	}

	public Calendar getLandIssuanceDate() {
		return landIssuanceDate;
	}

	public void setLandIssuanceDate(Calendar landIssuanceDate) {
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

	public Long getEncumbranceCertificateDocId() {
		return encumbranceCertificateDocId;
	}

	public void setEncumbranceCertificateDocId(Long encumbranceCertificateDocId) {
		this.encumbranceCertificateDocId = encumbranceCertificateDocId;
	}

	public String getEncumbranceCertificateDocUId() {
		return encumbranceCertificateDocUId;
	}

	public void setEncumbranceCertificateDocUId(String encumbranceCertificateDocUId) {
		this.encumbranceCertificateDocUId = encumbranceCertificateDocUId;
	}

	public Calendar getEncumbranceCertificateDocIssuanceDate() {
		return encumbranceCertificateDocIssuanceDate;
	}

	public void setEncumbranceCertificateDocIssuanceDate(Calendar encumbranceCertificateDocIssuanceDate) {
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

	public Long getSanctionedLayoutPlanDocId() {
		return sanctionedLayoutPlanDocId;
	}

	public void setSanctionedLayoutPlanDocId(Long sanctionedLayoutPlanDocId) {
		this.sanctionedLayoutPlanDocId = sanctionedLayoutPlanDocId;
	}

	public String getSanctionedLayoutPlanDocUId() {
		return sanctionedLayoutPlanDocUId;
	}

	public void setSanctionedLayoutPlanDocUId(String sanctionedLayoutPlanDocUId) {
		this.sanctionedLayoutPlanDocUId = sanctionedLayoutPlanDocUId;
	}

	public Long getAreaDevelopmentDocId() {
		return areaDevelopmentDocId;
	}

	public void setAreaDevelopmentDocId(Long areaDevelopmentDocId) {
		this.areaDevelopmentDocId = areaDevelopmentDocId;
	}

	public String getAreaDevelopmentDocUId() {
		return areaDevelopmentDocUId;
	}

	public void setAreaDevelopmentDocUId(String areaDevelopmentDocUId) {
		this.areaDevelopmentDocUId = areaDevelopmentDocUId;
	}

	public Long getPerformaOfAllotmentLetterDocId() {
		return performaOfAllotmentLetterDocId;
	}

	public void setPerformaOfAllotmentLetterDocId(Long performaOfAllotmentLetterDocId) {
		this.performaOfAllotmentLetterDocId = performaOfAllotmentLetterDocId;
	}

	public String getPerformaOfAllotmentLetterDocUId() {
		return performaOfAllotmentLetterDocUId;
	}

	public void setPerformaOfAllotmentLetterDocUId(String performaOfAllotmentLetterDocUId) {
		this.performaOfAllotmentLetterDocUId = performaOfAllotmentLetterDocUId;
	}

	public Long getBrochureOfCurrentProjectDocId() {
		return brochureOfCurrentProjectDocId;
	}

	public void setBrochureOfCurrentProjectDocId(Long brochureOfCurrentProjectDocId) {
		this.brochureOfCurrentProjectDocId = brochureOfCurrentProjectDocId;
	}

	public String getBrochureOfCurrentProjectDocUId() {
		return brochureOfCurrentProjectDocUId;
	}

	public void setBrochureOfCurrentProjectDocUId(String brochureOfCurrentProjectDocUId) {
		this.brochureOfCurrentProjectDocUId = brochureOfCurrentProjectDocUId;
	}

	public Long getProjectRelatedDocId() {
		return projectRelatedDocId;
	}

	public void setProjectRelatedDocId(Long projectRelatedDocId) {
		this.projectRelatedDocId = projectRelatedDocId;
	}

	public String getProjectRelatedDocUId() {
		return projectRelatedDocUId;
	}

	public void setProjectRelatedDocUId(String projectRelatedDocUId) {
		this.projectRelatedDocUId = projectRelatedDocUId;
	}

	public Long getDeclarationFormbDocId() {
		return declarationFormbDocId;
	}

	public void setDeclarationFormbDocId(Long declarationFormbDocId) {
		this.declarationFormbDocId = declarationFormbDocId;
	}

	public String getDeclarationFormbDocUId() {
		return declarationFormbDocUId;
	}

	public void setDeclarationFormbDocUId(String declarationFormbDocUId) {
		this.declarationFormbDocUId = declarationFormbDocUId;
	}

	public Calendar getDeclarationFormbDocIssuanceDate() {
		return declarationFormbDocIssuanceDate;
	}

	public void setDeclarationFormbDocIssuanceDate(Calendar declarationFormbDocIssuanceDate) {
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

	public Long getDeclarationFormB1Id() {
		return declarationFormB1Id;
	}

	public void setDeclarationFormB1Id(Long declarationFormB1Id) {
		this.declarationFormB1Id = declarationFormB1Id;
	}

	public String getDeclarationFormB1UId() {
		return declarationFormB1UId;
	}

	public void setDeclarationFormB1UId(String declarationFormB1UId) {
		this.declarationFormB1UId = declarationFormB1UId;
	}

	public Calendar getDeclarationFormB1Issurance() {
		return declarationFormB1Issurance;
	}

	public void setDeclarationFormB1Issurance(Calendar declarationFormB1Issurance) {
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

	public Long getDeclarationFormB2Id() {
		return declarationFormB2Id;
	}

	public void setDeclarationFormB2Id(Long declarationFormB2Id) {
		this.declarationFormB2Id = declarationFormB2Id;
	}

	public String getDeclarationFormB2UId() {
		return declarationFormB2UId;
	}

	public void setDeclarationFormB2UId(String declarationFormB2UId) {
		this.declarationFormB2UId = declarationFormB2UId;
	}

	public Calendar getDeclarationFormB2Issurance() {
		return declarationFormB2Issurance;
	}

	public void setDeclarationFormB2Issurance(Calendar declarationFormB2Issurance) {
		this.declarationFormB2Issurance = declarationFormB2Issurance;
	}

	public String getDeclarationFormB2IssurName() {
		return declarationFormB2IssurName;
	}

	public void setDeclarationFormB2IssurName(String declarationFormB2IssurName) {
		this.declarationFormB2IssurName = declarationFormB2IssurName;
	}

	public String getDeclarationFormB2Contact() {
		return declarationFormB2Contact;
	}

	public void setDeclarationFormB2Contact(String declarationFormB2Contact) {
		this.declarationFormB2Contact = declarationFormB2Contact;
	}

	public String getApprovedBuildingPlanPlottingPlanUId() {
		return approvedBuildingPlanPlottingPlanUId;
	}

	public void setApprovedBuildingPlanPlottingPlanUId(String approvedBuildingPlanPlottingPlanUId) {
		this.approvedBuildingPlanPlottingPlanUId = approvedBuildingPlanPlottingPlanUId;
	}

	public Long getApprovedBuildingPlanPlottingPlanId() {
		return approvedBuildingPlanPlottingPlanId;
	}

	public void setApprovedBuildingPlanPlottingPlanId(Long approvedBuildingPlanPlottingPlanId) {
		this.approvedBuildingPlanPlottingPlanId = approvedBuildingPlanPlottingPlanId;
	}

	public Long getAllNOCsfromAuthoritiesId() {
		return allNOCsfromAuthoritiesId;
	}

	public void setAllNOCsfromAuthoritiesId(Long allNOCsfromAuthoritiesId) {
		this.allNOCsfromAuthoritiesId = allNOCsfromAuthoritiesId;
	}

	public String getAllNOCsfromAuthoritiesUId() {
		return allNOCsfromAuthoritiesUId;
	}

	public void setAllNOCsfromAuthoritiesUId(String allNOCsfromAuthoritiesUId) {
		this.allNOCsfromAuthoritiesUId = allNOCsfromAuthoritiesUId;
	}

	public Long getPerformaforSaledeed() {
		return PerformaforSaledeed;
	}

	public void setPerformaforSaledeed(Long performaforSaledeed) {
		PerformaforSaledeed = performaforSaledeed;
	}

	public String getPerformaforSaledeedUId() {
		return PerformaforSaledeedUId;
	}

	public void setPerformaforSaledeedUId(String performaforSaledeedUId) {
		PerformaforSaledeedUId = performaforSaledeedUId;
	}

	public String getProjectphotoUId() {
		return ProjectphotoUId;
	}

	public void setProjectphotoUId(String projectphotoUId) {
		ProjectphotoUId = projectphotoUId;
	}

	public Long getProjectphotoId() {
		return ProjectphotoId;
	}

	public void setProjectphotoId(Long projectphotoId) {
		ProjectphotoId = projectphotoId;
	}

	public Long getTitleClearanceCertificateId() {
		return titleClearanceCertificateId;
	}

	public void setTitleClearanceCertificateId(Long titleClearanceCertificateId) {
		this.titleClearanceCertificateId = titleClearanceCertificateId;
	}

	public String getTitleClearanceCertificateUId() {
		return titleClearanceCertificateUId;
	}

	public void setTitleClearanceCertificateUId(String titleClearanceCertificateUId) {
		this.titleClearanceCertificateUId = titleClearanceCertificateUId;
	}

	public Calendar getTitleClearanceCertificateIssuanceDate() {
		return titleClearanceCertificateIssuanceDate;
	}

	public void setTitleClearanceCertificateIssuanceDate(Calendar titleClearanceCertificateIssuanceDate) {
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

	public Long getTitleReportId() {
		return titleReportId;
	}

	public void setTitleReportId(Long titleReportId) {
		this.titleReportId = titleReportId;
	}

	public String getTitleReportUId() {
		return titleReportUId;
	}

	public void setTitleReportUId(String titleReportUId) {
		this.titleReportUId = titleReportUId;
	}

	public Calendar getTitleReportIssueDate() {
		return titleReportIssueDate;
	}

	public void setTitleReportIssueDate(Calendar titleReportIssueDate) {
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

	public Long getDevelopmentAgreementId() {
		return developmentAgreementId;
	}

	public void setDevelopmentAgreementId(Long developmentAgreementId) {
		this.developmentAgreementId = developmentAgreementId;
	}

	public String getDevelopmentAgreementUId() {
		return developmentAgreementUId;
	}

	public void setDevelopmentAgreementUId(String developmentAgreementUId) {
		this.developmentAgreementUId = developmentAgreementUId;
	}

	public Calendar getDevelopmentAgreementIssueDate() {
		return developmentAgreementIssueDate;
	}

	public void setDevelopmentAgreementIssueDate(Calendar developmentAgreementIssueDate) {
		this.developmentAgreementIssueDate = developmentAgreementIssueDate;
	}

	public String getDevelopmentAgreementIssuerName() {
		return developmentAgreementIssuerName;
	}

	public void setDevelopmentAgreementIssuerName(String developmentAgreementIssuerName) {
		this.developmentAgreementIssuerName = developmentAgreementIssuerName;
	}

	public String getDevelopmentAgreementContact() {
		return developmentAgreementContact;
	}

	public void setDevelopmentAgreementContact(String developmentAgreementContact) {
		this.developmentAgreementContact = developmentAgreementContact;
	}

	public String getPropertyCardIdFlag() {
		return propertyCardIdFlag;
	}

	public void setPropertyCardIdFlag(String propertyCardIdFlag) {
		this.propertyCardIdFlag = propertyCardIdFlag;
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

	public String getPropertyCard2UId() {
		return propertyCard2UId;
	}

	public void setPropertyCard2UId(String propertyCard2UId) {
		this.propertyCard2UId = propertyCard2UId;
	}

	public Long getBuCertificateId() {
		return buCertificateId;
	}

	public void setBuCertificateId(Long buCertificateId) {
		this.buCertificateId = buCertificateId;
	}

	public String getBuCertificateUId() {
		return buCertificateUId;
	}

	public void setBuCertificateUId(String buCertificateUId) {
		this.buCertificateUId = buCertificateUId;
	}

	public Long getGanttchartForm1AId() {
		return ganttchartForm1AId;
	}

	public void setGanttchartForm1AId(Long ganttchartForm1AId) {
		this.ganttchartForm1AId = ganttchartForm1AId;
	}

	public String getGanttchartForm1AUId() {
		return ganttchartForm1AUId;
	}

	public void setGanttchartForm1AUId(String ganttchartForm1AUId) {
		this.ganttchartForm1AUId = ganttchartForm1AUId;
	}

	/*
	 * public void populateData(DocEnquiryTrxModel doc) {
	 * 
	 * this.setPropertyCardId(doc.getDocumentId());
	 * this.setPropertyCardUId(doc.getDocumentUId());
	 * 
	 * }
	 */

}

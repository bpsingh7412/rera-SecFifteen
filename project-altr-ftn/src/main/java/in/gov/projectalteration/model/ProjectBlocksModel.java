package in.gov.projectalteration.model;

import java.util.Calendar;

public class ProjectBlocksModel {

	private String blockName;

	private Long blockId;

	private String userId;

	private Long prjRegId;

	private Long prjAppRegId;

	private String devStartDate;

	private String devEndDate;

	private Calendar createdOn;

	private String createdBy;

	private Calendar lastModifiedOn;

	private String lastModifiedBy;

	private String commencementCertiNo;

	private Long commencementCertificateId;

	private String commencementCertificateUId;

	private Long photoId;

	private String photoUId;

	private Calendar dateIssuanceDoc;

	private String issuerName;

	private String contactDetails;

	private String height;

	public String getBlockName() {
		return blockName;
	}

	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;

	}

	public Long getBlockId() {
		return blockId;
	}

	public void setBlockId(Long blockId) {
		this.blockId = blockId;
	}

	public Long getPrjRegId() {
		return prjRegId;
	}

	public void setPrjRegId(Long prjRegId) {
		this.prjRegId = prjRegId;
	}

	public Long getPrjAppRegId() {
		return prjAppRegId;
	}

	public void setPrjAppRegId(Long prjAppRegId) {
		this.prjAppRegId = prjAppRegId;
	}

	public String getDevStartDate() {
		return devStartDate;
	}

	public void setDevStartDate(String devStartDate) {
		this.devStartDate = devStartDate;
	}

	public String getDevEndDate() {
		return devEndDate;
	}

	public void setDevEndDate(String devEndDate) {
		this.devEndDate = devEndDate;
	}

	public Calendar getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Calendar createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Calendar getLastModifiedOn() {
		return lastModifiedOn;
	}

	public void setLastModifiedOn(Calendar lastModifiedOn) {
		this.lastModifiedOn = lastModifiedOn;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public String getCommencementCertiNo() {
		return commencementCertiNo;
	}

	public void setCommencementCertiNo(String commencementCertiNo) {
		this.commencementCertiNo = commencementCertiNo;
	}

	public Long getCommencementCertificateId() {
		return commencementCertificateId;
	}

	public void setCommencementCertificateId(Long commencementCertificateId) {
		this.commencementCertificateId = commencementCertificateId;
	}

	public String getCommencementCertificateUId() {
		return commencementCertificateUId;
	}

	public void setCommencementCertificateUId(String commencementCertificateUId) {
		this.commencementCertificateUId = commencementCertificateUId;
	}

	public Long getPhotoId() {
		return photoId;
	}

	public void setPhotoId(Long photoId) {
		this.photoId = photoId;
	}

	public String getPhotoUId() {
		return photoUId;
	}

	public void setPhotoUId(String photoUId) {
		this.photoUId = photoUId;
	}

	public Calendar getDateIssuanceDoc() {
		return dateIssuanceDoc;
	}

	public void setDateIssuanceDoc(Calendar calendar) {
		this.dateIssuanceDoc = calendar;
	}

	public String getIssuerName() {
		return issuerName;
	}

	public void setIssuerName(String issuerName) {
		this.issuerName = issuerName;
	}

	public String getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}
}

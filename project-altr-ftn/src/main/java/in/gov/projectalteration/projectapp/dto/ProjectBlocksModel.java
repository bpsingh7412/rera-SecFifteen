package in.gov.projectalteration.projectapp.dto;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class ProjectBlocksModel {

	private long blockId;

	private Long projectAltrId;

	private String blockName;

	private String userId;

	private String devStartDate;
	private String devEndDate;

	private Long photoId;

	private String photoUId;

	private Calendar createdOn;

	private String createdBy;

	private Calendar lastModifiedOn;

	private String lastModifiedBy;

	private Long commencementCertificateId;

	private String commencementCertificateUId;

	private String commencementCertiNo;

	private Calendar dateIssuanceDoc;

	private String issuerName;

	private String contactDetails;

	private String height;

	public long getBlockId() {
		return blockId;
	}

	public void setBlockId(long blockId) {
		this.blockId = blockId;
	}

	public Long getProjectAltrId() {
		return projectAltrId;
	}

	public void setProjectAltrId(Long projectAltrId) {
		this.projectAltrId = projectAltrId;
	}

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

	public Calendar getDateIssuanceDoc() {
		return dateIssuanceDoc;
	}

	public void setDateIssuanceDoc(Calendar dateIssuanceDoc) {
		this.dateIssuanceDoc = dateIssuanceDoc;
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

	public String getCommencementCertiNo() {
		return commencementCertiNo;
	}

	public void setCommencementCertiNo(String commencementCertiNo) {
		this.commencementCertiNo = commencementCertiNo;
	}

}

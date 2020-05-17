package in.gov.projectalteration.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity(name = "BlocksModel")
@Table(name = "TL_PROJECT_ALT_BLOCKS")
public class BlocksModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BLK_ID")
	private long blockId;

	@Column(name = "PRJ_ALT_BLOCK_ID_FK")
	private Long projectAltrId;
	
	/*
	 * @Column(name = "PRJ_APP_ID_BLOCK_FK") private Long prjAppRegId;
	 */

	@Column(name = "BLK_NAME", length = 3500)
	private String blockName;

	@Column(name = "BLK_USER_ID")
	private String userId;

	@Column(name = "BLK_DEV_START_DATE")
	private String devStartDate;
	@Column(name = "BLK_DEV_END_DATE")
	private String devEndDate;

	@Column(name = "BLK_PHOTO_ID")
	private Long photoId;

	@Column(name = "BLK_PHOTO_UID")
	private String photoUId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "BLK_CREATED_ON")
	private Calendar createdOn;

	@Column(name = "BLK_CREATED_BY")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "BLK_LAST_MODIFIED_ON")
	private Calendar lastModifiedOn;

	@Column(name = "BLK_LAST_MODIFIED_BY")
	private String lastModifiedBy;
	
	@Column(name = "BLK_CERTIFICATE_ID")
	private Long commencementCertificateId;
	
	@Column(name = "BLK_CERTIFICATE_UID")
	private String commencementCertificateUId;
	
	@Column(name = "BLK_CERTIFICATE_NO")
	private String commencementCertiNo;
	
	
	@Column(name = "BLK_ISSUANCE_DATE")
	private Calendar dateIssuanceDoc;
	
	@Column(name = "BLK_ISSUER_NAME")	
	private String issuerName;
	
	@Column(name = "BLK_CONTACT_DETAILS")	
	private String contactDetails;
	
	@Column(name = "BLK_HEIGHT")	
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

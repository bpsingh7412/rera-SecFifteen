package in.gov.projectalteration.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "FormAssignmentModel")
@Table(name = "TL_PRJ_ALT_FORM1_ASSIGNMENT_DTL")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class FormAssignmentModel implements Serializable {

	private static final long serialVersionUID = -8907872497982894105L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ASSIGNED_ID")
	private Long id;

	@Column(name = "PRJ_ALT_F1_ASGN_ID")
	private Long projectAltrId;

	@Column(name = "ASSIGNED_FORM1_FK")
	private Long assignedFromId;

	@Column(name = "ASSIGNED_USER_ID")
	private Long assignedUserId;

	@Column(name = "ASSIGNED_USER_NAME")
	private String architectName;

	@Column(name = "ASSIGNED_MIDDLE_NAME")
	private String middleName;

	@Column(name = "ASSIGNED_LAST_NAME")
	private String lastName;

	@Column(name = "ASSIGNED_MOBILE")
	private String mobNumber;

	@Column(name = "ASSIGNED_COA")
	private String coaNo;

	@Column(name = "ASSIGNED_EMAILID")
	private String emailId;

	@Column(name = "ASSIGNED_BY")
	private String formAssignedBy;

	@Column(name = "ASSIGNED_ON")
	private Date formAssignedOn;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "CREATED_ON")
	private Long createdOn;

	@Column(name = "UPDATED_ON")
	private Long modifyOn;
	
	@Column(name = "REFERANCE_FORM_ONE_ID")
	private Long 	referanceformOneId;
	@Column(name = "REFERANCE_FORM_TWO_ID")
	private Long 	referanceformTwoId;
	@Column(name = "REFERANCE_FORM_THREE_ID")
	private Long referanceformThreeId;
	


	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAssignedFromId() {
		return assignedFromId;
	}

	public void setAssignedFromId(Long assignedFromId) {
		this.assignedFromId = assignedFromId;
	}

	public Long getAssignedUserId() {
		return assignedUserId;
	}

	public void setAssignedUserId(Long assignedUserId) {
		this.assignedUserId = assignedUserId;
	}

	public String getFormAssignedBy() {
		return formAssignedBy;
	}

	public void setFormAssignedBy(String formAssignedBy) {
		this.formAssignedBy = formAssignedBy;
	}

	public Date getFormAssignedOn() {
		return formAssignedOn;
	}

	public void setFormAssignedOn(Date formAssignedOn) {
		this.formAssignedOn = formAssignedOn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Long createdOn) {
		this.createdOn = createdOn;
	}

	public Long getModifyOn() {
		return modifyOn;
	}

	public void setModifyOn(Long modifyOn) {
		this.modifyOn = modifyOn;
	}

	
	public Long getProjectAltrId() {
		return projectAltrId;
	}

	public void setProjectAltrId(Long projectAltrId) {
		this.projectAltrId = projectAltrId;
	}

	public String getArchitectName() {
		return architectName;
	}

	public void setArchitectName(String architectName) {
		this.architectName = architectName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobNumber() {
		return mobNumber;
	}

	public void setMobNumber(String mobNumber) {
		this.mobNumber = mobNumber;
	}

	public String getCoaNo() {
		return coaNo;
	}

	public void setCoaNo(String coaNo) {
		this.coaNo = coaNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getReferanceformOneId() {
		return referanceformOneId;
	}

	public void setReferanceformOneId(Long referanceformOneId) {
		this.referanceformOneId = referanceformOneId;
	}

	public Long getReferanceformTwoId() {
		return referanceformTwoId;
	}

	public void setReferanceformTwoId(Long referanceformTwoId) {
		this.referanceformTwoId = referanceformTwoId;
	}

	public Long getReferanceformThreeId() {
		return referanceformThreeId;
	}

	public void setReferanceformThreeId(Long referanceformThreeId) {
		this.referanceformThreeId = referanceformThreeId;
	}

}

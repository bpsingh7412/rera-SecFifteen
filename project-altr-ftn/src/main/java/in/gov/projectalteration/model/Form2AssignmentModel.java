package in.gov.projectalteration.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Form2AssignmentModel")
@Table(name = "TL_PRJ_ALT_FORM2_ASSIGNMENT_DETAIL")
public class Form2AssignmentModel implements Serializable {

	private static final long serialVersionUID = -8907872497982894105L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ASSIGNED_ID")
	private Long id;

	@Column(name = "PRJ_ALT_F2_ASSGN_ID")
	private Long projectAltrId;

	@Column(name = "ASSIGNED_FORM2_FK")
	private Long assignedFromId;

	@Column(name = "ASSIGNED_USER_ID")
	private Long assignedUserId;

	// assign details
	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "MID_NAME")
	private String middleName;

	@Column(name = "MOBILE")
	private String mobileNo;

	@Column(name = "EMAIL_ID")
	private String emailId;

	@Column(name = "LICENCE_NO")
	private String engineerLicenseNumber;

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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getEngineerLicenseNumber() {
		return engineerLicenseNumber;
	}

	public void setEngineerLicenseNumber(String engineerLicenseNumber) {
		this.engineerLicenseNumber = engineerLicenseNumber;
	}

}

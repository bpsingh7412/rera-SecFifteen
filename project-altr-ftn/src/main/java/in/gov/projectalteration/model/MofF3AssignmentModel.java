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
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity(name = "MofAssignmentModel")
@Table(name = "TL_MOF_ASSIGNMENT_DTL")
public class MofF3AssignmentModel implements Serializable {

	private static final long serialVersionUID = -8907872497982894105L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ASSIGNED_ID")
	private Long id;

	@Column(name = "PRJ_ALT_ID")
	private Long prjAltId;

    @Column(name = "ASSIGNED_FORM3_MOF_FK")
	private Long assignedF3MofId;

	@Column(name = "ASSIGNED_USER_ID")
	private Long assignedUserId;

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

	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "MIDDLE_NAME")
	private String middleName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "EMAILID")
	private String emailId;
	@Column(name = "MOBILE")
	private String mobileNo;
	@Column(name = "MEMBER_SHIP_NO")
	private String caMemberShipNumber;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public Long getPrjAltId() {
		return prjAltId;
	}

	public void setPrjAltId(Long prjAltId) {
		this.prjAltId = prjAltId;
	}

	public Long getAssignedF3MofId() {
		return assignedF3MofId;
	}

	public void setAssignedF3MofId(Long assignedF3MofId) {
		this.assignedF3MofId = assignedF3MofId;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getCaMemberShipNumber() {
		return caMemberShipNumber;
	}

	public void setCaMemberShipNumber(String caMemberShipNumber) {
		this.caMemberShipNumber = caMemberShipNumber;
	}

	public Date getFormAssignedOn() {
		return formAssignedOn;
	}

	public void setFormAssignedOn(Date formAssignedOn) {
		this.formAssignedOn = formAssignedOn;
	}

}

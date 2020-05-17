package in.gov.projectalteration.projectapp.dto;

import java.io.Serializable;
import java.util.Date;

import in.gov.projectalteration.model.FormTrxModel;

public class ProjectAppFormThreeDetail implements Serializable {

	private static final long serialVersionUID = 6158399449816328628L;

	private Long formThreeId;

	private Long projRegId;

	private Long referenceForm3Id;

	/* assign detail */
	private Long assignedUserId;

	private String formAssignedBy;

	private Date formAssignedOn;

	private String status;

	private String firstName;
	private String middleName;
	private String lastName;
	private String emailId;

	private String mobileNo;
	private String caMemberShipNumber;

	public Long getFormThreeId() {
		return formThreeId;
	}

	public void setFormThreeId(Long formThreeId) {
		this.formThreeId = formThreeId;
	}

	public Long getProjRegId() {
		return projRegId;
	}

	public void setProjRegId(Long projRegId) {
		this.projRegId = projRegId;
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

	public Long getReferenceForm3Id() {
		return referenceForm3Id;
	}

	public void setReferenceForm3Id(Long referenceForm3Id) {
		this.referenceForm3Id = referenceForm3Id;
	}

	public void populateData(FormTrxModel formThree) {
		this.setProjRegId(formThree.getProcessId());
		this.setReferenceForm3Id(formThree.getReferanceformId());
		this.setAssignedUserId(formThree.getAssignedUserId());
		this.setFirstName(formThree.getFirstName());
		this.setMiddleName(formThree.getMiddleName());
		this.setLastName(formThree.getLastName());
		this.setMobileNo(formThree.getMobNumber());
		this.setCaMemberShipNumber(formThree.getProNo());
		this.setEmailId(formThree.getEmailId());
		this.setStatus(formThree.getStatus());

	}

}

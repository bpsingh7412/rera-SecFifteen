package in.gov.projectalteration.projectapp.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import in.gov.projectalteration.model.FormTrxModel;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ProjectAppFormTwoDetail implements Serializable {

	private static final long serialVersionUID = -644842667187145518L;

	private Long formTwoId;

	private Long projRegId;

	private Long referenceForm2Id;

	/* assign detail */
	private Long assignedUserId;

	// assign details
	private String firstName;

	private String lastName;

	private String middleName;

	private String mobileNo;

	private String emailId;

	private String engineerLicenseNumber;

	private String formAssignedBy;

	private Date formAssignedOn;

	private String status;

	public Long getFormTwoId() {
		return formTwoId;
	}

	public void setFormTwoId(Long formTwoId) {
		this.formTwoId = formTwoId;
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

	public Long getReferenceForm2Id() {
		return referenceForm2Id;
	}

	public void setReferenceForm2Id(Long referenceForm2Id) {
		this.referenceForm2Id = referenceForm2Id;
	}

	public void populateData(FormTrxModel formTwo) {

		this.setProjRegId(formTwo.getProcessId());
		this.setReferenceForm2Id(formTwo.getReferanceformId());
		this.setAssignedUserId(formTwo.getAssignedUserId());
		this.setFirstName(formTwo.getFirstName());
		this.setMiddleName(formTwo.getMiddleName());
		this.setLastName(formTwo.getLastName());
		this.setMobileNo(formTwo.getMobNumber());
		this.setEngineerLicenseNumber(formTwo.getProNo());
		this.setEmailId(formTwo.getEmailId());
		this.setStatus(formTwo.getStatus());

	}

}

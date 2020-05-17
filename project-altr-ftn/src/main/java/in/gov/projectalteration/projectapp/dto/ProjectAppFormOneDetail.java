package in.gov.projectalteration.projectapp.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import in.gov.projectalteration.model.FormTrxModel;

public class ProjectAppFormOneDetail implements Serializable {

	private static final long serialVersionUID = -8907872497982894105L;

	private Long formOneId;

	private Long projRegId;

	private Long referanceformOneId;

	/* assign detail */
	private Long assignedUserId;

	private String architectName;

	private String middleName;

	private String lastName;

	private String mobNumber;

	private String coaNo;

	private String emailId;

	private String formAssignedBy;

	private Date formAssignedOn;

	private String status;

	public Long getFormOneId() {
		return formOneId;
	}

	public void setFormOneId(Long formOneId) {
		this.formOneId = formOneId;
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

	public void populateData(FormTrxModel formOne) {

		// this.setFormOneId(formOne.getFormId());
		this.setProjRegId(formOne.getProcessId());
		this.setReferanceformOneId(formOne.getReferanceformId());
		this.setAssignedUserId(formOne.getAssignedUserId());
		this.setArchitectName(formOne.getFirstName());
		this.setMiddleName(formOne.getMiddleName());
		this.setLastName(formOne.getLastName());
		this.setMobNumber(formOne.getMobNumber());
		this.setCoaNo(formOne.getProNo());
		this.setEmailId(formOne.getEmailId());
		this.setStatus(formOne.getStatus());

	}
	
	


	public void populateData(ProjectAppFormOneDetail formOne) {
		this.setFormOneId(formOne.getFormOneId());
		this.setProjRegId(formOne.getProjRegId());
		this.setReferanceformOneId(formOne.getReferanceformOneId());
		this.setAssignedUserId(formOne.getAssignedUserId());
		this.setArchitectName(formOne.getArchitectName());
		this.setMiddleName(formOne.getMiddleName());
		this.setLastName(formOne.getLastName());
		this.setMobNumber(formOne.getMobNumber());
		this.setCoaNo(formOne.getCoaNo());
		this.setEmailId(formOne.getEmailId());
		this.setFormAssignedBy(formOne.getFormAssignedBy());
		this.setFormAssignedOn(formOne.getFormAssignedOn());
		this.setStatus(formOne.getStatus());
	}
}

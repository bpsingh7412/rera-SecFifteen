package in.gov.projectalteration.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity(name = "FormOneModel")
@Table(name = "TL_PRJ_ALT_FORM_ONE_DTL")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class FormOneModel {
	private static final long serialVersionUID = -8907872497982894105L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FRM_ONE_ID")
	private Long formOneId;

	@Column(name = "PRJ_ALT_ID_FORM1_FK")
	private Long projectAltrId;
	
	@Column(name = "FRM_FORM1_ID")
	private Long referanceformOneId;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ASSIGNED_FORM1_FK")
	List<FormAssignmentModel> assignmentModelList;

	/* assign detail */
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

	public Long getFormOneId() {
		return formOneId;
	}

	public void setFormOneId(Long formOneId) {
		this.formOneId = formOneId;
	}

	

	public Long getProjectAltrId() {
		return projectAltrId;
	}

	public void setProjectAltrId(Long projectAltrId) {
		this.projectAltrId = projectAltrId;
	}

	public List<FormAssignmentModel> getAssignmentModelList() {
		return assignmentModelList;
	}

	public void setAssignmentModelList(List<FormAssignmentModel> assignmentModelList) {
		this.assignmentModelList = assignmentModelList;
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
	
public void populateData(FormTrxModel formOne){
		
		//this.setFormOneId(formOne.getFormId());
		this.setProjectAltrId(formOne.getProAltId());
		this.setReferanceformOneId(formOne.getReferanceformId());
		this.setAssignedUserId(formOne.getAssignedUserId());
		this.setArchitectName(formOne.getFirstName());
		this.setMiddleName(formOne.getMiddleName());
		this.setLastName(formOne.getLastName());
		this.setMobNumber(formOne.getMobNumber());
		this.setCoaNo(formOne.getProNo());
		this.setEmailId(formOne.getEmailId());
		//this.setFormAssignedBy(formOne.get);
		//this.setFormAssignedOn(formOne.getFormAssignedOn());
		this.setStatus(formOne.getStatus());


	}
}

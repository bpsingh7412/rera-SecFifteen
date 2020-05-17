package in.gov.projectalteration.model;

import java.io.Serializable;
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

@Entity(name = "FormTwoModel")
@Table(name = "TL_PRJ_ALT_FORM_TWO_DTL")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class FormTwoModel implements Serializable {

	private static final long serialVersionUID = -644842667187145518L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FRM_TWO_ID")
	private Long formTwoId;

	@Column(name = "PRJ_REG_ID_FORM2_FK")
	private Long projectAltrId;

	@Column(name = "REFERENCE_FORM2_ID")
	private Long referenceForm2Id;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "ASSIGNED_FORM2_FK")
	List<Form2AssignmentModel> assignmentModelList;// log

	/* assign detail */
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

	public Long getFormTwoId() {
		return formTwoId;
	}

	public void setFormTwoId(Long formTwoId) {
		this.formTwoId = formTwoId;
	}

	public Long getProjectAltrId() {
		return projectAltrId;
	}

	public void setProjectAltrId(Long projectAltrId) {
		this.projectAltrId = projectAltrId;
	}

	public List<Form2AssignmentModel> getAssignmentModelList() {
		return assignmentModelList;
	}

	public void setAssignmentModelList(List<Form2AssignmentModel> assignmentModelList) {
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
	
	public void populateData(FormTrxModel formTwo){
		
		//this.setFormOneId(formOne.getFormId());
		this.setProjectAltrId(formTwo.getProAltId());
		this.setReferenceForm2Id(formTwo.getReferanceformId());
		this.setAssignedUserId(formTwo.getAssignedUserId());
		this.setFirstName(formTwo.getFirstName());
		this.setMiddleName(formTwo.getMiddleName());
		this.setLastName(formTwo.getLastName());
		this.setMobileNo(formTwo.getMobNumber());
		this.setEngineerLicenseNumber(formTwo.getProNo());
		this.setEmailId(formTwo.getEmailId());
		//this.setFormAssignedBy(formTwo.get);
		//this.setFormAssignedOn(formOne.getFormAssignedOn());
		this.setStatus(formTwo.getStatus());


}
}

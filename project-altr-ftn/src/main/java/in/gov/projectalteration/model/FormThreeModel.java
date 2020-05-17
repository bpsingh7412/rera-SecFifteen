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

@Entity(name = "FormThreeModel")
@Table(name = "TL_PRJ_ALT_FORM_THREE_DTL")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class FormThreeModel implements Serializable {

	private static final long serialVersionUID = 6158399449816328628L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FRM_THREE_ID")
	private Long formThreeId;

	@Column(name = "PRJ_ALT_ID_FORM3_FK")
	private Long projectAltrId;

	@Column(name = "REFERENCE_FORM3_ID")
	private Long referenceForm3Id;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ASSIGNED_FORM3_FK")
	List<Form3AssignmentModel> assignmentModelList;

	/* assign detail */
	@Column(name = "ASSIGNED_USER_ID")
	private Long assignedUserId;

	@Column(name = "ASSIGNED_BY")
	private String formAssignedBy;

	@Column(name = "ASSIGNED_ON")
	private Date formAssignedOn;

	@Column(name = "STATUS")
	private String status;

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

	public Long getFormThreeId() {
		return formThreeId;
	}

	public void setFormThreeId(Long formThreeId) {
		this.formThreeId = formThreeId;
	}

	public Long getProjectAltrId() {
		return projectAltrId;
	}

	public void setProjectAltrId(Long projectAltrId) {
		this.projectAltrId = projectAltrId;
	}

	public List<Form3AssignmentModel> getAssignmentModelList() {
		return assignmentModelList;
	}

	public void setAssignmentModelList(List<Form3AssignmentModel> assignmentModelList) {
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
	
public void populateData(FormTrxModel formThree){
		
		//this.setFormThreeId(formThree.getFormThreeId());
		this.setProjectAltrId(formThree.getProAltId());
		this.setReferenceForm3Id(formThree.getReferanceformId());
		this.setAssignedUserId(formThree.getAssignedUserId());
		this.setFirstName(formThree.getFirstName());
		this.setMiddleName(formThree.getMiddleName());
		this.setLastName(formThree.getLastName());
		this.setMobileNo(formThree.getMobNumber());
		this.setCaMemberShipNumber(formThree.getProNo());
		this.setEmailId(formThree.getEmailId());
		//this.setFormAssignedBy(formThree.getAssignedUserId());
		//this.setFormAssignedOn(formThree.getAssignedUserOn());
		this.setStatus(formThree.getStatus());


		}

}

package in.gov.projectalteration.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.management.MalformedObjectNameException;
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

@Entity(name = "MofModel")
@Table(name = "TL_MOF_FORM_THREE_DTL")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class MofFormThreeModel implements Serializable {

	private static final long serialVersionUID = 6158399449816328628L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MOF_ID")
	private Long mofId;

	@Column(name = "PRJ_ALT_ID_FORM3_MOF_FK")
	private Long projAltId;

	@Column(name = "REFERENCE_FORM3_MOF_ID")
	private Long referenceMofForm3Id;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ASSIGNED_FORM3_MOF_FK")
	List<MofF3AssignmentModel> assignmentModelList;

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
	
	public Long getProjAltId() {
		return projAltId;
	}

	public void setProjAltId(Long projAltId) {
		this.projAltId = projAltId;
	}

	public List<MofF3AssignmentModel> getAssignmentModelList() {
		return assignmentModelList;
	}

	public void setAssignmentModelList(List<MofF3AssignmentModel> assignmentModelList) {
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

	public Long getMofId() {
		return mofId;
	}

	public void setMofId(Long mofId) {
		this.mofId = mofId;
	}

	public Long getReferenceMofForm3Id() {
		return referenceMofForm3Id;
	}

	public void setReferenceMofForm3Id(Long referenceMofForm3Id) {
		this.referenceMofForm3Id = referenceMofForm3Id;
	}

	
}

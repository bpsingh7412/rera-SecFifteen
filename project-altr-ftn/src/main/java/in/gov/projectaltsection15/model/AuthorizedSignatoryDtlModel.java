package in.gov.projectaltsection15.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name = "AuthorizedSignatoryDtlModel")
@Table(name = "TL_AUTH_SINGNATORY_DTL")
public class AuthorizedSignatoryDtlModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 19873535435L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "AUTH_ID")
	private Long authId;
	
	@Column(name = "STAGE_TWO_AUTH_SIGN_FK")
	private Long  stageTwoId;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "MIDDLE_NAME")
	private String middleName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "PAN_NO")
	private String panNo;
	
	@Column(name = "MOBILE_NO")
	private String mobileNo;

	public Long getAuthId() {
		return authId;
	}

	public void setAuthId(Long authId) {
		this.authId = authId;
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

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Long getStageTwoId() {
		return stageTwoId;
	}

	public void setStageTwoId(Long stageTwoId) {
		this.stageTwoId = stageTwoId;
	}
	
}

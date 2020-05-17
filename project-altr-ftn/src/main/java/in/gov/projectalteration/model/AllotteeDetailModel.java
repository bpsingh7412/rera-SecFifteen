package in.gov.projectalteration.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "AllotteeDetailModel")
@Table(name = "TT_PROJECT_ALLOTTEE_DTL")
public class AllotteeDetailModel implements Serializable {

	private static final long serialVersionUID = 1803590463071163237L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AL_ID")
	private Long allotteeId;

	@Column(name = "PRJ_ALT_ID_ALLOTEE_FK")
	private Long prjAltId;

	@Column(name = "AL_PRJ_ID")
	private Long prjId;

	@Column(name = "AL_NAME")
	private String allotteeName;

	@Column(name = "AL_MOBILE")
	private String allotteeMobile;

	@Column(name = "AL_REPLY")
	private String allotteeReply;

	@Column(name = "REPLY_ON")
	private Calendar allotteeReplyOn;
	
	@Column(name = "KYC_ID")
	private String kycId;
	
	@Column(name = "BLOCK_NAME")	
	private String blockName;
	
	@Column(name = "FLAT_NO")	
	private String flatNo;
	
	@Column(name = "SMS_URL")	
	private String smsUrl;
	
	

	public Long getAllotteeId() {
		return allotteeId;
	}

	public void setAllotteeId(Long allotteeId) {
		this.allotteeId = allotteeId;
	}

	public Long getPrjAltId() {
		return prjAltId;
	}

	public void setPrjAltId(Long prjAltId) {
		this.prjAltId = prjAltId;
	}

	public Long getPrjId() {
		return prjId;
	}

	public void setPrjId(Long prjId) {
		this.prjId = prjId;
	}

	public String getAllotteeName() {
		return allotteeName;
	}

	public void setAllotteeName(String allotteeName) {
		this.allotteeName = allotteeName;
	}

	public String getAllotteeMobile() {
		return allotteeMobile;
	}

	public void setAllotteeMobile(String allotteeMobile) {
		this.allotteeMobile = allotteeMobile;
	}

	public String getAllotteeReply() {
		return allotteeReply;
	}

	public void setAllotteeReply(String allotteeReply) {
		this.allotteeReply = allotteeReply;
	}

	public Calendar getAllotteeReplyOn() {
		return allotteeReplyOn;
	}

	public void setAllotteeReplyOn(Calendar allotteeReplyOn) {
		this.allotteeReplyOn = allotteeReplyOn;
	}

	public String getKycId() {
		return kycId;
	}

	public void setKycId(String kycId) {
		this.kycId = kycId;
	}

	public String getBlockName() {
		return blockName;
	}

	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}

	public String getFlatNo() {
		return flatNo;
	}

	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}

	public String getSmsUrl() {
		return smsUrl;
	}

	public void setSmsUrl(String smsUrl) {
		this.smsUrl = smsUrl;
	}
	
	

}




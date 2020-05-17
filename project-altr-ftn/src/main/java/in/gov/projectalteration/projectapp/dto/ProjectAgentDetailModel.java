package in.gov.projectalteration.projectapp.dto;

import java.io.Serializable;
import java.util.Calendar;

public class ProjectAgentDetailModel implements Serializable {

	private static final long serialVersionUID = 1803590463071163237L;

	private Long id;

	private Long prjRegId;

	private Long prjAppRegId;

	private Long agentId;

	private String emailId;

	private Calendar JoinOn;

	private Calendar separatedOn;

	public void setPrjAppRegId(Long prjAppRegId) {
		this.prjAppRegId = prjAppRegId;
	}

	public Long getPrjAppRegId() {
		return prjAppRegId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAgentId() {
		return agentId;
	}

	public void setAgentId(Long agentId) {
		this.agentId = agentId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Calendar getJoinOn() {

		return JoinOn;
	}

	public void setJoinOn(Calendar joinOn) {
		JoinOn = joinOn;
	}

	public Calendar getSeparatedOn() {
		if (separatedOn == null) {
			return Calendar.getInstance();
		}
		return separatedOn;
	}

	public void setSeparatedOn(Calendar separatedOn) {
		this.separatedOn = separatedOn;
	}

	public Long getPrjRegId() {
		return prjRegId;
	}

	public void setPrjRegId(Long prjRegId) {
		this.prjRegId = prjRegId;
	}

}

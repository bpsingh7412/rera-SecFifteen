package in.gov.projectalteration.model.transaction;

import org.springframework.stereotype.Component;

@Component
public class ProfessionalsDetailsModel {

	private String profssionalType;
	private String name;
	private String userid;
	private String formId;
	private String status;

	public String getProfssionalType() {
		return profssionalType;
	}

	public void setProfssionalType(String profssionalType) {
		this.profssionalType = profssionalType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

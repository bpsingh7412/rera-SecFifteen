package in.gov.projectalteration.projectapp.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class ExtOtherDevModel implements Serializable {

	private static final long serialVersionUID = 145554443L;

	private Long extOtherDevId;

	private Long externalDevelopmentId; // foreign key

	private String developeBy;

	private String workDesc;

	public Long getExtOtherDevId() {
		return extOtherDevId;
	}

	public void setExtOtherDevId(Long extOtherDevId) {
		this.extOtherDevId = extOtherDevId;
	}

	public Long getExternalDevelopmentId() {
		return externalDevelopmentId;
	}

	public void setExternalDevelopmentId(Long externalDevelopmentId) {
		this.externalDevelopmentId = externalDevelopmentId;
	}

	public String getDevelopeBy() {
		return developeBy;
	}

	public void setDevelopeBy(String developeBy) {
		this.developeBy = developeBy;
	}

	public String getWorkDesc() {
		return workDesc;
	}

	public void setWorkDesc(String workDesc) {
		this.workDesc = workDesc;
	}

}

package in.gov.projectalteration.projectapp.dto;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


public class ProjectDevelopmentDetailModel implements Serializable {

	private static final long serialVersionUID = 972495504004101044L;

	
	private Long devId;

	@Column(name = "PRJ_REG_ID_DEV_FK")
	private Long prjRegId;
	
	@Column(name = "PRJ_APP_ID_DEV_FK")
	private Long prjAppRegId;

	
	private ProjectExternalDevWorkModel externalDev;

	
	private List<ProjectInternalDevWorkModel> internalDev;

	public Long getPrjAppRegId() {
		return prjAppRegId;
	}
	
	public void setPrjAppRegId(Long prjAppRegId) {
		this.prjAppRegId = prjAppRegId;
	}
	public Long getDevId() {
		return devId;
	}

	public void setDevId(Long devId) {
		this.devId = devId;
	}

	public Long getPrjRegId() {
		return prjRegId;
	}

	public void setPrjRegId(Long prjRegId) {
		this.prjRegId = prjRegId;
	}

	public ProjectExternalDevWorkModel getExternalDev() {
		return externalDev;
	}
	
	public void setExternalDev(ProjectExternalDevWorkModel externalDev) {
		this.externalDev = externalDev;
	}

	public List<ProjectInternalDevWorkModel> getInternalDev() {
		return internalDev;
	}

	public void setInternalDev(List<ProjectInternalDevWorkModel> internalDev) {
		this.internalDev = internalDev;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((devId == null) ? 0 : devId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProjectDevelopmentDetailModel other = (ProjectDevelopmentDetailModel) obj;
		if (devId == null) {
			if (other.devId != null)
				return false;
		} else if (!devId.equals(other.devId))
			return false;
		return true;
	}

}

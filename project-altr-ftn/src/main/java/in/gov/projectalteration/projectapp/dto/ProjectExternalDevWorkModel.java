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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

public class ProjectExternalDevWorkModel implements Serializable {

	private static final long serialVersionUID = -7224031143797994006L;

	
	private Long extDevId;
	
	private Long developmentId;

	private String roadSysetmDevBy;

	private String waterSupplyBy;

	private String sewegeAndDrainageSystemDevBy;

	private String electricityAndTrasfomerSupply;

	private String solidWasteSupplyBy;

	private List<ExtOtherDevModel> extOtherDevSet;

	public Long getExtDevId() {
		return extDevId;
	}

	public void setExtDevId(Long extDevId) {
		this.extDevId = extDevId;
	}

	public Long getDevelopmentId() {
		return developmentId;
	}

	public void setDevelopmentId(Long developmentId) {
		this.developmentId = developmentId;
	}

	public String getRoadSysetmDevBy() {
		return roadSysetmDevBy;
	}

	public void setRoadSysetmDevBy(String roadSysetmDevBy) {
		this.roadSysetmDevBy = roadSysetmDevBy;
	}

	public String getWaterSupplyBy() {
		return waterSupplyBy;
	}

	public void setWaterSupplyBy(String waterSupplyBy) {
		this.waterSupplyBy = waterSupplyBy;
	}

	public String getSewegeAndDrainageSystemDevBy() {
		return sewegeAndDrainageSystemDevBy;
	}

	public void setSewegeAndDrainageSystemDevBy(String sewegeAndDrainageSystemDevBy) {
		this.sewegeAndDrainageSystemDevBy = sewegeAndDrainageSystemDevBy;
	}

	public String getElectricityAndTrasfomerSupply() {
		return electricityAndTrasfomerSupply;
	}

	public void setElectricityAndTrasfomerSupply(String electricityAndTrasfomerSupply) {
		this.electricityAndTrasfomerSupply = electricityAndTrasfomerSupply;
	}

	public String getSolidWasteSupplyBy() {
		return solidWasteSupplyBy;
	}

	public void setSolidWasteSupplyBy(String solidWasteSupplyBy) {
		this.solidWasteSupplyBy = solidWasteSupplyBy;
	}

	public List<ExtOtherDevModel> getExtOtherDevSet() {
		return extOtherDevSet;
	}

	public void setExtOtherDevSet(List<ExtOtherDevModel> extOtherDevSet) {
		this.extOtherDevSet = extOtherDevSet;
	}

}

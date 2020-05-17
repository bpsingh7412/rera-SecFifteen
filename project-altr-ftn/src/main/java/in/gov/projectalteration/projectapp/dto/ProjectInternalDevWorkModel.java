package in.gov.projectalteration.projectapp.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class ProjectInternalDevWorkModel implements Serializable {

	private static final long serialVersionUID = -7224031143797994006L;

	private Long internalDevId;

	private Long projectDevelopmentId;

	private String typeOfInventory;

	private Integer noOfInventory;

	private Integer noOfInventoryCompleted;

	private Integer noOfInventoryBooked;

	private Double carpetArea;

	private Double areaOfExclusive;

	private Double areaOfExclusiveOpenTerrace;

	public Long getInternalDevId() {
		return internalDevId;
	}

	public void setInternalDevId(Long internalDevId) {
		this.internalDevId = internalDevId;
	}

	public Long getProjectDevelopmentId() {
		return projectDevelopmentId;
	}

	public void setProjectDevelopmentId(Long projectDevelopmentId) {
		this.projectDevelopmentId = projectDevelopmentId;
	}

	public String getTypeOfInventory() {
		return typeOfInventory;
	}

	public void setTypeOfInventory(String typeOfInventory) {
		this.typeOfInventory = typeOfInventory;
	}

	public Integer getNoOfInventory() {
		return noOfInventory;
	}

	public void setNoOfInventory(Integer noOfInventory) {
		this.noOfInventory = noOfInventory;
	}

	public Double getCarpetArea() {
		return carpetArea;
	}

	public void setCarpetArea(Double carpetArea) {
		this.carpetArea = carpetArea;
	}

	public Double getAreaOfExclusive() {
		return areaOfExclusive;
	}

	public void setAreaOfExclusive(Double areaOfExclusive) {
		this.areaOfExclusive = areaOfExclusive;
	}

	public Double getAreaOfExclusiveOpenTerrace() {
		return areaOfExclusiveOpenTerrace;
	}

	public void setAreaOfExclusiveOpenTerrace(Double areaOfExclusiveOpenTerrace) {
		this.areaOfExclusiveOpenTerrace = areaOfExclusiveOpenTerrace;
	}

	public Integer getNoOfInventoryCompleted() {
		return noOfInventoryCompleted;
	}

	public void setNoOfInventoryCompleted(Integer noOfInventoryCompleted) {
		this.noOfInventoryCompleted = noOfInventoryCompleted;
	}

	public Integer getNoOfInventoryBooked() {
		return noOfInventoryBooked;
	}

	public void setNoOfInventoryBooked(Integer noOfInventoryBooked) {
		this.noOfInventoryBooked = noOfInventoryBooked;
	}

}

package in.gov.projectalteration.model.transaction;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
public class AssigedUserTransactionModel implements Serializable {

	private static final long serialVersionUID = -8616903762245074717L;

	private Long assignedUserId;
	private String processId;
	private String projectName;
	private Long projectId;
	private String promoterName;
	private Calendar projectStartDate;
	private Calendar projectCompletionDate;
	private String assignedUserStatus;
	private String formType;
	private String processType;
	private Long promoterId;
	private Long referanceformId;
	private Date formAssignedOn;
	private Date assignedOn;

	public Long getAssignedUserId() {
		return assignedUserId;
	}

	public void setAssignedUserId(Long assignedUserId) {
		this.assignedUserId = assignedUserId;
	}

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	
	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getPromoterName() {
		return promoterName;
	}

	public void setPromoterName(String promoterName) {
		this.promoterName = promoterName;
	}

	public Calendar getProjectStartDate() {
		return projectStartDate;
	}

	public void setProjectStartDate(Calendar projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	public Calendar getProjectCompletionDate() {
		return projectCompletionDate;
	}

	public void setProjectCompletionDate(Calendar projectCompletionDate) {
		this.projectCompletionDate = projectCompletionDate;
	}

	public String getAssignedUserStatus() {
		return assignedUserStatus;
	}

	public void setAssignedUserStatus(String assignedUserStatus) {
		this.assignedUserStatus = assignedUserStatus;
	}

	public String getFormType() {
		return formType;
	}

	public void setFormType(String formType) {
		this.formType = formType;
	}

	public String getProcessType() {
		return processType;
	}

	public void setProcessType(String processType) {
		this.processType = processType;
	}

	public Long getPromoterId() {
		return promoterId;
	}

	public void setPromoterId(Long promoterId) {
		this.promoterId = promoterId;
	}

	public Long getReferanceformId() {
		return referanceformId;
	}

	public void setReferanceformId(Long referanceformId) {
		this.referanceformId = referanceformId;
	}

	public Date getFormAssignedOn() {
		return formAssignedOn;
	}

	public void setFormAssignedOn(Date formAssignedOn) {
		this.formAssignedOn = formAssignedOn;
	}

	public Date getAssignedOn() {
		return assignedOn;
	}

	public void setAssignedOn(Date assignedOn) {
		this.assignedOn = assignedOn;
	}

}

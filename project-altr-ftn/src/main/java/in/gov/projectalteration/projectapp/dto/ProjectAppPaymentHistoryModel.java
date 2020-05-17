package in.gov.projectalteration.projectapp.dto;

import java.io.Serializable;
import java.util.Calendar;

import in.gov.projectalteration.model.ProjectAlterationPaymentDetailsModel;

public class ProjectAppPaymentHistoryModel implements Serializable {

	private static final long serialVersionUID = -8616903762245074717L;

	private Long Id;

	private Long appPaymentId;

	private Double amount;

	private Double penaltyAmount;

	private Double totalProjectAmount;

	private String sbiReferanceNo;

	private String transactionNo;

	private Calendar transactionDate;

	private String tokenNo;

	private String feeType;

	private String status;

	public ProjectAppPaymentHistoryModel() {

	}

	public ProjectAppPaymentHistoryModel(ProjectAlterationPaymentDetailsModel pay) {
		this.amount = pay.getAmount();
		this.penaltyAmount = pay.getPenaltyAmount();
		this.sbiReferanceNo = pay.getSbiReferanceNo();
		this.status = pay.getStatus();
		this.tokenNo = pay.getTokenNo();
		this.totalProjectAmount = pay.getTotalProjectAmount();
		this.transactionNo = pay.getTransactionNo();
		this.feeType = "Registration Fee";
		this.transactionDate = pay.getTransactionDate();
	}

	public Calendar getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Calendar transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getAppPaymentId() {
		return appPaymentId;
	}

	public void setAppPaymentId(Long appPaymentId) {
		this.appPaymentId = appPaymentId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getPenaltyAmount() {
		return penaltyAmount;
	}

	public void setPenaltyAmount(Double penaltyAmount) {
		this.penaltyAmount = penaltyAmount;
	}

	public Double getTotalProjectAmount() {
		return totalProjectAmount;
	}

	public void setTotalProjectAmount(Double totalProjectAmount) {
		this.totalProjectAmount = totalProjectAmount;
	}

	public String getSbiReferanceNo() {
		return sbiReferanceNo;
	}

	public void setSbiReferanceNo(String sbiReferanceNo) {
		this.sbiReferanceNo = sbiReferanceNo;
	}

	public String getTransactionNo() {
		return transactionNo;
	}

	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTokenNo() {
		return tokenNo;
	}

	public void setTokenNo(String tokenNo) {
		this.tokenNo = tokenNo;
	}

}

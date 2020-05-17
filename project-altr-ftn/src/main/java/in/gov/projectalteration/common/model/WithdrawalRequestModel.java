package in.gov.projectalteration.common.model;

import java.util.Calendar;

import javax.persistence.Column;


public class WithdrawalRequestModel {
	private Long withdrawalId;
	private Long processId;
	private String processName;
	private String processType;
	private Long projectId;
	private String projectName;
	private String projectRegNo;
	private String projectAckNo;
	private String projectAddress;
	private Long promoterId;
	private String promotorName;
	private String promotorEmail;
	private String promotorAddress;
	private String promotorMobile;
	private String reasonForWithdrawal;
	private double totalPaymentAmt;
	private String refundAmount;
	private Calendar createdOn;
	private String CreatedBy;
	private String wfStateCode;
	private String wfStateName;
	private String authorityRemark;

	private BankDetailsDto bankDto;

	public Long getWithdrawalId() {
		return withdrawalId;
	}

	public void setWithdrawalId(Long withdrawalId) {
		this.withdrawalId = withdrawalId;
	}

	public Long getProcessId() {
		return processId;
	}

	public void setProcessId(Long processId) {
		this.processId = processId;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public String getProcessType() {
		return processType;
	}

	public void setProcessType(String processType) {
		this.processType = processType;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectRegNo() {
		return projectRegNo;
	}

	public void setProjectRegNo(String projectRegNo) {
		this.projectRegNo = projectRegNo;
	}

	public Long getPromoterId() {
		return promoterId;
	}

	public void setPromoterId(Long promoterId) {
		this.promoterId = promoterId;
	}

	public String getPromotorName() {
		return promotorName;
	}

	public void setPromotorName(String promotorName) {
		this.promotorName = promotorName;
	}

	public String getReasonForWithdrawal() {
		return reasonForWithdrawal;
	}

	public void setReasonForWithdrawal(String reasonForWithdrawal) {
		this.reasonForWithdrawal = reasonForWithdrawal;
	}

	public double getTotalPaymentAmt() {
		return totalPaymentAmt;
	}

	public void setTotalPaymentAmt(double totalPaymentAmt) {
		this.totalPaymentAmt = totalPaymentAmt;
	}

	public String getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(String refundAmount) {
		this.refundAmount = refundAmount;
	}

	public Calendar getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Calendar createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy() {
		return CreatedBy;
	}

	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}

	public BankDetailsDto getBankDto() {
		return bankDto;
	}

	public void setBankDto(BankDetailsDto bankDto) {
		this.bankDto = bankDto;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectAckNo() {
		return projectAckNo;
	}

	public void setProjectAckNo(String projectAckNo) {
		this.projectAckNo = projectAckNo;
	}

	public String getProjectAddress() {
		return projectAddress;
	}

	public void setProjectAddress(String projectAddress) {
		this.projectAddress = projectAddress;
	}

	public String getPromotorEmail() {
		return promotorEmail;
	}

	public void setPromotorEmail(String promotorEmail) {
		this.promotorEmail = promotorEmail;
	}

	public String getPromotorAddress() {
		return promotorAddress;
	}

	public void setPromotorAddress(String promotorAddress) {
		this.promotorAddress = promotorAddress;
	}

	public void setPromotorMobile(String promotorMobile) {
		this.promotorMobile = promotorMobile;
	}

	public String getPromotorMobile() {
		return promotorMobile;
	}

	public String getWfStateCode() {
		return wfStateCode;
	}

	public void setWfStateCode(String wfStateCode) {
		this.wfStateCode = wfStateCode;
	}

	public String getWfStateName() {
		return wfStateName;
	}

	public void setWfStateName(String wfStateName) {
		this.wfStateName = wfStateName;
	}

	public String getAuthorityRemark() {
		return authorityRemark;
	}

	public void setAuthorityRemark(String authorityRemark) {
		this.authorityRemark = authorityRemark;
	}

	/*
	 * public static WithdrawalRequestDto populate(WithdrawalRequestDto model) {
	 * WithdrawalRequestDto obj = new WithdrawalRequestDto();
	 * obj.setProcessId(model.getProcessId());
	 * obj.setProcessName(model.getProcessName());
	 * obj.setProjectRegNo(model.getProjectRegNo());
	 * obj.setProjectId(model.getProjectId());
	 * obj.setProjectAckNo(model.getProjectAckNo());
	 * obj.setProjectAddress(model.getProjectAddress());
	 * obj.setPromoterId(model.getPromoterId());
	 * obj.setPromotorName(model.getPromotorName());
	 * obj.setPromotorAddress(model.getPromotorAddress());
	 * obj.setPromotorEmail(model.getPromotorEmail());
	 * obj.setReasonForWithdrawal(model.getReasonForWithdrawal());
	 * obj.setTotalPaymentAmt(model.getTotalPaymentAmt());
	 * obj.setRefundAmount(model.getRefundAmount());
	 * obj.setProcessName(model.getProcessName());
	 * obj.setRefundAmount(model.getRefundAmount());
	 * 
	 * obj.getBankDto().setBankId(model.getBankDetailsObj().getBankId());
	 * obj.getBankDto().setBankName(model.getBankDetailsObj().getBankName());
	 * obj.getBankDto().setAccountNo(model.getBankDetailsObj().getAccountNo());
	 * obj.getBankDto().setBranchName(model.getBankDetailsObj().getBranchName());
	 * obj.getBankDto().setDistrictCode(model.getBankDetailsObj().getDistrictCode())
	 * ; obj.getBankDto().setDistrictName("");
	 * obj.getBankDto().setStateCode(model.getBankDetailsObj().getStateCode());
	 * obj.getBankDto().setStateName(model.getBankDetailsObj().getStateName());
	 * obj.getBankDto().setTalukaCode(model.getBankDetailsObj().getTalukaCode());
	 * obj.getBankDto().setTalukaName(model.getBankDetailsObj().getTalukaName());
	 * obj.getBankDto().setIfscCode(model.getBankDetailsObj().getIfscCode());
	 * obj.getBankDto().setPincode(model.getBankDetailsObj().getPincode()); return
	 * obj; }
	 */
}

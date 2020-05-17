package in.gov.projectalteration.projectapp.dto;

import java.io.Serializable;
import java.util.Calendar;

public class ProjectAppBankDetails implements Serializable {

	private static final long serialVersionUID = 19873535435L;

	private Long id;

	private String bankCode;

	private String bankName;

	private String branchName;

	private String districtCode;

	private String districtName;

	private String stateCode;

	private String stateName;

	private String talukaName;

	private String pincode;

	private String ifscCode;

	private String accountNumber;

	private String accountName;

	private String withdrwalAmt;

	private String depositAmt;

	private String openingBal;

	private String closingBal;

	private Calendar openingDate;

	private Calendar closingDate;

	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getWithdrwalAmt() {
		return withdrwalAmt;
	}

	public void setWithdrwalAmt(String withdrwalAmt) {
		this.withdrwalAmt = withdrwalAmt;
	}

	public String getDepositAmt() {
		return depositAmt;
	}

	public void setDepositAmt(String depositAmt) {
		this.depositAmt = depositAmt;
	}

	public String getOpeningBal() {
		return openingBal;
	}

	public void setOpeningBal(String openingBal) {
		this.openingBal = openingBal;
	}

	public String getClosingBal() {
		return closingBal;
	}

	public void setClosingBal(String closingBal) {
		this.closingBal = closingBal;
	}

	public Calendar getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Calendar openingDate) {
		this.openingDate = openingDate;
	}

	public Calendar getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(Calendar closingDate) {
		this.closingDate = closingDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getTalukaName() {
		return talukaName;
	}

	public void setTalukaName(String talukaName) {
		this.talukaName = talukaName;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	/*
	 * public void populateData(ProjectBankDetails bank) {
	 * this.setAccountName(bank.getAccountName());
	 * this.setAccountNumber(bank.getAccountNumber());
	 * this.setBankCode(bank.getBankCode()); this.setBankName(bank.getBankName());
	 * this.setDistrictName(bank.getBnkDistrictName());
	 * this.setDistrictCode(bank.getBnkDistrictCode());
	 * this.setPincode(bank.getBnkPincode());
	 * this.setStateCode(bank.getBnkStateCode());
	 * this.setStateName(bank.getBnkStateName());
	 * this.setTalukaName(bank.getBnkTalukaName());
	 * this.setBranchName(bank.getBranchName());
	 * this.setIfscCode(bank.getIfscCode());
	 * this.setOpeningBal(bank.getOpeningBal());
	 * this.setOpeningDate(bank.getOpeningDate());
	 * this.setWithdrwalAmt(bank.getWithdrwalAmt());
	 * this.setDepositAmt(bank.getDepositAmt());
	 * this.setClosingBal(bank.getClosingBal());
	 * this.setClosingDate(bank.getClosingDate()); }
	 */
	public void populateData(ProjectAppBankDetails bank) {
		this.setAccountName(bank.getAccountName());
		this.setAccountNumber(bank.getAccountNumber());
		this.setBankCode(bank.getBankCode());
		this.setBankName(bank.getBankName());
		this.setDistrictName(bank.getDistrictName());
		this.setDistrictCode(bank.getDistrictCode());
		this.setPincode(bank.getPincode());
		this.setStateCode(bank.getStateCode());
		this.setStateName(bank.getStateName());
		this.setTalukaName(bank.getTalukaName());
		this.setBranchName(bank.getBranchName());
		this.setIfscCode(bank.getIfscCode());
		this.setOpeningBal(bank.getOpeningBal());
		this.setOpeningDate(bank.getOpeningDate());
		this.setWithdrwalAmt(bank.getWithdrwalAmt());
		this.setDepositAmt(bank.getDepositAmt());
		this.setClosingBal(bank.getClosingBal());
		this.setClosingDate(bank.getClosingDate());
	}

	public long getClosingTm() {
		if (this.closingDate != null)
			return this.closingDate.getTimeInMillis();
		else
			return 0;
	}

	public long getOpeningTm() {
		if (this.openingDate != null)
			return this.openingDate.getTimeInMillis();
		else
			return 0;
	}
}

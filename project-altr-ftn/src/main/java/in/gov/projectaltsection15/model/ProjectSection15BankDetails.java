package in.gov.projectaltsection15.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name = "ProjectSection15BankDetails")
@Table(name = "TL_PROJECT_SECTION_15_BANK_DTL")
public class ProjectSection15BankDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 19873535435L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PRJ_BNK_ID")
	private Long projectBankId;
	
	@Column(name = "STAGE_TWO_BANK_NEW_PRM_FK")
	private Long  stageTwoId;

	
	@Column(name = "PRJ_BNK_CODE")
	private String bankCode;
	
	@Column(name = "PRJ_BNK_NAME")
	private String bankName;
	
	@Column(name = "PRJ_BRANCH_NAME")
	private String branchName;
	
	@Column(name = "PRJ_BNK_DIST_CODE")
	private String bnkDistrictCode;
	
	@Column(name = "PRJ_BNK_DIST_NAME")
	private String bnkDistrictName;
	
	@Column(name = "PRJ_BNK_STATECODE")
	private String bnkStateCode;
	
	@Column(name = "PRJ_BNK_STATENAME")
	private String bnkStateName;
	
	@Column(name = "PRJ_BNK_TALUKA")
	private String bnkTalukaName;
	
	@Column(name = "PRJ_BNK_PINCODE")
	private String bnkPincode;
	
	@Column(name = "PRJ_IFSC_OCDE")
	private String ifscCode;
	
	@Column(name = "PRJ_ACC_NUM")
	private String accountNumber;
	
	@Column(name = "PRJ_ACC_NAME")
	private String accountName;
	
	@Column(name = "WITHDRAWL_AMT")
	private String withdrwalAmt;
	
	@Column(name = "DEPOSIT_AMT")
	private String depositAmt;
	
	@Column(name = "OPENING_BAL")
	private String openingBal;
	
	@Column(name = "CLOSING_BAL")
	private String closingBal;
	
	@Column(name = "OPENING_DATE")
	private Calendar openingDate;
	
	@Column(name = "CLOSING_DATE")
	private Calendar closingDate;
	
	@Column(name = "BANKER_CERTIFICATE_DOC_ID")
	private Long bankerCertificateDocId;
	
	@Column(name = "BANKER_CERTIFICATE_DOC_UID")
	private String bankerCertificateDocUId;
	
	@Column(name = "PASSBOOK_DOC_ID")
	private Long passBookCopyDocId;
	
	@Column(name = "PASSBOOK_DOC_UID")
	private String passBookCopyDocUId;
	
	
	
	public Long getBankerCertificateDocId() {
		return bankerCertificateDocId;
	}

	public void setBankerCertificateDocId(Long bankerCertificateDocId) {
		this.bankerCertificateDocId = bankerCertificateDocId;
	}

	public String getBankerCertificateDocUId() {
		return bankerCertificateDocUId;
	}

	public void setBankerCertificateDocUId(String bankerCertificateDocUId) {
		this.bankerCertificateDocUId = bankerCertificateDocUId;
	}

	public Long getPassBookCopyDocId() {
		return passBookCopyDocId;
	}

	public void setPassBookCopyDocId(Long passBookCopyDocId) {
		this.passBookCopyDocId = passBookCopyDocId;
	}

	public String getPassBookCopyDocUId() {
		return passBookCopyDocUId;
	}

	public void setPassBookCopyDocUId(String passBookCopyDocUId) {
		this.passBookCopyDocUId = passBookCopyDocUId;
	}

	public ProjectSection15BankDetails(){
		
	}
	
	public void populateData(ProjectSection15BankDetails bank){
		this.setAccountName(bank.getAccountName());
		this.setAccountNumber(bank.getAccountNumber());
		this.setBankCode(bank.getBankCode());
		this.setBankName(bank.getBnkDistrictCode());
		this.setBnkDistrictName(bank.getBnkDistrictName());
		this.setBnkDistrictCode(bank.getBnkDistrictCode());
		this.setBnkPincode(bank.getBnkPincode());
		this.setBnkStateCode(bank.getBnkStateCode());
		this.setBnkStateName(bank.getBnkStateName());
		this.setBnkTalukaName(bank.getBnkTalukaName());
		this.setBranchName(bank.getBranchName());
		this.setIfscCode(bank.getIfscCode());
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

	public Long getProjectBankId() {
		return projectBankId;
	}
	public void setProjectBankId(Long projectBankId) {
		this.projectBankId = projectBankId;
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
	public String getBnkDistrictCode() {
		return bnkDistrictCode;
	}
	public void setBnkDistrictCode(String bnkDistrictCode) {
		this.bnkDistrictCode = bnkDistrictCode;
	}
	public String getBnkDistrictName() {
		return bnkDistrictName;
	}
	public void setBnkDistrictName(String bnkDistrictName) {
		this.bnkDistrictName = bnkDistrictName;
	}
	public String getBnkStateCode() {
		return bnkStateCode;
	}
	public void setBnkStateCode(String bnkStateCode) {
		this.bnkStateCode = bnkStateCode;
	}
	public String getBnkStateName() {
		return bnkStateName;
	}
	public void setBnkStateName(String bnkStateName) {
		this.bnkStateName = bnkStateName;
	}
	public String getBnkTalukaName() {
		return bnkTalukaName;
	}
	public void setBnkTalukaName(String bnkTalukaName) {
		this.bnkTalukaName = bnkTalukaName;
	}
	public String getBnkPincode() {
		return bnkPincode;
	}
	public void setBnkPincode(String bnkPincode) {
		this.bnkPincode = bnkPincode;
	}
	
	public long getClosingTm(){
		if( this.closingDate!=null)
		return this.closingDate.getTimeInMillis();
		else return 0;
	}
	public long getOpeningTm(){
		if( this.openingDate!=null)
		return this.openingDate.getTimeInMillis();
		else return 0;
	}

	public Long getStageTwoId() {
		return stageTwoId;
	}

	public void setStageTwoId(Long stageTwoId) {
		this.stageTwoId = stageTwoId;
	}
	
}

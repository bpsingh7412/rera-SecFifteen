package in.gov.projectalteration.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity(name = "ProjectAlterationPaymentDetailsModel")
@Table(name = "TT_PROJECT_ALT_PAYMENT")
public class ProjectAlterationPaymentDetailsModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PPY_ID")
	private Long paymentId;

	@Column(name = "PRJ_ALT_PAYMENT_ID_FK")
	private Long projectAltrId;

	@Column(name = "PPY_PAYMENT_AMOUNT", columnDefinition = "Double default '0'")
	private Double amount;

	@Column(name = "PPY_PENALTY_AMOUNT", columnDefinition = "Double default '0'")
	private Double penaltyAmount;

	@Column(name = "PPY_TOTAL_AMOUNT", columnDefinition = "Double default '0'")
	private Double totalProjectAmount;

	@Column(name = "PPY_SBI_REFNO")
	private String sbiReferanceNo;

	@Column(name = "TRANSACTION_NO")
	private String transactionNo;
	
	@Column(name = "TRANSACTION_DATE")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar transactionDate;

	@Column(name = "TOKEN_ON")
	private String tokenNo;

	@Column(name = "STATUS")
	private String status;

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	
	public Long getProjectAltrId() {
		return projectAltrId;
	}

	public void setProjectAltrId(Long projectAltrId) {
		this.projectAltrId = projectAltrId;
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

	public String getTokenNo() {
		return tokenNo;
	}

	public void setTokenNo(String tokenNo) {
		this.tokenNo = tokenNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Calendar getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Calendar transactionDate) {
		this.transactionDate = transactionDate;
	}

}

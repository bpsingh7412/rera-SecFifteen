package in.gov.projectalteration.projectapp.dto;

import java.io.Serializable;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ProjectAppFinDocumentModel implements Serializable {

	private static final long serialVersionUID = 5363287295758943111L;

	private Long docId;

	private Long projectRegId;

	private Long projectDocdId;

	private Long auditedBalSheetDoc1Id;

	private String auditedBalSheetDoc1UId;

	private Long auditedBalSheetDoc2_Id;

	private String auditedBalSheetDoc2_UId;

	private Long auditedBalSheetDoc3Id;

	private String auditedBalSheetDoc3UId;

	private Long auditedProfitLossSheetDoc1Id;

	private String auditedProfitLossSheetDoc1UId;

	private Long auditedProfitLossSheetDoc2Id;

	private String auditedProfitLossSheetDoc2UId;

	private Long auditedProfitLossSheetDoc3Id;

	private String auditedProfitLossSheetDoc3UId;

	private Long cashFlowStmtFileDoc1Id;

	private String cashFlowStmtFileDoc1UId;

	private Long cashFlowStmtFileDoc2Id;

	private String cashFlowStmtFileDoc2UId;

	private Long cashFlowStmtFileDoc3Id;

	private String cashFlowStmtFileDoc3UId;

	private Long auditedReportDoc1Id;

	private String auditedReportDoc1UId;

	private Long auditedReportDoc2Id;

	private String auditedReportDoc2UId;

	private Long auditedReportDoc3Id;

	private String auditedReportDoc3UId;

	public Long getDocId() {
		return docId;
	}

	public void setDocId(Long docId) {
		this.docId = docId;
	}

	public Long getProjectRegId() {
		return projectRegId;
	}

	public void setProjectRegId(Long projectRegId) {
		this.projectRegId = projectRegId;
	}

	public Long getProjectDocdId() {
		return projectDocdId;
	}

	public void setProjectDocdId(Long projectDocdId) {
		this.projectDocdId = projectDocdId;
	}

	public Long getAuditedBalSheetDoc1Id() {
		return auditedBalSheetDoc1Id;
	}

	public void setAuditedBalSheetDoc1Id(Long auditedBalSheetDoc1Id) {
		this.auditedBalSheetDoc1Id = auditedBalSheetDoc1Id;
	}

	public String getAuditedBalSheetDoc1UId() {
		return auditedBalSheetDoc1UId;
	}

	public void setAuditedBalSheetDoc1UId(String auditedBalSheetDoc1UId) {
		this.auditedBalSheetDoc1UId = auditedBalSheetDoc1UId;
	}

	public Long getAuditedBalSheetDoc2_Id() {
		return auditedBalSheetDoc2_Id;
	}

	public void setAuditedBalSheetDoc2_Id(Long auditedBalSheetDoc2_Id) {
		this.auditedBalSheetDoc2_Id = auditedBalSheetDoc2_Id;
	}

	public String getAuditedBalSheetDoc2_UId() {
		return auditedBalSheetDoc2_UId;
	}

	public void setAuditedBalSheetDoc2_UId(String auditedBalSheetDoc2_UId) {
		this.auditedBalSheetDoc2_UId = auditedBalSheetDoc2_UId;
	}

	public Long getAuditedBalSheetDoc3Id() {
		return auditedBalSheetDoc3Id;
	}

	public void setAuditedBalSheetDoc3Id(Long auditedBalSheetDoc3Id) {
		this.auditedBalSheetDoc3Id = auditedBalSheetDoc3Id;
	}

	public String getAuditedBalSheetDoc3UId() {
		return auditedBalSheetDoc3UId;
	}

	public void setAuditedBalSheetDoc3UId(String auditedBalSheetDoc3UId) {
		this.auditedBalSheetDoc3UId = auditedBalSheetDoc3UId;
	}

	public Long getAuditedProfitLossSheetDoc1Id() {
		return auditedProfitLossSheetDoc1Id;
	}

	public void setAuditedProfitLossSheetDoc1Id(Long auditedProfitLossSheetDoc1Id) {
		this.auditedProfitLossSheetDoc1Id = auditedProfitLossSheetDoc1Id;
	}

	public String getAuditedProfitLossSheetDoc1UId() {
		return auditedProfitLossSheetDoc1UId;
	}

	public void setAuditedProfitLossSheetDoc1UId(String auditedProfitLossSheetDoc1UId) {
		this.auditedProfitLossSheetDoc1UId = auditedProfitLossSheetDoc1UId;
	}

	public Long getAuditedProfitLossSheetDoc2Id() {
		return auditedProfitLossSheetDoc2Id;
	}

	public void setAuditedProfitLossSheetDoc2Id(Long auditedProfitLossSheetDoc2Id) {
		this.auditedProfitLossSheetDoc2Id = auditedProfitLossSheetDoc2Id;
	}

	public String getAuditedProfitLossSheetDoc2UId() {
		return auditedProfitLossSheetDoc2UId;
	}

	public void setAuditedProfitLossSheetDoc2UId(String auditedProfitLossSheetDoc2UId) {
		this.auditedProfitLossSheetDoc2UId = auditedProfitLossSheetDoc2UId;
	}

	public Long getAuditedProfitLossSheetDoc3Id() {
		return auditedProfitLossSheetDoc3Id;
	}

	public void setAuditedProfitLossSheetDoc3Id(Long auditedProfitLossSheetDoc3Id) {
		this.auditedProfitLossSheetDoc3Id = auditedProfitLossSheetDoc3Id;
	}

	public String getAuditedProfitLossSheetDoc3UId() {
		return auditedProfitLossSheetDoc3UId;
	}

	public void setAuditedProfitLossSheetDoc3UId(String auditedProfitLossSheetDoc3UId) {
		this.auditedProfitLossSheetDoc3UId = auditedProfitLossSheetDoc3UId;
	}

	public Long getCashFlowStmtFileDoc1Id() {
		return cashFlowStmtFileDoc1Id;
	}

	public void setCashFlowStmtFileDoc1Id(Long cashFlowStmtFileDoc1Id) {
		this.cashFlowStmtFileDoc1Id = cashFlowStmtFileDoc1Id;
	}

	public String getCashFlowStmtFileDoc1UId() {
		return cashFlowStmtFileDoc1UId;
	}

	public void setCashFlowStmtFileDoc1UId(String cashFlowStmtFileDoc1UId) {
		this.cashFlowStmtFileDoc1UId = cashFlowStmtFileDoc1UId;
	}

	public Long getCashFlowStmtFileDoc2Id() {
		return cashFlowStmtFileDoc2Id;
	}

	public void setCashFlowStmtFileDoc2Id(Long cashFlowStmtFileDoc2Id) {
		this.cashFlowStmtFileDoc2Id = cashFlowStmtFileDoc2Id;
	}

	public String getCashFlowStmtFileDoc2UId() {
		return cashFlowStmtFileDoc2UId;
	}

	public void setCashFlowStmtFileDoc2UId(String cashFlowStmtFileDoc2UId) {
		this.cashFlowStmtFileDoc2UId = cashFlowStmtFileDoc2UId;
	}

	public Long getCashFlowStmtFileDoc3Id() {
		return cashFlowStmtFileDoc3Id;
	}

	public void setCashFlowStmtFileDoc3Id(Long cashFlowStmtFileDoc3Id) {
		this.cashFlowStmtFileDoc3Id = cashFlowStmtFileDoc3Id;
	}

	public String getCashFlowStmtFileDoc3UId() {
		return cashFlowStmtFileDoc3UId;
	}

	public void setCashFlowStmtFileDoc3UId(String cashFlowStmtFileDoc3UId) {
		this.cashFlowStmtFileDoc3UId = cashFlowStmtFileDoc3UId;
	}

	public Long getAuditedReportDoc1Id() {
		return auditedReportDoc1Id;
	}

	public void setAuditedReportDoc1Id(Long auditedReportDoc1Id) {
		this.auditedReportDoc1Id = auditedReportDoc1Id;
	}

	public String getAuditedReportDoc1UId() {
		return auditedReportDoc1UId;
	}

	public void setAuditedReportDoc1UId(String auditedReportDoc1UId) {
		this.auditedReportDoc1UId = auditedReportDoc1UId;
	}

	public Long getAuditedReportDoc2Id() {
		return auditedReportDoc2Id;
	}

	public void setAuditedReportDoc2Id(Long auditedReportDoc2Id) {
		this.auditedReportDoc2Id = auditedReportDoc2Id;
	}

	public String getAuditedReportDoc2UId() {
		return auditedReportDoc2UId;
	}

	public void setAuditedReportDoc2UId(String auditedReportDoc2UId) {
		this.auditedReportDoc2UId = auditedReportDoc2UId;
	}

	public Long getAuditedReportDoc3Id() {
		return auditedReportDoc3Id;
	}

	public void setAuditedReportDoc3Id(Long auditedReportDoc3Id) {
		this.auditedReportDoc3Id = auditedReportDoc3Id;
	}

	public String getAuditedReportDoc3UId() {
		return auditedReportDoc3UId;
	}

	public void setAuditedReportDoc3UId(String auditedReportDoc3UId) {
		this.auditedReportDoc3UId = auditedReportDoc3UId;
	}

}

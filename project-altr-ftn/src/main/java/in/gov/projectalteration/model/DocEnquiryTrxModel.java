package in.gov.projectalteration.model;

public class DocEnquiryTrxModel{

	private Long responceId;
    private String code;
    private String lebel;
    private String documentType;
    private Long documentId;
    private String documentUId;
    private String status;
	private String createdBy;
	private Long processId;
	private Long prjAltId;
	
	public Long getProcessId() {
		return processId;
	}
	public void setProcessId(Long processId) {
		this.processId = processId;
	}
	public Long getResponceId() {
		return responceId;
	}
	public void setResponceId(Long responceId) {
		this.responceId = responceId;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLebel() {
		return lebel;
	}
	public void setLebel(String lebel) {
		this.lebel = lebel;
	}
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public Long getDocumentId() {
		return documentId;
	}
	public void setDocumentId(Long documentId) {
		this.documentId = documentId;
	}
	public String getDocumentUId() {
		return documentUId;
	}
	public void setDocumentUId(String documentUId) {
		this.documentUId = documentUId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Long getPrjAltId() {
		return prjAltId;
	}
	public void setPrjAltId(Long prjAltId) {
		this.prjAltId = prjAltId;
	}
	
}

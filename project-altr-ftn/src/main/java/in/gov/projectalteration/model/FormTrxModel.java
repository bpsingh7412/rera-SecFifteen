package in.gov.projectalteration.model;

public class FormTrxModel {
    private Long formId;
    private Long responceId;
    private Long referanceformId;
    private Long assignedUserId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String mobNumber;
    private String proNo;
    private String emailId;
    private String status;
    private Long processId;
    private Long proAltId;
    
    public FormTrxModel() {
    	
    }
    
    
    public FormTrxModel(Long formId, Long responceId, Long referanceformId, Long assignedUserId, String firstName,
			String middleName, String lastName, String mobNumber, String proNo, String emailId, String status,Long processId,Long proAltId) {
		super();
		this.formId = formId;
		this.responceId = responceId;
		this.referanceformId = referanceformId;
		this.assignedUserId = assignedUserId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.mobNumber = mobNumber;
		this.proNo = proNo;
		this.emailId = emailId;
		this.status = status;
		this.processId = processId;
		this.proAltId = proAltId;
	}
    
    
    
	public Long getProcessId() {
		return processId;
	}



	public void setProcessId(Long processId) {
		this.processId = processId;
	}



	public Long getFormId() {
		return formId;
	}
	public void setFormId(Long formId) {
		this.formId = formId;
	}
	public Long getResponceId() {
		return responceId;
	}
	public void setResponceId(Long responceId) {
		this.responceId = responceId;
	}
	public Long getReferanceformId() {
		return referanceformId;
	}
	public void setReferanceformId(Long referanceformId) {
		this.referanceformId = referanceformId;
	}
	public Long getAssignedUserId() {
		return assignedUserId;
	}
	public void setAssignedUserId(Long assignedUserId) {
		this.assignedUserId = assignedUserId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobNumber() {
		return mobNumber;
	}
	public void setMobNumber(String mobNumber) {
		this.mobNumber = mobNumber;
	}
	public String getProNo() {
		return proNo;
	}
	public void setProNo(String proNo) {
		this.proNo = proNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


	public Long getProAltId() {
		return proAltId;
	}


	public void setProAltId(Long proAltId) {
		this.proAltId = proAltId;
	}
	
   }

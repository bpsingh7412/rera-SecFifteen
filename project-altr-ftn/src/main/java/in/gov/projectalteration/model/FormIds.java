package in.gov.projectalteration.model;

public class FormIds {
    private Long formOneId;
    private Long formTwoId;
    private Long formThreeId;
    private Long proAltId;
    
    public FormIds() {
    	
    }
    
    
    public FormIds(Long formOneId, Long formTwoId, Long formThreeId, Long proAltId) {
		super();
		this.formOneId = formOneId;
		this.formTwoId = formTwoId;
		this.formThreeId = formThreeId;
		this.proAltId = proAltId;
	}


	public Long getFormOneId() {
		return formOneId;
	}


	public void setFormOneId(Long formOneId) {
		this.formOneId = formOneId;
	}


	public Long getFormTwoId() {
		return formTwoId;
	}


	public void setFormTwoId(Long formTwoId) {
		this.formTwoId = formTwoId;
	}


	public Long getFormThreeId() {
		return formThreeId;
	}


	public void setFormThreeId(Long formThreeId) {
		this.formThreeId = formThreeId;
	}


	public Long getProAltId() {
		return proAltId;
	}


	public void setProAltId(Long proAltId) {
		this.proAltId = proAltId;
	}
    
    
    
	
   }

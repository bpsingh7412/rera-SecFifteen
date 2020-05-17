package in.gov.projectalteration.services;

import java.util.List;

import in.gov.projectalteration.model.FormAssignmentModel;





public interface FormAssignmentDetailsServices {
  
	public FormAssignmentModel saveFormAssignmentDetails(FormAssignmentModel entitiy);

	public List<FormAssignmentModel> getAllFormAssignmentDetails();

	public FormAssignmentModel updateFormAssignmentDetails(FormAssignmentModel entitiy);	

	public FormAssignmentModel getFormAssignmentDetailsById(Long id);
	
	public List<FormAssignmentModel> getFormAssignmentDetailsByFormId(Long id);
	
	public List<FormAssignmentModel> getFormAssignmentDetailsByProfessionalId(Long id);
	
	public boolean isAssigned(Long formId);
}

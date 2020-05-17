package in.gov.projectalteration.services;

import java.util.List;

import in.gov.projectalteration.exception.ResourceNotFoundException;
import in.gov.projectalteration.model.Form2AssignmentModel;
import in.gov.projectalteration.model.FormTwoModel;



public interface FormTwoDetailsService {

	public FormTwoModel saveFromTwoDetails(FormTwoModel entitiy) throws ResourceNotFoundException;

	public List<FormTwoModel> getAllFromTwoDetails();

	public FormTwoModel updateFromTwoDetails(FormTwoModel entitiy);

	public FormTwoModel getFromTwoDetailsById(Long id);

	public FormTwoModel getFromTwoDetailsByProjectAltrId(Long id);

	public FormTwoModel saveProfessionalAssignment(Form2AssignmentModel entity)
			throws ResourceNotFoundException;
	
	public FormTwoModel updateStatus(Long id, String status) throws ResourceNotFoundException;
	
	public FormTwoModel updateStatus(Long id, String status,Long referenceForm2Id) throws ResourceNotFoundException;
	
	public FormTwoModel getFromTwoDetailsByProjectAltrIdAndStatus(Long id,String status);
}

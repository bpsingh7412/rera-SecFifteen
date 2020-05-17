package in.gov.projectalteration.services;

import java.util.List;

import in.gov.projectalteration.exception.ResourceNotFoundException;
import in.gov.projectalteration.model.Form3AssignmentModel;
import in.gov.projectalteration.model.FormThreeModel;






public interface FormThreeDetailsService {
  
	public FormThreeModel saveFormThreeDetails(FormThreeModel entitiy)throws ResourceNotFoundException ;

	public List<FormThreeModel> getAllFormThreeDetails();

	public FormThreeModel updateFormThreeDetails(FormThreeModel entitiy);	

	public FormThreeModel getFormThreeDetailsById(Long id);
	
	public FormThreeModel getFormThreeDetailsByProjectAltrId(Long id);
	
	public FormThreeModel getFormThreeDetailsByProjectAltrIdAndStatusNot(Long id,String status);
	
	public FormThreeModel assignProfessionals(Form3AssignmentModel entitiy)throws ResourceNotFoundException ;
	
	public FormThreeModel updateStatus(Long prjregid, String status) throws ResourceNotFoundException;
	public FormThreeModel updateStatus(Long prjregid, String status,Long referenceForm3Id) throws ResourceNotFoundException;

	
}

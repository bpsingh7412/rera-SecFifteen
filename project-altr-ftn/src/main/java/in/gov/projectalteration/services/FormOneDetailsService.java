package in.gov.projectalteration.services;

import java.util.List;

import org.springframework.web.client.ResourceAccessException;

import in.gov.projectalteration.exception.ResourceNotFoundException;
import in.gov.projectalteration.model.FormAssignmentModel;
import in.gov.projectalteration.model.FormOneModel;

public interface FormOneDetailsService {

	public FormOneModel saveProjectFormOnedettails(FormOneModel entitiy) throws ResourceNotFoundException;

	public List<FormOneModel> getAllFormOnedettails();

	public FormOneModel updateFormOnedettails(FormOneModel entitiy);

	public FormOneModel getFormOnedettailsById(Long id);

	public FormOneModel getFormOneByAltId(Long id);

	public FormOneModel updateStatus(Long id, String status) throws ResourceNotFoundException;

	public FormOneModel saveProfessionalAssignment(FormAssignmentModel entity) throws ResourceNotFoundException;

	public FormOneModel getFormOneByProjectAltrIdAndStatus(Long id, String status);

	public FormOneModel updateStatus(Long id, String status, Long referenceFormOneId) throws ResourceNotFoundException;
}

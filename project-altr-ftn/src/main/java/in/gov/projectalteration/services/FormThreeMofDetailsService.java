package in.gov.projectalteration.services;

import java.util.List;

import in.gov.projectalteration.exception.ResourceNotFoundException;
import in.gov.projectalteration.model.MofF3AssignmentModel;
import in.gov.projectalteration.model.MofFormThreeModel;



public interface FormThreeMofDetailsService {

	public MofFormThreeModel saveFormThreeMofDetails(MofFormThreeModel entitiy) throws ResourceNotFoundException;

	public List<MofFormThreeModel> getAllFormThreeDetails();

	public MofFormThreeModel updateFormThreeDetails(MofFormThreeModel entitiy);

	public MofFormThreeModel getFormThreeDetailsById(Long id);

	public MofFormThreeModel getFormThreeMofDetailsByResponceId(Long id);

	public MofFormThreeModel getFormThreeDetailsByResponceIdAndStatusNot(Long id, String status);

	public MofFormThreeModel assignProfessionals(MofF3AssignmentModel entitiy) throws ResourceNotFoundException;

	public MofFormThreeModel updateStatus(Long responsedId, String status) throws ResourceNotFoundException;

	public MofFormThreeModel updateStatus(Long prjregid, String status, Long referenceForm3mofId)
			throws ResourceNotFoundException;

	public MofFormThreeModel getFormThreeDetailsByprojectRegIdAndStatusNot(Long id, String rejected);
}


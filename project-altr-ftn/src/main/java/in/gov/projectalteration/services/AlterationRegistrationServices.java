package in.gov.projectalteration.services;

import java.util.List;
import java.util.Map;

import in.gov.projectalteration.exception.ResourceNotFoundException;
import in.gov.projectalteration.model.ProjectAlterationModel;
import in.gov.projectalteration.model.transaction.AssigedUserTransactionModel;
import in.gov.projectalteration.model.transaction.ProjectAlterationDto;


public interface AlterationRegistrationServices {

	public ProjectAlterationModel save(ProjectAlterationModel entitiy) throws ResourceNotFoundException;

	public List<ProjectAlterationModel> getAll();
	
	public List<ProjectAlterationModel> getAllByStatus(String statecode);

	public ProjectAlterationModel update(ProjectAlterationModel entitiy);

	public ProjectAlterationModel getById(Long id);
	public ProjectAlterationModel getByProjectAltId(Long prjAltId);
	public ProjectAlterationModel getByProjectWfoId(String wfoId);
	

	public List<ProjectAlterationModel> getByProjectId(Long id);
	
	public List<ProjectAlterationModel> getByPromoterId(Long id);

	public boolean remove(Long id) throws ResourceNotFoundException;
	public List<AssigedUserTransactionModel> getDetailsByArchitechtId(Long id)  throws ResourceNotFoundException;

	public List<AssigedUserTransactionModel> getDetailsByCaId(Long id) throws ResourceNotFoundException;
	public List<AssigedUserTransactionModel> getDetailsMofByCaId(Long id) throws ResourceNotFoundException;
    
	public List<AssigedUserTransactionModel> getDetailsByEngineerId(Long id) throws ResourceNotFoundException;
	
	public Map<String, String> getFormAssignmentStatusDetails(Long prjId) throws ResourceNotFoundException;
	public ProjectAlterationModel updateProjectApp(ProjectAlterationModel project);
	
	List<ProjectAlterationDto> getProjectAltForFilter(ProjectAlterationDto dto);
	
	public List<ProjectAlterationModel> getAllProjectList();

	public ProjectAlterationModel saveSection15(ProjectAlterationModel entity);
}

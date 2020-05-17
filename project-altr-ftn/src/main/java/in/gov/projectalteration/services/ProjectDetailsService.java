package in.gov.projectalteration.services;

import java.util.List;

import in.gov.projectalteration.exception.ResourceNotFoundException;
import in.gov.projectalteration.model.ProjectDetailModel;

public interface ProjectDetailsService {

	public ProjectDetailModel saveProjectDetails(ProjectDetailModel entitiy) throws ResourceNotFoundException;

	public List<ProjectDetailModel> getAll();

	public ProjectDetailModel updateProjectDetails(ProjectDetailModel entitiy);

	public ProjectDetailModel getProjectDetailsById(Long id);

	public ProjectDetailModel getByAlterationId(Long id);

	public List<ProjectDetailModel> getProjectDetailsByProfessionalId(Long id) throws ResourceNotFoundException;
}

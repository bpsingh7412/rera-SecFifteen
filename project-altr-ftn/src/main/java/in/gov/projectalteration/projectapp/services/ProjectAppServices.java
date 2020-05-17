package in.gov.projectalteration.projectapp.services;


import in.gov.projectalteration.model.ProjectAlterationModel;
import in.gov.projectalteration.projectapp.dto.ProjectAppRegistrationModel;




public interface ProjectAppServices {

	public ProjectAppRegistrationModel getPojectAppModel(ProjectAppRegistrationModel model,Long projectId);
	public ProjectAppRegistrationModel setPojectAppModel(ProjectAlterationModel model);
}

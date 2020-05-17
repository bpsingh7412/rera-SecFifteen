package in.gov.projectalteration.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.gov.projectalteration.model.ProjectDetailModel;

@Repository
public interface ProjectDetailsDao extends CrudRepository<ProjectDetailModel, Long> {

	public ProjectDetailModel findByProjectAltrId(Long id);

	public List<ProjectDetailModel> findByProjectName(String name);

}

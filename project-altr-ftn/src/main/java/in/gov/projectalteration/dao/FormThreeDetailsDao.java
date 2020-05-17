package in.gov.projectalteration.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.gov.projectalteration.model.FormThreeModel;




@Repository
public interface FormThreeDetailsDao extends CrudRepository<FormThreeModel,Long>{
	public FormThreeModel findByProjectAltrId(Long id);
	public List<FormThreeModel> findByAssignedUserId(Long id);
	public FormThreeModel findByProjectAltrIdAndStatusNot(Long id,String status);
}

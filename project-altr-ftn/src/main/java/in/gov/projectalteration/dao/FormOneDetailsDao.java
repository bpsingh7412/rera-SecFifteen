package in.gov.projectalteration.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.gov.projectalteration.model.FormOneModel;




@Repository
public interface FormOneDetailsDao extends CrudRepository<FormOneModel,Long>{
	FormOneModel findByProjectAltrId(Long id);
	List<FormOneModel> findByAssignedUserId(Long id);
	FormOneModel findByProjectAltrIdAndStatusNot(Long prjId,String status);
	
	
	/*
	 * @Query("select * from ") public List<Object[]> getAssignedUserList();
	 */
	
}

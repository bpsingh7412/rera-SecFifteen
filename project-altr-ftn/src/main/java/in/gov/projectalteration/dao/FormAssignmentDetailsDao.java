package in.gov.projectalteration.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.gov.projectalteration.model.FormAssignmentModel;




@Repository
public interface FormAssignmentDetailsDao extends CrudRepository<FormAssignmentModel,Long>{
   public List<FormAssignmentModel> findByAssignedFromId(Long id);
   public List<FormAssignmentModel> findByAssignedUserId(Long id);
   public List<FormAssignmentModel> findByProjectAltrIdAndEmailId(Long id,String emailId);
}

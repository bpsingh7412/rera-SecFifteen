package in.gov.projectalteration.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.gov.projectalteration.model.Form2AssignmentModel;




@Repository
public interface Form2AssignmentDetailsDao extends CrudRepository<Form2AssignmentModel,Long>{
   public List<Form2AssignmentModel> findByAssignedFromId(Long id);
   public List<Form2AssignmentModel> findByAssignedUserId(String emailId);
}

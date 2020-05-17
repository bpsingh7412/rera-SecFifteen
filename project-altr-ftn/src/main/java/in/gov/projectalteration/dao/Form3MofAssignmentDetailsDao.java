package in.gov.projectalteration.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import in.gov.projectalteration.model.MofF3AssignmentModel;

@Repository
public interface Form3MofAssignmentDetailsDao extends CrudRepository<MofF3AssignmentModel,Long>{
   public List<MofF3AssignmentModel> findByAssignedF3MofId(Long id);
   public List<MofF3AssignmentModel> findByAssignedUserId(String emailId);
}

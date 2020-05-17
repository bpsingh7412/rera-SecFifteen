package in.gov.projectalteration.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.gov.projectalteration.model.ProjectAlterationPaymentDetailsModel;




@Repository
public interface AlterationPaymentDao extends CrudRepository<ProjectAlterationPaymentDetailsModel,Long>{
	List<ProjectAlterationPaymentDetailsModel> findByProjectAltrId(Long id);
   
}

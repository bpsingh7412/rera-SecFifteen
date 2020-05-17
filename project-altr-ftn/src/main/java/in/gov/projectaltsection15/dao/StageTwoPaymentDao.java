package in.gov.projectaltsection15.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.gov.projectaltsection15.model.StageTwoPaymentModel;




@Repository
public interface StageTwoPaymentDao extends CrudRepository<StageTwoPaymentModel,Long>{
	List<StageTwoPaymentModel> findByProjectAltrId(Long id);
   
}

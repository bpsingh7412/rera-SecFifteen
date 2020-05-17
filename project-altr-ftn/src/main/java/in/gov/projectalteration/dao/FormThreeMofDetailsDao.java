package in.gov.projectalteration.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import in.gov.projectalteration.model.MofFormThreeModel;

@Repository
public interface FormThreeMofDetailsDao extends CrudRepository<MofFormThreeModel,Long>{
	
	public List<MofFormThreeModel> findByAssignedUserId(Long id);
	public MofFormThreeModel findByProjAltIdAndStatusNot(Long id,String status);
	public MofFormThreeModel findByProjAltId(Long prjregid);
}

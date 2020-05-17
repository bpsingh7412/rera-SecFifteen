package in.gov.projectalteration.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.gov.projectalteration.exception.ResourceNotFoundException;
import in.gov.projectalteration.model.FormTwoModel;

@Repository
public interface FormTwoDetailsDao extends CrudRepository<FormTwoModel, Long> {
	public List<FormTwoModel> findByAssignedUserId(Long id) throws ResourceNotFoundException;

	public FormTwoModel findByProjectAltrId(Long id);

	public FormTwoModel findByProjectAltrIdAndStatusNot(Long id, String status);
}

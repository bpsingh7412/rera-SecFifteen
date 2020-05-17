package in.gov.projectaltsection15.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.gov.projectaltsection15.model.Setion15StageTwoModel;


@Repository
public interface Section15StageTwoDao extends CrudRepository<Setion15StageTwoModel, Long> {
	public Setion15StageTwoModel findByProjectAltrId(Long altrId);
}

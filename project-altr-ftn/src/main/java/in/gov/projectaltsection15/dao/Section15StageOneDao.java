package in.gov.projectaltsection15.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.gov.projectaltsection15.model.Setion15StageOneModel;


@Repository
public interface Section15StageOneDao extends CrudRepository<Setion15StageOneModel, Long> {
	public Setion15StageOneModel findByProjectAltrId(Long altrId);
	public List<Setion15StageOneModel> findByPromoterId(Long id);
}

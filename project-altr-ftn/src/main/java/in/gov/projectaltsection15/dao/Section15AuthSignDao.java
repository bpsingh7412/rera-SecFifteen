package in.gov.projectaltsection15.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.gov.projectaltsection15.model.AuthorizedSignatoryDtlModel;


@Repository
public interface Section15AuthSignDao extends CrudRepository<AuthorizedSignatoryDtlModel, Long> {
	public AuthorizedSignatoryDtlModel getByStageTwoId(Long id);
}

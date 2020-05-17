package in.gov.projectaltsection15.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import in.gov.projectaltsection15.model.ProjectSection15BankDetails;


@Repository
public interface Section15BankDao extends CrudRepository<ProjectSection15BankDetails, Long> {

	ProjectSection15BankDetails findByStageTwoId(Long id);
	//public ProjectSection15BankDetails findById(Long bankId);
}

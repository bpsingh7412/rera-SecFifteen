package in.gov.projectaltsection15.services;

import javax.validation.Valid;
import in.gov.projectaltsection15.model.ProjectSection15BankDetails;

public interface StageTwoBankService {

	ProjectSection15BankDetails saveStageTwoBankDetails(@Valid ProjectSection15BankDetails entity, String string);

	ProjectSection15BankDetails getByStageTwoId(Long id);

	//ProjectSection15BankDetails getStageOneDetailsById(Long id);

	//Setion15StageTwoModel getByPrjAltId(Long id);




}

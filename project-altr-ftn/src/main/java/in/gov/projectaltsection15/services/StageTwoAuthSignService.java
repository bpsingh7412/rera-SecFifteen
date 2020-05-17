package in.gov.projectaltsection15.services;

import in.gov.projectaltsection15.model.AuthorizedSignatoryDtlModel;

public interface StageTwoAuthSignService {

	AuthorizedSignatoryDtlModel saveStageTwoAuthSignDetails(AuthorizedSignatoryDtlModel entity, String string);

	AuthorizedSignatoryDtlModel getByStageTwoId(Long id);

	//ProjectSection15BankDetails getStageOneDetailsById(Long id);

	//Setion15StageTwoModel getByPrjAltId(Long id);




}

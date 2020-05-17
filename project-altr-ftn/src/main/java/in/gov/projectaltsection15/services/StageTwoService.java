package in.gov.projectaltsection15.services;

import javax.validation.Valid;

import in.gov.projectaltsection15.model.Setion15StageTwoModel;

public interface StageTwoService {

	Setion15StageTwoModel saveStageTwoDetails(@Valid Setion15StageTwoModel entity, String string);

	Setion15StageTwoModel getStageOneDetailsById(Long id);

	Setion15StageTwoModel getByPrjAltId(Long id);




}

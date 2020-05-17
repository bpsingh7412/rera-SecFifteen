package in.gov.projectaltsection15.services;
import java.util.List;

import javax.validation.Valid;

import in.gov.projectaltsection15.model.Setion15StageOneModel;

public interface StageOneService {

	Setion15StageOneModel saveStageOneDetails(@Valid Setion15StageOneModel entity, String string);

	Setion15StageOneModel getStageOneDetailsById(Long id);

    Setion15StageOneModel getByPrjAltId(Long id);

    Setion15StageOneModel commitAllotteeDoc(Setion15StageOneModel pm, String string);

	List<Setion15StageOneModel> getByPromoterId(Long id);




}

package in.gov.projectaltsection15.services.impl;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import in.gov.projectalteration.common.model.DmsModel;
import in.gov.projectalteration.common.services.DmsServices;
import in.gov.projectalteration.constants.ReraConstants;
import in.gov.projectaltsection15.dao.Section15StageTwoDao;
import in.gov.projectaltsection15.model.Setion15StageTwoModel;
import in.gov.projectaltsection15.services.StageTwoService;

@Service
public class StageTwoServiceImpl implements StageTwoService {
	@Autowired
	Section15StageTwoDao dao;
	@Autowired
	DmsModel dms;

	@Autowired
	DmsServices dmsSevices;

	@Override
	public Setion15StageTwoModel saveStageTwoDetails(@Valid Setion15StageTwoModel m, String vdmsURL) {
		this.dao.save(m);
		dms.setFolderId(m.getProjectAltrId().toString());
		dms.setDocumentType(ReraConstants.SECTION_15_DOC);
		try {
			if (Optional.ofNullable(m.getAffidavitDocId()).isPresent() && m.getAffidavitDocUId() == null) {
				dms.setDocumentId(m.getAffidavitDocId());
				DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
				Optional.ofNullable(cfs3)
						.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
				m.setAffidavitDocId(cfs3.getDocumentId());
				m.setAffidavitDocUId(cfs3.getUid());
			}

			if (Optional.ofNullable(m.getFormBDocId()).isPresent() && m.getFormB1DocUId() == null) {
				dms.setDocumentId(m.getFormBDocId());
				DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
				Optional.ofNullable(cfs3)
						.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
				m.setFormBDocId(cfs3.getDocumentId());
				m.setFormBDocUId(cfs3.getUid());
			}

			if (Optional.ofNullable(m.getFormB1DocId()).isPresent() && m.getFormB1DocUId() == null) {
				dms.setDocumentId(m.getFormB1DocId());
				DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
				Optional.ofNullable(cfs3)
						.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
				m.setFormB1DocId(cfs3.getDocumentId());
				m.setFormB1DocUId(cfs3.getUid());
			}

			if (Optional.ofNullable(m.getFormB2DocId()).isPresent() && m.getFormB2DocUId() == null) {
				dms.setDocumentId(m.getFormB2DocId());
				DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
				Optional.ofNullable(cfs3)
						.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
				m.setFormB2DocId(cfs3.getDocumentId());
				m.setFormB2DocUId(cfs3.getUid());
			}

			if (Optional.ofNullable(m.getLandDocId()).isPresent() && m.getLandDocUId() == null) {
				dms.setDocumentId(m.getLandDocId());
				DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
				Optional.ofNullable(cfs3)
						.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
				m.setLandDocId(cfs3.getDocumentId());
				m.setLandDocUId(cfs3.getUid());
			}

			if (Optional.ofNullable(m.getAfsDocId()).isPresent() && m.getAfsDocUId() == null) {
				dms.setDocumentId(m.getAfsDocId());
				DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
				Optional.ofNullable(cfs3)
						.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
				m.setAfsDocId(cfs3.getDocumentId());
				m.setAfsDocUId(cfs3.getUid());
			}

			if (Optional.ofNullable(m.getSaleDeedDocId()).isPresent() && m.getSaleDeedDocUId() == null) {
				dms.setDocumentId(m.getSaleDeedDocId());
				DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
				Optional.ofNullable(cfs3)
						.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
				m.setSaleDeedDocId(cfs3.getDocumentId());
				m.setSaleDeedDocUId(cfs3.getUid());
			}

			if (Optional.ofNullable(m.getAllotmentDocId()).isPresent() && m.getAllotmentDocUId() == null) {
				dms.setDocumentId(m.getAllotmentDocId());
				DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
				Optional.ofNullable(cfs3)
						.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
				m.setAllotmentDocId(cfs3.getDocumentId());
				m.setAllotmentDocUId(cfs3.getUid());
			}

			if (Optional.ofNullable(m.getAmendedTitleDocId()).isPresent() && m.getAmendedTitleDocUId() == null) {
				dms.setDocumentId(m.getAmendedTitleDocId());
				DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
				Optional.ofNullable(cfs3)
						.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
				m.setAmendedTitleDocId(cfs3.getDocumentId());
				m.setAmendedTitleDocUId(cfs3.getUid());
			}

			if (Optional.ofNullable(m.getAmendedBuildingDocId()).isPresent() && m.getAmendedBuildingDocUId() == null) {
				dms.setDocumentId(m.getAmendedBuildingDocId());
				DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
				Optional.ofNullable(cfs3)
						.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
				m.setAmendedBuildingDocId(cfs3.getDocumentId());
				m.setAmendedBuildingDocUId(cfs3.getUid());
			}
			
			if (Optional.ofNullable(m.getPrjHeadPhotoDocId()).isPresent() && m.getPrjHeadPhotoDocUId() == null) {
				dms.setDocumentId(m.getPrjHeadPhotoDocId());
				DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
				Optional.ofNullable(cfs3)
						.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
				m.setPrjHeadPhotoDocId(cfs3.getDocumentId());
				m.setPrjHeadPhotoDocUId(cfs3.getUid());
			}
			
			if (Optional.ofNullable(m.getDraftVoucherDocId()).isPresent() && m.getDraftVoucherDocUId() == null) {
				dms.setDocumentId(m.getDraftVoucherDocId());
				DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
				Optional.ofNullable(cfs3)
						.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
				m.setDraftVoucherDocId(cfs3.getDocumentId());
				m.setDraftVoucherDocUId(cfs3.getUid());
			}
			
			if (Optional.ofNullable(m.getExecutedAggrementDocId()).isPresent() && m.getExecutedAggrementDocUId() == null) {
				dms.setDocumentId(m.getExecutedAggrementDocId());
				DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
				Optional.ofNullable(cfs3)
						.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
				m.setExecutedAggrementDocId(cfs3.getDocumentId());
				m.setExecutedAggrementDocUId(cfs3.getUid());
			}

			if (Optional.ofNullable(m.getEncumbranceDocId()).isPresent() && m.getEncumbranceDocUId() == null) {
				dms.setDocumentId(m.getEncumbranceDocId());
				DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
				Optional.ofNullable(cfs3)
						.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
				m.setEncumbranceDocId(cfs3.getDocumentId());
				m.setEncumbranceDocUId(cfs3.getUid());
			}
			
			if (Optional.ofNullable(m.getSevenTwelveDocId()).isPresent() && m.getSevenTwelveDocUId() == null) {
				dms.setDocumentId(m.getSevenTwelveDocId());
				DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
				Optional.ofNullable(cfs3)
						.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
				m.setSevenTwelveDocId(cfs3.getDocumentId());
				m.setSevenTwelveDocUId(cfs3.getUid());
			}
			
			if (Optional.ofNullable(m.getTitleClearanceDocId()).isPresent() && m.getTitleClearanceDocUId() == null) {
				dms.setDocumentId(m.getTitleClearanceDocId());
				DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
				Optional.ofNullable(cfs3)
						.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
				m.setTitleClearanceDocId(cfs3.getDocumentId());
				m.setTitleClearanceDocUId(cfs3.getUid());
			}
			
			if (Optional.ofNullable(m.getTitleReportDocId()).isPresent() && m.getTitleReportDocUId() == null) {
				dms.setDocumentId(m.getTitleReportDocId());
				DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
				Optional.ofNullable(cfs3)
						.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
				m.setTitleReportDocId(cfs3.getDocumentId());
				m.setTitleReportDocUId(cfs3.getUid());
			}
			
			if (Optional.ofNullable(m.getRegDevAggrementDocId()).isPresent() && m.getRegDevAggrementUId() == null) {
				dms.setDocumentId(m.getRegDevAggrementDocId());
				DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
				Optional.ofNullable(cfs3)
						.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
				m.setRegDevAggrementDocId(cfs3.getDocumentId());
				m.setRegDevAggrementUId(cfs3.getUid());
			}
			
			if (Optional.ofNullable(m.getPerForAlloDocId()).isPresent() && m.getPerForAlloDocUId() == null) {
				dms.setDocumentId(m.getPerForAlloDocId());
				DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
				Optional.ofNullable(cfs3)
						.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
				m.setPerForAlloDocId(cfs3.getDocumentId());
				m.setPerForAlloDocUId(cfs3.getUid());
			}
			
			if (Optional.ofNullable(m.getPerForSaleAgrDocId()).isPresent() && m.getPerForSaleAgrDocUId() == null) {
				dms.setDocumentId(m.getPerForSaleAgrDocId());
				DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
				Optional.ofNullable(cfs3)
						.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
				m.setPerForSaleAgrDocId(cfs3.getDocumentId());
				m.setPerForSaleAgrDocUId(cfs3.getUid());
			}
			
			if (Optional.ofNullable(m.getPerForSaleDeedDocId()).isPresent() && m.getPerForSaleDeedDocUId() == null) {
				dms.setDocumentId(m.getPerForSaleDeedDocId());
				DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
				Optional.ofNullable(cfs3)
						.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
				m.setPerForSaleDeedDocId(cfs3.getDocumentId());
				m.setPerForSaleDeedDocUId(cfs3.getUid());
			}
			
			if (Optional.ofNullable(m.getPropertyCardId()).isPresent() && m.getPropertyCardUId() == null) {
				dms.setDocumentId(m.getPropertyCardId());
				DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
				Optional.ofNullable(cfs3)
						.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
				m.setPropertyCardId(cfs3.getDocumentId());
				m.setPropertyCardUId(cfs3.getUid());
			}
			
			if (Optional.ofNullable(m.getPropertyCardId2()).isPresent() && m.getPropertyCardUId2() == null) {
				dms.setDocumentId(m.getPropertyCardId2());
				DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
				Optional.ofNullable(cfs3)
						.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
				m.setPropertyCardId2(cfs3.getDocumentId());
				m.setPropertyCardUId2(cfs3.getUid());
			}
			
			if (Optional.ofNullable(m.getPropertyCardId3()).isPresent() && m.getPropertyCardUId3() == null) {
				dms.setDocumentId(m.getPropertyCardId3());
				DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
				Optional.ofNullable(cfs3)
						.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
				m.setPropertyCardId3(cfs3.getDocumentId());
				m.setPropertyCardUId3(cfs3.getUid());
			}
			
		} catch (Exception e) {
			System.out.println("Some issue in stage two document commit");
		}
		return this.dao.save(m);
	}

	@Override
	public Setion15StageTwoModel getStageOneDetailsById(Long id) {
		return this.dao.findByProjectAltrId(id);
	}

	@Override
	public Setion15StageTwoModel getByPrjAltId(Long id) {
		return this.dao.findByProjectAltrId(id);
	}

}

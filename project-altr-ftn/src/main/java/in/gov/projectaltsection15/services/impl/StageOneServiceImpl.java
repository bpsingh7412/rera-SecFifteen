package in.gov.projectaltsection15.services.impl;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import in.gov.projectalteration.common.model.DmsModel;
import in.gov.projectalteration.common.services.DmsServices;
import in.gov.projectalteration.constants.ReraConstants;
import in.gov.projectaltsection15.dao.Section15StageOneDao;
import in.gov.projectaltsection15.model.Setion15StageOneModel;
import in.gov.projectaltsection15.services.StageOneService;

@Service
public class StageOneServiceImpl implements StageOneService {
	@Autowired
	Section15StageOneDao dao;
	
	@Autowired
	DmsModel dms;

	@Autowired
	DmsServices dmsSevices;

	
	@Override
	public Setion15StageOneModel saveStageOneDetails(@Valid Setion15StageOneModel m,String vdmsURL) {
		this.dao.save(m);
		dms.setFolderId(m.getProjectAltrId().toString());
		dms.setDocumentType(ReraConstants.SECTION_15_DOC);
		try {
		if (Optional.ofNullable(m.getAloContentNotDocId()).isPresent() && m.getAloContentNotDocUId()==null) {
			dms.setDocumentId(m.getAloContentNotDocId());
			DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
			Optional.ofNullable(cfs3)
					.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
			m.setAloContentNotDocId(cfs3.getDocumentId());
			m.setAloContentNotDocUId(cfs3.getUid());
		}
		
		if (Optional.ofNullable(m.getAuditedBalSheetYear1Id()).isPresent() && m.getAuditedBalSheetYear1UId()==null) {
			dms.setDocumentId(m.getAuditedBalSheetYear1Id());
			DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
			Optional.ofNullable(cfs3)
					.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
			m.setAuditedBalSheetYear1Id(cfs3.getDocumentId());
			m.setAuditedBalSheetYear1UId(cfs3.getUid());
		}
		
		if (Optional.ofNullable(m.getAuditedBalSheetYear2Id()).isPresent() && m.getAuditedBalSheetYear2UId()==null) {
			dms.setDocumentId(m.getAuditedBalSheetYear2Id());
			DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
			Optional.ofNullable(cfs3)
					.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
			m.setAuditedBalSheetYear2Id(cfs3.getDocumentId());
			m.setAuditedBalSheetYear2UId(cfs3.getUid());
		}
		
		if (Optional.ofNullable(m.getAuditedBalSheetYear3Id()).isPresent() && m.getAuditedBalSheetYear3UId()==null) {
			dms.setDocumentId(m.getAuditedBalSheetYear3Id());
			DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
			Optional.ofNullable(cfs3)
					.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
			m.setAuditedBalSheetYear3Id(cfs3.getDocumentId());
			m.setAuditedBalSheetYear3UId(cfs3.getUid());
		}
		
		if (Optional.ofNullable(m.getAuditedProfitLossSheetYear1Id()).isPresent() && m.getAuditedProfitLossSheetYear1UId()==null) {
			dms.setDocumentId(m.getAuditedProfitLossSheetYear1Id());
			DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
			Optional.ofNullable(cfs3)
					.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
			m.setAuditedProfitLossSheetYear1Id(cfs3.getDocumentId());
			m.setAuditedProfitLossSheetYear1UId(cfs3.getUid());
		}
		
		if (Optional.ofNullable(m.getAuditedProfitLossSheetYear2Id()).isPresent() && m.getAuditedProfitLossSheetYear2UId()==null) {
			dms.setDocumentId(m.getAuditedProfitLossSheetYear2Id());
			DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
			Optional.ofNullable(cfs3)
					.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
			m.setAuditedProfitLossSheetYear2Id(cfs3.getDocumentId());
			m.setAuditedProfitLossSheetYear2UId(cfs3.getUid());
		}
		
		if (Optional.ofNullable(m.getAuditedProfitLossSheetYear3Id()).isPresent() && m.getAuditedProfitLossSheetYear3UId()==null) {
			dms.setDocumentId(m.getAuditedProfitLossSheetYear3Id());
			DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
			Optional.ofNullable(cfs3)
					.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
			m.setAuditedProfitLossSheetYear3Id(cfs3.getDocumentId());
			m.setAuditedProfitLossSheetYear3UId(cfs3.getUid());
		}
		
		if (Optional.ofNullable(m.getCashFlowStmtYear1Id()).isPresent() && m.getCashFlowStmtYear1UId()==null) {
			dms.setDocumentId(m.getCashFlowStmtYear1Id());
			DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
			Optional.ofNullable(cfs3)
					.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
			m.setCashFlowStmtYear1Id(cfs3.getDocumentId());
			m.setCashFlowStmtYear1UId(cfs3.getUid());
		}
		
		if (Optional.ofNullable(m.getCashFlowStmtYear2Id()).isPresent() && m.getCashFlowStmtYear2UId()==null) {
			dms.setDocumentId(m.getCashFlowStmtYear2Id());
			DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
			Optional.ofNullable(cfs3)
					.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
			m.setCashFlowStmtYear2Id(cfs3.getDocumentId());
			m.setCashFlowStmtYear2UId(cfs3.getUid());
		}
		
		if (Optional.ofNullable(m.getCashFlowStmtYear3Id()).isPresent() && m.getCashFlowStmtYear3UId()==null) {
			dms.setDocumentId(m.getCashFlowStmtYear3Id());
			DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
			Optional.ofNullable(cfs3)
					.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
			m.setCashFlowStmtYear3Id(cfs3.getDocumentId());
			m.setCashFlowStmtYear3UId(cfs3.getUid());
		}
		
		if (Optional.ofNullable(m.getTransferAggrementDocId()).isPresent() && m.getTransferAggrementDocUId()==null) {
			dms.setDocumentId(m.getTransferAggrementDocId());
			DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
			Optional.ofNullable(cfs3)
					.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
			m.setTransferAggrementDocId(cfs3.getDocumentId());
			m.setTransferAggrementDocUId(cfs3.getUid());
		}
		
		if (Optional.ofNullable(m.getAuditedReportYear1Id()).isPresent() && m.getAuditedReportYear1UId()==null) {
			dms.setDocumentId(m.getAuditedReportYear1Id());
			DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
			Optional.ofNullable(cfs3)
					.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
			m.setAuditedReportYear1Id(cfs3.getDocumentId());
			m.setAuditedReportYear1UId(cfs3.getUid());
		}
		
		if (Optional.ofNullable(m.getAuditedReportYear2Id()).isPresent() && m.getAuditedReportYear2UId()==null) {
			dms.setDocumentId(m.getAuditedReportYear2Id());
			DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
			Optional.ofNullable(cfs3)
					.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
			m.setAuditedReportYear2Id(cfs3.getDocumentId());
			m.setAuditedReportYear2UId(cfs3.getUid());
		}
		
		if (Optional.ofNullable(m.getAuditedReportYear3Id()).isPresent() && m.getAuditedReportYear3UId()==null) {
			dms.setDocumentId(m.getAuditedReportYear3Id());
			DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
			Optional.ofNullable(cfs3)
					.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
			m.setAuditedReportYear3Id(cfs3.getDocumentId());
			m.setAuditedReportYear3UId(cfs3.getUid());
		}
		
		if (Optional.ofNullable(m.getErsPromaffidavitDocId()).isPresent() && m.getErsPromaffidavitDocUId()==null) {
			dms.setDocumentId(m.getErsPromaffidavitDocId());
			DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
			Optional.ofNullable(cfs3)
					.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
			m.setErsPromaffidavitDocId(cfs3.getDocumentId());
			m.setErsPromaffidavitDocUId(cfs3.getUid());
		}
		
		if (Optional.ofNullable(m.getIntendPromaffidavitDocId()).isPresent() && m.getIntendPromaffidavitDocUId()==null) {
			dms.setDocumentId(m.getIntendPromaffidavitDocId());
			DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
			Optional.ofNullable(cfs3)
					.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
			m.setIntendPromaffidavitDocId(cfs3.getDocumentId());
			m.setIntendPromaffidavitDocUId(cfs3.getUid());
		}
		
		if (Optional.ofNullable(m.getEncumbranceDocId()).isPresent() && m.getEncumbranceDocUId()==null) {
			dms.setDocumentId(m.getEncumbranceDocId());
			DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
			Optional.ofNullable(cfs3)
					.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
			m.setEncumbranceDocId(cfs3.getDocumentId());
			m.setEncumbranceDocUId(cfs3.getUid());
		}
		
		if (Optional.ofNullable(m.getIntendExperienceCertDocId()).isPresent() && m.getIntendExperienceCertDocUId()==null) {
			dms.setDocumentId(m.getIntendExperienceCertDocId());
			DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
			Optional.ofNullable(cfs3)
					.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
			m.setIntendExperienceCertDocId(cfs3.getDocumentId());
			m.setIntendExperienceCertDocUId(cfs3.getUid());
		}
		
		if (Optional.ofNullable(m.getDirectersReportYear1Id()).isPresent() && m.getDirectersReportYear1UId()==null) {
			dms.setDocumentId(m.getDirectersReportYear1Id());
			DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
			Optional.ofNullable(cfs3)
					.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
			m.setDirectersReportYear1Id(cfs3.getDocumentId());
			m.setDirectersReportYear1UId(cfs3.getUid());
		}
		
		if (Optional.ofNullable(m.getDirectersReportYear2Id()).isPresent() && m.getDirectersReportYear2UId()==null) {
			dms.setDocumentId(m.getDirectersReportYear2Id());
			DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
			Optional.ofNullable(cfs3)
					.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
			m.setDirectersReportYear2Id(cfs3.getDocumentId());
			m.setDirectersReportYear2UId(cfs3.getUid());
		}
		
		if (Optional.ofNullable(m.getDirectersReportYear3Id()).isPresent() && m.getDirectersReportYear3UId()==null) {
			dms.setDocumentId(m.getDirectersReportYear3Id());
			DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
			Optional.ofNullable(cfs3)
					.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
			m.setDirectersReportYear3Id(cfs3.getDocumentId());
			m.setDirectersReportYear3UId(cfs3.getUid());
		}
		
		if (Optional.ofNullable(m.getItrReturnDocId()).isPresent() && m.getItrReturnDocUId()==null) {
			dms.setDocumentId(m.getItrReturnDocId());
			DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
			Optional.ofNullable(cfs3)
					.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
			m.setItrReturnDocId(cfs3.getDocumentId());
			m.setItrReturnDocUId(cfs3.getUid());
		}
		if (Optional.ofNullable(m.getItrReturnDocYear1Id()).isPresent() && m.getItrReturnDocYear1UId()==null) {
			dms.setDocumentId(m.getItrReturnDocYear1Id());
			DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
			Optional.ofNullable(cfs3)
					.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
			m.setItrReturnDocYear1Id(cfs3.getDocumentId());
			m.setItrReturnDocYear1UId(cfs3.getUid());
		}
		if (Optional.ofNullable(m.getItrReturnDocYear2Id()).isPresent() && m.getItrReturnDocYear2UId()==null) {
			dms.setDocumentId(m.getItrReturnDocYear2Id());
			DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
			Optional.ofNullable(cfs3)
					.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
			m.setItrReturnDocYear2Id(cfs3.getDocumentId());
			m.setItrReturnDocYear2UId(cfs3.getUid());
		}
		if (Optional.ofNullable(m.getItrReturnDocYear3Id()).isPresent() && m.getItrReturnDocYear3UId()==null) {
			dms.setDocumentId(m.getItrReturnDocYear3Id());
			DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsURL);
			Optional.ofNullable(cfs3)
					.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
			m.setItrReturnDocYear3Id(cfs3.getDocumentId());
			m.setItrReturnDocYear3UId(cfs3.getUid());
		}
		
		}
		catch(Exception e)
		{
			System.out.println("some problem in document commit");
		}
		
		return this.dao.save(m);
	}

	@Override
	public Setion15StageOneModel getStageOneDetailsById(Long id) {
		return this.dao.findByProjectAltrId(id);
	}

	@Override
	public Setion15StageOneModel getByPrjAltId(Long id) {
		return this.dao.findByProjectAltrId(id);
	}

	@Override
	public Setion15StageOneModel commitAllotteeDoc(Setion15StageOneModel m,String vdmsUrl) {
		try
		{
		if (Optional.ofNullable(m.getAloContentNotDocId()).isPresent()) {
			dms.setFolderId(m.getProjectAltrId().toString());
			dms.setDocumentId(m.getAloContentNotDocId());
			dms.setDocumentType(ReraConstants.SECTION_15_DOC);
			DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsUrl);
			Optional.ofNullable(cfs3)
					.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
			m.setAloContentNotDocId(cfs3.getDocumentId());
			m.setAloContentNotDocUId(cfs3.getUid());
		}
		}
		catch(Exception e)
		{
			
		}
		return this.dao.save(m);
	}

	@Override
	public List<Setion15StageOneModel> getByPromoterId(Long id) {
		return dao.findByPromoterId(id);
	}
	
	

}

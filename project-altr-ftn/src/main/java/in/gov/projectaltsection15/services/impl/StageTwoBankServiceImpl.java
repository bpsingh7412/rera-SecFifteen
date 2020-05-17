package in.gov.projectaltsection15.services.impl;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import in.gov.projectalteration.common.model.DmsModel;
import in.gov.projectalteration.common.services.DmsServices;
import in.gov.projectalteration.constants.ReraConstants;
import in.gov.projectaltsection15.dao.Section15BankDao;
import in.gov.projectaltsection15.model.ProjectSection15BankDetails;
import in.gov.projectaltsection15.services.StageTwoBankService;

@Service
public class StageTwoBankServiceImpl implements StageTwoBankService {
	@Autowired
	Section15BankDao dao;
	
	@Autowired
	DmsModel dms;

	@Autowired
	DmsServices dmsSevices;

	@Override
	public ProjectSection15BankDetails saveStageTwoBankDetails(@Valid ProjectSection15BankDetails entity,
			String vdmsUrl) {
		this.dao.save(entity);
		dms.setFolderId(entity.getProjectBankId() .toString());
		dms.setDocumentType(ReraConstants.SECTION_15_DOC);
		try {
		if (Optional.ofNullable(entity.getBankerCertificateDocId()).isPresent() && entity.getBankerCertificateDocUId()==null) {
			dms.setDocumentId(entity.getBankerCertificateDocId());
			DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsUrl);
			Optional.ofNullable(cfs3)
					.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
			entity.setBankerCertificateDocId(cfs3.getDocumentId());
			entity.setBankerCertificateDocUId(cfs3.getUid());
		}
		if (Optional.ofNullable(entity.getPassBookCopyDocId()).isPresent() && entity.getPassBookCopyDocUId()==null) {
			dms.setDocumentId(entity.getPassBookCopyDocId());
			DmsModel cfs3 = dmsSevices.commitDoc(dms, vdmsUrl);
			Optional.ofNullable(cfs3)
					.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
			entity.setPassBookCopyDocId(cfs3.getDocumentId());
			entity.setPassBookCopyDocUId(cfs3.getUid());
		}
		}
		catch(Exception e)
		{
			System.out.println("some problem in document commit");
		}
		
		return dao.save(entity);
	}

	@Override
	public ProjectSection15BankDetails getByStageTwoId(Long id) {
		// TODO Auto-generated method stub
		return dao.findByStageTwoId(id);
	}

	
	
	

}

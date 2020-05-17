package in.gov.projectaltsection15.services.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.gov.projectalteration.common.model.DmsModel;
import in.gov.projectalteration.common.services.DmsServices;
import in.gov.projectaltsection15.dao.Section15AuthSignDao;
import in.gov.projectaltsection15.model.AuthorizedSignatoryDtlModel;
import in.gov.projectaltsection15.services.StageTwoAuthSignService;

@Service
public class StageTwoAuthSignServiceImpl implements StageTwoAuthSignService {
	@Autowired
	Section15AuthSignDao dao;
	@Autowired
	DmsModel dms;

	@Autowired
	DmsServices dmsSevices;

	@Override
	public AuthorizedSignatoryDtlModel saveStageTwoAuthSignDetails(AuthorizedSignatoryDtlModel entity,
			String string) {
		return dao.save(entity);
	}

	@Override
	public AuthorizedSignatoryDtlModel getByStageTwoId(Long id) {
		return dao.getByStageTwoId(id);
	}
}

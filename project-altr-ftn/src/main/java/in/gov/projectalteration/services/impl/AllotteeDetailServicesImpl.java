package in.gov.projectalteration.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import in.gov.projectalteration.dao.AllotteeDao;
import in.gov.projectalteration.model.AllotteeDetailModel;
import in.gov.projectalteration.services.AllotteeDetailServices;

@Service
public class AllotteeDetailServicesImpl implements AllotteeDetailServices {
	@Autowired
	AllotteeDao dao;

	@Override
	public AllotteeDetailModel save(AllotteeDetailModel entity) {
		return dao.save(entity);
	}

	@Override
	public AllotteeDetailModel update(AllotteeDetailModel entity) {
		Optional<AllotteeDetailModel> op=dao.findById(entity.getAllotteeId());
		AllotteeDetailModel m=new AllotteeDetailModel();
		if(op.isPresent()) {
			m=dao.save(entity);
		}else {
			throw new ResourceAccessException("data not found");
		}
		return m;
	}

	@Override
	public List<AllotteeDetailModel> getAll() {
		return dao.findAll();
	}

	@Override
	public AllotteeDetailModel getById(Long id) {
		AllotteeDetailModel m=null;
		Optional<AllotteeDetailModel> op=dao.findById(id);
		if(op.isPresent()){
			m=op.get();
		}else {
			throw new ResourceAccessException("id not found");
		}
		return m;
	}


	@Override
	public List<AllotteeDetailModel> getByAllotteeMobile( String allotteeMobile) {
		return dao.findByAllotteeMobile(allotteeMobile);
	}

	@Override
	public List<AllotteeDetailModel> getByPrjAltIdAndAllotteeMobile(Long prjId, String allotteeMobile) {
		return dao.findByPrjAltIdAndAllotteeMobile(prjId, allotteeMobile);
	}
	@Override
	public AllotteeDetailModel getByKycProjectId(String kycid, Long prjId) {
		return dao.findByKycIdAndPrjId(kycid, prjId);
	}
	
}

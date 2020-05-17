package in.gov.projectalteration.services;

import java.util.List;

import in.gov.projectalteration.model.AllotteeDetailModel;

public interface AllotteeDetailServices {

	public AllotteeDetailModel save(AllotteeDetailModel entity);

	public AllotteeDetailModel update(AllotteeDetailModel entity);

	public List<AllotteeDetailModel> getAll();

	public AllotteeDetailModel getById(Long id);
	
	public List<AllotteeDetailModel> getByAllotteeMobile(String allotteeMobile);
	
	public List<AllotteeDetailModel> getByPrjAltIdAndAllotteeMobile(Long prjId,String allotteeMobile);

	public AllotteeDetailModel getByKycProjectId(String kycid,Long prjId);
}

package in.gov.projectalteration.common.services;

import java.util.List;

import in.gov.projectalteration.common.model.DmsModel;



public interface DmsServices {

	public DmsModel commitDoc(DmsModel model,String url);
	public List<DmsModel> commitDoc(List<DmsModel> model,String url);
}

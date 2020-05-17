package in.gov.projectalteration.projectapp.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import in.gov.projectalteration.model.ProjectAlterationPaymentDetailsModel;



public class ProjectAppPaymentDetailModel implements Serializable {

	private static final long serialVersionUID = -8616903762245074717L;


	private Long paymentId;

	private Long prjRegId;	
	 
	
	Set<ProjectAppPaymentHistoryModel> paymentDetailsList;

	public Long getPaymentId() {
		return paymentId;
	}

	public Set<ProjectAppPaymentHistoryModel> getPaymentDetailsList() {
		return paymentDetailsList;
	}

	public void setPaymentDetailsList(Set<ProjectAppPaymentHistoryModel> paymentDetailsList) {
		this.paymentDetailsList = paymentDetailsList;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public Long getPrjRegId() {
		return prjRegId;
	}

	public void setPrjRegId(Long prjRegId) {
		this.prjRegId = prjRegId;
	}

	

}

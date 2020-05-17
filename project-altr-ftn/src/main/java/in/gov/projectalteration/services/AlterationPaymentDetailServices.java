package in.gov.projectalteration.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import in.gov.projectalteration.exception.ResourceNotFoundException;
import in.gov.projectalteration.model.ProjectAlterationPaymentDetailsModel;
import in.gov.projectalteration.model.transaction.PaymentTransactionModel;



public interface AlterationPaymentDetailServices {
  
	public ProjectAlterationPaymentDetailsModel savePaymentDetail(ProjectAlterationPaymentDetailsModel entity);

	public List<ProjectAlterationPaymentDetailsModel> getAllPaymentDetail();

	public ProjectAlterationPaymentDetailsModel updatePaymentDetail(ProjectAlterationPaymentDetailsModel entitiy,HttpServletRequest req);
	
	public ProjectAlterationPaymentDetailsModel getPaymentFee(Long id);	

	public ProjectAlterationPaymentDetailsModel getPaymentDetailById(Long id);
	
	public List<ProjectAlterationPaymentDetailsModel> getPaymentDetailByProjectId(Long id);
	
	public PaymentTransactionModel getTransactiondetails(ProjectAlterationPaymentDetailsModel tmodel)throws ResourceNotFoundException;
}

package in.gov.projectaltsection15.services;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import in.gov.projectalteration.exception.ResourceNotFoundException;
import in.gov.projectalteration.model.transaction.PaymentTransactionModel;
import in.gov.projectaltsection15.model.StageTwoPaymentModel;

public interface StageTwoPaymentServices {
  
	public StageTwoPaymentModel savePaymentDetail(StageTwoPaymentModel entity);

	public List<StageTwoPaymentModel> getAllPaymentDetail();

	public StageTwoPaymentModel updatePaymentDetail(StageTwoPaymentModel entitiy,HttpServletRequest req);
	
	public StageTwoPaymentModel getPaymentFee(Long id);	

	public StageTwoPaymentModel getPaymentDetailById(Long id);
	
	public List<StageTwoPaymentModel> getPaymentDetailByProjectId(Long id);
	
	public PaymentTransactionModel getTransactiondetails(StageTwoPaymentModel tmodel)throws ResourceNotFoundException;
}

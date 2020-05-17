package in.gov.projectaltsection15.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import in.gov.projectalteration.common.PaymentTokenNumber;
import in.gov.projectalteration.common.ProjectFeeCalculator;
import in.gov.projectalteration.common.services.impl.ProjectAltAckNumberGeneration;
import in.gov.projectalteration.constants.ReraConstants;
import in.gov.projectalteration.dao.ProjectAlterationDetailsDao;
import in.gov.projectalteration.exception.ResourceNotFoundException;
import in.gov.projectalteration.model.ProjectAlterationModel;
import in.gov.projectalteration.model.transaction.PaymentTransactionModel;
import in.gov.projectaltsection15.dao.StageTwoPaymentDao;
import in.gov.projectaltsection15.model.StageTwoPaymentModel;
import in.gov.projectaltsection15.services.StageTwoPaymentServices;
import in.gov.wf.util.WorkflowEngine;


@Service
public class StageTwoPaymentServiceImpl implements StageTwoPaymentServices {
	private static final Logger LOGGER = LogManager.getLogger(StageTwoPaymentServiceImpl.class);
	@Autowired
	StageTwoPaymentDao dao;

	@Autowired
	ProjectAlterationDetailsDao prjAltDao;

	@Autowired
	ProjectFeeCalculator prjAltCal;

	@Autowired
	PaymentTransactionModel paymentTransactionModel;

	/*
	 * @Autowired ProjectAppRegistrationService projectAppService;
	 */
	@Override
	public StageTwoPaymentModel savePaymentDetail(StageTwoPaymentModel entity) {
		LOGGER.debug("alteration savePaymentDetail : start");
		StageTwoPaymentModel m = entity;
		if (prjAltDao.findById(entity.getProjectAltrId()).isPresent()) {
			ProjectAlterationModel projectAlt = prjAltDao.findById(entity.getProjectAltrId()).get();
			if (Optional.ofNullable(projectAlt.getStageTwoPayment()).isPresent()) {
			  m=projectAlt.getStageTwoPayment();
			  }  
			  else {
			  projectAlt.setStageTwoPayment(m);
			  m =prjAltDao.save(projectAlt).getStageTwoPayment();
			  }
		} else {
			throw new ResourceAccessException("Project not exist");
		}
		LOGGER.debug("return payment id  :"+m.getPaymentId());
		return m;
	}

	@Override
	public List<StageTwoPaymentModel> getAllPaymentDetail() {
		List<StageTwoPaymentModel> l = new ArrayList<StageTwoPaymentModel>();
		dao.findAll().iterator().forEachRemaining(l::add);
		return l;
	}
	@Autowired
WorkflowEngine engine;
	
	@Override
	public StageTwoPaymentModel updatePaymentDetail(StageTwoPaymentModel entity,HttpServletRequest req) {
		LOGGER.debug("alteration updatePaymentDetail : start");
		StageTwoPaymentModel m = entity;
		//Optional<StageTwoPaymentModel> op = dao.findById(entity.getPaymentId());
		ProjectAlterationModel projectAlt = prjAltDao.findById(entity.getProjectAltrId()).get();
			if (prjAltDao.findById(entity.getProjectAltrId()).isPresent()) {
				StageTwoPaymentModel oldPaymentModel = projectAlt.getStageTwoPayment();
				if ("SUCCESS".contentEquals(entity.getStatus())) {
					oldPaymentModel.setSbiReferanceNo(entity.getSbiReferanceNo());
					oldPaymentModel.setTokenNo(entity.getTokenNo());
					oldPaymentModel.setStatus(entity.getStatus());
					oldPaymentModel.setTransactionNo(entity.getTransactionNo());
					if(ReraConstants.COMPLETED.equals(projectAlt.getStageOneStatus()))
					{
						projectAlt.setProjectStageOneAltAckNo(projectAlt.getProjectAltAckNo());
					}
					String ackno = ProjectAltAckNumberGeneration.getApplicationNo(projectAlt.getProjectDetailModel(),projectAlt);
					projectAlt.setProjectAltAckNo(ackno);
					projectAlt.setAppSubmissionDate(new Date());
					projectAlt.setStatus("PENDING");
					ProjectAlterationModel updatedProject = prjAltDao.save(projectAlt);
					engine.createNewTransaction(updatedProject, "SUBMIT", req);
					//projectAppService.saveprojectAppByProject(updatedProject);
				} else if ("BOOKED".contentEquals(entity.getStatus()) || "PENDING".equals(entity.getStatus())) {
					oldPaymentModel.setStatus(entity.getStatus());
				} else {
					projectAlt.setStageTwoPayment(m);
				}
		} else {
			throw new ResourceAccessException("Project is not found");
		}
			
			LOGGER.debug("alteration updatePaymentDetail : End");
		return projectAlt.getStageTwoPayment();
	}

	@Override
	public StageTwoPaymentModel getPaymentDetailById(Long id) {
		return dao.findById(id).get();
	}

	@Override
	public List<StageTwoPaymentModel> getPaymentDetailByProjectId(Long id) {
		return dao.findByProjectAltrId(id);
	}

	@Override
	public StageTwoPaymentModel getPaymentFee(Long prjAltId) {
		System.out.println("Project fee calculation");
		ProjectAlterationModel prm = prjAltDao.findById(prjAltId).get();
		Double amt = prjAltCal.getProjectAltFee(prm);
		String token = PaymentTokenNumber.generateProjAlterToken();
		System.out.println("Project fee:" + amt + ",token:" + token);
		StageTwoPaymentModel m = new StageTwoPaymentModel();
		m.setProjectAltrId(prjAltId);
		m.setAmount(amt);
		m.setTotalProjectAmount(amt);
		m.setPenaltyAmount(0.0);
		m.setTokenNo(token);
		m.setStatus(ReraConstants.SENT);
		return m;
	}

	// @Override
	public StageTwoPaymentModel setPaymentFeeByStatus() {
		System.out.println("Project fee calculation");
		StageTwoPaymentModel m = new StageTwoPaymentModel();
		/*
		 * ProjectAlterationModel prm= prjAltDao.findById(prjId).get();
		 * 
		 * Double amt=prjAltCal.getProjectRegFee(prm); String
		 * token=PaymentTokenNumber.generateToken(prm);
		 * System.out.println("Project fee:"+amt+",token:"+token);
		 * StageTwoPaymentModel m=new StageTwoPaymentModel();
		 * m.setPrjRegId(prjId); m.setAmount(amt); m.setPenaltyAmount(0.0);
		 * m.setTotalProjectAmount(amt); m.setTokenNo(token);
		 * m.setStatus(ReraConstants.SENT);
		 */

		return m;
	}

	@Override
	public PaymentTransactionModel getTransactiondetails(StageTwoPaymentModel tmodel)
			throws ResourceNotFoundException {
		LOGGER.debug("alteration getTransactiondetails : start");
		ProjectAlterationModel pm = prjAltDao.findById(tmodel.getProjectAltrId()).get();
		try {
			paymentTransactionModel.setProjectId(pm.getProjectRegId());
			paymentTransactionModel.setPaymentId(pm.getStageTwoPayment().getPaymentId());
			paymentTransactionModel.setEmailId(pm.getStageOneList().get(0).getPromoteremailId());
			paymentTransactionModel.setMobileNo(pm.getStageOneList().get(0).getPromoterMobileNo());
			paymentTransactionModel.setPaymentRemarks("");
			paymentTransactionModel.setPenaltyAmount(pm.getStageTwoPayment().getPenaltyAmount());
			paymentTransactionModel.setProcessId(pm.getProjectAltrId());
			paymentTransactionModel.setProcessName(ReraConstants.PROJECT_ALT_15);
			paymentTransactionModel.setPromoterId(pm.getStageOneList().get(0).getPromoterId().toString());
			paymentTransactionModel.setRedirectUrl("");
			paymentTransactionModel.setRegistraionType(pm.getProjectType());
			paymentTransactionModel.setSbiReferanceNo(pm.getStageTwoPayment().getSbiReferanceNo());
			paymentTransactionModel.setAmount(pm.getStageTwoPayment().getAmount());
			paymentTransactionModel.setStatus(pm.getStageTwoPayment().getStatus());
			paymentTransactionModel.setTokenNo(pm.getStageTwoPayment().getTokenNo());
			paymentTransactionModel.setTotalProjectAmount(pm.getStageTwoPayment().getTotalProjectAmount());
			paymentTransactionModel.setTransactionNo(pm.getStageTwoPayment().getTransactionNo());
			paymentTransactionModel.setUserName(pm.getStageOneList().get(0).getPromoterName());
			paymentTransactionModel.setAknowledgementNo(pm.getProjectAltAckNo());
			paymentTransactionModel.setPaymentStatus(pm.getStageTwoPayment().getStatus());
			paymentTransactionModel.setProjectSubmission(pm.getAppSubmissionDate());
		} catch (Exception e) {
			throw new ResourceAccessException("Error : paymentTransactionModel"+e.getMessage());
		}
		LOGGER.debug("alteration getTransactiondetails : End");
		return paymentTransactionModel;
	}
	
	
	
	/*
	 * Example of injecting prototype bean in singleton bean but it slow compare to new keyword initialization
	 * @Lookup private PaymentTransactionModel getPaymentTransactionModel() { return
	 * null; }
	 */
}

package in.gov.projectalteration.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import in.gov.projectalteration.common.PaymentTokenNumber;
import in.gov.projectalteration.common.ProjectFeeCalculator;
import in.gov.projectalteration.common.services.impl.ProjectAltAckNumberGeneration;
import in.gov.projectalteration.constants.ReraConstants;
import in.gov.projectalteration.dao.AlterationPaymentDao;
import in.gov.projectalteration.dao.ProjectAlterationDetailsDao;
import in.gov.projectalteration.exception.ResourceNotFoundException;
import in.gov.projectalteration.model.ProjectAlterationModel;
import in.gov.projectalteration.model.ProjectAlterationPaymentDetailsModel;
import in.gov.projectalteration.model.transaction.PaymentTransactionModel;
import in.gov.projectalteration.services.AlterationPaymentDetailServices;
import in.gov.wf.util.WorkflowEngine;


@Service
public class AlterationPaymentDetailsServiceImpl implements AlterationPaymentDetailServices {
	private static final Logger LOGGER = LogManager.getLogger(AlterationPaymentDetailServices.class);
	@Autowired
	AlterationPaymentDao dao;

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
	public ProjectAlterationPaymentDetailsModel savePaymentDetail(ProjectAlterationPaymentDetailsModel entity) {
		LOGGER.debug("alteration savePaymentDetail : start");
		ProjectAlterationPaymentDetailsModel m = entity;
		
		if (prjAltDao.findById(entity.getProjectAltrId()).isPresent()) {
			ProjectAlterationModel projectAlt = prjAltDao.findById(entity.getProjectAltrId()).get();
			
			/*
			 * List<ProjectAlterationPaymentDetailsModel> paymentList =
			 * dao.findByProjectAltrId(projectAlt.getProjectAltrId());
			 * if(paymentList.isEmpty()) { m=dao.save(m); } else if(paymentList.size()==1 &&
			 * null==projectAlt.getAltrStatus()) { m=paymentList.get(0);
			 * 
			 * } else if(paymentList.size()==1 &&
			 * ReraConstants.COMPLETED.equals(projectAlt.getStageOneStatus())) {
			 * m=dao.save(m); } else if(paymentList.size()==2 &&
			 * ReraConstants.COMPLETED.equals(projectAlt.getStageOneStatus())) {
			 * m=paymentList.get(0); }
			 */
			
			
			  if (Optional.ofNullable(projectAlt.getPaymentDetailsModel()).isPresent() &&
			  null==projectAlt.getAltrStatus()) {
			  LOGGER.debug("already saved payment id  :"+projectAlt.getPaymentDetailsModel(
			  ).getPaymentId()); m=projectAlt.getPaymentDetailsModel();
			  
			  } else
			  if(Optional.ofNullable(projectAlt.getPaymentDetailsModel()).isPresent() &&
			  ReraConstants.COMPLETED.equals(projectAlt.getStageOneStatus())) {
			  m=projectAlt.getPaymentDetailsModel(); } else {
			  projectAlt.setPaymentDetailsModel(m); m =
			  prjAltDao.save(projectAlt).getPaymentDetailsModel(); }
			 			
		} else {
			throw new ResourceAccessException("Project not exist");
		}
		LOGGER.debug("return payment id  :"+m.getPaymentId());
		return m;
	}

	@Override
	public List<ProjectAlterationPaymentDetailsModel> getAllPaymentDetail() {
		List<ProjectAlterationPaymentDetailsModel> l = new ArrayList<ProjectAlterationPaymentDetailsModel>();
		dao.findAll().iterator().forEachRemaining(l::add);
		return l;
	}
	@Autowired
WorkflowEngine engine;
	
	@Override
	public ProjectAlterationPaymentDetailsModel updatePaymentDetail(ProjectAlterationPaymentDetailsModel entity,HttpServletRequest req) {
		LOGGER.debug("alteration updatePaymentDetail : start");
		ProjectAlterationPaymentDetailsModel m = entity;
		//Optional<ProjectAlterationPaymentDetailsModel> op = dao.findById(entity.getPaymentId());
		ProjectAlterationModel projectAlt = prjAltDao.findById(entity.getProjectAltrId()).get();
			if (prjAltDao.findById(entity.getProjectAltrId()).isPresent()) {
				ProjectAlterationPaymentDetailsModel oldPaymentModel = projectAlt.getPaymentDetailsModel();
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
					projectAlt.setPaymentDetailsModel(m);
				}
		} else {
			throw new ResourceAccessException("Project is not found");
		}
			
			LOGGER.debug("alteration updatePaymentDetail : End");
		return projectAlt.getPaymentDetailsModel();
	}

	@Override
	public ProjectAlterationPaymentDetailsModel getPaymentDetailById(Long id) {
		return dao.findById(id).get();
	}

	@Override
	public List<ProjectAlterationPaymentDetailsModel> getPaymentDetailByProjectId(Long id) {
		return dao.findByProjectAltrId(id);
	}

	@Override
	public ProjectAlterationPaymentDetailsModel getPaymentFee(Long prjAltId) {
		System.out.println("Project fee calculation");
		ProjectAlterationModel prm = prjAltDao.findById(prjAltId).get();
		Double amt = prjAltCal.getProjectAltFee(prm);
		String token = PaymentTokenNumber.generateProjAlterToken();
		System.out.println("Project fee:" + amt + ",token:" + token);
		
		ProjectAlterationPaymentDetailsModel m = new ProjectAlterationPaymentDetailsModel();
		m.setProjectAltrId(prjAltId);

		if(ReraConstants.SECTION_15.equalsIgnoreCase(prm.getAlterationType()) && !ReraConstants.COMPLETED.equalsIgnoreCase(prm.getStageOneStatus()))
		{
			m.setAmount(5000D);
			m.setTotalProjectAmount(5000D);
		}
		else
		{
			m.setAmount(amt);
			m.setTotalProjectAmount(amt);
		}
		m.setPenaltyAmount(0.0);
		m.setTokenNo(token);
		m.setStatus(ReraConstants.SENT);
		return m;
	}

	// @Override
	public ProjectAlterationPaymentDetailsModel setPaymentFeeByStatus() {
		System.out.println("Project fee calculation");
		ProjectAlterationPaymentDetailsModel m = new ProjectAlterationPaymentDetailsModel();
		/*
		 * ProjectAlterationModel prm= prjAltDao.findById(prjId).get();
		 * 
		 * Double amt=prjAltCal.getProjectRegFee(prm); String
		 * token=PaymentTokenNumber.generateToken(prm);
		 * System.out.println("Project fee:"+amt+",token:"+token);
		 * ProjectAlterationPaymentDetailsModel m=new ProjectAlterationPaymentDetailsModel();
		 * m.setPrjRegId(prjId); m.setAmount(amt); m.setPenaltyAmount(0.0);
		 * m.setTotalProjectAmount(amt); m.setTokenNo(token);
		 * m.setStatus(ReraConstants.SENT);
		 */

		return m;
	}

	@Override
	public PaymentTransactionModel getTransactiondetails(ProjectAlterationPaymentDetailsModel tmodel)
			throws ResourceNotFoundException {
		LOGGER.debug("alteration getTransactiondetails : start");
		ProjectAlterationModel pm = prjAltDao.findById(tmodel.getProjectAltrId()).get();
		try {
			paymentTransactionModel.setProjectId(pm.getProjectRegId());
			paymentTransactionModel.setPaymentId(pm.getPaymentDetailsModel().getPaymentId());
			paymentTransactionModel.setEmailId(pm.getPromoteremailId());
			paymentTransactionModel.setMobileNo(pm.getPromoterMobileNo());
			paymentTransactionModel.setPaymentRemarks("");
			paymentTransactionModel.setPenaltyAmount(pm.getPaymentDetailsModel().getPenaltyAmount());
			paymentTransactionModel.setProcessId(pm.getProjectAltrId());
			paymentTransactionModel.setProcessName(ReraConstants.PROJECT_ALT_15);
			paymentTransactionModel.setPromoterId(pm.getPromoterId().toString());
			paymentTransactionModel.setRedirectUrl("");
			paymentTransactionModel.setRegistraionType(pm.getProjectType());
			paymentTransactionModel.setSbiReferanceNo(pm.getPaymentDetailsModel().getSbiReferanceNo());
			paymentTransactionModel.setAmount(pm.getPaymentDetailsModel().getAmount());
			paymentTransactionModel.setStatus(pm.getPaymentDetailsModel().getStatus());
			paymentTransactionModel.setTokenNo(pm.getPaymentDetailsModel().getTokenNo());
			paymentTransactionModel.setTotalProjectAmount(pm.getPaymentDetailsModel().getTotalProjectAmount());
			paymentTransactionModel.setTransactionNo(pm.getPaymentDetailsModel().getTransactionNo());
			paymentTransactionModel.setUserName(pm.getPromoterName());
			paymentTransactionModel.setAknowledgementNo(pm.getProjectAltAckNo());
			paymentTransactionModel.setPaymentStatus(pm.getPaymentDetailsModel().getStatus());
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

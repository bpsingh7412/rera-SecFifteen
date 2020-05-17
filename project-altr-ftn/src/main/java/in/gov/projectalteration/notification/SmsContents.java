package in.gov.projectalteration.notification;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import in.gov.projectalteration.constants.ReraConstants;
import in.gov.projectalteration.model.AllotteeDetailModel;
import in.gov.projectalteration.model.ProjectAlterationModel;
import in.gov.wf.security.StrEncUtill;

public class SmsContents {
	private static final Logger logger = LogManager.getLogger(SmsContents.class);

	/**********************************************************************************************
	 * Event : form 1 assignment to architect By promoter sent to: architect
	 **********************************************************************************************/

	public static SmsNotification formOneAssignmentSmsToArchitect(ProjectAlterationModel m) {
		logger.debug("formOneAssignmentSmsToArchitect ::Start");
		SmsNotification sms = new SmsNotification();
		sms.setMobileNo(m.getFormOneModel().getMobNumber());
		sms.setProcessName(ReraConstants.PROJECT_REG);
		sms.setSendAsOtp("N");
		StringBuilder sb = new StringBuilder();
		sb.append("Form 1 for");
		sb.append(m.getProjectDetailModel().getProjectName());
		sb.append("for filing ");
		sb.append("Project Alteration is ");

		if (ReraConstants.ASSIGNED.contentEquals(m.getFormOneModel().getStatus()))
			sb.append("assigned");
		if (ReraConstants.INPROGRESS.contentEquals(m.getFormOneModel().getStatus()))
			sb.append("rejected");
		if (ReraConstants.ACCEPTED.contentEquals(m.getFormOneModel().getStatus()))
			sb.append("accepted");
		if (ReraConstants.UPLOADED.contentEquals(m.getFormOneModel().getStatus()))
			sb.append("accepted");
		if (ReraConstants.REJECTED.contentEquals(m.getFormOneModel().getStatus()))
			sb.append("rejected");

		sb.append("and promoter details  are below: \n\n");
		sb.append("Promoter Name: ").append(m.getPromoterName()).append(" \n\n");
		sb.append("Promoter mobNo: ").append(m.getPromoterMobileNo()).append(" \n\n");
		sb.append("Regards: \n").append("Gujarat RERA \n\n\n");
		sms.setMessage(sb.toString());
		logger.debug("formOneAssignmentSmsToArchitect::end");
		return sms;
	}

	/**********************************************************************************************
	 * Event : form 2 assignment to Engineer By promoter sent to: Engineer
	 **********************************************************************************************/

	public static SmsNotification formTwoAssignmentSmsToEngineer(ProjectAlterationModel m) {
		logger.debug("formTwoAssignmentSmsToEngineer ::Start");
		SmsNotification sms = new SmsNotification();
		sms.setMobileNo(m.getFormTwoModel().getMobileNo());
		sms.setProcessName(ReraConstants.PROJECT_REG);
		sms.setSendAsOtp("N");
		StringBuilder sb = new StringBuilder();
		sb.append("Form 2 for");
		sb.append(m.getProjectDetailModel().getProjectName());
		sb.append("for filing ");
		sb.append("Project Alteration is ");

		if (ReraConstants.ASSIGNED.contentEquals(m.getFormTwoModel().getStatus()))
			sb.append("assigned");
		if (ReraConstants.INPROGRESS.contentEquals(m.getFormTwoModel().getStatus()))
			sb.append("rejected");
		if (ReraConstants.ACCEPTED.contentEquals(m.getFormTwoModel().getStatus()))
			sb.append("accepted");
		if (ReraConstants.UPLOADED.contentEquals(m.getFormTwoModel().getStatus()))
			sb.append("accepted");
		if (ReraConstants.REJECTED.contentEquals(m.getFormOneModel().getStatus()))
			sb.append("rejected");

		sb.append("and promoter details  are below: \n\n");
		sb.append("Promoter Name: ").append(m.getPromoterName()).append(" \n\n");
		sb.append("Promoter mobNo: ").append(m.getPromoterMobileNo()).append(" \n\n");
		sb.append("Regards: \n").append("Gujarat RERA \n\n\n");
		sms.setMessage(sb.toString());
		logger.debug("formTwoAssignmentSmsToEngineer::end");
		return sms;
	}

	/**********************************************************************************************
	 * Event : form 3 assignment to CA By promoter sent to: CA
	 **********************************************************************************************/

	public static SmsNotification formThreeAssignmentSmsToCa(ProjectAlterationModel m) {
		logger.debug("formThreeAssignmentSmsToCa ::Start");
		SmsNotification sms = new SmsNotification();
		sms.setMobileNo(m.getFormThreeModel().getMobileNo());
		sms.setProcessName(ReraConstants.PROJECT_REG);
		sms.setSendAsOtp("N");
		StringBuilder sb = new StringBuilder();
		sb.append("Form 3 for");
		sb.append(m.getProjectDetailModel().getProjectName());
		sb.append("for filing ");
		sb.append("Project Alteration is ");

		if (ReraConstants.ASSIGNED.contentEquals(m.getFormThreeModel().getStatus()))
			sb.append("assigned");
		if (ReraConstants.INPROGRESS.contentEquals(m.getFormThreeModel().getStatus()))
			sb.append("rejected");
		if (ReraConstants.ACCEPTED.contentEquals(m.getFormThreeModel().getStatus()))
			sb.append("accepted");
		if (ReraConstants.UPLOADED.contentEquals(m.getFormThreeModel().getStatus()))
			sb.append("accepted");
		if (ReraConstants.REJECTED.contentEquals(m.getFormOneModel().getStatus()))
			sb.append("rejected");

		sb.append("and promoter details  are below: \n\n");
		sb.append("Promoter Name: ").append(m.getPromoterName()).append(" \n\n");
		sb.append("Promoter mobNo: ").append(m.getPromoterMobileNo()).append(" \n\n");
		sb.append("Regards: \n").append("Gujarat RERA \n\n\n");
		sms.setMessage(sb.toString());
		logger.debug("formThreeAssignmentSmsToCa::end");
		return sms;
	}

	/**********************************************************************************************
	 * Event : Project Submit Successfully sent to: Promoter
	 **********************************************************************************************/

	public static SmsNotification smsNotificationForPaymentSuccess(ProjectAlterationModel m) {
		logger.debug("smsNotificationForPaymentSuccess::Start");
		SmsNotification sms = new SmsNotification();
		sms.setMobileNo(m.getPromoterMobileNo());
		sms.setProcessName(ReraConstants.PROJECT_REG);
		sms.setSendAsOtp("N");
		StringBuilder sb = new StringBuilder();
		sb.append("Dear ").append(m.getPromoterName()).append("\n\n");
		sb.append("Project ");
		sb.append(m.getProjectDetailModel().getProjectName());
		sb.append("registered payment Successfully. \n\n");

		sb.append("Regards: \n").append("Gujarat RERA \n\n\n");
		sms.setMessage(sb.toString());
		logger.debug("smsNotificationForPaymentSuccess::end");
		return sms;
	}

	/**********************************************************************************************
	 * Event : Project payment is pending sent to: Promoter
	 **********************************************************************************************/
	public static SmsNotification smsNotificationForPaymentPending(ProjectAlterationModel m) {
		logger.debug("smsNotificationForPaymentPending::Start");
		SmsNotification sms = new SmsNotification();
		sms.setMobileNo(m.getPromoterMobileNo());
		sms.setProcessName(ReraConstants.PROJECT_REG);
		sms.setSendAsOtp("N");
		StringBuilder sb = new StringBuilder();
		sb.append("Dear ").append(m.getPromoterName()).append("\n\n");
		sb.append("Project ");
		sb.append(m.getProjectDetailModel().getProjectName());
		sb.append("registered payment Pending. \n\n");

		sb.append("Regards: \n").append("Gujarat RERA \n\n\n");
		sms.setMessage(sb.toString());
		logger.debug("smsNotificationForPaymentSuccess::end");
		return sms;
	}

	/**********************************************************************************************
	 * Event : Project Approved Successfully sent to: Promoter
	 **********************************************************************************************/
	public static SmsNotification smsNotificationWfApproved(ProjectAlterationModel m) {
		logger.debug("smsNotificationWfApproved::Start");
		SmsNotification sms = new SmsNotification();
		sms.setMobileNo(m.getPromoterMobileNo());
		sms.setProcessName(ReraConstants.PROJECT_REG);
		sms.setSendAsOtp("N");
		StringBuilder sb = new StringBuilder();
		sb.append("Dear ").append(m.getPromoterName()).append("\n\n");
		sb.append("Project ");
		sb.append(m.getProjectDetailModel().getProjectName());
		sb.append("approved Successfully. \n\n");

		sb.append("Regards: \n").append("Gujarat RERA \n\n\n");
		sms.setMessage(sb.toString());
		logger.debug("smsNotificationWfApproved::end");
		return sms;
	}
	
	/**********************************************************************************************
	 * Event : Payment Sucessfully for project alteration
	 * sent to: allotee
	 **********************************************************************************************/
	public static SmsNotification alloteeSms(AllotteeDetailModel model,ProjectAlterationModel altm,String smsAllotteeFeedback) {
		String feedbackLink=smsAllotteeFeedback+StrEncUtill.encrypt(String.valueOf(model.getPrjId()))
				+"/mobnumber/"+
				StrEncUtill.encrypt(model.getAllotteeMobile())+"/feedback/";
		SmsNotification sms = new SmsNotification();
		sms.setMobileNo(model.getAllotteeMobile());
		sms.setProcessName(ReraConstants.ALLOTEE);
		StringBuilder sb = new StringBuilder();
		sb.append("Dear ").append(model.getAllotteeName())
				.append("This is a feedback survey from allotee of project details are below \n").append("project Name is "+altm.getProjectName()+"\n\n")
				.append("for yes click on below link:")
				.append(smsAllotteeFeedback+StrEncUtill.encrypt("yes")).append("for No click on below link : \n")
				.append(feedbackLink+StrEncUtill.encrypt("no"))
				.append("Regards: \n").append("Gujarat RERA \n\n\n");
		System.out.println("alloteeSms :::::::"+feedbackLink);
		sms.setMessage(sb.toString());
		return sms;
	}
}

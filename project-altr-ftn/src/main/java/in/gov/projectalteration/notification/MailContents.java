package in.gov.projectalteration.notification;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import in.gov.projectalteration.constants.ReraConstants;
import in.gov.projectalteration.model.ProjectAlterationModel;

public class MailContents {
	private static final Logger logger = LogManager.getLogger(MailContents.class);

	/**************************************************************************************************************
	 * Event : project Approved successfully sent to: Promoter
	 **************************************************************************************************************/
	public static EmailNotification projectAlterationMailWorkFlow(ProjectAlterationModel model) {
		EmailNotification email = new EmailNotification();
		StringBuilder subject = new StringBuilder();
		subject.append("GujRERA Project Alteration Approved");

		email.setSubject(subject.toString());
		email.setSendTo(model.getPromoteremailId());
		email.setProcessName(ReraConstants.PROJECT_ALT);
		email.setSendAsOtp("N");
		StringBuilder sb = new StringBuilder();
		sb.append("Dear ").append(model.getPromoterName()).append("\n\n");
		sb.append("Your Project is successfully approved in GujRERA Portal. Prject details are below: \n\n");
		sb.append("Promoter Alteration no: ").append(model.getProjectAltAckNo()).append(" \n\n");
		sb.append("Promoter type: ").append(model.getPromoterType()).append(" \n\n");
		sb.append("Regards: \n").append("Gujarat RERA \n\n\n");

		email.setBodyContent(sb.toString());
		return email;
	}

	/**************************************************************************************************************
	 * Event : project Register successfully sent to: Promoter
	 **************************************************************************************************************/
	public static EmailNotification projectAlterationMailPayment(ProjectAlterationModel model) {
		EmailNotification email = new EmailNotification();
		StringBuilder subject = new StringBuilder();
		subject.append("GujRERA Project Alteration payment");

		email.setSubject(subject.toString());
		email.setSendTo(model.getPromoteremailId());
		email.setProcessName(ReraConstants.PROJECT_ALT);
		email.setSendAsOtp("N");
		StringBuilder sb = new StringBuilder();
		sb.append("Dear ").append(model.getPromoterName()).append("\n\n");
		sb.append("Your Project is successfully registered in GujRERA Portal. Prject details are below: \n\n");
		sb.append("Promoter Alteration no: ").append(model.getProjectAltAckNo()).append(" \n\n");
		sb.append("Promoter type: ").append(model.getPromoterType()).append(" \n\n");
		sb.append("Regards: \n").append("Gujarat RERA \n\n\n");

		email.setBodyContent(sb.toString());
		return email;
	}

	/**************************************************************************************************************
	 * Event : form 1 assignment to architect By promoter sent to: architect
	 **************************************************************************************************************/
	public static EmailNotification formOneAssignmentMail(ProjectAlterationModel model) {
		System.out.println("formOneAssignmentMail::");
		StringBuilder subject = new StringBuilder();
		EmailNotification email = new EmailNotification();
		subject.append("Form 1 for");
		subject.append(model.getProjectDetailModel().getProjectName());
		subject.append("for filing ");
		subject.append("Project Alteration is ");

		if (ReraConstants.ASSIGNED.contentEquals(model.getFormOneModel().getStatus()))
			subject.append("assigned");
		if (ReraConstants.INPROGRESS.contentEquals(model.getFormOneModel().getStatus()))
			subject.append("rejected");
		if (ReraConstants.ACCEPTED.contentEquals(model.getFormOneModel().getStatus()))
			subject.append("accepted");
		if (ReraConstants.UPLOADED.contentEquals(model.getFormOneModel().getStatus()))
			subject.append("accepted");
		if (ReraConstants.REJECTED.contentEquals(model.getFormOneModel().getStatus()))
			subject.append("rejected");

		email.setSubject(subject.toString());
		email.setSendTo(model.getFormOneModel().getEmailId());
		email.setProcessName(ReraConstants.PROJECT_ALT);
		email.setSendAsOtp("N");
		StringBuilder sb = new StringBuilder();
		sb.append("Dear ").append(model.getPromoterName()).append("\n\n");

		sb.append("Project Form one is");

		if (ReraConstants.ASSIGNED.contentEquals(model.getFormOneModel().getStatus()))
			sb.append("assigned");
		if (ReraConstants.INPROGRESS.contentEquals(model.getFormOneModel().getStatus()))
			sb.append("rejected");
		if (ReraConstants.ACCEPTED.contentEquals(model.getFormOneModel().getStatus()))
			sb.append("accepted");
		if (ReraConstants.UPLOADED.contentEquals(model.getFormOneModel().getStatus()))
			sb.append("accepted");
		if (ReraConstants.REJECTED.contentEquals(model.getFormOneModel().getStatus()))
			sb.append("rejected");

		sb.append(" to Architect: \n\n");

		sb.append("Project Name: ").append(model.getProjectDetailModel().getProjectName()).append(" \n\n");
		sb.append("Promoter Name: ").append(model.getPromoterName()).append(" \n\n");
		sb.append("Email Id: ").append(model.getPromoteremailId()).append(" \n\n");
		sb.append("Mobile : ").append(model.getPromoterMobileNo()).append(" \n\n");
		sb.append("Regards: \n").append("Gujarat RERA \n\n\n");
		email.setBodyContent(sb.toString());
		return email;
	}

	/**************************************************************************************************************
	 * Event : form 2 assignment by promoter sent to: Engineer
	 **************************************************************************************************************/
	public static EmailNotification formTwoAssignmentMail(ProjectAlterationModel model) {
		System.out.println("formTwoAssignmentMail::");
		StringBuilder subject = new StringBuilder();
		EmailNotification email = new EmailNotification();
		subject.append("Form 2 for");
		subject.append(model.getProjectDetailModel().getProjectName());
		subject.append("for filing ");
		subject.append("Project Alteration is ");

		if (ReraConstants.ASSIGNED.contentEquals(model.getFormTwoModel().getStatus()))
			subject.append("assigned");
		if (ReraConstants.INPROGRESS.contentEquals(model.getFormTwoModel().getStatus()))
			subject.append("rejected");
		if (ReraConstants.ACCEPTED.contentEquals(model.getFormTwoModel().getStatus()))
			subject.append("accepted");
		if (ReraConstants.UPLOADED.contentEquals(model.getFormTwoModel().getStatus()))
			subject.append("accepted");
		if (ReraConstants.REJECTED.contentEquals(model.getFormOneModel().getStatus()))
			subject.append("rejected");
		email.setSubject(subject.toString());

		email.setSendTo(model.getFormTwoModel().getEmailId());
		email.setProcessName(ReraConstants.PROJECT_ALT);
		email.setSendAsOtp("N");
		StringBuilder sb = new StringBuilder();
		sb.append("Dear ").append(model.getPromoterName()).append("\n\n");
		sb.append("Project Form Two is Assigned to Engineer the details are below: \n\n");

		if (ReraConstants.ASSIGNED.contentEquals(model.getFormTwoModel().getStatus()))
			sb.append("assigned");
		if (ReraConstants.INPROGRESS.contentEquals(model.getFormTwoModel().getStatus()))
			sb.append("rejected");
		if (ReraConstants.ACCEPTED.contentEquals(model.getFormTwoModel().getStatus()))
			sb.append("accepted");
		if (ReraConstants.UPLOADED.contentEquals(model.getFormTwoModel().getStatus()))
			sb.append("accepted");
		if (ReraConstants.REJECTED.contentEquals(model.getFormOneModel().getStatus()))
			sb.append("rejected");

		sb.append("to Engineer the details are below: \n\n");

		sb.append("Project Name: ").append(model.getProjectDetailModel().getProjectName()).append(" \n\n");
		sb.append("Promoter Name: ").append(model.getPromoterName()).append(" \n\n");
		sb.append("Email Id: ").append(model.getPromoteremailId()).append(" \n\n");
		sb.append("Mobile : ").append(model.getPromoterMobileNo()).append(" \n\n");
		sb.append("Regards: \n").append("Gujarat RERA \n\n\n");
		email.setBodyContent(sb.toString());
		return email;
	}

	/**************************************************************************************************************
	 * Event : form 3 Assignment by promoter sent to: CA
	 **************************************************************************************************************/
	public static EmailNotification formThreeAssignmentMail(ProjectAlterationModel model) {
		System.out.println("formThreeAssignmentMail::");
		StringBuilder subject = new StringBuilder();
		EmailNotification email = new EmailNotification();
		subject.append("Form 3 for");
		subject.append(model.getProjectDetailModel().getProjectName());
		subject.append("for filing Project Alteration is ");
		if (ReraConstants.ASSIGNED.contentEquals(model.getFormThreeModel().getStatus()))
			subject.append("assigned");
		if (ReraConstants.INPROGRESS.contentEquals(model.getFormThreeModel().getStatus()))
			subject.append("rejected");
		if (ReraConstants.ACCEPTED.contentEquals(model.getFormThreeModel().getStatus()))
			subject.append("accepted");
		if (ReraConstants.UPLOADED.contentEquals(model.getFormThreeModel().getStatus()))
			subject.append("uploaded");
		if (ReraConstants.REJECTED.contentEquals(model.getFormOneModel().getStatus()))
			subject.append("rejected");
		email.setSubject(subject.toString());

		email.setSendTo(model.getFormThreeModel().getEmailId());
		email.setProcessName(ReraConstants.PROJECT_ALT);
		email.setSendAsOtp("N");
		StringBuilder sb = new StringBuilder();
		sb.append("Dear ").append(model.getFormThreeModel().getFirstName()).append("\n\n");
		sb.append("Project is assigned to CA the details of CA are below: \n\n");
		sb.append("Project Name: ").append(model.getProjectDetailModel().getProjectName()).append(" \n\n");
		sb.append("Promoter Name: ").append(model.getPromoterName()).append(" \n\n");
		sb.append("Email Id: ").append(model.getPromoteremailId()).append(" \n\n");
		sb.append("Mobile : ").append(model.getPromoterMobileNo()).append(" \n\n");
		sb.append("Regards: \n").append("Gujarat RERA \n\n\n");
		email.setBodyContent(sb.toString());
		return email;
	}

}

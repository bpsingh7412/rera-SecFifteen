package in.gov.projectalteration.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import in.gov.projectalteration.common.ProjectFeeCalculator;
import in.gov.projectalteration.common.model.ResponseModel;
import in.gov.projectalteration.common.services.impl.UserRestTemplateServices;
import in.gov.projectalteration.constants.ReraConstants;
import in.gov.projectalteration.exception.ResourceNotFoundException;
import in.gov.projectalteration.model.AllotteeDetailModel;
import in.gov.projectalteration.model.ProjectAlterationPaymentDetailsModel;
import in.gov.projectalteration.model.transaction.AllotteeResponceModel;
import in.gov.projectalteration.model.transaction.PaymentTransactionModel;
import in.gov.projectalteration.notification.MailContents;
import in.gov.projectalteration.notification.NotificationUtil;
import in.gov.projectalteration.notification.SmsContents;
import in.gov.projectalteration.services.AllotteeDetailServices;
import in.gov.projectalteration.services.AlterationPaymentDetailServices;
import in.gov.projectalteration.services.AlterationRegistrationServices;
import in.gov.wf.security.StrEncUtill;

@PropertySource(ignoreResourceNotFound = true, value = "classpath:message/common.properties")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/project_alt_ftn/secure/payment")
public class ProjectAltPaymentRestController {
	private static final Logger logger = LogManager.getLogger(ProjectAltPaymentRestController.class);
	@Autowired
	private Environment env;

	@Autowired
	AlterationPaymentDetailServices services;

	@Autowired
	ProjectFeeCalculator altCalServices;

	@Autowired
	NotificationUtil notifcationServices;

	@Autowired
	AlterationRegistrationServices altServices;

	@Autowired
	PaymentTransactionModel tmodel;
	@Autowired
	AllotteeDetailServices alloteeServices;

	@Value("${GET_ALLOTTEE_DTL}")
	String alloteeUrl;
	@Value("${SMS_ALLOTTEE_FEEDBACK}")
	String smsAllotteeFeedback;

	/**************************************************************************
	 * getAllProjectPaymentDetails
	 **************************************************************************/

	@GetMapping("/all")
	public ResponseEntity<?> getAllProjectPaymentDetails() {
		List<ProjectAlterationPaymentDetailsModel> list = new ArrayList<ProjectAlterationPaymentDetailsModel>();
		list = services.getAllPaymentDetail();
		if (list.size() == 0)
			throw new ResourceAccessException(env.getProperty("NOT_FOUND"));

		ResponseModel rs = new ResponseModel();
		rs.setStatus("200");
		rs.setMessage(list.size() + " record found.");
		rs.setData(list);

		return ResponseEntity.ok(rs);
	}

	/**************************************************************************
	 * saveProjectPaymentDetails
	 **************************************************************************/
	@PostMapping("/save")
	public ResponseEntity<?> saveProjectPaymentDetails(@RequestBody ProjectAlterationPaymentDetailsModel entity)
			throws ResourceNotFoundException {
		logger.debug("saveProjectPaymentDetails");
		String flag = "";
		Optional.ofNullable(entity).orElseThrow(() -> new ResourceAccessException(env.getProperty("DATA_INVALID")));

		ProjectAlterationPaymentDetailsModel pm = services.savePaymentDetail(entity);
		Optional<ProjectAlterationPaymentDetailsModel> op = Optional.ofNullable(pm);
		flag = op.isPresent() ? env.getProperty("SUCCESS") : env.getProperty("FAILED");

		ResponseModel rs = new ResponseModel();

		if (flag.equals(env.getProperty("SUCCESS"))) {
			rs.setStatus("200");
			rs.setMessage("");
			rs.setData(pm);
		} else {
			rs.setStatus("300");
			rs.setMessage("some thing went wrong.");
		}
		return ResponseEntity.ok(rs);
	}

	/**************************************************************************
	 * saveProjectPaymentDetails
	 **************************************************************************/
	@PostMapping("/modify")
	public ResponseEntity<?> modifyProjectPaymentDetails(@RequestBody ProjectAlterationPaymentDetailsModel entity,
			HttpServletRequest req) throws ResourceNotFoundException {
		logger.debug("modifyProjectPaymentDetails");
		String flag = "";
		ResponseModel rs = new ResponseModel();
		Optional.ofNullable(entity).orElseThrow(() -> new ResourceAccessException(env.getProperty("DATA_INVALID")));
		try {
			ProjectAlterationPaymentDetailsModel pm = services.updatePaymentDetail(entity, req);
			Optional<ProjectAlterationPaymentDetailsModel> op = Optional.ofNullable(pm);
			flag = op.isPresent() ? env.getProperty("SUCCESS") : env.getProperty("FAILED");

			PaymentTransactionModel t = services.getTransactiondetails(pm);

			if (flag.equals(env.getProperty("SUCCESS"))) {
				rs.setStatus("200");
				if ("SUCCESS".contentEquals(pm.getStatus())) {
					rs.setMessage("Your payment has been successfully paid and your acknowledge number is "
							+ t.getAknowledgementNo());
					try {

String processType = "PROJECT_ALT_15";
List<AllotteeDetailModel> allotteeList = new ArrayList<>();
AllotteeResponceModel am = UserRestTemplateServices.getAlloteeDetailsRestApiCall(alloteeUrl + entity.getProjectAltrId() + "/" + processType);
allotteeList = am.getAllotteeList();
String citizenURL=smsAllotteeFeedback.split("#")[1];
for (AllotteeDetailModel m : allotteeList) {
m.setPrjAltId(pm.getProjectAltrId());
m.setPrjId(t.getProjectId());
m.setAllotteeReply(ReraConstants.PENDING);
m.setSmsUrl(citizenURL+StrEncUtill.encrypt(m.getAllotteeMobile())+"/"+String.valueOf(pm.getProjectAltrId()));
alloteeServices.save(m);
notifcationServices.sendSms(SmsContents.alloteeSms(m,altServices.getById(pm.getProjectAltrId()),smsAllotteeFeedback));
}						 

						notifcationServices.sendEmail(
								MailContents.projectAlterationMailPayment(altServices.getById(pm.getProjectAltrId())));

						notifcationServices.sendSms(SmsContents
								.smsNotificationForPaymentSuccess(altServices.getById(pm.getProjectAltrId())));

					} catch (Exception e) {
						System.out.println("Error::" + e);
					}

				} else if ("BOOKED".contentEquals(pm.getStatus()) || "PENDING".contentEquals(pm.getStatus())) {
					rs.setMessage("Your payment is under settlement.");
					try {
						notifcationServices.sendEmail(
								MailContents.projectAlterationMailPayment(altServices.getById(pm.getProjectAltrId())));

						notifcationServices.sendSms(SmsContents
								.smsNotificationForPaymentSuccess(altServices.getById(pm.getProjectAltrId())));

					} catch (Exception e) {
						System.out.println(".............>" + e);
					}

				} else {
					rs.setStatus("200");
					rs.setMessage("Your payment is failed. Please try again for payment.");
				}
				rs.setData(t);
			} else {
				rs.setStatus("some thing went wrong. Please contact to administrator.");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ResponseEntity.ok(rs);
	}

	/**************************************************************************
	 * projectPaymentDetailsById
	 **************************************************************************/
	@GetMapping("/{id}")
	public ResponseEntity<?> getProjectPaymentDetailsById(@PathVariable(value = "id") Long id) {
		ProjectAlterationPaymentDetailsModel m = services.getPaymentDetailById(id);
		Optional.ofNullable(m).orElseThrow(() -> new ResourceAccessException(env.getProperty("NOT_FOUND")));
		ResponseModel rs = new ResponseModel();
		rs.setStatus("200");
		rs.setMessage("Record found.");
		rs.setData(m);

		return ResponseEntity.ok(rs);
	}

	/**************************************************************************
	 * projectPaymentDetailsProjectById
	 **************************************************************************/
	@GetMapping("/project{projectId}")
	public ResponseEntity<?> projectPaymentDetailsProjectById(@PathVariable(value = "projectId") Long id) {
		List<ProjectAlterationPaymentDetailsModel> list = new ArrayList<ProjectAlterationPaymentDetailsModel>();
		list = services.getPaymentDetailByProjectId(id);
		if (list.size() == 0)
			throw new ResourceAccessException(env.getProperty("NOT_FOUND"));
		return ResponseEntity.ok(list);
	}

	/**************************************************************************
	 * projectPaymentDetails
	 * 
	 * @throws ResourceNotFoundException
	 **************************************************************************/

	@GetMapping("/details/project-alt/{id}")
	public ResponseEntity<?> projectPaymentDetails(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException {
		System.out.print("project id:" + id);
		ProjectAlterationPaymentDetailsModel m = services.getPaymentFee(id);
		ProjectAlterationPaymentDetailsModel savedEntity = services.savePaymentDetail(m);
		PaymentTransactionModel t = services.getTransactiondetails(savedEntity);
		ResponseModel rs = new ResponseModel();
		rs.setStatus("200");
		rs.setData(t);
		return ResponseEntity.ok(rs);
	}

}

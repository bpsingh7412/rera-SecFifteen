package in.gov.projectalteration.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import in.gov.projectalteration.common.model.ResponseModel;
import in.gov.projectalteration.constants.ReraConstants;
import in.gov.projectalteration.exception.ResourceNotFoundException;
import in.gov.projectalteration.model.Form2AssignmentModel;
import in.gov.projectalteration.model.FormTwoModel;
import in.gov.projectalteration.notification.MailContents;
import in.gov.projectalteration.notification.NotificationUtil;
import in.gov.projectalteration.notification.SmsContents;
import in.gov.projectalteration.services.AlterationRegistrationServices;
import in.gov.projectalteration.services.FormTwoDetailsService;
import in.gov.wf.security.AuthUser;

@PropertySource(ignoreResourceNotFound = true, value = "classpath:message/common.properties")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/project_alt_ftn/secure/form-two")
public class FormTwoRestController {
	private static final Logger logger = LogManager.getLogger(FormTwoRestController.class);
	@Autowired
	private Environment env;
	@Autowired
	FormTwoDetailsService services;
	@Autowired
	NotificationUtil notifcationServices;
	@Autowired
	AlterationRegistrationServices altServices;

	/**************************************************************************
	 * getAllFromTwo
	 **************************************************************************/

	@GetMapping("/all")
	public ResponseEntity<?> getAllFromTwo() {
		List<FormTwoModel> list = new ArrayList<FormTwoModel>();
		list = services.getAllFromTwoDetails();
		if (list.size() == 0)
			throw new ResourceAccessException(env.getProperty("NOT_FOUND"));
		ResponseModel rs = new ResponseModel();
		rs.setStatus("200");
		rs.setMessage("records found.");
		rs.setData(list);
		return ResponseEntity.ok(list);
	}

	/**************************************************************************
	 * saveFromTwoDetails
	 **************************************************************************/
	@PostMapping("/save-from-two-details")
	public ResponseEntity<?> saveFromTwoDetails(@Valid @RequestBody FormTwoModel entity)
			throws ResourceNotFoundException {
		logger.debug("saveFromTwoDetails");
		String flag = "";
		Optional.ofNullable(entity).orElseThrow(() -> new ResourceAccessException(env.getProperty("DATA_INVALID")));

		FormTwoModel pm = services.saveFromTwoDetails(entity);
		Optional<FormTwoModel> op = Optional.ofNullable(pm);
		flag = op.isPresent() ? env.getProperty("SUCCESS") : env.getProperty("FAILED");
		ResponseModel rs = new ResponseModel();
		if (flag.equals(env.getProperty("SUCCESS"))) {

			rs.setStatus("200");
			rs.setMessage("Saved Successfully.");
			rs.setData(pm);
		} else {
			rs.setStatus("300");
			rs.setMessage("Some thing went wrong.");
		}
		return ResponseEntity.ok(rs);
	}

	/**************************************************************************
	 * assign-engineer
	 **************************************************************************/
	@PostMapping("/assign-engineer")
	public ResponseEntity<?> saveAssignEngineer(@Valid @RequestBody Form2AssignmentModel entity, HttpServletRequest req)
			throws ResourceNotFoundException {

		logger.debug("saveFromTwoDetails");
		logger.debug("saveFromTwoDetails");
		logger.debug("saveFromTwoDetails-->" + entity.getEmailId());

		String flag = "";
		Optional.ofNullable(entity).orElseThrow(() -> new ResourceAccessException(env.getProperty("DATA_INVALID")));
		AuthUser user=AuthUser.getLoggedInUser(req);
		entity.setFormAssignedBy(user.getProfileId().toString());
		entity.setFormAssignedOn(new Date());
		FormTwoModel pm = services.saveProfessionalAssignment(entity);

		Optional<FormTwoModel> op = Optional.ofNullable(pm);
		flag = op.isPresent() ? env.getProperty("SUCCESS") : env.getProperty("FAILED");
		ResponseModel rs = new ResponseModel();

		if (flag.equals(env.getProperty("SUCCESS"))) {
			try {
				
				notifcationServices.sendEmail(
						MailContents.formTwoAssignmentMail(altServices.getById(pm.getProjectAltrId())));

				notifcationServices.sendSms(
						SmsContents.formTwoAssignmentSmsToEngineer(altServices.getById(pm.getProjectAltrId())));
			} catch (Exception e) {
				logger.debug("notification failed");
			}

			rs.setStatus("200");
			rs.setMessage("Engineer assigned successfully.");
			rs.setData(pm);
		} else {
			rs.setStatus("FAILED");
		}
		return ResponseEntity.ok(rs);
	}

	/**************************************************************************
	 * getAllFromTwoById
	 **************************************************************************/
	@GetMapping("/{id}")
	public ResponseEntity<?> getAllFromTwoById(@PathVariable(value = "id") Long id) {
		FormTwoModel m = services.getFromTwoDetailsById(id);
		Optional.ofNullable(m).orElseThrow(() -> new ResourceAccessException(env.getProperty("NOT_FOUND")));
		ResponseModel rs = new ResponseModel();
		rs.setStatus("200");
		rs.setMessage("records found");
		rs.setData(m);
		return ResponseEntity.ok(m);
	}

	/**************************************************************************
	 * getAllFromTwoByProject
	 **************************************************************************/
	@GetMapping("/alteration/{id}")
	public ResponseEntity<?> getAllFromTwoByProject(@PathVariable(value = "id") Long id) {
		FormTwoModel m = services.getFromTwoDetailsByProjectAltrIdAndStatus(id, "REJECTED");
		Optional.ofNullable(m).orElseThrow(() -> new ResourceAccessException(env.getProperty("NOT_FOUND")));
		ResponseModel rs = new ResponseModel();
		rs.setStatus("200");
		rs.setMessage("");
		rs.setData(m);
		return ResponseEntity.ok(rs);
	}

	@PutMapping("/update-form-two/project-reg/{prjaltid}/status/{status}")
	public ResponseEntity<?> updateFormTwoStatus(@PathVariable(value = "prjaltid") Long prjaltid,
			@PathVariable(value = "status") String status,
			@RequestParam(value = "referenceFormTwoId") Long referenceForm2Id) throws ResourceNotFoundException {
		FormTwoModel result = services.updateStatus(prjaltid, status, referenceForm2Id);

		if (result.getStatus().contentEquals(ReraConstants.REJECTED)) {
			try {
				
				notifcationServices.sendEmail(
						MailContents.formTwoAssignmentMail(altServices.getById(result.getProjectAltrId())));
				
				notifcationServices.sendSms(
						SmsContents.formTwoAssignmentSmsToEngineer(altServices.getById(result.getProjectAltrId())));
			} catch (Exception e) {
				logger.debug("Notification failed");
			}

		}

		ResponseModel rs = new ResponseModel();
		rs.setStatus("200");
		rs.setMessage("status changed successffully.");
		rs.setData(result);
		return ResponseEntity.ok(rs);
	}
}

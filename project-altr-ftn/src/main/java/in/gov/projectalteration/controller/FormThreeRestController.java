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
import in.gov.projectalteration.model.Form3AssignmentModel;
import in.gov.projectalteration.model.FormThreeModel;
import in.gov.projectalteration.notification.MailContents;
import in.gov.projectalteration.notification.NotificationUtil;
import in.gov.projectalteration.notification.SmsContents;
import in.gov.projectalteration.services.AlterationRegistrationServices;
import in.gov.projectalteration.services.FormThreeDetailsService;
import in.gov.wf.security.AuthUser;

@PropertySource(ignoreResourceNotFound = true, value = "classpath:message/common.properties")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/project_alt_ftn/secure/from-three")
public class FormThreeRestController {
	private static final Logger logger = LogManager.getLogger(FormThreeRestController.class);
	@Autowired
	private Environment env;

	@Autowired
	FormThreeDetailsService services;

	@Autowired
	NotificationUtil notifcationServices;
	@Autowired
	AlterationRegistrationServices altServices;

	/**************************************************************************
	 * getAllFromThree
	 **************************************************************************/

	@GetMapping("/all")
	public ResponseEntity<?> getAllFromThree() {
		List<FormThreeModel> list = new ArrayList<FormThreeModel>();
		list = services.getAllFormThreeDetails();
		if (list.size() == 0)
			throw new ResourceAccessException(env.getProperty("NOT_FOUND"));
		ResponseModel rs = new ResponseModel();
		rs.setMessage("record found");
		rs.setStatus("200");
		rs.setData(list);
		return ResponseEntity.ok(rs);
	}

	/**************************************************************************
	 * saveFromThreeDetails
	 **************************************************************************/
	@PostMapping("/save")
	public ResponseEntity<?> saveFromThreeDetails(@Valid @RequestBody FormThreeModel entity)
			throws ResourceNotFoundException {
		logger.debug("saveFromThreeDetails");
		String flag = "";
		Optional.ofNullable(entity).orElseThrow(() -> new ResourceAccessException(env.getProperty("DATA_INVALID")));

		FormThreeModel pm = services.saveFormThreeDetails(entity);
		Optional<FormThreeModel> op = Optional.ofNullable(pm);
		flag = op.isPresent() ? env.getProperty("SUCCESS") : env.getProperty("FAILED");
		ResponseModel rs = new ResponseModel();
		rs.setMessage(flag);
		if (flag.equals(env.getProperty("SUCCESS"))) {
			rs.setStatus("SUCCESS");
			rs.setData(pm);
		} else {
			rs.setStatus("FAILED");
		}

		return ResponseEntity.ok(rs);
	}

	/**************************************************************************
	 * assignProfessionals
	 **************************************************************************/
	@PostMapping("/assign-ca")
	public ResponseEntity<?> assignProfessionals(@Valid @RequestBody Form3AssignmentModel entity,
			HttpServletRequest req) throws ResourceNotFoundException {
		logger.debug("saveFromThreeDetails");
		String flag = "";
		Optional.ofNullable(entity).orElseThrow(() -> new ResourceAccessException(env.getProperty("DATA_INVALID")));
		AuthUser user = AuthUser.getLoggedInUser(req);
		entity.setFormAssignedBy(user.getProfileId().toString());
		entity.setFormAssignedOn(new Date());
		entity.setStatus(ReraConstants.ASSIGNED);
		FormThreeModel pm = services.assignProfessionals(entity);
		Optional<FormThreeModel> op = Optional.ofNullable(pm);
		flag = op.isPresent() ? env.getProperty("SUCCESS") : env.getProperty("FAILED");
		ResponseModel rs = new ResponseModel();
		rs.setMessage(flag);
		if (flag.equals(env.getProperty("SUCCESS"))) {
			try {

				notifcationServices
						.sendEmail(MailContents.formThreeAssignmentMail(altServices.getById(pm.getProjectAltrId())));

				notifcationServices
						.sendSms(SmsContents.formThreeAssignmentSmsToCa(altServices.getById(pm.getProjectAltrId())));
			} catch (Exception e) {
				logger.debug("Notification failed");

			}
			rs.setStatus("200");
			rs.setData(pm);
		} else {
			rs.setStatus("FAILED");
		}

		return ResponseEntity.ok(rs);
	}

	/**************************************************************************
	 * modifyFromThreeDetails
	 **************************************************************************/
	@PostMapping("/modify")
	public ResponseEntity<?> modifyFromThreeDetails(@RequestBody FormThreeModel entity)
			throws ResourceNotFoundException {
		logger.debug("saveFromThreeDetails");
		String flag = "";
		Optional.ofNullable(entity).orElseThrow(() -> new ResourceAccessException(env.getProperty("DATA_INVALID")));

		FormThreeModel pm = services.saveFormThreeDetails(entity);
		Optional<FormThreeModel> op = Optional.ofNullable(pm);
		flag = op.isPresent() ? env.getProperty("SUCCESS") : env.getProperty("FAILED");
		ResponseModel rs = new ResponseModel();
		rs.setMessage(flag);
		if (flag.equals(env.getProperty("SUCCESS"))) {
			rs.setStatus("200");
		} else {
			rs.setStatus("FAILED");
		}

		return ResponseEntity.ok(rs);
	}

	/**************************************************************************
	 * getAllFromThreeById
	 **************************************************************************/
	@GetMapping("/{id}")
	public ResponseEntity<?> getAllFromThreeById(@PathVariable(value = "id") Long id) {
		FormThreeModel m = services.getFormThreeDetailsById(id);
		Optional.ofNullable(m).orElseThrow(() -> new ResourceAccessException(env.getProperty("NOT_FOUND")));
		return ResponseEntity.ok(m);
	}

	/**************************************************************************
	 * getAllFromThreeByProjectId
	 **************************************************************************/
	@GetMapping("/alteration/{id}")
	public ResponseEntity<?> getAllFromThreeByProjetId(@PathVariable(value = "id") Long id) {
		FormThreeModel m = services.getFormThreeDetailsByProjectAltrIdAndStatusNot(id, ReraConstants.REJECTED);
		Optional.ofNullable(m).orElseThrow(() -> new ResourceAccessException(env.getProperty("NOT_FOUND")));
		ResponseModel rs = new ResponseModel();
		rs.setMessage("record found");
		rs.setStatus("200");
		rs.setData(m);
		return ResponseEntity.ok(rs);
	}

	/**************************************************************************
	 * updateStatus
	 **************************************************************************/
	@PutMapping("/update-status/alteration/{altId}/status/{status}")
	public ResponseEntity<?> updateFormThreeAssignedStatus(@PathVariable(value = "altId") Long altId,
			@PathVariable(value = "status") String status,
			@RequestParam(value = "referenceFormThreeId") Long referenceFormThreeId) throws ResourceNotFoundException {

		FormThreeModel result = services.updateStatus(altId, status, referenceFormThreeId);

		if (result.getStatus().contentEquals(ReraConstants.REJECTED)) {
			try {
				notifcationServices.sendEmail(
						MailContents.formThreeAssignmentMail(altServices.getById(result.getProjectAltrId())));
				notifcationServices.sendEmail(
						MailContents.formThreeAssignmentMail(altServices.getById(result.getProjectAltrId())));

			} catch (Exception e) {
				logger.debug("Notification failed");
			}

		}

		ResponseModel rs = new ResponseModel();
		rs.setMessage("record found");
		rs.setStatus("200");
		rs.setData(result);
		return ResponseEntity.ok(rs);
	}
}

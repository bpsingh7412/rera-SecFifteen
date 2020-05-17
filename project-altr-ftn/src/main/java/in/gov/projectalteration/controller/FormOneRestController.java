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
import in.gov.projectalteration.model.FormAssignmentModel;
import in.gov.projectalteration.model.FormOneModel;
import in.gov.projectalteration.notification.MailContents;
import in.gov.projectalteration.notification.NotificationUtil;
import in.gov.projectalteration.notification.SmsContents;
import in.gov.projectalteration.services.AlterationRegistrationServices;
import in.gov.projectalteration.services.FormOneDetailsService;
import in.gov.wf.security.AuthUser;

@PropertySource(ignoreResourceNotFound = true, value = "classpath:message/common.properties")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/project_alt_ftn/secure/form-one")
public class FormOneRestController {
	private static final Logger logger = LogManager.getLogger(FormOneRestController.class);
	@Autowired
	private Environment env;
	@Autowired
	FormOneDetailsService services;
	@Autowired
	NotificationUtil notifcationServices;
	@Autowired
	AlterationRegistrationServices altServices;

	/**************************************************************************
	 * getAllFormOne
	 **************************************************************************/
	@GetMapping("/all")
	public ResponseEntity<?> getAllFormOne() {
		List<FormOneModel> list = new ArrayList<>();
		list = services.getAllFormOnedettails();
		if (list.size() == 0)
			throw new ResourceAccessException(env.getProperty("NOT_FOUND"));

		ResponseModel rs = new ResponseModel();
		rs.setStatus("200");
		rs.setMessage(list.size() + " records found");
		rs.setData(list);
		return ResponseEntity.ok(rs);
	}

	/**************************************************************************
	 * saveFormOneDetails
	 **************************************************************************/
	@PostMapping("/save-form-one-details")
	public ResponseEntity<?> saveFormOneDetails(@Valid @RequestBody FormOneModel entity)
			throws ResourceNotFoundException {
		logger.debug("saveFormOneDetails");
		String flag = "";
		Optional.ofNullable(entity).orElseThrow(() -> new ResourceAccessException(env.getProperty("DATA_INVALID")));

		FormOneModel pm = services.saveProjectFormOnedettails(entity);
		Optional<FormOneModel> op = Optional.ofNullable(pm);
		flag = op.isPresent() ? env.getProperty("SUCCESS") : env.getProperty("FAILED");
		ResponseModel rs = new ResponseModel();

		rs.setMessage(flag);
		if (flag.equals(env.getProperty("SUCCESS"))) {
			rs.setStatus(env.getProperty("SUCCESS"));
			rs.setMessage("Saved successfully.");
			rs.setData(pm);
		} else {
			rs.setStatus(env.getProperty("FILED"));
			rs.setMessage("Some thing went wrong.");
		}
		return ResponseEntity.ok(rs);
	}

	
	/**************************************************************************
	 * assign-architech
	 **************************************************************************/
	@PostMapping("/assign-architect")
	public ResponseEntity<?> saveProfessionalAssignment(@Valid @RequestBody FormAssignmentModel entity,
			HttpServletRequest req) throws ResourceNotFoundException {
		logger.debug("saveFormOneDetails");
		System.out.println("saveFormOneDetails");

		String flag = "";
		Optional.ofNullable(entity).orElseThrow(() -> new ResourceAccessException(env.getProperty("DATA_INVALID")));
		AuthUser user=AuthUser.getLoggedInUser(req);
		entity.setFormAssignedBy(user.getProfileId().toString());
		entity.setFormAssignedOn(new Date());

		FormOneModel pm = services.saveProfessionalAssignment(entity);
		Optional<FormOneModel> op = Optional.ofNullable(pm);
		flag = op.isPresent() ? env.getProperty("SUCCESS") : env.getProperty("FAILED");
		ResponseModel rs = new ResponseModel();

		if (flag.equals(env.getProperty("SUCCESS"))) {
			try {
				
		notifcationServices.sendEmail(
				MailContents.formOneAssignmentMail(altServices.getById(pm.getProjectAltrId())));
		

				notifcationServices.sendSms(
						SmsContents.formOneAssignmentSmsToArchitect(altServices.getById(pm.getProjectAltrId())));
			} catch (Exception e) {
				logger.debug("notification failed");
			}
			
			rs.setStatus(env.getProperty("SUCCESS"));
			rs.setMessage("Architect assigned successfully.");
			rs.setData(pm);
		} else {
			rs.setStatus(env.getProperty("FILED"));
			rs.setMessage("Architect assignment failed. Please enter valid data.");
		}
		return ResponseEntity.ok(rs);
	}

	/**************************************************************************
	 * modifyFormOneDetails
	 **************************************************************************/
	@PutMapping("/modify-form-one-details")
	public ResponseEntity<?> modifyFormOneDetails(@RequestBody FormOneModel entity) throws ResourceNotFoundException {
		logger.debug("saveFormOneDetails");
		String flag = "";
		Optional.ofNullable(entity).orElseThrow(() -> new ResourceAccessException(env.getProperty("DATA_INVALID")));

		FormOneModel pm = services.saveProjectFormOnedettails(entity);
		Optional<FormOneModel> op = Optional.ofNullable(pm);
		flag = op.isPresent() ? env.getProperty("SUCCESS") : env.getProperty("FAILED");
		ResponseModel rs = new ResponseModel();
		if (flag.equals(env.getProperty("SUCCESS"))) {
			
			rs.setStatus("200");
			rs.setMessage(flag);
			rs.setData(pm);
		} else {
			rs.setStatus(env.getProperty("FAILED"));
			rs.setMessage("Some thing went wrong.");
		}
		return ResponseEntity.ok(rs);
	}

	/**************************************************************************
	 * getFormOneById
	 **************************************************************************/

	@GetMapping("/{id}")
	public ResponseEntity<?> getAllFormOneById(@PathVariable(value = "id") Long id) {
		FormOneModel m = services.getFormOnedettailsById(id);
		Optional.ofNullable(m).orElseThrow(() -> new ResourceAccessException(env.getProperty("NOT_FOUND")));
		ResponseModel rs = new ResponseModel();
		rs.setStatus("200");
		rs.setMessage("records found");
		rs.setData(m);
		return ResponseEntity.ok(rs);
	}

	/**************************************************************************
	 * getFormOneByProjectId
	 **************************************************************************/

	@GetMapping("/alteration/{id}")
	public ResponseEntity<?> getFormOneByProjectId(@PathVariable(value = "id") Long id) {
		FormOneModel m = services.getFormOneByProjectAltrIdAndStatus(id, "REJECTED");
		Optional.ofNullable(m).orElseThrow(() -> new ResourceAccessException(env.getProperty("NOT_FOUND")));
		ResponseModel rs = new ResponseModel();
		rs.setStatus("200");
		rs.setMessage("Success");
		rs.setData(m);
		return ResponseEntity.ok(rs);
	}

	@PutMapping("/update-form-one/project-alt/{id}/status/{status}")
	public ResponseEntity<?> updateFormOneStatus(@PathVariable(value = "id") Long id,
			@PathVariable(value = "status") String status, @RequestParam Long referenceFormOneId)
			throws ResourceNotFoundException {

		FormOneModel result = services.updateStatus(id, status, referenceFormOneId);

		if (result.getStatus().contentEquals(ReraConstants.REJECTED)) {
			try {
				
				notifcationServices.sendEmail(
						MailContents.formOneAssignmentMail(altServices.getById(result.getProjectAltrId())));
				
				
				notifcationServices.sendSms(
						SmsContents.formOneAssignmentSmsToArchitect(altServices.getById(result.getProjectAltrId())));
			} catch (Exception e) {
				logger.debug("Notification failed");
			}

		
		}

		ResponseModel rs = new ResponseModel();
		rs.setStatus("200");
		rs.setMessage("Success");
		rs.setData(result);
		return ResponseEntity.ok(rs);
	}

}

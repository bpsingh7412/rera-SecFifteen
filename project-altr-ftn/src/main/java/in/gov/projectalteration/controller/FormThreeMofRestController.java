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
import in.gov.projectalteration.model.MofF3AssignmentModel;
import in.gov.projectalteration.model.MofFormThreeModel;
import in.gov.projectalteration.notification.MailContents;
import in.gov.projectalteration.notification.NotificationUtil;
import in.gov.projectalteration.notification.SmsContents;
import in.gov.projectalteration.services.AlterationRegistrationServices;
import in.gov.projectalteration.services.FormThreeMofDetailsService;
import in.gov.wf.security.AuthUser;

@PropertySource(ignoreResourceNotFound = true, value = "classpath:message/common.properties")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/project_alt_ftn/secure/from-three-mof")
public class FormThreeMofRestController {
	private static final Logger logger = LogManager.getLogger(FormThreeMofRestController.class);
	@Autowired
	private Environment env;

	@Autowired
	FormThreeMofDetailsService services;
	
	@Autowired
	NotificationUtil notifcationServices;
	
	@Autowired
	AlterationRegistrationServices altServices;

	/**************************************************************************
	 * getAllFromThree
	 **************************************************************************/

	@GetMapping("/all")
	public ResponseEntity<?> getAllFromThree() {
		List<MofFormThreeModel> list = new ArrayList<MofFormThreeModel>();
		list = services.getAllFormThreeDetails();
		if (list.size() == 0)
			throw new ResourceAccessException(env.getProperty("NOT_FOUND"));
		return ResponseEntity.ok(list);
	}

	/**************************************************************************
	 * saveFromThreeDetails
	 **************************************************************************/
	@PostMapping("/save-from-three-details")
	public ResponseEntity<?> saveFromThreeDetails(@Valid @RequestBody MofFormThreeModel entity)
			throws ResourceNotFoundException {
		logger.debug("saveFromThreeDetails");
		String flag = "";
		Optional.ofNullable(entity).orElseThrow(() -> new ResourceAccessException(env.getProperty("DATA_INVALID")));

		MofFormThreeModel pm = services.saveFormThreeMofDetails(entity);
		Optional<MofFormThreeModel> op = Optional.ofNullable(pm);
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
	public ResponseEntity<?> assignProfessionals(@Valid @RequestBody MofF3AssignmentModel entity,HttpServletRequest req)
			throws ResourceNotFoundException {
		logger.debug("saveFromThreeDetails");
		String flag = "";
		Optional.ofNullable(entity).orElseThrow(() -> new ResourceAccessException(env.getProperty("DATA_INVALID")));
		AuthUser user = AuthUser.getLoggedInUser(req);
		entity.setFormAssignedBy(user.getProfileId().toString());
		entity.setFormAssignedOn(new Date());		
		entity.setStatus(ReraConstants.ASSIGNED);
		MofFormThreeModel pm = services.assignProfessionals(entity);
		Optional<MofFormThreeModel> op = Optional.ofNullable(pm);
		flag = op.isPresent() ? env.getProperty("SUCCESS") : env.getProperty("FAILED");
		ResponseModel rs = new ResponseModel();
		rs.setMessage(flag);
		if (flag.equals(env.getProperty("SUCCESS"))) {
			try {
				notifcationServices.sendEmail(
						MailContents.formThreeAssignmentMail(altServices.getById(pm.getProjAltId())));

				notifcationServices.sendSms(
						SmsContents.formThreeAssignmentSmsToCa(altServices.getById(pm.getProjAltId())));
			} catch (Exception e) {

				System.out.println("[/assign-ca] Notification failed");
			}
			rs.setStatus("SUCCESS");
			rs.setData(pm);
		} else {
			rs.setStatus("FAILED");
		}

		return ResponseEntity.ok(rs);
	}
	
	/**************************************************************************
	 * modifyFromThreeDetails
	 **************************************************************************/
	@PostMapping("/modify-from-three-details")
	public ResponseEntity<?> modifyFromThreeDetails(@RequestBody MofFormThreeModel entity)
			throws ResourceNotFoundException {
		logger.debug("saveFromThreeDetails");
		String flag = "";
		Optional.ofNullable(entity).orElseThrow(() -> new ResourceAccessException(env.getProperty("DATA_INVALID")));

		MofFormThreeModel pm = services.saveFormThreeMofDetails(entity);
		Optional<MofFormThreeModel> op = Optional.ofNullable(pm);
		flag = op.isPresent() ? env.getProperty("SUCCESS") : env.getProperty("FAILED");
		ResponseModel rs = new ResponseModel();
		rs.setMessage(flag);
		if (flag.equals(env.getProperty("SUCCESS"))) {
			rs.setStatus("MODIFY");
		} else {
			rs.setStatus("FAILED");
		}

		return ResponseEntity.ok(rs);
	}

	/**************************************************************************
	 * getAllFromThreeById
	 **************************************************************************/
	@GetMapping("/{id}")
	public ResponseEntity<?> getAllFromThreeById(@PathVariable (value="id") Long id) {
		MofFormThreeModel m = services.getFormThreeDetailsById(id);
		Optional.ofNullable(m).orElseThrow(()-> new ResourceAccessException(env.getProperty("NOT_FOUND")));
		return ResponseEntity.ok(m);
	}
	
	/**************************************************************************
	 * getAllFromThreeByProjectId
	 **************************************************************************/
	
	@GetMapping("/alteration{id}")  
	public ResponseEntity<?> getAllFromThreeByProjetId(@PathVariable (value="id") Long id) {
		MofFormThreeModel m = services.getFormThreeDetailsByprojectRegIdAndStatusNot(id, ReraConstants.REJECTED);
		Optional.ofNullable(m).orElseThrow(()-> new ResourceAccessException(env.getProperty("NOT_FOUND")));
		return ResponseEntity.ok(m);
	}
	/**************************************************************************
	 * updateStatus
	 **************************************************************************/
	@PutMapping("/update-status/project-alt/{prjaltid}/status/{status}")
	public ResponseEntity<?> updateFormThreeAssignedStatus(@PathVariable(value = "prjaltid") Long prjaltid,
			@PathVariable(value = "status") String status,
			@RequestParam(value = "referenceForm3Id") Long referenceForm3Id) throws ResourceNotFoundException {
		MofFormThreeModel form3Model = services.updateStatus(prjaltid, status, referenceForm3Id);
		try {
			notifcationServices.sendEmail(
					MailContents.formThreeAssignmentMail(altServices.getById(form3Model.getProjAltId())));

			notifcationServices.sendSms(
					SmsContents.formThreeAssignmentSmsToCa(altServices.getById(form3Model.getProjAltId())));
		} catch (Exception e) {

			System.out.println("[/update-status/project-reg/{prjregid}/status/{status}] Notification failed");
		}
		return ResponseEntity.ok(form3Model);
	}
}

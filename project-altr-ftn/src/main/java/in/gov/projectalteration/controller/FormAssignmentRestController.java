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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import in.gov.projectalteration.common.model.ResponseModel;
import in.gov.projectalteration.exception.ResourceNotFoundException;
import in.gov.projectalteration.model.FormAssignmentModel;
import in.gov.projectalteration.services.FormAssignmentDetailsServices;
import in.gov.wf.security.AuthUser;


@PropertySource(ignoreResourceNotFound = true, value = "classpath:message/common.properties")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/project_alt_ftn/secure/form-assignment")
public class FormAssignmentRestController {
	private static final Logger logger = LogManager.getLogger(FormAssignmentRestController.class);
	@Autowired
	private Environment env;
	@Autowired
	FormAssignmentDetailsServices services;

	/**************************************************************************
	 * getAllAssignmentDetails
	 **************************************************************************/

	@GetMapping("/all")
	public ResponseEntity<?> getAllCaDetails() {
		List<FormAssignmentModel> list = new ArrayList<FormAssignmentModel>();
		list = services.getAllFormAssignmentDetails();
		if (list.size() == 0)
			throw new ResourceAccessException(env.getProperty("NOT_FOUND"));
		ResponseModel rs = new ResponseModel();
		rs.setMessage("records found.");
		rs.setStatus("200");
		rs.setData(list);
		return ResponseEntity.ok(rs);
	}

	/**************************************************************************
	 * savePreviousProjectDetails
	 **************************************************************************/
	@PostMapping("/save")
	public ResponseEntity<?> saveAssignmentProjectDetails(@Valid @RequestBody FormAssignmentModel entity,HttpServletRequest req)
			throws ResourceNotFoundException {
		logger.debug("save");
		String flag = "";
		Optional.ofNullable(entity).orElseThrow(() -> new ResourceAccessException(env.getProperty("DATA_INVALID")));
		//entity.setStatus("PENDING");
		AuthUser user=AuthUser.getLoggedInUser(req);
		entity.setFormAssignedBy(user.getProfileId().toString());
		entity.setFormAssignedOn(new Date());
		FormAssignmentModel m = services.saveFormAssignmentDetails(entity);
		Optional.ofNullable(m).orElseThrow(() -> new ResourceAccessException(env.getProperty("DATA_INVALID")));
		ResponseModel rs = new ResponseModel();
		rs.setMessage(flag);
		rs.setStatus("200");
		rs.setData(m);
		return ResponseEntity.ok(rs);
	}

	/**************************************************************************
	 * updatePreviousProjectDetails
	 **************************************************************************/
	@PutMapping("/modify")
	public ResponseEntity<?> modify(@Valid @RequestBody FormAssignmentModel entity)
			throws ResourceNotFoundException {
		logger.debug("modify");
		String flag = "";
		Optional.ofNullable(entity).orElseThrow(() -> new ResourceAccessException(env.getProperty("DATA_INVALID")));

		FormAssignmentModel m = services.saveFormAssignmentDetails(entity);
		Optional.ofNullable(m).orElseThrow(() -> new ResourceAccessException("Failed to modify"));
		ResponseModel rs = new ResponseModel();
		rs.setMessage(flag);
		rs.setStatus("200");
		rs.setData(m);
		return ResponseEntity.ok(rs);
	}
	
	/**************************************************************************
	 * modifyAssignmentStatus
	 **************************************************************************/
	@PutMapping("/modify-status/{id}/status/{status}")
	public ResponseEntity<?> modifyAssignmentStatus(@PathVariable (value="id") Long id, 
			@PathVariable (value="status") String status)
			throws ResourceNotFoundException {
		logger.debug("modifyAssignmentStatus");	
		Optional.ofNullable(id).orElseThrow(() -> new ResourceAccessException(env.getProperty("DATA_INVALID")));
		FormAssignmentModel m = services.getFormAssignmentDetailsById(id);
		Optional.ofNullable(m).orElseThrow(() -> new ResourceAccessException("Not found "+id));		
		m.setStatus(status);		
		Optional.ofNullable(services.updateFormAssignmentDetails(m)).orElseThrow(() -> new ResourceAccessException("Status not updated"));
		
		ResponseModel rs = new ResponseModel();
		rs.setMessage("Status updated :"+status);
		rs.setStatus("200");
		rs.setData(m);
		return ResponseEntity.ok(rs);
	}

	/**************************************************************************
	 * getPreviousProjectDetailsById
	 **************************************************************************/
	@GetMapping("/assigned-form-details{id}")
	public ResponseEntity<FormAssignmentModel> getAssignedFormDetailsById(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException {
		FormAssignmentModel d = services.getFormAssignmentDetailsById(id);
		 Optional.ofNullable(d).orElseThrow(()-> new ResourceAccessException("Not Found for id" + id));
		
		 	ResponseModel rs = new ResponseModel();
			rs.setMessage("records founds.");
			rs.setStatus("200");
			rs.setData(d);
		return ResponseEntity.ok(d);
	}

	/**************************************************************************
	 * getPreviousProjectDetailsByProjectRegId
	 **************************************************************************/
	@GetMapping("/assigned-professional{id}")
	public ResponseEntity<List<FormAssignmentModel>> getAssignedByProfessionalId(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException {
		List<FormAssignmentModel> ml = services.getFormAssignmentDetailsByProfessionalId(id);
		if (ml.size() == 0)
			throw new ResourceAccessException("Not Found for id " + id);
		
		ResponseModel rs = new ResponseModel();
		rs.setMessage(ml.size()+" records founds.");
		rs.setStatus("200");
		rs.setData(ml);
		return ResponseEntity.ok(ml);
	}
}

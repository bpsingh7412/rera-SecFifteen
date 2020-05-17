package in.gov.projectalteration.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

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
import in.gov.projectalteration.dao.ProjectAlterationDetailsDao;
import in.gov.projectalteration.exception.ResourceNotFoundException;
import in.gov.projectalteration.model.ProjectDetailModel;
import in.gov.projectalteration.services.ProjectDetailsService;

@PropertySource(ignoreResourceNotFound = true, value = "classpath:application.properties")
@PropertySource(ignoreResourceNotFound = true, value = "classpath:message/common.properties")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/project_alt_ftn/secure/project-details")

public class ProjectDeailsRestController {
	private static final Logger logger = LogManager.getLogger(ProjectDeailsRestController.class);
	@Autowired
	private Environment env;

	@Autowired
	ProjectDetailsService services;

	@Autowired
	ProjectAlterationDetailsDao dao;

	/**************************************************************************
	 * getAll
	 **************************************************************************/

	@GetMapping("/all")
	public ResponseEntity<?> getAllProjectRegistrationDetails() {
		List<ProjectDetailModel> list = new ArrayList<ProjectDetailModel>();
		list = services.getAll();
		if (list.size() == 0)
			throw new ResourceAccessException(env.getProperty("NOT_FOUND"));
		return ResponseEntity.ok(list);
	}

	/**************************************************************************
	 * save
	 **************************************************************************/
	@PostMapping("/save")
	public ResponseEntity<?> saveProjectDetails(@RequestBody ProjectDetailModel entity, HttpServletRequest request)
			throws ResourceNotFoundException {
		logger.debug("saveProjectDetails Start");
		Optional.ofNullable(entity).orElseThrow(() -> new ResourceAccessException(env.getProperty("DATA_INVALID")));
		ProjectDetailModel pm = services.saveProjectDetails(entity);
		// Optional.ofNullable(pm).orElseThrow(()->new ResourceAccessException(" Some
		// thing went wrong.")) ;
		// ProjectAlterationDocumentModel
		// commitDocument=docServives.commitDocument(pm.getDocument());
		// ProjectAlterationDocumentModel
		// updateDocument=docServives.update(commitDocument);
		// pm.setDocument(commitDocument);
		// ProjectDetailModel updateProjectDetails = services.updateProjectDetails(pm);
		Optional<ProjectDetailModel> op = Optional.ofNullable(pm);

		ResponseModel rs = new ResponseModel();
		if (op.isPresent()) {
			rs.setMessage("Saved successfully");
			rs.setStatus("200");
			rs.setData(pm);
		} else {
			rs.setMessage("Some thing went wrong.");
			rs.setStatus("300");
			// throw new ResourceAccessException(env.getProperty("FAILED"));
		}

		return ResponseEntity.ok(rs);
	}

	/**************************************************************************
	 * modify
	 **************************************************************************/
	@PutMapping("/modify")
	public ResponseEntity<?> modify(@RequestBody ProjectDetailModel entity) throws ResourceNotFoundException {
		logger.debug("modify");
		Optional.ofNullable(entity).orElseThrow(() -> new ResourceAccessException(env.getProperty("DATA_INVALID")));
		ProjectDetailModel pm = services.updateProjectDetails(entity);
		Optional<ProjectDetailModel> op = Optional.ofNullable(pm);
		ResponseModel rs = new ResponseModel();
		if (op.isPresent()) {
			rs.setMessage("Updated successfully.");
			rs.setStatus("200");
			rs.setData(pm);
		} else {
			rs.setMessage("Some thing went wrong.");
			rs.setStatus("300");
		}

		return ResponseEntity.ok(rs);
	}

	/**************************************************************************
	 * getById
	 **************************************************************************/

	@GetMapping("getBy/{id}")
	public ResponseEntity<?> getProjectRegistrationDetailById(@PathVariable(value = "id") Long id) {

		ProjectDetailModel m = services.getProjectDetailsById(id);
		Optional.ofNullable(m).orElseThrow(() -> new ResourceAccessException(env.getProperty("NOT_FOUND")));
		ResponseModel rs = new ResponseModel();
		rs.setMessage("Records found.");
		rs.setStatus("200");
		rs.setData(m);
		return ResponseEntity.ok(rs);
	}

	/**************************************************************************
	 * getByAlterationId
	 **************************************************************************/

	@GetMapping("/alteration/{id}")
	public ResponseEntity<?> getByAlterationId(@PathVariable(value = "id") Long id) {
		ProjectDetailModel m = services.getByAlterationId(id);
		Optional.ofNullable(m).orElseThrow(() -> new ResourceAccessException(env.getProperty("NOT_FOUND")));
		ResponseModel rs = new ResponseModel();
		rs.setMessage("Records found.");
		rs.setStatus("200");
		rs.setData(m);
		return ResponseEntity.ok(rs);
	}

	/*
	 * @GetMapping("/getBypro/{id}") public ResponseEntity<?>
	 * getProjectRegistrationDetailsById(@PathVariable(value = "id") Long id) {
	 * ProjectDetailModel pro = services.getProjectDetailsById(id);
	 * 
	 * Optional<ProjectAlterationModel> result =
	 * dao.findById(pro.getProjectAltrId());
	 * 
	 * Optional.ofNullable(result).orElseThrow(() -> new
	 * ResourceAccessException(env.getProperty("NOT_FOUND")));
	 * ProjectRegistrationModel rg= new ProjectRegistrationModel();
	 * rg.setProjectName(result.get().getProjectName());
	 * rg.setProjectStatus(result.get().getStatus());
	 * rg.setProjectAltAckNo(result.get().getProjectAltAckNo());
	 * rg.setAppSubmissionDate(result.get().getAppSubmissionDate());
	 * 
	 * ResponseModel rs = new ResponseModel(); rs.setMessage("Records found.");
	 * rs.setStatus("200"); rs.setData(result); return ResponseEntity.ok(rs); }
	 */
}

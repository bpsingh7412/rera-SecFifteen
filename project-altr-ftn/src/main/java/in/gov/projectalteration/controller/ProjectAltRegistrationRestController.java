package in.gov.projectalteration.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import in.gov.projectalteration.common.model.ResponseModel;
import in.gov.projectalteration.common.model.ResponseStatusCodeModel;
import in.gov.projectalteration.common.model.WithdrawalRequestModel;
import in.gov.projectalteration.common.model.WithdrawalRestDto;
import in.gov.projectalteration.common.services.impl.UserRestTemplateServices;
import in.gov.projectalteration.constants.ReraConstants;
import in.gov.projectalteration.exception.ResourceNotFoundException;
import in.gov.projectalteration.model.ProjectAlterationModel;
import in.gov.projectalteration.model.transaction.AssigedUserTransactionModel;
import in.gov.projectalteration.model.transaction.ProjectAlterationDto;
import in.gov.projectalteration.services.AlterationRegistrationServices;
import in.gov.projectalteration.services.ProjectDetailsService;
import in.gov.wf.security.AuthUser;

@PropertySource(ignoreResourceNotFound = true, value = "classpath:application.properties")
@PropertySource(ignoreResourceNotFound = true, value = "classpath:message/common.properties")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/project_alt_ftn/secure")

//saveproject-officenote
public class ProjectAltRegistrationRestController {
	private static final Logger logger = LogManager.getLogger(ProjectAltRegistrationRestController.class);
	@Autowired
	private Environment env;

	@Autowired
	AlterationRegistrationServices services;
	@Autowired
	ProjectDetailsService servicess;
	
	@Value(value="${widrawal.status.service.url}")
	String urlWithdrawal;
	
	boolean flag;

	/**************************************************************************
	 * getAll
	 **************************************************************************/

	@GetMapping("/all")
	public ResponseEntity<?> getAll() {
		List<ProjectAlterationModel> list = services.getAll();
		if (list.size() == 0)
			throw new ResourceAccessException(env.getProperty("NOT_FOUND"));
		ResponseModel rs = new ResponseModel();
		rs.setMessage("records found.");
		rs.setStatus("200");
		rs.setData(list);
		return ResponseEntity.ok(rs);
	}
	
	@GetMapping("/all/{statecode}")
	public ResponseEntity<?> getAllByStatus(@PathVariable(value = "statecode") String statecode) {
		List<ProjectAlterationModel> list = services.getAllByStatus(statecode);
		List datalist=new ArrayList();
		if (list.size() == 0)
			throw new ResourceAccessException(env.getProperty("NOT_FOUND"));
		list.forEach(dataList->{
			ResponseStatusCodeModel rscm=new ResponseStatusCodeModel();
			rscm.setRegistrationNo("");
			rscm.setPromoterName(dataList.getPromoterName());
			rscm.setProjectName(dataList.getProjectName());
			rscm.setProjectType(dataList.getProjectType());
			rscm.setProjectCost(dataList.getProjectDetailModel().getTotalProjectCost());
			rscm.setStatus(dataList.getStateCode());
			rscm.setStateName(dataList.getStateName());
			rscm.setSubmissionDate(dataList.getAppSubmissionDate());
			rscm.setProjectStatrDate(dataList.getProjectDetailModel().getStartDate());
			rscm.setProjectEndDate(dataList.getProjectDetailModel().getCompletionDate());
			datalist.add(rscm);
		});
		ResponseModel rs = new ResponseModel();
		rs.setMessage("records found.");
		rs.setStatus("200");
		rs.setData(datalist);
		return ResponseEntity.ok(rs);
	}

	/**************************************************************************
	 * saveProjectRegistrationDetails
	 **************************************************************************/
	@PostMapping("/save-alteration")
	public ResponseEntity<?> saveProjectDetails(@Valid @RequestBody ProjectAlterationModel entity)
			throws ResourceNotFoundException {
		logger.debug("saveProjectRegistrationDetails");
		Optional.ofNullable(entity).orElseThrow(() -> new ResourceAccessException("invalid data"));
		entity.setStatus("SAVEASDRAFT");
		ProjectAlterationModel pm = services.save(entity);
		Optional<ProjectAlterationModel> op = Optional.ofNullable(pm);
		ResponseModel rs = new ResponseModel();
		if (op.isPresent()) {
			rs.setMessage("Saved successfully");
			rs.setStatus("200");
			rs.setData(pm);
		} else {
			rs.setStatus("FAILED");
			throw new ResourceAccessException(env.getProperty("FAILED"));
		}

		return ResponseEntity.ok(rs);
	}
	
	/**************************************************************************
	 * saveProjectAlterationSection15Details
	 **************************************************************************/
	@PostMapping("/save-alteration-section15")
	public ResponseEntity<?> saveProjectAltSection15Details(@RequestBody ProjectAlterationModel entity)
			throws ResourceNotFoundException {
		logger.debug("saveProjectRegistrationDetails");
		Optional.ofNullable(entity).orElseThrow(() -> new ResourceAccessException("invalid data"));
		entity.setStatus("SAVEASDRAFT");
		ProjectAlterationModel pm = services.saveSection15(entity);
		Optional<ProjectAlterationModel> op = Optional.ofNullable(pm);
		ResponseModel rs = new ResponseModel();
		if (op.isPresent()) {
			rs.setMessage("Saved successfully");
			rs.setStatus("200");
			rs.setData(pm);
		} else {
			rs.setStatus("FAILED");
			throw new ResourceAccessException(env.getProperty("FAILED"));
		}

		return ResponseEntity.ok(rs);
	}
	

	/**************************************************************************
	 * modify
	 **************************************************************************/
	@PutMapping("/modify-alteration")
	public ResponseEntity<?> modifyProjectRegistrationDetails(@RequestBody ProjectAlterationModel entity)
			throws ResourceNotFoundException {
		logger.debug("modify");
		Optional.ofNullable(entity).orElseThrow(() -> new ResourceAccessException(env.getProperty("DATA_INVALID")));
		ProjectAlterationModel pm = services.update(entity);
		Optional<ProjectAlterationModel> op = Optional.ofNullable(pm);
		ResponseModel rs = new ResponseModel();
		if (op.isPresent()) {
			rs.setMessage("MODIFIED");
			rs.setStatus("200");
			rs.setData(pm);
		} else {
			throw new ResourceAccessException(env.getProperty("FAILED"));
		}

		return ResponseEntity.ok(rs);
	}

	/**************************************************************************
	 * getById
	 **************************************************************************/

	@GetMapping("/{id}")
	public ResponseEntity<?> getProjectRegistrationDetailsById(@PathVariable(value = "id") Long id) {
		ProjectAlterationModel m = services.getById(id);
		Optional.ofNullable(m).orElseThrow(() -> new ResourceAccessException(env.getProperty("NOT_FOUND")));
		ResponseModel rs = new ResponseModel();
		rs.setStatus("200");
		rs.setMessage("record found");
		rs.setData(m);
		return ResponseEntity.ok(rs);
	}

	@GetMapping("/getByproject/{id}")
	public ResponseEntity<?> getProjectRegistrationDetailsByProId(@PathVariable(value = "id") Long id) {
		List<ProjectAlterationModel> ma = services.getByProjectId(id);
		Optional.ofNullable(ma).orElseThrow(() -> new ResourceAccessException(env.getProperty("NOT_FOUND")));
		
		for (ProjectAlterationModel altr : ma) {
			if(isWidrawal(altr.getProjectAltrId())){
				ma.remove(altr.getProjectAltrId());
			}			
		}
		ResponseModel rs = new ResponseModel();
		rs.setStatus("200");
		rs.setMessage("record found");
		rs.setData(ma);
		return ResponseEntity.ok(rs);
	}
	
	@GetMapping("/get-list-by-project-id/{id}")
	public ResponseEntity<?> getProjectListProId(@PathVariable(value = "id") Long id) {
		List<ProjectAlterationModel> ma = services.getByProjectId(id);
		Optional.ofNullable(ma).orElseThrow(() -> new ResourceAccessException(env.getProperty("NOT_FOUND")));
		List<ProjectAlterationDto> dList = new ArrayList<>();
		for (ProjectAlterationModel altr : ma) {
			if(!ReraConstants.COMPLETED.equals(altr.getStageOneStatus()))
			dList.add(ProjectAlterationDto.populate(altr));			
		}
		ResponseModel rs = new ResponseModel();
		rs.setStatus("200");
		rs.setMessage("record found");
		rs.setData(dList);
		return ResponseEntity.ok(rs);
	}
	
	@GetMapping("/get-stage-one-old-list")
	public ResponseEntity<?> getProjectListForOldPromoter(HttpServletRequest req) {
		AuthUser user=AuthUser.getLoggedInUser(req);
		List<ProjectAlterationModel> ma = services.getByPromoterId(user.getProfileId());
		Optional.ofNullable(ma).orElseThrow(() -> new ResourceAccessException(env.getProperty("NOT_FOUND")));
		List<ProjectAlterationDto> dList = new ArrayList<>();
		for (ProjectAlterationModel altr : ma) {
			if(ReraConstants.COMPLETED.equals(altr.getStageOneStatus())
					&& ReraConstants.APPROVED.equals(altr.getStateCode()))
			dList.add(ProjectAlterationDto.populate(altr));			
		}
		ResponseModel rs = new ResponseModel();
		rs.setStatus("200");
		rs.setMessage("record found");
		rs.setData(dList);
		return ResponseEntity.ok(rs);
	}
	
	@GetMapping("/section-15-by-prj-id/{id}")
	public ResponseEntity<?> getSection15AlterationDtl(@PathVariable(value = "id") Long id) {
		List<ProjectAlterationModel> ma = services.getByProjectId(id);
		Optional.ofNullable(ma).orElseThrow(() -> new ResourceAccessException(env.getProperty("NOT_FOUND")));
		ProjectAlterationModel m = new ProjectAlterationModel();
		for(ProjectAlterationModel model:ma)
		{
			if(ReraConstants.SECTION_15.equalsIgnoreCase(model.getAlterationType())  && (ReraConstants.SAVEASDRAFT.equalsIgnoreCase(model.getStatus()) || ReraConstants.PENDING.equalsIgnoreCase(model.getStatus())))
			{
				m=model;
			}
		}
		ResponseModel rs = new ResponseModel();
		rs.setStatus("200");
		rs.setMessage("record found");
		rs.setData(m);
		return ResponseEntity.ok(rs);
	}
	
	private boolean isWidrawal(Long altId) {
		flag=false;
		WithdrawalRestDto dto = UserRestTemplateServices.getByWidralStateCode(urlWithdrawal+"Approved");
		List<WithdrawalRequestModel> wplist = dto.getWithdrawalList();
		wplist.forEach(e -> {
			System.out.println("Process Id== "+e.getProcessId());
			if (e.getProcessId().compareTo(altId) == 0) {
				flag = true;
			}

		});

		return flag;
	}

	@GetMapping("/architect{id}")
	public ResponseEntity<?> getProjectRegistrationDetailsByArchitectId(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException {
		List<AssigedUserTransactionModel> m = services.getDetailsByArchitechtId(id);
		Optional.ofNullable(m).orElseThrow(() -> new ResourceAccessException(env.getProperty("NOT_FOUND")));
		ResponseModel rs = new ResponseModel();
		rs.setStatus("200");
		rs.setMessage(m.size() + " record found");
		rs.setData(m);
		return ResponseEntity.ok(rs);
	}

	@GetMapping("/ca{id}")
	public ResponseEntity<?> getProjectRegistrationDetailsByCaId(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException {
		List<AssigedUserTransactionModel> m = services.getDetailsByCaId(id);
		Optional.ofNullable(m).orElseThrow(() -> new ResourceAccessException(env.getProperty("NOT_FOUND")));
		ResponseModel rs = new ResponseModel();
		rs.setStatus("200");
		rs.setMessage(m.size() + " record found");
		rs.setData(m);
		return ResponseEntity.ok(rs);
	}

	
	@GetMapping("/mof/ca{id}")
	public ResponseEntity<?> getProjectAltByCaId(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException {
		List<AssigedUserTransactionModel> m = services.getDetailsMofByCaId(id);
		Optional.ofNullable(m).orElseThrow(() -> new ResourceAccessException(env.getProperty("NOT_FOUND")));
		ResponseModel rs = new ResponseModel();
		rs.setStatus("200");
		rs.setMessage(m.size() + " record found");
		rs.setData(m);
		return ResponseEntity.ok(rs);
	}
	
	@GetMapping("/engineer{id}")
	public ResponseEntity<?> getProjectRegistrationDetailsByEngineerId(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException {
		List<AssigedUserTransactionModel> m = services.getDetailsByEngineerId(id);
		Optional.ofNullable(m).orElseThrow(() -> new ResourceAccessException(env.getProperty("NOT_FOUND")));
		ResponseModel rs = new ResponseModel();
		rs.setStatus("200");
		rs.setMessage(m.size() + " record found");
		rs.setData(m);
		return ResponseEntity.ok(rs);
	}

	@GetMapping("/professional-assignment-status/alteration-id/{id}")
	public ResponseEntity<?> getFormAssignmentStatusDetails(@PathVariable Long id) throws ResourceNotFoundException {
		ResponseModel rs = new ResponseModel();
		Map<String, String> l = services.getFormAssignmentStatusDetails(id);
		if (Optional.ofNullable(l).isPresent()) {
			rs.setStatus("200");
			rs.setMessage("Assigned professional details");
			rs.setData(l);
		} else {
			rs.setStatus("000");
			rs.setMessage("data  not found");
			rs.setData(l);
			throw new ResourceAccessException("data not found");
		}

		return ResponseEntity.ok(rs);
	}

}

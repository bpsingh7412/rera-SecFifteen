package in.gov.projectaltsection15.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import in.gov.projectalteration.common.model.ResponseModel;
import in.gov.projectalteration.constants.ReraConstants;
import in.gov.projectalteration.model.ProjectAlterationModel;
import in.gov.projectalteration.services.AlterationRegistrationServices;
import in.gov.projectaltsection15.model.Setion15StageOneModel;
import in.gov.projectaltsection15.services.StageOneService;
import in.gov.wf.security.AuthSecurity;
import in.gov.wf.security.AuthUser;

@PropertySource(ignoreResourceNotFound = true, value = "classpath:application.properties")
@PropertySource(ignoreResourceNotFound = true, value = "classpath:message/common.properties")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/project_alt_ftn/secure/section15/stage-one")
public class StageOneRestController {
	private static final Logger logger = LogManager.getLogger(StageOneRestController.class);
	@Autowired
    private Environment env;
	@Autowired
	StageOneService services;
	@Autowired
	AlterationRegistrationServices prs;
	
	/**************************************************************************
	 * getAll 
	 **************************************************************************/
	/*
	 * @GetMapping("/all-agent") public ResponseEntity<?> getAllAgent(){
	 * List<Setion15StageOneModel> list =new ArrayList<Setion15StageOneModel>();
	 * list=services.getAllSta(); if(list.size()==0) throw new
	 * ResourceAccessException(env.getProperty("NOT_FOUND")); return
	 * ResponseEntity.ok(list); }
	 */

	/**************************************************************************
	 * saveDetails
	 **************************************************************************/
	@PostMapping("/save")
	public ResponseEntity<?> save(@Valid @RequestBody Setion15StageOneModel entity) 
			{
		logger.debug("saveAgentDetails");
		String flag="";
		Setion15StageOneModel pm;
		ResponseModel rs=new ResponseModel();
		pm=services.saveStageOneDetails(entity,env.getProperty("URL_CREATE_VDMS"));
		Optional<Setion15StageOneModel> op=Optional.ofNullable(pm);
		flag=op.isPresent()?env.getProperty("SUCCESS"):env.getProperty("FAILED");
		rs.setMessage(flag);
		if(flag.equals(env.getProperty("SUCCESS"))) {
			rs.setStatus(env.getProperty("SUCCESS"));
			rs.setData(pm);
		}else {
			rs.setStatus(env.getProperty("SUCCESS"));
			rs.setStatus(env.getProperty("FAIL"));
		}
		
		return ResponseEntity.ok(rs);
	}
	
	@PostMapping("/modify-reasondtl")
	public ResponseEntity<?> modifyReason(@Valid @RequestBody Setion15StageOneModel entity) 
			{
		String flag="";
		Setion15StageOneModel pm =  services.getByPrjAltId(entity.getProjectAltrId());
		pm.setReaasonForTransfer(entity.getReaasonForTransfer());
		pm.setAloContentNotDocId(entity.getAloContentNotDocId());
	    pm = services.commitAllotteeDoc(pm,env.getProperty("URL_CREATE_VDMS"));
				
		ResponseModel rs=new ResponseModel();
		Optional<Setion15StageOneModel> op=Optional.ofNullable(pm);
		flag=op.isPresent()?env.getProperty("SUCCESS"):env.getProperty("FAILED");
		rs.setMessage(flag);
		if(flag.equals(env.getProperty("SUCCESS"))) {
			rs.setStatus(env.getProperty("SUCCESS"));
			rs.setData(pm);
		}else {
			rs.setStatus(env.getProperty("SUCCESS"));
			rs.setStatus(env.getProperty("FAIL"));
		}
		
		return ResponseEntity.ok(rs);
	}
	
	
	
	/**************************************************************************
	 * getStageOneById
	 **************************************************************************/
	@GetMapping("/{id}")
	public ResponseEntity<?> getStageOneById(@PathVariable (value="id") Long id){		
		Setion15StageOneModel m=services.getStageOneDetailsById(id);
		Optional.of(m).orElseThrow(()->
			 new ResourceAccessException(env.getProperty("NOT_FOUND")));
		ResponseModel rs=new ResponseModel();
		rs.setStatus("200");
		rs.setMessage("");
		rs.setData(m);
		return ResponseEntity.ok(rs);
	}
	
	/**************************************************************************
	 * get
	 **************************************************************************/
	@GetMapping("/alteration{id}")
	public ResponseEntity<?> getStageOneByAlterationId(@PathVariable (value="id") Long id){		
		Setion15StageOneModel lm=services.getByPrjAltId(id);
		Optional.of(lm).orElseThrow(()->
			 new ResourceAccessException(env.getProperty("NOT_FOUND")));
		
		ResponseModel rs=new ResponseModel();
		rs.setStatus("200");
		rs.setMessage("");
		rs.setData(lm);
		return ResponseEntity.ok(rs);
	}
	
	@GetMapping("/stage-two-list-by-promtoer")
	public ResponseEntity<?> getStageTwoListByPromoterId(HttpServletRequest req){
		AuthUser user = (AuthUser) req.getAttribute(AuthSecurity.AUTH_USER_ATTR);
		List<Setion15StageOneModel> lm=services.getByPromoterId(user.getProfileId());
		List<ProjectAlterationModel> pList = new ArrayList<>();
		for(Setion15StageOneModel model :lm)
		{
			ProjectAlterationModel m = prs.getById(model.getProjectAltrId());
			if(ReraConstants.STAGE2.equals(m.getAltrStatus()))
		    pList.add(m);
		}
		ResponseModel rs=new ResponseModel();
		rs.setStatus("200");
		rs.setMessage("");
		rs.setData(pList);
		return ResponseEntity.ok(rs);
	}
	
	
	/**************************************************************************
	 * removeArchitectByProjectId
	 * @throws ResourceNotFoundException 
	 **************************************************************************/
	/*
	 * @DeleteMapping("/remove/{id}") public ResponseEntity<?>
	 * removeArchitectById(@PathVariable (value="id") Long id) throws
	 * ResourceNotFoundException{ Optional.of(id).orElseThrow(()-> new
	 * ResourceAccessException(env.getProperty("NOT_FOUND"))); services.remove(id);;
	 * ResponseModel rs=new ResponseModel(); rs.setMessage("removed"); return
	 * ResponseEntity.ok(rs); }
	 */
	
	
	
	
}

package in.gov.projectaltsection15.controller;

import java.util.Optional;

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
import in.gov.projectalteration.services.AlterationRegistrationServices;
import in.gov.projectaltsection15.model.Setion15StageTwoModel;
import in.gov.projectaltsection15.services.StageTwoService;

@PropertySource(ignoreResourceNotFound = true, value = "classpath:application.properties")
@PropertySource(ignoreResourceNotFound = true, value = "classpath:message/common.properties")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/project_alt_ftn/secure/section15/stage-two")
public class StageTwoRestController {
	private static final Logger logger = LogManager.getLogger(StageTwoRestController.class);
	@Autowired
    private Environment env;
	@Autowired
	StageTwoService services;
	@Autowired
	AlterationRegistrationServices prs;
	
	/**************************************************************************
	 * getAll 
	 **************************************************************************/
	/*
	 * @GetMapping("/all-agent") public ResponseEntity<?> getAllAgent(){
	 * List<Setion15StageTwoModel> list =new ArrayList<Setion15StageTwoModel>();
	 * list=services.getAllSta(); if(list.size()==0) throw new
	 * ResourceAccessException(env.getProperty("NOT_FOUND")); return
	 * ResponseEntity.ok(list); }
	 */

	/**************************************************************************
	 * saveDetails
	 **************************************************************************/
	@PostMapping("/save")
	public ResponseEntity<?> save(@Valid @RequestBody Setion15StageTwoModel entity) 
			{
		logger.debug("saveAgentDetails");
		String flag="";
		Setion15StageTwoModel pm;
		ResponseModel rs=new ResponseModel();
				
		pm=services.saveStageTwoDetails(entity,env.getProperty("URL_CREATE_VDMS"));
		Optional<Setion15StageTwoModel> op=Optional.ofNullable(pm);
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
		Setion15StageTwoModel m=services.getStageOneDetailsById(id);
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
		Setion15StageTwoModel lm=services.getByPrjAltId(id);
		Optional.of(lm).orElseThrow(()->
			 new ResourceAccessException(env.getProperty("NOT_FOUND")));
		
		ResponseModel rs=new ResponseModel();
		rs.setStatus("200");
		rs.setMessage("");
		rs.setData(lm);
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

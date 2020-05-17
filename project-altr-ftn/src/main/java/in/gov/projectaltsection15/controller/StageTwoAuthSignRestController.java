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
import in.gov.projectaltsection15.model.AuthorizedSignatoryDtlModel;
import in.gov.projectaltsection15.model.ProjectSection15BankDetails;
import in.gov.projectaltsection15.model.Setion15StageOneModel;
import in.gov.projectaltsection15.services.StageTwoAuthSignService;

@PropertySource(ignoreResourceNotFound = true, value = "classpath:application.properties")
@PropertySource(ignoreResourceNotFound = true, value = "classpath:message/common.properties")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/project_alt_ftn/secure/section15/stage-two-auth-sign")
public class StageTwoAuthSignRestController {
	private static final Logger logger = LogManager.getLogger(StageTwoAuthSignRestController.class);
	@Autowired
    private Environment env;
	@Autowired
	StageTwoAuthSignService services;
	@Autowired
	AlterationRegistrationServices prs;
	
	

	/**************************************************************************
	 * saveDetails
	 **************************************************************************/
	@PostMapping("/save")
	public ResponseEntity<?> save(@Valid @RequestBody AuthorizedSignatoryDtlModel entity) 
			{
		logger.debug("save bank details called");
		String flag="";
		AuthorizedSignatoryDtlModel pm;
		ResponseModel rs=new ResponseModel();
		pm=services.saveStageTwoAuthSignDetails(entity,env.getProperty("URL_CREATE_VDMS"));
		Optional<AuthorizedSignatoryDtlModel> op=Optional.ofNullable(pm);
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
}

package in.gov.projectalteration.controller;

import java.util.Calendar;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
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
import in.gov.projectalteration.constants.ReraConstants;
import in.gov.projectalteration.model.AllotteeDetailModel;
import in.gov.projectalteration.services.AllotteeDetailServices;
import in.gov.wf.security.StrEncUtill;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/project_alt_ftn/allottee")
public class AllotteeAlterationController {
	private static final Logger logger = LogManager.getLogger(AllotteeAlterationController.class);
	@Autowired
	private Environment env;
	@Autowired
	ResourceLoader resourceLoader;

	@Autowired
	private AllotteeDetailServices services;

	@GetMapping("/all")
	public ResponseEntity<ResponseModel> getAll() {
		logger.info("end point  : /project_alt/allottee/all");
		ResponseModel rs = new ResponseModel();

		List<AllotteeDetailModel> list = services.getAll();
		if (list.isEmpty())
			throw new ResourceAccessException(env.getProperty("NOT_FOUND"));
		rs.setData(list);
		rs.setMessage("");
		rs.setStatus("200");
		return ResponseEntity.ok(rs);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseModel> getId(@PathVariable(value = "id") Long id) {
		logger.info("end point  : /project_alt/allottee/{id}");
		ResponseModel rs = new ResponseModel();
		AllotteeDetailModel m = services.getById(id);
		rs.setData(m);
		rs.setMessage("records found");
		rs.setStatus("200");
		return ResponseEntity.ok(rs);
	}

	@PostMapping("/save")
	public ResponseEntity<ResponseModel> save(@RequestBody AllotteeDetailModel model) {
		logger.info("end point  : /project_alt/allottee/save");
		ResponseModel rs = new ResponseModel();
		AllotteeDetailModel m = services.save(model);
		rs.setData(m);
		rs.setMessage("request saved successfully");
		rs.setStatus("200");
		return ResponseEntity.ok(rs);
	}

	@PutMapping("/modify")
	public ResponseEntity<ResponseModel> modify(@RequestBody AllotteeDetailModel model) {
		logger.info("end point  : /project_alt/allottee/modify");
		ResponseModel rs = new ResponseModel();
		AllotteeDetailModel m = services.update(model);
		rs.setData(m);
		rs.setMessage("request saved successfully");
		rs.setStatus("200");
		return ResponseEntity.ok(rs);
	}

	@PutMapping("/project/{id}/mobnumber/{mobileno}/feedback/{feedback}")
	public ResponseEntity<ResponseModel> feedback(@PathVariable(value = "id") String id,
			@PathVariable(value = "mobileno") String mobileno, @PathVariable(value = "feedback") String feedback) {
		
		
		ResponseModel rs = new ResponseModel();
		//AllotteeDetailModel m = services.getByPrjAltIdAndAllotteeMobile(Long.parseLong(StrEncUtill.decrypt(id)), StrEncUtill.decrypt(mobileno));
		List<AllotteeDetailModel> m = services.getByPrjAltIdAndAllotteeMobile(Long.parseLong(id), StrEncUtill.decrypt(mobileno));
		m.forEach(b->{			
			b.setAllotteeReply(feedback);
			b.setAllotteeReplyOn(Calendar.getInstance());
			AllotteeDetailModel updated = services.update(b);
			});
		rs.setMessage("records found");
		rs.setStatus("200");
		
		return ResponseEntity.ok(rs);
	}
	
	/*@PutMapping("/project/{id}/mobnumber/{mobileno}/feedback/{feedback}")
	public ResponseEntity<ResponseModel> feedback(@PathVariable(value = "id") String id,
			@PathVariable(value = "mobileno") String mobileno, @PathVariable(value = "feedback") String feedback) {
		//logger.info("end point  : /mobnumber/{mobileno}/feedback/{feedback}");StrEncUtill.decrypt(String.valueOf(id));
		ResponseModel rs = new ResponseModel();
		//AllotteeDetailModel m = services.getByprjIdAndAllotteeMobile(Long.parseLong(StrEncUtill.decrypt(id)), StrEncUtill.decrypt(mobileno));
		
		List<AllotteeDetailModel> m = services.getByPrjAltIdAndAllotteeMobile(Long.parseLong(id),mobileno);
		m.forEach(b->{			
		b.setAllotteeReply(feedback);
		b.setAllotteeReplyOn(Calendar.getInstance());
		AllotteeDetailModel updated = services.update(b);
		}); 
		
		rs.setMessage("records found");
		rs.setStatus("200");		
			
		
		return ResponseEntity.ok(rs);
	}*/
	
	@GetMapping("/bykyc-projid/{kycid}/{prjId}")
	public ResponseEntity<ResponseModel> getByKycProjectId(@PathVariable(value = "kycid") String kycid, @PathVariable(value = "prjId") Long prjId) {
		
		ResponseModel rs = new ResponseModel();
		AllotteeDetailModel m = services.getByKycProjectId(kycid,prjId);
		if(m.getAllotteeReply().contentEquals(ReraConstants.PENDING)) {
			rs.setData(m);
			rs.setMessage("Records Found");
			rs.setStatus("200");	
		}
		else {
			rs.setMessage("No Records Found");
			rs.setStatus("300");
		}
		
		return ResponseEntity.ok(rs);
	}
}

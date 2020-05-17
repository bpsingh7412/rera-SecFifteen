package in.gov.projectalteration.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.gov.projectalteration.common.model.ResponseModel;
import in.gov.projectalteration.common.services.impl.UserRestTemplateServices;
import in.gov.projectalteration.model.AllotteeDetailModel;
import in.gov.projectalteration.model.FormIds;
import in.gov.projectalteration.model.ProjectAlterationModel;
import in.gov.projectalteration.model.ProjectDetailModel;
import in.gov.projectalteration.model.ProjectResponseModel;
import in.gov.projectalteration.model.ProjectTeamStateDto;
import in.gov.projectalteration.model.transaction.AllotteeResponceModel;
import in.gov.projectalteration.model.transaction.ProjectAlterationDto;
import in.gov.projectalteration.pdf.services.impl.PdfGeneration;
import in.gov.projectalteration.projectapp.dto.ProjectAppRegistrationModel;
import in.gov.projectalteration.projectapp.services.ProjectAppServices;
import in.gov.projectalteration.services.AlterationRegistrationServices;
import in.gov.projectalteration.services.ProjectDetailsService;
import in.gov.wf.util.DateUtil;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/project_alt_ftn")
public class PublicAlterationController {
	private static final Logger logger = LogManager.getLogger(PublicAlterationController.class);
	@Autowired
	private Environment env;
	
	@Value("${URL_GET_PROJECTAPP_DTL}")
    String projectDtlUrl;
	@Value("${GET_ALLOTTEE_DTL}")
	String alloteeUrl;
	@Autowired
	ResourceLoader resourceLoader;

	/**************************************************************************
	 * getAllProjectBlock
	 **************************************************************************/
		@Autowired
	ProjectDetailsService serviceds;
	

	@Autowired
	AlterationRegistrationServices servicesalt;
	
	@Autowired
	ProjectAppServices prjAppServices;

	/*
	 * @GetMapping("/block/aleration/{id}") public ResponseEntity<?>
	 * getProjectBlockByProjectAltrId(@PathVariable(value = "id") Long id) {
	 * List<BlocksModel> list = new ArrayList<BlocksModel>(); list =
	 * services.getBlockEntryByProjectAltrId(id); if (list.size() == 0) throw new
	 * ResourceAccessException(env.getProperty("NOT_FOUND"));
	 * 
	 * 
	 * List<ProjectBlocksModel> data = new ArrayList<ProjectBlocksModel>(); for
	 * (BlocksModel b : list) { ProjectBlocksModel model = new ProjectBlocksModel();
	 * model.setBlockName(b.getBlockName()); model.setUserId(b.getUserId());
	 * model.setBlockId(b.getBlockId()); data.add(model); }
	 * 
	 * return ResponseEntity.ok(data); }
	 * 
	 * @GetMapping("project/alteration/{id}") public ResponseEntity<?>
	 * getByAlterationId(@PathVariable(value = "id") Long id) { ProjectDetailModel m
	 * = serviceds.getByAlterationId(id); List<ArcheitectDetailsModel> pro =
	 * servicess.getArchitechDetailsByprojectRegId(id); List<EngineerDetailsModel>
	 * eng = service.getEngineerDetailsByProjectAltrId(id); ProjectAlterationModel
	 * alt = servicesalt.getById(id); Optional.ofNullable(m).orElseThrow(() -> new
	 * ResourceAccessException(env.getProperty("NOT_FOUND")));
	 * List<ArcheitectDetailsModel> list = new ArrayList<ArcheitectDetailsModel>();
	 * List<EngineerDetailsModel> list1 = new ArrayList<EngineerDetailsModel>();
	 * 
	 * for (ArcheitectDetailsModel d : pro) { list.add(d); } for
	 * (EngineerDetailsModel p : eng) { list1.add(p);
	 * 
	 * } ProjectRegistrationModel data = new ProjectRegistrationModel();
	 * data.setPromoterName(alt.getPromoterName());
	 * data.setPromoterId(alt.getPromoterId());
	 * data.setPromoterType(alt.getPromoterType());
	 * data.setPromoterMobileNo(alt.getPromoterMobileNo());
	 * data.setPromoteremailId(alt.getPromoteremailId());
	 * data.setArcheitectDetailsModel(list); data.setEngineerDetailsModel(list1);
	 * data.setProjectDetailsModel(m);
	 * 
	 * return ResponseEntity.ok(data); }
	 */
	
	@GetMapping("projectdetails/alteration/{id}")
	public ResponseEntity<?> getProjectByAlterationId(@PathVariable(value = "id") Long id) {
		ProjectDetailModel m = serviceds.getByAlterationId(id);
		
		return ResponseEntity.ok(m);
		}
		
	@GetMapping("/project/formid/{id}")
	public ResponseEntity<ProjectResponseModel> getProjectFormidByAlterationId(@PathVariable(value = "id") Long id) {
		ProjectAlterationModel alt = servicesalt.getById(id);
		//ProjectResponseModel m=new ProjectResponseModel()
		FormIds ids=new FormIds();
		ids .setFormOneId(alt.getFormOneModel().getFormOneId());
		ids.setFormTwoId(alt.getFormTwoModel().getFormTwoId());
		ids.setFormThreeId(alt.getFormThreeModel().getFormThreeId());
		ids.setProAltId(alt.getProjectAltrId());
		return ResponseEntity.ok(ProjectResponseModel.ok(ids));
		
		}
	@GetMapping(path = "/allprojectapprovalstate")
	public ResponseEntity<ProjectResponseModel> allProjectApprovalState(){
		List<ProjectAlterationModel> projectList =this.servicesalt.getAllProjectList();
		List<ProjectTeamStateDto> returnList=new ArrayList<ProjectTeamStateDto>();
		
		projectList.forEach(singleproject->{
			ProjectTeamStateDto dto=new ProjectTeamStateDto(); 
			dto.setProjectCreatedOn(DateUtil.getDateStr(singleproject.getCreatedOn()));
			dto.setProjectApprovedOn(DateUtil.getDateStr(singleproject.getApprovedOn()));
			dto.setProjectFinState(singleproject.getFinState());
			dto.setProjectLgState(singleproject.getLegalState());
			dto.setProjectAckNo(singleproject.getProjectAltAckNo());
			dto.setProjectName(singleproject.getPromoterName());
			dto.setProjectStateCode(singleproject.getStateCode());
			dto.setProjectStateName(singleproject.getStateName());
			dto.setProjectStatus(singleproject.getStatus());
			dto.setProjectTeam(singleproject.getTpTeam());
			dto.setProjectTpState(singleproject.getTpState());
			dto.setWfoId(singleproject.getWfoId());
			dto.setProjectLastUpdateByName(singleproject.getLastUpdatedByName());
			dto.setFinTeam(singleproject.getFinTeam());
			dto.setLgTeam(singleproject.getLegalTeam());
			dto.setTpsrTeam(singleproject.getTpSrTeam());
			returnList.add(dto);
		}); 
		return ResponseEntity.ok(ProjectResponseModel.ok(returnList));
	}
	
	
	@GetMapping(path = "/approvalstatebyprojectid/{wfoid}")
	public ResponseEntity<ProjectResponseModel> approvalStateByProjectId(@PathVariable("wfoid") String wfoid){
		ProjectAlterationModel project =this.servicesalt.getByProjectWfoId(wfoid);
		
			ProjectTeamStateDto dto=new ProjectTeamStateDto(); 
			dto.setProjectCreatedOn(DateUtil.getDateStr(project.getCreatedOn()));
			dto.setProjectApprovedOn(DateUtil.getDateStr(project.getApprovedOn()));
			dto.setProjectFinState(project.getFinState());
			dto.setProjectLgState(project.getLegalState());
			dto.setProjectAckNo(project.getProjectAltAckNo());
			dto.setProjectName(project.getPromoterName());
			dto.setProjectStateCode(project.getStateCode());
			dto.setProjectStateName(project.getStateName());
			dto.setProjectStatus(project.getStatus());
			dto.setProjectTeam(project.getTpTeam());
			dto.setProjectTpState(project.getTpState());
			dto.setWfoId(project.getWfoId());
			dto.setProjectLastUpdateByName(project.getLastUpdatedByName());
			dto.setFinTeam(project.getFinTeam());
			dto.setLgTeam(project.getLegalTeam());
			dto.setTpsrTeam(project.getTpSrTeam());
		
		return ResponseEntity.ok(ProjectResponseModel.ok(dto));
	}
	
	/****************************************************************************************
	 * getProjectAppDetailsByprojectId
	 ****************************************************************************************/
	@PostMapping("/project-app-details/project/{id}")
	public ResponseEntity<ResponseModel> getProjectAppDetailsByprojectId(@PathVariable Long id) {

		ProjectAppRegistrationModel m = prjAppServices.getPojectAppModel(new ProjectAppRegistrationModel(), id);

		ResponseModel rs = new ResponseModel();
		if (Optional.ofNullable(m).isPresent()) {
			rs.setData(m);
			rs.setMessage(" Records found");
			rs.setStatus("200");
		} else {
			rs.setData(m);
			rs.setMessage("No Records found");
			rs.setStatus("200");
		}
		return ResponseEntity.ok(rs);
	}
	
	/****************************************************************************************
	 * getProjectAppDetailsByprojectId
	 ****************************************************************************************/
	@GetMapping("/allotee-details/project/{id}")
	public ResponseEntity<ResponseModel> getAlloteeDetails(@PathVariable Long id) {

		
		String processType = "PROJECT_REG";
		List<AllotteeDetailModel> allotteeList = new ArrayList<>();
		AllotteeResponceModel am = UserRestTemplateServices.getAlloteeDetailsRestApiCall(alloteeUrl + id + "/" + processType);
		allotteeList = am.getAllotteeList();
		System.out.println(""+am.getAllotteeList().size());
		ResponseModel rs = new ResponseModel();
		if (!allotteeList.isEmpty()) {
			rs.setData(allotteeList);
			rs.setMessage(" Records found");
			rs.setStatus("200");
		} else {
			rs.setMessage("No Records found");
			rs.setStatus("300");
		}
		return ResponseEntity.ok(rs);
	}

	/****************************************************************************************
	 * saveProjectAlterationCertificatePdf
	 ****************************************************************************************/
	@GetMapping(value = "save-project-alt-certificate-pdf/project-alt/{id}")
	public ResponseEntity<ResponseModel> saveProjectAlterationCertificatePdf(@PathVariable(value = "id") Long id,
			HttpServletResponse response) {
		logger.debug("generateProjectAlterationCertificatePdf start");
		ProjectAlterationModel p = null;
		Resource resource = resourceLoader.getResource("classpath:/images/wmlogo.jpg");
		
		byte[] reraImage = null;
		ResponseModel rs = new ResponseModel();
		
		rs.setStatus("200");
		rs.setData("");
		try {
			InputStream reraLogo = resource.getInputStream();
			p = servicesalt.getById(id);
			reraImage = new byte[reraLogo.available()];
			reraLogo.read(reraImage);
			reraLogo.close();
			PdfGeneration.saveProjectAltCertificatePdf(p, reraImage,projectDtlUrl);
			logger.debug("pdf generated");
			rs.setMessage("Pdf Generated");
		} catch (IOException e) {
			logger.debug("Error");
			logger.debug(e);
			e.printStackTrace();
			rs.setMessage("Pdf gereration error :"+e.getMessage());
			//throw new ResourceAccessException("Pdf gereration error");
		}
		
		logger.debug("generateProjectAlterationCertificatePdf End");
		return ResponseEntity.ok(rs);
	}
	
	/****************************************************************************************
	 * getProjectByAlterationFilter
	 ****************************************************************************************/
	@PostMapping("/filter-details")
	public ResponseEntity<ResponseModel> getProjectByAlterationFilter(@RequestBody ProjectAlterationDto dto) {
		List<ProjectAlterationDto> m = servicesalt.getProjectAltForFilter(dto);

		ResponseModel rs = new ResponseModel();
		if (!m.isEmpty()) {
			rs.setData(m);
			rs.setMessage(m.size() + " Records found");
			rs.setStatus("200");
		} else {
			rs.setData(m);
			rs.setMessage("No Records found");
			rs.setStatus("200");
		}
		return ResponseEntity.ok(rs);
	}
	//updateformonedtl
}

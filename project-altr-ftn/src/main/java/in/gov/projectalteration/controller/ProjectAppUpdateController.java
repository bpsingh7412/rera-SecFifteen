package in.gov.projectalteration.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.gov.projectalteration.model.BlocksModel;
import in.gov.projectalteration.model.BlocksTrxModel;
import in.gov.projectalteration.model.DocEnquiryTrxModel;
import in.gov.projectalteration.model.FormTrxModel;
import in.gov.projectalteration.model.ProjectAlterationModel;
import in.gov.projectalteration.model.ProjectResponseModel;
import in.gov.projectalteration.services.AlterationRegistrationServices;
import in.gov.projectalteration.services.impl.AlterationRegistrationServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/project_alt_ftn/project-update")
public class ProjectAppUpdateController {

	@Autowired
	private AlterationRegistrationServices service;
	@Autowired
	private AlterationRegistrationServiceImpl updateService;



	@RequestMapping(path = "/updateformonedtl", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
	public ResponseEntity<ProjectResponseModel> updateformonedtl(@RequestBody FormTrxModel formOne) {

		ProjectAlterationModel project = this.service.getByProjectAltId(formOne.getProcessId());
		project.getFormOneModel().populateData(formOne);
		this.service.updateProjectApp(project);

		return ResponseEntity.ok(ProjectResponseModel.ok(formOne));

	}

	@RequestMapping(path = "/updateformtwodtl", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
	public ResponseEntity<ProjectResponseModel> updateformtwodtl(@RequestBody FormTrxModel formTwo) {
		ProjectAlterationModel project = this.service.getByProjectAltId(formTwo.getProcessId());
		project.getFormTwoModel().populateData(formTwo);
		this.service.updateProjectApp(project);

		return ResponseEntity.ok(ProjectResponseModel.ok(formTwo));

	}

	@RequestMapping(path = "/updateformthreedtl", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
	public ResponseEntity<ProjectResponseModel> updateformthreedtl(@RequestBody FormTrxModel formThree) {
		ProjectAlterationModel project = this.service.getByProjectAltId(formThree.getProcessId());
		project.getFormThreeModel().populateData(formThree);
		this.service.updateProjectApp(project);

		return ResponseEntity.ok(ProjectResponseModel.ok(formThree));
	}

	@RequestMapping(path = "/updateblocks", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
	public ResponseEntity<ProjectResponseModel> updateblocks(@RequestBody List<BlocksTrxModel> blockList) {

		ProjectAlterationModel project = this.service.getByProjectAltId(blockList.get(0).getProcessId());
		
		blockList.forEach(b->{
			BlocksModel block=new BlocksModel();

			block.setProjectAltrId(b.getPrjAltId());
			block.setBlockName(b.getBlockName());
			block.setUserId(b.getUserId());
			block.setDevStartDate(b.getDevStartDate());
			block.setDevEndDate(b.getDevEndDate());
			block.setCreatedBy(b.getCreatedBy());
			block.setCommencementCertiNo(b.getCommencementCertiNo());
			block.setCommencementCertificateId(b.getCommencementCertificateId());
			block.setCommencementCertificateUId(b.getCommencementCertificateUId());
			block.setIssuerName(b.getIssuerName());
			block.setContactDetails(b.getContactDetails());
			block.setHeight(b.getHeight());
			project.getBlockList().add(block);
		}); 
		  this.service.updateProjectApp(project);

		return ResponseEntity.ok(ProjectResponseModel.ok(blockList));
	}

	@RequestMapping(path = "/updatedocuments", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
	public ResponseEntity<ProjectResponseModel> updatedocuments(@RequestBody List<DocEnquiryTrxModel> docList) {
		
		try {
		ProjectAlterationModel project = this.service.getByProjectAltId(docList.get(0).getProcessId());
		  for(DocEnquiryTrxModel b:docList) {
			if(null!=b.getCode() && b.getCode().equals("EN571793")) {
		        project.getStageOneList().get(0).setEncumbranceDocId(b.getDocumentId());
		        project.getStageOneList().get(0).setEncumbranceDocUId(b.getDocumentUId());
		        project.getStageTwoList().get(0).setEncumbranceDocId(b.getDocumentId());
		        project.getStageTwoList().get(0).setEncumbranceDocUId(b.getDocumentUId());
			}
			if(null!=b.getCode() && b.getCode().equals("EN323475"))
			{
				project.getStageTwoList().get(0).setFormBDocId(b.getDocumentId());
				project.getStageTwoList().get(0).setFormBDocUId(b.getDocumentUId());
			}
			if(null!=b.getCode() && b.getCode().equals("EN131187"))
			{
				project.getStageTwoList().get(0).setAllotmentDocId(b.getDocumentId());
				project.getStageTwoList().get(0).setAllotmentDocUId(b.getDocumentUId());
			}
			if(null!=b.getCode() && b.getCode().equals("EN704032"))
			{
				project.getStageTwoList().get(0).setPerForSaleAgrDocId(b.getDocumentId());
				project.getStageTwoList().get(0).setPerForSaleAgrDocUId(b.getDocumentUId());
			}
			if(null!=b.getCode() && b.getCode().equals("EN160812"))
			{
				project.getStageTwoList().get(0).setSaleDeedDocId(b.getDocumentId());
				project.getStageTwoList().get(0).setSaleDeedDocUId(b.getDocumentUId());
			}
		}
		this.service.updateProjectApp(project);
		}
		catch(Exception e)
		{
			System.out.println("Excepton in Update Document Enquiry Project Alteration secton 15 "+e);
		}
		return ResponseEntity.ok(ProjectResponseModel.ok("Success"));
	}

	@RequestMapping(path = "/runwf-byprojectregid", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
	public ResponseEntity<ProjectResponseModel> updatestateByProjectId(@RequestBody Map<String, Object> req) {
		try {
			int projectId = (Integer) req.get("processId");
			String outcome = (String) req.get("outCome");
			System.out.println("processId" + projectId + "   outcome" + outcome);
			this.updateService.runworkflow((long) projectId, outcome);
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.ok(ProjectResponseModel.ok("Error"));
		}
		return ResponseEntity.ok(ProjectResponseModel.ok("Success"));
	}

}

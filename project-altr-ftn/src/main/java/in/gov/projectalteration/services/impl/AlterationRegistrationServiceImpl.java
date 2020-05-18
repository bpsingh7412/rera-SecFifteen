package in.gov.projectalteration.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import in.gov.projectalteration.constants.ReraConstants;
import in.gov.projectalteration.dao.FormOneDetailsDao;
import in.gov.projectalteration.dao.FormThreeDetailsDao;
import in.gov.projectalteration.dao.FormThreeMofDetailsDao;
import in.gov.projectalteration.dao.FormTwoDetailsDao;
import in.gov.projectalteration.dao.ProjectAlterationDetailsDao;
import in.gov.projectalteration.exception.ResourceNotFoundException;
import in.gov.projectalteration.model.BlocksModel;
import in.gov.projectalteration.model.FormOneModel;
import in.gov.projectalteration.model.FormThreeModel;
import in.gov.projectalteration.model.FormTwoModel;
import in.gov.projectalteration.model.MofFormThreeModel;
import in.gov.projectalteration.model.ProjectAlterationModel;
import in.gov.projectalteration.model.transaction.AssigedUserTransactionModel;
import in.gov.projectalteration.model.transaction.ProjectAlterationDto;
import in.gov.projectalteration.projectapp.dto.ProjectAppRegistrationModel;
import in.gov.projectalteration.projectapp.dto.ProjectBlocksModel;
import in.gov.projectalteration.projectapp.services.ProjectAppServices;
import in.gov.projectalteration.services.AlterationRegistrationServices;
import in.gov.wf.util.WorkflowEngine;


@Service
public class AlterationRegistrationServiceImpl implements AlterationRegistrationServices {
	@Autowired
	ProjectAlterationDetailsDao dao;
	@Autowired
	FormOneDetailsDao f1dao;
	@Autowired
	FormTwoDetailsDao f2dao;
	@Autowired
	FormThreeDetailsDao f3dao;
	
	@Autowired
	FormThreeMofDetailsDao f3Mofdao;

	@Autowired
	ProjectAppServices appService;
	
	@Autowired
	private WorkflowEngine engine;
	
	
	
	boolean flag;
	
	@Override
	public ProjectAlterationModel save(ProjectAlterationModel entity) throws ResourceNotFoundException {
				
		ProjectAlterationModel m = entity;
		if (Optional.of(entity.getProjectRegId()).isPresent()) {
			List<ProjectAlterationModel> l = dao.findByProjectRegIdAndStatus(entity.getProjectRegId(),
					ReraConstants.SAVEASDRAFT);
			if (l.size() == 1) {
				m = l.get(0);
			} else {
				m = dao.save(entity);
			}
		} else {
			throw new ResourceAccessException("Not found");
		}
		return m;
	}

	@Override
	public List<ProjectAlterationModel> getAll() {
		List<ProjectAlterationModel> l = new ArrayList<ProjectAlterationModel>();
		dao.findAll().iterator().forEachRemaining(l::add);
		return l;
	}
	
	@Override
	public List<ProjectAlterationModel> getAllByStatus(String statecode) {
		List<ProjectAlterationModel> l = new ArrayList<ProjectAlterationModel>();
		dao.getProjectByStateCode(statecode).iterator().forEachRemaining(l::add);
		return l;
	}

	@Override
	public ProjectAlterationModel update(ProjectAlterationModel entity) {
		ProjectAlterationModel m = null;
		if (dao.findById(entity.getProjectAltrId()).isPresent()) {
			m = dao.save(entity);
		} else {
			throw new ResourceAccessException("Not exist");
		}

		return m;
	}

	@Override
	public ProjectAlterationModel getById(Long id) {
		return dao.findById(id).get();
	}

	@Override
	public List<ProjectAlterationModel> getByProjectId(Long id) {
		return dao.findByProjectRegId(id);
	}

	
	
	@Override
	public boolean remove(Long id) throws ResourceNotFoundException {
		return false;
	}

	@Override
	public List<AssigedUserTransactionModel> getDetailsByArchitechtId(Long id) throws ResourceNotFoundException {
		List<ProjectAlterationModel> l = new ArrayList<>();
		List<AssigedUserTransactionModel> assignProjectList = new ArrayList<AssigedUserTransactionModel>();
try {
		List<FormOneModel> f1List = f1dao.findByAssignedUserId(id);
		if (f1List.size() > 0) {
			for (FormOneModel altFormOneDetail : f1List) {
				if ((ReraConstants.ASSIGNED).equals(altFormOneDetail.getStatus())
						|| (ReraConstants.INPROGRESS).equals(altFormOneDetail.getStatus())
						|| (ReraConstants.ACCEPTED).equals(altFormOneDetail.getStatus())
						|| (ReraConstants.UPLOADED).equals(altFormOneDetail.getStatus())
						|| (ReraConstants.REJECTED).equals(altFormOneDetail.getStatus())
						)
					if(null!=altFormOneDetail.getProjectAltrId())
					l.add(dao.findById(altFormOneDetail.getProjectAltrId()).get());
			}

			for (ProjectAlterationModel alt : l) {
				try {
				AssigedUserTransactionModel assignUser = new AssigedUserTransactionModel();
				assignUser.setAssignedUserId(alt.getFormOneModel().getAssignedUserId());
				assignUser.setAssignedUserStatus(alt.getFormOneModel().getStatus());
				assignUser.setFormType("FORMONE");
				assignUser.setFormAssignedOn(alt.getFormOneModel().getFormAssignedOn());
				assignUser.setProcessId(alt.getProjectAltrId().toString());
				if(null==alt.getAlterationType())
				assignUser.setProcessType(ReraConstants.PROJECT_ALT);
				else
				assignUser.setProcessType(ReraConstants.PROJECT_ALT_15);	
				assignUser.setProjectStartDate(alt.getProjectDetailModel().getStartDate());
				assignUser.setProjectCompletionDate(alt.getProjectDetailModel().getCompletionDate());
				assignUser.setProjectName(alt.getProjectDetailModel().getProjectName());
				assignUser.setPromoterName(alt.getPromoterName());
				assignUser.setProjectId(alt.getProjectRegId());
				assignUser.setPromoterId(alt.getPromoterId());
				assignUser.setReferanceformId(alt.getFormOneModel().getReferanceformOneId());
				assignProjectList.add(assignUser);
				}
				catch(Exception e) {}
			}

		} else {
			throw new ResourceAccessException("No data Found for id:" + id);
		}
}
catch(Exception e)
{

}
		return assignProjectList;
	}

	@Override
	public List<AssigedUserTransactionModel> getDetailsByEngineerId(Long id) throws ResourceNotFoundException {
		List<AssigedUserTransactionModel> assignProjectList = new ArrayList<AssigedUserTransactionModel>();
		List<ProjectAlterationModel> l = new ArrayList<>();
		List<FormTwoModel> f2List = f2dao.findByAssignedUserId(id);
		try {
		if (f2List.size() > 0) {
			for (FormTwoModel projectFormTwoDetail : f2List) {
				if ((ReraConstants.ASSIGNED).equals(projectFormTwoDetail.getStatus())
						|| (ReraConstants.INPROGRESS).equals(projectFormTwoDetail.getStatus())
						|| (ReraConstants.ACCEPTED).equals(projectFormTwoDetail.getStatus())
						|| (ReraConstants.UPLOADED).equals(projectFormTwoDetail.getStatus())
						|| (ReraConstants.REJECTED).equals(projectFormTwoDetail.getStatus())
						)
					if(null!=projectFormTwoDetail.getProjectAltrId())
					l.add(dao.findById(projectFormTwoDetail.getProjectAltrId()).get());

			}

			for (ProjectAlterationModel projectAlt : l) {
				try {
				AssigedUserTransactionModel assignUser = new AssigedUserTransactionModel();
				assignUser.setAssignedUserId(projectAlt.getFormTwoModel().getAssignedUserId());
				assignUser.setAssignedUserStatus(projectAlt.getFormTwoModel().getStatus());
				assignUser.setFormAssignedOn(projectAlt.getFormTwoModel().getFormAssignedOn());
				assignUser.setFormType("FORMTWO");
				assignUser.setProcessId(projectAlt.getProjectAltrId().toString());
				if(null==projectAlt.getAlterationType())
					assignUser.setProcessType(ReraConstants.PROJECT_ALT);
				else
				assignUser.setProcessType(ReraConstants.PROJECT_ALT_15);
				assignUser.setProjectStartDate(projectAlt.getProjectDetailModel().getStartDate());
				assignUser.setProjectCompletionDate(projectAlt.getProjectDetailModel().getCompletionDate());
				assignUser.setProjectName(projectAlt.getProjectDetailModel().getProjectName());
				assignUser.setPromoterName(projectAlt.getPromoterName());
				assignUser.setProjectId(projectAlt.getProjectRegId());
				assignUser.setPromoterId(projectAlt.getPromoterId());
				assignUser.setReferanceformId(projectAlt.getFormTwoModel().getReferenceForm2Id());
				assignProjectList.add(assignUser);
				}
				catch(Exception e)
				{
					
				}
			}

		} else {
			throw new ResourceAccessException("No data Found for id:" + id);
		}
		}
		catch(Exception e)
		{
			
		}
		return assignProjectList;
	}

	@Override
	public List<AssigedUserTransactionModel> getDetailsByCaId(Long id) throws ResourceNotFoundException {
		List<AssigedUserTransactionModel> assignProjectList = new ArrayList<AssigedUserTransactionModel>();
		List<ProjectAlterationModel> l = new ArrayList<>();
		List<FormThreeModel> f3List = f3dao.findByAssignedUserId(id);
		try {
		if (f3List.size() > 0) {
			for (FormThreeModel projectFormThreeDetail : f3List) {
				if ((ReraConstants.ASSIGNED).equals(projectFormThreeDetail.getStatus())
						|| (ReraConstants.INPROGRESS).equals(projectFormThreeDetail.getStatus())
						|| (ReraConstants.ACCEPTED).equals(projectFormThreeDetail.getStatus())
						|| (ReraConstants.UPLOADED).equals(projectFormThreeDetail.getStatus())
						|| (ReraConstants.REJECTED).equals(projectFormThreeDetail.getStatus())
						)
					if(null!=projectFormThreeDetail.getProjectAltrId())
					l.add(dao.findById(projectFormThreeDetail.getProjectAltrId()).get());

			}
			for (ProjectAlterationModel projectAlt : l) {
				try {
				AssigedUserTransactionModel assignUser = new AssigedUserTransactionModel();
				assignUser.setAssignedUserId(projectAlt.getFormThreeModel().getAssignedUserId());
				assignUser.setAssignedUserStatus(projectAlt.getFormThreeModel().getStatus());
				assignUser.setFormAssignedOn(projectAlt.getFormThreeModel().getFormAssignedOn());
				assignUser.setFormType("FORMTHREE");
				assignUser.setProcessId(projectAlt.getProjectAltrId().toString());
				if(null==projectAlt.getAlterationType())
					assignUser.setProcessType(ReraConstants.PROJECT_ALT);
				else
				assignUser.setProcessType(ReraConstants.PROJECT_ALT_15);
				assignUser.setProjectStartDate(projectAlt.getProjectDetailModel().getStartDate());
				assignUser.setProjectCompletionDate(projectAlt.getProjectDetailModel().getCompletionDate());
				assignUser.setProjectName(projectAlt.getProjectDetailModel().getProjectName());
				assignUser.setPromoterName(projectAlt.getPromoterName());
				assignUser.setProjectId(projectAlt.getProjectRegId());
				assignUser.setPromoterId(projectAlt.getPromoterId());
				assignUser.setReferanceformId(projectAlt.getFormThreeModel().getReferenceForm3Id());
				assignProjectList.add(assignUser);
				}
				catch(Exception e)
				{}
			}
		} else {
			throw new ResourceAccessException("No data Found for id:" + id);
		}
		}
		catch(Exception e)
		{
			
		}
		return assignProjectList;
	}
	
	@Override
	public List<AssigedUserTransactionModel> getDetailsMofByCaId(Long id) throws ResourceNotFoundException {
		List<AssigedUserTransactionModel> assignProjectList = new ArrayList<AssigedUserTransactionModel>();
		List<ProjectAlterationModel> l = new ArrayList<>();
		List<MofFormThreeModel> f3List = f3Mofdao.findByAssignedUserId(id);
		if (f3List.size() > 0) {
			for (MofFormThreeModel projectFormThreeDetail : f3List) {
				if ((ReraConstants.ASSIGNED).equals(projectFormThreeDetail.getStatus())
						|| (ReraConstants.INPROGRESS).equals(projectFormThreeDetail.getStatus())
						|| (ReraConstants.ACCEPTED).equals(projectFormThreeDetail.getStatus())
						|| (ReraConstants.UPLOADED).equals(projectFormThreeDetail.getStatus())
						|| (ReraConstants.REJECTED).equals(projectFormThreeDetail.getStatus())
						)
					if(null!=projectFormThreeDetail.getProjAltId())
					l.add(dao.findById(projectFormThreeDetail.getProjAltId()).get());

			}
			for (ProjectAlterationModel projectAlt : l) {
				try {
				AssigedUserTransactionModel assignUser = new AssigedUserTransactionModel();
				assignUser.setAssignedUserId(projectAlt.getProjectFormThreeMof().getAssignedUserId());
				assignUser.setAssignedUserStatus(projectAlt.getProjectFormThreeMof().getStatus());
				assignUser.setAssignedOn(projectAlt.getProjectFormThreeMof().getFormAssignedOn());
				assignUser.setFormType("MOF");
				assignUser.setProcessId(projectAlt.getProjectAltrId().toString());
				if(null==projectAlt.getAlterationType())
					assignUser.setProcessType(ReraConstants.PROJECT_ALT);
				else
				assignUser.setProcessType(ReraConstants.PROJECT_ALT_15);
				assignUser.setProjectStartDate(projectAlt.getProjectDetailModel().getStartDate());
				assignUser.setProjectCompletionDate(projectAlt.getProjectDetailModel().getCompletionDate());
				assignUser.setProjectName(projectAlt.getProjectDetailModel().getProjectName());
				assignUser.setPromoterName(projectAlt.getPromoterName());
				assignUser.setProjectId(projectAlt.getProjectRegId());
				assignUser.setPromoterId(projectAlt.getPromoterId());
				assignUser.setReferanceformId(projectAlt.getProjectFormThreeMof().getReferenceMofForm3Id());
				assignProjectList.add(assignUser);
				}
				catch(Exception e) {}
			}
		} else {
			throw new ResourceAccessException("No data Found for id:" + id);
		}
		return assignProjectList;
	}
	
	

	@Override
	public Map<String, String> getFormAssignmentStatusDetails(Long id) throws ResourceNotFoundException {
		FormOneModel f1m = f1dao.findByProjectAltrId(id);
		FormTwoModel f2m = f2dao.findByProjectAltrId(id);
		FormThreeModel f3m = f3dao.findByProjectAltrId(id);
		MofFormThreeModel f3mofm = f3Mofdao.findByProjAltId(id);
		Map<String, String> m = new HashMap<String, String>();	

		m.put("TYPE", "AIRCHITECT");
		m.put("architectName", f1m.getArchitectName());
		m.put("architectAssignedUserId", f1m.getAssignedUserId().toString());
		m.put("architectAssigned", f1m.getStatus());
		if (Optional.ofNullable(f1m.getReferanceformOneId()).isPresent())
			m.put("referanceformOneId", f1m.getReferanceformOneId().toString());

		m.put("TYPE", "ENGINEER");
		m.put("engineerName", f2m.getFirstName() + " " + f2m.getLastName());
		m.put("engineerAssignedUserId", f2m.getAssignedUserId().toString());
		m.put("EngineerAssigned", f2m.getStatus());
		if (Optional.ofNullable(f2m.getReferenceForm2Id()).isPresent())
			m.put("referanceformTwoId", f2m.getReferenceForm2Id().toString());
		
		m.put("TYPE", "CA");
		m.put("caName", f3m.getFirstName() + " " + f3m.getLastName());
		m.put("caAssignedUserId", f3m.getAssignedUserId().toString());
		m.put("CAassigned", f3m.getStatus());
		if (Optional.ofNullable(f3m.getReferenceForm3Id()).isPresent())
			m.put("referanceformThreeId", f3m.getReferenceForm3Id().toString());
		
		/*
		 * m.put("TYPE", "MOF"); m.put("caName", f3mofm.getFirstName() + " " +
		 * f3mofm.getLastName()); m.put("caAssignedUserId",
		 * f3mofm.getAssignedUserId().toString()); m.put("CAassigned",
		 * f3mofm.getStatus()); if
		 * (Optional.ofNullable(f3mofm.getReferenceMofForm3Id()).isPresent())
		 * m.put("referanceformThreeMofId", f3mofm.getReferenceMofForm3Id().toString());
		 */
		
		m.put("TYPE_MOF", "CA");
		m.put("caNameMof", f3mofm.getFirstName() + " " + f3mofm.getLastName());
		m.put("caAssignedUserMofId", f3mofm.getAssignedUserId().toString());
		m.put("CAassignedMof", f3mofm.getStatus());
		if (Optional.ofNullable(f3mofm.getReferenceMofForm3Id()).isPresent())
		m.put("referanceformThreeMofId", f3mofm.getReferenceMofForm3Id().toString());
		
		return m;
	}

	@Override
	public ProjectAlterationModel getByProjectAltId(Long prjAltId) {
		return this.dao.findByProjectAltrId(prjAltId);
	}

	@Override
	public ProjectAlterationModel updateProjectApp(ProjectAlterationModel project) {
		return this.dao.save(project);
	}

	
	public ProjectAlterationModel runworkflow(Long projectId , String outcome){
		ProjectAlterationModel project=this.dao.findById(projectId).get();
		this.engine.runWorkflow(project.getWfoId(), outcome, null, "Compliance Submitted", "Submit");
		return project;
		
	}

	
	@Override
	public List<ProjectAlterationDto> getProjectAltForFilter(ProjectAlterationDto model) {
		List<ProjectAlterationModel> list = null;
		List<ProjectAlterationDto> dtoList = new ArrayList<ProjectAlterationDto>();

		if (!Optional.ofNullable(model.getProjectName()).isPresent() || "".contentEquals(model.getProjectName())) {
			model.setProjectName("%");
		}
		if (!Optional.ofNullable(model.getProjectType()).isPresent() || "".contentEquals(model.getProjectType())) {
			model.setProjectType("%");
		}
		if (!Optional.ofNullable(model.getPromoterType()).isPresent() || "".contentEquals(model.getPromoterType())) {
			model.setPromoterType("%");
		}
		if (!Optional.ofNullable(model.getStateName()).isPresent() || "".contentEquals(model.getStateName())) {
			model.setStateName("%");
		}

		if (!Optional.ofNullable(model.getStateCode()).isPresent() || "".contentEquals(model.getStateCode())) {
			model.setStateCode("%");
		}

		if (!Optional.ofNullable(model.getProjectAltAckNo()).isPresent()
				|| "".contentEquals(model.getProjectAltAckNo())) {
			model.setProjectAltAckNo("%");
		}
		if (!Optional.ofNullable(model.getStateCode()).isPresent() || "".contentEquals(model.getStateCode())) {
			model.setStatus("%");
		}

		System.out.println("ProjectName:" + model.getProjectName() + "\n ProjectType:" + model.getProjectType()
				+ "\n PromoterType:" + model.getPromoterType() + "\n ProjectAltAckNo:" + model.getProjectAltAckNo()
				+ "\n StateCode:" + model.getStateCode());

		list = dao.getProjectAltForFilter(model.getProjectName(), model.getProjectType(), model.getPromoterType(),
				model.getProjectAltAckNo(), model.getStateCode());

		System.out.print("size:" + list.size());

		for (ProjectAlterationModel alm : list) {
			dtoList.add(ProjectAlterationDto.populate(alm));

		}

		return dtoList;
	}

	@Override
	public List<ProjectAlterationModel> getAllProjectList() {
		return (List<ProjectAlterationModel>) dao.findAll();
		
	}

	@Override
	public ProjectAlterationModel getByProjectWfoId(String wfoId) {
		return this.dao.findByWfoId(wfoId);
	}

	@Override
	public ProjectAlterationModel saveSection15(ProjectAlterationModel entity) {
		// TODO Auto-generated method stub
		System.out.println("project id :" + entity.getProjectRegId());
		
		try
		{
			if(null==entity.getBlockList())
			{
			ProjectAppRegistrationModel oldProjectApp = appService.getPojectAppModel(new ProjectAppRegistrationModel(),entity.getProjectRegId());
			List<BlocksModel> bList = new ArrayList<>();
		    
			for(ProjectBlocksModel m:oldProjectApp.getBlockList())
		    {
				BlocksModel newModel = new BlocksModel();
				newModel.setBlockName(m.getBlockName());
				newModel.setCommencementCertificateId(m.getCommencementCertificateId());
				newModel.setCommencementCertificateUId(m.getCommencementCertificateUId());
				newModel.setCommencementCertiNo(m.getCommencementCertiNo());
                newModel.setDateIssuanceDoc(m.getDateIssuanceDoc());
                newModel.setDevEndDate(m.getDevEndDate());
                newModel.setDevStartDate(m.getDevStartDate());
                newModel.setHeight(m.getHeight());
                bList.add(newModel);
		    }
			entity.setBlockList(bList);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception::::: in Add block list in section 15 "+e);
		}
		

		
		
		return this.dao.save(entity);
	}

	@Override
	public List<ProjectAlterationModel> getByPromoterId(Long id) {
		return dao.findByPromoterId(id);
	}

	
}

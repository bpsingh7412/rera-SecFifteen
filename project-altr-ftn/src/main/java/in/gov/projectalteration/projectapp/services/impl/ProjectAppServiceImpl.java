package in.gov.projectalteration.projectapp.services.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import in.gov.projectalteration.common.services.impl.UserRestTemplateServices;
import in.gov.projectalteration.model.BlocksModel;
import in.gov.projectalteration.model.FormOneModel;
import in.gov.projectalteration.model.FormThreeModel;
import in.gov.projectalteration.model.FormTwoModel;
import in.gov.projectalteration.model.ProjectAlterationModel;
import in.gov.projectalteration.projectapp.dto.ProjectAgentDetailModel;
import in.gov.projectalteration.projectapp.dto.ProjectAppFormOneDetail;
import in.gov.projectalteration.projectapp.dto.ProjectAppFormThreeDetail;
import in.gov.projectalteration.projectapp.dto.ProjectAppFormTwoDetail;
import in.gov.projectalteration.projectapp.dto.ProjectAppPaymentDetailModel;
import in.gov.projectalteration.projectapp.dto.ProjectAppPaymentHistoryModel;
import in.gov.projectalteration.projectapp.dto.ProjectAppRegistrationModel;
import in.gov.projectalteration.projectapp.dto.ProjectBlocksModel;
import in.gov.projectalteration.projectapp.services.ProjectAppServices;

@Service
public class ProjectAppServiceImpl implements ProjectAppServices {
	@Value("${URL_GET_PROJECTAPP_DTL}")
	String prjAppDtlURL;

	@Override
	public ProjectAppRegistrationModel getPojectAppModel(ProjectAppRegistrationModel model, Long projectId) {
		return UserRestTemplateServices.getProjectAppDetails(model, prjAppDtlURL + projectId);
	}

	@Override
	public ProjectAppRegistrationModel setPojectAppModel(ProjectAlterationModel model) {
		ProjectAppRegistrationModel oldProjectApp = getPojectAppModel(new ProjectAppRegistrationModel(),
				model.getProjectRegId());
try {
		oldProjectApp.setApprovedBy(model.getApprovedBy());
		oldProjectApp.setApprovedOn(model.getApprovedOn());
		oldProjectApp.setAppSubmissionDate(model.getAppSubmissionDate());

		List<BlocksModel> blkList = model.getBlockList();
		List<ProjectBlocksModel> newList = new ArrayList<>();
		BeanUtils.copyProperties(blkList, newList);
		oldProjectApp.setBlockList(newList);

		// oldProjectApp.setCertificateId(model.getCertificateId()); //project
		// certificate
		// oldProjectApp.setCertificateUid(certificateUid);

	
		ProjectAppPaymentDetailModel pay = new ProjectAppPaymentDetailModel();
		Set<ProjectAppPaymentHistoryModel> paymentOld = oldProjectApp.getPaymentDetailsModel().getPaymentDetailsList();
		paymentOld.add(new ProjectAppPaymentHistoryModel(model.getPaymentDetailsModel()));

		
		oldProjectApp.getPaymentDetailsModel().setPaymentDetailsList(paymentOld);
	

		Set<ProjectAgentDetailModel> newAgent = new HashSet<>();

	

		FormOneModel frm1 = model.getFormOneModel();
		System.out.print(frm1.getProjectAltrId()+"caono:"+frm1.getCoaNo()+"name:"+frm1.getArchitectName()+"Ref:"+frm1.getReferanceformOneId());
		
		ProjectAppFormOneDetail pFrm1 = new ProjectAppFormOneDetail();
		BeanUtils.copyProperties(frm1, pFrm1);
		pFrm1.setProjRegId(model.getProjectRegId());
		oldProjectApp.setProjectFormOne(pFrm1);

		FormTwoModel frm2 = model.getFormTwoModel();
		ProjectAppFormTwoDetail pFrm2 = new ProjectAppFormTwoDetail();
		BeanUtils.copyProperties(frm2, pFrm2);
		pFrm2.setProjRegId(model.getProjectRegId());
		System.out.print("userid:"+pFrm2.getAssignedUserId()+",lno:"+pFrm2.getEngineerLicenseNumber()+",Ref:"+pFrm2.getReferenceForm2Id());
		oldProjectApp.setProjectFormTwo(pFrm2);

		FormThreeModel frm3 = model.getFormThreeModel();
		ProjectAppFormThreeDetail pFrm3 = new ProjectAppFormThreeDetail();
		BeanUtils.copyProperties(frm3, pFrm3);
		pFrm3.setProjRegId(model.getProjectRegId());
		System.out.print("userid:"+pFrm3.getAssignedUserId()+",no:"+pFrm3.getCaMemberShipNumber()+",Ref:"+pFrm3.getReferenceForm3Id());
		oldProjectApp.setProjectFormThree(pFrm3);

}
catch(Exception e)
{
System.out.println("Exception in setting section 15 to projectregappmodel "+e);	
}


		return oldProjectApp;
	}

}

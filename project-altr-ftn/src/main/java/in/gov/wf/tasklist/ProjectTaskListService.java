package in.gov.wf.tasklist;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.gov.projectalteration.dao.ProjectAlterationDetailsDao;
import in.gov.projectalteration.model.ProjectAlterationModel;
import in.gov.wf.security.AuthUser;


@Service
public class ProjectTaskListService {

	@Autowired
	ProjectAlterationDetailsDao projectDao;
	
	public List<ProjectSummaryModel> getProjectList(AuthUser user){
		
		List<ProjectAlterationModel> pList=null;
		if(user.getUserType().equals("TPJR")){
			pList=this.getProjectListForTPJR(user.getTeam());
		}else if(user.getUserType().equals("TPSR")){
			pList=this.getProjectListForTPSR(user.getTeam());
		}else if(user.getUserType().equals("FIN")){
			pList=this.getProjectListForFinUser(user.getTeam());
		}else if(user.getUserType().equals("LEGAL")){
			pList=this.getProjectListForLegalUser(user.getTeam());
		}else if(user.getUserType().equals("TPOFFICER")){
			pList=this.getProjectListForTpOfficer();
		}else if(user.getUserType().equals("FINCONTROLLER")){
			pList=this.getProjectListForFinController();
		}else if(user.getUserType().equals("LEGALOFFICER")){
			pList=this.getProjectListForLegalOfficer();
		}else if(user.getUserType().equals("MEMBERONE")){
			pList=this.getProjectListForMemberOne();
		}else if(user.getUserType().equals("SECRETRY")){
			pList=this.getProjectListForSecretry();
		}else if(user.getUserType().equals("CHAIRPERSON")){
			pList=this.getProjectListForCP();
		}else if(user.getUserType().equals("SECRETRYPA")){
			pList=this.getProjectListForSecretryPA();
		}else if(user.getUserType().equals("ENQOFFICER")){
			pList=this.getProjectListForEnquiry();
		} 
		
		return populat(pList);
	}
	

	private List<ProjectAlterationModel> getProjectListForTPJR(String team){
		return projectDao.getProjectForTeamBytpStateCode("LEVELONE", "NEW",team);
	}
	private List<ProjectAlterationModel> getProjectListForTPSR(String team){
		return projectDao.getProjectForTeamBytpSrStateCode("LEVELONE", "TPSR",team);
	}
	private List<ProjectAlterationModel> getProjectListForFinUser(String team){
		return projectDao.getProjectForTeamByFinStateCode("LEVELONE", "NEW",team);
	}
	private List<ProjectAlterationModel> getProjectListForLegalUser(String team){
		return projectDao.getProjectForTeamByLegalStateCode("LEVELONE", "NEW",team);
	}
	private List<ProjectAlterationModel> getProjectListForTpOfficer(){
		return projectDao.getProjectForTeamBytpStateCode("LEVELONE","OFFC");
	}
	private List<ProjectAlterationModel> getProjectListForFinController(){
		return projectDao.getProjectForTeamByFinStateCode("LEVELONE","OFFC");
	}
	private List<ProjectAlterationModel> getProjectListForLegalOfficer(){
		return projectDao.getProjectForTeamByLegalStateCode("LEVELONE","OFFC");
	}
	private List<ProjectAlterationModel> getProjectListForMemberOne(){
		return projectDao.getProjectByStateCode("MEMBERONE");
	}
	private List<ProjectAlterationModel> getProjectListForSecretry(){
		return projectDao.getProjectByStateCode("SECRETRY");
	}
	private List<ProjectAlterationModel> getProjectListForCP(){
		return projectDao.getProjectByStateCode("CHAIRPERSON");
	}
	private List<ProjectAlterationModel> getProjectListForSecretryPA(){
		return projectDao.getProjectByStateCode("SECRETRYPA");
	}
	private List<ProjectAlterationModel> getProjectListForEnquiry(){
		return projectDao.getProjectByStateCode("ENQUIRY");
	}
	private List<ProjectSummaryModel> populat(List<ProjectAlterationModel> plist){
		List<ProjectSummaryModel> projectList=new ArrayList<ProjectSummaryModel>();
		if(plist!=null){
			for(ProjectAlterationModel project:plist){
				projectList.add(new ProjectSummaryModel(project));	
			}
		}
		return projectList;
	}


	public List<ProjectSummaryModel> getPendingWithAuthList() {
		return populat(projectDao.getPendingWithProjectList());
	}


	public List<ProjectSummaryModel> pendingProjectListByDepName(String depName, int noOfDays) {
		return populat(projectDao.pendingProjectListByDepName("LEVELONE",noOfDays));
	}
	
	

}

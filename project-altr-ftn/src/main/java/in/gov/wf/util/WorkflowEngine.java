package in.gov.wf.util;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.gov.projectalteration.common.services.impl.UserRestTemplateServices;
import in.gov.projectalteration.constants.ReraConstants;
import in.gov.projectalteration.dao.ProjectAlterationDetailsDao;
import in.gov.projectalteration.model.ProjectAlterationModel;
import in.gov.projectalteration.notification.MailContents;
import in.gov.projectalteration.notification.NotificationUtil;
import in.gov.projectalteration.notification.SmsContents;
import in.gov.projectalteration.projectapp.dto.ProjectAppRegistrationModel;
import in.gov.projectalteration.projectapp.services.ProjectAppServices;
import in.gov.projectaltsection15.model.Setion15StageOneModel;
import in.gov.projectaltsection15.services.StageOneService;
import in.gov.wf.constant.ProcessConstant;
import in.gov.wf.dao.ActivityLogDao;
import in.gov.wf.model.ActivityLog;
import in.gov.wf.model.FormRequest;
import in.gov.wf.model.WFEntity;
import in.gov.wf.security.AuthUser;

@Service
public class WorkflowEngine {

	private HttpServletRequest request;
	private String outcome;
	private AuthUser user;
	private String childState;
	private WFEntity entity;
	private String tpState;
	private String finState;
	private String lgState;
	private String nextChildState;
	private MapUtility nextState;

	private String remarks;
	private String reason;

	@Value(value="${fin.team.number}")
	private String finTeamCount;
	@Value(value="${legal.team.number}")
	private String lgTeamCount;
	@Value(value="${tp.team.number}")
	private String tpTeamCount;
	@Value(value="${tpsr.team.number}")
	private String tpSrTeamCount;

	@Autowired
	ActivityLogDao logDao;

	@Autowired
	NotificationUtil notifcationServices;

	@Value("${URL_MODIFY_PROJECTAPP_DTL}")
	String prjAppUpdateDtlURL;
	
	@Value("${UPDATE_PRJ_APP_BANKDTL}")
	String bankDtlUpdateURL;
	
	@Value("${UPDATE_PRJ_APP_PROMOTERDTL}")
	String promoterDtlUpdateURL;
	
	@Autowired
	ProjectAppServices prjAppServices;
	
	@Autowired
	StageOneService sService;
	
	@Transactional
	public void createNewTransaction(WFEntity entity,String outcome,HttpServletRequest request){
		ProcessConfiguration conf=ProcessConfiguration.getConfObj();
		this.request=request;
		this.outcome=outcome;
		if(request!=null)
		this.user=	AuthUser.getLoggedInUser(request);
		else{
			this.user= AuthUser.getSystemUser();
		}
     	entity.setProcessName(conf.getProcessConf().getStringValue(ProcessConstant.PR_NAME));
		entity.setWfoId(generateWfoId(conf.getProcessConf().getStringValue(ProcessConstant.PR_NAME)));
		entity.setStateCode("NEW");
		entity.setStateName("New");
		entity.setFinState(ProcessConstant.PR_DEFUALT_VALUE);
		entity.setTpState(ProcessConstant.PR_DEFUALT_VALUE);
		entity.setLegalState(ProcessConstant.PR_DEFUALT_VALUE);
		entity.setCreatedOn(Calendar.getInstance());
		entity.setTpTeam( getTeamNameForAssign());
		entity.setTpSrTeam( getSrTeamNameForAssign());
		entity.setFinTeam( getFinTeamNameForAssign());
		entity.setLegalTeam( getLgTeamNameForAssign());
		updateWfEntity(entity);
		runWorkflow(entity.getWfoId(), "SUBMIT", request, "Application Submit", "Application Submit");
	}

	public void runWorkflow(String wfoid,String outcome,HttpServletRequest request,String remarks,String reason){
		this.request=request;
		this.outcome=outcome;
		this.remarks=remarks;
		this.reason=reason;
		if(request!=null)
			this.user=	AuthUser.getLoggedInUser(request);
			else{
				this.user= AuthUser.getSystemUser();
			}
		System.out.println(wfoid+"  --  "+outcome+" -- ");
		 entity=getWfEntityById(wfoid);
		String stateCode=entity.getStateCode();
		System.out.println("stateCode   "+stateCode);
		ProcessConfiguration conf=ProcessConfiguration.getConfObj();
		MapUtility state= conf.getProcesStates().getMap(stateCode);
		if(state.getStringValue(ProcessConstant.PR_STATE_TYPE).equals(ProcessConstant.PR_STATE_TYPE_M) && 
				!this.user.getDepartment().equals(ProcessConstant.PR_DEFUALT_VALUE)){
			getChState();
			runChWorkflow(state);
			updateEntity();
		}else{
			
			runWorkflow();
			updateEntity();
		}
	}

	@Transactional
	public void runWorkflow(FormRequest submit,HttpServletRequest request){
		this.request=request;
		this.outcome=submit.getOutcome();
		this.remarks=submit.getRemarks();
		this.reason=submit.getReason();
		if(request!=null)
			this.user=	AuthUser.getLoggedInUser(request);
			else{
				this.user= AuthUser.getSystemUser();
			}
		 entity=getWfEntityById(submit.getWfoId());
		String stateCode=entity.getStateCode();
		ProcessConfiguration conf=ProcessConfiguration.getConfObj();
		MapUtility state= conf.getProcesStates().getMap(stateCode);
		if(state.getStringValue(ProcessConstant.PR_STATE_TYPE).equals(ProcessConstant.PR_STATE_TYPE_M) && 
				!this.user.getDepartment().equals(ProcessConstant.PR_DEFUALT_VALUE)){
			getChState();
			runChWorkflow(state);
			updateEntity();
		}else{
			
			runWorkflow();
			updateEntity();
		}
	}

	private void runChWorkflow(MapUtility state){
		MapUtility fsm=	state.getMap(ProcessConstant.PR_ST_FSM_LIB);
		String dpt=this.user.getDepartment();
		String role=this.user.getUserType();
		
		/*MapRenderUtility ren=new MapRenderUtility(fsm);
		while(ren.isNext()){
			System.out.println(">>>>   "+ren.nextKey());
		}
		*/
		
		if(fsm.containsKey(role+"~"+dpt+"~"+this.childState+"~"+outcome)){
			System.out.println("3334333");
			this.nextChildState=fsm.getMap(role+"~"+dpt+"~"+this.childState+"~"+outcome).getMap(ProcessConstant.PR_ST_FSM_N_CHSTATE)
					.getStringValue(ProcessConstant.PR_CH_STATE_CODE);
			
		}else{
			this.nextChildState=this.childState;
		}
		
		setChState(this.nextChildState);
		
		String outs=chkoutcome(state);
		
		getNextState(outs);
		if(!outs.equals("000")){
		
		if(this.nextState.getStringValue(ProcessConstant.PR_STATE_TYPE).equals(ProcessConstant.PR_STATE_TYPE_M)){
			MapUtility chm= this.nextState.getMap(ProcessConstant.PR_CH_DFSTATE);
			if(chm!=null){
				String dfch=chm.getStringValue(ProcessConstant.PR_CH_STATE_CODE);
				entity.setTpState(dfch);entity.setLegalState(dfch);entity.setFinState(dfch);
			}else{
				entity.setTpState(ProcessConstant.PR_DEFUALT_VALUE);
				entity.setLegalState(ProcessConstant.PR_DEFUALT_VALUE);
				entity.setFinState(ProcessConstant.PR_DEFUALT_VALUE);
			}
		}else{
			entity.setTpState(ProcessConstant.PR_DEFUALT_VALUE);
			entity.setLegalState(ProcessConstant.PR_DEFUALT_VALUE);
			entity.setFinState(ProcessConstant.PR_DEFUALT_VALUE);
		}}
		createActivityLog();
		
		
		}

	private String chkoutcome(MapUtility state){
		String out="000";
		MapRenderUtility ocs=new MapRenderUtility(state.getMap(ProcessConstant.PR_ST_CALS_OCS));
		MapRenderUtility ends=new MapRenderUtility(state.getMap(ProcessConstant.PR_ST_ENDSTATES));
		int num=0;
		while(ends.isNext()){
			num+=	ends.getValue(ProcessConstant.PR_CH_STATE_CODE).equals(this.finState)?1:0;
			num+=	ends.getValue(ProcessConstant.PR_CH_STATE_CODE).equals(this.tpState)?1:0;
			num+=	ends.getValue(ProcessConstant.PR_CH_STATE_CODE).equals(this.lgState)?1:0;
		}
		if(num>=3){
			while(ocs.isNext()){
			MapUtility mp=	ocs.next();
			MapUtility ch=mp.getMap(ProcessConstant.PR_ST_FSM_CHSTATE);
		if(	mp.getStringValue(ProcessConstant.PR_ST_FSM_CAL_TYPE).equals("PR")){
			if(ch.getStringValue(ProcessConstant.PR_CH_STATE_CODE).equals(this.tpState) ||
					ch.getStringValue(ProcessConstant.PR_CH_STATE_CODE).equals(this.finState)||
					ch.getStringValue(ProcessConstant.PR_CH_STATE_CODE).equals(this.lgState)){
				MapUtility ot= (MapUtility)mp.getValue(ProcessConstant.PR_ST_FSM_OC);
				out=	ot.getStringValue(ProcessConstant.PR_OC_CODE);
				break;
			}
		}else{
			if(ch.getStringValue(ProcessConstant.PR_CH_STATE_CODE).equals(this.tpState) &&
					ch.getStringValue(ProcessConstant.PR_CH_STATE_CODE).equals(this.finState)&&
					ch.getStringValue(ProcessConstant.PR_CH_STATE_CODE).equals(this.lgState)){
				MapUtility ot= (MapUtility)mp.getValue(ProcessConstant.PR_ST_FSM_OC);
				out=	ot.getStringValue(ProcessConstant.PR_OC_CODE);
				break;
			}
		}
			}
		}
		return out;
	}

	private void runWorkflow(){
		
		getNextState(this.outcome);
		if(this.nextState.getStringValue(ProcessConstant.PR_STATE_TYPE).equals(ProcessConstant.PR_STATE_TYPE_M)){
			MapUtility chm= this.nextState.getMap(ProcessConstant.PR_CH_DFSTATE);
			if(chm!=null){
				String dfch=chm.getStringValue(ProcessConstant.PR_CH_STATE_CODE);
				entity.setTpState(dfch);entity.setLegalState(dfch);entity.setFinState(dfch);
			}else{
				entity.setTpState(ProcessConstant.PR_DEFUALT_VALUE);entity.setLegalState(ProcessConstant.PR_DEFUALT_VALUE);entity.setFinState(ProcessConstant.PR_DEFUALT_VALUE);
			}
		}else{
			entity.setTpState(ProcessConstant.PR_DEFUALT_VALUE);entity.setLegalState(ProcessConstant.PR_DEFUALT_VALUE);entity.setFinState(ProcessConstant.PR_DEFUALT_VALUE);
		}
		createActivityLog();
		}

	private void getNextState(String outcome){
		ProcessConfiguration conf=ProcessConfiguration.getConfObj();
		MapUtility fsm=conf.getProcesFsmLib();
		if(fsm.containsKey(entity.getStateCode()+"~"+outcome)){
			MapUtility stf=fsm.getMap(entity.getStateCode()+"~"+outcome);
			this.nextState=stf.getMap(ProcessConstant.PR_FSM_NSTATE);
		
		}else{
			this.nextState=conf.getProcesStates().getMap(entity.getStateCode());
		}
		System.out.println(this.nextState+"   this.nextState");
	}

	private void createActivityLog(){
		ActivityLog log=new ActivityLog();
		log.setWfoId(entity.getWfoId());
		log.setActivityOn(Calendar.getInstance());
		log.setDeptName(user.getDepartment());
		log.setChStateCode(this.childState);
		log.setNextChStateCode(this.nextChildState);
		log.setOutcome(this.outcome);
		log.setStateCode(entity.getStateCode());
		log.setStateName(entity.getStateName());
		log.setNextStateCode(this.nextState.getStringValue(ProcessConstant.PR_STATE_CODE));
		log.setNextStateName(this.nextState.getStringValue(ProcessConstant.PR_STATE_NAME));
		log.setActivityBy(this.user.getProfileId());
		log.setActivityByName(this.user.getUserName());
		log.setReason(this.reason);
		log.setRemarks(this.remarks);
		log.setTeam(this.user.getTeam());
		System.out.println(logDao);
		logDao.save(log);
	}

private void updateEntity(){
		
		
		entity.setStateCode(this.nextState.getStringValue(ProcessConstant.PR_STATE_CODE));
		entity.setStateName(this.nextState.getStringValue(ProcessConstant.PR_STATE_NAME));
		entity.setLastUpdatedOn(Calendar.getInstance());
		entity.setLastUpdatedBy(this.user.getProfileId());
		entity.setLastUpdatedByName(this.user.getUserName());
		updateWfEntity(entity);
		System.out.println("Check Approval Condition >> "+this.nextState.getStringValue(ProcessConstant.PR_STATE_CODE) );
		if(this.outcome.equals("APPROVED") && this.nextState.getStringValue(ProcessConstant.PR_STATE_CODE).equals("APPROVED") ){
			System.out.println("In Approval Condition >> "+this.nextState.getStringValue(ProcessConstant.PR_STATE_CODE) );
			System.out.println(entity);
			
		}
	}

private String generateWfoId(String processName){
	StringBuilder sb=new StringBuilder();
	Calendar cal=Calendar.getInstance();
	sb.append(processName).append(cal.get(Calendar.YEAR)).append(cal.get(Calendar.MONTH)).append(cal.get(Calendar.DATE)).append(cal.get(Calendar.HOUR))
	.append(cal.get(Calendar.MINUTE)).append(cal.get(Calendar.SECOND)).append(cal.get(Calendar.MILLISECOND));
	return sb.toString();
}


private void setChState(){
	if(! this.user.getDepartment().equals(ProcessConstant.PR_DEFUALT_VALUE)){
		if(this.user.getDepartment().equals("TP")){
			this.entity.setTpState(this.nextChildState);
		}else if(this.user.getDepartment().equals("FIN")){
		this.entity.setFinState(this.nextChildState);
		}else if(this.user.getDepartment().equals("LEGAL")){
			this.entity.setLegalState(this.nextChildState);
		}else{
			this.childState=ProcessConstant.PR_DEFUALT_VALUE;
		}
	}else{
		this.childState=ProcessConstant.PR_DEFUALT_VALUE;
	}
}

private void getChState(){
	if(! this.user.getDepartment().equals(ProcessConstant.PR_DEFUALT_VALUE)){
		if(this.user.getDepartment().equals("TP")){
			this.childState=this.entity.getTpState();
		}else if(this.user.getDepartment().equals("FIN")){
			this.childState=this.entity.getFinState();
		}else if(this.user.getDepartment().equals("LEGAL")){
			this.childState=this.entity.getLegalState();
		}else{
			this.childState=ProcessConstant.PR_DEFUALT_VALUE;
		}
	}else{
		this.childState=ProcessConstant.PR_DEFUALT_VALUE;
	}
	System.out.println("this.childState >> "+ this.childState);
	
	this.finState=this.entity.getFinState();
	this.tpState=this.entity.getTpState();
	this.lgState=this.entity.getLegalState();
}

private void setChState(String cst){
	
	if(this.user.getDepartment().equals("TP")){
		this.tpState=cst;
	}else if(this.user.getDepartment().equals("FIN")){
		this.finState=cst;
	}else if(this.user.getDepartment().equals("LEGAL")){
		this.lgState=cst;
	}
	setChState();

}
	
public void updateWfEntity(WFEntity entity) {
ProjectAlterationModel project = (ProjectAlterationModel) entity;
System.out.println("project tpstate >> " + project.getTpState());
if (this.outcome.equals("APPROVED")
&& this.nextState.getStringValue(ProcessConstant.PR_STATE_CODE).equals("APPROVED")) {
  if(null==project.getAltrStatus() && ReraConstants.SECTION_15.equals(project.getAlterationType()))	
   {
  	 project.setAltrStatus(ReraConstants.STAGE2);
  	 project.setStageOneStatus(ReraConstants.COMPLETED);
  	 project.setApprovedOn(Calendar.getInstance());
  	 dao.save(project);
   }

}

if (this.outcome.equals("APPROVED")
&& this.nextState.getStringValue(ProcessConstant.PR_STATE_CODE).equals("APPROVED")) {
try {
if(ReraConstants.COMPLETED.equalsIgnoreCase(project.getStageOneStatus()))
{
	System.out.println("Stage 2 Inside Completed::::::::::::::");
	project = dao.findByProjectAltrId(project.getProjectAltrId());
	project.setStageTwoStatus(ReraConstants.COMPLETED);
	project=dao.save(project);
	Setion15StageOneModel sModel=sService.getByPrjAltId(project.getId());
	System.out.println("before setting section 15 model to ProjectAppRegistrationModel");
	ProjectAppRegistrationModel pAppModel =prjAppServices.setPojectAppModel(project);
pAppModel.setPromoterId(sModel.getPromoterId());
pAppModel.setPromoteremailId(sModel.getPromoteremailId());
pAppModel.setPromoterName(sModel.getPromoterName());
pAppModel.setPromoterType(sModel.getPromoterType());
System.out.println("Project App update url is "+prjAppUpdateDtlURL);
//UserRestTemplateServices.updateProjectAppDetailsRestApiCall(pAppModel,prjAppUpdateDtlURL);


Map<String,Object> bankDtl= new HashMap<String, Object>();
bankDtl.put("id",project.getProjectRegId());
bankDtl.put("bankCode",project.getStageTwoList().get(0).getNewPrmoBankDtl().get(0).getBankCode());
bankDtl.put("bankName",project.getStageTwoList().get(0).getNewPrmoBankDtl().get(0).getBankName());
bankDtl.put("branchName",project.getStageTwoList().get(0).getNewPrmoBankDtl().get(0).getBranchName());
bankDtl.put("districtCode",project.getStageTwoList().get(0).getNewPrmoBankDtl().get(0).getBnkDistrictCode());
bankDtl.put("districtName",project.getStageTwoList().get(0).getNewPrmoBankDtl().get(0).getBnkDistrictName());
bankDtl.put("stateCode",project.getStageTwoList().get(0).getNewPrmoBankDtl().get(0).getBnkStateCode());
bankDtl.put("stateName",project.getStageTwoList().get(0).getNewPrmoBankDtl().get(0).getBnkStateName());
bankDtl.put("talukaName",project.getStageTwoList().get(0).getNewPrmoBankDtl().get(0).getBnkTalukaName());
bankDtl.put("pincode",project.getStageTwoList().get(0).getNewPrmoBankDtl().get(0).getBnkPincode());
bankDtl.put("ifscCode",project.getStageTwoList().get(0).getNewPrmoBankDtl().get(0).getIfscCode());
bankDtl.put("accountNumber",project.getStageTwoList().get(0).getNewPrmoBankDtl().get(0).getAccountNumber());
bankDtl.put("accountName",project.getStageTwoList().get(0).getNewPrmoBankDtl().get(0).getAccountName());
bankDtl.put("closingBal",project.getStageTwoList().get(0).getNewPrmoBankDtl().get(0).getClosingBal());
bankDtl.put("status",ReraConstants.APPROVED);
UserRestTemplateServices.updateBankDtl(bankDtl,bankDtlUpdateURL);


Map<String,Object> prmDtl= new HashMap<String, Object>();
prmDtl.put("promoterId", project.getStageOneList().get(0).getPromoterId());
prmDtl.put("promoteremailId", project.getStageOneList().get(0).getPromoteremailId());
prmDtl.put("promoterMobileNo", project.getStageOneList().get(0).getPromoterMobileNo());
prmDtl.put("promoterName", project.getStageOneList().get(0).getPromoterName());
prmDtl.put("promoterType", project.getStageOneList().get(0).getPromoterType());
prmDtl.put("projectRegId", project.getProjectRegId());
//projectRegId

UserRestTemplateServices.updatePromoterDtl(prmDtl,promoterDtlUpdateURL);


notifcationServices.sendEmail(MailContents.projectAlterationMailWorkFlow(project));
notifcationServices.sendSms(SmsContents.smsNotificationWfApproved(project));
}
}
catch (Exception e) {
System.out.println("......Exception in Alteration Stage 2 Approval .......>" + e);
}
}
}


	public WFEntity getWfEntityById(String wfoid) {
		return this.dao.findByWfoId(wfoid);
	}

	public String getSrTeamNameForAssign() {
		String team="TEAM1";
		List<Object> lst=this.dao.findTpSrTeamToAssign();
		if(lst!=null && !lst.isEmpty() && lst.get(0)!=null){
		String str=(String)lst.get(0);	
		System.out.println("Found from db "+str);
		char c=str.charAt(4);
		System.out.println("c value "+c);
		int xxx=Integer.parseInt(c+"");
		int teamCount=3;
	if(this.tpSrTeamCount!=null){
		try{teamCount=Integer.parseInt(this.tpSrTeamCount);}catch(Exception ex){ex.printStackTrace();}
	}	
	xxx=	xxx+1;
	if(xxx>teamCount){
		xxx=xxx-teamCount;
	}
	team="TEAM"+xxx;
		}
		return team;
	}

	public String getTeamNameForAssign() {
		String team="TEAM1";
		List<Object> lst=this.dao.findTeamToAssign();
		if(lst!=null && !lst.isEmpty() && lst.get(0)!=null){
		String str=(String)lst.get(0);	
		System.out.println("Found from db "+str);
		char c=str.charAt(4);
		System.out.println("c value "+c);
		int xxx=Integer.parseInt(c+"");
		int teamCount=3;
	if(this.tpTeamCount!=null){
		try{teamCount=Integer.parseInt(this.tpTeamCount);}catch(Exception ex){ex.printStackTrace();}
	}	
	xxx=	xxx+1;
	if(xxx>teamCount){
		xxx=xxx-teamCount;
	}
	team="TEAM"+xxx;
		}
		return team;
	}
	
	public String getFinTeamNameForAssign() {
		String team="TEAM1";
		List<Object> lst=this.dao.findFinTeamToAssign();
		if(lst!=null && !lst.isEmpty() && lst.get(0)!=null){
		String str=(String)lst.get(0);	
		System.out.println("Found from db "+str);
		char c=str.charAt(4);
		System.out.println("c value "+c);
		int xxx=Integer.parseInt(c+"");
		int teamCount=3;
	if(this.finTeamCount!=null){
		try{teamCount=Integer.parseInt(this.finTeamCount);}catch(Exception ex){ex.printStackTrace();}
	}	
	xxx=	xxx+1;
	if(xxx>teamCount){
		xxx=xxx-teamCount;
	}
	team="TEAM"+xxx;
		}
		return team;
	}
	public String getLgTeamNameForAssign() {
		String team="TEAM1";
		List<Object> lst=this.dao.findLegalTeamToAssign();
		if(lst!=null && !lst.isEmpty() && lst.get(0)!=null){
		String str=(String)lst.get(0);	
		System.out.println("Found from db "+str);
		char c=str.charAt(4);
		System.out.println("c value "+c);
		int xxx=Integer.parseInt(c+"");
		int teamCount=3;
	if(this.lgTeamCount!=null){
		try{teamCount=Integer.parseInt(this.lgTeamCount);}catch(Exception ex){ex.printStackTrace();}
	}	
	xxx=	xxx+1;
	if(xxx>teamCount){
		xxx=xxx-teamCount;
	}
	team="TEAM"+xxx;
		}
		return team;
	}

	@Autowired
	ProjectAlterationDetailsDao dao;
}

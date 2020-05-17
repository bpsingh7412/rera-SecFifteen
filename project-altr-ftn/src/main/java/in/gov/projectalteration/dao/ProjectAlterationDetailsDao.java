package in.gov.projectalteration.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.gov.projectalteration.model.ProjectAlterationModel;

@Repository
public interface ProjectAlterationDetailsDao extends CrudRepository<ProjectAlterationModel, Long> {

	public List<ProjectAlterationModel> findByProjectName(String name);
	public List<ProjectAlterationModel> findByPromoterId(Long id);
	public List<ProjectAlterationModel> findByProjectRegId(Long projectRegId);
	public List<ProjectAlterationModel> findByProjectRegIdAndStatus(Long projectRegId,String status);
	public ProjectAlterationModel findByWfoId(String wfoId);
	public ProjectAlterationModel findByProjectAltrId(Long prjAltId);
	
	@Query(value="SELECT XX.PTEAM FROM  (SELECT MAX(P.CREATED_ON) CT,P.PR_TEAM PTEAM FROM tt_project_alteration P "
			+ "GROUP BY P.PR_TEAM)XX WHERE XX.PTEAM IS NOT NULL ORDER BY XX.CT DESC", nativeQuery=true)
	List<Object> findTeamToAssign();
	
	@Query(value = "SELECT XX.PTEAM FROM  (SELECT MAX(P.CREATED_ON) CT,P.TPSR_TEAM PTEAM FROM tt_project_alteration P "
			+ "GROUP BY P.TPSR_TEAM)XX WHERE XX.PTEAM IS NOT NULL ORDER BY XX.CT DESC", nativeQuery = true)
	List<Object> findTpSrTeamToAssign();

	@Query(value = "SELECT XX.PTEAM FROM  (SELECT MAX(P.CREATED_ON) CT,P.FIN_TEAM PTEAM FROM tt_project_alteration P "
			+ "GROUP BY P.FIN_TEAM)XX WHERE XX.PTEAM IS NOT NULL ORDER BY XX.CT DESC", nativeQuery = true)
	List<Object> findFinTeamToAssign();

	@Query(value = "SELECT XX.PTEAM FROM  (SELECT MAX(P.CREATED_ON) CT,P.LG_TEAM PTEAM FROM tt_project_alteration P "
			+ "GROUP BY P.LG_TEAM)XX WHERE XX.PTEAM IS NOT NULL ORDER BY XX.CT DESC", nativeQuery = true)
	List<Object> findLegalTeamToAssign();
	
	@Query(value=" Select p from ProjectAlterationModel p where p.stateCode=?1")
	List<ProjectAlterationModel> getProjectByStateCode(String stateCode);
	
	@Query(value=" Select p from ProjectAlterationModel p where p.stateCode=?1 and p.finState=?2 and p.finTeam=?3")
	List<ProjectAlterationModel> getProjectForTeamByFinStateCode(String stateCode,String finState,String team);
	
	@Query(value=" Select p from ProjectAlterationModel p where p.stateCode=?1 and p.tpState=?2 and p.tpTeam=?3")
	List<ProjectAlterationModel> getProjectForTeamBytpStateCode(String stateCode,String tpState,String team);
	
	@Query(value=" Select p from ProjectAlterationModel p where p.stateCode=?1 and p.legalState=?2 and p.legalTeam=?3")
	List<ProjectAlterationModel> getProjectForTeamByLegalStateCode(String stateCode,String legalState,String team);

	
	@Query(value=" Select p from ProjectAlterationModel p where p.stateCode=?1 and p.finState=?2 ")
	List<ProjectAlterationModel> getProjectForTeamByFinStateCode(String stateCode,String finState);
	
	@Query(value = " Select p from ProjectAlterationModel p where p.stateCode=?1 and p.tpState=?2 and p.tpSrTeam=?3")
	List<ProjectAlterationModel> getProjectForTeamBytpSrStateCode(String stateCode, String tpState, String team);
	
	@Query(value=" Select p from ProjectAlterationModel p where p.stateCode=?1 and p.tpState=?2 ")
	List<ProjectAlterationModel> getProjectForTeamBytpStateCode(String stateCode,String tpState);
	
	//@Query(value=" Select p from ProjectAlterationModel p where p.projectName LIKE %?1% and p.projectType LIKE %?2% and p.promoterType LIKE %?3% and p.projectAltAckNo LIKE %?4% and p.stateCode LIKE %?5%")
	@Query(value=" Select p from ProjectAlterationModel p")
	List<ProjectAlterationModel> getProjectAltForFilter(String projectName,String projectType,String promoterType,String projectAltAckNo,String stateCode);
	
	@Query(value=" Select p from ProjectAlterationModel p where p.stateCode=?1 and p.legalState=?2")
	List<ProjectAlterationModel> getProjectForTeamByLegalStateCode(String stateCode,String legalState);
	
	@Query(value=" Select p from ProjectAlterationModel p where p.stateCode not in ('APPROVED','REJECTED','SAVE_AS_DRAFT') and datediff(CURDATE(),p.createdOn)>30")
	
	
	List<ProjectAlterationModel> getPendingWithProjectList();
	
	@Query(value="Select p from ProjectAlterationModel p where p.stateCode = ?1 and datediff(CURDATE(),p.createdOn)>?2  ")
	public List<ProjectAlterationModel> pendingProjectListByDepName(String stateCode, int noOfDays);
	
}

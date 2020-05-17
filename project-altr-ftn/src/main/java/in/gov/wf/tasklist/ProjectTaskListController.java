package in.gov.wf.tasklist;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.gov.projectalteration.projectapp.dto.CountResponseDto;
import in.gov.wf.model.TaskListResponse;
import in.gov.wf.security.AuthUser;
import in.gov.wf.util.DateUtil;

@CrossOrigin("*")
@RestController
@RequestMapping(path= "/project_alt_ftn/secure/")
public class ProjectTaskListController {

	@Autowired
	ProjectTaskListService service;
	
	@RequestMapping(path= "projectalt-tasklist", method=RequestMethod.GET,produces="application/json")
	public ResponseEntity<TaskListResponse> getProjectForTaskList(HttpServletRequest req) {
		AuthUser user=AuthUser.getLoggedInUser(req);
		System.out.println(user);
		System.out.println(user.getDepartment()+"  "+user.getTeam()+"  "+user.getUserType());
		try{
		List<ProjectSummaryModel> plist=this.service.getProjectList(user);
		return ResponseEntity.ok(TaskListResponse.ok(plist));
		}catch (Exception ex){
			ex.printStackTrace();
			return ResponseEntity.ok(TaskListResponse.error(ex.getMessage()));
		}
	}
	
	@RequestMapping(path= "projectalt-tasklist-count", method=RequestMethod.GET,produces="application/json")
	public ResponseEntity<CountResponseDto> getProjectForTaskListCount(HttpServletRequest req) {
		AuthUser user=AuthUser.getLoggedInUser(req);
		System.out.println(user);
		System.out.println(user.getDepartment()+"  "+user.getTeam()+"  "+user.getUserType());
		CountResponseDto dto = new CountResponseDto();
		dto.setType("PROJECT_ALT_15");
		try{
		List<ProjectSummaryModel> plist=this.service.getProjectList(user);
		Calendar c = Calendar.getInstance();
		if(!plist.isEmpty()) {
			dto.setTotal(plist.size());
		for(ProjectSummaryModel p :plist)
		{
			long days = DateUtil.daysBetween(c, p.getLastModifiedOn());
			if(days<15)
			{
			  dto.setLessThan15(dto.getLessThan15()+1);
			}
			else if(days>15 && days<30)
			{
				dto.setBetween15to30(dto.getBetween15to30()+1);
			}
			else if(days>30)
			{
				dto.setGreaterThan30(dto.getGreaterThan30()+1);
			}
		}
		}
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping(path= "project-alt-tasklist-by-days/{noOfDays}")
	public ResponseEntity<TaskListResponse> getProjectForTaskListByDays(@PathVariable long noOfDays,HttpServletRequest req) {
		AuthUser user=AuthUser.getLoggedInUser(req);
		System.out.println(user);
		System.out.println(user.getDepartment()+"  "+user.getTeam()+"  "+user.getUserType());
		CountResponseDto dto = new CountResponseDto();
		List<ProjectSummaryModel> dList = new ArrayList<>();
		try{
		List<ProjectSummaryModel> plist=this.service.getProjectList(user);
		
		Calendar c = Calendar.getInstance();
		if(!plist.isEmpty()) {
			dto.setTotal(plist.size());
		for(ProjectSummaryModel p :plist)
		{
			long days = DateUtil.daysBetween(c, p.getLastModifiedOn());
			if(days<15 && noOfDays==1)
			{
				dList.add(p);
			}
			else if(days>15 && days<30 && noOfDays==2)
			{
				dList.add(p);
			}
			else if(days>30 && noOfDays==3)
			{
				dList.add(p);
			}
		}
		}
		}catch (Exception ex){
			ex.printStackTrace();
			return ResponseEntity.ok(TaskListResponse.error(ex.getMessage()));
		}
		return ResponseEntity.ok(TaskListResponse.ok(dList));
	}
	
	@GetMapping(path= "project-alt-list-chariman-dashboard")
	public ResponseEntity<TaskListResponse> getProjectListForChairman() {
		List<ProjectSummaryModel> plist=service.getPendingWithAuthList();
		return ResponseEntity.ok(TaskListResponse.ok(plist)); 
	}
	
	@GetMapping(path= "project-alt-list-by-department/{depName}/{noOfDays}")
	public ResponseEntity<TaskListResponse> getProjectListByDepName(@PathVariable String depName,@PathVariable int noOfDays,HttpServletRequest req) {
		AuthUser user=AuthUser.getLoggedInUser(req);
		System.out.println(user);
		System.out.println(user.getDepartment()+"  "+user.getTeam()+"  "+user.getUserType());
		List<ProjectSummaryModel> plist=this.service.pendingProjectListByDepName(depName,noOfDays);
		return ResponseEntity.ok(TaskListResponse.ok(plist));
	}
}

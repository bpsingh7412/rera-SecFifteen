package in.gov.projectalteration.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.gov.projectalteration.dao.OfficeNoteDao;
import in.gov.projectalteration.model.OfficeNoteModel;
import in.gov.projectalteration.model.ProjectResponseModel;
import in.gov.wf.security.AuthSecurity;
import in.gov.wf.security.AuthUser;

@RestController
@CrossOrigin("*")
public class OfficeNoteController {

	@Autowired
	private OfficeNoteDao noteDao;
	
	@RequestMapping(path="/project_alt_ftn/secure/project-officenote/{prjid}",produces="application/json",method=RequestMethod.GET)
	public ResponseEntity<ProjectResponseModel> getOfficeNoteListByProjectId(@PathVariable("prjid")Long prjId,  HttpServletRequest req){
		AuthUser user=AuthUser.getLoggedInUser(req);
	List<OfficeNoteModel> list=	this.noteDao.getNoteForOfficer(prjId, user.getDepartment(),  user.getDepartment());
		
		return ResponseEntity.ok(ProjectResponseModel.ok(list));
	}
	
	@RequestMapping(path="/project_alt_ftn/secure/saveproject-officenote",consumes="application/json",  produces="application/json",method=RequestMethod.POST)
	public ResponseEntity<ProjectResponseModel> saveOfficeNoteListByProjectId( @RequestBody OfficeNoteModel note,  HttpServletRequest req){
		try{
	   AuthUser user=AuthUser.getLoggedInUser(req);
	   note.setPostedOn(Calendar.getInstance());
	   note.setPostedBy(user.getUserName());
	   note.setFromDepartment(user.getDepartment());
	   note.setStatus("ACTIVE");
		this.noteDao.save(note);
		}catch(Exception ex){ex.printStackTrace();
		return ResponseEntity.ok(ProjectResponseModel.error(ex.getMessage()));
		}
		return ResponseEntity.ok(ProjectResponseModel.ok(note));
	}
	
	@RequestMapping(path="/project_alt_ftn/secure/rmproject-officenote/{nid}",  produces="application/json",method=RequestMethod.GET)
	public ResponseEntity<ProjectResponseModel> removeOfficeNoteListByProjectId( @PathVariable("nid") Long noteId,  HttpServletRequest req){
	
		OfficeNoteModel note=null;
		try{
	note=this.noteDao.getOne(noteId);
	   note.setStatus("INACTIVE");
		this.noteDao.save(note);
		}catch(Exception ex){ex.printStackTrace();
		return ResponseEntity.ok(ProjectResponseModel.error(ex.getMessage()));
		}
		return ResponseEntity.ok(ProjectResponseModel.ok(note));
	}
	
	
	@RequestMapping(path="/project_alt_ftn/project-officenote-test",produces="application/json",method=RequestMethod.GET)
	public ResponseEntity<ProjectResponseModel> getOfficeNoteTest(){
	
		
		return ResponseEntity.ok(ProjectResponseModel.ok(new OfficeNoteModel()));
	}
}

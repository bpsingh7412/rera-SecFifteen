package in.gov.projectalteration.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import in.gov.ProjectalterationApplication;
import in.gov.projectalteration.dao.FormThreeMofDetailsDao;
import in.gov.projectalteration.dao.ProjectAlterationDetailsDao;
import in.gov.projectalteration.exception.ResourceNotFoundException;
import in.gov.projectalteration.model.MofF3AssignmentModel;
import in.gov.projectalteration.model.MofFormThreeModel;
import in.gov.projectalteration.model.ProjectAlterationModel;
import in.gov.projectalteration.model.ProjectRegistrationModel;
import in.gov.projectalteration.services.FormThreeMofDetailsService;


@Service
@Transactional
public class FormThreeMofDetailsServiceImp  implements FormThreeMofDetailsService {

	
	@Autowired
	FormThreeMofDetailsDao dao;
	
	@Autowired
	ProjectAlterationDetailsDao altDao;

	
	@Override
	public MofFormThreeModel saveFormThreeMofDetails(MofFormThreeModel entity) throws ResourceNotFoundException {
		 
		Optional<ProjectAlterationModel> op = altDao.findById(entity.getProjAltId());
		if (op.isPresent()) {
			ProjectAlterationModel p = altDao.findById(entity.getProjAltId()).get();
			p.setProjectFormThreeMof(entity);
			altDao.save(p);
		} else {
			throw new ResourceNotFoundException("Not found data for Project Alt Id:" + entity.getProjAltId());
		}
		return entity;
		
	}

	@Override
	public List<MofFormThreeModel> getAllFormThreeDetails() {
		// TODO Auto-generated method stub
		List<MofFormThreeModel> l = new ArrayList<MofFormThreeModel>();
		dao.findAll().iterator().forEachRemaining(l::add);
		return l;
	}

	@Override
	public MofFormThreeModel updateFormThreeDetails(MofFormThreeModel entitiy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MofFormThreeModel getFormThreeDetailsById(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public MofFormThreeModel getFormThreeMofDetailsByResponceId(Long id) {
		// TODO Auto-generated method stub
		return dao.findByProjAltId(id);
	}

	@Override
	public MofFormThreeModel getFormThreeDetailsByResponceIdAndStatusNot(Long id, String status) {
		// TODO Auto-generated method stub
		return dao.findByProjAltIdAndStatusNot(id, status);
	}

	@Override
	public MofFormThreeModel assignProfessionals(MofF3AssignmentModel entity) throws ResourceNotFoundException {
		System.out.println("assignProfessionals");
		System.out.println("assignProfessionals-->" + entity.getPrjAltId());
		List<MofF3AssignmentModel> assignList = null;
		Optional<ProjectAlterationModel> op = altDao.findById(entity.getPrjAltId());
		MofFormThreeModel f3m;
		if (op.isPresent()) {
			ProjectAlterationModel project = altDao.findById(entity.getPrjAltId()).get();
			f3m = project.getProjectFormThreeMof();
			Optional<MofFormThreeModel> frmone = Optional.ofNullable(f3m);
			if (frmone.isPresent()) {
				f3m.setProjAltId(entity.getPrjAltId());
				f3m.setAssignedUserId(entity.getAssignedUserId());
				f3m.setFormAssignedBy(entity.getFormAssignedBy());
				f3m.setFormAssignedOn(new Date());
				f3m.setCaMemberShipNumber(entity.getCaMemberShipNumber());
				f3m.setFirstName(entity.getFirstName());
				f3m.setLastName(entity.getLastName());
				f3m.setMiddleName(entity.getMiddleName());
				f3m.setMobileNo(entity.getMobileNo());
				f3m.setEmailId(entity.getEmailId());
				f3m.setStatus(entity.getStatus());
			
				assignList = f3m.getAssignmentModelList();

				if (assignList.size() > 0) {
					MofF3AssignmentModel prevObj = assignList.get(assignList.size() - 1);
					prevObj.setStatus("REJECTED");
				}
				assignList.add(entity);
			} else {
				f3m = new MofFormThreeModel();
				f3m.setProjAltId(entity.getPrjAltId());
				f3m.setAssignedUserId(entity.getAssignedUserId());
				f3m.setFormAssignedBy(entity.getFormAssignedBy());
				f3m.setFormAssignedOn(new Date());
				f3m.setCaMemberShipNumber(entity.getCaMemberShipNumber());
				f3m.setFirstName(entity.getFirstName());
				f3m.setLastName(entity.getLastName());
				f3m.setMiddleName(entity.getMiddleName());
				f3m.setMobileNo(entity.getMobileNo());
				f3m.setEmailId(entity.getEmailId());
				f3m.setStatus(entity.getStatus());
				f3m.setAssignmentModelList(new ArrayList<MofF3AssignmentModel>());
				f3m.getAssignmentModelList().add(entity);
			}
			
			project.setProjectFormThreeMof(f3m);
			altDao.save(project);
		} else {
			throw new ResourceNotFoundException("Not found data for Project Alt Id:" + entity.getPrjAltId());
		}

		return f3m;

	}

	@Override
	public MofFormThreeModel updateStatus(Long responceId, String status) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		MofFormThreeModel op = dao.findByProjAltId(responceId);
		Optional.ofNullable(op).orElseThrow(() -> new ResourceAccessException("Not found"));
		op.setStatus(status);
		return dao.save(op);
	}

	@Override
	public MofFormThreeModel updateStatus(Long prjAltid, String status, Long referenceForm3mofId)
			throws ResourceNotFoundException {
		
		MofFormThreeModel op = dao.findByProjAltId(prjAltid);
		Optional.ofNullable(op).orElseThrow(() -> new ResourceAccessException("Not found"));
		if(Optional.ofNullable(referenceForm3mofId).isPresent()) {
			op.setReferenceMofForm3Id(referenceForm3mofId);
		}else {
			op.setReferenceMofForm3Id(null);
		}
		op.setStatus(status);
		return dao.save(op);
    }

	@Override
	public MofFormThreeModel getFormThreeDetailsByprojectRegIdAndStatusNot(Long id, String rejected) {
		// TODO Auto-generated method stub
		return dao.findByProjAltIdAndStatusNot(id,rejected);
		
		
	}

}

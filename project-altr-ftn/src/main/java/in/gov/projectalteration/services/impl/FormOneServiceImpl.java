package in.gov.projectalteration.services.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import in.gov.projectalteration.dao.FormAssignmentDetailsDao;
import in.gov.projectalteration.dao.FormOneDetailsDao;
import in.gov.projectalteration.dao.ProjectAlterationDetailsDao;
import in.gov.projectalteration.exception.ResourceNotFoundException;
import in.gov.projectalteration.model.FormAssignmentModel;
import in.gov.projectalteration.model.FormOneModel;
import in.gov.projectalteration.model.ProjectAlterationModel;
import in.gov.projectalteration.services.FormOneDetailsService;

@Service
public class FormOneServiceImpl implements FormOneDetailsService {

	@Autowired
	FormOneDetailsDao dao;
	@Autowired
	ProjectAlterationDetailsDao prdao;
	@Autowired
	FormAssignmentDetailsDao fdao;
	@Autowired
	FormOneDetailsDao f1dao;

	@Override
	public FormOneModel saveProjectFormOnedettails(FormOneModel entity) throws ResourceNotFoundException {
		Optional<ProjectAlterationModel> op = prdao.findById(entity.getProjectAltrId());
		if (op.isPresent()) {
			ProjectAlterationModel p = prdao.findById(entity.getProjectAltrId()).get();
			p.setFormOneModel(entity);
			prdao.save(p);
		} else {
			throw new ResourceNotFoundException("Not found data for Project Id:" + entity.getProjectAltrId());
		}
		return entity;

	}
    
	@Transactional
	@Override
	public FormOneModel saveProfessionalAssignment(FormAssignmentModel entity) throws ResourceNotFoundException {
		System.out.println("saveProfessionalAssignment................>");
		System.out.println("getProjectAltrId:>" + entity.getProjectAltrId());

		List<FormAssignmentModel> assignList = null;
		Optional<ProjectAlterationModel> op = prdao.findById(entity.getProjectAltrId());
		FormOneModel f1m;

		if (op.isPresent()) {
			ProjectAlterationModel project = prdao.findById(entity.getProjectAltrId()).get();
			f1m = project.getFormOneModel();

			Optional<FormOneModel> frmone = Optional.ofNullable(f1m);

			if (frmone.isPresent()) {
				f1m.setProjectAltrId(entity.getProjectAltrId());
				f1m.setAssignedUserId(entity.getAssignedUserId());
				f1m.setFormAssignedBy(entity.getFormAssignedBy());
				f1m.setFormAssignedOn(new Date());
				f1m.setStatus(entity.getStatus());
				f1m.setArchitectName(entity.getArchitectName());
				f1m.setCoaNo(entity.getCoaNo());
				f1m.setEmailId(entity.getEmailId());
				f1m.setLastName(entity.getLastName());
				f1m.setMiddleName(entity.getMiddleName());
				f1m.setMobNumber(entity.getMobNumber());
				f1m.setStatus(entity.getStatus());
				assignList = f1m.getAssignmentModelList();
				if (assignList.size() > 0) {
					FormAssignmentModel prevObj = assignList.get(assignList.size() - 1);
					prevObj.setStatus("REJECTED");
				}
				assignList.add(entity);
			} else {
				f1m = new FormOneModel();
				f1m.setProjectAltrId(entity.getProjectAltrId());
				f1m.setAssignedUserId(entity.getAssignedUserId());
				f1m.setFormAssignedBy(entity.getFormAssignedBy());
				f1m.setFormAssignedOn(new Date());
				f1m.setStatus(entity.getStatus());
				f1m.setArchitectName(entity.getArchitectName());
				f1m.setCoaNo(entity.getCoaNo());
				f1m.setEmailId(entity.getEmailId());
				f1m.setLastName(entity.getLastName());
				f1m.setMiddleName(entity.getMiddleName());
				f1m.setMobNumber(entity.getMobNumber());
				f1m.setAssignmentModelList(new ArrayList<FormAssignmentModel>());
				f1m.getAssignmentModelList().add(entity);
				f1m.setStatus(entity.getStatus());
			}

			project.setFormOneModel(f1m);
			prdao.save(project);
		} else {
			throw new ResourceNotFoundException("Not found data for Project Id:" + entity.getProjectAltrId());
		}

		return f1m;

	}

	@Override
	public List<FormOneModel> getAllFormOnedettails() {
		List<FormOneModel> l = new ArrayList<FormOneModel>();
		dao.findAll().iterator().forEachRemaining(l::add);
		return l;
	}

	@Override
	public FormOneModel updateFormOnedettails(FormOneModel entity) {
		return dao.save(entity);
	}

	@Override
	public FormOneModel getFormOnedettailsById(Long id) {
		return dao.findById(id).get();
	}

	@Override
	public FormOneModel getFormOneByAltId(Long id) {
		return dao.findByProjectAltrId(id);
	}

	@Override
	public FormOneModel getFormOneByProjectAltrIdAndStatus(Long id, String status) {
		return dao.findByProjectAltrIdAndStatusNot(id, status);
	}

	@Override
	public FormOneModel updateStatus(Long id, String status) throws ResourceNotFoundException {
		FormOneModel op = dao.findByProjectAltrId(id);
		Optional.ofNullable(op).orElseThrow(() -> new ResourceAccessException("Not found"));
		op.setStatus(status);
		return dao.save(op);
	}

	@Override
	public FormOneModel updateStatus(Long id, String status, Long referenceFormOneId) throws ResourceNotFoundException {
		System.out.println("updateStatus : start");
		System.out.println("referenceFormOneId=" + referenceFormOneId);
		FormOneModel op = dao.findByProjectAltrId(id);
		Optional.ofNullable(op).orElseThrow(() -> new ResourceAccessException("Not found"));
		if (Optional.ofNullable(referenceFormOneId).isPresent())
			op.setReferanceformOneId(referenceFormOneId);
		else
			op.setReferanceformOneId(0l);
		op.setStatus(status);
		return dao.save(op);
	}

}

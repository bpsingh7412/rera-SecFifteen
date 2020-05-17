package in.gov.projectalteration.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import in.gov.projectalteration.dao.FormThreeDetailsDao;
import in.gov.projectalteration.dao.ProjectAlterationDetailsDao;
import in.gov.projectalteration.exception.ResourceNotFoundException;
import in.gov.projectalteration.model.Form3AssignmentModel;
import in.gov.projectalteration.model.FormThreeModel;
import in.gov.projectalteration.model.ProjectAlterationModel;
import in.gov.projectalteration.services.FormThreeDetailsService;

@Service
public class FormThreeServiceImpl implements FormThreeDetailsService {
	@Autowired
	FormThreeDetailsDao dao;
	@Autowired
	ProjectAlterationDetailsDao prdao;

	@Override

	public FormThreeModel saveFormThreeDetails(FormThreeModel entity) throws ResourceNotFoundException {
		Optional<ProjectAlterationModel> op = prdao.findById(entity.getProjectAltrId());
		if (op.isPresent()) {
			ProjectAlterationModel p = prdao.findById(entity.getProjectAltrId()).get();
			p.setFormThreeModel(entity);
			prdao.save(p);
		} else {
			throw new ResourceNotFoundException("Not found data for Project Id:" + entity.getProjectAltrId());
		}
		return entity;
	}

	@Override
	public List<FormThreeModel> getAllFormThreeDetails() {
		List<FormThreeModel> l = new ArrayList<FormThreeModel>();
		dao.findAll().iterator().forEachRemaining(l::add);
		return l;
	}

	@Override
	public FormThreeModel updateFormThreeDetails(FormThreeModel entitiy) {
		return null;
	}

	@Override
	public FormThreeModel getFormThreeDetailsById(Long id) {
		return dao.findById(id).get();
	}

	@Override
	public FormThreeModel getFormThreeDetailsByProjectAltrId(Long id) {
		return dao.findByProjectAltrId(id);
	}

	@Override
	public FormThreeModel assignProfessionals(Form3AssignmentModel entity) throws ResourceNotFoundException {
		System.out.println("assignProfessionals");
		System.out.println("assignProfessionals-->" + entity.getProjectAltrId());
		List<Form3AssignmentModel> assignList = null;
		Optional<ProjectAlterationModel> op = prdao.findById(entity.getProjectAltrId());
		FormThreeModel f3m;
		if (op.isPresent()) {
			ProjectAlterationModel project = prdao.findById(entity.getProjectAltrId()).get();
			f3m = project.getFormThreeModel();
			Optional<FormThreeModel> frmone = Optional.ofNullable(f3m);
			if (frmone.isPresent()) {
				f3m.setProjectAltrId(entity.getProjectAltrId());
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
					Form3AssignmentModel prevObj = assignList.get(assignList.size() - 1);
					prevObj.setStatus("REJECTED");
				}
				assignList.add(entity);
			} else {
				f3m = new FormThreeModel();
				f3m.setProjectAltrId(entity.getProjectAltrId());
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
				f3m.setAssignmentModelList(new ArrayList<Form3AssignmentModel>());
				f3m.getAssignmentModelList().add(entity);
			}

			project.setFormThreeModel(f3m);
			prdao.save(project);
		} else {
			throw new ResourceNotFoundException("Not found data for Project Id:" + entity.getProjectAltrId());
		}

		return f3m;
	}

	@Override
	public FormThreeModel updateStatus(Long ProjectAltrId, String status) throws ResourceNotFoundException {
		FormThreeModel op = dao.findByProjectAltrId(ProjectAltrId);
		Optional.ofNullable(op).orElseThrow(() -> new ResourceAccessException("Not found"));
		op.setStatus(status);
		return dao.save(op);
	}

	@Override
	public FormThreeModel updateStatus(Long ProjectAltrId, String status, Long referenceForm3Id)
			throws ResourceNotFoundException {
		FormThreeModel op = dao.findByProjectAltrId(ProjectAltrId);
		Optional.ofNullable(op).orElseThrow(() -> new ResourceAccessException("Not found"));
		if (Optional.ofNullable(referenceForm3Id).isPresent()) {
			op.setReferenceForm3Id(referenceForm3Id);
		} else {
			op.setReferenceForm3Id(null);
		}
		op.setStatus(status);
		return dao.save(op);
	}

	@Override
	public FormThreeModel getFormThreeDetailsByProjectAltrIdAndStatusNot(Long id, String status) {
		return dao.findByProjectAltrIdAndStatusNot(id, status);
	}

}

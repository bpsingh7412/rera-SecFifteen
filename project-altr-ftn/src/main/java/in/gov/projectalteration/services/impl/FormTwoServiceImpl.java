package in.gov.projectalteration.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import in.gov.projectalteration.dao.FormTwoDetailsDao;
import in.gov.projectalteration.dao.ProjectAlterationDetailsDao;
import in.gov.projectalteration.exception.ResourceNotFoundException;
import in.gov.projectalteration.model.Form2AssignmentModel;
import in.gov.projectalteration.model.FormTwoModel;
import in.gov.projectalteration.model.ProjectAlterationModel;
import in.gov.projectalteration.services.FormTwoDetailsService;

@Service
public class FormTwoServiceImpl implements FormTwoDetailsService {
	@Autowired
	FormTwoDetailsDao dao;
	@Autowired
	ProjectAlterationDetailsDao prdao;

	@Override
	public FormTwoModel saveFromTwoDetails(FormTwoModel entity) throws ResourceNotFoundException {
		Optional<ProjectAlterationModel> op = prdao.findById(entity.getProjectAltrId());
		if (op.isPresent()) {
			ProjectAlterationModel p = prdao.findById(entity.getProjectAltrId()).get();
			p.setFormTwoModel(entity);
			prdao.save(p);
		} else {
			throw new ResourceNotFoundException("Not found data for Project Id:" + entity.getProjectAltrId());
		}
		return entity;
	}

	@Override
	public List<FormTwoModel> getAllFromTwoDetails() {
		List<FormTwoModel> l = new ArrayList<FormTwoModel>();
		dao.findAll().iterator().forEachRemaining(l::add);
		return l;
	}

	@Override
	public FormTwoModel updateFromTwoDetails(FormTwoModel entity) {
		return dao.save(entity);
	}

	@Override
	public FormTwoModel getFromTwoDetailsById(Long id) {
		return dao.findById(id).get();
	}

	@Override
	public FormTwoModel saveProfessionalAssignment(Form2AssignmentModel entity) throws ResourceNotFoundException {
		System.out.println("saveFromTwoDetails-->" + entity.getEmailId());
		List<Form2AssignmentModel> assignList = null;
		Optional<ProjectAlterationModel> op = prdao.findById(entity.getProjectAltrId());
		FormTwoModel f2m;
		if (op.isPresent()) {
			ProjectAlterationModel project = prdao.findById(entity.getProjectAltrId()).get();
			f2m = project.getFormTwoModel();
			Optional<FormTwoModel> frm2 = Optional.ofNullable(f2m);

			if (frm2.isPresent()) {
				f2m.setProjectAltrId(entity.getProjectAltrId());
				f2m.setAssignedUserId(entity.getAssignedUserId());
				f2m.setFormAssignedBy(entity.getFormAssignedBy());
				f2m.setFormAssignedOn(new Date());
				f2m.setEmailId(entity.getEmailId());
				f2m.setEngineerLicenseNumber(entity.getEngineerLicenseNumber());
				f2m.setFirstName(entity.getFirstName());
				f2m.setLastName(entity.getLastName());
				f2m.setMiddleName(entity.getMiddleName());
				f2m.setMobileNo(entity.getMobileNo());
				f2m.setStatus(entity.getStatus());
				assignList = f2m.getAssignmentModelList();

				if (assignList.size() > 0) {
					Form2AssignmentModel prevObj = assignList.get(assignList.size() - 1);
					prevObj.setStatus("REJECTED");
				}
				assignList.add(entity);
			} else {
				f2m = new FormTwoModel();
				f2m.setProjectAltrId(entity.getProjectAltrId());
				f2m.setAssignedUserId(entity.getAssignedUserId());
				f2m.setFormAssignedBy(entity.getFormAssignedBy());
				f2m.setFormAssignedOn(new Date());
				f2m.setEmailId(entity.getEmailId());
				f2m.setEngineerLicenseNumber(entity.getEngineerLicenseNumber());
				f2m.setFirstName(entity.getFirstName());
				f2m.setLastName(entity.getLastName());
				f2m.setMiddleName(entity.getMiddleName());
				f2m.setMobileNo(entity.getMobileNo());
				f2m.setAssignmentModelList(new ArrayList<Form2AssignmentModel>());
				f2m.getAssignmentModelList().add(entity);
				f2m.setStatus(entity.getStatus());
			}

			project.setFormTwoModel(f2m);
			prdao.save(project);
		} else {
			throw new ResourceNotFoundException("Not found data for Project Id:" + entity.getProjectAltrId());
		}

		return f2m;
	}

	@Override
	public FormTwoModel updateStatus(Long id, String status) throws ResourceNotFoundException {
		FormTwoModel op = dao.findByProjectAltrId(id);
		Optional.ofNullable(op).orElseThrow(() -> new ResourceAccessException("Not found"));
		op.setStatus(status);
		return dao.save(op);
	}

	@Override
	public FormTwoModel updateStatus(Long id, String status, Long referenceForm2Id) throws ResourceNotFoundException {
		FormTwoModel op = dao.findByProjectAltrId(id);
		Optional.ofNullable(op).orElseThrow(() -> new ResourceAccessException("Not found"));
		if (Optional.ofNullable(referenceForm2Id).isPresent()) {
			op.setReferenceForm2Id(referenceForm2Id);
		} else
			op.setReferenceForm2Id(null);

		op.setStatus(status);
		return dao.save(op);
	}

	@Override
	public FormTwoModel getFromTwoDetailsByProjectAltrId(Long id) {
		return dao.findByProjectAltrId(id);
	}

	@Override
	public FormTwoModel getFromTwoDetailsByProjectAltrIdAndStatus(Long id, String status) {
		return dao.findByProjectAltrIdAndStatusNot(id, status);
	}

}

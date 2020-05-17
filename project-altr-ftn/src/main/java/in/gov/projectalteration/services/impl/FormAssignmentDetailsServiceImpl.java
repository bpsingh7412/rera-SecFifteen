package in.gov.projectalteration.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.gov.projectalteration.dao.FormAssignmentDetailsDao;
import in.gov.projectalteration.model.FormAssignmentModel;
import in.gov.projectalteration.services.FormAssignmentDetailsServices;



@Service
public class FormAssignmentDetailsServiceImpl implements FormAssignmentDetailsServices {
	@Autowired
	FormAssignmentDetailsDao dao;

	@Override
	public FormAssignmentModel saveFormAssignmentDetails(FormAssignmentModel entity) {
		return dao.save(entity);
	}

	@Override
	public List<FormAssignmentModel> getAllFormAssignmentDetails() {
		List<FormAssignmentModel> l=new ArrayList<FormAssignmentModel>();
		dao.findAll().iterator().forEachRemaining(l::add);
		return l;
	}

	@Override
	public FormAssignmentModel updateFormAssignmentDetails(FormAssignmentModel entity) {
		return dao.save(entity);
	}

	@Override
	public FormAssignmentModel getFormAssignmentDetailsById(Long id) {
		return dao.findById(id).get();
	}

	@Override
	public List<FormAssignmentModel> getFormAssignmentDetailsByFormId(Long formId) {
		return dao.findByAssignedFromId(formId);
	}

	@Override
	public boolean isAssigned(Long formId) {
		return dao.findByAssignedFromId(formId).size() > 0 ? true : false;
	}

	@Override
	public List<FormAssignmentModel> getFormAssignmentDetailsByProfessionalId(Long id) {
		return dao.findByAssignedUserId(id);
	}

}

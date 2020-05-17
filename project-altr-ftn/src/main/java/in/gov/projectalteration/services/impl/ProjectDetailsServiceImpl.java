package in.gov.projectalteration.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import in.gov.projectalteration.dao.FormOneDetailsDao;
import in.gov.projectalteration.dao.ProjectAlterationDetailsDao;
import in.gov.projectalteration.dao.ProjectDetailsDao;
import in.gov.projectalteration.exception.ResourceNotFoundException;
import in.gov.projectalteration.model.FormOneModel;
import in.gov.projectalteration.model.ProjectAlterationModel;
import in.gov.projectalteration.model.ProjectDetailModel;
import in.gov.projectalteration.services.ProjectDetailsService;

@Service
public class ProjectDetailsServiceImpl implements ProjectDetailsService {
	private static final Logger logger = LogManager.getLogger(ProjectDetailsServiceImpl.class);
	@Autowired
	ProjectDetailsDao dao;

	@Autowired
	ProjectAlterationDetailsDao prDao;

	@Autowired
	FormOneDetailsDao f1dao;

	@Override
	@Transactional
	public ProjectDetailModel saveProjectDetails(ProjectDetailModel entity) throws ResourceNotFoundException {
		ProjectDetailModel returnObj = entity;
		logger.debug("saveprojectDetails");
		logger.debug("alt id:" + entity.getProjectAltrId());
		Optional<ProjectAlterationModel> p = prDao.findById(entity.getProjectAltrId());
		if (p.isPresent()) {
			logger.debug("isPresent:" + p.isPresent());
			if(null!=dao.findByProjectAltrId(entity.getProjectAltrId()))
			{
				returnObj=dao.findByProjectAltrId(entity.getProjectAltrId());
			}
			else
			{
				entity=dao.save(entity);
				ProjectAlterationModel alt = prDao.findById(entity.getProjectAltrId()).get();
				alt.setProjectDetailModel(entity);
				returnObj = prDao.save(alt).getProjectDetailModel();
			}
			} 
		 else {
			throw new ResourceAccessException("No project Reg record exist for given id" + entity.getProjectAltrId());
		}
		return returnObj;
	}

	@Override
	public List<ProjectDetailModel> getAll() {
		List<ProjectDetailModel> l = new ArrayList<ProjectDetailModel>();
		dao.findAll().iterator().forEachRemaining(l::add);
		return l;
	}

	@Override
	public ProjectDetailModel updateProjectDetails(ProjectDetailModel entity) {
		return dao.save(entity);
	}

	@Override
	public ProjectDetailModel getProjectDetailsById(Long id) {
		return dao.findById(id).get();
	}

	/* get assigned project details */
	@Override
	public List<ProjectDetailModel> getProjectDetailsByProfessionalId(Long id) throws ResourceNotFoundException {
		System.out.println("getProjectDetailsByProfessionalId");
		List<ProjectDetailModel> l = new ArrayList<ProjectDetailModel>();
		List<FormOneModel> f1List = f1dao.findByAssignedUserId(id);
		Optional.ofNullable(f1List).orElseThrow(() -> new ResourceAccessException("Data Not Found for id:" + id));

		for (FormOneModel projectFormOneDetail : f1List) {
			l.add(dao.findById(projectFormOneDetail.getProjectAltrId()).get());
		}

		return l;
	}

	@Override
	public ProjectDetailModel getByAlterationId(Long id) {
		ProjectDetailModel m = null;
		if (Optional.ofNullable(dao.findByProjectAltrId(id)).isPresent()) {
			m = dao.findByProjectAltrId(id);
		} else {
			throw new ResourceAccessException("Not exist.");
		}
		return m;
	}

}

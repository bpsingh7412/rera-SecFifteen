package in.gov.projectalteration.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.gov.projectalteration.dao.ProjectAlterationDetailsDao;
import in.gov.projectalteration.model.ProjectAlterationModel;
import in.gov.wf.model.WFEntity;
import in.gov.wf.service.WFService;


@Service
public class ProjectAlterationServiceImpl implements WFService{

	@Autowired
	ProjectAlterationDetailsDao dao;
	
	@Override
	public void updateWfEntity(WFEntity entity) {
		ProjectAlterationModel model=(ProjectAlterationModel)entity;
		this.dao.save(model);
		
	}

	@Override
	public WFEntity getWfEntityById(String wfoid) {
		// TODO Auto-generated method stub
		return this.dao.findByWfoId(wfoid);
	}

	@Override
	public String getTeamNameForAssign() {
		// TODO Auto-generated method stub
		return "TEAM1";
	}

}

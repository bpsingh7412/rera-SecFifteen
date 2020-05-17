package in.gov.projectalteration.common.services.impl;

import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import in.gov.projectalteration.constants.ReraConstants;
import in.gov.projectalteration.model.ProjectAlterationModel;
import in.gov.projectalteration.model.ProjectDetailModel;


@Service
public class ProjectAltAckNumberGeneration {
	private static final Logger logger = LogManager.getLogger(ProjectAltAckNumberGeneration.class);
	

	public static String getApplicationNo(ProjectDetailModel projectAlt, ProjectAlterationModel pModel) {
		logger.debug("getApplicationNo::Started::");
		Calendar cal = Calendar.getInstance();
		StringBuffer sb = new StringBuffer();
		sb.append("PR/");
		if(null==pModel.getStageOneStatus())
		{
			sb.append("S1/");
		}
		if(ReraConstants.COMPLETED.equals(pModel.getStageOneStatus()))
		{
			sb.append("S2/");
		}
		if (projectAlt.getDistCode() != null)
			sb.append(projectAlt.getDistName().toUpperCase()).append("/");
		if (projectAlt.getSubDistCode() != null)
			sb.append(projectAlt.getSubDistName().toUpperCase()).append("/");
		if (projectAlt.getApprovingAuthority() != null)
		{
			if(projectAlt.getValidTpName()!=null)
			sb.append(projectAlt.getValidTpName().toUpperCase()).append("/");
		}
		int yr = cal.get(Calendar.YEAR);
		int mnth = cal.get(Calendar.MONTH) + 1;
		int dt = cal.get(Calendar.DATE);
		yr = yr % 100;
		if (yr < 10) {
			sb.append("0").append(yr);
		} else {
			sb.append(yr);
		}
		if (mnth < 10) {
			sb.append("0").append(mnth);
		} else {
			sb.append(mnth);
		}
		if (dt < 10) {
			sb.append("0").append(dt);
		} else {
			sb.append(dt);
		}
		sb.append("/");

		String str = "" + projectAlt.getAltprojectDetailId();
		while (str.length() < 6) {
			str = "0" + str;
		}
		sb.append(str);
		 logger.debug("getApplicationNo::Ended::");
		return sb.toString();
	}
}

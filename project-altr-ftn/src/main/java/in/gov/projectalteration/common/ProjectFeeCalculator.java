package in.gov.projectalteration.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import in.gov.projectalteration.model.ProjectAlterationModel;

@Component
public class ProjectFeeCalculator {

	private static final Logger LOGGER = LogManager.getLogger(ProjectFeeCalculator.class);

	private static Map<String, Integer> oldMaxLimit;
	private static Map<String, Integer> oldHigherCost;
	private static Map<String, Integer> oldLowerCost;

	private static Map<String, Integer> maxLimit;
	private static Map<String, Integer> minLimit;
	private static Map<String, Integer> lowerCost;
	private static Map<String, Integer> maxExtLimit;
	private static Map<String, Integer> minExtLimit;

//	private static Map<String, Integer> higherCost;

	// @Autowired
	// static IPenaltyService<PenaltyModel, Long> penaltyService;

	static {
		maxLimit = new HashMap<String, Integer>();
		minLimit = new HashMap<String, Integer>();
		lowerCost = new HashMap<String, Integer>();
//		higherCost = new HashMap<String, Integer>();
		maxExtLimit = new HashMap<String, Integer>();
		minExtLimit = new HashMap<String, Integer>();

		maxLimit.put("Residential/Group Housing", 1000000);
		minLimit.put("Residential/Group Housing", 10000);
		lowerCost.put("Residential/Group Housing", 8);
		// higherCost.put("Residential/Group Housing", 10);

		maxLimit.put("Mixed Development", 1200000);
		minLimit.put("Mixed Development", 12000);
		lowerCost.put("Mixed Development", 15);
		// higherCost.put("Mixed Development", 15);

		maxLimit.put("Commercial", 1500000);
		minLimit.put("Commercial", 15000);
		lowerCost.put("Commercial", 20);
		// higherCost.put("Commercial", 25);

		maxLimit.put("Plotted Development", 500000);
		minLimit.put("Plotted Development", 5000);
		lowerCost.put("Plotted Development", 10);
		// higherCost.put("Plotted Development", 5);

		maxExtLimit.put("Residential/Group Housing", 500000);
		minExtLimit.put("Residential/Group Housing", 5000);

		maxExtLimit.put("Mixed Development", 600000);
		minExtLimit.put("Mixed Development", 6000);

		maxExtLimit.put("Commercial", 750000);
		minExtLimit.put("Commercial", 7500);

		maxExtLimit.put("Plotted Development", 250000);
		minExtLimit.put("Plotted Development", 2500);

		oldMaxLimit = new HashMap<String, Integer>();
		oldLowerCost = new HashMap<String, Integer>();
		oldHigherCost = new HashMap<String, Integer>();

		oldMaxLimit.put("Residential/Group Housing", 500000);
		oldLowerCost.put("Residential/Group Housing", 5);
		oldHigherCost.put("Residential/Group Housing", 10);

		oldMaxLimit.put("Mixed Development", 700000);
		oldLowerCost.put("Mixed Development", 10);
		oldHigherCost.put("Mixed Development", 15);

		oldMaxLimit.put("Commercial", 1000000);
		oldLowerCost.put("Commercial", 20);
		oldHigherCost.put("Commercial", 25);

		oldMaxLimit.put("Plotted Development", 200000);
		oldLowerCost.put("Plotted Development", 5);
		oldHigherCost.put("Plotted Development", 5);

	}

	public static double getProjectAltFee(ProjectAlterationModel project) {
		double fee = 0.0;
		String type = project.getProjectType();
//		int area = (int) (double) project.getTotalAreaOfLand();
		double area;

		try {

			area = project.getProjectDetailModel().getTotCarpetArea();
			fee = area * lowerCost.get(type);

			if (fee > maxLimit.get(type)) {
				fee = maxLimit.get(type);
			} else if (fee < minLimit.get(type)) {
				fee = minLimit.get(type);
			}

			// fee = Double.parseDouble(ReraConstants.DECIMALF2.format(fee));
			LOGGER.debug("Project ALt Type::::" + type);
			LOGGER.debug("Project Alt Areaaaaaaa::::" + area);
			LOGGER.debug("Project Alt Feeeeeessss::::" + fee);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("exception in calculateProjectAltFee" + e.getMessage());
		}
		return fee;
	}

	public static double getProjectRegFee(ProjectAlterationModel bsModel) {
		LOGGER.debug("getProjectRegFee:");
		System.out.println("getProjectRegFee:");
		double fee = 0.0;
		try {
			String type = bsModel.getProjectDetailModel().getProjectType();
			LOGGER.debug("ProjectID:" + bsModel.getProjectDetailModel().getProjectAltrId() + ",Project type:" + type);
			System.out.println("ProjectID:" + bsModel.getProjectDetailModel().getAltprojectDetailId() + ",Project type:" + type);

			double area = 0.0;

			area = bsModel.getProjectDetailModel().getTotCarpetAreaForProjectUnderReg(); // getTotalCarpetAreaForProjectUnderReg()
			fee = area * lowerCost.get(type);

			if (fee > maxLimit.get(type)) {
				fee = maxLimit.get(type);
			} else if (fee < minLimit.get(type)) {
				fee = minLimit.get(type);
			}

			LOGGER.debug("Project D areaa::::" + area);
			System.out.println("Project D areaa::::" + area);
			// fee = Double.parseDouble(ReraConstants.DECIMALF2.format(fee));
			LOGGER.debug("Project Type::::" + type);
			LOGGER.debug("Project Areaaaaaaa::::" + area);
			LOGGER.debug("Project Feeeeeessss::::" + fee);
			System.out.println("Project type :" + type + ",fee:" + fee + ",Project Fee:" + fee);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Exception in Project Fees Calc:::::::" + e.getMessage());
		}
		return fee;
	}

	public static double calculateProjectRegFee(String type, double area, ProjectAlterationModel projectAlt) {
		double fee = 0.0;
		try {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date dt = sdf.parse("2019-08-31");
			if (projectAlt.getAppSubmissionDate() != null
					&& projectAlt.getAppSubmissionDate().getTime() < dt.getTime()) { // area
																						// =
				projectAlt.getProjectDetailModel().getTotAreaOfLand();
				if (area <= 1000) {
					fee = area * oldLowerCost.get(type);
				} else {
					fee = area * oldHigherCost.get(type);
				}
				if (fee > oldMaxLimit.get(type)) {
					fee = oldMaxLimit.get(type);
				}
			} else { // area = //
				projectAlt.getProjectDetailModel().getTotCarpetAreaForProjectUnderReg();
				fee = area * lowerCost.get(type);

				if (fee > maxLimit.get(type)) {
					fee = maxLimit.get(type);
				} else if (fee < minLimit.get(type)) {
					fee = minLimit.get(type);
				}
			}

			// fee = Double.parseDouble(ReraConstants.DECIMALF2.format(fee));

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("exception in calculateProjectRegFee" + e.getMessage());
		}
		return fee;
	}

}

package in.gov.projectalteration.common;

import java.util.Date;

import in.gov.projectalteration.constants.ReraConstants;
import in.gov.projectalteration.model.ProjectAlterationModel;

public class PaymentTokenNumber {

	public static String QUARTER_TOKEN_STARTWITH = "QT";
	public static String DEFAULT_QUARTER_TOKEN_STARTWITH = "DEFQT";
	public static String PROJECT_ALTER_TOKEN_STARTWITH = "PA";
	public static String CA_REG_TOKEN_STARTWITH = "CAREG";
	public static String ARCHITECT_REG_TOKEN_STARTWITH = "ARCREG";
	
	

	public static String generateToken(ProjectAlterationModel model) {

		StringBuffer sb = new StringBuffer("PR");
		if (model.getPromoterType().equals(ReraConstants.INDVISUAL))
			sb.append("I");
		else
			sb.append("C");
		sb.append(uniqeCode());

		Long id = model.getProjectAltrId();

		String str = "" + (id % 1000);

		while (str.length() < 3) {
			str = "0" + str;
		}
		sb.append(str);
		return sb.toString();
	}

	public static String generateTokenProjectRegExtension(ProjectAlterationModel model) {

		StringBuffer sb = new StringBuffer("PX");
		if (model.getPromoterType().equals(ReraConstants.INDVISUAL))
			sb.append("I");
		else
			sb.append("C");
		sb.append(uniqeCode());

		long id = model.getProjectAltrId();

		String str = "" + (id % 1000);

		while (str.length() < 3) {
			str = "0" + str;
		}
		sb.append(str);
		return sb.toString();
	}

	/*
	 * public static String generateToken(AgentRegistrationModel model){
	 * 
	 * StringBuffer sb=new StringBuffer("AR");
	 * if(model.getRegistrationType().equals(ReraConstants.INDVISUAL_REG))
	 * sb.append("I"); else sb.append("C"); sb.append(uniqeCode());
	 * 
	 * long id=model.getAgentRegistrationID();
	 * 
	 * String str=""+(id%1000);
	 * 
	 * while(str.length()<3){ str="0"+str; } sb.append(str); return sb.toString(); }
	 * 
	 * public static String generateTokenAgentRegRenewal(AgentRegistrationModel
	 * model){
	 * 
	 * StringBuffer sb=new StringBuffer("AX");
	 * if(model.getRegistrationType().equals(ReraConstants.INDVISUAL_REG))
	 * sb.append("I"); else sb.append("C"); sb.append(uniqeCode());
	 * 
	 * long id=model.getAgentRegistrationID();
	 * 
	 * String str=""+(id%1000);
	 * 
	 * while(str.length()<3){ str="0"+str; } sb.append(str); return sb.toString(); }
	 */
	public static String generateToken() {

		StringBuffer sb = new StringBuffer("CMP");

		sb.append(uniqeCode());

		String str = "" + (number % 1000);

		while (str.length() < 3) {
			str = "0" + str;
		}
		number++;
		sb.append(str);
		return sb.toString();
	}

	private static long number = 1l;

	public static String uniqeCode() {
		StringBuffer sb = new StringBuffer();
		long l = new Date().getTime();
		while (l > 0) {
			int x = (int) (l % 35);
			l = l / 61;
			sb.append(charCode.charAt(x));
		}

		return sb.toString();
	}

	public static String generateQuarterToken(Long quarterId) {

		StringBuffer sb = new StringBuffer(PaymentTokenNumber.QUARTER_TOKEN_STARTWITH);

		sb.append(uniqeCode());

		String str = "" + (quarterId % 1000);

		while (str.length() < 3) {
			str = "0" + str;
		}
		sb.append(str);
		return sb.toString();
	}

	public static String generateDefaultQuarterToken(Long defaultQuarterId) {

		StringBuffer sb = new StringBuffer(PaymentTokenNumber.DEFAULT_QUARTER_TOKEN_STARTWITH);

		sb.append(uniqeCode());

		String str = "" + (defaultQuarterId % 1000);

		while (str.length() < 3) {
			str = "0" + str;
		}
		sb.append(str);
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(uniqeCode());
	}

	private static final String charCode = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	public static String generateMisceToken() {

		StringBuffer sb = new StringBuffer("MS");
		sb.append(uniqeCode());

		String str = "" + (number % 1000);

		while (str.length() < 3) {
			str = "0" + str;
		}
		number++;
		sb.append(str);
		return sb.toString();
	}

	public static String generateProjAlterToken() {

		StringBuffer sb = new StringBuffer(PROJECT_ALTER_TOKEN_STARTWITH);

		sb.append(uniqeCode());

		String str = "" + (number % 1000);

		while (str.length() < 3) {
			str = "0" + str;
		}
		number++;
		sb.append(str);
		return sb.toString();
	}

	public static String generateMisceChallan() {

		StringBuffer sb = new StringBuffer("MSCH");
		sb.append(uniqeCode());

		String str = "" + (number % 1000);

		while (str.length() < 3) {
			str = "0" + str;
		}
		number++;
		sb.append(str);
		return sb.toString();
	}

	public static String generateTokenForCA() {

		StringBuffer sb = new StringBuffer(CA_REG_TOKEN_STARTWITH);

		sb.append(uniqeCode());
		String str = "" + (number % 1000);

		while (str.length() < 3) {
			str = "0" + str;
		}
		number++;
		sb.append(str);
		return sb.toString();
	}

// token generated for architect
	public static String generateTokenForArchitect() {

		StringBuffer sb = new StringBuffer(ARCHITECT_REG_TOKEN_STARTWITH);
		sb.append(uniqeCode());
		String str = "" + (number % 1000);
		while (str.length() < 3) {
			str = "0" + str;
		}
		number++;
		sb.append(str);
		return sb.toString();
	}

	public static String generatePayBRCToken() {

		StringBuffer sb = new StringBuffer("BCR");

		sb.append(uniqeCode());

		String str = "" + (number % 1000);

		while (str.length() < 3) {
			str = "0" + str;
		}
		number++;
		sb.append(str);
		return sb.toString();
	}
}

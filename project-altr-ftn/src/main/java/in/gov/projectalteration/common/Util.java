package in.gov.projectalteration.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Util {

	public static String covertCalenderToStringDate(Calendar date) {
		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
		String formatter = format1.format(date.getTime());
		System.out.println(formatter);
		return formatter;
		}
}

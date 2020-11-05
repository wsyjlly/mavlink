package cn.swyan.mavlink.protocol.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**********************************
 * @Author YSW
 * @Description
 * @Date 2020.10.30 - 15:03
 **********************************/

public class StringModel {
	private static final Pattern patternLineToHump = Pattern.compile("_(\\w)");
	public static String lineToHump(String str) {
		Matcher matcher =  patternLineToHump.matcher(str.toLowerCase());
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
		}
		matcher.appendTail(sb);
		return sb.toString();
	}
	public static String lineToBigHump(String str) {
		return lineToHump("_"+str);
	}
}

package cn.swyan.mavlink.protocol.util;

/**********************************
 * Author YSW
 * Description
 * Date 2020.10.22 - 19:51
 **********************************/

public class ByteModel {

	/**
	 * 十进制字符串转二进制字节数组
	 */
	public static byte[] hexStringToBytes(String hex) {
		if (hex.length() < 1) {
			return null;
		} else if(hex.length() % 2 !=0 ){
			throw new IllegalArgumentException("参数异常，十六进制字符串长度需为偶数！");
		} else {
			byte[] result = new byte[hex.length() / 2];
			int j = 0;
			for(int i = 0; i < hex.length(); i += 2) {
				result[j++] = (byte)Integer.parseInt(hex.substring(i,i+2), 16);
			}
			return result;
		}
	}

	/**
	 * 十六进制字节间隔为空格字符串转二进制字节数组
	 */
	public static byte[] hexBlankStringToBytes(String hex) {
		hex = hex.trim();
		if (hex.length() < 1) {
			throw new NullPointerException("字符串为空！");
		} else if(hex.length() % 3 !=2 ){
			throw new IllegalArgumentException("参数异常，十六进制字符个数需为偶数！");
		} else {
			byte[] result = new byte[(hex.length()+1) / 3];
			int j = 0;
			for(int i = 0; i < hex.length(); i+=3) {
				result[j++] = (byte)Integer.parseInt(hex.substring(i,i+2), 16);
			}
			return result;
		}
	}

	/**
	 * 二进制字节数组转十六进制字符串
	 */
	public static String bytes2HexString(byte[] b) {
		StringBuilder ret = new StringBuilder();
		for (byte value : b) {
			String hex = Integer.toHexString(value & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			ret.append(hex.toUpperCase()).append(" ");
		}
		return ret.toString();
	}
}

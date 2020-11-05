package cn.swyan.mavlink.common;

/**********************************
 * @Author YSW
 * @Description
 * @Date 2020.11.03 - 13:22
 **********************************/

public interface Message {
	/**
	 * 设置载荷信息
	 * @param messagePayload
	 */
	void messagePayload(byte[] messagePayload);

	/**
	 * 获取载荷信息
	 * @return
	 */
	byte[] messagePayload();

	/**
	 * 返回载荷十六进制字符串
	 * @return
	 */
	String hexStringPayload();
}

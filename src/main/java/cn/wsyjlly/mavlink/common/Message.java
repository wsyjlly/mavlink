package cn.wsyjlly.mavlink.common;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.03 - 13:22
 **********************************/

public interface Message {

	void messagePayload(byte[] messagePayload);
	byte[] messagePayload();
	String hexStringPayload();

}

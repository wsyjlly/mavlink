package cn.wsyjlly.mavlink.descriptor;

/**********************************
 * Author YSW
 * Description
 * Date 2020.10.26 - 14:45
 **********************************/

public interface MavlinkDescriptor {
	/**
	 * 解析Mavlink Common.xml minimal.xml 及遵循Mavlink规范的自定义xml ,生成Java 映射类
	 */
	void descriptor(String srcFile, String targetFolder);
}

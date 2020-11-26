package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "FIRMWARE_VERSION_TYPE")
public enum  FirmwareVersionType {
	
	/**
	 * development release
	 */
	@MavlinkEnumEntry(value = 0,description = "development release")
	FIRMWARE_VERSION_TYPE_DEV(),
	
	/**
	 * alpha release
	 */
	@MavlinkEnumEntry(value = 64,description = "alpha release")
	FIRMWARE_VERSION_TYPE_ALPHA(),
	
	/**
	 * beta release
	 */
	@MavlinkEnumEntry(value = 128,description = "beta release")
	FIRMWARE_VERSION_TYPE_BETA(),
	
	/**
	 * release candidate
	 */
	@MavlinkEnumEntry(value = 192,description = "release candidate")
	FIRMWARE_VERSION_TYPE_RC(),
	
	/**
	 * official stable release
	 */
	@MavlinkEnumEntry(value = 255,description = "official stable release")
	FIRMWARE_VERSION_TYPE_OFFICIAL(),
}
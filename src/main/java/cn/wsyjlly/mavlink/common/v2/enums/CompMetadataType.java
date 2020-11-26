package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "COMP_METADATA_TYPE")
public enum  CompMetadataType {
	
	/**
	 * Version information which also includes information on other optional supported COMP_METADATA_TYPE's. Must be supported. Only downloadable from vehicle.
	 */
	@MavlinkEnumEntry(value = 0,description = "Version information which also includes information on other optional supported COMP_METADATA_TYPE's. Must be supported. Only downloadable from vehicle.")
	COMP_METADATA_TYPE_VERSION(),
	
	/**
	 * Parameter meta data.
	 */
	@MavlinkEnumEntry(value = 1,description = "Parameter meta data.")
	COMP_METADATA_TYPE_PARAMETER(),
	
	/**
	 * Meta data which specifies the commands the vehicle supports. (WIP)
	 */
	@MavlinkEnumEntry(value = 2,description = "Meta data which specifies the commands the vehicle supports. (WIP)")
	COMP_METADATA_TYPE_COMMANDS(),
}
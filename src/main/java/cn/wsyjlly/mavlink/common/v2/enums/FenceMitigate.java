package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "FENCE_MITIGATE")
public enum  FenceMitigate {
	
	/**
	 * Unknown
	 */
	@MavlinkEnumEntry(value = 0,description = "Unknown")
	FENCE_MITIGATE_UNKNOWN(),
	
	/**
	 * No actions being taken
	 */
	@MavlinkEnumEntry(value = 1,description = "No actions being taken")
	FENCE_MITIGATE_NONE(),
	
	/**
	 * Velocity limiting active to prevent breach
	 */
	@MavlinkEnumEntry(value = 2,description = "Velocity limiting active to prevent breach")
	FENCE_MITIGATE_VEL_LIMIT(),
}
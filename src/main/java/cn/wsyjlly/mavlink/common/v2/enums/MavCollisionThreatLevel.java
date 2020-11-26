package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "MAV_COLLISION_THREAT_LEVEL")
public enum  MavCollisionThreatLevel {
	
	/**
	 * Not a threat
	 */
	@MavlinkEnumEntry(value = 0,description = "Not a threat")
	MAV_COLLISION_THREAT_LEVEL_NONE(),
	
	/**
	 * Craft is mildly concerned about this threat
	 */
	@MavlinkEnumEntry(value = 1,description = "Craft is mildly concerned about this threat")
	MAV_COLLISION_THREAT_LEVEL_LOW(),
	
	/**
	 * Craft is panicking, and may take actions to avoid threat
	 */
	@MavlinkEnumEntry(value = 2,description = "Craft is panicking, and may take actions to avoid threat")
	MAV_COLLISION_THREAT_LEVEL_HIGH(),
}
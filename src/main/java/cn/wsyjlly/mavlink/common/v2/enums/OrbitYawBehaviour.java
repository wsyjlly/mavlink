package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "ORBIT_YAW_BEHAVIOUR")
public enum  OrbitYawBehaviour {
	
	/**
	 * Vehicle front points to the center (default).
	 */
	@MavlinkEnumEntry(value = 0,description = "Vehicle front points to the center (default).")
	ORBIT_YAW_BEHAVIOUR_HOLD_FRONT_TO_CIRCLE_CENTER(),
	
	/**
	 * Vehicle front holds heading when message received.
	 */
	@MavlinkEnumEntry(value = 1,description = "Vehicle front holds heading when message received.")
	ORBIT_YAW_BEHAVIOUR_HOLD_INITIAL_HEADING(),
	
	/**
	 * Yaw uncontrolled.
	 */
	@MavlinkEnumEntry(value = 2,description = "Yaw uncontrolled.")
	ORBIT_YAW_BEHAVIOUR_UNCONTROLLED(),
	
	/**
	 * Vehicle front follows flight path (tangential to circle).
	 */
	@MavlinkEnumEntry(value = 3,description = "Vehicle front follows flight path (tangential to circle).")
	ORBIT_YAW_BEHAVIOUR_HOLD_FRONT_TANGENT_TO_CIRCLE(),
	
	/**
	 * Yaw controlled by RC input.
	 */
	@MavlinkEnumEntry(value = 4,description = "Yaw controlled by RC input.")
	ORBIT_YAW_BEHAVIOUR_RC_CONTROLLED(),
}
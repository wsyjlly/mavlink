package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "GIMBAL_MANAGER_FLAGS", bitmask = "true")
public enum  GimbalManagerFlags {
	
	/**
	 * Based on GIMBAL_DEVICE_FLAGS_RETRACT
	 */
	@MavlinkEnumEntry(value = 1,description = "Based on GIMBAL_DEVICE_FLAGS_RETRACT")
	GIMBAL_MANAGER_FLAGS_RETRACT(),
	
	/**
	 * Based on GIMBAL_DEVICE_FLAGS_NEUTRAL
	 */
	@MavlinkEnumEntry(value = 2,description = "Based on GIMBAL_DEVICE_FLAGS_NEUTRAL")
	GIMBAL_MANAGER_FLAGS_NEUTRAL(),
	
	/**
	 * Based on GIMBAL_DEVICE_FLAGS_ROLL_LOCK
	 */
	@MavlinkEnumEntry(value = 4,description = "Based on GIMBAL_DEVICE_FLAGS_ROLL_LOCK")
	GIMBAL_MANAGER_FLAGS_ROLL_LOCK(),
	
	/**
	 * Based on GIMBAL_DEVICE_FLAGS_PITCH_LOCK
	 */
	@MavlinkEnumEntry(value = 8,description = "Based on GIMBAL_DEVICE_FLAGS_PITCH_LOCK")
	GIMBAL_MANAGER_FLAGS_PITCH_LOCK(),
	
	/**
	 * Based on GIMBAL_DEVICE_FLAGS_YAW_LOCK
	 */
	@MavlinkEnumEntry(value = 16,description = "Based on GIMBAL_DEVICE_FLAGS_YAW_LOCK")
	GIMBAL_MANAGER_FLAGS_YAW_LOCK(),
	
	/**
	 * This flag can be set to give up control previously set using MAV_CMD_DO_GIMBAL_MANAGER_PITCHYAW. This flag must not be combined with other flags.
	 */
	@MavlinkEnumEntry(value = 1048576,description = "This flag can be set to give up control previously set using MAV_CMD_DO_GIMBAL_MANAGER_PITCHYAW. This flag must not be combined with other flags.")
	GIMBAL_MANAGER_FLAGS_NONE(),
}
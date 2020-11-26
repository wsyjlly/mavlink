package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "GIMBAL_MANAGER_CAP_FLAGS", bitmask = "true")
public enum  GimbalManagerCapFlags {
	
	/**
	 * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_RETRACT.
	 */
	@MavlinkEnumEntry(value = 1,description = "Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_RETRACT.")
	GIMBAL_MANAGER_CAP_FLAGS_HAS_RETRACT(),
	
	/**
	 * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_NEUTRAL.
	 */
	@MavlinkEnumEntry(value = 2,description = "Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_NEUTRAL.")
	GIMBAL_MANAGER_CAP_FLAGS_HAS_NEUTRAL(),
	
	/**
	 * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_ROLL_AXIS.
	 */
	@MavlinkEnumEntry(value = 4,description = "Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_ROLL_AXIS.")
	GIMBAL_MANAGER_CAP_FLAGS_HAS_ROLL_AXIS(),
	
	/**
	 * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_ROLL_FOLLOW.
	 */
	@MavlinkEnumEntry(value = 8,description = "Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_ROLL_FOLLOW.")
	GIMBAL_MANAGER_CAP_FLAGS_HAS_ROLL_FOLLOW(),
	
	/**
	 * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_ROLL_LOCK.
	 */
	@MavlinkEnumEntry(value = 16,description = "Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_ROLL_LOCK.")
	GIMBAL_MANAGER_CAP_FLAGS_HAS_ROLL_LOCK(),
	
	/**
	 * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_PITCH_AXIS.
	 */
	@MavlinkEnumEntry(value = 32,description = "Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_PITCH_AXIS.")
	GIMBAL_MANAGER_CAP_FLAGS_HAS_PITCH_AXIS(),
	
	/**
	 * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_PITCH_FOLLOW.
	 */
	@MavlinkEnumEntry(value = 64,description = "Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_PITCH_FOLLOW.")
	GIMBAL_MANAGER_CAP_FLAGS_HAS_PITCH_FOLLOW(),
	
	/**
	 * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_PITCH_LOCK.
	 */
	@MavlinkEnumEntry(value = 128,description = "Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_PITCH_LOCK.")
	GIMBAL_MANAGER_CAP_FLAGS_HAS_PITCH_LOCK(),
	
	/**
	 * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_YAW_AXIS.
	 */
	@MavlinkEnumEntry(value = 256,description = "Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_YAW_AXIS.")
	GIMBAL_MANAGER_CAP_FLAGS_HAS_YAW_AXIS(),
	
	/**
	 * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_YAW_FOLLOW.
	 */
	@MavlinkEnumEntry(value = 512,description = "Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_YAW_FOLLOW.")
	GIMBAL_MANAGER_CAP_FLAGS_HAS_YAW_FOLLOW(),
	
	/**
	 * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_YAW_LOCK.
	 */
	@MavlinkEnumEntry(value = 1024,description = "Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_YAW_LOCK.")
	GIMBAL_MANAGER_CAP_FLAGS_HAS_YAW_LOCK(),
	
	/**
	 * Based on GIMBAL_DEVICE_CAP_FLAGS_SUPPORTS_INFINITE_YAW.
	 */
	@MavlinkEnumEntry(value = 2048,description = "Based on GIMBAL_DEVICE_CAP_FLAGS_SUPPORTS_INFINITE_YAW.")
	GIMBAL_MANAGER_CAP_FLAGS_SUPPORTS_INFINITE_YAW(),
	
	/**
	 * Gimbal manager supports to point to a local position.
	 */
	@MavlinkEnumEntry(value = 65536,description = "Gimbal manager supports to point to a local position.")
	GIMBAL_MANAGER_CAP_FLAGS_CAN_POINT_LOCATION_LOCAL(),
	
	/**
	 * Gimbal manager supports to point to a global latitude, longitude, altitude position.
	 */
	@MavlinkEnumEntry(value = 131072,description = "Gimbal manager supports to point to a global latitude, longitude, altitude position.")
	GIMBAL_MANAGER_CAP_FLAGS_CAN_POINT_LOCATION_GLOBAL(),
}
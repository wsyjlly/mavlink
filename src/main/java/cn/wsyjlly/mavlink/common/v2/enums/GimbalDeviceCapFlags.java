package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "GIMBAL_DEVICE_CAP_FLAGS", bitmask = "true")
public enum  GimbalDeviceCapFlags {
	
	/**
	 * Gimbal device supports a retracted position
	 */
	@MavlinkEnumEntry(value = 1,description = "Gimbal device supports a retracted position")
	GIMBAL_DEVICE_CAP_FLAGS_HAS_RETRACT(),
	
	/**
	 * Gimbal device supports a horizontal, forward looking position, stabilized
	 */
	@MavlinkEnumEntry(value = 2,description = "Gimbal device supports a horizontal, forward looking position, stabilized")
	GIMBAL_DEVICE_CAP_FLAGS_HAS_NEUTRAL(),
	
	/**
	 * Gimbal device supports rotating around roll axis.
	 */
	@MavlinkEnumEntry(value = 4,description = "Gimbal device supports rotating around roll axis.")
	GIMBAL_DEVICE_CAP_FLAGS_HAS_ROLL_AXIS(),
	
	/**
	 * Gimbal device supports to follow a roll angle relative to the vehicle
	 */
	@MavlinkEnumEntry(value = 8,description = "Gimbal device supports to follow a roll angle relative to the vehicle")
	GIMBAL_DEVICE_CAP_FLAGS_HAS_ROLL_FOLLOW(),
	
	/**
	 * Gimbal device supports locking to an roll angle (generally that's the default with roll stabilized)
	 */
	@MavlinkEnumEntry(value = 16,description = "Gimbal device supports locking to an roll angle (generally that's the default with roll stabilized)")
	GIMBAL_DEVICE_CAP_FLAGS_HAS_ROLL_LOCK(),
	
	/**
	 * Gimbal device supports rotating around pitch axis.
	 */
	@MavlinkEnumEntry(value = 32,description = "Gimbal device supports rotating around pitch axis.")
	GIMBAL_DEVICE_CAP_FLAGS_HAS_PITCH_AXIS(),
	
	/**
	 * Gimbal device supports to follow a pitch angle relative to the vehicle
	 */
	@MavlinkEnumEntry(value = 64,description = "Gimbal device supports to follow a pitch angle relative to the vehicle")
	GIMBAL_DEVICE_CAP_FLAGS_HAS_PITCH_FOLLOW(),
	
	/**
	 * Gimbal device supports locking to an pitch angle (generally that's the default with pitch stabilized)
	 */
	@MavlinkEnumEntry(value = 128,description = "Gimbal device supports locking to an pitch angle (generally that's the default with pitch stabilized)")
	GIMBAL_DEVICE_CAP_FLAGS_HAS_PITCH_LOCK(),
	
	/**
	 * Gimbal device supports rotating around yaw axis.
	 */
	@MavlinkEnumEntry(value = 256,description = "Gimbal device supports rotating around yaw axis.")
	GIMBAL_DEVICE_CAP_FLAGS_HAS_YAW_AXIS(),
	
	/**
	 * Gimbal device supports to follow a yaw angle relative to the vehicle (generally that's the default)
	 */
	@MavlinkEnumEntry(value = 512,description = "Gimbal device supports to follow a yaw angle relative to the vehicle (generally that's the default)")
	GIMBAL_DEVICE_CAP_FLAGS_HAS_YAW_FOLLOW(),
	
	/**
	 * Gimbal device supports locking to an absolute heading (often this is an option available)
	 */
	@MavlinkEnumEntry(value = 1024,description = "Gimbal device supports locking to an absolute heading (often this is an option available)")
	GIMBAL_DEVICE_CAP_FLAGS_HAS_YAW_LOCK(),
	
	/**
	 * Gimbal device supports yawing/panning infinetely (e.g. using slip disk).
	 */
	@MavlinkEnumEntry(value = 2048,description = "Gimbal device supports yawing/panning infinetely (e.g. using slip disk).")
	GIMBAL_DEVICE_CAP_FLAGS_SUPPORTS_INFINITE_YAW(),
}
package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "GIMBAL_DEVICE_FLAGS", bitmask = "true")
public enum  GimbalDeviceFlags {
	
	/**
	 * Set to retracted safe position (no stabilization), takes presedence over all other flags.
	 */
	@MavlinkEnumEntry(value = 1,description = "Set to retracted safe position (no stabilization), takes presedence over all other flags.")
	GIMBAL_DEVICE_FLAGS_RETRACT(),
	
	/**
	 * Set to neutral position (horizontal, forward looking, with stabiliziation), takes presedence over all other flags except RETRACT.
	 */
	@MavlinkEnumEntry(value = 2,description = "Set to neutral position (horizontal, forward looking, with stabiliziation), takes presedence over all other flags except RETRACT.")
	GIMBAL_DEVICE_FLAGS_NEUTRAL(),
	
	/**
	 * Lock roll angle to absolute angle relative to horizon (not relative to drone). This is generally the default with a stabilizing gimbal.
	 */
	@MavlinkEnumEntry(value = 4,description = "Lock roll angle to absolute angle relative to horizon (not relative to drone). This is generally the default with a stabilizing gimbal.")
	GIMBAL_DEVICE_FLAGS_ROLL_LOCK(),
	
	/**
	 * Lock pitch angle to absolute angle relative to horizon (not relative to drone). This is generally the default.
	 */
	@MavlinkEnumEntry(value = 8,description = "Lock pitch angle to absolute angle relative to horizon (not relative to drone). This is generally the default.")
	GIMBAL_DEVICE_FLAGS_PITCH_LOCK(),
	
	/**
	 * Lock yaw angle to absolute angle relative to North (not relative to drone). If this flag is set, the quaternion is in the Earth frame with the x-axis pointing North (yaw absolute). If this flag is not set, the quaternion frame is in the Earth frame rotated so that the x-axis is pointing forward (yaw relative to vehicle).
	 */
	@MavlinkEnumEntry(value = 16,description = "Lock yaw angle to absolute angle relative to North (not relative to drone). If this flag is set, the quaternion is in the Earth frame with the x-axis pointing North (yaw absolute). If this flag is not set, the quaternion frame is in the Earth frame rotated so that the x-axis is pointing forward (yaw relative to vehicle).")
	GIMBAL_DEVICE_FLAGS_YAW_LOCK(),
}
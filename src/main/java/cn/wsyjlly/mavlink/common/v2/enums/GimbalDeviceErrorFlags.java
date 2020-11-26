package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "GIMBAL_DEVICE_ERROR_FLAGS", bitmask = "true")
public enum  GimbalDeviceErrorFlags {
	
	/**
	 * Gimbal device is limited by hardware roll limit.
	 */
	@MavlinkEnumEntry(value = 1,description = "Gimbal device is limited by hardware roll limit.")
	GIMBAL_DEVICE_ERROR_FLAGS_AT_ROLL_LIMIT(),
	
	/**
	 * Gimbal device is limited by hardware pitch limit.
	 */
	@MavlinkEnumEntry(value = 2,description = "Gimbal device is limited by hardware pitch limit.")
	GIMBAL_DEVICE_ERROR_FLAGS_AT_PITCH_LIMIT(),
	
	/**
	 * Gimbal device is limited by hardware yaw limit.
	 */
	@MavlinkEnumEntry(value = 4,description = "Gimbal device is limited by hardware yaw limit.")
	GIMBAL_DEVICE_ERROR_FLAGS_AT_YAW_LIMIT(),
	
	/**
	 * There is an error with the gimbal encoders.
	 */
	@MavlinkEnumEntry(value = 8,description = "There is an error with the gimbal encoders.")
	GIMBAL_DEVICE_ERROR_FLAGS_ENCODER_ERROR(),
	
	/**
	 * There is an error with the gimbal power source.
	 */
	@MavlinkEnumEntry(value = 16,description = "There is an error with the gimbal power source.")
	GIMBAL_DEVICE_ERROR_FLAGS_POWER_ERROR(),
	
	/**
	 * There is an error with the gimbal motor's.
	 */
	@MavlinkEnumEntry(value = 32,description = "There is an error with the gimbal motor's.")
	GIMBAL_DEVICE_ERROR_FLAGS_MOTOR_ERROR(),
	
	/**
	 * There is an error with the gimbal's software.
	 */
	@MavlinkEnumEntry(value = 64,description = "There is an error with the gimbal's software.")
	GIMBAL_DEVICE_ERROR_FLAGS_SOFTWARE_ERROR(),
	
	/**
	 * There is an error with the gimbal's communication.
	 */
	@MavlinkEnumEntry(value = 128,description = "There is an error with the gimbal's communication.")
	GIMBAL_DEVICE_ERROR_FLAGS_COMMS_ERROR(),
	
	/**
	 * Gimbal is currently calibrating.
	 */
	@MavlinkEnumEntry(value = 256,description = "Gimbal is currently calibrating.")
	GIMBAL_DEVICE_ERROR_FLAGS_CALIBRATION_RUNNING(),
}
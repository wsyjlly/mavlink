package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "HL_FAILURE_FLAG", bitmask = "true")
public enum  HlFailureFlag {
	
	/**
	 * GPS failure.
	 */
	@MavlinkEnumEntry(value = 1,description = "GPS failure.")
	HL_FAILURE_FLAG_GPS(),
	
	/**
	 * Differential pressure sensor failure.
	 */
	@MavlinkEnumEntry(value = 2,description = "Differential pressure sensor failure.")
	HL_FAILURE_FLAG_DIFFERENTIAL_PRESSURE(),
	
	/**
	 * Absolute pressure sensor failure.
	 */
	@MavlinkEnumEntry(value = 4,description = "Absolute pressure sensor failure.")
	HL_FAILURE_FLAG_ABSOLUTE_PRESSURE(),
	
	/**
	 * Accelerometer sensor failure.
	 */
	@MavlinkEnumEntry(value = 8,description = "Accelerometer sensor failure.")
	HL_FAILURE_FLAG_3D_ACCEL(),
	
	/**
	 * Gyroscope sensor failure.
	 */
	@MavlinkEnumEntry(value = 16,description = "Gyroscope sensor failure.")
	HL_FAILURE_FLAG_3D_GYRO(),
	
	/**
	 * Magnetometer sensor failure.
	 */
	@MavlinkEnumEntry(value = 32,description = "Magnetometer sensor failure.")
	HL_FAILURE_FLAG_3D_MAG(),
	
	/**
	 * Terrain subsystem failure.
	 */
	@MavlinkEnumEntry(value = 64,description = "Terrain subsystem failure.")
	HL_FAILURE_FLAG_TERRAIN(),
	
	/**
	 * Battery failure/critical low battery.
	 */
	@MavlinkEnumEntry(value = 128,description = "Battery failure/critical low battery.")
	HL_FAILURE_FLAG_BATTERY(),
	
	/**
	 * RC receiver failure/no rc connection.
	 */
	@MavlinkEnumEntry(value = 256,description = "RC receiver failure/no rc connection.")
	HL_FAILURE_FLAG_RC_RECEIVER(),
	
	/**
	 * Offboard link failure.
	 */
	@MavlinkEnumEntry(value = 512,description = "Offboard link failure.")
	HL_FAILURE_FLAG_OFFBOARD_LINK(),
	
	/**
	 * Engine failure.
	 */
	@MavlinkEnumEntry(value = 1024,description = "Engine failure.")
	HL_FAILURE_FLAG_ENGINE(),
	
	/**
	 * Geofence violation.
	 */
	@MavlinkEnumEntry(value = 2048,description = "Geofence violation.")
	HL_FAILURE_FLAG_GEOFENCE(),
	
	/**
	 * Estimator failure, for example measurement rejection or large variances.
	 */
	@MavlinkEnumEntry(value = 4096,description = "Estimator failure, for example measurement rejection or large variances.")
	HL_FAILURE_FLAG_ESTIMATOR(),
	
	/**
	 * Mission failure.
	 */
	@MavlinkEnumEntry(value = 8192,description = "Mission failure.")
	HL_FAILURE_FLAG_MISSION(),
}
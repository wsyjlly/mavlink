package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "FAILURE_UNIT")
public enum  FailureUnit {
	
	/**
	 * FAILURE_UNIT_SENSOR_GYRO
	 */
	@MavlinkEnumEntry(value = 0)
	FAILURE_UNIT_SENSOR_GYRO(),
	
	/**
	 * FAILURE_UNIT_SENSOR_ACCEL
	 */
	@MavlinkEnumEntry(value = 1)
	FAILURE_UNIT_SENSOR_ACCEL(),
	
	/**
	 * FAILURE_UNIT_SENSOR_MAG
	 */
	@MavlinkEnumEntry(value = 2)
	FAILURE_UNIT_SENSOR_MAG(),
	
	/**
	 * FAILURE_UNIT_SENSOR_BARO
	 */
	@MavlinkEnumEntry(value = 3)
	FAILURE_UNIT_SENSOR_BARO(),
	
	/**
	 * FAILURE_UNIT_SENSOR_GPS
	 */
	@MavlinkEnumEntry(value = 4)
	FAILURE_UNIT_SENSOR_GPS(),
	
	/**
	 * FAILURE_UNIT_SENSOR_OPTICAL_FLOW
	 */
	@MavlinkEnumEntry(value = 5)
	FAILURE_UNIT_SENSOR_OPTICAL_FLOW(),
	
	/**
	 * FAILURE_UNIT_SENSOR_VIO
	 */
	@MavlinkEnumEntry(value = 6)
	FAILURE_UNIT_SENSOR_VIO(),
	
	/**
	 * FAILURE_UNIT_SENSOR_DISTANCE_SENSOR
	 */
	@MavlinkEnumEntry(value = 7)
	FAILURE_UNIT_SENSOR_DISTANCE_SENSOR(),
	
	/**
	 * FAILURE_UNIT_SENSOR_AIRSPEED
	 */
	@MavlinkEnumEntry(value = 8)
	FAILURE_UNIT_SENSOR_AIRSPEED(),
	
	/**
	 * FAILURE_UNIT_SYSTEM_BATTERY
	 */
	@MavlinkEnumEntry(value = 100)
	FAILURE_UNIT_SYSTEM_BATTERY(),
	
	/**
	 * FAILURE_UNIT_SYSTEM_MOTOR
	 */
	@MavlinkEnumEntry(value = 101)
	FAILURE_UNIT_SYSTEM_MOTOR(),
	
	/**
	 * FAILURE_UNIT_SYSTEM_SERVO
	 */
	@MavlinkEnumEntry(value = 102)
	FAILURE_UNIT_SYSTEM_SERVO(),
	
	/**
	 * FAILURE_UNIT_SYSTEM_AVOIDANCE
	 */
	@MavlinkEnumEntry(value = 103)
	FAILURE_UNIT_SYSTEM_AVOIDANCE(),
	
	/**
	 * FAILURE_UNIT_SYSTEM_RC_SIGNAL
	 */
	@MavlinkEnumEntry(value = 104)
	FAILURE_UNIT_SYSTEM_RC_SIGNAL(),
	
	/**
	 * FAILURE_UNIT_SYSTEM_MAVLINK_SIGNAL
	 */
	@MavlinkEnumEntry(value = 105)
	FAILURE_UNIT_SYSTEM_MAVLINK_SIGNAL(),
}
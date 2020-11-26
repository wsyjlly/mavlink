package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "MAV_SENSOR_ORIENTATION")
public enum  MavSensorOrientation {
	
	/**
	 * Roll: 0, Pitch: 0, Yaw: 0
	 */
	@MavlinkEnumEntry(value = 0,description = "Roll: 0, Pitch: 0, Yaw: 0")
	MAV_SENSOR_ROTATION_NONE(),
	
	/**
	 * Roll: 0, Pitch: 0, Yaw: 45
	 */
	@MavlinkEnumEntry(value = 1,description = "Roll: 0, Pitch: 0, Yaw: 45")
	MAV_SENSOR_ROTATION_YAW_45(),
	
	/**
	 * Roll: 0, Pitch: 0, Yaw: 90
	 */
	@MavlinkEnumEntry(value = 2,description = "Roll: 0, Pitch: 0, Yaw: 90")
	MAV_SENSOR_ROTATION_YAW_90(),
	
	/**
	 * Roll: 0, Pitch: 0, Yaw: 135
	 */
	@MavlinkEnumEntry(value = 3,description = "Roll: 0, Pitch: 0, Yaw: 135")
	MAV_SENSOR_ROTATION_YAW_135(),
	
	/**
	 * Roll: 0, Pitch: 0, Yaw: 180
	 */
	@MavlinkEnumEntry(value = 4,description = "Roll: 0, Pitch: 0, Yaw: 180")
	MAV_SENSOR_ROTATION_YAW_180(),
	
	/**
	 * Roll: 0, Pitch: 0, Yaw: 225
	 */
	@MavlinkEnumEntry(value = 5,description = "Roll: 0, Pitch: 0, Yaw: 225")
	MAV_SENSOR_ROTATION_YAW_225(),
	
	/**
	 * Roll: 0, Pitch: 0, Yaw: 270
	 */
	@MavlinkEnumEntry(value = 6,description = "Roll: 0, Pitch: 0, Yaw: 270")
	MAV_SENSOR_ROTATION_YAW_270(),
	
	/**
	 * Roll: 0, Pitch: 0, Yaw: 315
	 */
	@MavlinkEnumEntry(value = 7,description = "Roll: 0, Pitch: 0, Yaw: 315")
	MAV_SENSOR_ROTATION_YAW_315(),
	
	/**
	 * Roll: 180, Pitch: 0, Yaw: 0
	 */
	@MavlinkEnumEntry(value = 8,description = "Roll: 180, Pitch: 0, Yaw: 0")
	MAV_SENSOR_ROTATION_ROLL_180(),
	
	/**
	 * Roll: 180, Pitch: 0, Yaw: 45
	 */
	@MavlinkEnumEntry(value = 9,description = "Roll: 180, Pitch: 0, Yaw: 45")
	MAV_SENSOR_ROTATION_ROLL_180_YAW_45(),
	
	/**
	 * Roll: 180, Pitch: 0, Yaw: 90
	 */
	@MavlinkEnumEntry(value = 10,description = "Roll: 180, Pitch: 0, Yaw: 90")
	MAV_SENSOR_ROTATION_ROLL_180_YAW_90(),
	
	/**
	 * Roll: 180, Pitch: 0, Yaw: 135
	 */
	@MavlinkEnumEntry(value = 11,description = "Roll: 180, Pitch: 0, Yaw: 135")
	MAV_SENSOR_ROTATION_ROLL_180_YAW_135(),
	
	/**
	 * Roll: 0, Pitch: 180, Yaw: 0
	 */
	@MavlinkEnumEntry(value = 12,description = "Roll: 0, Pitch: 180, Yaw: 0")
	MAV_SENSOR_ROTATION_PITCH_180(),
	
	/**
	 * Roll: 180, Pitch: 0, Yaw: 225
	 */
	@MavlinkEnumEntry(value = 13,description = "Roll: 180, Pitch: 0, Yaw: 225")
	MAV_SENSOR_ROTATION_ROLL_180_YAW_225(),
	
	/**
	 * Roll: 180, Pitch: 0, Yaw: 270
	 */
	@MavlinkEnumEntry(value = 14,description = "Roll: 180, Pitch: 0, Yaw: 270")
	MAV_SENSOR_ROTATION_ROLL_180_YAW_270(),
	
	/**
	 * Roll: 180, Pitch: 0, Yaw: 315
	 */
	@MavlinkEnumEntry(value = 15,description = "Roll: 180, Pitch: 0, Yaw: 315")
	MAV_SENSOR_ROTATION_ROLL_180_YAW_315(),
	
	/**
	 * Roll: 90, Pitch: 0, Yaw: 0
	 */
	@MavlinkEnumEntry(value = 16,description = "Roll: 90, Pitch: 0, Yaw: 0")
	MAV_SENSOR_ROTATION_ROLL_90(),
	
	/**
	 * Roll: 90, Pitch: 0, Yaw: 45
	 */
	@MavlinkEnumEntry(value = 17,description = "Roll: 90, Pitch: 0, Yaw: 45")
	MAV_SENSOR_ROTATION_ROLL_90_YAW_45(),
	
	/**
	 * Roll: 90, Pitch: 0, Yaw: 90
	 */
	@MavlinkEnumEntry(value = 18,description = "Roll: 90, Pitch: 0, Yaw: 90")
	MAV_SENSOR_ROTATION_ROLL_90_YAW_90(),
	
	/**
	 * Roll: 90, Pitch: 0, Yaw: 135
	 */
	@MavlinkEnumEntry(value = 19,description = "Roll: 90, Pitch: 0, Yaw: 135")
	MAV_SENSOR_ROTATION_ROLL_90_YAW_135(),
	
	/**
	 * Roll: 270, Pitch: 0, Yaw: 0
	 */
	@MavlinkEnumEntry(value = 20,description = "Roll: 270, Pitch: 0, Yaw: 0")
	MAV_SENSOR_ROTATION_ROLL_270(),
	
	/**
	 * Roll: 270, Pitch: 0, Yaw: 45
	 */
	@MavlinkEnumEntry(value = 21,description = "Roll: 270, Pitch: 0, Yaw: 45")
	MAV_SENSOR_ROTATION_ROLL_270_YAW_45(),
	
	/**
	 * Roll: 270, Pitch: 0, Yaw: 90
	 */
	@MavlinkEnumEntry(value = 22,description = "Roll: 270, Pitch: 0, Yaw: 90")
	MAV_SENSOR_ROTATION_ROLL_270_YAW_90(),
	
	/**
	 * Roll: 270, Pitch: 0, Yaw: 135
	 */
	@MavlinkEnumEntry(value = 23,description = "Roll: 270, Pitch: 0, Yaw: 135")
	MAV_SENSOR_ROTATION_ROLL_270_YAW_135(),
	
	/**
	 * Roll: 0, Pitch: 90, Yaw: 0
	 */
	@MavlinkEnumEntry(value = 24,description = "Roll: 0, Pitch: 90, Yaw: 0")
	MAV_SENSOR_ROTATION_PITCH_90(),
	
	/**
	 * Roll: 0, Pitch: 270, Yaw: 0
	 */
	@MavlinkEnumEntry(value = 25,description = "Roll: 0, Pitch: 270, Yaw: 0")
	MAV_SENSOR_ROTATION_PITCH_270(),
	
	/**
	 * Roll: 0, Pitch: 180, Yaw: 90
	 */
	@MavlinkEnumEntry(value = 26,description = "Roll: 0, Pitch: 180, Yaw: 90")
	MAV_SENSOR_ROTATION_PITCH_180_YAW_90(),
	
	/**
	 * Roll: 0, Pitch: 180, Yaw: 270
	 */
	@MavlinkEnumEntry(value = 27,description = "Roll: 0, Pitch: 180, Yaw: 270")
	MAV_SENSOR_ROTATION_PITCH_180_YAW_270(),
	
	/**
	 * Roll: 90, Pitch: 90, Yaw: 0
	 */
	@MavlinkEnumEntry(value = 28,description = "Roll: 90, Pitch: 90, Yaw: 0")
	MAV_SENSOR_ROTATION_ROLL_90_PITCH_90(),
	
	/**
	 * Roll: 180, Pitch: 90, Yaw: 0
	 */
	@MavlinkEnumEntry(value = 29,description = "Roll: 180, Pitch: 90, Yaw: 0")
	MAV_SENSOR_ROTATION_ROLL_180_PITCH_90(),
	
	/**
	 * Roll: 270, Pitch: 90, Yaw: 0
	 */
	@MavlinkEnumEntry(value = 30,description = "Roll: 270, Pitch: 90, Yaw: 0")
	MAV_SENSOR_ROTATION_ROLL_270_PITCH_90(),
	
	/**
	 * Roll: 90, Pitch: 180, Yaw: 0
	 */
	@MavlinkEnumEntry(value = 31,description = "Roll: 90, Pitch: 180, Yaw: 0")
	MAV_SENSOR_ROTATION_ROLL_90_PITCH_180(),
	
	/**
	 * Roll: 270, Pitch: 180, Yaw: 0
	 */
	@MavlinkEnumEntry(value = 32,description = "Roll: 270, Pitch: 180, Yaw: 0")
	MAV_SENSOR_ROTATION_ROLL_270_PITCH_180(),
	
	/**
	 * Roll: 90, Pitch: 270, Yaw: 0
	 */
	@MavlinkEnumEntry(value = 33,description = "Roll: 90, Pitch: 270, Yaw: 0")
	MAV_SENSOR_ROTATION_ROLL_90_PITCH_270(),
	
	/**
	 * Roll: 180, Pitch: 270, Yaw: 0
	 */
	@MavlinkEnumEntry(value = 34,description = "Roll: 180, Pitch: 270, Yaw: 0")
	MAV_SENSOR_ROTATION_ROLL_180_PITCH_270(),
	
	/**
	 * Roll: 270, Pitch: 270, Yaw: 0
	 */
	@MavlinkEnumEntry(value = 35,description = "Roll: 270, Pitch: 270, Yaw: 0")
	MAV_SENSOR_ROTATION_ROLL_270_PITCH_270(),
	
	/**
	 * Roll: 90, Pitch: 180, Yaw: 90
	 */
	@MavlinkEnumEntry(value = 36,description = "Roll: 90, Pitch: 180, Yaw: 90")
	MAV_SENSOR_ROTATION_ROLL_90_PITCH_180_YAW_90(),
	
	/**
	 * Roll: 90, Pitch: 0, Yaw: 270
	 */
	@MavlinkEnumEntry(value = 37,description = "Roll: 90, Pitch: 0, Yaw: 270")
	MAV_SENSOR_ROTATION_ROLL_90_YAW_270(),
	
	/**
	 * Roll: 90, Pitch: 68, Yaw: 293
	 */
	@MavlinkEnumEntry(value = 38,description = "Roll: 90, Pitch: 68, Yaw: 293")
	MAV_SENSOR_ROTATION_ROLL_90_PITCH_68_YAW_293(),
	
	/**
	 * Pitch: 315
	 */
	@MavlinkEnumEntry(value = 39,description = "Pitch: 315")
	MAV_SENSOR_ROTATION_PITCH_315(),
	
	/**
	 * Roll: 90, Pitch: 315
	 */
	@MavlinkEnumEntry(value = 40,description = "Roll: 90, Pitch: 315")
	MAV_SENSOR_ROTATION_ROLL_90_PITCH_315(),
	
	/**
	 * Roll: 270, Yaw: 180
	 */
	@MavlinkEnumEntry(value = 41,description = "Roll: 270, Yaw: 180")
	MAV_SENSOR_ROTATION_ROLL_270_YAW_180(),
	
	/**
	 * Custom orientation
	 */
	@MavlinkEnumEntry(value = 100,description = "Custom orientation")
	MAV_SENSOR_ROTATION_CUSTOM(),
}
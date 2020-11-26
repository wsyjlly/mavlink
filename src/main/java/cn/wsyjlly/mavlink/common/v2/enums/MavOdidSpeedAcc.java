package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "MAV_ODID_SPEED_ACC")
public enum  MavOdidSpeedAcc {
	
	/**
	 * The speed accuracy is unknown.
	 */
	@MavlinkEnumEntry(value = 0,description = "The speed accuracy is unknown.")
	MAV_ODID_SPEED_ACC_UNKNOWN(),
	
	/**
	 * The speed accuracy is smaller than 10 meters per second.
	 */
	@MavlinkEnumEntry(value = 1,description = "The speed accuracy is smaller than 10 meters per second.")
	MAV_ODID_SPEED_ACC_10_METERS_PER_SECOND(),
	
	/**
	 * The speed accuracy is smaller than 3 meters per second.
	 */
	@MavlinkEnumEntry(value = 2,description = "The speed accuracy is smaller than 3 meters per second.")
	MAV_ODID_SPEED_ACC_3_METERS_PER_SECOND(),
	
	/**
	 * The speed accuracy is smaller than 1 meters per second.
	 */
	@MavlinkEnumEntry(value = 3,description = "The speed accuracy is smaller than 1 meters per second.")
	MAV_ODID_SPEED_ACC_1_METERS_PER_SECOND(),
	
	/**
	 * The speed accuracy is smaller than 0.3 meters per second.
	 */
	@MavlinkEnumEntry(value = 4,description = "The speed accuracy is smaller than 0.3 meters per second.")
	MAV_ODID_SPEED_ACC_0_3_METERS_PER_SECOND(),
}
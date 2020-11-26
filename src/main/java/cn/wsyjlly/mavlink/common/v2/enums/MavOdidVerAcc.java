package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "MAV_ODID_VER_ACC")
public enum  MavOdidVerAcc {
	
	/**
	 * The vertical accuracy is unknown.
	 */
	@MavlinkEnumEntry(value = 0,description = "The vertical accuracy is unknown.")
	MAV_ODID_VER_ACC_UNKNOWN(),
	
	/**
	 * The vertical accuracy is smaller than 150 meter.
	 */
	@MavlinkEnumEntry(value = 1,description = "The vertical accuracy is smaller than 150 meter.")
	MAV_ODID_VER_ACC_150_METER(),
	
	/**
	 * The vertical accuracy is smaller than 45 meter.
	 */
	@MavlinkEnumEntry(value = 2,description = "The vertical accuracy is smaller than 45 meter.")
	MAV_ODID_VER_ACC_45_METER(),
	
	/**
	 * The vertical accuracy is smaller than 25 meter.
	 */
	@MavlinkEnumEntry(value = 3,description = "The vertical accuracy is smaller than 25 meter.")
	MAV_ODID_VER_ACC_25_METER(),
	
	/**
	 * The vertical accuracy is smaller than 10 meter.
	 */
	@MavlinkEnumEntry(value = 4,description = "The vertical accuracy is smaller than 10 meter.")
	MAV_ODID_VER_ACC_10_METER(),
	
	/**
	 * The vertical accuracy is smaller than 3 meter.
	 */
	@MavlinkEnumEntry(value = 5,description = "The vertical accuracy is smaller than 3 meter.")
	MAV_ODID_VER_ACC_3_METER(),
	
	/**
	 * The vertical accuracy is smaller than 1 meter.
	 */
	@MavlinkEnumEntry(value = 6,description = "The vertical accuracy is smaller than 1 meter.")
	MAV_ODID_VER_ACC_1_METER(),
}
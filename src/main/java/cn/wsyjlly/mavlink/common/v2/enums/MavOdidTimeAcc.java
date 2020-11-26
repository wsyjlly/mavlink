package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "MAV_ODID_TIME_ACC")
public enum  MavOdidTimeAcc {
	
	/**
	 * The timestamp accuracy is unknown.
	 */
	@MavlinkEnumEntry(value = 0,description = "The timestamp accuracy is unknown.")
	MAV_ODID_TIME_ACC_UNKNOWN(),
	
	/**
	 * The timestamp accuracy is smaller than or equal to 0.1 second.
	 */
	@MavlinkEnumEntry(value = 1,description = "The timestamp accuracy is smaller than or equal to 0.1 second.")
	MAV_ODID_TIME_ACC_0_1_SECOND(),
	
	/**
	 * The timestamp accuracy is smaller than or equal to 0.2 second.
	 */
	@MavlinkEnumEntry(value = 2,description = "The timestamp accuracy is smaller than or equal to 0.2 second.")
	MAV_ODID_TIME_ACC_0_2_SECOND(),
	
	/**
	 * The timestamp accuracy is smaller than or equal to 0.3 second.
	 */
	@MavlinkEnumEntry(value = 3,description = "The timestamp accuracy is smaller than or equal to 0.3 second.")
	MAV_ODID_TIME_ACC_0_3_SECOND(),
	
	/**
	 * The timestamp accuracy is smaller than or equal to 0.4 second.
	 */
	@MavlinkEnumEntry(value = 4,description = "The timestamp accuracy is smaller than or equal to 0.4 second.")
	MAV_ODID_TIME_ACC_0_4_SECOND(),
	
	/**
	 * The timestamp accuracy is smaller than or equal to 0.5 second.
	 */
	@MavlinkEnumEntry(value = 5,description = "The timestamp accuracy is smaller than or equal to 0.5 second.")
	MAV_ODID_TIME_ACC_0_5_SECOND(),
	
	/**
	 * The timestamp accuracy is smaller than or equal to 0.6 second.
	 */
	@MavlinkEnumEntry(value = 6,description = "The timestamp accuracy is smaller than or equal to 0.6 second.")
	MAV_ODID_TIME_ACC_0_6_SECOND(),
	
	/**
	 * The timestamp accuracy is smaller than or equal to 0.7 second.
	 */
	@MavlinkEnumEntry(value = 7,description = "The timestamp accuracy is smaller than or equal to 0.7 second.")
	MAV_ODID_TIME_ACC_0_7_SECOND(),
	
	/**
	 * The timestamp accuracy is smaller than or equal to 0.8 second.
	 */
	@MavlinkEnumEntry(value = 8,description = "The timestamp accuracy is smaller than or equal to 0.8 second.")
	MAV_ODID_TIME_ACC_0_8_SECOND(),
	
	/**
	 * The timestamp accuracy is smaller than or equal to 0.9 second.
	 */
	@MavlinkEnumEntry(value = 9,description = "The timestamp accuracy is smaller than or equal to 0.9 second.")
	MAV_ODID_TIME_ACC_0_9_SECOND(),
	
	/**
	 * The timestamp accuracy is smaller than or equal to 1.0 second.
	 */
	@MavlinkEnumEntry(value = 10,description = "The timestamp accuracy is smaller than or equal to 1.0 second.")
	MAV_ODID_TIME_ACC_1_0_SECOND(),
	
	/**
	 * The timestamp accuracy is smaller than or equal to 1.1 second.
	 */
	@MavlinkEnumEntry(value = 11,description = "The timestamp accuracy is smaller than or equal to 1.1 second.")
	MAV_ODID_TIME_ACC_1_1_SECOND(),
	
	/**
	 * The timestamp accuracy is smaller than or equal to 1.2 second.
	 */
	@MavlinkEnumEntry(value = 12,description = "The timestamp accuracy is smaller than or equal to 1.2 second.")
	MAV_ODID_TIME_ACC_1_2_SECOND(),
	
	/**
	 * The timestamp accuracy is smaller than or equal to 1.3 second.
	 */
	@MavlinkEnumEntry(value = 13,description = "The timestamp accuracy is smaller than or equal to 1.3 second.")
	MAV_ODID_TIME_ACC_1_3_SECOND(),
	
	/**
	 * The timestamp accuracy is smaller than or equal to 1.4 second.
	 */
	@MavlinkEnumEntry(value = 14,description = "The timestamp accuracy is smaller than or equal to 1.4 second.")
	MAV_ODID_TIME_ACC_1_4_SECOND(),
	
	/**
	 * The timestamp accuracy is smaller than or equal to 1.5 second.
	 */
	@MavlinkEnumEntry(value = 15,description = "The timestamp accuracy is smaller than or equal to 1.5 second.")
	MAV_ODID_TIME_ACC_1_5_SECOND(),
}
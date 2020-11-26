package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "MAV_ODID_HOR_ACC")
public enum  MavOdidHorAcc {
	
	/**
	 * The horizontal accuracy is unknown.
	 */
	@MavlinkEnumEntry(value = 0,description = "The horizontal accuracy is unknown.")
	MAV_ODID_HOR_ACC_UNKNOWN(),
	
	/**
	 * The horizontal accuracy is smaller than 10 Nautical Miles. 18.52 km.
	 */
	@MavlinkEnumEntry(value = 1,description = "The horizontal accuracy is smaller than 10 Nautical Miles. 18.52 km.")
	MAV_ODID_HOR_ACC_10NM(),
	
	/**
	 * The horizontal accuracy is smaller than 4 Nautical Miles. 7.408 km.
	 */
	@MavlinkEnumEntry(value = 2,description = "The horizontal accuracy is smaller than 4 Nautical Miles. 7.408 km.")
	MAV_ODID_HOR_ACC_4NM(),
	
	/**
	 * The horizontal accuracy is smaller than 2 Nautical Miles. 3.704 km.
	 */
	@MavlinkEnumEntry(value = 3,description = "The horizontal accuracy is smaller than 2 Nautical Miles. 3.704 km.")
	MAV_ODID_HOR_ACC_2NM(),
	
	/**
	 * The horizontal accuracy is smaller than 1 Nautical Miles. 1.852 km.
	 */
	@MavlinkEnumEntry(value = 4,description = "The horizontal accuracy is smaller than 1 Nautical Miles. 1.852 km.")
	MAV_ODID_HOR_ACC_1NM(),
	
	/**
	 * The horizontal accuracy is smaller than 0.5 Nautical Miles. 926 m.
	 */
	@MavlinkEnumEntry(value = 5,description = "The horizontal accuracy is smaller than 0.5 Nautical Miles. 926 m.")
	MAV_ODID_HOR_ACC_0_5NM(),
	
	/**
	 * The horizontal accuracy is smaller than 0.3 Nautical Miles. 555.6 m.
	 */
	@MavlinkEnumEntry(value = 6,description = "The horizontal accuracy is smaller than 0.3 Nautical Miles. 555.6 m.")
	MAV_ODID_HOR_ACC_0_3NM(),
	
	/**
	 * The horizontal accuracy is smaller than 0.1 Nautical Miles. 185.2 m.
	 */
	@MavlinkEnumEntry(value = 7,description = "The horizontal accuracy is smaller than 0.1 Nautical Miles. 185.2 m.")
	MAV_ODID_HOR_ACC_0_1NM(),
	
	/**
	 * The horizontal accuracy is smaller than 0.05 Nautical Miles. 92.6 m.
	 */
	@MavlinkEnumEntry(value = 8,description = "The horizontal accuracy is smaller than 0.05 Nautical Miles. 92.6 m.")
	MAV_ODID_HOR_ACC_0_05NM(),
	
	/**
	 * The horizontal accuracy is smaller than 30 meter.
	 */
	@MavlinkEnumEntry(value = 9,description = "The horizontal accuracy is smaller than 30 meter.")
	MAV_ODID_HOR_ACC_30_METER(),
	
	/**
	 * The horizontal accuracy is smaller than 10 meter.
	 */
	@MavlinkEnumEntry(value = 10,description = "The horizontal accuracy is smaller than 10 meter.")
	MAV_ODID_HOR_ACC_10_METER(),
	
	/**
	 * The horizontal accuracy is smaller than 3 meter.
	 */
	@MavlinkEnumEntry(value = 11,description = "The horizontal accuracy is smaller than 3 meter.")
	MAV_ODID_HOR_ACC_3_METER(),
	
	/**
	 * The horizontal accuracy is smaller than 1 meter.
	 */
	@MavlinkEnumEntry(value = 12,description = "The horizontal accuracy is smaller than 1 meter.")
	MAV_ODID_HOR_ACC_1_METER(),
}
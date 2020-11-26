package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "MAV_MISSION_TYPE")
public enum  MavMissionType {
	
	/**
	 * Items are mission commands for main mission.
	 */
	@MavlinkEnumEntry(value = 0,description = "Items are mission commands for main mission.")
	MAV_MISSION_TYPE_MISSION(),
	
	/**
	 * Specifies GeoFence area(s). Items are MAV_CMD_NAV_FENCE_ GeoFence items.
	 */
	@MavlinkEnumEntry(value = 1,description = "Specifies GeoFence area(s). Items are MAV_CMD_NAV_FENCE_ GeoFence items.")
	MAV_MISSION_TYPE_FENCE(),
	
	/**
	 * Specifies the rally points for the vehicle. Rally points are alternative RTL points. Items are MAV_CMD_NAV_RALLY_POINT rally point items.
	 */
	@MavlinkEnumEntry(value = 2,description = "Specifies the rally points for the vehicle. Rally points are alternative RTL points. Items are MAV_CMD_NAV_RALLY_POINT rally point items.")
	MAV_MISSION_TYPE_RALLY(),
	
	/**
	 * Only used in MISSION_CLEAR_ALL to clear all mission types.
	 */
	@MavlinkEnumEntry(value = 255,description = "Only used in MISSION_CLEAR_ALL to clear all mission types.")
	MAV_MISSION_TYPE_ALL(),
}
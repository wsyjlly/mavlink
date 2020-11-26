package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "MAV_ARM_AUTH_DENIED_REASON")
public enum  MavArmAuthDeniedReason {
	
	/**
	 * Not a specific reason
	 */
	@MavlinkEnumEntry(value = 0,description = "Not a specific reason")
	MAV_ARM_AUTH_DENIED_REASON_GENERIC(),
	
	/**
	 * Authorizer will send the error as string to GCS
	 */
	@MavlinkEnumEntry(value = 1,description = "Authorizer will send the error as string to GCS")
	MAV_ARM_AUTH_DENIED_REASON_NONE(),
	
	/**
	 * At least one waypoint have a invalid value
	 */
	@MavlinkEnumEntry(value = 2,description = "At least one waypoint have a invalid value")
	MAV_ARM_AUTH_DENIED_REASON_INVALID_WAYPOINT(),
	
	/**
	 * Timeout in the authorizer process(in case it depends on network)
	 */
	@MavlinkEnumEntry(value = 3,description = "Timeout in the authorizer process(in case it depends on network)")
	MAV_ARM_AUTH_DENIED_REASON_TIMEOUT(),
	
	/**
	 * Airspace of the mission in use by another vehicle, second result parameter can have the waypoint id that caused it to be denied.
	 */
	@MavlinkEnumEntry(value = 4,description = "Airspace of the mission in use by another vehicle, second result parameter can have the waypoint id that caused it to be denied.")
	MAV_ARM_AUTH_DENIED_REASON_AIRSPACE_IN_USE(),
	
	/**
	 * Weather is not good to fly
	 */
	@MavlinkEnumEntry(value = 5,description = "Weather is not good to fly")
	MAV_ARM_AUTH_DENIED_REASON_BAD_WEATHER(),
}
package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "VTOL_TRANSITION_HEADING")
public enum  VtolTransitionHeading {
	
	/**
	 * Respect the heading configuration of the vehicle.
	 */
	@MavlinkEnumEntry(value = 0,description = "Respect the heading configuration of the vehicle.")
	VTOL_TRANSITION_HEADING_VEHICLE_DEFAULT(),
	
	/**
	 * Use the heading pointing towards the next waypoint.
	 */
	@MavlinkEnumEntry(value = 1,description = "Use the heading pointing towards the next waypoint.")
	VTOL_TRANSITION_HEADING_NEXT_WAYPOINT(),
	
	/**
	 * Use the heading on takeoff (while sitting on the ground).
	 */
	@MavlinkEnumEntry(value = 2,description = "Use the heading on takeoff (while sitting on the ground).")
	VTOL_TRANSITION_HEADING_TAKEOFF(),
	
	/**
	 * Use the specified heading in parameter 4.
	 */
	@MavlinkEnumEntry(value = 3,description = "Use the specified heading in parameter 4.")
	VTOL_TRANSITION_HEADING_SPECIFIED(),
	
	/**
	 * Use the current heading when reaching takeoff altitude (potentially facing the wind when weather-vaning is active).
	 */
	@MavlinkEnumEntry(value = 4,description = "Use the current heading when reaching takeoff altitude (potentially facing the wind when weather-vaning is active).")
	VTOL_TRANSITION_HEADING_ANY(),
}
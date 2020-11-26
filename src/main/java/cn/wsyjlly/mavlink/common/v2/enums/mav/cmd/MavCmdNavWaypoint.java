package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 16, name = "MAV_CMD_NAV_WAYPOINT", hasLocation = "true", isDestination = "true", description = "Navigate to waypoint.")
public enum MavCmdNavWaypoint {

	/**
	 * Hold time. (ignored by fixed wing, time to stay at waypoint for rotary wing)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Hold", units = "s", minValue = 0)
	PARAM_1(),

	/**
	 * Acceptance radius (if the sphere with this radius is hit, the waypoint counts as reached)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Accept Radius", units = "m", minValue = 0)
	PARAM_2(),

	/**
	 * 0 to pass through the WP, if gt 0 radius to pass by WP. Positive value for clockwise orbit, negative value for counter-clockwise orbit. Allows trajectory control.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, label = "Pass Radius", units = "m")
	PARAM_3(),

	/**
	 * Desired yaw angle at waypoint (rotary wing). NaN to use the current system yaw heading mode (e.g. yaw towards next waypoint, yaw to home, etc.).
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4, label = "Yaw", units = "deg")
	PARAM_4(),

	/**
	 * Latitude
	 */
	@MavlinkEnumMavCmdEntryParam(index = 5, label = "Latitude")
	PARAM_5(),

	/**
	 * Longitude
	 */
	@MavlinkEnumMavCmdEntryParam(index = 6, label = "Longitude")
	PARAM_6(),

	/**
	 * Altitude
	 */
	@MavlinkEnumMavCmdEntryParam(index = 7, label = "Altitude", units = "m")
	PARAM_7(),
}
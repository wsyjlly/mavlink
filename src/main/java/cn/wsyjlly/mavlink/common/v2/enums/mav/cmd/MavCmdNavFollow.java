package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 25, name = "MAV_CMD_NAV_FOLLOW", hasLocation = "true", isDestination = "false", description = "Vehicle following, i.e. this waypoint represents the position of a moving vehicle")
public enum MavCmdNavFollow {

	/**
	 * Following logic to use (e.g. loitering or sinusoidal following) - depends on specific autopilot implementation
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Following", increment = 1)
	PARAM_1(),

	/**
	 * Ground speed of vehicle to be followed
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Ground Speed", units = "m/s")
	PARAM_2(),

	/**
	 * Radius around waypoint. If positive loiter clockwise, else counter-clockwise
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, label = "Radius", units = "m")
	PARAM_3(),

	/**
	 * Desired yaw angle.
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
package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 17, name = "MAV_CMD_NAV_LOITER_UNLIM", hasLocation = "true", isDestination = "true", description = "Loiter around this waypoint an unlimited amount of time")
public enum MavCmdNavLoiterUnlim {

	/**
	 * Empty
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1)
	PARAM_1(),

	/**
	 * Empty
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2)
	PARAM_2(),

	/**
	 * Loiter radius around waypoint for forward-only moving vehicles (not multicopters). If positive loiter clockwise, else counter-clockwise
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, label = "Radius", units = "m")
	PARAM_3(),

	/**
	 * Desired yaw angle. NaN to use the current system yaw heading mode (e.g. yaw towards next waypoint, yaw to home, etc.).
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
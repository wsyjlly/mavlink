package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 22, name = "MAV_CMD_NAV_TAKEOFF", hasLocation = "true", isDestination = "true", description = "Takeoff from ground / hand. Vehicles that support multiple takeoff modes (e.g. VTOL quadplane) should take off using the currently configured mode.")
public enum MavCmdNavTakeoff {

	/**
	 * Minimum pitch (if airspeed sensor present), desired pitch without sensor
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Pitch", units = "deg")
	PARAM_1(),

	/**
	 * Empty
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2)
	PARAM_2(),

	/**
	 * Empty
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3)
	PARAM_3(),

	/**
	 * Yaw angle (if magnetometer present), ignored without magnetometer. NaN to use the current system yaw heading mode (e.g. yaw towards next waypoint, yaw to home, etc.).
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
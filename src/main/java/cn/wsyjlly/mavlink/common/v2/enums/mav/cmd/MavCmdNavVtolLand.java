package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 85, name = "MAV_CMD_NAV_VTOL_LAND", hasLocation = "true", isDestination = "true", description = "Land using VTOL mode")
public enum MavCmdNavVtolLand {

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
	 * Approach altitude (with the same reference as the Altitude field). NaN if unspecified.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, label = "Approach Altitude", units = "m")
	PARAM_3(),

	/**
	 * Yaw angle. NaN to use the current system yaw heading mode (e.g. yaw towards next waypoint, yaw to home, etc.).
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
	 * Altitude (ground level)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 7, label = "Ground Altitude", units = "m")
	PARAM_7(),
}
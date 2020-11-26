package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 24, name = "MAV_CMD_NAV_TAKEOFF_LOCAL", hasLocation = "true", isDestination = "true", description = "Takeoff from local position (local frame only)")
public enum MavCmdNavTakeoffLocal {

	/**
	 * Minimum pitch (if airspeed sensor present), desired pitch without sensor
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Pitch", units = "rad")
	PARAM_1(),

	/**
	 * Empty
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2)
	PARAM_2(),

	/**
	 * Takeoff ascend rate
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, label = "Ascend Rate", units = "m/s")
	PARAM_3(),

	/**
	 * Yaw angle (if magnetometer or another yaw estimation source present), ignored without one of these
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4, label = "Yaw", units = "rad")
	PARAM_4(),

	/**
	 * Y-axis position
	 */
	@MavlinkEnumMavCmdEntryParam(index = 5, label = "Y Position", units = "m")
	PARAM_5(),

	/**
	 * X-axis position
	 */
	@MavlinkEnumMavCmdEntryParam(index = 6, label = "X Position", units = "m")
	PARAM_6(),

	/**
	 * Z-axis position
	 */
	@MavlinkEnumMavCmdEntryParam(index = 7, label = "Z Position", units = "m")
	PARAM_7(),
}
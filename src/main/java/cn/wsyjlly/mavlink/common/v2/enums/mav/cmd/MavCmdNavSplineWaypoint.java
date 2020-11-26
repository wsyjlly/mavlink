package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 82, name = "MAV_CMD_NAV_SPLINE_WAYPOINT", hasLocation = "true", isDestination = "true", description = "Navigate to waypoint using a spline path.")
public enum MavCmdNavSplineWaypoint {

	/**
	 * Hold time. (ignored by fixed wing, time to stay at waypoint for rotary wing)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Hold", units = "s", minValue = 0)
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
	 * Empty
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4)
	PARAM_4(),

	/**
	 * Latitude/X of goal
	 */
	@MavlinkEnumMavCmdEntryParam(index = 5, label = "Latitude/X")
	PARAM_5(),

	/**
	 * Longitude/Y of goal
	 */
	@MavlinkEnumMavCmdEntryParam(index = 6, label = "Longitude/Y")
	PARAM_6(),

	/**
	 * Altitude/Z of goal
	 */
	@MavlinkEnumMavCmdEntryParam(index = 7, label = "Altitude/Z")
	PARAM_7(),
}
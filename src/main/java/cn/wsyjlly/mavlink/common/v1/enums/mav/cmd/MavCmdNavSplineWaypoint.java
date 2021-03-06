package cn.wsyjlly.mavlink.common.v1.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:45
 **********************************/

@MavlinkEnumMavCmdEntry(value = 82, name = "MAV_CMD_NAV_SPLINE_WAYPOINT", hasLocation = "null", isDestination = "null", description = "Navigate to MISSION using a spline path.")
public enum MavCmdNavSplineWaypoint {

	/**
	 * Hold time in decimal seconds. (ignored by fixed wing, time to stay at MISSION for rotary wing)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1)
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
	@MavlinkEnumMavCmdEntryParam(index = 5)
	PARAM_5(),

	/**
	 * Longitude/Y of goal
	 */
	@MavlinkEnumMavCmdEntryParam(index = 6)
	PARAM_6(),

	/**
	 * Altitude/Z of goal
	 */
	@MavlinkEnumMavCmdEntryParam(index = 7)
	PARAM_7(),
}
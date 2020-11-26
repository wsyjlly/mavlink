package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 81, name = "MAV_CMD_NAV_PATHPLANNING", hasLocation = "true", isDestination = "true", description = "Control autonomous path planning on the MAV.")
public enum MavCmdNavPathplanning {

	/**
	 * 0: Disable local obstacle avoidance / local path planning (without resetting map), 1: Enable local path planning, 2: Enable and reset local path planning
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Local Ctrl", minValue = 0, maxValue = 2, increment = 1)
	PARAM_1(),

	/**
	 * 0: Disable full path planning (without resetting map), 1: Enable, 2: Enable and reset map/occupancy grid, 3: Enable and reset planned route, but not occupancy grid
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Global Ctrl", minValue = 0, maxValue = 3, increment = 1)
	PARAM_2(),

	/**
	 * Empty
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3)
	PARAM_3(),

	/**
	 * Yaw angle at goal
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4, label = "Yaw", units = "deg")
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
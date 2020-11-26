package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 115, name = "MAV_CMD_CONDITION_YAW", hasLocation = "false", isDestination = "false", description = "Reach a certain target angle.")
public enum MavCmdConditionYaw {

	/**
	 * target angle, 0 is north
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Angle", units = "deg")
	PARAM_1(),

	/**
	 * angular speed
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Angular Speed", units = "deg/s")
	PARAM_2(),

	/**
	 * direction: -1: counter clockwise, 1: clockwise
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, label = "Direction", minValue = -1, maxValue = 1, increment = 2)
	PARAM_3(),

	/**
	 * 0: absolute angle, 1: relative offset
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4, label = "Relative", minValue = 0, maxValue = 1, increment = 1)
	PARAM_4(),

	/**
	 * Empty
	 */
	@MavlinkEnumMavCmdEntryParam(index = 5)
	PARAM_5(),

	/**
	 * Empty
	 */
	@MavlinkEnumMavCmdEntryParam(index = 6)
	PARAM_6(),

	/**
	 * Empty
	 */
	@MavlinkEnumMavCmdEntryParam(index = 7)
	PARAM_7(),
}
package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 177, name = "MAV_CMD_DO_JUMP", hasLocation = "false", isDestination = "false", description = "Jump to the desired command in the mission list. Repeat this action only the specified number of times")
public enum MavCmdDoJump {

	/**
	 * Sequence number
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Number", minValue = 0, increment = 1)
	PARAM_1(),

	/**
	 * Repeat count
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Repeat", minValue = 0, increment = 1)
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
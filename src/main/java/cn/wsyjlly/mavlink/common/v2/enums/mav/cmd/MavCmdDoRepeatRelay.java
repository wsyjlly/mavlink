package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 182, name = "MAV_CMD_DO_REPEAT_RELAY", hasLocation = "false", isDestination = "false", description = "Cycle a relay on and off for a desired number of cycles with a desired period.")
public enum MavCmdDoRepeatRelay {

	/**
	 * Relay instance number.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Instance", minValue = 0, increment = 1)
	PARAM_1(),

	/**
	 * Cycle count.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Count", minValue = 1, increment = 1)
	PARAM_2(),

	/**
	 * Cycle time.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, label = "Time", units = "s", minValue = 0)
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
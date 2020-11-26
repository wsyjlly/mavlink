package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 93, name = "MAV_CMD_NAV_DELAY", hasLocation = "false", isDestination = "false", description = "Delay the next navigation command a number of seconds or until a specified time")
public enum MavCmdNavDelay {

	/**
	 * Delay (-1 to enable time-of-day fields)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Delay", units = "s", minValue = -1, increment = 1)
	PARAM_1(),

	/**
	 * hour (24h format, UTC, -1 to ignore)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Hour", minValue = -1, maxValue = 23, increment = 1)
	PARAM_2(),

	/**
	 * minute (24h format, UTC, -1 to ignore)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, label = "Minute", minValue = -1, maxValue = 59, increment = 1)
	PARAM_3(),

	/**
	 * second (24h format, UTC, -1 to ignore)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4, label = "Second", minValue = -1, maxValue = 59, increment = 1)
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
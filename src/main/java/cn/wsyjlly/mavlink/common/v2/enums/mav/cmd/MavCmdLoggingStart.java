package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 2510, name = "MAV_CMD_LOGGING_START", hasLocation = "false", isDestination = "false", description = "Request to start streaming logging data over MAVLink (see also LOGGING_DATA message)")
public enum MavCmdLoggingStart {

	/**
	 * Format: 0: ULog
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Format", minValue = 0, increment = 1)
	PARAM_1(),

	/**
	 * Reserved (set to 0)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2)
	PARAM_2(),

	/**
	 * Reserved (set to 0)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3)
	PARAM_3(),

	/**
	 * Reserved (set to 0)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4)
	PARAM_4(),

	/**
	 * Reserved (set to 0)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 5)
	PARAM_5(),

	/**
	 * Reserved (set to 0)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 6)
	PARAM_6(),

	/**
	 * Reserved (set to 0)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 7)
	PARAM_7(),
}
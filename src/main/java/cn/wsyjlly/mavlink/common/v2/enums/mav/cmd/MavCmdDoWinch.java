package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;
import cn.wsyjlly.mavlink.common.v2.enums.WinchActions;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 42600, name = "MAV_CMD_DO_WINCH", hasLocation = "false", isDestination = "false", description = "Command to operate winch.")
public enum MavCmdDoWinch {

	/**
	 * Winch instance number.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Instance", minValue = 1, increment = 1)
	PARAM_1(),

	/**
	 * Action to perform.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Action", enum0 = WinchActions.class)
	PARAM_2(),

	/**
	 * Length of cable to release (negative to wind).
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, label = "Length", units = "m")
	PARAM_3(),

	/**
	 * Release rate (negative to wind).
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4, label = "Rate", units = "m/s")
	PARAM_4(),

	/**
	 * Empty.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 5)
	PARAM_5(),

	/**
	 * Empty.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 6)
	PARAM_6(),

	/**
	 * Empty.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 7)
	PARAM_7(),
}
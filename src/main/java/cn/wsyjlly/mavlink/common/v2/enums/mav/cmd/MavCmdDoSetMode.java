package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;
import cn.wsyjlly.mavlink.common.v2.enums.MavMode;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 176, name = "MAV_CMD_DO_SET_MODE", hasLocation = "false", isDestination = "false", description = "Set system mode.")
public enum MavCmdDoSetMode {

	/**
	 * Mode
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Mode", enum0 = MavMode.class)
	PARAM_1(),

	/**
	 * Custom mode - this is system specific, please refer to the individual autopilot specifications for details.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Custom Mode")
	PARAM_2(),

	/**
	 * Custom sub mode - this is system specific, please refer to the individual autopilot specifications for details.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, label = "Custom Submode")
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
package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 2003, name = "MAV_CMD_DO_TRIGGER_CONTROL", hasLocation = "false", isDestination = "false", description = "Enable or disable on-board camera triggering system.")
public enum MavCmdDoTriggerControl {

	/**
	 * Trigger enable/disable (0 for disable, 1 for start), -1 to ignore
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Enable", minValue = -1, maxValue = 1, increment = 1)
	PARAM_1(),

	/**
	 * 1 to reset the trigger sequence, -1 or 0 to ignore
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Reset", minValue = -1, maxValue = 1, increment = 1)
	PARAM_2(),

	/**
	 * 1 to pause triggering, but without switching the camera off or retracting it. -1 to ignore
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, label = "Pause", minValue = -1, maxValue = 1, increment = 2)
	PARAM_3(),
}
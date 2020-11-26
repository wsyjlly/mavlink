package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 529, name = "MAV_CMD_RESET_CAMERA_SETTINGS", hasLocation = "false", isDestination = "false", description = "Reset all camera settings to Factory Default")
public enum MavCmdResetCameraSettings {

	/**
	 * 0: No Action 1: Reset all settings
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Reset", minValue = 0, maxValue = 1, increment = 1)
	PARAM_1(),

	/**
	 * Reserved (all remaining params)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2)
	PARAM_2(),
}
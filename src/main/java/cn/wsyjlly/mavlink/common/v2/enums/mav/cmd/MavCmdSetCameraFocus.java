package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;
import cn.wsyjlly.mavlink.common.v2.enums.SetFocusType;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 532, name = "MAV_CMD_SET_CAMERA_FOCUS", hasLocation = "false", isDestination = "false", description = "Set camera focus. Camera must respond with a CAMERA_SETTINGS message (on success).")
public enum MavCmdSetCameraFocus {

	/**
	 * Focus type
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Focus Type", enum0 = SetFocusType.class)
	PARAM_1(),

	/**
	 * Focus value
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Focus Value")
	PARAM_2(),

	/**
	 * 
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, reserved = "true", default0 = "NaN")
	PARAM_3(),

	/**
	 * 
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4, reserved = "true", default0 = "NaN")
	PARAM_4(),
}
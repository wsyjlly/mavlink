package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 521, name = "MAV_CMD_REQUEST_CAMERA_INFORMATION", hasLocation = "false", isDestination = "false", description = "Request camera information (CAMERA_INFORMATION).")
public enum MavCmdRequestCameraInformation {

	/**
	 * 0: No action 1: Request camera capabilities
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Capabilities", minValue = 0, maxValue = 1, increment = 1)
	PARAM_1(),

	/**
	 * Reserved (all remaining params)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2)
	PARAM_2(),
}
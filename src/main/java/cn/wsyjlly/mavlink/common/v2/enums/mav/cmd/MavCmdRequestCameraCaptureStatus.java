package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 527, name = "MAV_CMD_REQUEST_CAMERA_CAPTURE_STATUS", hasLocation = "false", isDestination = "false", description = "Request camera capture status (CAMERA_CAPTURE_STATUS)")
public enum MavCmdRequestCameraCaptureStatus {

	/**
	 * 0: No Action 1: Request camera capture status
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Capture Status", minValue = 0, maxValue = 1, increment = 1)
	PARAM_1(),

	/**
	 * Reserved (all remaining params)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2)
	PARAM_2(),
}
package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 2002, name = "MAV_CMD_REQUEST_CAMERA_IMAGE_CAPTURE", hasLocation = "false", isDestination = "false", description = "Re-request a CAMERA_IMAGE_CAPTURED message.")
public enum MavCmdRequestCameraImageCapture {

	/**
	 * Sequence number for missing CAMERA_IMAGE_CAPTURED message
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Number", minValue = 0, increment = 1)
	PARAM_1(),

	/**
	 * 
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, reserved = "true", default0 = "NaN")
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
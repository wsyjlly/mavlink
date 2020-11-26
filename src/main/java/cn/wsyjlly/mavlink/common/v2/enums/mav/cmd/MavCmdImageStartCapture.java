package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 2000, name = "MAV_CMD_IMAGE_START_CAPTURE", hasLocation = "false", isDestination = "false", description = "Start image capture sequence. Sends CAMERA_IMAGE_CAPTURED after each capture. Use NaN for reserved values.")
public enum MavCmdImageStartCapture {

	/**
	 * Reserved (Set to 0)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1)
	PARAM_1(),

	/**
	 * Desired elapsed time between two consecutive pictures (in seconds). Minimum values depend on hardware (typically greater than 2 seconds).
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Interval", units = "s", minValue = 0)
	PARAM_2(),

	/**
	 * Total number of images to capture. 0 to capture forever/until MAV_CMD_IMAGE_STOP_CAPTURE.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, label = "Total Images", minValue = 0, increment = 1)
	PARAM_3(),

	/**
	 * Capture sequence number starting from 1. This is only valid for single-capture (param3 == 1), otherwise set to 0. Increment the capture ID for each capture command to prevent double captures when a command is re-transmitted.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4, label = "Sequence Number", minValue = 1, increment = 1)
	PARAM_4(),

	/**
	 * 
	 */
	@MavlinkEnumMavCmdEntryParam(index = 5, reserved = "true", default0 = "NaN")
	PARAM_5(),

	/**
	 * 
	 */
	@MavlinkEnumMavCmdEntryParam(index = 6, reserved = "true", default0 = "NaN")
	PARAM_6(),

	/**
	 * 
	 */
	@MavlinkEnumMavCmdEntryParam(index = 7, reserved = "true", default0 = "NaN")
	PARAM_7(),
}
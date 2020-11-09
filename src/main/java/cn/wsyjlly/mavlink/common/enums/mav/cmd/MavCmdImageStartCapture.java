package cn.wsyjlly.mavlink.common.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.09 - 03:37
 **********************************/

@MavlinkEnumMavCmdEntry(value = 2000, name = "MAV_CMD_IMAGE_START_CAPTURE", hasLocation = "null", isDestination = "null", description = "Start image capture sequence")
public enum MavCmdImageStartCapture {

	/**
	 * Duration between two consecutive pictures (in seconds)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1)
	PARAM_1(),

	/**
	 * Number of images to capture total - 0 for unlimited capture
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2)
	PARAM_2(),

	/**
	 * Resolution in megapixels (0.3 for 640x480, 1.3 for 1280x720, etc)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3)
	PARAM_3(),
}
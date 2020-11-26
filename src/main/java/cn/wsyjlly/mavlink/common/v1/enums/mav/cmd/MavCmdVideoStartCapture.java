package cn.wsyjlly.mavlink.common.v1.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:45
 **********************************/

@MavlinkEnumMavCmdEntry(value = 2500, name = "MAV_CMD_VIDEO_START_CAPTURE", hasLocation = "null", isDestination = "null", description = "Starts video capture")
public enum MavCmdVideoStartCapture {

	/**
	 * Camera ID (0 for all cameras), 1 for first, 2 for second, etc.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1)
	PARAM_1(),

	/**
	 * Frames per second
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2)
	PARAM_2(),

	/**
	 * Resolution in megapixels (0.3 for 640x480, 1.3 for 1280x720, etc)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3)
	PARAM_3(),
}
package cn.swyan.mavlink.common.enums.mav.cmd;

import cn.swyan.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.swyan.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * @Author YSW
 * @Description
 * @Date 2020.11.04 - 03:56
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
package cn.swyan.mavlink.common.enums.mav.cmd;

import cn.swyan.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.swyan.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * @Author YSW
 * @Description
 * @Date 2020.11.04 - 03:56
 **********************************/

@MavlinkEnumMavCmdEntry(value = 2501, name = "MAV_CMD_VIDEO_STOP_CAPTURE", hasLocation = "null", isDestination = "null", description = "Stop the current video capture")
public enum MavCmdVideoStopCapture {

	/**
	 * Reserved
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1)
	PARAM_1(),

	/**
	 * Reserved
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2)
	PARAM_2(),
}
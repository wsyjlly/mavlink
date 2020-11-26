package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 2503, name = "MAV_CMD_VIDEO_STOP_STREAMING", hasLocation = "false", isDestination = "false", description = "Stop the given video stream")
public enum MavCmdVideoStopStreaming {

	/**
	 * Video Stream ID (0 for all streams, 1 for first, 2 for second, etc.)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Stream ID", minValue = 0, increment = 1)
	PARAM_1(),
}
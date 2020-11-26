package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 2501, name = "MAV_CMD_VIDEO_STOP_CAPTURE", hasLocation = "false", isDestination = "false", description = "Stop the current video capture (recording).")
public enum MavCmdVideoStopCapture {

	/**
	 * Video Stream ID (0 for all streams)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Stream ID", minValue = 0, increment = 1)
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
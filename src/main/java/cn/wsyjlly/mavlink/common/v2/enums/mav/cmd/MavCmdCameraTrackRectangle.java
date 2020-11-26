package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 2005, name = "MAV_CMD_CAMERA_TRACK_RECTANGLE", hasLocation = "false", isDestination = "false", description = "If the camera supports rectangle visual tracking (CAMERA_CAP_FLAGS_HAS_TRACKING_RECTANGLE is set), this command allows to initiate the tracking.")
public enum MavCmdCameraTrackRectangle {

	/**
	 * Top left corner of rectangle x value (normalized 0..1, 0 is left, 1 is right).
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Top left corner x", minValue = 0, maxValue = 1)
	PARAM_1(),

	/**
	 * Top left corner of rectangle y value (normalized 0..1, 0 is top, 1 is bottom).
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Top left corner y", minValue = 0, maxValue = 1)
	PARAM_2(),

	/**
	 * Bottom right corner of rectangle x value (normalized 0..1, 0 is left, 1 is right).
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, label = "Bottom right corner x", minValue = 0, maxValue = 1)
	PARAM_3(),

	/**
	 * Bottom right corner of rectangle y value (normalized 0..1, 0 is top, 1 is bottom).
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4, label = "Bottom right corner y", minValue = 0, maxValue = 1)
	PARAM_4(),
}
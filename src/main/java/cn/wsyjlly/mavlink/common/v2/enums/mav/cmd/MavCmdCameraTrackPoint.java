package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 2004, name = "MAV_CMD_CAMERA_TRACK_POINT", hasLocation = "false", isDestination = "false", description = "If the camera supports point visual tracking (CAMERA_CAP_FLAGS_HAS_TRACKING_POINT is set), this command allows to initiate the tracking.")
public enum MavCmdCameraTrackPoint {

	/**
	 * Point to track x value (normalized 0..1, 0 is left, 1 is right).
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Point x", minValue = 0, maxValue = 1)
	PARAM_1(),

	/**
	 * Point to track y value (normalized 0..1, 0 is top, 1 is bottom).
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Point y", minValue = 0, maxValue = 1)
	PARAM_2(),

	/**
	 * Point radius (normalized 0..1, 0 is image left, 1 is image right).
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, label = "Radius", minValue = 0, maxValue = 1)
	PARAM_3(),
}
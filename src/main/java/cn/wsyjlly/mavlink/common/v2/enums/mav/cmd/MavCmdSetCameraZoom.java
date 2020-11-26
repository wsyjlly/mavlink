package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;
import cn.wsyjlly.mavlink.common.v2.enums.CameraZoomType;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 531, name = "MAV_CMD_SET_CAMERA_ZOOM", hasLocation = "false", isDestination = "false", description = "Set camera zoom. Camera must respond with a CAMERA_SETTINGS message (on success).")
public enum MavCmdSetCameraZoom {

	/**
	 * Zoom type
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Zoom Type", enum0 = CameraZoomType.class)
	PARAM_1(),

	/**
	 * Zoom value. The range of valid values depend on the zoom type.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Zoom Value")
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
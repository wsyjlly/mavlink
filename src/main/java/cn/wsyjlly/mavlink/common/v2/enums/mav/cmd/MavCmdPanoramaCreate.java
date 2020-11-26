package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 2800, name = "MAV_CMD_PANORAMA_CREATE", hasLocation = "false", isDestination = "false", description = "Create a panorama at the current position")
public enum MavCmdPanoramaCreate {

	/**
	 * Viewing angle horizontal of the panorama (+- 0.5 the total angle)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Horizontal Angle", units = "deg")
	PARAM_1(),

	/**
	 * Viewing angle vertical of panorama.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Vertical Angle", units = "deg")
	PARAM_2(),

	/**
	 * Speed of the horizontal rotation.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, label = "Horizontal Speed", units = "deg/s")
	PARAM_3(),

	/**
	 * Speed of the vertical rotation.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4, label = "Vertical Speed", units = "deg/s")
	PARAM_4(),
}
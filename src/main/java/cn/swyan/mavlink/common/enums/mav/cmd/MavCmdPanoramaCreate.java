package cn.swyan.mavlink.common.enums.mav.cmd;

import cn.swyan.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.swyan.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * @Author YSW
 * @Description
 * @Date 2020.11.04 - 03:56
 **********************************/

@MavlinkEnumMavCmdEntry(value = 2800, name = "MAV_CMD_PANORAMA_CREATE", hasLocation = "null", isDestination = "null", description = "Create a panorama at the current position")
public enum MavCmdPanoramaCreate {

	/**
	 * Viewing angle horizontal of the panorama (in degrees, +- 0.5 the total angle)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1)
	PARAM_1(),

	/**
	 * Viewing angle vertical of panorama (in degrees)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2)
	PARAM_2(),

	/**
	 * Speed of the horizontal rotation (in degrees per second)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3)
	PARAM_3(),

	/**
	 * Speed of the vertical rotation (in degrees per second)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4)
	PARAM_4(),
}
package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 202, name = "MAV_CMD_DO_DIGICAM_CONFIGURE", hasLocation = "false", isDestination = "false", description = "Configure digital camera. This is a fallback message for systems that have not yet implemented PARAM_EXT_XXX messages and camera definition files (see https://mavlink.io/en/services/camera_def.html ).")
public enum MavCmdDoDigicamConfigure {

	/**
	 * Modes: P, TV, AV, M, Etc.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Mode", minValue = 0, increment = 1)
	PARAM_1(),

	/**
	 * Shutter speed: Divisor number for one second.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Shutter Speed", minValue = 0, increment = 1)
	PARAM_2(),

	/**
	 * Aperture: F stop number.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, label = "Aperture", minValue = 0)
	PARAM_3(),

	/**
	 * ISO number e.g. 80, 100, 200, Etc.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4, label = "ISO", minValue = 0, increment = 1)
	PARAM_4(),

	/**
	 * Exposure type enumerator.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 5, label = "Exposure")
	PARAM_5(),

	/**
	 * Command Identity.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 6, label = "Command Identity")
	PARAM_6(),

	/**
	 * Main engine cut-off time before camera trigger. (0 means no cut-off)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 7, label = "Engine Cut-off", units = "ds", minValue = 0, increment = 1)
	PARAM_7(),
}
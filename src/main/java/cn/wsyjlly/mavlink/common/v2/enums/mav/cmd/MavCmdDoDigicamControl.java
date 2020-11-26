package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 203, name = "MAV_CMD_DO_DIGICAM_CONTROL", hasLocation = "false", isDestination = "false", description = "Control digital camera. This is a fallback message for systems that have not yet implemented PARAM_EXT_XXX messages and camera definition files (see https://mavlink.io/en/services/camera_def.html ).")
public enum MavCmdDoDigicamControl {

	/**
	 * Session control e.g. show/hide lens
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Session Control")
	PARAM_1(),

	/**
	 * Zoom's absolute position
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Zoom Absolute")
	PARAM_2(),

	/**
	 * Zooming step value to offset zoom from the current position
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, label = "Zoom Relative")
	PARAM_3(),

	/**
	 * Focus Locking, Unlocking or Re-locking
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4, label = "Focus")
	PARAM_4(),

	/**
	 * Shooting Command
	 */
	@MavlinkEnumMavCmdEntryParam(index = 5, label = "Shoot Command")
	PARAM_5(),

	/**
	 * Command Identity
	 */
	@MavlinkEnumMavCmdEntryParam(index = 6, label = "Command Identity")
	PARAM_6(),

	/**
	 * Test shot identifier. If set to 1, image will only be captured, but not counted towards internal frame count.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 7, label = "Shot ID")
	PARAM_7(),
}
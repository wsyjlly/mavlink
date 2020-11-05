package cn.swyan.mavlink.common.enums.mav.cmd;

import cn.swyan.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.swyan.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * @Author YSW
 * @Description
 * @Date 2020.11.04 - 03:56
 **********************************/

@MavlinkEnumMavCmdEntry(value = 203, name = "MAV_CMD_DO_DIGICAM_CONTROL", hasLocation = "null", isDestination = "null", description = "Mission command to control an on-board camera controller system.")
public enum MavCmdDoDigicamControl {

	/**
	 * Session control e.g. show/hide lens
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1)
	PARAM_1(),

	/**
	 * Zoom's absolute position
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2)
	PARAM_2(),

	/**
	 * Zooming step value to offset zoom from the current position
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3)
	PARAM_3(),

	/**
	 * Focus Locking, Unlocking or Re-locking
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4)
	PARAM_4(),

	/**
	 * Shooting Command
	 */
	@MavlinkEnumMavCmdEntryParam(index = 5)
	PARAM_5(),

	/**
	 * Command Identity
	 */
	@MavlinkEnumMavCmdEntryParam(index = 6)
	PARAM_6(),

	/**
	 * Empty
	 */
	@MavlinkEnumMavCmdEntryParam(index = 7)
	PARAM_7(),
}
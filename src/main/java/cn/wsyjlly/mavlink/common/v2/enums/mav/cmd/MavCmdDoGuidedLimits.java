package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 222, name = "MAV_CMD_DO_GUIDED_LIMITS", hasLocation = "false", isDestination = "false", description = "Set limits for external control")
public enum MavCmdDoGuidedLimits {

	/**
	 * Timeout - maximum time that external controller will be allowed to control vehicle. 0 means no timeout.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Timeout", units = "s", minValue = 0)
	PARAM_1(),

	/**
	 * Altitude (MSL) min - if vehicle moves below this alt, the command will be aborted and the mission will continue. 0 means no lower altitude limit.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Min Altitude", units = "m")
	PARAM_2(),

	/**
	 * Altitude (MSL) max - if vehicle moves above this alt, the command will be aborted and the mission will continue. 0 means no upper altitude limit.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, label = "Max Altitude", units = "m")
	PARAM_3(),

	/**
	 * Horizontal move limit - if vehicle moves more than this distance from its location at the moment the command was executed, the command will be aborted and the mission will continue. 0 means no horizontal move limit.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4, label = "Horiz. Move Limit", units = "m", minValue = 0)
	PARAM_4(),

	/**
	 * Empty
	 */
	@MavlinkEnumMavCmdEntryParam(index = 5)
	PARAM_5(),

	/**
	 * Empty
	 */
	@MavlinkEnumMavCmdEntryParam(index = 6)
	PARAM_6(),

	/**
	 * Empty
	 */
	@MavlinkEnumMavCmdEntryParam(index = 7)
	PARAM_7(),
}
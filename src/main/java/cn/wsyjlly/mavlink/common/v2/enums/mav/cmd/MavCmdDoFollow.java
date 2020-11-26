package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 32, name = "MAV_CMD_DO_FOLLOW", hasLocation = "false", isDestination = "false", description = "Begin following a target")
public enum MavCmdDoFollow {

	/**
	 * System ID (of the FOLLOW_TARGET beacon). Send 0 to disable follow-me and return to the default position hold mode.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "System ID", minValue = 0, maxValue = 255, increment = 1)
	PARAM_1(),

	/**
	 * Reserved
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2)
	PARAM_2(),

	/**
	 * Reserved
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3)
	PARAM_3(),

	/**
	 * Altitude mode: 0: Keep current altitude, 1: keep altitude difference to target, 2: go to a fixed altitude above home.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4, label = "Altitude Mode", minValue = 0, maxValue = 2, increment = 1)
	PARAM_4(),

	/**
	 * Altitude above home. (used if mode=2)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 5, label = "Altitude", units = "m")
	PARAM_5(),

	/**
	 * Reserved
	 */
	@MavlinkEnumMavCmdEntryParam(index = 6)
	PARAM_6(),

	/**
	 * Time to land in which the MAV should go to the default position hold mode after a message RX timeout.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 7, label = "Time to Land", units = "s", minValue = 0)
	PARAM_7(),
}
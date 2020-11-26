package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 190, name = "MAV_CMD_DO_RALLY_LAND", hasLocation = "false", isDestination = "false", description = "Mission command to perform a landing from a rally point.")
public enum MavCmdDoRallyLand {

	/**
	 * Break altitude
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Altitude", units = "m")
	PARAM_1(),

	/**
	 * Landing speed
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Speed", units = "m/s")
	PARAM_2(),

	/**
	 * Empty
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3)
	PARAM_3(),

	/**
	 * Empty
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4)
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
package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 2520, name = "MAV_CMD_AIRFRAME_CONFIGURATION", hasLocation = "false", isDestination = "false", description = "")
public enum MavCmdAirframeConfiguration {

	/**
	 * Landing gear ID (default: 0, -1 for all)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Landing Gear ID", minValue = -1, increment = 1)
	PARAM_1(),

	/**
	 * Landing gear position (Down: 0, Up: 1, NaN for no change)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Landing Gear Position")
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

	/**
	 * 
	 */
	@MavlinkEnumMavCmdEntryParam(index = 5, reserved = "true", default0 = "NaN")
	PARAM_5(),

	/**
	 * 
	 */
	@MavlinkEnumMavCmdEntryParam(index = 6, reserved = "true", default0 = "NaN")
	PARAM_6(),

	/**
	 * 
	 */
	@MavlinkEnumMavCmdEntryParam(index = 7, reserved = "true", default0 = "NaN")
	PARAM_7(),
}
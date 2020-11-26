package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 178, name = "MAV_CMD_DO_CHANGE_SPEED", hasLocation = "false", isDestination = "false", description = "Change speed and/or throttle set points.")
public enum MavCmdDoChangeSpeed {

	/**
	 * Speed type (0=Airspeed, 1=Ground Speed, 2=Climb Speed, 3=Descent Speed)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Speed Type", minValue = 0, maxValue = 3, increment = 1)
	PARAM_1(),

	/**
	 * Speed (-1 indicates no change)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Speed", units = "m/s", minValue = -1)
	PARAM_2(),

	/**
	 * Throttle (-1 indicates no change)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, label = "Throttle", units = "%", minValue = -1)
	PARAM_3(),

	/**
	 * 0: absolute, 1: relative
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4, label = "Relative", minValue = 0, maxValue = 1, increment = 1)
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
package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 213, name = "MAV_CMD_NAV_SET_YAW_SPEED", hasLocation = "false", isDestination = "false", description = "Sets a desired vehicle turn angle and speed change.")
public enum MavCmdNavSetYawSpeed {

	/**
	 * Yaw angle to adjust steering by.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Yaw", units = "deg")
	PARAM_1(),

	/**
	 * Speed.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Speed", units = "m/s")
	PARAM_2(),

	/**
	 * Final angle. (0=absolute, 1=relative)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, label = "Angle", minValue = 0, maxValue = 1, increment = 1)
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
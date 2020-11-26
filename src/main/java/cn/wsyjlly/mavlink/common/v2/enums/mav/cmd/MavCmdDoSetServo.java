package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 183, name = "MAV_CMD_DO_SET_SERVO", hasLocation = "false", isDestination = "false", description = "Set a servo to a desired PWM value.")
public enum MavCmdDoSetServo {

	/**
	 * Servo instance number.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Instance", minValue = 0, increment = 1)
	PARAM_1(),

	/**
	 * Pulse Width Modulation.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "PWM", units = "us", minValue = 0, increment = 1)
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
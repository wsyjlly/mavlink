package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 187, name = "MAV_CMD_DO_SET_ACTUATOR", hasLocation = "false", isDestination = "false", description = "Sets actuators (e.g. servos) to a desired value. The actuator numbers are mapped to specific outputs (e.g. on any MAIN or AUX PWM or UAVCAN) using a flight-stack specific mechanism (i.e. a parameter).")
public enum MavCmdDoSetActuator {

	/**
	 * Actuator 1 value, scaled from [-1 to 1]. NaN to ignore.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Actuator 1", minValue = -1, maxValue = 1)
	PARAM_1(),

	/**
	 * Actuator 2 value, scaled from [-1 to 1]. NaN to ignore.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Actuator 2", minValue = -1, maxValue = 1)
	PARAM_2(),

	/**
	 * Actuator 3 value, scaled from [-1 to 1]. NaN to ignore.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, label = "Actuator 3", minValue = -1, maxValue = 1)
	PARAM_3(),

	/**
	 * Actuator 4 value, scaled from [-1 to 1]. NaN to ignore.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4, label = "Actuator 4", minValue = -1, maxValue = 1)
	PARAM_4(),

	/**
	 * Actuator 5 value, scaled from [-1 to 1]. NaN to ignore.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 5, label = "Actuator 5", minValue = -1, maxValue = 1)
	PARAM_5(),

	/**
	 * Actuator 6 value, scaled from [-1 to 1]. NaN to ignore.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 6, label = "Actuator 6", minValue = -1, maxValue = 1)
	PARAM_6(),

	/**
	 * Index of actuator set (i.e if set to 1, Actuator 1 becomes Actuator 7)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 7, label = "Index", minValue = 0, increment = 1)
	PARAM_7(),
}
package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 223, name = "MAV_CMD_DO_ENGINE_CONTROL", hasLocation = "false", isDestination = "false", description = "Control vehicle engine. This is interpreted by the vehicles engine controller to change the target engine state. It is intended for vehicles with internal combustion engines")
public enum MavCmdDoEngineControl {

	/**
	 * 0: Stop engine, 1:Start Engine
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Start Engine", minValue = 0, maxValue = 1, increment = 1)
	PARAM_1(),

	/**
	 * 0: Warm start, 1:Cold start. Controls use of choke where applicable
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Cold Start", minValue = 0, maxValue = 1, increment = 1)
	PARAM_2(),

	/**
	 * Height delay. This is for commanding engine start only after the vehicle has gained the specified height. Used in VTOL vehicles during takeoff to start engine after the aircraft is off the ground. Zero for no delay.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, label = "Height Delay", units = "m", minValue = 0)
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
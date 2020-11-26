package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 4501, name = "MAV_CMD_CONDITION_GATE", hasLocation = "true", isDestination = "true", description = "Delay mission state machine until gate has been reached.")
public enum MavCmdConditionGate {

	/**
	 * Geometry: 0: orthogonal to path between previous and next waypoint.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Geometry", minValue = 0, increment = 1)
	PARAM_1(),

	/**
	 * Altitude: 0: ignore altitude
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "UseAltitude", minValue = 0, maxValue = 1, increment = 1)
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
	 * Latitude
	 */
	@MavlinkEnumMavCmdEntryParam(index = 5, label = "Latitude")
	PARAM_5(),

	/**
	 * Longitude
	 */
	@MavlinkEnumMavCmdEntryParam(index = 6, label = "Longitude")
	PARAM_6(),

	/**
	 * Altitude
	 */
	@MavlinkEnumMavCmdEntryParam(index = 7, label = "Altitude", units = "m")
	PARAM_7(),
}
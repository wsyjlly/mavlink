package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 18, name = "MAV_CMD_NAV_LOITER_TURNS", hasLocation = "true", isDestination = "true", description = "Loiter around this waypoint for X turns")
public enum MavCmdNavLoiterTurns {

	/**
	 * Number of turns.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Turns", minValue = 0)
	PARAM_1(),

	/**
	 * Leave loiter circle only once heading towards the next waypoint (0 = False)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Heading Required", minValue = 0, maxValue = 1, increment = 1)
	PARAM_2(),

	/**
	 * Loiter radius around waypoint for forward-only moving vehicles (not multicopters). If positive loiter clockwise, else counter-clockwise
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, label = "Radius", units = "m")
	PARAM_3(),

	/**
	 * Loiter circle exit location and/or path to next waypoint ('xtrack') for forward-only moving vehicles (not multicopters). 0 for the vehicle to converge towards the center xtrack when it leaves the loiter (the line between the centers of the current and next waypoint), 1 to converge to the direct line between the location that the vehicle exits the loiter radius and the next waypoint. Otherwise the angle (in degrees) between the tangent of the loiter circle and the center xtrack at which the vehicle must leave the loiter (and converge to the center xtrack). NaN to use the current system default xtrack behaviour.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4, label = "Xtrack Location")
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
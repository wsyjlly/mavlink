package cn.wsyjlly.mavlink.common.v1.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:45
 **********************************/

@MavlinkEnumMavCmdEntry(value = 30001, name = "MAV_CMD_PAYLOAD_PREPARE_DEPLOY", hasLocation = "null", isDestination = "null", description = "Deploy payload on a Lat / Lon / Alt position. This includes the navigation to reach the required release position and velocity.")
public enum MavCmdPayloadPrepareDeploy {

	/**
	 * Operation mode. 0: prepare single payload deploy (overwriting previous requests), but do not execute it. 1: execute payload deploy immediately (rejecting further deploy commands during execution, but allowing abort). 2: add payload deploy to existing deployment list.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1)
	PARAM_1(),

	/**
	 * Desired approach vector in degrees compass heading (0..360). A negative value indicates the system can define the approach vector at will.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2)
	PARAM_2(),

	/**
	 * Desired ground speed at release time. This can be overriden by the airframe in case it needs to meet minimum airspeed. A negative value indicates the system can define the ground speed at will.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3)
	PARAM_3(),

	/**
	 * Minimum altitude clearance to the release position in meters. A negative value indicates the system can define the clearance at will.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4)
	PARAM_4(),

	/**
	 * Latitude unscaled for MISSION_ITEM or in 1e7 degrees for MISSION_ITEM_INT
	 */
	@MavlinkEnumMavCmdEntryParam(index = 5)
	PARAM_5(),

	/**
	 * Longitude unscaled for MISSION_ITEM or in 1e7 degrees for MISSION_ITEM_INT
	 */
	@MavlinkEnumMavCmdEntryParam(index = 6)
	PARAM_6(),

	/**
	 * Altitude, in meters WGS84
	 */
	@MavlinkEnumMavCmdEntryParam(index = 7)
	PARAM_7(),
}
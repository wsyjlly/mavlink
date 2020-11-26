package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 30001, name = "MAV_CMD_PAYLOAD_PREPARE_DEPLOY", hasLocation = "true", isDestination = "true", description = "Deploy payload on a Lat / Lon / Alt position. This includes the navigation to reach the required release position and velocity.")
public enum MavCmdPayloadPrepareDeploy {

	/**
	 * Operation mode. 0: prepare single payload deploy (overwriting previous requests), but do not execute it. 1: execute payload deploy immediately (rejecting further deploy commands during execution, but allowing abort). 2: add payload deploy to existing deployment list.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Operation Mode", minValue = 0, maxValue = 2, increment = 1)
	PARAM_1(),

	/**
	 * Desired approach vector in compass heading. A negative value indicates the system can define the approach vector at will.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Approach Vector", units = "deg", minValue = -1, maxValue = 360)
	PARAM_2(),

	/**
	 * Desired ground speed at release time. This can be overridden by the airframe in case it needs to meet minimum airspeed. A negative value indicates the system can define the ground speed at will.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, label = "Ground Speed", minValue = -1)
	PARAM_3(),

	/**
	 * Minimum altitude clearance to the release position. A negative value indicates the system can define the clearance at will.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4, label = "Altitude Clearance", units = "m", minValue = -1)
	PARAM_4(),

	/**
	 * Latitude. Note, if used in MISSION_ITEM (deprecated) the units are degrees (unscaled)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 5, label = "Latitude", units = "degE7")
	PARAM_5(),

	/**
	 * Longitude. Note, if used in MISSION_ITEM (deprecated) the units are degrees (unscaled)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 6, label = "Longitude", units = "degE7")
	PARAM_6(),

	/**
	 * Altitude (MSL)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 7, label = "Altitude", units = "m")
	PARAM_7(),
}
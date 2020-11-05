package cn.swyan.mavlink.common.enums.mav.cmd;

import cn.swyan.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.swyan.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * @Author YSW
 * @Description
 * @Date 2020.11.04 - 03:56
 **********************************/

@MavlinkEnumMavCmdEntry(value = 21, name = "MAV_CMD_NAV_LAND", hasLocation = "null", isDestination = "null", description = "Land at location")
public enum MavCmdNavLand {

	/**
	 * Empty
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1)
	PARAM_1(),

	/**
	 * Empty
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2)
	PARAM_2(),

	/**
	 * Empty
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3)
	PARAM_3(),

	/**
	 * Desired yaw angle.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4)
	PARAM_4(),

	/**
	 * Latitude
	 */
	@MavlinkEnumMavCmdEntryParam(index = 5)
	PARAM_5(),

	/**
	 * Longitude
	 */
	@MavlinkEnumMavCmdEntryParam(index = 6)
	PARAM_6(),

	/**
	 * Altitude
	 */
	@MavlinkEnumMavCmdEntryParam(index = 7)
	PARAM_7(),
}
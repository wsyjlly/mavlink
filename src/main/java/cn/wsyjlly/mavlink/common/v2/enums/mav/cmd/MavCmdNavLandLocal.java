package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 23, name = "MAV_CMD_NAV_LAND_LOCAL", hasLocation = "true", isDestination = "true", description = "Land at local position (local frame only)")
public enum MavCmdNavLandLocal {

	/**
	 * Landing target number (if available)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Target", minValue = 0, increment = 1)
	PARAM_1(),

	/**
	 * Maximum accepted offset from desired landing position - computed magnitude from spherical coordinates: d = sqrt(x^2 + y^2 + z^2), which gives the maximum accepted distance between the desired landing position and the position where the vehicle is about to land
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Offset", units = "m", minValue = 0)
	PARAM_2(),

	/**
	 * Landing descend rate
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, label = "Descend Rate", units = "m/s")
	PARAM_3(),

	/**
	 * Desired yaw angle
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4, label = "Yaw", units = "rad")
	PARAM_4(),

	/**
	 * Y-axis position
	 */
	@MavlinkEnumMavCmdEntryParam(index = 5, label = "Y Position", units = "m")
	PARAM_5(),

	/**
	 * X-axis position
	 */
	@MavlinkEnumMavCmdEntryParam(index = 6, label = "X Position", units = "m")
	PARAM_6(),

	/**
	 * Z-axis / ground level position
	 */
	@MavlinkEnumMavCmdEntryParam(index = 7, label = "Z Position", units = "m")
	PARAM_7(),
}
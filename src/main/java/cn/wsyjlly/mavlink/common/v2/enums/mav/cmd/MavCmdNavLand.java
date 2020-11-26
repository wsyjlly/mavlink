package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;
import cn.wsyjlly.mavlink.common.v2.enums.PrecisionLandMode;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 21, name = "MAV_CMD_NAV_LAND", hasLocation = "true", isDestination = "true", description = "Land at location.")
public enum MavCmdNavLand {

	/**
	 * Minimum target altitude if landing is aborted (0 = undefined/use system default).
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Abort Alt", units = "m")
	PARAM_1(),

	/**
	 * Precision land mode.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Land Mode", enum0 = PrecisionLandMode.class)
	PARAM_2(),

	/**
	 * Empty
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3)
	PARAM_3(),

	/**
	 * Desired yaw angle. NaN to use the current system yaw heading mode (e.g. yaw towards next waypoint, yaw to home, etc.).
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4, label = "Yaw Angle", units = "deg")
	PARAM_4(),

	/**
	 * Latitude.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 5, label = "Latitude")
	PARAM_5(),

	/**
	 * Longitude.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 6, label = "Longitude")
	PARAM_6(),

	/**
	 * Landing altitude (ground level in current frame).
	 */
	@MavlinkEnumMavCmdEntryParam(index = 7, label = "Altitude", units = "m")
	PARAM_7(),
}
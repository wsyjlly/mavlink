package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 42006, name = "MAV_CMD_FIXED_MAG_CAL_YAW", hasLocation = "true", isDestination = "false", description = "Magnetometer calibration based on provided known yaw. This allows for fast calibration using WMM field tables in the vehicle, given only the known yaw of the vehicle. If Latitude and longitude are both zero then use the current vehicle location.")
public enum MavCmdFixedMagCalYaw {

	/**
	 * Yaw of vehicle in earth frame.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Yaw", units = "deg")
	PARAM_1(),

	/**
	 * CompassMask, 0 for all.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "CompassMask")
	PARAM_2(),

	/**
	 * Latitude.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, label = "Latitude", units = "deg")
	PARAM_3(),

	/**
	 * Longitude.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4, label = "Longitude", units = "deg")
	PARAM_4(),

	/**
	 * Empty.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 5)
	PARAM_5(),

	/**
	 * Empty.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 6)
	PARAM_6(),

	/**
	 * Empty.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 7)
	PARAM_7(),
}
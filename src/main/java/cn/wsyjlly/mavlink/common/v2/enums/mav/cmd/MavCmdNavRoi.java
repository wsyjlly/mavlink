package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;
import cn.wsyjlly.mavlink.common.v2.enums.MavRoi;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 80, name = "MAV_CMD_NAV_ROI", hasLocation = "true", isDestination = "false", description = "Sets the region of interest (ROI) for a sensor set or the vehicle itself. This can then be used by the vehicle's control system to control the vehicle attitude and the attitude of various sensors such as cameras.")
public enum MavCmdNavRoi {

	/**
	 * Region of interest mode.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "ROI Mode", enum0 = MavRoi.class)
	PARAM_1(),

	/**
	 * Waypoint index/ target ID. (see MAV_ROI enum)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "WP Index", minValue = 0, increment = 1)
	PARAM_2(),

	/**
	 * ROI index (allows a vehicle to manage multiple ROI's)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, label = "ROI Index", minValue = 0, increment = 1)
	PARAM_3(),

	/**
	 * Empty
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4)
	PARAM_4(),

	/**
	 * x the location of the fixed ROI (see MAV_FRAME)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 5, label = "X")
	PARAM_5(),

	/**
	 * y
	 */
	@MavlinkEnumMavCmdEntryParam(index = 6, label = "Y")
	PARAM_6(),

	/**
	 * z
	 */
	@MavlinkEnumMavCmdEntryParam(index = 7, label = "Z")
	PARAM_7(),
}
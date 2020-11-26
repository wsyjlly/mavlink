package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;
import cn.wsyjlly.mavlink.common.v2.enums.MavRoi;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 201, name = "MAV_CMD_DO_SET_ROI", hasLocation = "true", isDestination = "false", description = "Sets the region of interest (ROI) for a sensor set or the vehicle itself. This can then be used by the vehicle's control system to control the vehicle attitude and the attitude of various sensors such as cameras.")
public enum MavCmdDoSetRoi {

	/**
	 * Region of interest mode.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "ROI Mode", enum0 = MavRoi.class)
	PARAM_1(),

	/**
	 * Waypoint index/ target ID (depends on param 1).
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "WP Index", minValue = 0, increment = 1)
	PARAM_2(),

	/**
	 * Region of interest index. (allows a vehicle to manage multiple ROI's)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, label = "ROI Index", minValue = 0, increment = 1)
	PARAM_3(),

	/**
	 * Empty
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4)
	PARAM_4(),

	/**
	 * MAV_ROI_WPNEXT: pitch offset from next waypoint, MAV_ROI_LOCATION: latitude
	 */
	@MavlinkEnumMavCmdEntryParam(index = 5)
	PARAM_5(),

	/**
	 * MAV_ROI_WPNEXT: roll offset from next waypoint, MAV_ROI_LOCATION: longitude
	 */
	@MavlinkEnumMavCmdEntryParam(index = 6)
	PARAM_6(),

	/**
	 * MAV_ROI_WPNEXT: yaw offset from next waypoint, MAV_ROI_LOCATION: altitude
	 */
	@MavlinkEnumMavCmdEntryParam(index = 7)
	PARAM_7(),
}
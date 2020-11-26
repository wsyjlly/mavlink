package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 196, name = "MAV_CMD_DO_SET_ROI_WPNEXT_OFFSET", hasLocation = "false", isDestination = "false", description = "Sets the region of interest (ROI) to be toward next waypoint, with optional pitch/roll/yaw offset. This can then be used by the vehicle's control system to control the vehicle attitude and the attitude of various sensors such as cameras. This command can be sent to a gimbal manager but not to a gimbal device. A gimbal device is not to react to this message.")
public enum MavCmdDoSetRoiWpnextOffset {

	/**
	 * Component ID of gimbal device to address (or 1-6 for non-MAVLink gimbal), 0 for all gimbal device components. Send command multiple times for more than one gimbal (but not all gimbals).
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Gimbal device ID")
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
	 * Empty
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4)
	PARAM_4(),

	/**
	 * Pitch offset from next waypoint, positive pitching up
	 */
	@MavlinkEnumMavCmdEntryParam(index = 5, label = "Pitch Offset")
	PARAM_5(),

	/**
	 * roll offset from next waypoint, positive rolling to the right
	 */
	@MavlinkEnumMavCmdEntryParam(index = 6, label = "Roll Offset")
	PARAM_6(),

	/**
	 * yaw offset from next waypoint, positive yawing to the right
	 */
	@MavlinkEnumMavCmdEntryParam(index = 7, label = "Yaw Offset")
	PARAM_7(),
}
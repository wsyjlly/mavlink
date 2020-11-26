package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 220, name = "MAV_CMD_DO_MOUNT_CONTROL_QUAT", hasLocation = "false", isDestination = "false", description = "Mission command to control a camera or antenna mount, using a quaternion as reference.")
public enum MavCmdDoMountControlQuat {

	/**
	 * quaternion param q1, w (1 in null-rotation)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Q1")
	PARAM_1(),

	/**
	 * quaternion param q2, x (0 in null-rotation)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Q2")
	PARAM_2(),

	/**
	 * quaternion param q3, y (0 in null-rotation)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, label = "Q3")
	PARAM_3(),

	/**
	 * quaternion param q4, z (0 in null-rotation)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4, label = "Q4")
	PARAM_4(),

	/**
	 * Empty
	 */
	@MavlinkEnumMavCmdEntryParam(index = 5)
	PARAM_5(),

	/**
	 * Empty
	 */
	@MavlinkEnumMavCmdEntryParam(index = 6)
	PARAM_6(),

	/**
	 * Empty
	 */
	@MavlinkEnumMavCmdEntryParam(index = 7)
	PARAM_7(),
}
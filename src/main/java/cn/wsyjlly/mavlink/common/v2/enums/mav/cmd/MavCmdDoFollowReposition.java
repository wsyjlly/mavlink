package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 33, name = "MAV_CMD_DO_FOLLOW_REPOSITION", hasLocation = "false", isDestination = "false", description = "Reposition the MAV after a follow target command has been sent")
public enum MavCmdDoFollowReposition {

	/**
	 * Camera q1 (where 0 is on the ray from the camera to the tracking device)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Camera Q1")
	PARAM_1(),

	/**
	 * Camera q2
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Camera Q2")
	PARAM_2(),

	/**
	 * Camera q3
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, label = "Camera Q3")
	PARAM_3(),

	/**
	 * Camera q4
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4, label = "Camera Q4")
	PARAM_4(),

	/**
	 * altitude offset from target
	 */
	@MavlinkEnumMavCmdEntryParam(index = 5, label = "Altitude Offset", units = "m")
	PARAM_5(),

	/**
	 * X offset from target
	 */
	@MavlinkEnumMavCmdEntryParam(index = 6, label = "X Offset", units = "m")
	PARAM_6(),

	/**
	 * Y offset from target
	 */
	@MavlinkEnumMavCmdEntryParam(index = 7, label = "Y Offset", units = "m")
	PARAM_7(),
}
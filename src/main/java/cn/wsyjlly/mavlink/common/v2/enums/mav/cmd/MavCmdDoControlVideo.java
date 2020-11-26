package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 200, name = "MAV_CMD_DO_CONTROL_VIDEO", hasLocation = "false", isDestination = "false", description = "Control onboard camera system.")
public enum MavCmdDoControlVideo {

	/**
	 * Camera ID (-1 for all)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "ID", minValue = -1, increment = 1)
	PARAM_1(),

	/**
	 * Transmission: 0: disabled, 1: enabled compressed, 2: enabled raw
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Transmission", minValue = 0, maxValue = 2, increment = 1)
	PARAM_2(),

	/**
	 * Transmission mode: 0: video stream, gt 0: single images every n seconds
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, label = "Interval", units = "s", minValue = 0)
	PARAM_3(),

	/**
	 * Recording: 0: disabled, 1: enabled compressed, 2: enabled raw
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4, label = "Recording", minValue = 0, maxValue = 2, increment = 1)
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
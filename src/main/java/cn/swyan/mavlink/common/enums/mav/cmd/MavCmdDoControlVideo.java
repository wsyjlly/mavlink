package cn.swyan.mavlink.common.enums.mav.cmd;

import cn.swyan.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.swyan.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * @Author YSW
 * @Description
 * @Date 2020.11.04 - 03:56
 **********************************/

@MavlinkEnumMavCmdEntry(value = 200, name = "MAV_CMD_DO_CONTROL_VIDEO", hasLocation = "null", isDestination = "null", description = "Control onboard camera system.")
public enum MavCmdDoControlVideo {

	/**
	 * Camera ID (-1 for all)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1)
	PARAM_1(),

	/**
	 * Transmission: 0: disabled, 1: enabled compressed, 2: enabled raw
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2)
	PARAM_2(),

	/**
	 * Transmission mode: 0: video stream, >0: single images every n seconds (decimal)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3)
	PARAM_3(),

	/**
	 * Recording: 0: disabled, 1: enabled compressed, 2: enabled raw
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4)
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
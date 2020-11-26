package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 221, name = "MAV_CMD_DO_GUIDED_MASTER", hasLocation = "false", isDestination = "false", description = "set id of master controller")
public enum MavCmdDoGuidedMaster {

	/**
	 * System ID
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "System ID", minValue = 0, maxValue = 255, increment = 1)
	PARAM_1(),

	/**
	 * Component ID
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Component ID", minValue = 0, maxValue = 255, increment = 1)
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
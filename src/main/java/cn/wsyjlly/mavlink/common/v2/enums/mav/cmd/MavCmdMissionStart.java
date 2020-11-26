package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 300, name = "MAV_CMD_MISSION_START", hasLocation = "false", isDestination = "false", description = "start running a mission")
public enum MavCmdMissionStart {

	/**
	 * first_item: the first mission item to run
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "First Item", minValue = 0, increment = 1)
	PARAM_1(),

	/**
	 * last_item: the last mission item to run (after this item is run, the mission ends)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Last Item", minValue = 0, increment = 1)
	PARAM_2(),
}
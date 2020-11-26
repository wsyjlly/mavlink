package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 600, name = "MAV_CMD_JUMP_TAG", hasLocation = "false", isDestination = "false", description = "Tagged jump target. Can be jumped to with MAV_CMD_DO_JUMP_TAG.")
public enum MavCmdJumpTag {

	/**
	 * Tag.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Tag", minValue = 0, increment = 1)
	PARAM_1(),
}
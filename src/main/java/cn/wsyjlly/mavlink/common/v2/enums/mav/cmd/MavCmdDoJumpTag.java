package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 601, name = "MAV_CMD_DO_JUMP_TAG", hasLocation = "false", isDestination = "false", description = "Jump to the matching tag in the mission list. Repeat this action for the specified number of times. A mission should contain a single matching tag for each jump. If this is not the case then a jump to a missing tag should complete the mission, and a jump where there are multiple matching tags should always select the one with the lowest mission sequence number.")
public enum MavCmdDoJumpTag {

	/**
	 * Target tag to jump to.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Tag", minValue = 0, increment = 1)
	PARAM_1(),

	/**
	 * Repeat count.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Repeat", minValue = 0, increment = 1)
	PARAM_2(),
}
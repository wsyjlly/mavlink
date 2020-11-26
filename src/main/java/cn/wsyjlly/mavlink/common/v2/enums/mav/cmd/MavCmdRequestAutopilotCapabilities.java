package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 520, name = "MAV_CMD_REQUEST_AUTOPILOT_CAPABILITIES", hasLocation = "false", isDestination = "false", description = "Request autopilot capabilities. The receiver should ACK the command and then emit its capabilities in an AUTOPILOT_VERSION message")
public enum MavCmdRequestAutopilotCapabilities {

	/**
	 * 1: Request autopilot version
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Version", minValue = 0, maxValue = 1, increment = 1)
	PARAM_1(),

	/**
	 * Reserved (all remaining params)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2)
	PARAM_2(),
}
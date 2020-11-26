package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 525, name = "MAV_CMD_REQUEST_STORAGE_INFORMATION", hasLocation = "false", isDestination = "false", description = "Request storage information (STORAGE_INFORMATION). Use the command's target_component to target a specific component's storage.")
public enum MavCmdRequestStorageInformation {

	/**
	 * Storage ID (0 for all, 1 for first, 2 for second, etc.)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Storage ID", minValue = 0, increment = 1)
	PARAM_1(),

	/**
	 * 0: No Action 1: Request storage information
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Information", minValue = 0, maxValue = 1, increment = 1)
	PARAM_2(),

	/**
	 * Reserved (all remaining params)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3)
	PARAM_3(),
}
package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 526, name = "MAV_CMD_STORAGE_FORMAT", hasLocation = "false", isDestination = "false", description = "Format a storage medium. Once format is complete, a STORAGE_INFORMATION message is sent. Use the command's target_component to target a specific component's storage.")
public enum MavCmdStorageFormat {

	/**
	 * Storage ID (1 for first, 2 for second, etc.)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Storage ID", minValue = 0, increment = 1)
	PARAM_1(),

	/**
	 * Format storage (and reset image log). 0: No action 1: Format storage
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Format", minValue = 0, maxValue = 1, increment = 1)
	PARAM_2(),

	/**
	 * Reset Image Log (without formatting storage medium). This will reset CAMERA_CAPTURE_STATUS.image_count and CAMERA_IMAGE_CAPTURED.image_index. 0: No action 1: Reset Image Log
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, label = "Reset Image Log", minValue = 0, maxValue = 1, increment = 1)
	PARAM_3(),

	/**
	 * Reserved (all remaining params)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4)
	PARAM_4(),
}
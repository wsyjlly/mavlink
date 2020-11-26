package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 214, name = "MAV_CMD_DO_SET_CAM_TRIGG_INTERVAL", hasLocation = "false", isDestination = "false", description = "Mission command to set camera trigger interval for this flight. If triggering is enabled, the camera is triggered each time this interval expires. This command can also be used to set the shutter integration time for the camera.")
public enum MavCmdDoSetCamTriggInterval {

	/**
	 * Camera trigger cycle time. -1 or 0 to ignore.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Trigger Cycle", units = "ms", minValue = -1, increment = 1)
	PARAM_1(),

	/**
	 * Camera shutter integration time. Should be less than trigger cycle time. -1 or 0 to ignore.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Shutter Integration", units = "ms", minValue = -1, increment = 1)
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
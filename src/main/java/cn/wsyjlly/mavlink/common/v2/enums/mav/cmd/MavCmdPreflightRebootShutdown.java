package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 246, name = "MAV_CMD_PREFLIGHT_REBOOT_SHUTDOWN", hasLocation = "false", isDestination = "false", description = "Request the reboot or shutdown of system components.")
public enum MavCmdPreflightRebootShutdown {

	/**
	 * 0: Do nothing for autopilot, 1: Reboot autopilot, 2: Shutdown autopilot, 3: Reboot autopilot and keep it in the bootloader until upgraded.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Autopilot", minValue = 0, maxValue = 3, increment = 1)
	PARAM_1(),

	/**
	 * 0: Do nothing for onboard computer, 1: Reboot onboard computer, 2: Shutdown onboard computer, 3: Reboot onboard computer and keep it in the bootloader until upgraded.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Companion", minValue = 0, maxValue = 3, increment = 1)
	PARAM_2(),

	/**
	 * WIP: 0: Do nothing for camera, 1: Reboot onboard camera, 2: Shutdown onboard camera, 3: Reboot onboard camera and keep it in the bootloader until upgraded
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3)
	PARAM_3(),

	/**
	 * WIP: 0: Do nothing for mount (e.g. gimbal), 1: Reboot mount, 2: Shutdown mount, 3: Reboot mount and keep it in the bootloader until upgraded
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4)
	PARAM_4(),

	/**
	 * Reserved (set to 0)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 5)
	PARAM_5(),

	/**
	 * Reserved (set to 0)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 6)
	PARAM_6(),

	/**
	 * WIP: ID (e.g. camera ID -1 for all IDs)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 7)
	PARAM_7(),
}
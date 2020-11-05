package cn.swyan.mavlink.common.enums.mav.cmd;

import cn.swyan.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.swyan.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * @Author YSW
 * @Description
 * @Date 2020.11.04 - 03:56
 **********************************/

@MavlinkEnumMavCmdEntry(value = 246, name = "MAV_CMD_PREFLIGHT_REBOOT_SHUTDOWN", hasLocation = "null", isDestination = "null", description = "Request the reboot or shutdown of system components.")
public enum MavCmdPreflightRebootShutdown {

	/**
	 * 0: Do nothing for autopilot, 1: Reboot autopilot, 2: Shutdown autopilot.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1)
	PARAM_1(),

	/**
	 * 0: Do nothing for onboard computer, 1: Reboot onboard computer, 2: Shutdown onboard computer.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2)
	PARAM_2(),

	/**
	 * Reserved
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3)
	PARAM_3(),

	/**
	 * Reserved
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
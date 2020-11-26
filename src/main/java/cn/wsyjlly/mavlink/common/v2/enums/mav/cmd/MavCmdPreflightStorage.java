package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 245, name = "MAV_CMD_PREFLIGHT_STORAGE", hasLocation = "false", isDestination = "false", description = "Request storage of different parameter values and logs. This command will be only accepted if in pre-flight mode.")
public enum MavCmdPreflightStorage {

	/**
	 * Parameter storage: 0: READ FROM FLASH/EEPROM, 1: WRITE CURRENT TO FLASH/EEPROM, 2: Reset to defaults
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Parameter Storage", minValue = 0, maxValue = 2, increment = 1)
	PARAM_1(),

	/**
	 * Mission storage: 0: READ FROM FLASH/EEPROM, 1: WRITE CURRENT TO FLASH/EEPROM, 2: Reset to defaults
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Mission Storage", minValue = 0, maxValue = 2, increment = 1)
	PARAM_2(),

	/**
	 * Onboard logging: 0: Ignore, 1: Start default rate logging, -1: Stop logging, gt 1: logging rate (e.g. set to 1000 for 1000 Hz logging)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, label = "Logging Rate", units = "Hz", minValue = -1, increment = 1)
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
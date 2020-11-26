package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 410, name = "MAV_CMD_GET_HOME_POSITION", hasLocation = "false", isDestination = "false", description = "Request the home position from the vehicle.")
public enum MavCmdGetHomePosition {

	/**
	 * Reserved
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1)
	PARAM_1(),

	/**
	 * Reserved
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
	 * Reserved
	 */
	@MavlinkEnumMavCmdEntryParam(index = 5)
	PARAM_5(),

	/**
	 * Reserved
	 */
	@MavlinkEnumMavCmdEntryParam(index = 6)
	PARAM_6(),

	/**
	 * Reserved
	 */
	@MavlinkEnumMavCmdEntryParam(index = 7)
	PARAM_7(),
}
package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 528, name = "MAV_CMD_REQUEST_FLIGHT_INFORMATION", hasLocation = "false", isDestination = "false", description = "Request flight information (FLIGHT_INFORMATION)")
public enum MavCmdRequestFlightInformation {

	/**
	 * 1: Request flight information
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Flight Information", minValue = 0, maxValue = 1, increment = 1)
	PARAM_1(),

	/**
	 * Reserved (all remaining params)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2)
	PARAM_2(),
}
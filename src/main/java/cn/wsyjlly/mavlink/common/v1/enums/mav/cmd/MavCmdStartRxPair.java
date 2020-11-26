package cn.wsyjlly.mavlink.common.v1.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:45
 **********************************/

@MavlinkEnumMavCmdEntry(value = 500, name = "MAV_CMD_START_RX_PAIR", hasLocation = "null", isDestination = "null", description = "Starts receiver pairing")
public enum MavCmdStartRxPair {

	/**
	 * 0:Spektrum
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1)
	PARAM_1(),

	/**
	 * 0:Spektrum DSM2, 1:Spektrum DSMX
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2)
	PARAM_2(),
}
package cn.swyan.mavlink.common.enums.mav.cmd;

import cn.swyan.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.swyan.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * @Author YSW
 * @Description
 * @Date 2020.11.04 - 03:56
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
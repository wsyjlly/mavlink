package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;
import cn.wsyjlly.mavlink.common.v2.enums.RcType;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 500, name = "MAV_CMD_START_RX_PAIR", hasLocation = "false", isDestination = "false", description = "Starts receiver pairing.")
public enum MavCmdStartRxPair {

	/**
	 * 0:Spektrum.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Spektrum")
	PARAM_1(),

	/**
	 * RC type.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "RC Type", enum0 = RcType.class)
	PARAM_2(),
}
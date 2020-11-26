package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 519, name = "MAV_CMD_REQUEST_PROTOCOL_VERSION", hasLocation = "false", isDestination = "false", description = "Request MAVLink protocol version compatibility. All receivers should ACK the command and then emit their capabilities in an PROTOCOL_VERSION message")
public enum MavCmdRequestProtocolVersion {

	/**
	 * 1: Request supported protocol versions by all nodes on the network
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Protocol", minValue = 0, maxValue = 1, increment = 1)
	PARAM_1(),

	/**
	 * Reserved (all remaining params)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2)
	PARAM_2(),
}
package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:45
 **********************************/

@MavlinkEnumMavCmdEntry(value = 512, name = "MAV_CMD_REQUEST_MESSAGE", hasLocation = "false", isDestination = "false", description = "Request the target system(s) emit a single instance of a specified message (i.e. a 'one-shot' version of MAV_CMD_SET_MESSAGE_INTERVAL).")
public enum MavCmdRequestMessage {

	/**
	 * The MAVLink message ID of the requested message.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Message ID", minValue = 0, maxValue = 16777215, increment = 1)
	PARAM_1(),

	/**
	 * Use for index ID, if required. Otherwise, the use of this parameter (if any) must be defined in the requested message. By default assumed not used (0).
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Req Param 1")
	PARAM_2(),

	/**
	 * The use of this parameter (if any), must be defined in the requested message. By default assumed not used (0).
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, label = "Req Param 2")
	PARAM_3(),

	/**
	 * The use of this parameter (if any), must be defined in the requested message. By default assumed not used (0).
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4, label = "Req Param 3")
	PARAM_4(),

	/**
	 * The use of this parameter (if any), must be defined in the requested message. By default assumed not used (0).
	 */
	@MavlinkEnumMavCmdEntryParam(index = 5, label = "Req Param 4")
	PARAM_5(),

	/**
	 * The use of this parameter (if any), must be defined in the requested message. By default assumed not used (0).
	 */
	@MavlinkEnumMavCmdEntryParam(index = 6, label = "Req Param 5")
	PARAM_6(),

	/**
	 * Target address for requested message (if message has target address fields). 0: Flight-stack default, 1: address of requestor, 2: broadcast.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 7, label = "Response Target", minValue = 0, maxValue = 2, increment = 1)
	PARAM_7(),
}
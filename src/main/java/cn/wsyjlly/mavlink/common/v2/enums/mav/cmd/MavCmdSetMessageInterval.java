package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 511, name = "MAV_CMD_SET_MESSAGE_INTERVAL", hasLocation = "false", isDestination = "false", description = "Set the interval between messages for a particular MAVLink message ID. This interface replaces REQUEST_DATA_STREAM.")
public enum MavCmdSetMessageInterval {

	/**
	 * The MAVLink message ID
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Message ID", minValue = 0, maxValue = 16777215, increment = 1)
	PARAM_1(),

	/**
	 * The interval between two messages. Set to -1 to disable and 0 to request default rate.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Interval", units = "us", minValue = -1, increment = 1)
	PARAM_2(),
}
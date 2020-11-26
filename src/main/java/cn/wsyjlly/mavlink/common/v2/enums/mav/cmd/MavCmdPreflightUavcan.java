package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 243, name = "MAV_CMD_PREFLIGHT_UAVCAN", hasLocation = "false", isDestination = "false", description = "Trigger UAVCAN configuration (actuator ID assignment and direction mapping). Note that this maps to the legacy UAVCAN v0 function UAVCAN_ENUMERATE, which is intended to be executed just once during initial vehicle configuration (it is not a normal pre-flight command and has been poorly named).")
public enum MavCmdPreflightUavcan {

	/**
	 * 1: Trigger actuator ID assignment and direction mapping. 0: Cancel command.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Actuator ID")
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
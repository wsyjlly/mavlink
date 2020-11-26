package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 400, name = "MAV_CMD_COMPONENT_ARM_DISARM", hasLocation = "false", isDestination = "false", description = "Arms / Disarms a component")
public enum MavCmdComponentArmDisarm {

	/**
	 * 0: disarm, 1: arm
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Arm", minValue = 0, maxValue = 1, increment = 1)
	PARAM_1(),

	/**
	 * 0: arm-disarm unless prevented by safety checks (i.e. when landed), 21196: force arming/disarming (e.g. allow arming to override preflight checks and disarming in flight)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Force", minValue = 0, maxValue = 21196, increment = 21196)
	PARAM_2(),
}
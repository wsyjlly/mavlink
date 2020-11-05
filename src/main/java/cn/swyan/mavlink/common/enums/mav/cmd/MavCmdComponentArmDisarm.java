package cn.swyan.mavlink.common.enums.mav.cmd;

import cn.swyan.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.swyan.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * @Author YSW
 * @Description
 * @Date 2020.11.04 - 03:56
 **********************************/

@MavlinkEnumMavCmdEntry(value = 400, name = "MAV_CMD_COMPONENT_ARM_DISARM", hasLocation = "null", isDestination = "null", description = "Arms / Disarms a component")
public enum MavCmdComponentArmDisarm {

	/**
	 * 1 to arm, 0 to disarm
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1)
	PARAM_1(),
}
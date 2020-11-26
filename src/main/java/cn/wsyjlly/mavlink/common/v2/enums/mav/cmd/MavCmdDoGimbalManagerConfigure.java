package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 1001, name = "MAV_CMD_DO_GIMBAL_MANAGER_CONFIGURE", hasLocation = "false", isDestination = "false", description = "Gimbal configuration to set which sysid/compid is in primary and secondary control.")
public enum MavCmdDoGimbalManagerConfigure {

	/**
	 * Sysid for primary control (0: no one in control).
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "sysid primary control")
	PARAM_1(),

	/**
	 * Compid for primary control (0: no one in control).
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "compid primary control")
	PARAM_2(),

	/**
	 * Sysid for secondary control (0: no one in control).
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, label = "sysid secondary control")
	PARAM_3(),

	/**
	 * Compid for secondary control (0: no one in control).
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4, label = "compid secondary control")
	PARAM_4(),
}
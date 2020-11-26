package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;
import cn.wsyjlly.mavlink.common.v2.enums.MavVtolState;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 3000, name = "MAV_CMD_DO_VTOL_TRANSITION", hasLocation = "false", isDestination = "false", description = "Request VTOL transition")
public enum MavCmdDoVtolTransition {

	/**
	 * The target VTOL state. Only MAV_VTOL_STATE_MC and MAV_VTOL_STATE_FW can be used.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "State", enum0 = MavVtolState.class)
	PARAM_1(),
}
package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 405, name = "MAV_CMD_ILLUMINATOR_ON_OFF", hasLocation = "false", isDestination = "false", description = "Turns illuminators ON/OFF. An illuminator is a light source that is used for lighting up dark areas external to the sytstem: e.g. a torch or searchlight (as opposed to a light source for illuminating the system itself, e.g. an indicator light).")
public enum MavCmdIlluminatorOnOff {

	/**
	 * 0: Illuminators OFF, 1: Illuminators ON
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Enable", minValue = 0, maxValue = 1, increment = 1)
	PARAM_1(),
}
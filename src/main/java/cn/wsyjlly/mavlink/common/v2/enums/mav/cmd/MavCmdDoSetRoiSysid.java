package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 198, name = "MAV_CMD_DO_SET_ROI_SYSID", hasLocation = "null", isDestination = "null", description = "Mount tracks system with specified system ID. Determination of target vehicle position may be done with GLOBAL_POSITION_INT or any other means. This command can be sent to a gimbal manager but not to a gimbal device. A gimbal device is not to react to this message.")
public enum MavCmdDoSetRoiSysid {

	/**
	 * System ID
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "System ID", minValue = 1, maxValue = 255, increment = 1)
	PARAM_1(),

	/**
	 * Component ID of gimbal device to address (or 1-6 for non-MAVLink gimbal), 0 for all gimbal device components. Send command multiple times for more than one gimbal (but not all gimbals).
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Gimbal device ID")
	PARAM_2(),
}
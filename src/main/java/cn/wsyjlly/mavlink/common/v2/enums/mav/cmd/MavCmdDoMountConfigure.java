package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;
import cn.wsyjlly.mavlink.common.v2.enums.MavMountMode;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 204, name = "MAV_CMD_DO_MOUNT_CONFIGURE", hasLocation = "false", isDestination = "false", description = "Mission command to configure a camera or antenna mount")
public enum MavCmdDoMountConfigure {

	/**
	 * Mount operation mode
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Mode", enum0 = MavMountMode.class)
	PARAM_1(),

	/**
	 * stabilize roll? (1 = yes, 0 = no)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Stabilize Roll", minValue = 0, maxValue = 1, increment = 1)
	PARAM_2(),

	/**
	 * stabilize pitch? (1 = yes, 0 = no)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, label = "Stabilize Pitch", minValue = 0, maxValue = 1, increment = 1)
	PARAM_3(),

	/**
	 * stabilize yaw? (1 = yes, 0 = no)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4, label = "Stabilize Yaw", minValue = 0, maxValue = 1, increment = 1)
	PARAM_4(),

	/**
	 * roll input (0 = angle body frame, 1 = angular rate, 2 = angle absolute frame)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 5, label = "Roll Input Mode")
	PARAM_5(),

	/**
	 * pitch input (0 = angle body frame, 1 = angular rate, 2 = angle absolute frame)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 6, label = "Pitch Input Mode")
	PARAM_6(),

	/**
	 * yaw input (0 = angle body frame, 1 = angular rate, 2 = angle absolute frame)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 7, label = "Yaw Input Mode")
	PARAM_7(),
}
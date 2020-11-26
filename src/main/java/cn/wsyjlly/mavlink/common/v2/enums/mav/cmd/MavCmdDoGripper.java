package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;
import cn.wsyjlly.mavlink.common.v2.enums.GripperActions;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 211, name = "MAV_CMD_DO_GRIPPER", hasLocation = "false", isDestination = "false", description = "Mission command to operate a gripper.")
public enum MavCmdDoGripper {

	/**
	 * Gripper instance number.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Instance", minValue = 1, increment = 1)
	PARAM_1(),

	/**
	 * Gripper action to perform.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Action", enum0 = GripperActions.class)
	PARAM_2(),

	/**
	 * Empty
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3)
	PARAM_3(),

	/**
	 * Empty
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4)
	PARAM_4(),

	/**
	 * Empty
	 */
	@MavlinkEnumMavCmdEntryParam(index = 5)
	PARAM_5(),

	/**
	 * Empty
	 */
	@MavlinkEnumMavCmdEntryParam(index = 6)
	PARAM_6(),

	/**
	 * Empty
	 */
	@MavlinkEnumMavCmdEntryParam(index = 7)
	PARAM_7(),
}
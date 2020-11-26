package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;
import cn.wsyjlly.mavlink.common.v2.enums.MavComponent;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 247, name = "MAV_CMD_DO_UPGRADE", hasLocation = "false", isDestination = "false", description = "Request a target system to start an upgrade of one (or all) of its components. For example, the command might be sent to a companion computer to cause it to upgrade a connected flight controller. The system doing the upgrade will report progress using the normal command protocol sequence for a long running operation. Command protocol information: https://mavlink.io/en/services/command.html.")
public enum MavCmdDoUpgrade {

	/**
	 * Component id of the component to be upgraded. If set to 0, all components should be upgraded.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Component ID", enum0 = MavComponent.class)
	PARAM_1(),

	/**
	 * 0: Do not reboot component after the action is executed, 1: Reboot component after the action is executed.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Reboot", minValue = 0, maxValue = 1, increment = 1)
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
	 * WIP: upgrade progress report rate (can be used for more granular control).
	 */
	@MavlinkEnumMavCmdEntryParam(index = 7)
	PARAM_7(),
}
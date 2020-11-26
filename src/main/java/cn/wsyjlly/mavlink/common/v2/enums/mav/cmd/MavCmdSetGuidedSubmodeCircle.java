package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 4001, name = "MAV_CMD_SET_GUIDED_SUBMODE_CIRCLE", hasLocation = "true", isDestination = "false", description = "This command sets submode circle when vehicle is in guided mode. Vehicle flies along a circle facing the center of the circle. The user can input the velocity along the circle and change the radius. If no input is given the vehicle will hold position.")
public enum MavCmdSetGuidedSubmodeCircle {

	/**
	 * Radius of desired circle in CIRCLE_MODE
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Radius", units = "m")
	PARAM_1(),

	/**
	 * User defined
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2)
	PARAM_2(),

	/**
	 * User defined
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3)
	PARAM_3(),

	/**
	 * User defined
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4)
	PARAM_4(),

	/**
	 * Target latitude of center of circle in CIRCLE_MODE
	 */
	@MavlinkEnumMavCmdEntryParam(index = 5, label = "Latitude", units = "degE7")
	PARAM_5(),

	/**
	 * Target longitude of center of circle in CIRCLE_MODE
	 */
	@MavlinkEnumMavCmdEntryParam(index = 6, label = "Longitude", units = "degE7")
	PARAM_6(),
}
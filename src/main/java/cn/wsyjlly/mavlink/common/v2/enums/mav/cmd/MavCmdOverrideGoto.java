package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;
import cn.wsyjlly.mavlink.common.v2.enums.MavGoto;
import cn.wsyjlly.mavlink.common.v2.enums.MavGoto;
import cn.wsyjlly.mavlink.common.v2.enums.MavFrame;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 252, name = "MAV_CMD_OVERRIDE_GOTO", hasLocation = "true", isDestination = "true", description = "Override current mission with command to pause mission, pause mission and move to position, continue/resume mission. When param 1 indicates that the mission is paused (MAV_GOTO_DO_HOLD), param 2 defines whether it holds in place or moves to another position.")
public enum MavCmdOverrideGoto {

	/**
	 * MAV_GOTO_DO_HOLD: pause mission and either hold or move to specified position (depending on param2), MAV_GOTO_DO_CONTINUE: resume mission.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Continue", enum0 = MavGoto.class)
	PARAM_1(),

	/**
	 * MAV_GOTO_HOLD_AT_CURRENT_POSITION: hold at current position, MAV_GOTO_HOLD_AT_SPECIFIED_POSITION: hold at specified position.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Position", enum0 = MavGoto.class)
	PARAM_2(),

	/**
	 * Coordinate frame of hold point.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, label = "Frame", enum0 = MavFrame.class)
	PARAM_3(),

	/**
	 * Desired yaw angle.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4, label = "Yaw", units = "deg")
	PARAM_4(),

	/**
	 * Latitude/X position.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 5, label = "Latitude/X")
	PARAM_5(),

	/**
	 * Longitude/Y position.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 6, label = "Longitude/Y")
	PARAM_6(),

	/**
	 * Altitude/Z position.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 7, label = "Altitude/Z")
	PARAM_7(),
}
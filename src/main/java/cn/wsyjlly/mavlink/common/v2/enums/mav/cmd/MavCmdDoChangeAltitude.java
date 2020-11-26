package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;
import cn.wsyjlly.mavlink.common.v2.enums.MavFrame;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 186, name = "MAV_CMD_DO_CHANGE_ALTITUDE", hasLocation = "false", isDestination = "false", description = "Change altitude set point.")
public enum MavCmdDoChangeAltitude {

	/**
	 * Altitude
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Altitude", units = "m")
	PARAM_1(),

	/**
	 * Frame of new altitude.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Frame", enum0 = MavFrame.class)
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
package cn.swyan.mavlink.common.enums.mav.cmd;

import cn.swyan.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.swyan.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * @Author YSW
 * @Description
 * @Date 2020.11.04 - 03:56
 **********************************/

@MavlinkEnumMavCmdEntry(value = 205, name = "MAV_CMD_DO_MOUNT_CONTROL", hasLocation = "null", isDestination = "null", description = "Mission command to control a camera or antenna mount")
public enum MavCmdDoMountControl {

	/**
	 * pitch or lat in degrees, depending on mount mode.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1)
	PARAM_1(),

	/**
	 * roll or lon in degrees depending on mount mode
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2)
	PARAM_2(),

	/**
	 * yaw or alt (in meters) depending on mount mode
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3)
	PARAM_3(),

	/**
	 * reserved
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4)
	PARAM_4(),

	/**
	 * reserved
	 */
	@MavlinkEnumMavCmdEntryParam(index = 5)
	PARAM_5(),

	/**
	 * reserved
	 */
	@MavlinkEnumMavCmdEntryParam(index = 6)
	PARAM_6(),

	/**
	 * MAV_MOUNT_MODE enum value
	 */
	@MavlinkEnumMavCmdEntryParam(index = 7)
	PARAM_7(),
}
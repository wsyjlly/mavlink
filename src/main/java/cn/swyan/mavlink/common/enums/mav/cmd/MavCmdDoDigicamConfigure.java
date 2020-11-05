package cn.swyan.mavlink.common.enums.mav.cmd;

import cn.swyan.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.swyan.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * @Author YSW
 * @Description
 * @Date 2020.11.04 - 03:56
 **********************************/

@MavlinkEnumMavCmdEntry(value = 202, name = "MAV_CMD_DO_DIGICAM_CONFIGURE", hasLocation = "null", isDestination = "null", description = "Mission command to configure an on-board camera controller system.")
public enum MavCmdDoDigicamConfigure {

	/**
	 * Modes: P, TV, AV, M, Etc
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1)
	PARAM_1(),

	/**
	 * Shutter speed: Divisor number for one second
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2)
	PARAM_2(),

	/**
	 * Aperture: F stop number
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3)
	PARAM_3(),

	/**
	 * ISO number e.g. 80, 100, 200, Etc
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4)
	PARAM_4(),

	/**
	 * Exposure type enumerator
	 */
	@MavlinkEnumMavCmdEntryParam(index = 5)
	PARAM_5(),

	/**
	 * Command Identity
	 */
	@MavlinkEnumMavCmdEntryParam(index = 6)
	PARAM_6(),

	/**
	 * Main engine cut-off time before camera trigger in seconds/10 (0 means no cut-off)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 7)
	PARAM_7(),
}
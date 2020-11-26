package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 206, name = "MAV_CMD_DO_SET_CAM_TRIGG_DIST", hasLocation = "false", isDestination = "false", description = "Mission command to set camera trigger distance for this flight. The camera is triggered each time this distance is exceeded. This command can also be used to set the shutter integration time for the camera.")
public enum MavCmdDoSetCamTriggDist {

	/**
	 * Camera trigger distance. 0 to stop triggering.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Distance", units = "m", minValue = 0)
	PARAM_1(),

	/**
	 * Camera shutter integration time. -1 or 0 to ignore
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Shutter", units = "ms", minValue = -1, increment = 1)
	PARAM_2(),

	/**
	 * Trigger camera once immediately. (0 = no trigger, 1 = trigger)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, label = "Trigger", minValue = 0, maxValue = 1, increment = 1)
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
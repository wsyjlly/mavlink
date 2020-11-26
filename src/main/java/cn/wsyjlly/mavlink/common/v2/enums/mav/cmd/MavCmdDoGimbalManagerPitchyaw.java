package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;
import cn.wsyjlly.mavlink.common.v2.enums.GimbalManagerFlags;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 1000, name = "MAV_CMD_DO_GIMBAL_MANAGER_PITCHYAW", hasLocation = "false", isDestination = "false", description = "High level setpoint to be sent to a gimbal manager to set a gimbal attitude. It is possible to set combinations of the values below. E.g. an angle as well as a desired angular rate can be used to get to this angle at a certain angular rate, or an angular rate only will result in continuous turning. NaN is to be used to signal unset. Note: a gimbal is never to react to this command but only the gimbal manager.")
public enum MavCmdDoGimbalManagerPitchyaw {

	/**
	 * Pitch angle (positive to pitch up, relative to vehicle for FOLLOW mode, relative to world horizon for LOCK mode).
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Pitch angle", units = "deg", minValue = -180, maxValue = 180)
	PARAM_1(),

	/**
	 * Yaw angle (positive to yaw to the right, relative to vehicle for FOLLOW mode, absolute to North for LOCK mode).
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Yaw angle", units = "deg", minValue = -180, maxValue = 180)
	PARAM_2(),

	/**
	 * Pitch rate (positive to pitch up).
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, label = "Pitch rate", units = "deg/s")
	PARAM_3(),

	/**
	 * Yaw rate (positive to yaw to the right).
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4, label = "Yaw rate", units = "deg/s")
	PARAM_4(),

	/**
	 * Gimbal manager flags to use.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 5, label = "Gimbal manager flags", enum0 = GimbalManagerFlags.class)
	PARAM_5(),
}
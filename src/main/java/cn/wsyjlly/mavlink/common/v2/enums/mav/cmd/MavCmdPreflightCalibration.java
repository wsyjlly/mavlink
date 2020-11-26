package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 241, name = "MAV_CMD_PREFLIGHT_CALIBRATION", hasLocation = "false", isDestination = "false", description = "Trigger calibration. This command will be only accepted if in pre-flight mode. Except for Temperature Calibration, only one sensor should be set in a single message and all others should be zero.")
public enum MavCmdPreflightCalibration {

	/**
	 * 1: gyro calibration, 3: gyro temperature calibration
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Gyro Temperature", minValue = 0, maxValue = 3, increment = 1)
	PARAM_1(),

	/**
	 * 1: magnetometer calibration
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Magnetometer", minValue = 0, maxValue = 1, increment = 1)
	PARAM_2(),

	/**
	 * 1: ground pressure calibration
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, label = "Ground Pressure", minValue = 0, maxValue = 1, increment = 1)
	PARAM_3(),

	/**
	 * 1: radio RC calibration, 2: RC trim calibration
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4, label = "Remote Control", minValue = 0, maxValue = 1, increment = 1)
	PARAM_4(),

	/**
	 * 1: accelerometer calibration, 2: board level calibration, 3: accelerometer temperature calibration, 4: simple accelerometer calibration
	 */
	@MavlinkEnumMavCmdEntryParam(index = 5, label = "Accelerometer", minValue = 0, maxValue = 4, increment = 1)
	PARAM_5(),

	/**
	 * 1: APM: compass/motor interference calibration (PX4: airspeed calibration, deprecated), 2: airspeed calibration
	 */
	@MavlinkEnumMavCmdEntryParam(index = 6, label = "Compmot or Airspeed", minValue = 0, maxValue = 2, increment = 1)
	PARAM_6(),

	/**
	 * 1: ESC calibration, 3: barometer temperature calibration
	 */
	@MavlinkEnumMavCmdEntryParam(index = 7, label = "ESC or Baro", minValue = 0, maxValue = 3, increment = 1)
	PARAM_7(),
}
package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 242, name = "MAV_CMD_PREFLIGHT_SET_SENSOR_OFFSETS", hasLocation = "false", isDestination = "false", description = "Set sensor offsets. This command will be only accepted if in pre-flight mode.")
public enum MavCmdPreflightSetSensorOffsets {

	/**
	 * Sensor to adjust the offsets for: 0: gyros, 1: accelerometer, 2: magnetometer, 3: barometer, 4: optical flow, 5: second magnetometer, 6: third magnetometer
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Sensor Type", minValue = 0, maxValue = 6, increment = 1)
	PARAM_1(),

	/**
	 * X axis offset (or generic dimension 1), in the sensor's raw units
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "X Offset")
	PARAM_2(),

	/**
	 * Y axis offset (or generic dimension 2), in the sensor's raw units
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, label = "Y Offset")
	PARAM_3(),

	/**
	 * Z axis offset (or generic dimension 3), in the sensor's raw units
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4, label = "Z Offset")
	PARAM_4(),

	/**
	 * Generic dimension 4, in the sensor's raw units
	 */
	@MavlinkEnumMavCmdEntryParam(index = 5, label = "4th Dimension")
	PARAM_5(),

	/**
	 * Generic dimension 5, in the sensor's raw units
	 */
	@MavlinkEnumMavCmdEntryParam(index = 6, label = "5th Dimension")
	PARAM_6(),

	/**
	 * Generic dimension 6, in the sensor's raw units
	 */
	@MavlinkEnumMavCmdEntryParam(index = 7, label = "6th Dimension")
	PARAM_7(),
}
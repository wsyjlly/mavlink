package cn.swyan.mavlink.common.enums.mav.cmd;

import cn.swyan.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.swyan.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * @Author YSW
 * @Description
 * @Date 2020.11.04 - 03:56
 **********************************/

@MavlinkEnumMavCmdEntry(value = 242, name = "MAV_CMD_PREFLIGHT_SET_SENSOR_OFFSETS", hasLocation = "null", isDestination = "null", description = "Set sensor offsets. This command will be only accepted if in pre-flight mode.")
public enum MavCmdPreflightSetSensorOffsets {

	/**
	 * Sensor to adjust the offsets for: 0: gyros, 1: accelerometer, 2: magnetometer, 3: barometer, 4: optical flow, 5: second magnetometer
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1)
	PARAM_1(),

	/**
	 * X axis offset (or generic dimension 1), in the sensor's raw units
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2)
	PARAM_2(),

	/**
	 * Y axis offset (or generic dimension 2), in the sensor's raw units
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3)
	PARAM_3(),

	/**
	 * Z axis offset (or generic dimension 3), in the sensor's raw units
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4)
	PARAM_4(),

	/**
	 * Generic dimension 4, in the sensor's raw units
	 */
	@MavlinkEnumMavCmdEntryParam(index = 5)
	PARAM_5(),

	/**
	 * Generic dimension 5, in the sensor's raw units
	 */
	@MavlinkEnumMavCmdEntryParam(index = 6)
	PARAM_6(),

	/**
	 * Generic dimension 6, in the sensor's raw units
	 */
	@MavlinkEnumMavCmdEntryParam(index = 7)
	PARAM_7(),
}
package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;
import cn.wsyjlly.mavlink.common.v2.enums.OrbitYawBehaviour;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 34, name = "MAV_CMD_DO_ORBIT", hasLocation = "true", isDestination = "true", description = "Start orbiting on the circumference of a circle defined by the parameters. Setting any value NaN results in using defaults.")
public enum MavCmdDoOrbit {

	/**
	 * Radius of the circle. positive: Orbit clockwise. negative: Orbit counter-clockwise.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Radius", units = "m")
	PARAM_1(),

	/**
	 * Tangential Velocity. NaN: Vehicle configuration default.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Velocity", units = "m/s")
	PARAM_2(),

	/**
	 * Yaw behavior of the vehicle.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, label = "Yaw Behavior", enum0 = OrbitYawBehaviour.class)
	PARAM_3(),

	/**
	 * Reserved (e.g. for dynamic center beacon options)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4)
	PARAM_4(),

	/**
	 * Center point latitude (if no MAV_FRAME specified) / X coordinate according to MAV_FRAME. NaN: Use current vehicle position or current center if already orbiting.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 5, label = "Latitude/X")
	PARAM_5(),

	/**
	 * Center point longitude (if no MAV_FRAME specified) / Y coordinate according to MAV_FRAME. NaN: Use current vehicle position or current center if already orbiting.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 6, label = "Longitude/Y")
	PARAM_6(),

	/**
	 * Center point altitude (MSL) (if no MAV_FRAME specified) / Z coordinate according to MAV_FRAME. NaN: Use current vehicle position or current center if already orbiting.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 7, label = "Altitude/Z")
	PARAM_7(),
}
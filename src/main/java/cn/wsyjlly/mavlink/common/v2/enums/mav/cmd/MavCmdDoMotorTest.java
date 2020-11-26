package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;
import cn.wsyjlly.mavlink.common.v2.enums.MotorTestThrottleType;
import cn.wsyjlly.mavlink.common.v2.enums.MotorTestOrder;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 209, name = "MAV_CMD_DO_MOTOR_TEST", hasLocation = "false", isDestination = "false", description = "Mission command to perform motor test.")
public enum MavCmdDoMotorTest {

	/**
	 * Motor instance number. (from 1 to max number of motors on the vehicle)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Instance", minValue = 1, increment = 1)
	PARAM_1(),

	/**
	 * Throttle type.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Throttle Type", enum0 = MotorTestThrottleType.class)
	PARAM_2(),

	/**
	 * Throttle.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, label = "Throttle")
	PARAM_3(),

	/**
	 * Timeout.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 4, label = "Timeout", units = "s", minValue = 0)
	PARAM_4(),

	/**
	 * Motor count. (number of motors to test to test in sequence, waiting for the timeout above between them; 0=1 motor, 1=1 motor, 2=2 motors...)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 5, label = "Motor Count", minValue = 0, increment = 1)
	PARAM_5(),

	/**
	 * Motor test order.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 6, label = "Test Order", enum0 = MotorTestOrder.class)
	PARAM_6(),

	/**
	 * Empty
	 */
	@MavlinkEnumMavCmdEntryParam(index = 7)
	PARAM_7(),
}
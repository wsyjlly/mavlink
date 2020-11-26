package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "MOTOR_TEST_ORDER")
public enum  MotorTestOrder {
	
	/**
	 * default autopilot motor test method
	 */
	@MavlinkEnumEntry(value = 0,description = "default autopilot motor test method")
	MOTOR_TEST_ORDER_DEFAULT(),
	
	/**
	 * motor numbers are specified as their index in a predefined vehicle-specific sequence
	 */
	@MavlinkEnumEntry(value = 1,description = "motor numbers are specified as their index in a predefined vehicle-specific sequence")
	MOTOR_TEST_ORDER_SEQUENCE(),
	
	/**
	 * motor numbers are specified as the output as labeled on the board
	 */
	@MavlinkEnumEntry(value = 2,description = "motor numbers are specified as the output as labeled on the board")
	MOTOR_TEST_ORDER_BOARD(),
}
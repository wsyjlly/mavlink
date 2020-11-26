package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "ESC_CONNECTION_TYPE")
public enum  EscConnectionType {
	
	/**
	 * Traditional PPM ESC.
	 */
	@MavlinkEnumEntry(value = 0,description = "Traditional PPM ESC.")
	ESC_CONNECTION_TYPE_PPM(),
	
	/**
	 * Serial Bus connected ESC.
	 */
	@MavlinkEnumEntry(value = 1,description = "Serial Bus connected ESC.")
	ESC_CONNECTION_TYPE_SERIAL(),
	
	/**
	 * One Shot PPM ESC.
	 */
	@MavlinkEnumEntry(value = 2,description = "One Shot PPM ESC.")
	ESC_CONNECTION_TYPE_ONESHOT(),
	
	/**
	 * I2C ESC.
	 */
	@MavlinkEnumEntry(value = 3,description = "I2C ESC.")
	ESC_CONNECTION_TYPE_I2C(),
	
	/**
	 * CAN-Bus ESC.
	 */
	@MavlinkEnumEntry(value = 4,description = "CAN-Bus ESC.")
	ESC_CONNECTION_TYPE_CAN(),
	
	/**
	 * DShot ESC.
	 */
	@MavlinkEnumEntry(value = 5,description = "DShot ESC.")
	ESC_CONNECTION_TYPE_DSHOT(),
}
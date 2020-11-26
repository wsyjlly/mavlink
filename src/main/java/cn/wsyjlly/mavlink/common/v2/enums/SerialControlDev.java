package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "SERIAL_CONTROL_DEV")
public enum  SerialControlDev {
	
	/**
	 * First telemetry port
	 */
	@MavlinkEnumEntry(value = 0,description = "First telemetry port")
	SERIAL_CONTROL_DEV_TELEM1(),
	
	/**
	 * Second telemetry port
	 */
	@MavlinkEnumEntry(value = 1,description = "Second telemetry port")
	SERIAL_CONTROL_DEV_TELEM2(),
	
	/**
	 * First GPS port
	 */
	@MavlinkEnumEntry(value = 2,description = "First GPS port")
	SERIAL_CONTROL_DEV_GPS1(),
	
	/**
	 * Second GPS port
	 */
	@MavlinkEnumEntry(value = 3,description = "Second GPS port")
	SERIAL_CONTROL_DEV_GPS2(),
	
	/**
	 * system shell
	 */
	@MavlinkEnumEntry(value = 10,description = "system shell")
	SERIAL_CONTROL_DEV_SHELL(),
	
	/**
	 * SERIAL0
	 */
	@MavlinkEnumEntry(value = 100,description = "SERIAL0")
	SERIAL_CONTROL_SERIAL0(),
	
	/**
	 * SERIAL1
	 */
	@MavlinkEnumEntry(value = 101,description = "SERIAL1")
	SERIAL_CONTROL_SERIAL1(),
	
	/**
	 * SERIAL2
	 */
	@MavlinkEnumEntry(value = 102,description = "SERIAL2")
	SERIAL_CONTROL_SERIAL2(),
	
	/**
	 * SERIAL3
	 */
	@MavlinkEnumEntry(value = 103,description = "SERIAL3")
	SERIAL_CONTROL_SERIAL3(),
	
	/**
	 * SERIAL4
	 */
	@MavlinkEnumEntry(value = 104,description = "SERIAL4")
	SERIAL_CONTROL_SERIAL4(),
	
	/**
	 * SERIAL5
	 */
	@MavlinkEnumEntry(value = 105,description = "SERIAL5")
	SERIAL_CONTROL_SERIAL5(),
	
	/**
	 * SERIAL6
	 */
	@MavlinkEnumEntry(value = 106,description = "SERIAL6")
	SERIAL_CONTROL_SERIAL6(),
	
	/**
	 * SERIAL7
	 */
	@MavlinkEnumEntry(value = 107,description = "SERIAL7")
	SERIAL_CONTROL_SERIAL7(),
	
	/**
	 * SERIAL8
	 */
	@MavlinkEnumEntry(value = 108,description = "SERIAL8")
	SERIAL_CONTROL_SERIAL8(),
	
	/**
	 * SERIAL9
	 */
	@MavlinkEnumEntry(value = 109,description = "SERIAL9")
	SERIAL_CONTROL_SERIAL9(),
}
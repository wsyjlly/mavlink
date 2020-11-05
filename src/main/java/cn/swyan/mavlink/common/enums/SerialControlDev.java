package cn.swyan.mavlink.common.enums;

import cn.swyan.mavlink.annotation.MavlinkEnum;
import cn.swyan.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * @Author YSW
 * @Description
 * @Date 2020.11.04 - 03:56
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
}
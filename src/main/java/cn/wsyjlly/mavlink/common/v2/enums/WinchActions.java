package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "WINCH_ACTIONS")
public enum  WinchActions {
	
	/**
	 * Relax winch.
	 */
	@MavlinkEnumEntry(value = 0,description = "Relax winch.")
	WINCH_RELAXED(),
	
	/**
	 * Wind or unwind specified length of cable, optionally using specified rate.
	 */
	@MavlinkEnumEntry(value = 1,description = "Wind or unwind specified length of cable, optionally using specified rate.")
	WINCH_RELATIVE_LENGTH_CONTROL(),
	
	/**
	 * Wind or unwind cable at specified rate.
	 */
	@MavlinkEnumEntry(value = 2,description = "Wind or unwind cable at specified rate.")
	WINCH_RATE_CONTROL(),
}
package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "PARACHUTE_ACTION")
public enum  ParachuteAction {
	
	/**
	 * Disable auto-release of parachute (i.e. release triggered by crash detectors).
	 */
	@MavlinkEnumEntry(value = 0,description = "Disable auto-release of parachute (i.e. release triggered by crash detectors).")
	PARACHUTE_DISABLE(),
	
	/**
	 * Enable auto-release of parachute.
	 */
	@MavlinkEnumEntry(value = 1,description = "Enable auto-release of parachute.")
	PARACHUTE_ENABLE(),
	
	/**
	 * Release parachute and kill motors.
	 */
	@MavlinkEnumEntry(value = 2,description = "Release parachute and kill motors.")
	PARACHUTE_RELEASE(),
}
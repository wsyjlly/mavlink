package cn.wsyjlly.mavlink.common.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.09 - 03:37
 *
 **********************************/

@MavlinkEnum(name = "MAV_BATTERY_TYPE")
public enum  MavBatteryType {
	
	/**
	 * Not specified.
	 */
	@MavlinkEnumEntry(value = 0,description = "Not specified.")
	MAV_BATTERY_TYPE_UNKNOWN(),
	
	/**
	 * Lithium polymere battery
	 */
	@MavlinkEnumEntry(value = 1,description = "Lithium polymere battery")
	MAV_BATTERY_TYPE_LIPO(),
	
	/**
	 * Lithium ferrite battery
	 */
	@MavlinkEnumEntry(value = 2,description = "Lithium ferrite battery")
	MAV_BATTERY_TYPE_LIFE(),
	
	/**
	 * Lithium-ION battery
	 */
	@MavlinkEnumEntry(value = 3,description = "Lithium-ION battery")
	MAV_BATTERY_TYPE_LION(),
	
	/**
	 * Nickel metal hydride battery
	 */
	@MavlinkEnumEntry(value = 4,description = "Nickel metal hydride battery")
	MAV_BATTERY_TYPE_NIMH(),
}
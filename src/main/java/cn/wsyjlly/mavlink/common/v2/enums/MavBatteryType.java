package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
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
	 * Lithium polymer battery
	 */
	@MavlinkEnumEntry(value = 1,description = "Lithium polymer battery")
	MAV_BATTERY_TYPE_LIPO(),
	
	/**
	 * Lithium-iron-phosphate battery
	 */
	@MavlinkEnumEntry(value = 2,description = "Lithium-iron-phosphate battery")
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
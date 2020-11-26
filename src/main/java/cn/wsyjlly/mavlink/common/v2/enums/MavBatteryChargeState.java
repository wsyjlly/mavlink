package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "MAV_BATTERY_CHARGE_STATE")
public enum  MavBatteryChargeState {
	
	/**
	 * Low battery state is not provided
	 */
	@MavlinkEnumEntry(value = 0,description = "Low battery state is not provided")
	MAV_BATTERY_CHARGE_STATE_UNDEFINED(),
	
	/**
	 * Battery is not in low state. Normal operation.
	 */
	@MavlinkEnumEntry(value = 1,description = "Battery is not in low state. Normal operation.")
	MAV_BATTERY_CHARGE_STATE_OK(),
	
	/**
	 * Battery state is low, warn and monitor close.
	 */
	@MavlinkEnumEntry(value = 2,description = "Battery state is low, warn and monitor close.")
	MAV_BATTERY_CHARGE_STATE_LOW(),
	
	/**
	 * Battery state is critical, return or abort immediately.
	 */
	@MavlinkEnumEntry(value = 3,description = "Battery state is critical, return or abort immediately.")
	MAV_BATTERY_CHARGE_STATE_CRITICAL(),
	
	/**
	 * Battery state is too low for ordinary abort sequence. Perform fastest possible emergency stop to prevent damage.
	 */
	@MavlinkEnumEntry(value = 4,description = "Battery state is too low for ordinary abort sequence. Perform fastest possible emergency stop to prevent damage.")
	MAV_BATTERY_CHARGE_STATE_EMERGENCY(),
	
	/**
	 * Battery failed, damage unavoidable. Possible causes (faults) are listed in MAV_BATTERY_FAULT.
	 */
	@MavlinkEnumEntry(value = 5,description = "Battery failed, damage unavoidable. Possible causes (faults) are listed in MAV_BATTERY_FAULT.")
	MAV_BATTERY_CHARGE_STATE_FAILED(),
	
	/**
	 * Battery is diagnosed to be defective or an error occurred, usage is discouraged / prohibited. Possible causes (faults) are listed in MAV_BATTERY_FAULT.
	 */
	@MavlinkEnumEntry(value = 6,description = "Battery is diagnosed to be defective or an error occurred, usage is discouraged / prohibited. Possible causes (faults) are listed in MAV_BATTERY_FAULT.")
	MAV_BATTERY_CHARGE_STATE_UNHEALTHY(),
	
	/**
	 * Battery is charging.
	 */
	@MavlinkEnumEntry(value = 7,description = "Battery is charging.")
	MAV_BATTERY_CHARGE_STATE_CHARGING(),
}
package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "MAV_BATTERY_FAULT", bitmask = "true")
public enum  MavBatteryFault {
	
	/**
	 * Battery has deep discharged.
	 */
	@MavlinkEnumEntry(value = 1,description = "Battery has deep discharged.")
	MAV_BATTERY_FAULT_DEEP_DISCHARGE(),
	
	/**
	 * Voltage spikes.
	 */
	@MavlinkEnumEntry(value = 2,description = "Voltage spikes.")
	MAV_BATTERY_FAULT_SPIKES(),
	
	/**
	 * One or more cells have failed. Battery should also report MAV_BATTERY_CHARGE_STATE_FAILE (and should not be used).
	 */
	@MavlinkEnumEntry(value = 4,description = "One or more cells have failed. Battery should also report MAV_BATTERY_CHARGE_STATE_FAILE (and should not be used).")
	MAV_BATTERY_FAULT_CELL_FAIL(),
	
	/**
	 * Over-current fault.
	 */
	@MavlinkEnumEntry(value = 8,description = "Over-current fault.")
	MAV_BATTERY_FAULT_OVER_CURRENT(),
	
	/**
	 * Over-temperature fault.
	 */
	@MavlinkEnumEntry(value = 16,description = "Over-temperature fault.")
	MAV_BATTERY_FAULT_OVER_TEMPERATURE(),
	
	/**
	 * Under-temperature fault.
	 */
	@MavlinkEnumEntry(value = 32,description = "Under-temperature fault.")
	MAV_BATTERY_FAULT_UNDER_TEMPERATURE(),
	
	/**
	 * Vehicle voltage is not compatible with this battery (batteries on same power rail should have similar voltage).
	 */
	@MavlinkEnumEntry(value = 64,description = "Vehicle voltage is not compatible with this battery (batteries on same power rail should have similar voltage).")
	MAV_BATTERY_FAULT_INCOMPATIBLE_VOLTAGE(),
}
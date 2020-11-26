package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "MAV_BATTERY_MODE")
public enum  MavBatteryMode {
	
	/**
	 * Battery mode not supported/unknown battery mode/normal operation.
	 */
	@MavlinkEnumEntry(value = 0,description = "Battery mode not supported/unknown battery mode/normal operation.")
	MAV_BATTERY_MODE_UNKNOWN(),
	
	/**
	 * Battery is auto discharging (towards storage level).
	 */
	@MavlinkEnumEntry(value = 1,description = "Battery is auto discharging (towards storage level).")
	MAV_BATTERY_MODE_AUTO_DISCHARGING(),
	
	/**
	 * Battery in hot-swap mode (current limited to prevent spikes that might damage sensitive electrical circuits).
	 */
	@MavlinkEnumEntry(value = 2,description = "Battery in hot-swap mode (current limited to prevent spikes that might damage sensitive electrical circuits).")
	MAV_BATTERY_MODE_HOT_SWAP(),
}
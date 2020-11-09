package cn.wsyjlly.mavlink.common.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.09 - 03:37
 *
 **********************************/

@MavlinkEnum(name = "MAV_SEVERITY")
public enum  MavSeverity {
	
	/**
	 * System is unusable. This is a 'panic' condition.
	 */
	@MavlinkEnumEntry(value = 0,description = "System is unusable. This is a 'panic' condition.")
	MAV_SEVERITY_EMERGENCY(),
	
	/**
	 * Action should be taken immediately. Indicates error in non-critical systems.
	 */
	@MavlinkEnumEntry(value = 1,description = "Action should be taken immediately. Indicates error in non-critical systems.")
	MAV_SEVERITY_ALERT(),
	
	/**
	 * Action must be taken immediately. Indicates failure in a primary system.
	 */
	@MavlinkEnumEntry(value = 2,description = "Action must be taken immediately. Indicates failure in a primary system.")
	MAV_SEVERITY_CRITICAL(),
	
	/**
	 * Indicates an error in secondary/redundant systems.
	 */
	@MavlinkEnumEntry(value = 3,description = "Indicates an error in secondary/redundant systems.")
	MAV_SEVERITY_ERROR(),
	
	/**
	 * Indicates about a possible future error if this is not resolved within a given timeframe. Example would be a low battery warning.
	 */
	@MavlinkEnumEntry(value = 4,description = "Indicates about a possible future error if this is not resolved within a given timeframe. Example would be a low battery warning.")
	MAV_SEVERITY_WARNING(),
	
	/**
	 * An unusual event has occured, though not an error condition. This should be investigated for the root cause.
	 */
	@MavlinkEnumEntry(value = 5,description = "An unusual event has occured, though not an error condition. This should be investigated for the root cause.")
	MAV_SEVERITY_NOTICE(),
	
	/**
	 * Normal operational messages. Useful for logging. No action is required for these messages.
	 */
	@MavlinkEnumEntry(value = 6,description = "Normal operational messages. Useful for logging. No action is required for these messages.")
	MAV_SEVERITY_INFO(),
	
	/**
	 * Useful non-operational messages that can assist in debugging. These should not occur during normal operation.
	 */
	@MavlinkEnumEntry(value = 7,description = "Useful non-operational messages that can assist in debugging. These should not occur during normal operation.")
	MAV_SEVERITY_DEBUG(),
}
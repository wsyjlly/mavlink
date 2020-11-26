package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "ESC_FAILURE_FLAGS", bitmask = "true")
public enum  EscFailureFlags {
	
	/**
	 * No ESC failure.
	 */
	@MavlinkEnumEntry(value = 0,description = "No ESC failure.")
	ESC_FAILURE_NONE(),
	
	/**
	 * Over current failure.
	 */
	@MavlinkEnumEntry(value = 1,description = "Over current failure.")
	ESC_FAILURE_OVER_CURRENT(),
	
	/**
	 * Over voltage failure.
	 */
	@MavlinkEnumEntry(value = 2,description = "Over voltage failure.")
	ESC_FAILURE_OVER_VOLTAGE(),
	
	/**
	 * Over temperature failure.
	 */
	@MavlinkEnumEntry(value = 4,description = "Over temperature failure.")
	ESC_FAILURE_OVER_TEMPERATURE(),
	
	/**
	 * Over RPM failure.
	 */
	@MavlinkEnumEntry(value = 8,description = "Over RPM failure.")
	ESC_FAILURE_OVER_RPM(),
	
	/**
	 * Inconsistent command failure i.e. out of bounds.
	 */
	@MavlinkEnumEntry(value = 16,description = "Inconsistent command failure i.e. out of bounds.")
	ESC_FAILURE_INCONSISTENT_CMD(),
	
	/**
	 * Motor stuck failure.
	 */
	@MavlinkEnumEntry(value = 32,description = "Motor stuck failure.")
	ESC_FAILURE_MOTOR_STUCK(),
	
	/**
	 * Generic ESC failure.
	 */
	@MavlinkEnumEntry(value = 64,description = "Generic ESC failure.")
	ESC_FAILURE_GENERIC(),
}
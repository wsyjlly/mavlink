package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "FAILURE_TYPE")
public enum  FailureType {
	
	/**
	 * No failure injected, used to reset a previous failure.
	 */
	@MavlinkEnumEntry(value = 0,description = "No failure injected, used to reset a previous failure.")
	FAILURE_TYPE_OK(),
	
	/**
	 * Sets unit off, so completely non-responsive.
	 */
	@MavlinkEnumEntry(value = 1,description = "Sets unit off, so completely non-responsive.")
	FAILURE_TYPE_OFF(),
	
	/**
	 * Unit is stuck e.g. keeps reporting the same value.
	 */
	@MavlinkEnumEntry(value = 2,description = "Unit is stuck e.g. keeps reporting the same value.")
	FAILURE_TYPE_STUCK(),
	
	/**
	 * Unit is reporting complete garbage.
	 */
	@MavlinkEnumEntry(value = 3,description = "Unit is reporting complete garbage.")
	FAILURE_TYPE_GARBAGE(),
	
	/**
	 * Unit is consistently wrong.
	 */
	@MavlinkEnumEntry(value = 4,description = "Unit is consistently wrong.")
	FAILURE_TYPE_WRONG(),
	
	/**
	 * Unit is slow, so e.g. reporting at slower than expected rate.
	 */
	@MavlinkEnumEntry(value = 5,description = "Unit is slow, so e.g. reporting at slower than expected rate.")
	FAILURE_TYPE_SLOW(),
	
	/**
	 * Data of unit is delayed in time.
	 */
	@MavlinkEnumEntry(value = 6,description = "Data of unit is delayed in time.")
	FAILURE_TYPE_DELAYED(),
	
	/**
	 * Unit is sometimes working, sometimes not.
	 */
	@MavlinkEnumEntry(value = 7,description = "Unit is sometimes working, sometimes not.")
	FAILURE_TYPE_INTERMITTENT(),
}
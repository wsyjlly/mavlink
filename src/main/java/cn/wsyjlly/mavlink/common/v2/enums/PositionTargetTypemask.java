package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "POSITION_TARGET_TYPEMASK", bitmask = "true")
public enum  PositionTargetTypemask {
	
	/**
	 * Ignore position x
	 */
	@MavlinkEnumEntry(value = 1,description = "Ignore position x")
	POSITION_TARGET_TYPEMASK_X_IGNORE(),
	
	/**
	 * Ignore position y
	 */
	@MavlinkEnumEntry(value = 2,description = "Ignore position y")
	POSITION_TARGET_TYPEMASK_Y_IGNORE(),
	
	/**
	 * Ignore position z
	 */
	@MavlinkEnumEntry(value = 4,description = "Ignore position z")
	POSITION_TARGET_TYPEMASK_Z_IGNORE(),
	
	/**
	 * Ignore velocity x
	 */
	@MavlinkEnumEntry(value = 8,description = "Ignore velocity x")
	POSITION_TARGET_TYPEMASK_VX_IGNORE(),
	
	/**
	 * Ignore velocity y
	 */
	@MavlinkEnumEntry(value = 16,description = "Ignore velocity y")
	POSITION_TARGET_TYPEMASK_VY_IGNORE(),
	
	/**
	 * Ignore velocity z
	 */
	@MavlinkEnumEntry(value = 32,description = "Ignore velocity z")
	POSITION_TARGET_TYPEMASK_VZ_IGNORE(),
	
	/**
	 * Ignore acceleration x
	 */
	@MavlinkEnumEntry(value = 64,description = "Ignore acceleration x")
	POSITION_TARGET_TYPEMASK_AX_IGNORE(),
	
	/**
	 * Ignore acceleration y
	 */
	@MavlinkEnumEntry(value = 128,description = "Ignore acceleration y")
	POSITION_TARGET_TYPEMASK_AY_IGNORE(),
	
	/**
	 * Ignore acceleration z
	 */
	@MavlinkEnumEntry(value = 256,description = "Ignore acceleration z")
	POSITION_TARGET_TYPEMASK_AZ_IGNORE(),
	
	/**
	 * Use force instead of acceleration
	 */
	@MavlinkEnumEntry(value = 512,description = "Use force instead of acceleration")
	POSITION_TARGET_TYPEMASK_FORCE_SET(),
	
	/**
	 * Ignore yaw
	 */
	@MavlinkEnumEntry(value = 1024,description = "Ignore yaw")
	POSITION_TARGET_TYPEMASK_YAW_IGNORE(),
	
	/**
	 * Ignore yaw rate
	 */
	@MavlinkEnumEntry(value = 2048,description = "Ignore yaw rate")
	POSITION_TARGET_TYPEMASK_YAW_RATE_IGNORE(),
}
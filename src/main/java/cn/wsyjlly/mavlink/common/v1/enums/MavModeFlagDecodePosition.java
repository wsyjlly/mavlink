package cn.wsyjlly.mavlink.common.v1.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:45
 *
 **********************************/

@MavlinkEnum(name = "MAV_MODE_FLAG_DECODE_POSITION")
public enum  MavModeFlagDecodePosition {
	
	/**
	 * First bit: 10000000
	 */
	@MavlinkEnumEntry(value = 128,description = "First bit: 10000000")
	MAV_MODE_FLAG_DECODE_POSITION_SAFETY(),
	
	/**
	 * Second bit: 01000000
	 */
	@MavlinkEnumEntry(value = 64,description = "Second bit: 01000000")
	MAV_MODE_FLAG_DECODE_POSITION_MANUAL(),
	
	/**
	 * Third bit: 00100000
	 */
	@MavlinkEnumEntry(value = 32,description = "Third bit: 00100000")
	MAV_MODE_FLAG_DECODE_POSITION_HIL(),
	
	/**
	 * Fourth bit: 00010000
	 */
	@MavlinkEnumEntry(value = 16,description = "Fourth bit: 00010000")
	MAV_MODE_FLAG_DECODE_POSITION_STABILIZE(),
	
	/**
	 * Fifth bit: 00001000
	 */
	@MavlinkEnumEntry(value = 8,description = "Fifth bit: 00001000")
	MAV_MODE_FLAG_DECODE_POSITION_GUIDED(),
	
	/**
	 * Sixt bit: 00000100
	 */
	@MavlinkEnumEntry(value = 4,description = "Sixt bit: 00000100")
	MAV_MODE_FLAG_DECODE_POSITION_AUTO(),
	
	/**
	 * Seventh bit: 00000010
	 */
	@MavlinkEnumEntry(value = 2,description = "Seventh bit: 00000010")
	MAV_MODE_FLAG_DECODE_POSITION_TEST(),
	
	/**
	 * Eighth bit: 00000001
	 */
	@MavlinkEnumEntry(value = 1,description = "Eighth bit: 00000001")
	MAV_MODE_FLAG_DECODE_POSITION_CUSTOM_MODE(),
}
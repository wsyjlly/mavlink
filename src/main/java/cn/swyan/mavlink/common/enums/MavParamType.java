package cn.swyan.mavlink.common.enums;

import cn.swyan.mavlink.annotation.MavlinkEnum;
import cn.swyan.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * @Author YSW
 * @Description
 * @Date 2020.11.04 - 03:56
 *
 **********************************/

@MavlinkEnum(name = "MAV_PARAM_TYPE")
public enum  MavParamType {
	
	/**
	 * 8-bit unsigned integer
	 */
	@MavlinkEnumEntry(value = 1,description = "8-bit unsigned integer")
	MAV_PARAM_TYPE_UINT8(),
	
	/**
	 * 8-bit signed integer
	 */
	@MavlinkEnumEntry(value = 2,description = "8-bit signed integer")
	MAV_PARAM_TYPE_INT8(),
	
	/**
	 * 16-bit unsigned integer
	 */
	@MavlinkEnumEntry(value = 3,description = "16-bit unsigned integer")
	MAV_PARAM_TYPE_UINT16(),
	
	/**
	 * 16-bit signed integer
	 */
	@MavlinkEnumEntry(value = 4,description = "16-bit signed integer")
	MAV_PARAM_TYPE_INT16(),
	
	/**
	 * 32-bit unsigned integer
	 */
	@MavlinkEnumEntry(value = 5,description = "32-bit unsigned integer")
	MAV_PARAM_TYPE_UINT32(),
	
	/**
	 * 32-bit signed integer
	 */
	@MavlinkEnumEntry(value = 6,description = "32-bit signed integer")
	MAV_PARAM_TYPE_INT32(),
	
	/**
	 * 64-bit unsigned integer
	 */
	@MavlinkEnumEntry(value = 7,description = "64-bit unsigned integer")
	MAV_PARAM_TYPE_UINT64(),
	
	/**
	 * 64-bit signed integer
	 */
	@MavlinkEnumEntry(value = 8,description = "64-bit signed integer")
	MAV_PARAM_TYPE_INT64(),
	
	/**
	 * 32-bit floating-point
	 */
	@MavlinkEnumEntry(value = 9,description = "32-bit floating-point")
	MAV_PARAM_TYPE_REAL32(),
	
	/**
	 * 64-bit floating-point
	 */
	@MavlinkEnumEntry(value = 10,description = "64-bit floating-point")
	MAV_PARAM_TYPE_REAL64(),
}
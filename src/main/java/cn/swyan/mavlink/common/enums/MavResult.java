package cn.swyan.mavlink.common.enums;

import cn.swyan.mavlink.annotation.MavlinkEnum;
import cn.swyan.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * @Author YSW
 * @Description
 * @Date 2020.11.04 - 03:56
 *
 **********************************/

@MavlinkEnum(name = "MAV_RESULT")
public enum  MavResult {
	
	/**
	 * Command ACCEPTED and EXECUTED
	 */
	@MavlinkEnumEntry(value = 0,description = "Command ACCEPTED and EXECUTED")
	MAV_RESULT_ACCEPTED(),
	
	/**
	 * Command TEMPORARY REJECTED/DENIED
	 */
	@MavlinkEnumEntry(value = 1,description = "Command TEMPORARY REJECTED/DENIED")
	MAV_RESULT_TEMPORARILY_REJECTED(),
	
	/**
	 * Command PERMANENTLY DENIED
	 */
	@MavlinkEnumEntry(value = 2,description = "Command PERMANENTLY DENIED")
	MAV_RESULT_DENIED(),
	
	/**
	 * Command UNKNOWN/UNSUPPORTED
	 */
	@MavlinkEnumEntry(value = 3,description = "Command UNKNOWN/UNSUPPORTED")
	MAV_RESULT_UNSUPPORTED(),
	
	/**
	 * Command executed, but failed
	 */
	@MavlinkEnumEntry(value = 4,description = "Command executed, but failed")
	MAV_RESULT_FAILED(),
}
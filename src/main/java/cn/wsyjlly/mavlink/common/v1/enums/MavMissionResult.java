package cn.wsyjlly.mavlink.common.v1.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:45
 *
 **********************************/

@MavlinkEnum(name = "MAV_MISSION_RESULT")
public enum  MavMissionResult {
	
	/**
	 * mission accepted OK
	 */
	@MavlinkEnumEntry(value = 0,description = "mission accepted OK")
	MAV_MISSION_ACCEPTED(),
	
	/**
	 * generic error / not accepting mission commands at all right now
	 */
	@MavlinkEnumEntry(value = 1,description = "generic error / not accepting mission commands at all right now")
	MAV_MISSION_ERROR(),
	
	/**
	 * coordinate frame is not supported
	 */
	@MavlinkEnumEntry(value = 2,description = "coordinate frame is not supported")
	MAV_MISSION_UNSUPPORTED_FRAME(),
	
	/**
	 * command is not supported
	 */
	@MavlinkEnumEntry(value = 3,description = "command is not supported")
	MAV_MISSION_UNSUPPORTED(),
	
	/**
	 * mission item exceeds storage space
	 */
	@MavlinkEnumEntry(value = 4,description = "mission item exceeds storage space")
	MAV_MISSION_NO_SPACE(),
	
	/**
	 * one of the parameters has an invalid value
	 */
	@MavlinkEnumEntry(value = 5,description = "one of the parameters has an invalid value")
	MAV_MISSION_INVALID(),
	
	/**
	 * param1 has an invalid value
	 */
	@MavlinkEnumEntry(value = 6,description = "param1 has an invalid value")
	MAV_MISSION_INVALID_PARAM1(),
	
	/**
	 * param2 has an invalid value
	 */
	@MavlinkEnumEntry(value = 7,description = "param2 has an invalid value")
	MAV_MISSION_INVALID_PARAM2(),
	
	/**
	 * param3 has an invalid value
	 */
	@MavlinkEnumEntry(value = 8,description = "param3 has an invalid value")
	MAV_MISSION_INVALID_PARAM3(),
	
	/**
	 * param4 has an invalid value
	 */
	@MavlinkEnumEntry(value = 9,description = "param4 has an invalid value")
	MAV_MISSION_INVALID_PARAM4(),
	
	/**
	 * x/param5 has an invalid value
	 */
	@MavlinkEnumEntry(value = 10,description = "x/param5 has an invalid value")
	MAV_MISSION_INVALID_PARAM5_X(),
	
	/**
	 * y/param6 has an invalid value
	 */
	@MavlinkEnumEntry(value = 11,description = "y/param6 has an invalid value")
	MAV_MISSION_INVALID_PARAM6_Y(),
	
	/**
	 * param7 has an invalid value
	 */
	@MavlinkEnumEntry(value = 12,description = "param7 has an invalid value")
	MAV_MISSION_INVALID_PARAM7(),
	
	/**
	 * received waypoint out of sequence
	 */
	@MavlinkEnumEntry(value = 13,description = "received waypoint out of sequence")
	MAV_MISSION_INVALID_SEQUENCE(),
	
	/**
	 * not accepting any mission commands from this communication partner
	 */
	@MavlinkEnumEntry(value = 14,description = "not accepting any mission commands from this communication partner")
	MAV_MISSION_DENIED(),
}
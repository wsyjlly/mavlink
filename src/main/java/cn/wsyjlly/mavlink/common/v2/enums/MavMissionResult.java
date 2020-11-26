package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
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
	 * Generic error / not accepting mission commands at all right now.
	 */
	@MavlinkEnumEntry(value = 1,description = "Generic error / not accepting mission commands at all right now.")
	MAV_MISSION_ERROR(),
	
	/**
	 * Coordinate frame is not supported.
	 */
	@MavlinkEnumEntry(value = 2,description = "Coordinate frame is not supported.")
	MAV_MISSION_UNSUPPORTED_FRAME(),
	
	/**
	 * Command is not supported.
	 */
	@MavlinkEnumEntry(value = 3,description = "Command is not supported.")
	MAV_MISSION_UNSUPPORTED(),
	
	/**
	 * Mission items exceed storage space.
	 */
	@MavlinkEnumEntry(value = 4,description = "Mission items exceed storage space.")
	MAV_MISSION_NO_SPACE(),
	
	/**
	 * One of the parameters has an invalid value.
	 */
	@MavlinkEnumEntry(value = 5,description = "One of the parameters has an invalid value.")
	MAV_MISSION_INVALID(),
	
	/**
	 * param1 has an invalid value.
	 */
	@MavlinkEnumEntry(value = 6,description = "param1 has an invalid value.")
	MAV_MISSION_INVALID_PARAM1(),
	
	/**
	 * param2 has an invalid value.
	 */
	@MavlinkEnumEntry(value = 7,description = "param2 has an invalid value.")
	MAV_MISSION_INVALID_PARAM2(),
	
	/**
	 * param3 has an invalid value.
	 */
	@MavlinkEnumEntry(value = 8,description = "param3 has an invalid value.")
	MAV_MISSION_INVALID_PARAM3(),
	
	/**
	 * param4 has an invalid value.
	 */
	@MavlinkEnumEntry(value = 9,description = "param4 has an invalid value.")
	MAV_MISSION_INVALID_PARAM4(),
	
	/**
	 * x / param5 has an invalid value.
	 */
	@MavlinkEnumEntry(value = 10,description = "x / param5 has an invalid value.")
	MAV_MISSION_INVALID_PARAM5_X(),
	
	/**
	 * y / param6 has an invalid value.
	 */
	@MavlinkEnumEntry(value = 11,description = "y / param6 has an invalid value.")
	MAV_MISSION_INVALID_PARAM6_Y(),
	
	/**
	 * z / param7 has an invalid value.
	 */
	@MavlinkEnumEntry(value = 12,description = "z / param7 has an invalid value.")
	MAV_MISSION_INVALID_PARAM7(),
	
	/**
	 * Mission item received out of sequence
	 */
	@MavlinkEnumEntry(value = 13,description = "Mission item received out of sequence")
	MAV_MISSION_INVALID_SEQUENCE(),
	
	/**
	 * Not accepting any mission commands from this communication partner.
	 */
	@MavlinkEnumEntry(value = 14,description = "Not accepting any mission commands from this communication partner.")
	MAV_MISSION_DENIED(),
	
	/**
	 * Current mission operation cancelled (e.g. mission upload, mission download).
	 */
	@MavlinkEnumEntry(value = 15,description = "Current mission operation cancelled (e.g. mission upload, mission download).")
	MAV_MISSION_OPERATION_CANCELLED(),
}
package cn.wsyjlly.mavlink.common.v1.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:45
 *
 **********************************/

@MavlinkEnum(name = "MAV_PROTOCOL_CAPABILITY")
public enum  MavProtocolCapability {
	
	/**
	 * Autopilot supports MISSION float message type.
	 */
	@MavlinkEnumEntry(value = 1,description = "Autopilot supports MISSION float message type.")
	MAV_PROTOCOL_CAPABILITY_MISSION_FLOAT(),
	
	/**
	 * Autopilot supports the new param float message type.
	 */
	@MavlinkEnumEntry(value = 2,description = "Autopilot supports the new param float message type.")
	MAV_PROTOCOL_CAPABILITY_PARAM_FLOAT(),
	
	/**
	 * Autopilot supports MISSION_INT scaled integer message type.
	 */
	@MavlinkEnumEntry(value = 4,description = "Autopilot supports MISSION_INT scaled integer message type.")
	MAV_PROTOCOL_CAPABILITY_MISSION_INT(),
	
	/**
	 * Autopilot supports COMMAND_INT scaled integer message type.
	 */
	@MavlinkEnumEntry(value = 8,description = "Autopilot supports COMMAND_INT scaled integer message type.")
	MAV_PROTOCOL_CAPABILITY_COMMAND_INT(),
	
	/**
	 * Autopilot supports the new param union message type.
	 */
	@MavlinkEnumEntry(value = 16,description = "Autopilot supports the new param union message type.")
	MAV_PROTOCOL_CAPABILITY_PARAM_UNION(),
	
	/**
	 * Autopilot supports the new param union message type.
	 */
	@MavlinkEnumEntry(value = 32,description = "Autopilot supports the new param union message type.")
	MAV_PROTOCOL_CAPABILITY_FTP(),
	
	/**
	 * Autopilot supports commanding attitude offboard.
	 */
	@MavlinkEnumEntry(value = 64,description = "Autopilot supports commanding attitude offboard.")
	MAV_PROTOCOL_CAPABILITY_SET_ATTITUDE_TARGET(),
	
	/**
	 * Autopilot supports commanding position and velocity targets in local NED frame.
	 */
	@MavlinkEnumEntry(value = 128,description = "Autopilot supports commanding position and velocity targets in local NED frame.")
	MAV_PROTOCOL_CAPABILITY_SET_POSITION_TARGET_LOCAL_NED(),
	
	/**
	 * Autopilot supports commanding position and velocity targets in global scaled integers.
	 */
	@MavlinkEnumEntry(value = 256,description = "Autopilot supports commanding position and velocity targets in global scaled integers.")
	MAV_PROTOCOL_CAPABILITY_SET_POSITION_TARGET_GLOBAL_INT(),
	
	/**
	 * Autopilot supports terrain protocol / data handling.
	 */
	@MavlinkEnumEntry(value = 512,description = "Autopilot supports terrain protocol / data handling.")
	MAV_PROTOCOL_CAPABILITY_TERRAIN(),
}
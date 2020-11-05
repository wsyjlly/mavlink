package cn.swyan.mavlink.common.enums;

import cn.swyan.mavlink.annotation.MavlinkEnum;
import cn.swyan.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * @Author YSW
 * @Description
 * @Date 2020.11.04 - 03:56
 *
 **********************************/

@MavlinkEnum(name = "MAV_CMD_ACK")
public enum  MavCmdAck {
	
	/**
	 * Command / mission item is ok.
	 */
	@MavlinkEnumEntry(description = "Command / mission item is ok.")
	MAV_CMD_ACK_OK(),
	
	/**
	 * Generic error message if none of the other reasons fails or if no detailed error reporting is implemented.
	 */
	@MavlinkEnumEntry(description = "Generic error message if none of the other reasons fails or if no detailed error reporting is implemented.")
	MAV_CMD_ACK_ERR_FAIL(),
	
	/**
	 * The system is refusing to accept this command from this source / communication partner.
	 */
	@MavlinkEnumEntry(description = "The system is refusing to accept this command from this source / communication partner.")
	MAV_CMD_ACK_ERR_ACCESS_DENIED(),
	
	/**
	 * Command or mission item is not supported, other commands would be accepted.
	 */
	@MavlinkEnumEntry(description = "Command or mission item is not supported, other commands would be accepted.")
	MAV_CMD_ACK_ERR_NOT_SUPPORTED(),
	
	/**
	 * The coordinate frame of this command / mission item is not supported.
	 */
	@MavlinkEnumEntry(description = "The coordinate frame of this command / mission item is not supported.")
	MAV_CMD_ACK_ERR_COORDINATE_FRAME_NOT_SUPPORTED(),
	
	/**
	 * The coordinate frame of this command is ok, but he coordinate values exceed the safety limits of this system. This is a generic error, please use the more specific error messages below if possible.
	 */
	@MavlinkEnumEntry(description = "The coordinate frame of this command is ok, but he coordinate values exceed the safety limits of this system. This is a generic error, please use the more specific error messages below if possible.")
	MAV_CMD_ACK_ERR_COORDINATES_OUT_OF_RANGE(),
	
	/**
	 * The X or latitude value is out of range.
	 */
	@MavlinkEnumEntry(description = "The X or latitude value is out of range.")
	MAV_CMD_ACK_ERR_X_LAT_OUT_OF_RANGE(),
	
	/**
	 * The Y or longitude value is out of range.
	 */
	@MavlinkEnumEntry(description = "The Y or longitude value is out of range.")
	MAV_CMD_ACK_ERR_Y_LON_OUT_OF_RANGE(),
	
	/**
	 * The Z or altitude value is out of range.
	 */
	@MavlinkEnumEntry(description = "The Z or altitude value is out of range.")
	MAV_CMD_ACK_ERR_Z_ALT_OUT_OF_RANGE(),
}
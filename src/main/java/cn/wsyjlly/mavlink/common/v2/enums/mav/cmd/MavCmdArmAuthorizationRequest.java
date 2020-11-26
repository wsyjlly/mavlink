package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 3001, name = "MAV_CMD_ARM_AUTHORIZATION_REQUEST", hasLocation = "false", isDestination = "false", description = "Request authorization to arm the vehicle to a external entity, the arm authorizer is responsible to request all data that is needs from the vehicle before authorize or deny the request. If approved the progress of command_ack message should be set with period of time that this authorization is valid in seconds or in case it was denied it should be set with one of the reasons in ARM_AUTH_DENIED_REASON.")
public enum MavCmdArmAuthorizationRequest {

	/**
	 * Vehicle system id, this way ground station can request arm authorization on behalf of any vehicle
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "System ID", minValue = 0, maxValue = 255, increment = 1)
	PARAM_1(),
}
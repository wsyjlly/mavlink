package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "MAV_ODID_AUTH_TYPE")
public enum  MavOdidAuthType {
	
	/**
	 * No authentication type is specified.
	 */
	@MavlinkEnumEntry(value = 0,description = "No authentication type is specified.")
	MAV_ODID_AUTH_TYPE_NONE(),
	
	/**
	 * Signature for the UAS (Unmanned Aircraft System) ID.
	 */
	@MavlinkEnumEntry(value = 1,description = "Signature for the UAS (Unmanned Aircraft System) ID.")
	MAV_ODID_AUTH_TYPE_UAS_ID_SIGNATURE(),
	
	/**
	 * Signature for the Operator ID.
	 */
	@MavlinkEnumEntry(value = 2,description = "Signature for the Operator ID.")
	MAV_ODID_AUTH_TYPE_OPERATOR_ID_SIGNATURE(),
	
	/**
	 * Signature for the entire message set.
	 */
	@MavlinkEnumEntry(value = 3,description = "Signature for the entire message set.")
	MAV_ODID_AUTH_TYPE_MESSAGE_SET_SIGNATURE(),
	
	/**
	 * Authentication is provided by Network Remote ID.
	 */
	@MavlinkEnumEntry(value = 4,description = "Authentication is provided by Network Remote ID.")
	MAV_ODID_AUTH_TYPE_NETWORK_REMOTE_ID(),
}
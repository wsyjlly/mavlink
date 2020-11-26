package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "CELLULAR_CONFIG_RESPONSE")
public enum  CellularConfigResponse {
	
	/**
	 * Changes accepted.
	 */
	@MavlinkEnumEntry(value = 0,description = "Changes accepted.")
	CELLULAR_CONFIG_RESPONSE_ACCEPTED(),
	
	/**
	 * Invalid APN.
	 */
	@MavlinkEnumEntry(value = 1,description = "Invalid APN.")
	CELLULAR_CONFIG_RESPONSE_APN_ERROR(),
	
	/**
	 * Invalid PIN.
	 */
	@MavlinkEnumEntry(value = 2,description = "Invalid PIN.")
	CELLULAR_CONFIG_RESPONSE_PIN_ERROR(),
	
	/**
	 * Changes rejected.
	 */
	@MavlinkEnumEntry(value = 3,description = "Changes rejected.")
	CELLULAR_CONFIG_RESPONSE_REJECTED(),
	
	/**
	 * PUK is required to unblock SIM card.
	 */
	@MavlinkEnumEntry(value = 4,description = "PUK is required to unblock SIM card.")
	CELLULAR_CONFIG_BLOCKED_PUK_REQUIRED(),
}
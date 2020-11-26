package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "CELLULAR_NETWORK_FAILED_REASON")
public enum  CellularNetworkFailedReason {
	
	/**
	 * No error
	 */
	@MavlinkEnumEntry(value = 0,description = "No error")
	CELLULAR_NETWORK_FAILED_REASON_NONE(),
	
	/**
	 * Error state is unknown
	 */
	@MavlinkEnumEntry(value = 1,description = "Error state is unknown")
	CELLULAR_NETWORK_FAILED_REASON_UNKNOWN(),
	
	/**
	 * SIM is required for the modem but missing
	 */
	@MavlinkEnumEntry(value = 2,description = "SIM is required for the modem but missing")
	CELLULAR_NETWORK_FAILED_REASON_SIM_MISSING(),
	
	/**
	 * SIM is available, but not usuable for connection
	 */
	@MavlinkEnumEntry(value = 3,description = "SIM is available, but not usuable for connection")
	CELLULAR_NETWORK_FAILED_REASON_SIM_ERROR(),
}
package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "PARAM_ACK")
public enum  ParamAck {
	
	/**
	 * Parameter value ACCEPTED and SET
	 */
	@MavlinkEnumEntry(value = 0,description = "Parameter value ACCEPTED and SET")
	PARAM_ACK_ACCEPTED(),
	
	/**
	 * Parameter value UNKNOWN/UNSUPPORTED
	 */
	@MavlinkEnumEntry(value = 1,description = "Parameter value UNKNOWN/UNSUPPORTED")
	PARAM_ACK_VALUE_UNSUPPORTED(),
	
	/**
	 * Parameter failed to set
	 */
	@MavlinkEnumEntry(value = 2,description = "Parameter failed to set")
	PARAM_ACK_FAILED(),
	
	/**
	 * Parameter value received but not yet set/accepted. A subsequent PARAM_ACK_TRANSACTION or PARAM_EXT_ACK with the final result will follow once operation is completed. This is returned immediately for parameters that take longer to set, indicating taht the the parameter was recieved and does not need to be resent.
	 */
	@MavlinkEnumEntry(value = 3,description = "Parameter value received but not yet set/accepted. A subsequent PARAM_ACK_TRANSACTION or PARAM_EXT_ACK with the final result will follow once operation is completed. This is returned immediately for parameters that take longer to set, indicating taht the the parameter was recieved and does not need to be resent.")
	PARAM_ACK_IN_PROGRESS(),
}
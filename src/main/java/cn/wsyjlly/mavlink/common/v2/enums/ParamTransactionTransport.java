package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "PARAM_TRANSACTION_TRANSPORT")
public enum  ParamTransactionTransport {
	
	/**
	 * Transaction over param transport.
	 */
	@MavlinkEnumEntry(value = 0,description = "Transaction over param transport.")
	PARAM_TRANSACTION_TRANSPORT_PARAM(),
	
	/**
	 * Transaction over param_ext transport.
	 */
	@MavlinkEnumEntry(value = 1,description = "Transaction over param_ext transport.")
	PARAM_TRANSACTION_TRANSPORT_PARAM_EXT(),
}
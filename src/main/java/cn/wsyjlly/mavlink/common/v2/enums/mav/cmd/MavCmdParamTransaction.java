package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;
import cn.wsyjlly.mavlink.common.v2.enums.ParamTransactionAction;
import cn.wsyjlly.mavlink.common.v2.enums.ParamTransactionTransport;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 900, name = "MAV_CMD_PARAM_TRANSACTION", hasLocation = "false", isDestination = "false", description = "Request to start or end a parameter transaction. Multiple kinds of transport layers can be used to exchange parameters in the transaction (param, param_ext and mavftp). The command response can either be a success/failure or an in progress in case the receiving side takes some time to apply the parameters.")
public enum MavCmdParamTransaction {

	/**
	 * Action to be performed (start, commit, cancel, etc.)
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Action", enum0 = ParamTransactionAction.class)
	PARAM_1(),

	/**
	 * Possible transport layers to set and get parameters via mavlink during a parameter transaction.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Transport", enum0 = ParamTransactionTransport.class)
	PARAM_2(),

	/**
	 * Identifier for a specific transaction.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, label = "Transaction ID")
	PARAM_3(),
}
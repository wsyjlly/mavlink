package cn.wsyjlly.mavlink.common.v2.enums.mav.cmd;

import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntry;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumMavCmdEntryParam;
import cn.wsyjlly.mavlink.common.v2.enums.FailureUnit;
import cn.wsyjlly.mavlink.common.v2.enums.FailureType;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkEnumMavCmdEntry(value = 420, name = "MAV_CMD_INJECT_FAILURE", hasLocation = "null", isDestination = "null", description = "Inject artificial failure for testing purposes. Note that autopilots should implement an additional protection before accepting this command such as a specific param setting.")
public enum MavCmdInjectFailure {

	/**
	 * The unit which is affected by the failure.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 1, label = "Failure unit", enum0 = FailureUnit.class)
	PARAM_1(),

	/**
	 * The type how the failure manifests itself.
	 */
	@MavlinkEnumMavCmdEntryParam(index = 2, label = "Failure type", enum0 = FailureType.class)
	PARAM_2(),

	/**
	 * Instance affected by failure (0 to signal all).
	 */
	@MavlinkEnumMavCmdEntryParam(index = 3, label = "Instance")
	PARAM_3(),
}
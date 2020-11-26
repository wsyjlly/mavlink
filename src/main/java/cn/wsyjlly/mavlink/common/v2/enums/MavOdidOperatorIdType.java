package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "MAV_ODID_OPERATOR_ID_TYPE")
public enum  MavOdidOperatorIdType {
	
	/**
	 * CAA (Civil Aviation Authority) registered operator ID.
	 */
	@MavlinkEnumEntry(value = 0,description = "CAA (Civil Aviation Authority) registered operator ID.")
	MAV_ODID_OPERATOR_ID_TYPE_CAA(),
}
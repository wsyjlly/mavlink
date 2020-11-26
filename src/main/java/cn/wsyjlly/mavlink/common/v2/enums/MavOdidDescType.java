package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "MAV_ODID_DESC_TYPE")
public enum  MavOdidDescType {
	
	/**
	 * Free-form text description of the purpose of the flight.
	 */
	@MavlinkEnumEntry(value = 0,description = "Free-form text description of the purpose of the flight.")
	MAV_ODID_DESC_TYPE_TEXT(),
}
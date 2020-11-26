package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "MAV_ODID_HEIGHT_REF")
public enum  MavOdidHeightRef {
	
	/**
	 * The height field is relative to the take-off location.
	 */
	@MavlinkEnumEntry(value = 0,description = "The height field is relative to the take-off location.")
	MAV_ODID_HEIGHT_REF_OVER_TAKEOFF(),
	
	/**
	 * The height field is relative to ground.
	 */
	@MavlinkEnumEntry(value = 1,description = "The height field is relative to ground.")
	MAV_ODID_HEIGHT_REF_OVER_GROUND(),
}
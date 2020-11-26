package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "MAV_LANDED_STATE")
public enum  MavLandedState {
	
	/**
	 * MAV landed state is unknown
	 */
	@MavlinkEnumEntry(value = 0,description = "MAV landed state is unknown")
	MAV_LANDED_STATE_UNDEFINED(),
	
	/**
	 * MAV is landed (on ground)
	 */
	@MavlinkEnumEntry(value = 1,description = "MAV is landed (on ground)")
	MAV_LANDED_STATE_ON_GROUND(),
	
	/**
	 * MAV is in air
	 */
	@MavlinkEnumEntry(value = 2,description = "MAV is in air")
	MAV_LANDED_STATE_IN_AIR(),
	
	/**
	 * MAV currently taking off
	 */
	@MavlinkEnumEntry(value = 3,description = "MAV currently taking off")
	MAV_LANDED_STATE_TAKEOFF(),
	
	/**
	 * MAV currently landing
	 */
	@MavlinkEnumEntry(value = 4,description = "MAV currently landing")
	MAV_LANDED_STATE_LANDING(),
}
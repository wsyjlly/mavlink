package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "MAV_VTOL_STATE")
public enum  MavVtolState {
	
	/**
	 * MAV is not configured as VTOL
	 */
	@MavlinkEnumEntry(value = 0,description = "MAV is not configured as VTOL")
	MAV_VTOL_STATE_UNDEFINED(),
	
	/**
	 * VTOL is in transition from multicopter to fixed-wing
	 */
	@MavlinkEnumEntry(value = 1,description = "VTOL is in transition from multicopter to fixed-wing")
	MAV_VTOL_STATE_TRANSITION_TO_FW(),
	
	/**
	 * VTOL is in transition from fixed-wing to multicopter
	 */
	@MavlinkEnumEntry(value = 2,description = "VTOL is in transition from fixed-wing to multicopter")
	MAV_VTOL_STATE_TRANSITION_TO_MC(),
	
	/**
	 * VTOL is in multicopter state
	 */
	@MavlinkEnumEntry(value = 3,description = "VTOL is in multicopter state")
	MAV_VTOL_STATE_MC(),
	
	/**
	 * VTOL is in fixed-wing state
	 */
	@MavlinkEnumEntry(value = 4,description = "VTOL is in fixed-wing state")
	MAV_VTOL_STATE_FW(),
}
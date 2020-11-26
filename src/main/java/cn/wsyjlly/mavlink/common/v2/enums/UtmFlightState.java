package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "UTM_FLIGHT_STATE")
public enum  UtmFlightState {
	
	/**
	 * The flight state can't be determined.
	 */
	@MavlinkEnumEntry(value = 1,description = "The flight state can't be determined.")
	UTM_FLIGHT_STATE_UNKNOWN(),
	
	/**
	 * UAS on ground.
	 */
	@MavlinkEnumEntry(value = 2,description = "UAS on ground.")
	UTM_FLIGHT_STATE_GROUND(),
	
	/**
	 * UAS airborne.
	 */
	@MavlinkEnumEntry(value = 3,description = "UAS airborne.")
	UTM_FLIGHT_STATE_AIRBORNE(),
	
	/**
	 * UAS is in an emergency flight state.
	 */
	@MavlinkEnumEntry(value = 16,description = "UAS is in an emergency flight state.")
	UTM_FLIGHT_STATE_EMERGENCY(),
	
	/**
	 * UAS has no active controls.
	 */
	@MavlinkEnumEntry(value = 32,description = "UAS has no active controls.")
	UTM_FLIGHT_STATE_NOCTRL(),
}
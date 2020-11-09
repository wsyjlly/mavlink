package cn.wsyjlly.mavlink.common.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.09 - 03:37
 *
 **********************************/

@MavlinkEnum(name = "MAV_STATE")
public enum  MavState {
	
	/**
	 * Uninitialized system, state is unknown.
	 */
	@MavlinkEnumEntry(value = 0,description = "Uninitialized system, state is unknown.")
	MAV_STATE_UNINIT(),
	
	/**
	 * System is booting up.
	 */
	@MavlinkEnumEntry(description = "System is booting up.")
	MAV_STATE_BOOT(),
	
	/**
	 * System is calibrating and not flight-ready.
	 */
	@MavlinkEnumEntry(description = "System is calibrating and not flight-ready.")
	MAV_STATE_CALIBRATING(),
	
	/**
	 * System is grounded and on standby. It can be launched any time.
	 */
	@MavlinkEnumEntry(description = "System is grounded and on standby. It can be launched any time.")
	MAV_STATE_STANDBY(),
	
	/**
	 * System is active and might be already airborne. Motors are engaged.
	 */
	@MavlinkEnumEntry(description = "System is active and might be already airborne. Motors are engaged.")
	MAV_STATE_ACTIVE(),
	
	/**
	 * System is in a non-normal flight mode. It can however still navigate.
	 */
	@MavlinkEnumEntry(description = "System is in a non-normal flight mode. It can however still navigate.")
	MAV_STATE_CRITICAL(),
	
	/**
	 * System is in a non-normal flight mode. It lost control over parts or over the whole airframe. It is in mayday and going down.
	 */
	@MavlinkEnumEntry(description = "System is in a non-normal flight mode. It lost control over parts or over the whole airframe. It is in mayday and going down.")
	MAV_STATE_EMERGENCY(),
	
	/**
	 * System just initialized its power-down sequence, will shut down now.
	 */
	@MavlinkEnumEntry(description = "System just initialized its power-down sequence, will shut down now.")
	MAV_STATE_POWEROFF(),
}
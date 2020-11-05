package cn.swyan.mavlink.common.enums;

import cn.swyan.mavlink.annotation.MavlinkEnum;
import cn.swyan.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * @Author YSW
 * @Description
 * @Date 2020.11.04 - 03:56
 *
 **********************************/

@MavlinkEnum(name = "MAV_MODE")
public enum  MavMode {
	
	/**
	 * System is not ready to fly, booting, calibrating, etc. No flag is set.
	 */
	@MavlinkEnumEntry(value = 0,description = "System is not ready to fly, booting, calibrating, etc. No flag is set.")
	MAV_MODE_PREFLIGHT(),
	
	/**
	 * System is allowed to be active, under assisted RC control.
	 */
	@MavlinkEnumEntry(value = 80,description = "System is allowed to be active, under assisted RC control.")
	MAV_MODE_STABILIZE_DISARMED(),
	
	/**
	 * System is allowed to be active, under assisted RC control.
	 */
	@MavlinkEnumEntry(value = 208,description = "System is allowed to be active, under assisted RC control.")
	MAV_MODE_STABILIZE_ARMED(),
	
	/**
	 * System is allowed to be active, under manual (RC) control, no stabilization
	 */
	@MavlinkEnumEntry(value = 64,description = "System is allowed to be active, under manual (RC) control, no stabilization")
	MAV_MODE_MANUAL_DISARMED(),
	
	/**
	 * System is allowed to be active, under manual (RC) control, no stabilization
	 */
	@MavlinkEnumEntry(value = 192,description = "System is allowed to be active, under manual (RC) control, no stabilization")
	MAV_MODE_MANUAL_ARMED(),
	
	/**
	 * System is allowed to be active, under autonomous control, manual setpoint
	 */
	@MavlinkEnumEntry(value = 88,description = "System is allowed to be active, under autonomous control, manual setpoint")
	MAV_MODE_GUIDED_DISARMED(),
	
	/**
	 * System is allowed to be active, under autonomous control, manual setpoint
	 */
	@MavlinkEnumEntry(value = 216,description = "System is allowed to be active, under autonomous control, manual setpoint")
	MAV_MODE_GUIDED_ARMED(),
	
	/**
	 * System is allowed to be active, under autonomous control and navigation (the trajectory is decided onboard and not pre-programmed by MISSIONs)
	 */
	@MavlinkEnumEntry(value = 92,description = "System is allowed to be active, under autonomous control and navigation (the trajectory is decided onboard and not pre-programmed by MISSIONs)")
	MAV_MODE_AUTO_DISARMED(),
	
	/**
	 * System is allowed to be active, under autonomous control and navigation (the trajectory is decided onboard and not pre-programmed by MISSIONs)
	 */
	@MavlinkEnumEntry(value = 220,description = "System is allowed to be active, under autonomous control and navigation (the trajectory is decided onboard and not pre-programmed by MISSIONs)")
	MAV_MODE_AUTO_ARMED(),
	
	/**
	 * UNDEFINED mode. This solely depends on the autopilot - use with caution, intended for developers only.
	 */
	@MavlinkEnumEntry(value = 66,description = "UNDEFINED mode. This solely depends on the autopilot - use with caution, intended for developers only.")
	MAV_MODE_TEST_DISARMED(),
	
	/**
	 * UNDEFINED mode. This solely depends on the autopilot - use with caution, intended for developers only.
	 */
	@MavlinkEnumEntry(value = 194,description = "UNDEFINED mode. This solely depends on the autopilot - use with caution, intended for developers only.")
	MAV_MODE_TEST_ARMED(),
}
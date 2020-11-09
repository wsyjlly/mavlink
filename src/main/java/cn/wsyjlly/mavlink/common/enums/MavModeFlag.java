package cn.wsyjlly.mavlink.common.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.09 - 03:37
 *
 **********************************/

@MavlinkEnum(name = "MAV_MODE_FLAG")
public enum  MavModeFlag {
	
	/**
	 * 0b10000000 MAV safety set to armed. Motors are enabled / running / can start. Ready to fly.
	 */
	@MavlinkEnumEntry(value = 128,description = "0b10000000 MAV safety set to armed. Motors are enabled / running / can start. Ready to fly.")
	MAV_MODE_FLAG_SAFETY_ARMED(),
	
	/**
	 * 0b01000000 remote control input is enabled.
	 */
	@MavlinkEnumEntry(value = 64,description = "0b01000000 remote control input is enabled.")
	MAV_MODE_FLAG_MANUAL_INPUT_ENABLED(),
	
	/**
	 * 0b00100000 hardware in the loop simulation. All motors / actuators are blocked, but internal software is full operational.
	 */
	@MavlinkEnumEntry(value = 32,description = "0b00100000 hardware in the loop simulation. All motors / actuators are blocked, but internal software is full operational.")
	MAV_MODE_FLAG_HIL_ENABLED(),
	
	/**
	 * 0b00010000 system stabilizes electronically its attitude (and optionally position). It needs however further control inputs to move around.
	 */
	@MavlinkEnumEntry(value = 16,description = "0b00010000 system stabilizes electronically its attitude (and optionally position). It needs however further control inputs to move around.")
	MAV_MODE_FLAG_STABILIZE_ENABLED(),
	
	/**
	 * 0b00001000 guided mode enabled, system flies MISSIONs / mission items.
	 */
	@MavlinkEnumEntry(value = 8,description = "0b00001000 guided mode enabled, system flies MISSIONs / mission items.")
	MAV_MODE_FLAG_GUIDED_ENABLED(),
	
	/**
	 * 0b00000100 autonomous mode enabled, system finds its own goal positions. Guided flag can be set or not, depends on the actual implementation.
	 */
	@MavlinkEnumEntry(value = 4,description = "0b00000100 autonomous mode enabled, system finds its own goal positions. Guided flag can be set or not, depends on the actual implementation.")
	MAV_MODE_FLAG_AUTO_ENABLED(),
	
	/**
	 * 0b00000010 system has a test mode enabled. This flag is intended for temporary system tests and should not be used for stable implementations.
	 */
	@MavlinkEnumEntry(value = 2,description = "0b00000010 system has a test mode enabled. This flag is intended for temporary system tests and should not be used for stable implementations.")
	MAV_MODE_FLAG_TEST_ENABLED(),
	
	/**
	 * 0b00000001 Reserved for future use.
	 */
	@MavlinkEnumEntry(value = 1,description = "0b00000001 Reserved for future use.")
	MAV_MODE_FLAG_CUSTOM_MODE_ENABLED(),
}
package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "AIS_FLAGS", bitmask = "true")
public enum  AisFlags {
	
	/**
	 * 1 = Position accuracy less than 10m, 0 = position accuracy greater than 10m.
	 */
	@MavlinkEnumEntry(value = 1,description = "1 = Position accuracy less than 10m, 0 = position accuracy greater than 10m.")
	AIS_FLAGS_POSITION_ACCURACY(),
	
	/**
	 * AIS_FLAGS_VALID_COG
	 */
	@MavlinkEnumEntry(value = 2)
	AIS_FLAGS_VALID_COG(),
	
	/**
	 * AIS_FLAGS_VALID_VELOCITY
	 */
	@MavlinkEnumEntry(value = 4)
	AIS_FLAGS_VALID_VELOCITY(),
	
	/**
	 * 1 = Velocity over 52.5765m/s (102.2 knots)
	 */
	@MavlinkEnumEntry(value = 8,description = "1 = Velocity over 52.5765m/s (102.2 knots)")
	AIS_FLAGS_HIGH_VELOCITY(),
	
	/**
	 * AIS_FLAGS_VALID_TURN_RATE
	 */
	@MavlinkEnumEntry(value = 16)
	AIS_FLAGS_VALID_TURN_RATE(),
	
	/**
	 * Only the sign of the returned turn rate value is valid, either greater than 5deg/30s or less than -5deg/30s
	 */
	@MavlinkEnumEntry(value = 32,description = "Only the sign of the returned turn rate value is valid, either greater than 5deg/30s or less than -5deg/30s")
	AIS_FLAGS_TURN_RATE_SIGN_ONLY(),
	
	/**
	 * AIS_FLAGS_VALID_DIMENSIONS
	 */
	@MavlinkEnumEntry(value = 64)
	AIS_FLAGS_VALID_DIMENSIONS(),
	
	/**
	 * Distance to bow is larger than 511m
	 */
	@MavlinkEnumEntry(value = 128,description = "Distance to bow is larger than 511m")
	AIS_FLAGS_LARGE_BOW_DIMENSION(),
	
	/**
	 * Distance to stern is larger than 511m
	 */
	@MavlinkEnumEntry(value = 256,description = "Distance to stern is larger than 511m")
	AIS_FLAGS_LARGE_STERN_DIMENSION(),
	
	/**
	 * Distance to port side is larger than 63m
	 */
	@MavlinkEnumEntry(value = 512,description = "Distance to port side is larger than 63m")
	AIS_FLAGS_LARGE_PORT_DIMENSION(),
	
	/**
	 * Distance to starboard side is larger than 63m
	 */
	@MavlinkEnumEntry(value = 1024,description = "Distance to starboard side is larger than 63m")
	AIS_FLAGS_LARGE_STARBOARD_DIMENSION(),
	
	/**
	 * AIS_FLAGS_VALID_CALLSIGN
	 */
	@MavlinkEnumEntry(value = 2048)
	AIS_FLAGS_VALID_CALLSIGN(),
	
	/**
	 * AIS_FLAGS_VALID_NAME
	 */
	@MavlinkEnumEntry(value = 4096)
	AIS_FLAGS_VALID_NAME(),
}
package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "ADSB_FLAGS", bitmask = "true")
public enum  AdsbFlags {
	
	/**
	 * ADSB_FLAGS_VALID_COORDS
	 */
	@MavlinkEnumEntry(value = 1)
	ADSB_FLAGS_VALID_COORDS(),
	
	/**
	 * ADSB_FLAGS_VALID_ALTITUDE
	 */
	@MavlinkEnumEntry(value = 2)
	ADSB_FLAGS_VALID_ALTITUDE(),
	
	/**
	 * ADSB_FLAGS_VALID_HEADING
	 */
	@MavlinkEnumEntry(value = 4)
	ADSB_FLAGS_VALID_HEADING(),
	
	/**
	 * ADSB_FLAGS_VALID_VELOCITY
	 */
	@MavlinkEnumEntry(value = 8)
	ADSB_FLAGS_VALID_VELOCITY(),
	
	/**
	 * ADSB_FLAGS_VALID_CALLSIGN
	 */
	@MavlinkEnumEntry(value = 16)
	ADSB_FLAGS_VALID_CALLSIGN(),
	
	/**
	 * ADSB_FLAGS_VALID_SQUAWK
	 */
	@MavlinkEnumEntry(value = 32)
	ADSB_FLAGS_VALID_SQUAWK(),
	
	/**
	 * ADSB_FLAGS_SIMULATED
	 */
	@MavlinkEnumEntry(value = 64)
	ADSB_FLAGS_SIMULATED(),
	
	/**
	 * ADSB_FLAGS_VERTICAL_VELOCITY_VALID
	 */
	@MavlinkEnumEntry(value = 128)
	ADSB_FLAGS_VERTICAL_VELOCITY_VALID(),
	
	/**
	 * ADSB_FLAGS_BARO_VALID
	 */
	@MavlinkEnumEntry(value = 256)
	ADSB_FLAGS_BARO_VALID(),
	
	/**
	 * ADSB_FLAGS_SOURCE_UAT
	 */
	@MavlinkEnumEntry(value = 32768)
	ADSB_FLAGS_SOURCE_UAT(),
}
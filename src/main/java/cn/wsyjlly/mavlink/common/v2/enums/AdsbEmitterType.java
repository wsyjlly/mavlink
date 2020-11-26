package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "ADSB_EMITTER_TYPE")
public enum  AdsbEmitterType {
	
	/**
	 * ADSB_EMITTER_TYPE_NO_INFO
	 */
	@MavlinkEnumEntry(value = 0)
	ADSB_EMITTER_TYPE_NO_INFO(),
	
	/**
	 * ADSB_EMITTER_TYPE_LIGHT
	 */
	@MavlinkEnumEntry(value = 1)
	ADSB_EMITTER_TYPE_LIGHT(),
	
	/**
	 * ADSB_EMITTER_TYPE_SMALL
	 */
	@MavlinkEnumEntry(value = 2)
	ADSB_EMITTER_TYPE_SMALL(),
	
	/**
	 * ADSB_EMITTER_TYPE_LARGE
	 */
	@MavlinkEnumEntry(value = 3)
	ADSB_EMITTER_TYPE_LARGE(),
	
	/**
	 * ADSB_EMITTER_TYPE_HIGH_VORTEX_LARGE
	 */
	@MavlinkEnumEntry(value = 4)
	ADSB_EMITTER_TYPE_HIGH_VORTEX_LARGE(),
	
	/**
	 * ADSB_EMITTER_TYPE_HEAVY
	 */
	@MavlinkEnumEntry(value = 5)
	ADSB_EMITTER_TYPE_HEAVY(),
	
	/**
	 * ADSB_EMITTER_TYPE_HIGHLY_MANUV
	 */
	@MavlinkEnumEntry(value = 6)
	ADSB_EMITTER_TYPE_HIGHLY_MANUV(),
	
	/**
	 * ADSB_EMITTER_TYPE_ROTOCRAFT
	 */
	@MavlinkEnumEntry(value = 7)
	ADSB_EMITTER_TYPE_ROTOCRAFT(),
	
	/**
	 * ADSB_EMITTER_TYPE_UNASSIGNED
	 */
	@MavlinkEnumEntry(value = 8)
	ADSB_EMITTER_TYPE_UNASSIGNED(),
	
	/**
	 * ADSB_EMITTER_TYPE_GLIDER
	 */
	@MavlinkEnumEntry(value = 9)
	ADSB_EMITTER_TYPE_GLIDER(),
	
	/**
	 * ADSB_EMITTER_TYPE_LIGHTER_AIR
	 */
	@MavlinkEnumEntry(value = 10)
	ADSB_EMITTER_TYPE_LIGHTER_AIR(),
	
	/**
	 * ADSB_EMITTER_TYPE_PARACHUTE
	 */
	@MavlinkEnumEntry(value = 11)
	ADSB_EMITTER_TYPE_PARACHUTE(),
	
	/**
	 * ADSB_EMITTER_TYPE_ULTRA_LIGHT
	 */
	@MavlinkEnumEntry(value = 12)
	ADSB_EMITTER_TYPE_ULTRA_LIGHT(),
	
	/**
	 * ADSB_EMITTER_TYPE_UNASSIGNED2
	 */
	@MavlinkEnumEntry(value = 13)
	ADSB_EMITTER_TYPE_UNASSIGNED2(),
	
	/**
	 * ADSB_EMITTER_TYPE_UAV
	 */
	@MavlinkEnumEntry(value = 14)
	ADSB_EMITTER_TYPE_UAV(),
	
	/**
	 * ADSB_EMITTER_TYPE_SPACE
	 */
	@MavlinkEnumEntry(value = 15)
	ADSB_EMITTER_TYPE_SPACE(),
	
	/**
	 * ADSB_EMITTER_TYPE_UNASSGINED3
	 */
	@MavlinkEnumEntry(value = 16)
	ADSB_EMITTER_TYPE_UNASSGINED3(),
	
	/**
	 * ADSB_EMITTER_TYPE_EMERGENCY_SURFACE
	 */
	@MavlinkEnumEntry(value = 17)
	ADSB_EMITTER_TYPE_EMERGENCY_SURFACE(),
	
	/**
	 * ADSB_EMITTER_TYPE_SERVICE_SURFACE
	 */
	@MavlinkEnumEntry(value = 18)
	ADSB_EMITTER_TYPE_SERVICE_SURFACE(),
	
	/**
	 * ADSB_EMITTER_TYPE_POINT_OBSTACLE
	 */
	@MavlinkEnumEntry(value = 19)
	ADSB_EMITTER_TYPE_POINT_OBSTACLE(),
}
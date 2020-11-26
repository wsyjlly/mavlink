package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "AIS_NAV_STATUS")
public enum  AisNavStatus {
	
	/**
	 * Under way using engine.
	 */
	@MavlinkEnumEntry(value = 0,description = "Under way using engine.")
	UNDER_WAY(),
	
	/**
	 * AIS_NAV_ANCHORED
	 */
	@MavlinkEnumEntry(value = 1)
	AIS_NAV_ANCHORED(),
	
	/**
	 * AIS_NAV_UN_COMMANDED
	 */
	@MavlinkEnumEntry(value = 2)
	AIS_NAV_UN_COMMANDED(),
	
	/**
	 * AIS_NAV_RESTRICTED_MANOEUVERABILITY
	 */
	@MavlinkEnumEntry(value = 3)
	AIS_NAV_RESTRICTED_MANOEUVERABILITY(),
	
	/**
	 * AIS_NAV_DRAUGHT_CONSTRAINED
	 */
	@MavlinkEnumEntry(value = 4)
	AIS_NAV_DRAUGHT_CONSTRAINED(),
	
	/**
	 * AIS_NAV_MOORED
	 */
	@MavlinkEnumEntry(value = 5)
	AIS_NAV_MOORED(),
	
	/**
	 * AIS_NAV_AGROUND
	 */
	@MavlinkEnumEntry(value = 6)
	AIS_NAV_AGROUND(),
	
	/**
	 * AIS_NAV_FISHING
	 */
	@MavlinkEnumEntry(value = 7)
	AIS_NAV_FISHING(),
	
	/**
	 * AIS_NAV_SAILING
	 */
	@MavlinkEnumEntry(value = 8)
	AIS_NAV_SAILING(),
	
	/**
	 * AIS_NAV_RESERVED_HSC
	 */
	@MavlinkEnumEntry(value = 9)
	AIS_NAV_RESERVED_HSC(),
	
	/**
	 * AIS_NAV_RESERVED_WIG
	 */
	@MavlinkEnumEntry(value = 10)
	AIS_NAV_RESERVED_WIG(),
	
	/**
	 * AIS_NAV_RESERVED_1
	 */
	@MavlinkEnumEntry(value = 11)
	AIS_NAV_RESERVED_1(),
	
	/**
	 * AIS_NAV_RESERVED_2
	 */
	@MavlinkEnumEntry(value = 12)
	AIS_NAV_RESERVED_2(),
	
	/**
	 * AIS_NAV_RESERVED_3
	 */
	@MavlinkEnumEntry(value = 13)
	AIS_NAV_RESERVED_3(),
	
	/**
	 * Search And Rescue Transponder.
	 */
	@MavlinkEnumEntry(value = 14,description = "Search And Rescue Transponder.")
	AIS_NAV_AIS_SART(),
	
	/**
	 * Not available (default).
	 */
	@MavlinkEnumEntry(value = 15,description = "Not available (default).")
	AIS_NAV_UNKNOWN(),
}
package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "PRECISION_LAND_MODE")
public enum  PrecisionLandMode {
	
	/**
	 * Normal (non-precision) landing.
	 */
	@MavlinkEnumEntry(value = 0,description = "Normal (non-precision) landing.")
	PRECISION_LAND_MODE_DISABLED(),
	
	/**
	 * Use precision landing if beacon detected when land command accepted, otherwise land normally.
	 */
	@MavlinkEnumEntry(value = 1,description = "Use precision landing if beacon detected when land command accepted, otherwise land normally.")
	PRECISION_LAND_MODE_OPPORTUNISTIC(),
	
	/**
	 * Use precision landing, searching for beacon if not found when land command accepted (land normally if beacon cannot be found).
	 */
	@MavlinkEnumEntry(value = 2,description = "Use precision landing, searching for beacon if not found when land command accepted (land normally if beacon cannot be found).")
	PRECISION_LAND_MODE_REQUIRED(),
}
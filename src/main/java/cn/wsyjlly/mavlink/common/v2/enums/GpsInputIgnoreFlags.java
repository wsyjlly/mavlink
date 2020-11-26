package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "GPS_INPUT_IGNORE_FLAGS", bitmask = "true")
public enum  GpsInputIgnoreFlags {
	
	/**
	 * ignore altitude field
	 */
	@MavlinkEnumEntry(value = 1,description = "ignore altitude field")
	GPS_INPUT_IGNORE_FLAG_ALT(),
	
	/**
	 * ignore hdop field
	 */
	@MavlinkEnumEntry(value = 2,description = "ignore hdop field")
	GPS_INPUT_IGNORE_FLAG_HDOP(),
	
	/**
	 * ignore vdop field
	 */
	@MavlinkEnumEntry(value = 4,description = "ignore vdop field")
	GPS_INPUT_IGNORE_FLAG_VDOP(),
	
	/**
	 * ignore horizontal velocity field (vn and ve)
	 */
	@MavlinkEnumEntry(value = 8,description = "ignore horizontal velocity field (vn and ve)")
	GPS_INPUT_IGNORE_FLAG_VEL_HORIZ(),
	
	/**
	 * ignore vertical velocity field (vd)
	 */
	@MavlinkEnumEntry(value = 16,description = "ignore vertical velocity field (vd)")
	GPS_INPUT_IGNORE_FLAG_VEL_VERT(),
	
	/**
	 * ignore speed accuracy field
	 */
	@MavlinkEnumEntry(value = 32,description = "ignore speed accuracy field")
	GPS_INPUT_IGNORE_FLAG_SPEED_ACCURACY(),
	
	/**
	 * ignore horizontal accuracy field
	 */
	@MavlinkEnumEntry(value = 64,description = "ignore horizontal accuracy field")
	GPS_INPUT_IGNORE_FLAG_HORIZONTAL_ACCURACY(),
	
	/**
	 * ignore vertical accuracy field
	 */
	@MavlinkEnumEntry(value = 128,description = "ignore vertical accuracy field")
	GPS_INPUT_IGNORE_FLAG_VERTICAL_ACCURACY(),
}
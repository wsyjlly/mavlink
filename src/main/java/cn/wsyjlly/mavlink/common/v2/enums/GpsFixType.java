package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "GPS_FIX_TYPE")
public enum  GpsFixType {
	
	/**
	 * No GPS connected
	 */
	@MavlinkEnumEntry(value = 0,description = "No GPS connected")
	GPS_FIX_TYPE_NO_GPS(),
	
	/**
	 * No position information, GPS is connected
	 */
	@MavlinkEnumEntry(value = 1,description = "No position information, GPS is connected")
	GPS_FIX_TYPE_NO_FIX(),
	
	/**
	 * 2D position
	 */
	@MavlinkEnumEntry(value = 2,description = "2D position")
	GPS_FIX_TYPE_2D_FIX(),
	
	/**
	 * 3D position
	 */
	@MavlinkEnumEntry(value = 3,description = "3D position")
	GPS_FIX_TYPE_3D_FIX(),
	
	/**
	 * DGPS/SBAS aided 3D position
	 */
	@MavlinkEnumEntry(value = 4,description = "DGPS/SBAS aided 3D position")
	GPS_FIX_TYPE_DGPS(),
	
	/**
	 * RTK float, 3D position
	 */
	@MavlinkEnumEntry(value = 5,description = "RTK float, 3D position")
	GPS_FIX_TYPE_RTK_FLOAT(),
	
	/**
	 * RTK Fixed, 3D position
	 */
	@MavlinkEnumEntry(value = 6,description = "RTK Fixed, 3D position")
	GPS_FIX_TYPE_RTK_FIXED(),
	
	/**
	 * Static fixed, typically used for base stations
	 */
	@MavlinkEnumEntry(value = 7,description = "Static fixed, typically used for base stations")
	GPS_FIX_TYPE_STATIC(),
	
	/**
	 * PPP, 3D position.
	 */
	@MavlinkEnumEntry(value = 8,description = "PPP, 3D position.")
	GPS_FIX_TYPE_PPP(),
}
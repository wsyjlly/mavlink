package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "WIFI_CONFIG_AP_MODE")
public enum  WifiConfigApMode {
	
	/**
	 * WiFi mode is undefined.
	 */
	@MavlinkEnumEntry(value = 0,description = "WiFi mode is undefined.")
	WIFI_CONFIG_AP_MODE_UNDEFINED(),
	
	/**
	 * WiFi configured as an access point.
	 */
	@MavlinkEnumEntry(value = 1,description = "WiFi configured as an access point.")
	WIFI_CONFIG_AP_MODE_AP(),
	
	/**
	 * WiFi configured as a station connected to an existing local WiFi network.
	 */
	@MavlinkEnumEntry(value = 2,description = "WiFi configured as a station connected to an existing local WiFi network.")
	WIFI_CONFIG_AP_MODE_STATION(),
	
	/**
	 * WiFi disabled.
	 */
	@MavlinkEnumEntry(value = 3,description = "WiFi disabled.")
	WIFI_CONFIG_AP_MODE_DISABLED(),
}
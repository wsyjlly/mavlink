package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "WIFI_CONFIG_AP_RESPONSE")
public enum  WifiConfigApResponse {
	
	/**
	 * Undefined response. Likely an indicative of a system that doesn't support this request.
	 */
	@MavlinkEnumEntry(value = 0,description = "Undefined response. Likely an indicative of a system that doesn't support this request.")
	WIFI_CONFIG_AP_RESPONSE_UNDEFINED(),
	
	/**
	 * Changes accepted.
	 */
	@MavlinkEnumEntry(value = 1,description = "Changes accepted.")
	WIFI_CONFIG_AP_RESPONSE_ACCEPTED(),
	
	/**
	 * Changes rejected.
	 */
	@MavlinkEnumEntry(value = 2,description = "Changes rejected.")
	WIFI_CONFIG_AP_RESPONSE_REJECTED(),
	
	/**
	 * Invalid Mode.
	 */
	@MavlinkEnumEntry(value = 3,description = "Invalid Mode.")
	WIFI_CONFIG_AP_RESPONSE_MODE_ERROR(),
	
	/**
	 * Invalid SSID.
	 */
	@MavlinkEnumEntry(value = 4,description = "Invalid SSID.")
	WIFI_CONFIG_AP_RESPONSE_SSID_ERROR(),
	
	/**
	 * Invalid Password.
	 */
	@MavlinkEnumEntry(value = 5,description = "Invalid Password.")
	WIFI_CONFIG_AP_RESPONSE_PASSWORD_ERROR(),
}
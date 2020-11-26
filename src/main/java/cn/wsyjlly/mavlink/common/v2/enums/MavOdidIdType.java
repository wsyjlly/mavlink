package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "MAV_ODID_ID_TYPE")
public enum  MavOdidIdType {
	
	/**
	 * No type defined.
	 */
	@MavlinkEnumEntry(value = 0,description = "No type defined.")
	MAV_ODID_ID_TYPE_NONE(),
	
	/**
	 * Manufacturer Serial Number (ANSI/CTA-2063 format).
	 */
	@MavlinkEnumEntry(value = 1,description = "Manufacturer Serial Number (ANSI/CTA-2063 format).")
	MAV_ODID_ID_TYPE_SERIAL_NUMBER(),
	
	/**
	 * CAA (Civil Aviation Authority) registered ID. Format: [ICAO Country Code].[CAA Assigned ID].
	 */
	@MavlinkEnumEntry(value = 2,description = "CAA (Civil Aviation Authority) registered ID. Format: [ICAO Country Code].[CAA Assigned ID].")
	MAV_ODID_ID_TYPE_CAA_REGISTRATION_ID(),
	
	/**
	 * UTM (Unmanned Traffic Management) assigned UUID (RFC4122).
	 */
	@MavlinkEnumEntry(value = 3,description = "UTM (Unmanned Traffic Management) assigned UUID (RFC4122).")
	MAV_ODID_ID_TYPE_UTM_ASSIGNED_UUID(),
}
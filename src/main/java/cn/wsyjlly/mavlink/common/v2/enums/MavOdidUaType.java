package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "MAV_ODID_UA_TYPE")
public enum  MavOdidUaType {
	
	/**
	 * No UA (Unmanned Aircraft) type defined.
	 */
	@MavlinkEnumEntry(value = 0,description = "No UA (Unmanned Aircraft) type defined.")
	MAV_ODID_UA_TYPE_NONE(),
	
	/**
	 * Aeroplane/Airplane. Fixed wing.
	 */
	@MavlinkEnumEntry(value = 1,description = "Aeroplane/Airplane. Fixed wing.")
	MAV_ODID_UA_TYPE_AEROPLANE(),
	
	/**
	 * Helicopter or multirotor.
	 */
	@MavlinkEnumEntry(value = 2,description = "Helicopter or multirotor.")
	MAV_ODID_UA_TYPE_HELICOPTER_OR_MULTIROTOR(),
	
	/**
	 * Gyroplane.
	 */
	@MavlinkEnumEntry(value = 3,description = "Gyroplane.")
	MAV_ODID_UA_TYPE_GYROPLANE(),
	
	/**
	 * VTOL (Vertical Take-Off and Landing). Fixed wing aircraft that can take off vertically.
	 */
	@MavlinkEnumEntry(value = 4,description = "VTOL (Vertical Take-Off and Landing). Fixed wing aircraft that can take off vertically.")
	MAV_ODID_UA_TYPE_HYBRID_LIFT(),
	
	/**
	 * Ornithopter.
	 */
	@MavlinkEnumEntry(value = 5,description = "Ornithopter.")
	MAV_ODID_UA_TYPE_ORNITHOPTER(),
	
	/**
	 * Glider.
	 */
	@MavlinkEnumEntry(value = 6,description = "Glider.")
	MAV_ODID_UA_TYPE_GLIDER(),
	
	/**
	 * Kite.
	 */
	@MavlinkEnumEntry(value = 7,description = "Kite.")
	MAV_ODID_UA_TYPE_KITE(),
	
	/**
	 * Free Balloon.
	 */
	@MavlinkEnumEntry(value = 8,description = "Free Balloon.")
	MAV_ODID_UA_TYPE_FREE_BALLOON(),
	
	/**
	 * Captive Balloon.
	 */
	@MavlinkEnumEntry(value = 9,description = "Captive Balloon.")
	MAV_ODID_UA_TYPE_CAPTIVE_BALLOON(),
	
	/**
	 * Airship. E.g. a blimp.
	 */
	@MavlinkEnumEntry(value = 10,description = "Airship. E.g. a blimp.")
	MAV_ODID_UA_TYPE_AIRSHIP(),
	
	/**
	 * Free Fall/Parachute (unpowered).
	 */
	@MavlinkEnumEntry(value = 11,description = "Free Fall/Parachute (unpowered).")
	MAV_ODID_UA_TYPE_FREE_FALL_PARACHUTE(),
	
	/**
	 * Rocket.
	 */
	@MavlinkEnumEntry(value = 12,description = "Rocket.")
	MAV_ODID_UA_TYPE_ROCKET(),
	
	/**
	 * Tethered powered aircraft.
	 */
	@MavlinkEnumEntry(value = 13,description = "Tethered powered aircraft.")
	MAV_ODID_UA_TYPE_TETHERED_POWERED_AIRCRAFT(),
	
	/**
	 * Ground Obstacle.
	 */
	@MavlinkEnumEntry(value = 14,description = "Ground Obstacle.")
	MAV_ODID_UA_TYPE_GROUND_OBSTACLE(),
	
	/**
	 * Other type of aircraft not listed earlier.
	 */
	@MavlinkEnumEntry(value = 15,description = "Other type of aircraft not listed earlier.")
	MAV_ODID_UA_TYPE_OTHER(),
}
package cn.wsyjlly.mavlink.common.v1.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:45
 *
 **********************************/

@MavlinkEnum(name = "MAV_TYPE")
public enum  MavType {
	
	/**
	 * Generic micro air vehicle.
	 */
	@MavlinkEnumEntry(value = 0,description = "Generic micro air vehicle.")
	MAV_TYPE_GENERIC(),
	
	/**
	 * Fixed wing aircraft.
	 */
	@MavlinkEnumEntry(value = 1,description = "Fixed wing aircraft.")
	MAV_TYPE_FIXED_WING(),
	
	/**
	 * Quadrotor
	 */
	@MavlinkEnumEntry(value = 2,description = "Quadrotor")
	MAV_TYPE_QUADROTOR(),
	
	/**
	 * Coaxial helicopter
	 */
	@MavlinkEnumEntry(value = 3,description = "Coaxial helicopter")
	MAV_TYPE_COAXIAL(),
	
	/**
	 * Normal helicopter with tail rotor.
	 */
	@MavlinkEnumEntry(value = 4,description = "Normal helicopter with tail rotor.")
	MAV_TYPE_HELICOPTER(),
	
	/**
	 * Ground installation
	 */
	@MavlinkEnumEntry(value = 5,description = "Ground installation")
	MAV_TYPE_ANTENNA_TRACKER(),
	
	/**
	 * Operator control unit / ground control station
	 */
	@MavlinkEnumEntry(value = 6,description = "Operator control unit / ground control station")
	MAV_TYPE_GCS(),
	
	/**
	 * Airship, controlled
	 */
	@MavlinkEnumEntry(value = 7,description = "Airship, controlled")
	MAV_TYPE_AIRSHIP(),
	
	/**
	 * Free balloon, uncontrolled
	 */
	@MavlinkEnumEntry(value = 8,description = "Free balloon, uncontrolled")
	MAV_TYPE_FREE_BALLOON(),
	
	/**
	 * Rocket
	 */
	@MavlinkEnumEntry(value = 9,description = "Rocket")
	MAV_TYPE_ROCKET(),
	
	/**
	 * Ground rover
	 */
	@MavlinkEnumEntry(value = 10,description = "Ground rover")
	MAV_TYPE_GROUND_ROVER(),
	
	/**
	 * Surface vessel, boat, ship
	 */
	@MavlinkEnumEntry(value = 11,description = "Surface vessel, boat, ship")
	MAV_TYPE_SURFACE_BOAT(),
	
	/**
	 * Submarine
	 */
	@MavlinkEnumEntry(value = 12,description = "Submarine")
	MAV_TYPE_SUBMARINE(),
	
	/**
	 * Hexarotor
	 */
	@MavlinkEnumEntry(value = 13,description = "Hexarotor")
	MAV_TYPE_HEXAROTOR(),
	
	/**
	 * Octorotor
	 */
	@MavlinkEnumEntry(value = 14,description = "Octorotor")
	MAV_TYPE_OCTOROTOR(),
	
	/**
	 * Octorotor
	 */
	@MavlinkEnumEntry(value = 15,description = "Octorotor")
	MAV_TYPE_TRICOPTER(),
	
	/**
	 * Flapping wing
	 */
	@MavlinkEnumEntry(value = 16,description = "Flapping wing")
	MAV_TYPE_FLAPPING_WING(),
	
	/**
	 * Flapping wing
	 */
	@MavlinkEnumEntry(value = 17,description = "Flapping wing")
	MAV_TYPE_KITE(),
	
	/**
	 * Onboard companion controller
	 */
	@MavlinkEnumEntry(value = 18,description = "Onboard companion controller")
	MAV_TYPE_ONBOARD_CONTROLLER(),
	
	/**
	 * Two-rotor VTOL using control surfaces in vertical operation in addition. Tailsitter.
	 */
	@MavlinkEnumEntry(value = 19,description = "Two-rotor VTOL using control surfaces in vertical operation in addition. Tailsitter.")
	MAV_TYPE_VTOL_DUOROTOR(),
	
	/**
	 * Quad-rotor VTOL using a V-shaped quad config in vertical operation. Tailsitter.
	 */
	@MavlinkEnumEntry(value = 20,description = "Quad-rotor VTOL using a V-shaped quad config in vertical operation. Tailsitter.")
	MAV_TYPE_VTOL_QUADROTOR(),
}
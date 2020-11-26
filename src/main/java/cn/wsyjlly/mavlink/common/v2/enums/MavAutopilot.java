package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:45
 *
 **********************************/

@MavlinkEnum(name = "MAV_AUTOPILOT")
public enum  MavAutopilot {
	
	/**
	 * Generic autopilot, full support for everything
	 */
	@MavlinkEnumEntry(value = 0,description = "Generic autopilot, full support for everything")
	MAV_AUTOPILOT_GENERIC(),
	
	/**
	 * Reserved for future use.
	 */
	@MavlinkEnumEntry(value = 1,description = "Reserved for future use.")
	MAV_AUTOPILOT_RESERVED(),
	
	/**
	 * SLUGS autopilot, http://slugsuav.soe.ucsc.edu
	 */
	@MavlinkEnumEntry(value = 2,description = "SLUGS autopilot, http://slugsuav.soe.ucsc.edu")
	MAV_AUTOPILOT_SLUGS(),
	
	/**
	 * ArduPilot - Plane/Copter/Rover/Sub/Tracker, https://ardupilot.org
	 */
	@MavlinkEnumEntry(value = 3,description = "ArduPilot - Plane/Copter/Rover/Sub/Tracker, https://ardupilot.org")
	MAV_AUTOPILOT_ARDUPILOTMEGA(),
	
	/**
	 * OpenPilot, http://openpilot.org
	 */
	@MavlinkEnumEntry(value = 4,description = "OpenPilot, http://openpilot.org")
	MAV_AUTOPILOT_OPENPILOT(),
	
	/**
	 * Generic autopilot only supporting simple waypoints
	 */
	@MavlinkEnumEntry(value = 5,description = "Generic autopilot only supporting simple waypoints")
	MAV_AUTOPILOT_GENERIC_WAYPOINTS_ONLY(),
	
	/**
	 * Generic autopilot supporting waypoints and other simple navigation commands
	 */
	@MavlinkEnumEntry(value = 6,description = "Generic autopilot supporting waypoints and other simple navigation commands")
	MAV_AUTOPILOT_GENERIC_WAYPOINTS_AND_SIMPLE_NAVIGATION_ONLY(),
	
	/**
	 * Generic autopilot supporting the full mission command set
	 */
	@MavlinkEnumEntry(value = 7,description = "Generic autopilot supporting the full mission command set")
	MAV_AUTOPILOT_GENERIC_MISSION_FULL(),
	
	/**
	 * No valid autopilot, e.g. a GCS or other MAVLink component
	 */
	@MavlinkEnumEntry(value = 8,description = "No valid autopilot, e.g. a GCS or other MAVLink component")
	MAV_AUTOPILOT_INVALID(),
	
	/**
	 * PPZ UAV - http://nongnu.org/paparazzi
	 */
	@MavlinkEnumEntry(value = 9,description = "PPZ UAV - http://nongnu.org/paparazzi")
	MAV_AUTOPILOT_PPZ(),
	
	/**
	 * UAV Dev Board
	 */
	@MavlinkEnumEntry(value = 10,description = "UAV Dev Board")
	MAV_AUTOPILOT_UDB(),
	
	/**
	 * FlexiPilot
	 */
	@MavlinkEnumEntry(value = 11,description = "FlexiPilot")
	MAV_AUTOPILOT_FP(),
	
	/**
	 * PX4 Autopilot - http://px4.io/
	 */
	@MavlinkEnumEntry(value = 12,description = "PX4 Autopilot - http://px4.io/")
	MAV_AUTOPILOT_PX4(),
	
	/**
	 * SMACCMPilot - http://smaccmpilot.org
	 */
	@MavlinkEnumEntry(value = 13,description = "SMACCMPilot - http://smaccmpilot.org")
	MAV_AUTOPILOT_SMACCMPILOT(),
	
	/**
	 * AutoQuad -- http://autoquad.org
	 */
	@MavlinkEnumEntry(value = 14,description = "AutoQuad -- http://autoquad.org")
	MAV_AUTOPILOT_AUTOQUAD(),
	
	/**
	 * Armazila -- http://armazila.com
	 */
	@MavlinkEnumEntry(value = 15,description = "Armazila -- http://armazila.com")
	MAV_AUTOPILOT_ARMAZILA(),
	
	/**
	 * Aerob -- http://aerob.ru
	 */
	@MavlinkEnumEntry(value = 16,description = "Aerob -- http://aerob.ru")
	MAV_AUTOPILOT_AEROB(),
	
	/**
	 * ASLUAV autopilot -- http://www.asl.ethz.ch
	 */
	@MavlinkEnumEntry(value = 17,description = "ASLUAV autopilot -- http://www.asl.ethz.ch")
	MAV_AUTOPILOT_ASLUAV(),
	
	/**
	 * SmartAP Autopilot - http://sky-drones.com
	 */
	@MavlinkEnumEntry(value = 18,description = "SmartAP Autopilot - http://sky-drones.com")
	MAV_AUTOPILOT_SMARTAP(),
	
	/**
	 * AirRails - http://uaventure.com
	 */
	@MavlinkEnumEntry(value = 19,description = "AirRails - http://uaventure.com")
	MAV_AUTOPILOT_AIRRAILS(),
}
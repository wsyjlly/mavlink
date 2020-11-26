package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "MAV_DISTANCE_SENSOR")
public enum  MavDistanceSensor {
	
	/**
	 * Laser rangefinder, e.g. LightWare SF02/F or PulsedLight units
	 */
	@MavlinkEnumEntry(value = 0,description = "Laser rangefinder, e.g. LightWare SF02/F or PulsedLight units")
	MAV_DISTANCE_SENSOR_LASER(),
	
	/**
	 * Ultrasound rangefinder, e.g. MaxBotix units
	 */
	@MavlinkEnumEntry(value = 1,description = "Ultrasound rangefinder, e.g. MaxBotix units")
	MAV_DISTANCE_SENSOR_ULTRASOUND(),
	
	/**
	 * Infrared rangefinder, e.g. Sharp units
	 */
	@MavlinkEnumEntry(value = 2,description = "Infrared rangefinder, e.g. Sharp units")
	MAV_DISTANCE_SENSOR_INFRARED(),
	
	/**
	 * Radar type, e.g. uLanding units
	 */
	@MavlinkEnumEntry(value = 3,description = "Radar type, e.g. uLanding units")
	MAV_DISTANCE_SENSOR_RADAR(),
	
	/**
	 * Broken or unknown type, e.g. analog units
	 */
	@MavlinkEnumEntry(value = 4,description = "Broken or unknown type, e.g. analog units")
	MAV_DISTANCE_SENSOR_UNKNOWN(),
}
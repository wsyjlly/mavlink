package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "MAV_GENERATOR_STATUS_FLAG", bitmask = "true")
public enum  MavGeneratorStatusFlag {
	
	/**
	 * Generator is off.
	 */
	@MavlinkEnumEntry(value = 1,description = "Generator is off.")
	MAV_GENERATOR_STATUS_FLAG_OFF(),
	
	/**
	 * Generator is ready to start generating power.
	 */
	@MavlinkEnumEntry(value = 2,description = "Generator is ready to start generating power.")
	MAV_GENERATOR_STATUS_FLAG_READY(),
	
	/**
	 * Generator is generating power.
	 */
	@MavlinkEnumEntry(value = 4,description = "Generator is generating power.")
	MAV_GENERATOR_STATUS_FLAG_GENERATING(),
	
	/**
	 * Generator is charging the batteries (generating enough power to charge and provide the load).
	 */
	@MavlinkEnumEntry(value = 8,description = "Generator is charging the batteries (generating enough power to charge and provide the load).")
	MAV_GENERATOR_STATUS_FLAG_CHARGING(),
	
	/**
	 * Generator is operating at a reduced maximum power.
	 */
	@MavlinkEnumEntry(value = 16,description = "Generator is operating at a reduced maximum power.")
	MAV_GENERATOR_STATUS_FLAG_REDUCED_POWER(),
	
	/**
	 * Generator is providing the maximum output.
	 */
	@MavlinkEnumEntry(value = 32,description = "Generator is providing the maximum output.")
	MAV_GENERATOR_STATUS_FLAG_MAXPOWER(),
	
	/**
	 * Generator is near the maximum operating temperature, cooling is insufficient.
	 */
	@MavlinkEnumEntry(value = 64,description = "Generator is near the maximum operating temperature, cooling is insufficient.")
	MAV_GENERATOR_STATUS_FLAG_OVERTEMP_WARNING(),
	
	/**
	 * Generator hit the maximum operating temperature and shutdown.
	 */
	@MavlinkEnumEntry(value = 128,description = "Generator hit the maximum operating temperature and shutdown.")
	MAV_GENERATOR_STATUS_FLAG_OVERTEMP_FAULT(),
	
	/**
	 * Power electronics are near the maximum operating temperature, cooling is insufficient.
	 */
	@MavlinkEnumEntry(value = 256,description = "Power electronics are near the maximum operating temperature, cooling is insufficient.")
	MAV_GENERATOR_STATUS_FLAG_ELECTRONICS_OVERTEMP_WARNING(),
	
	/**
	 * Power electronics hit the maximum operating temperature and shutdown.
	 */
	@MavlinkEnumEntry(value = 512,description = "Power electronics hit the maximum operating temperature and shutdown.")
	MAV_GENERATOR_STATUS_FLAG_ELECTRONICS_OVERTEMP_FAULT(),
	
	/**
	 * Power electronics experienced a fault and shutdown.
	 */
	@MavlinkEnumEntry(value = 1024,description = "Power electronics experienced a fault and shutdown.")
	MAV_GENERATOR_STATUS_FLAG_ELECTRONICS_FAULT(),
	
	/**
	 * The power source supplying the generator failed e.g. mechanical generator stopped, tether is no longer providing power, solar cell is in shade, hydrogen reaction no longer happening.
	 */
	@MavlinkEnumEntry(value = 2048,description = "The power source supplying the generator failed e.g. mechanical generator stopped, tether is no longer providing power, solar cell is in shade, hydrogen reaction no longer happening.")
	MAV_GENERATOR_STATUS_FLAG_POWERSOURCE_FAULT(),
	
	/**
	 * Generator controller having communication problems.
	 */
	@MavlinkEnumEntry(value = 4096,description = "Generator controller having communication problems.")
	MAV_GENERATOR_STATUS_FLAG_COMMUNICATION_WARNING(),
	
	/**
	 * Power electronic or generator cooling system error.
	 */
	@MavlinkEnumEntry(value = 8192,description = "Power electronic or generator cooling system error.")
	MAV_GENERATOR_STATUS_FLAG_COOLING_WARNING(),
	
	/**
	 * Generator controller power rail experienced a fault.
	 */
	@MavlinkEnumEntry(value = 16384,description = "Generator controller power rail experienced a fault.")
	MAV_GENERATOR_STATUS_FLAG_POWER_RAIL_FAULT(),
	
	/**
	 * Generator controller exceeded the overcurrent threshold and shutdown to prevent damage.
	 */
	@MavlinkEnumEntry(value = 32768,description = "Generator controller exceeded the overcurrent threshold and shutdown to prevent damage.")
	MAV_GENERATOR_STATUS_FLAG_OVERCURRENT_FAULT(),
	
	/**
	 * Generator controller detected a high current going into the batteries and shutdown to prevent battery damage.
	 */
	@MavlinkEnumEntry(value = 65536,description = "Generator controller detected a high current going into the batteries and shutdown to prevent battery damage.")
	MAV_GENERATOR_STATUS_FLAG_BATTERY_OVERCHARGE_CURRENT_FAULT(),
	
	/**
	 * Generator controller exceeded it's overvoltage threshold and shutdown to prevent it exceeding the voltage rating.
	 */
	@MavlinkEnumEntry(value = 131072,description = "Generator controller exceeded it's overvoltage threshold and shutdown to prevent it exceeding the voltage rating.")
	MAV_GENERATOR_STATUS_FLAG_OVERVOLTAGE_FAULT(),
	
	/**
	 * Batteries are under voltage (generator will not start).
	 */
	@MavlinkEnumEntry(value = 262144,description = "Batteries are under voltage (generator will not start).")
	MAV_GENERATOR_STATUS_FLAG_BATTERY_UNDERVOLT_FAULT(),
	
	/**
	 * Generator start is inhibited by e.g. a safety switch.
	 */
	@MavlinkEnumEntry(value = 524288,description = "Generator start is inhibited by e.g. a safety switch.")
	MAV_GENERATOR_STATUS_FLAG_START_INHIBITED(),
	
	/**
	 * Generator requires maintenance.
	 */
	@MavlinkEnumEntry(value = 1048576,description = "Generator requires maintenance.")
	MAV_GENERATOR_STATUS_FLAG_MAINTENANCE_REQUIRED(),
	
	/**
	 * Generator is not ready to generate yet.
	 */
	@MavlinkEnumEntry(value = 2097152,description = "Generator is not ready to generate yet.")
	MAV_GENERATOR_STATUS_FLAG_WARMING_UP(),
	
	/**
	 * Generator is idle.
	 */
	@MavlinkEnumEntry(value = 4194304,description = "Generator is idle.")
	MAV_GENERATOR_STATUS_FLAG_IDLE(),
}
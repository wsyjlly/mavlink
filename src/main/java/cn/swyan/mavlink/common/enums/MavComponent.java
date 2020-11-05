package cn.swyan.mavlink.common.enums;

import cn.swyan.mavlink.annotation.MavlinkEnum;
import cn.swyan.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * @Author YSW
 * @Description
 * @Date 2020.11.04 - 03:56
 *
 **********************************/

@MavlinkEnum(name = "MAV_COMPONENT")
public enum  MavComponent {
	
	/**
	 * 
	 */
	@MavlinkEnumEntry(value = 0,description = "")
	MAV_COMP_ID_ALL(),
	
	/**
	 * 
	 */
	@MavlinkEnumEntry(value = 220,description = "")
	MAV_COMP_ID_GPS(),
	
	/**
	 * 
	 */
	@MavlinkEnumEntry(value = 190,description = "")
	MAV_COMP_ID_MISSIONPLANNER(),
	
	/**
	 * 
	 */
	@MavlinkEnumEntry(value = 195,description = "")
	MAV_COMP_ID_PATHPLANNER(),
	
	/**
	 * 
	 */
	@MavlinkEnumEntry(value = 180,description = "")
	MAV_COMP_ID_MAPPER(),
	
	/**
	 * 
	 */
	@MavlinkEnumEntry(value = 100,description = "")
	MAV_COMP_ID_CAMERA(),
	
	/**
	 * 
	 */
	@MavlinkEnumEntry(value = 200,description = "")
	MAV_COMP_ID_IMU(),
	
	/**
	 * 
	 */
	@MavlinkEnumEntry(value = 201,description = "")
	MAV_COMP_ID_IMU_2(),
	
	/**
	 * 
	 */
	@MavlinkEnumEntry(value = 202,description = "")
	MAV_COMP_ID_IMU_3(),
	
	/**
	 * 
	 */
	@MavlinkEnumEntry(value = 240,description = "")
	MAV_COMP_ID_UDP_BRIDGE(),
	
	/**
	 * 
	 */
	@MavlinkEnumEntry(value = 241,description = "")
	MAV_COMP_ID_UART_BRIDGE(),
	
	/**
	 * 
	 */
	@MavlinkEnumEntry(value = 250,description = "")
	MAV_COMP_ID_SYSTEM_CONTROL(),
	
	/**
	 * 
	 */
	@MavlinkEnumEntry(value = 140,description = "")
	MAV_COMP_ID_SERVO1(),
	
	/**
	 * 
	 */
	@MavlinkEnumEntry(value = 141,description = "")
	MAV_COMP_ID_SERVO2(),
	
	/**
	 * 
	 */
	@MavlinkEnumEntry(value = 142,description = "")
	MAV_COMP_ID_SERVO3(),
	
	/**
	 * 
	 */
	@MavlinkEnumEntry(value = 143,description = "")
	MAV_COMP_ID_SERVO4(),
	
	/**
	 * 
	 */
	@MavlinkEnumEntry(value = 144,description = "")
	MAV_COMP_ID_SERVO5(),
	
	/**
	 * 
	 */
	@MavlinkEnumEntry(value = 145,description = "")
	MAV_COMP_ID_SERVO6(),
	
	/**
	 * 
	 */
	@MavlinkEnumEntry(value = 146,description = "")
	MAV_COMP_ID_SERVO7(),
	
	/**
	 * 
	 */
	@MavlinkEnumEntry(value = 147,description = "")
	MAV_COMP_ID_SERVO8(),
	
	/**
	 * 
	 */
	@MavlinkEnumEntry(value = 148,description = "")
	MAV_COMP_ID_SERVO9(),
	
	/**
	 * 
	 */
	@MavlinkEnumEntry(value = 149,description = "")
	MAV_COMP_ID_SERVO10(),
	
	/**
	 * 
	 */
	@MavlinkEnumEntry(value = 150,description = "")
	MAV_COMP_ID_SERVO11(),
	
	/**
	 * 
	 */
	@MavlinkEnumEntry(value = 151,description = "")
	MAV_COMP_ID_SERVO12(),
	
	/**
	 * 
	 */
	@MavlinkEnumEntry(value = 152,description = "")
	MAV_COMP_ID_SERVO13(),
	
	/**
	 * 
	 */
	@MavlinkEnumEntry(value = 153,description = "")
	MAV_COMP_ID_SERVO14(),
}
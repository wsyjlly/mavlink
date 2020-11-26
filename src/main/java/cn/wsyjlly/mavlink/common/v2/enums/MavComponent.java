package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:45
 *
 **********************************/

@MavlinkEnum(name = "MAV_COMPONENT")
public enum  MavComponent {
	
	/**
	 * Target id (target_component) used to broadcast messages to all components of the receiving system. Components should attempt to process messages with this component ID and forward to components on any other interfaces. Note: This is not a valid *source* component id for a message.
	 */
	@MavlinkEnumEntry(value = 0,description = "Target id (target_component) used to broadcast messages to all components of the receiving system. Components should attempt to process messages with this component ID and forward to components on any other interfaces. Note: This is not a valid *source* component id for a message.")
	MAV_COMP_ID_ALL(),
	
	/**
	 * System flight controller component ('autopilot'). Only one autopilot is expected in a particular system.
	 */
	@MavlinkEnumEntry(value = 1,description = "System flight controller component ('autopilot'). Only one autopilot is expected in a particular system.")
	MAV_COMP_ID_AUTOPILOT1(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 25,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER1(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 26,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER2(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 27,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER3(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 28,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER4(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 29,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER5(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 30,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER6(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 31,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER7(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 32,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER8(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 33,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER9(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 34,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER10(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 35,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER11(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 36,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER12(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 37,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER13(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 38,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER14(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 39,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER15(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 40,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER16(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 41,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER17(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 42,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER18(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 43,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER19(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 44,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER20(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 45,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER21(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 46,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER22(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 47,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER23(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 48,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER24(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 49,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER25(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 50,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER26(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 51,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER27(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 52,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER28(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 53,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER29(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 54,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER30(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 55,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER31(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 56,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER32(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 57,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER33(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 58,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER34(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 59,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER35(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 60,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER36(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 61,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER37(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 62,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER38(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 63,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER39(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 64,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER40(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 65,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER41(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 66,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER42(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 67,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER43(),
	
	/**
	 * Telemetry radio (e.g. SiK radio, or other component that emits RADIO_STATUS messages).
	 */
	@MavlinkEnumEntry(value = 68,description = "Telemetry radio (e.g. SiK radio, or other component that emits RADIO_STATUS messages).")
	MAV_COMP_ID_TELEMETRY_RADIO(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 69,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER45(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 70,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER46(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 71,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER47(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 72,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER48(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 73,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER49(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 74,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER50(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 75,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER51(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 76,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER52(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 77,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER53(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 78,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER54(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 79,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER55(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 80,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER56(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 81,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER57(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 82,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER58(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 83,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER59(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 84,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER60(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 85,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER61(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 86,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER62(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 87,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER63(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 88,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER64(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 89,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER65(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 90,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER66(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 91,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER67(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 92,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER68(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 93,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER69(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 94,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER70(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 95,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER71(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 96,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER72(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 97,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER73(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 98,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER74(),
	
	/**
	 * Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.
	 */
	@MavlinkEnumEntry(value = 99,description = "Id for a component on privately managed MAVLink network. Can be used for any purpose but may not be published by components outside of the private network.")
	MAV_COMP_ID_USER75(),
	
	/**
	 * Camera #1.
	 */
	@MavlinkEnumEntry(value = 100,description = "Camera #1.")
	MAV_COMP_ID_CAMERA(),
	
	/**
	 * Camera #2.
	 */
	@MavlinkEnumEntry(value = 101,description = "Camera #2.")
	MAV_COMP_ID_CAMERA2(),
	
	/**
	 * Camera #3.
	 */
	@MavlinkEnumEntry(value = 102,description = "Camera #3.")
	MAV_COMP_ID_CAMERA3(),
	
	/**
	 * Camera #4.
	 */
	@MavlinkEnumEntry(value = 103,description = "Camera #4.")
	MAV_COMP_ID_CAMERA4(),
	
	/**
	 * Camera #5.
	 */
	@MavlinkEnumEntry(value = 104,description = "Camera #5.")
	MAV_COMP_ID_CAMERA5(),
	
	/**
	 * Camera #6.
	 */
	@MavlinkEnumEntry(value = 105,description = "Camera #6.")
	MAV_COMP_ID_CAMERA6(),
	
	/**
	 * Servo #1.
	 */
	@MavlinkEnumEntry(value = 140,description = "Servo #1.")
	MAV_COMP_ID_SERVO1(),
	
	/**
	 * Servo #2.
	 */
	@MavlinkEnumEntry(value = 141,description = "Servo #2.")
	MAV_COMP_ID_SERVO2(),
	
	/**
	 * Servo #3.
	 */
	@MavlinkEnumEntry(value = 142,description = "Servo #3.")
	MAV_COMP_ID_SERVO3(),
	
	/**
	 * Servo #4.
	 */
	@MavlinkEnumEntry(value = 143,description = "Servo #4.")
	MAV_COMP_ID_SERVO4(),
	
	/**
	 * Servo #5.
	 */
	@MavlinkEnumEntry(value = 144,description = "Servo #5.")
	MAV_COMP_ID_SERVO5(),
	
	/**
	 * Servo #6.
	 */
	@MavlinkEnumEntry(value = 145,description = "Servo #6.")
	MAV_COMP_ID_SERVO6(),
	
	/**
	 * Servo #7.
	 */
	@MavlinkEnumEntry(value = 146,description = "Servo #7.")
	MAV_COMP_ID_SERVO7(),
	
	/**
	 * Servo #8.
	 */
	@MavlinkEnumEntry(value = 147,description = "Servo #8.")
	MAV_COMP_ID_SERVO8(),
	
	/**
	 * Servo #9.
	 */
	@MavlinkEnumEntry(value = 148,description = "Servo #9.")
	MAV_COMP_ID_SERVO9(),
	
	/**
	 * Servo #10.
	 */
	@MavlinkEnumEntry(value = 149,description = "Servo #10.")
	MAV_COMP_ID_SERVO10(),
	
	/**
	 * Servo #11.
	 */
	@MavlinkEnumEntry(value = 150,description = "Servo #11.")
	MAV_COMP_ID_SERVO11(),
	
	/**
	 * Servo #12.
	 */
	@MavlinkEnumEntry(value = 151,description = "Servo #12.")
	MAV_COMP_ID_SERVO12(),
	
	/**
	 * Servo #13.
	 */
	@MavlinkEnumEntry(value = 152,description = "Servo #13.")
	MAV_COMP_ID_SERVO13(),
	
	/**
	 * Servo #14.
	 */
	@MavlinkEnumEntry(value = 153,description = "Servo #14.")
	MAV_COMP_ID_SERVO14(),
	
	/**
	 * Gimbal #1.
	 */
	@MavlinkEnumEntry(value = 154,description = "Gimbal #1.")
	MAV_COMP_ID_GIMBAL(),
	
	/**
	 * Logging component.
	 */
	@MavlinkEnumEntry(value = 155,description = "Logging component.")
	MAV_COMP_ID_LOG(),
	
	/**
	 * Automatic Dependent Surveillance-Broadcast (ADS-B) component.
	 */
	@MavlinkEnumEntry(value = 156,description = "Automatic Dependent Surveillance-Broadcast (ADS-B) component.")
	MAV_COMP_ID_ADSB(),
	
	/**
	 * On Screen Display (OSD) devices for video links.
	 */
	@MavlinkEnumEntry(value = 157,description = "On Screen Display (OSD) devices for video links.")
	MAV_COMP_ID_OSD(),
	
	/**
	 * Generic autopilot peripheral component ID. Meant for devices that do not implement the parameter microservice.
	 */
	@MavlinkEnumEntry(value = 158,description = "Generic autopilot peripheral component ID. Meant for devices that do not implement the parameter microservice.")
	MAV_COMP_ID_PERIPHERAL(),
	
	/**
	 * Gimbal ID for QX1.
	 */
	@MavlinkEnumEntry(value = 159,description = "Gimbal ID for QX1.")
	MAV_COMP_ID_QX1_GIMBAL(),
	
	/**
	 * FLARM collision alert component.
	 */
	@MavlinkEnumEntry(value = 160,description = "FLARM collision alert component.")
	MAV_COMP_ID_FLARM(),
	
	/**
	 * Gimbal #2.
	 */
	@MavlinkEnumEntry(value = 171,description = "Gimbal #2.")
	MAV_COMP_ID_GIMBAL2(),
	
	/**
	 * Gimbal #3.
	 */
	@MavlinkEnumEntry(value = 172,description = "Gimbal #3.")
	MAV_COMP_ID_GIMBAL3(),
	
	/**
	 * Gimbal #4
	 */
	@MavlinkEnumEntry(value = 173,description = "Gimbal #4")
	MAV_COMP_ID_GIMBAL4(),
	
	/**
	 * Gimbal #5.
	 */
	@MavlinkEnumEntry(value = 174,description = "Gimbal #5.")
	MAV_COMP_ID_GIMBAL5(),
	
	/**
	 * Gimbal #6.
	 */
	@MavlinkEnumEntry(value = 175,description = "Gimbal #6.")
	MAV_COMP_ID_GIMBAL6(),
	
	/**
	 * Component that can generate/supply a mission flight plan (e.g. GCS or developer API).
	 */
	@MavlinkEnumEntry(value = 190,description = "Component that can generate/supply a mission flight plan (e.g. GCS or developer API).")
	MAV_COMP_ID_MISSIONPLANNER(),
	
	/**
	 * Component that lives on the onboard computer (companion computer) and has some generic functionalities, such as settings system parameters and monitoring the status of some processes that don't directly speak mavlink and so on.
	 */
	@MavlinkEnumEntry(value = 191,description = "Component that lives on the onboard computer (companion computer) and has some generic functionalities, such as settings system parameters and monitoring the status of some processes that don't directly speak mavlink and so on.")
	MAV_COMP_ID_ONBOARD_COMPUTER(),
	
	/**
	 * Component that finds an optimal path between points based on a certain constraint (e.g. minimum snap, shortest path, cost, etc.).
	 */
	@MavlinkEnumEntry(value = 195,description = "Component that finds an optimal path between points based on a certain constraint (e.g. minimum snap, shortest path, cost, etc.).")
	MAV_COMP_ID_PATHPLANNER(),
	
	/**
	 * Component that plans a collision free path between two points.
	 */
	@MavlinkEnumEntry(value = 196,description = "Component that plans a collision free path between two points.")
	MAV_COMP_ID_OBSTACLE_AVOIDANCE(),
	
	/**
	 * Component that provides position estimates using VIO techniques.
	 */
	@MavlinkEnumEntry(value = 197,description = "Component that provides position estimates using VIO techniques.")
	MAV_COMP_ID_VISUAL_INERTIAL_ODOMETRY(),
	
	/**
	 * Component that manages pairing of vehicle and GCS.
	 */
	@MavlinkEnumEntry(value = 198,description = "Component that manages pairing of vehicle and GCS.")
	MAV_COMP_ID_PAIRING_MANAGER(),
	
	/**
	 * Inertial Measurement Unit (IMU) #1.
	 */
	@MavlinkEnumEntry(value = 200,description = "Inertial Measurement Unit (IMU) #1.")
	MAV_COMP_ID_IMU(),
	
	/**
	 * Inertial Measurement Unit (IMU) #2.
	 */
	@MavlinkEnumEntry(value = 201,description = "Inertial Measurement Unit (IMU) #2.")
	MAV_COMP_ID_IMU_2(),
	
	/**
	 * Inertial Measurement Unit (IMU) #3.
	 */
	@MavlinkEnumEntry(value = 202,description = "Inertial Measurement Unit (IMU) #3.")
	MAV_COMP_ID_IMU_3(),
	
	/**
	 * GPS #1.
	 */
	@MavlinkEnumEntry(value = 220,description = "GPS #1.")
	MAV_COMP_ID_GPS(),
	
	/**
	 * GPS #2.
	 */
	@MavlinkEnumEntry(value = 221,description = "GPS #2.")
	MAV_COMP_ID_GPS2(),
	
	/**
	 * Open Drone ID transmitter/receiver (Bluetooth/WiFi/Internet).
	 */
	@MavlinkEnumEntry(value = 236,description = "Open Drone ID transmitter/receiver (Bluetooth/WiFi/Internet).")
	MAV_COMP_ID_ODID_TXRX_1(),
	
	/**
	 * Open Drone ID transmitter/receiver (Bluetooth/WiFi/Internet).
	 */
	@MavlinkEnumEntry(value = 237,description = "Open Drone ID transmitter/receiver (Bluetooth/WiFi/Internet).")
	MAV_COMP_ID_ODID_TXRX_2(),
	
	/**
	 * Open Drone ID transmitter/receiver (Bluetooth/WiFi/Internet).
	 */
	@MavlinkEnumEntry(value = 238,description = "Open Drone ID transmitter/receiver (Bluetooth/WiFi/Internet).")
	MAV_COMP_ID_ODID_TXRX_3(),
	
	/**
	 * Component to bridge MAVLink to UDP (i.e. from a UART).
	 */
	@MavlinkEnumEntry(value = 240,description = "Component to bridge MAVLink to UDP (i.e. from a UART).")
	MAV_COMP_ID_UDP_BRIDGE(),
	
	/**
	 * Component to bridge to UART (i.e. from UDP).
	 */
	@MavlinkEnumEntry(value = 241,description = "Component to bridge to UART (i.e. from UDP).")
	MAV_COMP_ID_UART_BRIDGE(),
	
	/**
	 * Component handling TUNNEL messages (e.g. vendor specific GUI of a component).
	 */
	@MavlinkEnumEntry(value = 242,description = "Component handling TUNNEL messages (e.g. vendor specific GUI of a component).")
	MAV_COMP_ID_TUNNEL_NODE(),
	
	/**
	 * Component for handling system messages (e.g. to ARM, takeoff, etc.).
	 */
	@MavlinkEnumEntry(value = 250,description = "Component for handling system messages (e.g. to ARM, takeoff, etc.).")
	MAV_COMP_ID_SYSTEM_CONTROL(),
}
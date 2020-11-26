package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "AIS_TYPE")
public enum  AisType {
	
	/**
	 * Not available (default).
	 */
	@MavlinkEnumEntry(value = 0,description = "Not available (default).")
	AIS_TYPE_UNKNOWN(),
	
	/**
	 * AIS_TYPE_RESERVED_1
	 */
	@MavlinkEnumEntry(value = 1)
	AIS_TYPE_RESERVED_1(),
	
	/**
	 * AIS_TYPE_RESERVED_2
	 */
	@MavlinkEnumEntry(value = 2)
	AIS_TYPE_RESERVED_2(),
	
	/**
	 * AIS_TYPE_RESERVED_3
	 */
	@MavlinkEnumEntry(value = 3)
	AIS_TYPE_RESERVED_3(),
	
	/**
	 * AIS_TYPE_RESERVED_4
	 */
	@MavlinkEnumEntry(value = 4)
	AIS_TYPE_RESERVED_4(),
	
	/**
	 * AIS_TYPE_RESERVED_5
	 */
	@MavlinkEnumEntry(value = 5)
	AIS_TYPE_RESERVED_5(),
	
	/**
	 * AIS_TYPE_RESERVED_6
	 */
	@MavlinkEnumEntry(value = 6)
	AIS_TYPE_RESERVED_6(),
	
	/**
	 * AIS_TYPE_RESERVED_7
	 */
	@MavlinkEnumEntry(value = 7)
	AIS_TYPE_RESERVED_7(),
	
	/**
	 * AIS_TYPE_RESERVED_8
	 */
	@MavlinkEnumEntry(value = 8)
	AIS_TYPE_RESERVED_8(),
	
	/**
	 * AIS_TYPE_RESERVED_9
	 */
	@MavlinkEnumEntry(value = 9)
	AIS_TYPE_RESERVED_9(),
	
	/**
	 * AIS_TYPE_RESERVED_10
	 */
	@MavlinkEnumEntry(value = 10)
	AIS_TYPE_RESERVED_10(),
	
	/**
	 * AIS_TYPE_RESERVED_11
	 */
	@MavlinkEnumEntry(value = 11)
	AIS_TYPE_RESERVED_11(),
	
	/**
	 * AIS_TYPE_RESERVED_12
	 */
	@MavlinkEnumEntry(value = 12)
	AIS_TYPE_RESERVED_12(),
	
	/**
	 * AIS_TYPE_RESERVED_13
	 */
	@MavlinkEnumEntry(value = 13)
	AIS_TYPE_RESERVED_13(),
	
	/**
	 * AIS_TYPE_RESERVED_14
	 */
	@MavlinkEnumEntry(value = 14)
	AIS_TYPE_RESERVED_14(),
	
	/**
	 * AIS_TYPE_RESERVED_15
	 */
	@MavlinkEnumEntry(value = 15)
	AIS_TYPE_RESERVED_15(),
	
	/**
	 * AIS_TYPE_RESERVED_16
	 */
	@MavlinkEnumEntry(value = 16)
	AIS_TYPE_RESERVED_16(),
	
	/**
	 * AIS_TYPE_RESERVED_17
	 */
	@MavlinkEnumEntry(value = 17)
	AIS_TYPE_RESERVED_17(),
	
	/**
	 * AIS_TYPE_RESERVED_18
	 */
	@MavlinkEnumEntry(value = 18)
	AIS_TYPE_RESERVED_18(),
	
	/**
	 * AIS_TYPE_RESERVED_19
	 */
	@MavlinkEnumEntry(value = 19)
	AIS_TYPE_RESERVED_19(),
	
	/**
	 * Wing In Ground effect.
	 */
	@MavlinkEnumEntry(value = 20,description = "Wing In Ground effect.")
	AIS_TYPE_WIG(),
	
	/**
	 * AIS_TYPE_WIG_HAZARDOUS_A
	 */
	@MavlinkEnumEntry(value = 21)
	AIS_TYPE_WIG_HAZARDOUS_A(),
	
	/**
	 * AIS_TYPE_WIG_HAZARDOUS_B
	 */
	@MavlinkEnumEntry(value = 22)
	AIS_TYPE_WIG_HAZARDOUS_B(),
	
	/**
	 * AIS_TYPE_WIG_HAZARDOUS_C
	 */
	@MavlinkEnumEntry(value = 23)
	AIS_TYPE_WIG_HAZARDOUS_C(),
	
	/**
	 * AIS_TYPE_WIG_HAZARDOUS_D
	 */
	@MavlinkEnumEntry(value = 24)
	AIS_TYPE_WIG_HAZARDOUS_D(),
	
	/**
	 * AIS_TYPE_WIG_RESERVED_1
	 */
	@MavlinkEnumEntry(value = 25)
	AIS_TYPE_WIG_RESERVED_1(),
	
	/**
	 * AIS_TYPE_WIG_RESERVED_2
	 */
	@MavlinkEnumEntry(value = 26)
	AIS_TYPE_WIG_RESERVED_2(),
	
	/**
	 * AIS_TYPE_WIG_RESERVED_3
	 */
	@MavlinkEnumEntry(value = 27)
	AIS_TYPE_WIG_RESERVED_3(),
	
	/**
	 * AIS_TYPE_WIG_RESERVED_4
	 */
	@MavlinkEnumEntry(value = 28)
	AIS_TYPE_WIG_RESERVED_4(),
	
	/**
	 * AIS_TYPE_WIG_RESERVED_5
	 */
	@MavlinkEnumEntry(value = 29)
	AIS_TYPE_WIG_RESERVED_5(),
	
	/**
	 * AIS_TYPE_FISHING
	 */
	@MavlinkEnumEntry(value = 30)
	AIS_TYPE_FISHING(),
	
	/**
	 * AIS_TYPE_TOWING
	 */
	@MavlinkEnumEntry(value = 31)
	AIS_TYPE_TOWING(),
	
	/**
	 * Towing: length exceeds 200m or breadth exceeds 25m.
	 */
	@MavlinkEnumEntry(value = 32,description = "Towing: length exceeds 200m or breadth exceeds 25m.")
	AIS_TYPE_TOWING_LARGE(),
	
	/**
	 * Dredging or other underwater ops.
	 */
	@MavlinkEnumEntry(value = 33,description = "Dredging or other underwater ops.")
	AIS_TYPE_DREDGING(),
	
	/**
	 * AIS_TYPE_DIVING
	 */
	@MavlinkEnumEntry(value = 34)
	AIS_TYPE_DIVING(),
	
	/**
	 * AIS_TYPE_MILITARY
	 */
	@MavlinkEnumEntry(value = 35)
	AIS_TYPE_MILITARY(),
	
	/**
	 * AIS_TYPE_SAILING
	 */
	@MavlinkEnumEntry(value = 36)
	AIS_TYPE_SAILING(),
	
	/**
	 * AIS_TYPE_PLEASURE
	 */
	@MavlinkEnumEntry(value = 37)
	AIS_TYPE_PLEASURE(),
	
	/**
	 * AIS_TYPE_RESERVED_20
	 */
	@MavlinkEnumEntry(value = 38)
	AIS_TYPE_RESERVED_20(),
	
	/**
	 * AIS_TYPE_RESERVED_21
	 */
	@MavlinkEnumEntry(value = 39)
	AIS_TYPE_RESERVED_21(),
	
	/**
	 * High Speed Craft.
	 */
	@MavlinkEnumEntry(value = 40,description = "High Speed Craft.")
	AIS_TYPE_HSC(),
	
	/**
	 * AIS_TYPE_HSC_HAZARDOUS_A
	 */
	@MavlinkEnumEntry(value = 41)
	AIS_TYPE_HSC_HAZARDOUS_A(),
	
	/**
	 * AIS_TYPE_HSC_HAZARDOUS_B
	 */
	@MavlinkEnumEntry(value = 42)
	AIS_TYPE_HSC_HAZARDOUS_B(),
	
	/**
	 * AIS_TYPE_HSC_HAZARDOUS_C
	 */
	@MavlinkEnumEntry(value = 43)
	AIS_TYPE_HSC_HAZARDOUS_C(),
	
	/**
	 * AIS_TYPE_HSC_HAZARDOUS_D
	 */
	@MavlinkEnumEntry(value = 44)
	AIS_TYPE_HSC_HAZARDOUS_D(),
	
	/**
	 * AIS_TYPE_HSC_RESERVED_1
	 */
	@MavlinkEnumEntry(value = 45)
	AIS_TYPE_HSC_RESERVED_1(),
	
	/**
	 * AIS_TYPE_HSC_RESERVED_2
	 */
	@MavlinkEnumEntry(value = 46)
	AIS_TYPE_HSC_RESERVED_2(),
	
	/**
	 * AIS_TYPE_HSC_RESERVED_3
	 */
	@MavlinkEnumEntry(value = 47)
	AIS_TYPE_HSC_RESERVED_3(),
	
	/**
	 * AIS_TYPE_HSC_RESERVED_4
	 */
	@MavlinkEnumEntry(value = 48)
	AIS_TYPE_HSC_RESERVED_4(),
	
	/**
	 * AIS_TYPE_HSC_UNKNOWN
	 */
	@MavlinkEnumEntry(value = 49)
	AIS_TYPE_HSC_UNKNOWN(),
	
	/**
	 * AIS_TYPE_PILOT
	 */
	@MavlinkEnumEntry(value = 50)
	AIS_TYPE_PILOT(),
	
	/**
	 * Search And Rescue vessel.
	 */
	@MavlinkEnumEntry(value = 51,description = "Search And Rescue vessel.")
	AIS_TYPE_SAR(),
	
	/**
	 * AIS_TYPE_TUG
	 */
	@MavlinkEnumEntry(value = 52)
	AIS_TYPE_TUG(),
	
	/**
	 * AIS_TYPE_PORT_TENDER
	 */
	@MavlinkEnumEntry(value = 53)
	AIS_TYPE_PORT_TENDER(),
	
	/**
	 * Anti-pollution equipment.
	 */
	@MavlinkEnumEntry(value = 54,description = "Anti-pollution equipment.")
	AIS_TYPE_ANTI_POLLUTION(),
	
	/**
	 * AIS_TYPE_LAW_ENFORCEMENT
	 */
	@MavlinkEnumEntry(value = 55)
	AIS_TYPE_LAW_ENFORCEMENT(),
	
	/**
	 * AIS_TYPE_SPARE_LOCAL_1
	 */
	@MavlinkEnumEntry(value = 56)
	AIS_TYPE_SPARE_LOCAL_1(),
	
	/**
	 * AIS_TYPE_SPARE_LOCAL_2
	 */
	@MavlinkEnumEntry(value = 57)
	AIS_TYPE_SPARE_LOCAL_2(),
	
	/**
	 * AIS_TYPE_MEDICAL_TRANSPORT
	 */
	@MavlinkEnumEntry(value = 58)
	AIS_TYPE_MEDICAL_TRANSPORT(),
	
	/**
	 * Noncombatant ship according to RR Resolution No. 18.
	 */
	@MavlinkEnumEntry(value = 59,description = "Noncombatant ship according to RR Resolution No. 18.")
	AIS_TYPE_NONECOMBATANT(),
	
	/**
	 * AIS_TYPE_PASSENGER
	 */
	@MavlinkEnumEntry(value = 60)
	AIS_TYPE_PASSENGER(),
	
	/**
	 * AIS_TYPE_PASSENGER_HAZARDOUS_A
	 */
	@MavlinkEnumEntry(value = 61)
	AIS_TYPE_PASSENGER_HAZARDOUS_A(),
	
	/**
	 * AIS_TYPE_PASSENGER_HAZARDOUS_B
	 */
	@MavlinkEnumEntry(value = 62)
	AIS_TYPE_PASSENGER_HAZARDOUS_B(),
	
	/**
	 * AIS_TYPE_AIS_TYPE_PASSENGER_HAZARDOUS_C
	 */
	@MavlinkEnumEntry(value = 63)
	AIS_TYPE_AIS_TYPE_PASSENGER_HAZARDOUS_C(),
	
	/**
	 * AIS_TYPE_PASSENGER_HAZARDOUS_D
	 */
	@MavlinkEnumEntry(value = 64)
	AIS_TYPE_PASSENGER_HAZARDOUS_D(),
	
	/**
	 * AIS_TYPE_PASSENGER_RESERVED_1
	 */
	@MavlinkEnumEntry(value = 65)
	AIS_TYPE_PASSENGER_RESERVED_1(),
	
	/**
	 * AIS_TYPE_PASSENGER_RESERVED_2
	 */
	@MavlinkEnumEntry(value = 66)
	AIS_TYPE_PASSENGER_RESERVED_2(),
	
	/**
	 * AIS_TYPE_PASSENGER_RESERVED_3
	 */
	@MavlinkEnumEntry(value = 67)
	AIS_TYPE_PASSENGER_RESERVED_3(),
	
	/**
	 * AIS_TYPE_AIS_TYPE_PASSENGER_RESERVED_4
	 */
	@MavlinkEnumEntry(value = 68)
	AIS_TYPE_AIS_TYPE_PASSENGER_RESERVED_4(),
	
	/**
	 * AIS_TYPE_PASSENGER_UNKNOWN
	 */
	@MavlinkEnumEntry(value = 69)
	AIS_TYPE_PASSENGER_UNKNOWN(),
	
	/**
	 * AIS_TYPE_CARGO
	 */
	@MavlinkEnumEntry(value = 70)
	AIS_TYPE_CARGO(),
	
	/**
	 * AIS_TYPE_CARGO_HAZARDOUS_A
	 */
	@MavlinkEnumEntry(value = 71)
	AIS_TYPE_CARGO_HAZARDOUS_A(),
	
	/**
	 * AIS_TYPE_CARGO_HAZARDOUS_B
	 */
	@MavlinkEnumEntry(value = 72)
	AIS_TYPE_CARGO_HAZARDOUS_B(),
	
	/**
	 * AIS_TYPE_CARGO_HAZARDOUS_C
	 */
	@MavlinkEnumEntry(value = 73)
	AIS_TYPE_CARGO_HAZARDOUS_C(),
	
	/**
	 * AIS_TYPE_CARGO_HAZARDOUS_D
	 */
	@MavlinkEnumEntry(value = 74)
	AIS_TYPE_CARGO_HAZARDOUS_D(),
	
	/**
	 * AIS_TYPE_CARGO_RESERVED_1
	 */
	@MavlinkEnumEntry(value = 75)
	AIS_TYPE_CARGO_RESERVED_1(),
	
	/**
	 * AIS_TYPE_CARGO_RESERVED_2
	 */
	@MavlinkEnumEntry(value = 76)
	AIS_TYPE_CARGO_RESERVED_2(),
	
	/**
	 * AIS_TYPE_CARGO_RESERVED_3
	 */
	@MavlinkEnumEntry(value = 77)
	AIS_TYPE_CARGO_RESERVED_3(),
	
	/**
	 * AIS_TYPE_CARGO_RESERVED_4
	 */
	@MavlinkEnumEntry(value = 78)
	AIS_TYPE_CARGO_RESERVED_4(),
	
	/**
	 * AIS_TYPE_CARGO_UNKNOWN
	 */
	@MavlinkEnumEntry(value = 79)
	AIS_TYPE_CARGO_UNKNOWN(),
	
	/**
	 * AIS_TYPE_TANKER
	 */
	@MavlinkEnumEntry(value = 80)
	AIS_TYPE_TANKER(),
	
	/**
	 * AIS_TYPE_TANKER_HAZARDOUS_A
	 */
	@MavlinkEnumEntry(value = 81)
	AIS_TYPE_TANKER_HAZARDOUS_A(),
	
	/**
	 * AIS_TYPE_TANKER_HAZARDOUS_B
	 */
	@MavlinkEnumEntry(value = 82)
	AIS_TYPE_TANKER_HAZARDOUS_B(),
	
	/**
	 * AIS_TYPE_TANKER_HAZARDOUS_C
	 */
	@MavlinkEnumEntry(value = 83)
	AIS_TYPE_TANKER_HAZARDOUS_C(),
	
	/**
	 * AIS_TYPE_TANKER_HAZARDOUS_D
	 */
	@MavlinkEnumEntry(value = 84)
	AIS_TYPE_TANKER_HAZARDOUS_D(),
	
	/**
	 * AIS_TYPE_TANKER_RESERVED_1
	 */
	@MavlinkEnumEntry(value = 85)
	AIS_TYPE_TANKER_RESERVED_1(),
	
	/**
	 * AIS_TYPE_TANKER_RESERVED_2
	 */
	@MavlinkEnumEntry(value = 86)
	AIS_TYPE_TANKER_RESERVED_2(),
	
	/**
	 * AIS_TYPE_TANKER_RESERVED_3
	 */
	@MavlinkEnumEntry(value = 87)
	AIS_TYPE_TANKER_RESERVED_3(),
	
	/**
	 * AIS_TYPE_TANKER_RESERVED_4
	 */
	@MavlinkEnumEntry(value = 88)
	AIS_TYPE_TANKER_RESERVED_4(),
	
	/**
	 * AIS_TYPE_TANKER_UNKNOWN
	 */
	@MavlinkEnumEntry(value = 89)
	AIS_TYPE_TANKER_UNKNOWN(),
	
	/**
	 * AIS_TYPE_OTHER
	 */
	@MavlinkEnumEntry(value = 90)
	AIS_TYPE_OTHER(),
	
	/**
	 * AIS_TYPE_OTHER_HAZARDOUS_A
	 */
	@MavlinkEnumEntry(value = 91)
	AIS_TYPE_OTHER_HAZARDOUS_A(),
	
	/**
	 * AIS_TYPE_OTHER_HAZARDOUS_B
	 */
	@MavlinkEnumEntry(value = 92)
	AIS_TYPE_OTHER_HAZARDOUS_B(),
	
	/**
	 * AIS_TYPE_OTHER_HAZARDOUS_C
	 */
	@MavlinkEnumEntry(value = 93)
	AIS_TYPE_OTHER_HAZARDOUS_C(),
	
	/**
	 * AIS_TYPE_OTHER_HAZARDOUS_D
	 */
	@MavlinkEnumEntry(value = 94)
	AIS_TYPE_OTHER_HAZARDOUS_D(),
	
	/**
	 * AIS_TYPE_OTHER_RESERVED_1
	 */
	@MavlinkEnumEntry(value = 95)
	AIS_TYPE_OTHER_RESERVED_1(),
	
	/**
	 * AIS_TYPE_OTHER_RESERVED_2
	 */
	@MavlinkEnumEntry(value = 96)
	AIS_TYPE_OTHER_RESERVED_2(),
	
	/**
	 * AIS_TYPE_OTHER_RESERVED_3
	 */
	@MavlinkEnumEntry(value = 97)
	AIS_TYPE_OTHER_RESERVED_3(),
	
	/**
	 * AIS_TYPE_OTHER_RESERVED_4
	 */
	@MavlinkEnumEntry(value = 98)
	AIS_TYPE_OTHER_RESERVED_4(),
	
	/**
	 * AIS_TYPE_OTHER_UNKNOWN
	 */
	@MavlinkEnumEntry(value = 99)
	AIS_TYPE_OTHER_UNKNOWN(),
}
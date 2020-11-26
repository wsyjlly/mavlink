package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "MAV_ODID_CLASS_EU")
public enum  MavOdidClassEu {
	
	/**
	 * The class for the UA, according to the EU specification, is undeclared.
	 */
	@MavlinkEnumEntry(value = 0,description = "The class for the UA, according to the EU specification, is undeclared.")
	MAV_ODID_CLASS_EU_UNDECLARED(),
	
	/**
	 * The class for the UA, according to the EU specification, is Class 0.
	 */
	@MavlinkEnumEntry(value = 1,description = "The class for the UA, according to the EU specification, is Class 0.")
	MAV_ODID_CLASS_EU_CLASS_0(),
	
	/**
	 * The class for the UA, according to the EU specification, is Class 1.
	 */
	@MavlinkEnumEntry(value = 2,description = "The class for the UA, according to the EU specification, is Class 1.")
	MAV_ODID_CLASS_EU_CLASS_1(),
	
	/**
	 * The class for the UA, according to the EU specification, is Class 2.
	 */
	@MavlinkEnumEntry(value = 3,description = "The class for the UA, according to the EU specification, is Class 2.")
	MAV_ODID_CLASS_EU_CLASS_2(),
	
	/**
	 * The class for the UA, according to the EU specification, is Class 3.
	 */
	@MavlinkEnumEntry(value = 4,description = "The class for the UA, according to the EU specification, is Class 3.")
	MAV_ODID_CLASS_EU_CLASS_3(),
	
	/**
	 * The class for the UA, according to the EU specification, is Class 4.
	 */
	@MavlinkEnumEntry(value = 5,description = "The class for the UA, according to the EU specification, is Class 4.")
	MAV_ODID_CLASS_EU_CLASS_4(),
	
	/**
	 * The class for the UA, according to the EU specification, is Class 5.
	 */
	@MavlinkEnumEntry(value = 6,description = "The class for the UA, according to the EU specification, is Class 5.")
	MAV_ODID_CLASS_EU_CLASS_5(),
	
	/**
	 * The class for the UA, according to the EU specification, is Class 6.
	 */
	@MavlinkEnumEntry(value = 7,description = "The class for the UA, according to the EU specification, is Class 6.")
	MAV_ODID_CLASS_EU_CLASS_6(),
}
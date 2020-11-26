package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "MAV_ODID_CATEGORY_EU")
public enum  MavOdidCategoryEu {
	
	/**
	 * The category for the UA, according to the EU specification, is undeclared.
	 */
	@MavlinkEnumEntry(value = 0,description = "The category for the UA, according to the EU specification, is undeclared.")
	MAV_ODID_CATEGORY_EU_UNDECLARED(),
	
	/**
	 * The category for the UA, according to the EU specification, is the Open category.
	 */
	@MavlinkEnumEntry(value = 1,description = "The category for the UA, according to the EU specification, is the Open category.")
	MAV_ODID_CATEGORY_EU_OPEN(),
	
	/**
	 * The category for the UA, according to the EU specification, is the Specific category.
	 */
	@MavlinkEnumEntry(value = 2,description = "The category for the UA, according to the EU specification, is the Specific category.")
	MAV_ODID_CATEGORY_EU_SPECIFIC(),
	
	/**
	 * The category for the UA, according to the EU specification, is the Certified category.
	 */
	@MavlinkEnumEntry(value = 3,description = "The category for the UA, according to the EU specification, is the Certified category.")
	MAV_ODID_CATEGORY_EU_CERTIFIED(),
}
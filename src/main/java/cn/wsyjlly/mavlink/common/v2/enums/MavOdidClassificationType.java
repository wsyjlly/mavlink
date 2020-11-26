package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "MAV_ODID_CLASSIFICATION_TYPE")
public enum  MavOdidClassificationType {
	
	/**
	 * The classification type for the UA is undeclared.
	 */
	@MavlinkEnumEntry(value = 0,description = "The classification type for the UA is undeclared.")
	MAV_ODID_CLASSIFICATION_TYPE_UNDECLARED(),
	
	/**
	 * The classification type for the UA follows EU (European Union) specifications.
	 */
	@MavlinkEnumEntry(value = 1,description = "The classification type for the UA follows EU (European Union) specifications.")
	MAV_ODID_CLASSIFICATION_TYPE_EU(),
}
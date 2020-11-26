package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "UAVCAN_NODE_MODE")
public enum  UavcanNodeMode {
	
	/**
	 * The node is performing its primary functions.
	 */
	@MavlinkEnumEntry(value = 0,description = "The node is performing its primary functions.")
	UAVCAN_NODE_MODE_OPERATIONAL(),
	
	/**
	 * The node is initializing; this mode is entered immediately after startup.
	 */
	@MavlinkEnumEntry(value = 1,description = "The node is initializing; this mode is entered immediately after startup.")
	UAVCAN_NODE_MODE_INITIALIZATION(),
	
	/**
	 * The node is under maintenance.
	 */
	@MavlinkEnumEntry(value = 2,description = "The node is under maintenance.")
	UAVCAN_NODE_MODE_MAINTENANCE(),
	
	/**
	 * The node is in the process of updating its software.
	 */
	@MavlinkEnumEntry(value = 3,description = "The node is in the process of updating its software.")
	UAVCAN_NODE_MODE_SOFTWARE_UPDATE(),
	
	/**
	 * The node is no longer available online.
	 */
	@MavlinkEnumEntry(value = 7,description = "The node is no longer available online.")
	UAVCAN_NODE_MODE_OFFLINE(),
}
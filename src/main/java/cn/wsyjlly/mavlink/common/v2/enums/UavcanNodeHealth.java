package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "UAVCAN_NODE_HEALTH")
public enum  UavcanNodeHealth {
	
	/**
	 * The node is functioning properly.
	 */
	@MavlinkEnumEntry(value = 0,description = "The node is functioning properly.")
	UAVCAN_NODE_HEALTH_OK(),
	
	/**
	 * A critical parameter went out of range or the node has encountered a minor failure.
	 */
	@MavlinkEnumEntry(value = 1,description = "A critical parameter went out of range or the node has encountered a minor failure.")
	UAVCAN_NODE_HEALTH_WARNING(),
	
	/**
	 * The node has encountered a major failure.
	 */
	@MavlinkEnumEntry(value = 2,description = "The node has encountered a major failure.")
	UAVCAN_NODE_HEALTH_ERROR(),
	
	/**
	 * The node has suffered a fatal malfunction.
	 */
	@MavlinkEnumEntry(value = 3,description = "The node has suffered a fatal malfunction.")
	UAVCAN_NODE_HEALTH_CRITICAL(),
}
package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "MAV_COLLISION_ACTION")
public enum  MavCollisionAction {
	
	/**
	 * Ignore any potential collisions
	 */
	@MavlinkEnumEntry(value = 0,description = "Ignore any potential collisions")
	MAV_COLLISION_ACTION_NONE(),
	
	/**
	 * Report potential collision
	 */
	@MavlinkEnumEntry(value = 1,description = "Report potential collision")
	MAV_COLLISION_ACTION_REPORT(),
	
	/**
	 * Ascend or Descend to avoid threat
	 */
	@MavlinkEnumEntry(value = 2,description = "Ascend or Descend to avoid threat")
	MAV_COLLISION_ACTION_ASCEND_OR_DESCEND(),
	
	/**
	 * Move horizontally to avoid threat
	 */
	@MavlinkEnumEntry(value = 3,description = "Move horizontally to avoid threat")
	MAV_COLLISION_ACTION_MOVE_HORIZONTALLY(),
	
	/**
	 * Aircraft to move perpendicular to the collision's velocity vector
	 */
	@MavlinkEnumEntry(value = 4,description = "Aircraft to move perpendicular to the collision's velocity vector")
	MAV_COLLISION_ACTION_MOVE_PERPENDICULAR(),
	
	/**
	 * Aircraft to fly directly back to its launch point
	 */
	@MavlinkEnumEntry(value = 5,description = "Aircraft to fly directly back to its launch point")
	MAV_COLLISION_ACTION_RTL(),
	
	/**
	 * Aircraft to stop in place
	 */
	@MavlinkEnumEntry(value = 6,description = "Aircraft to stop in place")
	MAV_COLLISION_ACTION_HOVER(),
}
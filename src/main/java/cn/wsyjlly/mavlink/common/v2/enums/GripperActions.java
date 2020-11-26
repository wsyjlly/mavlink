package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "GRIPPER_ACTIONS")
public enum  GripperActions {
	
	/**
	 * Gripper release cargo.
	 */
	@MavlinkEnumEntry(value = 0,description = "Gripper release cargo.")
	GRIPPER_ACTION_RELEASE(),
	
	/**
	 * Gripper grab onto cargo.
	 */
	@MavlinkEnumEntry(value = 1,description = "Gripper grab onto cargo.")
	GRIPPER_ACTION_GRAB(),
}
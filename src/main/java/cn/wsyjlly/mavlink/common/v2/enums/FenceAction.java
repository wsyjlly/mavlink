package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "FENCE_ACTION")
public enum  FenceAction {
	
	/**
	 * Disable fenced mode
	 */
	@MavlinkEnumEntry(value = 0,description = "Disable fenced mode")
	FENCE_ACTION_NONE(),
	
	/**
	 * Switched to guided mode to return point (fence point 0)
	 */
	@MavlinkEnumEntry(value = 1,description = "Switched to guided mode to return point (fence point 0)")
	FENCE_ACTION_GUIDED(),
	
	/**
	 * Report fence breach, but don't take action
	 */
	@MavlinkEnumEntry(value = 2,description = "Report fence breach, but don't take action")
	FENCE_ACTION_REPORT(),
	
	/**
	 * Switched to guided mode to return point (fence point 0) with manual throttle control
	 */
	@MavlinkEnumEntry(value = 3,description = "Switched to guided mode to return point (fence point 0) with manual throttle control")
	FENCE_ACTION_GUIDED_THR_PASS(),
	
	/**
	 * Switch to RTL (return to launch) mode and head for the return point.
	 */
	@MavlinkEnumEntry(value = 4,description = "Switch to RTL (return to launch) mode and head for the return point.")
	FENCE_ACTION_RTL(),
}
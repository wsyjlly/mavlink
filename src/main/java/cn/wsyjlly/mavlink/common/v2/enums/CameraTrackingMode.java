package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "CAMERA_TRACKING_MODE")
public enum  CameraTrackingMode {
	
	/**
	 * Not tracking
	 */
	@MavlinkEnumEntry(value = 0,description = "Not tracking")
	CAMERA_TRACKING_NONE(),
	
	/**
	 * Target is a point
	 */
	@MavlinkEnumEntry(value = 1,description = "Target is a point")
	CAMERA_TRACKING_POINT(),
	
	/**
	 * Target is a rectangle
	 */
	@MavlinkEnumEntry(value = 2,description = "Target is a rectangle")
	CAMERA_TRACKING_RECTANGLE(),
}
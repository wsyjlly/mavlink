package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "CAMERA_TRACKING_STATUS_FLAGS")
public enum  CameraTrackingStatusFlags {
	
	/**
	 * Camera is not tracking
	 */
	@MavlinkEnumEntry(value = 0,description = "Camera is not tracking")
	CAMERA_TRACKING_STATUS_FLAGS_IDLE(),
	
	/**
	 * Camera is tracking
	 */
	@MavlinkEnumEntry(value = 1,description = "Camera is tracking")
	CAMERA_TRACKING_STATUS_FLAGS_ACTIVE(),
	
	/**
	 * Camera tracking in error state
	 */
	@MavlinkEnumEntry(value = 2,description = "Camera tracking in error state")
	CAMERA_TRACKING_STATUS_FLAGS_ERROR(),
}
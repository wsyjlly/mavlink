package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "CAMERA_TRACKING_TARGET_DATA", bitmask = "true")
public enum  CameraTrackingTargetData {
	
	/**
	 * No target data
	 */
	@MavlinkEnumEntry(value = 0,description = "No target data")
	CAMERA_TRACKING_TARGET_NONE(),
	
	/**
	 * Target data embedded in image data (proprietary)
	 */
	@MavlinkEnumEntry(value = 1,description = "Target data embedded in image data (proprietary)")
	CAMERA_TRACKING_TARGET_EMBEDDED(),
	
	/**
	 * Target data rendered in image
	 */
	@MavlinkEnumEntry(value = 2,description = "Target data rendered in image")
	CAMERA_TRACKING_TARGET_RENDERED(),
	
	/**
	 * Target data within status message (Point or Rectangle)
	 */
	@MavlinkEnumEntry(value = 4,description = "Target data within status message (Point or Rectangle)")
	CAMERA_TRACKING_TARGET_IN_STATUS(),
}
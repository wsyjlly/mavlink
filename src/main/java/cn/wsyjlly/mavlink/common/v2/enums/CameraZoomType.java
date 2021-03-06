package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "CAMERA_ZOOM_TYPE")
public enum  CameraZoomType {
	
	/**
	 * Zoom one step increment (-1 for wide, 1 for tele)
	 */
	@MavlinkEnumEntry(value = 0,description = "Zoom one step increment (-1 for wide, 1 for tele)")
	ZOOM_TYPE_STEP(),
	
	/**
	 * Continuous zoom up/down until stopped (-1 for wide, 1 for tele, 0 to stop zooming)
	 */
	@MavlinkEnumEntry(value = 1,description = "Continuous zoom up/down until stopped (-1 for wide, 1 for tele, 0 to stop zooming)")
	ZOOM_TYPE_CONTINUOUS(),
	
	/**
	 * Zoom value as proportion of full camera range (a value between 0.0 and 100.0)
	 */
	@MavlinkEnumEntry(value = 2,description = "Zoom value as proportion of full camera range (a value between 0.0 and 100.0)")
	ZOOM_TYPE_RANGE(),
	
	/**
	 * Zoom value/variable focal length in milimetres. Note that there is no message to get the valid zoom range of the camera, so this can type can only be used for cameras where the zoom range is known (implying that this cannot reliably be used in a GCS for an arbitrary camera)
	 */
	@MavlinkEnumEntry(value = 3,description = "Zoom value/variable focal length in milimetres. Note that there is no message to get the valid zoom range of the camera, so this can type can only be used for cameras where the zoom range is known (implying that this cannot reliably be used in a GCS for an arbitrary camera)")
	ZOOM_TYPE_FOCAL_LENGTH(),
}
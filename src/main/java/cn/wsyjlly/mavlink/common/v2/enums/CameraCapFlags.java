package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "CAMERA_CAP_FLAGS", bitmask = "true")
public enum  CameraCapFlags {
	
	/**
	 * Camera is able to record video
	 */
	@MavlinkEnumEntry(value = 1,description = "Camera is able to record video")
	CAMERA_CAP_FLAGS_CAPTURE_VIDEO(),
	
	/**
	 * Camera is able to capture images
	 */
	@MavlinkEnumEntry(value = 2,description = "Camera is able to capture images")
	CAMERA_CAP_FLAGS_CAPTURE_IMAGE(),
	
	/**
	 * Camera has separate Video and Image/Photo modes (MAV_CMD_SET_CAMERA_MODE)
	 */
	@MavlinkEnumEntry(value = 4,description = "Camera has separate Video and Image/Photo modes (MAV_CMD_SET_CAMERA_MODE)")
	CAMERA_CAP_FLAGS_HAS_MODES(),
	
	/**
	 * Camera can capture images while in video mode
	 */
	@MavlinkEnumEntry(value = 8,description = "Camera can capture images while in video mode")
	CAMERA_CAP_FLAGS_CAN_CAPTURE_IMAGE_IN_VIDEO_MODE(),
	
	/**
	 * Camera can capture videos while in Photo/Image mode
	 */
	@MavlinkEnumEntry(value = 16,description = "Camera can capture videos while in Photo/Image mode")
	CAMERA_CAP_FLAGS_CAN_CAPTURE_VIDEO_IN_IMAGE_MODE(),
	
	/**
	 * Camera has image survey mode (MAV_CMD_SET_CAMERA_MODE)
	 */
	@MavlinkEnumEntry(value = 32,description = "Camera has image survey mode (MAV_CMD_SET_CAMERA_MODE)")
	CAMERA_CAP_FLAGS_HAS_IMAGE_SURVEY_MODE(),
	
	/**
	 * Camera has basic zoom control (MAV_CMD_SET_CAMERA_ZOOM)
	 */
	@MavlinkEnumEntry(value = 64,description = "Camera has basic zoom control (MAV_CMD_SET_CAMERA_ZOOM)")
	CAMERA_CAP_FLAGS_HAS_BASIC_ZOOM(),
	
	/**
	 * Camera has basic focus control (MAV_CMD_SET_CAMERA_FOCUS)
	 */
	@MavlinkEnumEntry(value = 128,description = "Camera has basic focus control (MAV_CMD_SET_CAMERA_FOCUS)")
	CAMERA_CAP_FLAGS_HAS_BASIC_FOCUS(),
	
	/**
	 * Camera has video streaming capabilities (request VIDEO_STREAM_INFORMATION with MAV_CMD_REQUEST_MESSAGE for video streaming info)
	 */
	@MavlinkEnumEntry(value = 256,description = "Camera has video streaming capabilities (request VIDEO_STREAM_INFORMATION with MAV_CMD_REQUEST_MESSAGE for video streaming info)")
	CAMERA_CAP_FLAGS_HAS_VIDEO_STREAM(),
	
	/**
	 * Camera supports tracking of a point on the camera view.
	 */
	@MavlinkEnumEntry(value = 512,description = "Camera supports tracking of a point on the camera view.")
	CAMERA_CAP_FLAGS_HAS_TRACKING_POINT(),
	
	/**
	 * Camera supports tracking of a selection rectangle on the camera view.
	 */
	@MavlinkEnumEntry(value = 1024,description = "Camera supports tracking of a selection rectangle on the camera view.")
	CAMERA_CAP_FLAGS_HAS_TRACKING_RECTANGLE(),
	
	/**
	 * Camera supports tracking geo status (CAMERA_TRACKING_GEO_STATUS).
	 */
	@MavlinkEnumEntry(value = 2048,description = "Camera supports tracking geo status (CAMERA_TRACKING_GEO_STATUS).")
	CAMERA_CAP_FLAGS_HAS_TRACKING_GEO_STATUS(),
}
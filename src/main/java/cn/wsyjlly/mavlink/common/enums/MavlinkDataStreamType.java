package cn.wsyjlly.mavlink.common.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.09 - 03:37
 *
 **********************************/

@MavlinkEnum(name = "MAVLINK_DATA_STREAM_TYPE")
public enum  MavlinkDataStreamType {
	
	/**
	 * 
	 */
	@MavlinkEnumEntry(description = "")
	MAVLINK_DATA_STREAM_IMG_JPEG(),
	
	/**
	 * 
	 */
	@MavlinkEnumEntry(description = "")
	MAVLINK_DATA_STREAM_IMG_BMP(),
	
	/**
	 * 
	 */
	@MavlinkEnumEntry(description = "")
	MAVLINK_DATA_STREAM_IMG_RAW8U(),
	
	/**
	 * 
	 */
	@MavlinkEnumEntry(description = "")
	MAVLINK_DATA_STREAM_IMG_RAW32U(),
	
	/**
	 * 
	 */
	@MavlinkEnumEntry(description = "")
	MAVLINK_DATA_STREAM_IMG_PGM(),
	
	/**
	 * 
	 */
	@MavlinkEnumEntry(description = "")
	MAVLINK_DATA_STREAM_IMG_PNG(),
}
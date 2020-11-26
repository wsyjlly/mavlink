package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "VIDEO_STREAM_TYPE")
public enum  VideoStreamType {
	
	/**
	 * Stream is RTSP
	 */
	@MavlinkEnumEntry(value = 0,description = "Stream is RTSP")
	VIDEO_STREAM_TYPE_RTSP(),
	
	/**
	 * Stream is RTP UDP (URI gives the port number)
	 */
	@MavlinkEnumEntry(value = 1,description = "Stream is RTP UDP (URI gives the port number)")
	VIDEO_STREAM_TYPE_RTPUDP(),
	
	/**
	 * Stream is MPEG on TCP
	 */
	@MavlinkEnumEntry(value = 2,description = "Stream is MPEG on TCP")
	VIDEO_STREAM_TYPE_TCP_MPEG(),
	
	/**
	 * Stream is h.264 on MPEG TS (URI gives the port number)
	 */
	@MavlinkEnumEntry(value = 3,description = "Stream is h.264 on MPEG TS (URI gives the port number)")
	VIDEO_STREAM_TYPE_MPEG_TS_H264(),
}
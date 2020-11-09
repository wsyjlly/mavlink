package cn.wsyjlly.mavlink.common.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.09 - 03:37
 *
 **********************************/

@MavlinkEnum(name = "MAV_MOUNT_MODE")
public enum  MavMountMode {
	
	/**
	 * Load and keep safe position (Roll,Pitch,Yaw) from permant memory and stop stabilization
	 */
	@MavlinkEnumEntry(value = 0,description = "Load and keep safe position (Roll,Pitch,Yaw) from permant memory and stop stabilization")
	MAV_MOUNT_MODE_RETRACT(),
	
	/**
	 * Load and keep neutral position (Roll,Pitch,Yaw) from permanent memory.
	 */
	@MavlinkEnumEntry(value = 1,description = "Load and keep neutral position (Roll,Pitch,Yaw) from permanent memory.")
	MAV_MOUNT_MODE_NEUTRAL(),
	
	/**
	 * Load neutral position and start MAVLink Roll,Pitch,Yaw control with stabilization
	 */
	@MavlinkEnumEntry(value = 2,description = "Load neutral position and start MAVLink Roll,Pitch,Yaw control with stabilization")
	MAV_MOUNT_MODE_MAVLINK_TARGETING(),
	
	/**
	 * Load neutral position and start RC Roll,Pitch,Yaw control with stabilization
	 */
	@MavlinkEnumEntry(value = 3,description = "Load neutral position and start RC Roll,Pitch,Yaw control with stabilization")
	MAV_MOUNT_MODE_RC_TARGETING(),
	
	/**
	 * Load neutral position and start to point to Lat,Lon,Alt
	 */
	@MavlinkEnumEntry(value = 4,description = "Load neutral position and start to point to Lat,Lon,Alt")
	MAV_MOUNT_MODE_GPS_POINT(),
}
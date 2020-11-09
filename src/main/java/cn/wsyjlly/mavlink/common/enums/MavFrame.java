package cn.wsyjlly.mavlink.common.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.09 - 03:37
 *
 **********************************/

@MavlinkEnum(name = "MAV_FRAME")
public enum  MavFrame {
	
	/**
	 * Global coordinate frame, WGS84 coordinate system. First value / x: latitude, second value / y: longitude, third value / z: positive altitude over mean sea level (MSL)
	 */
	@MavlinkEnumEntry(value = 0,description = "Global coordinate frame, WGS84 coordinate system. First value / x: latitude, second value / y: longitude, third value / z: positive altitude over mean sea level (MSL)")
	MAV_FRAME_GLOBAL(),
	
	/**
	 * Local coordinate frame, Z-up (x: north, y: east, z: down).
	 */
	@MavlinkEnumEntry(value = 1,description = "Local coordinate frame, Z-up (x: north, y: east, z: down).")
	MAV_FRAME_LOCAL_NED(),
	
	/**
	 * NOT a coordinate frame, indicates a mission command.
	 */
	@MavlinkEnumEntry(value = 2,description = "NOT a coordinate frame, indicates a mission command.")
	MAV_FRAME_MISSION(),
	
	/**
	 * Global coordinate frame, WGS84 coordinate system, relative altitude over ground with respect to the home position. First value / x: latitude, second value / y: longitude, third value / z: positive altitude with 0 being at the altitude of the home location.
	 */
	@MavlinkEnumEntry(value = 3,description = "Global coordinate frame, WGS84 coordinate system, relative altitude over ground with respect to the home position. First value / x: latitude, second value / y: longitude, third value / z: positive altitude with 0 being at the altitude of the home location.")
	MAV_FRAME_GLOBAL_RELATIVE_ALT(),
	
	/**
	 * Local coordinate frame, Z-down (x: east, y: north, z: up)
	 */
	@MavlinkEnumEntry(value = 4,description = "Local coordinate frame, Z-down (x: east, y: north, z: up)")
	MAV_FRAME_LOCAL_ENU(),
	
	/**
	 * Offset to the current local frame. Anything expressed in this frame should be added to the current local frame position.
	 */
	@MavlinkEnumEntry(value = 7,description = "Offset to the current local frame. Anything expressed in this frame should be added to the current local frame position.")
	MAV_FRAME_LOCAL_OFFSET_NED(),
	
	/**
	 * Setpoint in body NED frame. This makes sense if all position control is externalized - e.g. useful to command 2 m/s^2 acceleration to the right.
	 */
	@MavlinkEnumEntry(value = 8,description = "Setpoint in body NED frame. This makes sense if all position control is externalized - e.g. useful to command 2 m/s^2 acceleration to the right.")
	MAV_FRAME_BODY_NED(),
	
	/**
	 * Offset in body NED frame. This makes sense if adding setpoints to the current flight path, to avoid an obstacle - e.g. useful to command 2 m/s^2 acceleration to the east.
	 */
	@MavlinkEnumEntry(value = 9,description = "Offset in body NED frame. This makes sense if adding setpoints to the current flight path, to avoid an obstacle - e.g. useful to command 2 m/s^2 acceleration to the east.")
	MAV_FRAME_BODY_OFFSET_NED(),
	
	/**
	 * Global coordinate frame with above terrain level altitude. WGS84 coordinate system, relative altitude over terrain with respect to the waypoint coordinate. First value / x: latitude in degrees, second value / y: longitude in degrees, third value / z: positive altitude in meters with 0 being at ground level in terrain model.
	 */
	@MavlinkEnumEntry(value = 10,description = "Global coordinate frame with above terrain level altitude. WGS84 coordinate system, relative altitude over terrain with respect to the waypoint coordinate. First value / x: latitude in degrees, second value / y: longitude in degrees, third value / z: positive altitude in meters with 0 being at ground level in terrain model.")
	MAV_FRAME_GLOBAL_TERRAIN_ALT(),
}
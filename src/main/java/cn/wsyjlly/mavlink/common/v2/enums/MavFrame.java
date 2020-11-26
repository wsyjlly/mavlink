package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "MAV_FRAME")
public enum  MavFrame {
	
	/**
	 * Global (WGS84) coordinate frame + MSL altitude. First value / x: latitude, second value / y: longitude, third value / z: positive altitude over mean sea level (MSL).
	 */
	@MavlinkEnumEntry(value = 0,description = "Global (WGS84) coordinate frame + MSL altitude. First value / x: latitude, second value / y: longitude, third value / z: positive altitude over mean sea level (MSL).")
	MAV_FRAME_GLOBAL(),
	
	/**
	 * Local coordinate frame, Z-down (x: North, y: East, z: Down).
	 */
	@MavlinkEnumEntry(value = 1,description = "Local coordinate frame, Z-down (x: North, y: East, z: Down).")
	MAV_FRAME_LOCAL_NED(),
	
	/**
	 * NOT a coordinate frame, indicates a mission command.
	 */
	@MavlinkEnumEntry(value = 2,description = "NOT a coordinate frame, indicates a mission command.")
	MAV_FRAME_MISSION(),
	
	/**
	 * Global (WGS84) coordinate frame + altitude relative to the home position. First value / x: latitude, second value / y: longitude, third value / z: positive altitude with 0 being at the altitude of the home location.
	 */
	@MavlinkEnumEntry(value = 3,description = "Global (WGS84) coordinate frame + altitude relative to the home position. First value / x: latitude, second value / y: longitude, third value / z: positive altitude with 0 being at the altitude of the home location.")
	MAV_FRAME_GLOBAL_RELATIVE_ALT(),
	
	/**
	 * Local coordinate frame, Z-up (x: East, y: North, z: Up).
	 */
	@MavlinkEnumEntry(value = 4,description = "Local coordinate frame, Z-up (x: East, y: North, z: Up).")
	MAV_FRAME_LOCAL_ENU(),
	
	/**
	 * Global (WGS84) coordinate frame (scaled) + MSL altitude. First value / x: latitude in degrees*1.0e-7, second value / y: longitude in degrees*1.0e-7, third value / z: positive altitude over mean sea level (MSL).
	 */
	@MavlinkEnumEntry(value = 5,description = "Global (WGS84) coordinate frame (scaled) + MSL altitude. First value / x: latitude in degrees*1.0e-7, second value / y: longitude in degrees*1.0e-7, third value / z: positive altitude over mean sea level (MSL).")
	MAV_FRAME_GLOBAL_INT(),
	
	/**
	 * Global (WGS84) coordinate frame (scaled) + altitude relative to the home position. First value / x: latitude in degrees*10e-7, second value / y: longitude in degrees*10e-7, third value / z: positive altitude with 0 being at the altitude of the home location.
	 */
	@MavlinkEnumEntry(value = 6,description = "Global (WGS84) coordinate frame (scaled) + altitude relative to the home position. First value / x: latitude in degrees*10e-7, second value / y: longitude in degrees*10e-7, third value / z: positive altitude with 0 being at the altitude of the home location.")
	MAV_FRAME_GLOBAL_RELATIVE_ALT_INT(),
	
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
	 * Global (WGS84) coordinate frame with AGL altitude (at the waypoint coordinate). First value / x: latitude in degrees, second value / y: longitude in degrees, third value / z: positive altitude in meters with 0 being at ground level in terrain model.
	 */
	@MavlinkEnumEntry(value = 10,description = "Global (WGS84) coordinate frame with AGL altitude (at the waypoint coordinate). First value / x: latitude in degrees, second value / y: longitude in degrees, third value / z: positive altitude in meters with 0 being at ground level in terrain model.")
	MAV_FRAME_GLOBAL_TERRAIN_ALT(),
	
	/**
	 * Global (WGS84) coordinate frame (scaled) with AGL altitude (at the waypoint coordinate). First value / x: latitude in degrees*10e-7, second value / y: longitude in degrees*10e-7, third value / z: positive altitude in meters with 0 being at ground level in terrain model.
	 */
	@MavlinkEnumEntry(value = 11,description = "Global (WGS84) coordinate frame (scaled) with AGL altitude (at the waypoint coordinate). First value / x: latitude in degrees*10e-7, second value / y: longitude in degrees*10e-7, third value / z: positive altitude in meters with 0 being at ground level in terrain model.")
	MAV_FRAME_GLOBAL_TERRAIN_ALT_INT(),
	
	/**
	 * Body fixed frame of reference, Z-down (x: Forward, y: Right, z: Down).
	 */
	@MavlinkEnumEntry(value = 12,description = "Body fixed frame of reference, Z-down (x: Forward, y: Right, z: Down).")
	MAV_FRAME_BODY_FRD(),
	
	/**
	 * MAV_FRAME_BODY_FLU - Body fixed frame of reference, Z-up (x: Forward, y: Left, z: Up).
	 */
	@MavlinkEnumEntry(value = 13,description = "MAV_FRAME_BODY_FLU - Body fixed frame of reference, Z-up (x: Forward, y: Left, z: Up).")
	MAV_FRAME_RESERVED_13(),
	
	/**
	 * MAV_FRAME_MOCAP_NED - Odometry local coordinate frame of data given by a motion capture system, Z-down (x: North, y: East, z: Down).
	 */
	@MavlinkEnumEntry(value = 14,description = "MAV_FRAME_MOCAP_NED - Odometry local coordinate frame of data given by a motion capture system, Z-down (x: North, y: East, z: Down).")
	MAV_FRAME_RESERVED_14(),
	
	/**
	 * MAV_FRAME_MOCAP_ENU - Odometry local coordinate frame of data given by a motion capture system, Z-up (x: East, y: North, z: Up).
	 */
	@MavlinkEnumEntry(value = 15,description = "MAV_FRAME_MOCAP_ENU - Odometry local coordinate frame of data given by a motion capture system, Z-up (x: East, y: North, z: Up).")
	MAV_FRAME_RESERVED_15(),
	
	/**
	 * MAV_FRAME_VISION_NED - Odometry local coordinate frame of data given by a vision estimation system, Z-down (x: North, y: East, z: Down).
	 */
	@MavlinkEnumEntry(value = 16,description = "MAV_FRAME_VISION_NED - Odometry local coordinate frame of data given by a vision estimation system, Z-down (x: North, y: East, z: Down).")
	MAV_FRAME_RESERVED_16(),
	
	/**
	 * MAV_FRAME_VISION_ENU - Odometry local coordinate frame of data given by a vision estimation system, Z-up (x: East, y: North, z: Up).
	 */
	@MavlinkEnumEntry(value = 17,description = "MAV_FRAME_VISION_ENU - Odometry local coordinate frame of data given by a vision estimation system, Z-up (x: East, y: North, z: Up).")
	MAV_FRAME_RESERVED_17(),
	
	/**
	 * MAV_FRAME_ESTIM_NED - Odometry local coordinate frame of data given by an estimator running onboard the vehicle, Z-down (x: North, y: East, z: Down).
	 */
	@MavlinkEnumEntry(value = 18,description = "MAV_FRAME_ESTIM_NED - Odometry local coordinate frame of data given by an estimator running onboard the vehicle, Z-down (x: North, y: East, z: Down).")
	MAV_FRAME_RESERVED_18(),
	
	/**
	 * MAV_FRAME_ESTIM_ENU - Odometry local coordinate frame of data given by an estimator running onboard the vehicle, Z-up (x: East, y: North, z: Up).
	 */
	@MavlinkEnumEntry(value = 19,description = "MAV_FRAME_ESTIM_ENU - Odometry local coordinate frame of data given by an estimator running onboard the vehicle, Z-up (x: East, y: North, z: Up).")
	MAV_FRAME_RESERVED_19(),
	
	/**
	 * Forward, Right, Down coordinate frame. This is a local frame with Z-down and arbitrary F/R alignment (i.e. not aligned with NED/earth frame).
	 */
	@MavlinkEnumEntry(value = 20,description = "Forward, Right, Down coordinate frame. This is a local frame with Z-down and arbitrary F/R alignment (i.e. not aligned with NED/earth frame).")
	MAV_FRAME_LOCAL_FRD(),
	
	/**
	 * Forward, Left, Up coordinate frame. This is a local frame with Z-up and arbitrary F/L alignment (i.e. not aligned with ENU/earth frame).
	 */
	@MavlinkEnumEntry(value = 21,description = "Forward, Left, Up coordinate frame. This is a local frame with Z-up and arbitrary F/L alignment (i.e. not aligned with ENU/earth frame).")
	MAV_FRAME_LOCAL_FLU(),
}
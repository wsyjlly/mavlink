package cn.wsyjlly.mavlink.common.v1.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:45
 *
 **********************************/

@MavlinkEnum(name = "MAV_SYS_STATUS_SENSOR")
public enum  MavSysStatusSensor {
	
	/**
	 * 0x01 3D gyro
	 */
	@MavlinkEnumEntry(value = 1,description = "0x01 3D gyro")
	MAV_SYS_STATUS_SENSOR_3D_GYRO(),
	
	/**
	 * 0x02 3D accelerometer
	 */
	@MavlinkEnumEntry(value = 2,description = "0x02 3D accelerometer")
	MAV_SYS_STATUS_SENSOR_3D_ACCEL(),
	
	/**
	 * 0x04 3D magnetometer
	 */
	@MavlinkEnumEntry(value = 4,description = "0x04 3D magnetometer")
	MAV_SYS_STATUS_SENSOR_3D_MAG(),
	
	/**
	 * 0x08 absolute pressure
	 */
	@MavlinkEnumEntry(value = 8,description = "0x08 absolute pressure")
	MAV_SYS_STATUS_SENSOR_ABSOLUTE_PRESSURE(),
	
	/**
	 * 0x10 differential pressure
	 */
	@MavlinkEnumEntry(value = 16,description = "0x10 differential pressure")
	MAV_SYS_STATUS_SENSOR_DIFFERENTIAL_PRESSURE(),
	
	/**
	 * 0x20 GPS
	 */
	@MavlinkEnumEntry(value = 32,description = "0x20 GPS")
	MAV_SYS_STATUS_SENSOR_GPS(),
	
	/**
	 * 0x40 optical flow
	 */
	@MavlinkEnumEntry(value = 64,description = "0x40 optical flow")
	MAV_SYS_STATUS_SENSOR_OPTICAL_FLOW(),
	
	/**
	 * 0x80 computer vision position
	 */
	@MavlinkEnumEntry(value = 128,description = "0x80 computer vision position")
	MAV_SYS_STATUS_SENSOR_VISION_POSITION(),
	
	/**
	 * 0x100 laser based position
	 */
	@MavlinkEnumEntry(value = 256,description = "0x100 laser based position")
	MAV_SYS_STATUS_SENSOR_LASER_POSITION(),
	
	/**
	 * 0x200 external ground truth (Vicon or Leica)
	 */
	@MavlinkEnumEntry(value = 512,description = "0x200 external ground truth (Vicon or Leica)")
	MAV_SYS_STATUS_SENSOR_EXTERNAL_GROUND_TRUTH(),
	
	/**
	 * 0x400 3D angular rate control
	 */
	@MavlinkEnumEntry(value = 1024,description = "0x400 3D angular rate control")
	MAV_SYS_STATUS_SENSOR_ANGULAR_RATE_CONTROL(),
	
	/**
	 * 0x800 attitude stabilization
	 */
	@MavlinkEnumEntry(value = 2048,description = "0x800 attitude stabilization")
	MAV_SYS_STATUS_SENSOR_ATTITUDE_STABILIZATION(),
	
	/**
	 * 0x1000 yaw position
	 */
	@MavlinkEnumEntry(value = 4096,description = "0x1000 yaw position")
	MAV_SYS_STATUS_SENSOR_YAW_POSITION(),
	
	/**
	 * 0x2000 z/altitude control
	 */
	@MavlinkEnumEntry(value = 8192,description = "0x2000 z/altitude control")
	MAV_SYS_STATUS_SENSOR_Z_ALTITUDE_CONTROL(),
	
	/**
	 * 0x4000 x/y position control
	 */
	@MavlinkEnumEntry(value = 16384,description = "0x4000 x/y position control")
	MAV_SYS_STATUS_SENSOR_XY_POSITION_CONTROL(),
	
	/**
	 * 0x8000 motor outputs / control
	 */
	@MavlinkEnumEntry(value = 32768,description = "0x8000 motor outputs / control")
	MAV_SYS_STATUS_SENSOR_MOTOR_OUTPUTS(),
	
	/**
	 * 0x10000 rc receiver
	 */
	@MavlinkEnumEntry(value = 65536,description = "0x10000 rc receiver")
	MAV_SYS_STATUS_SENSOR_RC_RECEIVER(),
	
	/**
	 * 0x20000 2nd 3D gyro
	 */
	@MavlinkEnumEntry(value = 131072,description = "0x20000 2nd 3D gyro")
	MAV_SYS_STATUS_SENSOR_3D_GYRO2(),
	
	/**
	 * 0x40000 2nd 3D accelerometer
	 */
	@MavlinkEnumEntry(value = 262144,description = "0x40000 2nd 3D accelerometer")
	MAV_SYS_STATUS_SENSOR_3D_ACCEL2(),
	
	/**
	 * 0x80000 2nd 3D magnetometer
	 */
	@MavlinkEnumEntry(value = 524288,description = "0x80000 2nd 3D magnetometer")
	MAV_SYS_STATUS_SENSOR_3D_MAG2(),
	
	/**
	 * 0x100000 geofence
	 */
	@MavlinkEnumEntry(value = 1048576,description = "0x100000 geofence")
	MAV_SYS_STATUS_GEOFENCE(),
	
	/**
	 * 0x200000 AHRS subsystem health
	 */
	@MavlinkEnumEntry(value = 2097152,description = "0x200000 AHRS subsystem health")
	MAV_SYS_STATUS_AHRS(),
	
	/**
	 * 0x400000 Terrain subsystem health
	 */
	@MavlinkEnumEntry(value = 4194304,description = "0x400000 Terrain subsystem health")
	MAV_SYS_STATUS_TERRAIN(),
}
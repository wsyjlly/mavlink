package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "MAV_DATA_STREAM")
public enum  MavDataStream {
	
	/**
	 * Enable all data streams
	 */
	@MavlinkEnumEntry(value = 0,description = "Enable all data streams")
	MAV_DATA_STREAM_ALL(),
	
	/**
	 * Enable IMU_RAW, GPS_RAW, GPS_STATUS packets.
	 */
	@MavlinkEnumEntry(value = 1,description = "Enable IMU_RAW, GPS_RAW, GPS_STATUS packets.")
	MAV_DATA_STREAM_RAW_SENSORS(),
	
	/**
	 * Enable GPS_STATUS, CONTROL_STATUS, AUX_STATUS
	 */
	@MavlinkEnumEntry(value = 2,description = "Enable GPS_STATUS, CONTROL_STATUS, AUX_STATUS")
	MAV_DATA_STREAM_EXTENDED_STATUS(),
	
	/**
	 * Enable RC_CHANNELS_SCALED, RC_CHANNELS_RAW, SERVO_OUTPUT_RAW
	 */
	@MavlinkEnumEntry(value = 3,description = "Enable RC_CHANNELS_SCALED, RC_CHANNELS_RAW, SERVO_OUTPUT_RAW")
	MAV_DATA_STREAM_RC_CHANNELS(),
	
	/**
	 * Enable ATTITUDE_CONTROLLER_OUTPUT, POSITION_CONTROLLER_OUTPUT, NAV_CONTROLLER_OUTPUT.
	 */
	@MavlinkEnumEntry(value = 4,description = "Enable ATTITUDE_CONTROLLER_OUTPUT, POSITION_CONTROLLER_OUTPUT, NAV_CONTROLLER_OUTPUT.")
	MAV_DATA_STREAM_RAW_CONTROLLER(),
	
	/**
	 * Enable LOCAL_POSITION, GLOBAL_POSITION/GLOBAL_POSITION_INT messages.
	 */
	@MavlinkEnumEntry(value = 6,description = "Enable LOCAL_POSITION, GLOBAL_POSITION/GLOBAL_POSITION_INT messages.")
	MAV_DATA_STREAM_POSITION(),
	
	/**
	 * Dependent on the autopilot
	 */
	@MavlinkEnumEntry(value = 10,description = "Dependent on the autopilot")
	MAV_DATA_STREAM_EXTRA1(),
	
	/**
	 * Dependent on the autopilot
	 */
	@MavlinkEnumEntry(value = 11,description = "Dependent on the autopilot")
	MAV_DATA_STREAM_EXTRA2(),
	
	/**
	 * Dependent on the autopilot
	 */
	@MavlinkEnumEntry(value = 12,description = "Dependent on the autopilot")
	MAV_DATA_STREAM_EXTRA3(),
}
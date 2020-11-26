package cn.wsyjlly.mavlink.common.v1.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:45
 *
 **********************************/

@MavlinkEnum(name = "MAV_CMD")
public enum  MavCmd {
	
	/**
	 * Navigate to MISSION.
	 */
	@MavlinkEnumEntry(value = 16,description = "Navigate to MISSION.")
	MAV_CMD_NAV_WAYPOINT(),
	
	/**
	 * Loiter around this MISSION an unlimited amount of time
	 */
	@MavlinkEnumEntry(value = 17,description = "Loiter around this MISSION an unlimited amount of time")
	MAV_CMD_NAV_LOITER_UNLIM(),
	
	/**
	 * Loiter around this MISSION for X turns
	 */
	@MavlinkEnumEntry(value = 18,description = "Loiter around this MISSION for X turns")
	MAV_CMD_NAV_LOITER_TURNS(),
	
	/**
	 * Loiter around this MISSION for X seconds
	 */
	@MavlinkEnumEntry(value = 19,description = "Loiter around this MISSION for X seconds")
	MAV_CMD_NAV_LOITER_TIME(),
	
	/**
	 * Return to launch location
	 */
	@MavlinkEnumEntry(value = 20,description = "Return to launch location")
	MAV_CMD_NAV_RETURN_TO_LAUNCH(),
	
	/**
	 * Land at location
	 */
	@MavlinkEnumEntry(value = 21,description = "Land at location")
	MAV_CMD_NAV_LAND(),
	
	/**
	 * Takeoff from ground / hand
	 */
	@MavlinkEnumEntry(value = 22,description = "Takeoff from ground / hand")
	MAV_CMD_NAV_TAKEOFF(),
	
	/**
	 * Sets the region of interest (ROI) for a sensor set or the vehicle itself. This can then be used by the vehicles control system to control the vehicle attitude and the attitude of various sensors such as cameras.
	 */
	@MavlinkEnumEntry(value = 80,description = "Sets the region of interest (ROI) for a sensor set or the vehicle itself. This can then be used by the vehicles control system to control the vehicle attitude and the attitude of various sensors such as cameras.")
	MAV_CMD_NAV_ROI(),
	
	/**
	 * Control autonomous path planning on the MAV.
	 */
	@MavlinkEnumEntry(value = 81,description = "Control autonomous path planning on the MAV.")
	MAV_CMD_NAV_PATHPLANNING(),
	
	/**
	 * Navigate to MISSION using a spline path.
	 */
	@MavlinkEnumEntry(value = 82,description = "Navigate to MISSION using a spline path.")
	MAV_CMD_NAV_SPLINE_WAYPOINT(),
	
	/**
	 * hand control over to an external controller
	 */
	@MavlinkEnumEntry(value = 92,description = "hand control over to an external controller")
	MAV_CMD_NAV_GUIDED_ENABLE(),
	
	/**
	 * NOP - This command is only used to mark the upper limit of the NAV/ACTION commands in the enumeration
	 */
	@MavlinkEnumEntry(value = 95,description = "NOP - This command is only used to mark the upper limit of the NAV/ACTION commands in the enumeration")
	MAV_CMD_NAV_LAST(),
	
	/**
	 * Delay mission state machine.
	 */
	@MavlinkEnumEntry(value = 112,description = "Delay mission state machine.")
	MAV_CMD_CONDITION_DELAY(),
	
	/**
	 * Ascend/descend at rate. Delay mission state machine until desired altitude reached.
	 */
	@MavlinkEnumEntry(value = 113,description = "Ascend/descend at rate. Delay mission state machine until desired altitude reached.")
	MAV_CMD_CONDITION_CHANGE_ALT(),
	
	/**
	 * Delay mission state machine until within desired distance of next NAV point.
	 */
	@MavlinkEnumEntry(value = 114,description = "Delay mission state machine until within desired distance of next NAV point.")
	MAV_CMD_CONDITION_DISTANCE(),
	
	/**
	 * Reach a certain target angle.
	 */
	@MavlinkEnumEntry(value = 115,description = "Reach a certain target angle.")
	MAV_CMD_CONDITION_YAW(),
	
	/**
	 * NOP - This command is only used to mark the upper limit of the CONDITION commands in the enumeration
	 */
	@MavlinkEnumEntry(value = 159,description = "NOP - This command is only used to mark the upper limit of the CONDITION commands in the enumeration")
	MAV_CMD_CONDITION_LAST(),
	
	/**
	 * Set system mode.
	 */
	@MavlinkEnumEntry(value = 176,description = "Set system mode.")
	MAV_CMD_DO_SET_MODE(),
	
	/**
	 * Jump to the desired command in the mission list. Repeat this action only the specified number of times
	 */
	@MavlinkEnumEntry(value = 177,description = "Jump to the desired command in the mission list. Repeat this action only the specified number of times")
	MAV_CMD_DO_JUMP(),
	
	/**
	 * Change speed and/or throttle set points.
	 */
	@MavlinkEnumEntry(value = 178,description = "Change speed and/or throttle set points.")
	MAV_CMD_DO_CHANGE_SPEED(),
	
	/**
	 * Changes the home location either to the current location or a specified location.
	 */
	@MavlinkEnumEntry(value = 179,description = "Changes the home location either to the current location or a specified location.")
	MAV_CMD_DO_SET_HOME(),
	
	/**
	 * Set a system parameter. Caution! Use of this command requires knowledge of the numeric enumeration value of the parameter.
	 */
	@MavlinkEnumEntry(value = 180,description = "Set a system parameter. Caution! Use of this command requires knowledge of the numeric enumeration value of the parameter.")
	MAV_CMD_DO_SET_PARAMETER(),
	
	/**
	 * Set a relay to a condition.
	 */
	@MavlinkEnumEntry(value = 181,description = "Set a relay to a condition.")
	MAV_CMD_DO_SET_RELAY(),
	
	/**
	 * Cycle a relay on and off for a desired number of cyles with a desired period.
	 */
	@MavlinkEnumEntry(value = 182,description = "Cycle a relay on and off for a desired number of cyles with a desired period.")
	MAV_CMD_DO_REPEAT_RELAY(),
	
	/**
	 * Set a servo to a desired PWM value.
	 */
	@MavlinkEnumEntry(value = 183,description = "Set a servo to a desired PWM value.")
	MAV_CMD_DO_SET_SERVO(),
	
	/**
	 * Cycle a between its nominal setting and a desired PWM for a desired number of cycles with a desired period.
	 */
	@MavlinkEnumEntry(value = 184,description = "Cycle a between its nominal setting and a desired PWM for a desired number of cycles with a desired period.")
	MAV_CMD_DO_REPEAT_SERVO(),
	
	/**
	 * Terminate flight immediately
	 */
	@MavlinkEnumEntry(value = 185,description = "Terminate flight immediately")
	MAV_CMD_DO_FLIGHTTERMINATION(),
	
	/**
	 * Mission command to perform a landing. This is used as a marker in a mission to tell the autopilot where a sequence of mission items that represents a landing starts. It may also be sent via a COMMAND_LONG to trigger a landing, in which case the nearest (geographically) landing sequence in the mission will be used. The Latitude/Longitude is optional, and may be set to 0/0 if not needed. If specified then it will be used to help find the closest landing sequence.
	 */
	@MavlinkEnumEntry(value = 189,description = "Mission command to perform a landing. This is used as a marker in a mission to tell the autopilot where a sequence of mission items that represents a landing starts. It may also be sent via a COMMAND_LONG to trigger a landing, in which case the nearest (geographically) landing sequence in the mission will be used. The Latitude/Longitude is optional, and may be set to 0/0 if not needed. If specified then it will be used to help find the closest landing sequence.")
	MAV_CMD_DO_LAND_START(),
	
	/**
	 * Mission command to perform a landing from a rally point.
	 */
	@MavlinkEnumEntry(value = 190,description = "Mission command to perform a landing from a rally point.")
	MAV_CMD_DO_RALLY_LAND(),
	
	/**
	 * Mission command to safely abort an autonmous landing.
	 */
	@MavlinkEnumEntry(value = 191,description = "Mission command to safely abort an autonmous landing.")
	MAV_CMD_DO_GO_AROUND(),
	
	/**
	 * Control onboard camera system.
	 */
	@MavlinkEnumEntry(value = 200,description = "Control onboard camera system.")
	MAV_CMD_DO_CONTROL_VIDEO(),
	
	/**
	 * Sets the region of interest (ROI) for a sensor set or the vehicle itself. This can then be used by the vehicles control system to control the vehicle attitude and the attitude of various sensors such as cameras.
	 */
	@MavlinkEnumEntry(value = 201,description = "Sets the region of interest (ROI) for a sensor set or the vehicle itself. This can then be used by the vehicles control system to control the vehicle attitude and the attitude of various sensors such as cameras.")
	MAV_CMD_DO_SET_ROI(),
	
	/**
	 * Mission command to configure an on-board camera controller system.
	 */
	@MavlinkEnumEntry(value = 202,description = "Mission command to configure an on-board camera controller system.")
	MAV_CMD_DO_DIGICAM_CONFIGURE(),
	
	/**
	 * Mission command to control an on-board camera controller system.
	 */
	@MavlinkEnumEntry(value = 203,description = "Mission command to control an on-board camera controller system.")
	MAV_CMD_DO_DIGICAM_CONTROL(),
	
	/**
	 * Mission command to configure a camera or antenna mount
	 */
	@MavlinkEnumEntry(value = 204,description = "Mission command to configure a camera or antenna mount")
	MAV_CMD_DO_MOUNT_CONFIGURE(),
	
	/**
	 * Mission command to control a camera or antenna mount
	 */
	@MavlinkEnumEntry(value = 205,description = "Mission command to control a camera or antenna mount")
	MAV_CMD_DO_MOUNT_CONTROL(),
	
	/**
	 * Mission command to set CAM_TRIGG_DIST for this flight
	 */
	@MavlinkEnumEntry(value = 206,description = "Mission command to set CAM_TRIGG_DIST for this flight")
	MAV_CMD_DO_SET_CAM_TRIGG_DIST(),
	
	/**
	 * Mission command to enable the geofence
	 */
	@MavlinkEnumEntry(value = 207,description = "Mission command to enable the geofence")
	MAV_CMD_DO_FENCE_ENABLE(),
	
	/**
	 * Mission command to trigger a parachute
	 */
	@MavlinkEnumEntry(value = 208,description = "Mission command to trigger a parachute")
	MAV_CMD_DO_PARACHUTE(),
	
	/**
	 * Change to/from inverted flight
	 */
	@MavlinkEnumEntry(value = 210,description = "Change to/from inverted flight")
	MAV_CMD_DO_INVERTED_FLIGHT(),
	
	/**
	 * Mission command to control a camera or antenna mount, using a quaternion as reference.
	 */
	@MavlinkEnumEntry(value = 220,description = "Mission command to control a camera or antenna mount, using a quaternion as reference.")
	MAV_CMD_DO_MOUNT_CONTROL_QUAT(),
	
	/**
	 * set id of master controller
	 */
	@MavlinkEnumEntry(value = 221,description = "set id of master controller")
	MAV_CMD_DO_GUIDED_MASTER(),
	
	/**
	 * set limits for external control
	 */
	@MavlinkEnumEntry(value = 222,description = "set limits for external control")
	MAV_CMD_DO_GUIDED_LIMITS(),
	
	/**
	 * NOP - This command is only used to mark the upper limit of the DO commands in the enumeration
	 */
	@MavlinkEnumEntry(value = 240,description = "NOP - This command is only used to mark the upper limit of the DO commands in the enumeration")
	MAV_CMD_DO_LAST(),
	
	/**
	 * Trigger calibration. This command will be only accepted if in pre-flight mode.
	 */
	@MavlinkEnumEntry(value = 241,description = "Trigger calibration. This command will be only accepted if in pre-flight mode.")
	MAV_CMD_PREFLIGHT_CALIBRATION(),
	
	/**
	 * Set sensor offsets. This command will be only accepted if in pre-flight mode.
	 */
	@MavlinkEnumEntry(value = 242,description = "Set sensor offsets. This command will be only accepted if in pre-flight mode.")
	MAV_CMD_PREFLIGHT_SET_SENSOR_OFFSETS(),
	
	/**
	 * Request storage of different parameter values and logs. This command will be only accepted if in pre-flight mode.
	 */
	@MavlinkEnumEntry(value = 245,description = "Request storage of different parameter values and logs. This command will be only accepted if in pre-flight mode.")
	MAV_CMD_PREFLIGHT_STORAGE(),
	
	/**
	 * Request the reboot or shutdown of system components.
	 */
	@MavlinkEnumEntry(value = 246,description = "Request the reboot or shutdown of system components.")
	MAV_CMD_PREFLIGHT_REBOOT_SHUTDOWN(),
	
	/**
	 * Hold / continue the current action
	 */
	@MavlinkEnumEntry(value = 252,description = "Hold / continue the current action")
	MAV_CMD_OVERRIDE_GOTO(),
	
	/**
	 * start running a mission
	 */
	@MavlinkEnumEntry(value = 300,description = "start running a mission")
	MAV_CMD_MISSION_START(),
	
	/**
	 * Arms / Disarms a component
	 */
	@MavlinkEnumEntry(value = 400,description = "Arms / Disarms a component")
	MAV_CMD_COMPONENT_ARM_DISARM(),
	
	/**
	 * Starts receiver pairing
	 */
	@MavlinkEnumEntry(value = 500,description = "Starts receiver pairing")
	MAV_CMD_START_RX_PAIR(),
	
	/**
	 * Start image capture sequence
	 */
	@MavlinkEnumEntry(value = 2000,description = "Start image capture sequence")
	MAV_CMD_IMAGE_START_CAPTURE(),
	
	/**
	 * Stop image capture sequence
	 */
	@MavlinkEnumEntry(value = 2001,description = "Stop image capture sequence")
	MAV_CMD_IMAGE_STOP_CAPTURE(),
	
	/**
	 * Starts video capture
	 */
	@MavlinkEnumEntry(value = 2500,description = "Starts video capture")
	MAV_CMD_VIDEO_START_CAPTURE(),
	
	/**
	 * Stop the current video capture
	 */
	@MavlinkEnumEntry(value = 2501,description = "Stop the current video capture")
	MAV_CMD_VIDEO_STOP_CAPTURE(),
	
	/**
	 * Create a panorama at the current position
	 */
	@MavlinkEnumEntry(value = 2800,description = "Create a panorama at the current position")
	MAV_CMD_PANORAMA_CREATE(),
	
	/**
	 * Deploy payload on a Lat / Lon / Alt position. This includes the navigation to reach the required release position and velocity.
	 */
	@MavlinkEnumEntry(value = 30001,description = "Deploy payload on a Lat / Lon / Alt position. This includes the navigation to reach the required release position and velocity.")
	MAV_CMD_PAYLOAD_PREPARE_DEPLOY(),
	
	/**
	 * Control the payload deployment.
	 */
	@MavlinkEnumEntry(value = 30002,description = "Control the payload deployment.")
	MAV_CMD_PAYLOAD_CONTROL_DEPLOY(),
}
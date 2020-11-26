package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "MAV_CMD")
public enum  MavCmd {
	
	/**
	 * Navigate to waypoint.
	 */
	@MavlinkEnumEntry(value = 16,description = "Navigate to waypoint.")
	MAV_CMD_NAV_WAYPOINT(),
	
	/**
	 * Loiter around this waypoint an unlimited amount of time
	 */
	@MavlinkEnumEntry(value = 17,description = "Loiter around this waypoint an unlimited amount of time")
	MAV_CMD_NAV_LOITER_UNLIM(),
	
	/**
	 * Loiter around this waypoint for X turns
	 */
	@MavlinkEnumEntry(value = 18,description = "Loiter around this waypoint for X turns")
	MAV_CMD_NAV_LOITER_TURNS(),
	
	/**
	 * Loiter at the specified latitude, longitude and altitude for a certain amount of time. Multicopter vehicles stop at the point (within a vehicle-specific acceptance radius). Forward-only moving vehicles (e.g. fixed-wing) circle the point with the specified radius/direction. If the Heading Required parameter (2) is non-zero forward moving aircraft will only leave the loiter circle once heading towards the next waypoint.
	 */
	@MavlinkEnumEntry(value = 19,description = "Loiter at the specified latitude, longitude and altitude for a certain amount of time. Multicopter vehicles stop at the point (within a vehicle-specific acceptance radius). Forward-only moving vehicles (e.g. fixed-wing) circle the point with the specified radius/direction. If the Heading Required parameter (2) is non-zero forward moving aircraft will only leave the loiter circle once heading towards the next waypoint.")
	MAV_CMD_NAV_LOITER_TIME(),
	
	/**
	 * Return to launch location
	 */
	@MavlinkEnumEntry(value = 20,description = "Return to launch location")
	MAV_CMD_NAV_RETURN_TO_LAUNCH(),
	
	/**
	 * Land at location.
	 */
	@MavlinkEnumEntry(value = 21,description = "Land at location.")
	MAV_CMD_NAV_LAND(),
	
	/**
	 * Takeoff from ground / hand. Vehicles that support multiple takeoff modes (e.g. VTOL quadplane) should take off using the currently configured mode.
	 */
	@MavlinkEnumEntry(value = 22,description = "Takeoff from ground / hand. Vehicles that support multiple takeoff modes (e.g. VTOL quadplane) should take off using the currently configured mode.")
	MAV_CMD_NAV_TAKEOFF(),
	
	/**
	 * Land at local position (local frame only)
	 */
	@MavlinkEnumEntry(value = 23,description = "Land at local position (local frame only)")
	MAV_CMD_NAV_LAND_LOCAL(),
	
	/**
	 * Takeoff from local position (local frame only)
	 */
	@MavlinkEnumEntry(value = 24,description = "Takeoff from local position (local frame only)")
	MAV_CMD_NAV_TAKEOFF_LOCAL(),
	
	/**
	 * Vehicle following, i.e. this waypoint represents the position of a moving vehicle
	 */
	@MavlinkEnumEntry(value = 25,description = "Vehicle following, i.e. this waypoint represents the position of a moving vehicle")
	MAV_CMD_NAV_FOLLOW(),
	
	/**
	 * Continue on the current course and climb/descend to specified altitude. When the altitude is reached continue to the next command (i.e., don't proceed to the next command until the desired altitude is reached.
	 */
	@MavlinkEnumEntry(value = 30,description = "Continue on the current course and climb/descend to specified altitude. When the altitude is reached continue to the next command (i.e., don't proceed to the next command until the desired altitude is reached.")
	MAV_CMD_NAV_CONTINUE_AND_CHANGE_ALT(),
	
	/**
	 * Begin loiter at the specified Latitude and Longitude. If Lat=Lon=0, then loiter at the current position. Don't consider the navigation command complete (don't leave loiter) until the altitude has been reached. Additionally, if the Heading Required parameter is non-zero the aircraft will not leave the loiter until heading toward the next waypoint.
	 */
	@MavlinkEnumEntry(value = 31,description = "Begin loiter at the specified Latitude and Longitude. If Lat=Lon=0, then loiter at the current position. Don't consider the navigation command complete (don't leave loiter) until the altitude has been reached. Additionally, if the Heading Required parameter is non-zero the aircraft will not leave the loiter until heading toward the next waypoint.")
	MAV_CMD_NAV_LOITER_TO_ALT(),
	
	/**
	 * Begin following a target
	 */
	@MavlinkEnumEntry(value = 32,description = "Begin following a target")
	MAV_CMD_DO_FOLLOW(),
	
	/**
	 * Reposition the MAV after a follow target command has been sent
	 */
	@MavlinkEnumEntry(value = 33,description = "Reposition the MAV after a follow target command has been sent")
	MAV_CMD_DO_FOLLOW_REPOSITION(),
	
	/**
	 * Start orbiting on the circumference of a circle defined by the parameters. Setting any value NaN results in using defaults.
	 */
	@MavlinkEnumEntry(value = 34,description = "Start orbiting on the circumference of a circle defined by the parameters. Setting any value NaN results in using defaults.")
	MAV_CMD_DO_ORBIT(),
	
	/**
	 * Sets the region of interest (ROI) for a sensor set or the vehicle itself. This can then be used by the vehicle's control system to control the vehicle attitude and the attitude of various sensors such as cameras.
	 */
	@MavlinkEnumEntry(value = 80,description = "Sets the region of interest (ROI) for a sensor set or the vehicle itself. This can then be used by the vehicle's control system to control the vehicle attitude and the attitude of various sensors such as cameras.")
	MAV_CMD_NAV_ROI(),
	
	/**
	 * Control autonomous path planning on the MAV.
	 */
	@MavlinkEnumEntry(value = 81,description = "Control autonomous path planning on the MAV.")
	MAV_CMD_NAV_PATHPLANNING(),
	
	/**
	 * Navigate to waypoint using a spline path.
	 */
	@MavlinkEnumEntry(value = 82,description = "Navigate to waypoint using a spline path.")
	MAV_CMD_NAV_SPLINE_WAYPOINT(),
	
	/**
	 * Takeoff from ground using VTOL mode, and transition to forward flight with specified heading. The command should be ignored by vehicles that dont support both VTOL and fixed-wing flight (multicopters, boats,etc.).
	 */
	@MavlinkEnumEntry(value = 84,description = "Takeoff from ground using VTOL mode, and transition to forward flight with specified heading. The command should be ignored by vehicles that dont support both VTOL and fixed-wing flight (multicopters, boats,etc.).")
	MAV_CMD_NAV_VTOL_TAKEOFF(),
	
	/**
	 * Land using VTOL mode
	 */
	@MavlinkEnumEntry(value = 85,description = "Land using VTOL mode")
	MAV_CMD_NAV_VTOL_LAND(),
	
	/**
	 * hand control over to an external controller
	 */
	@MavlinkEnumEntry(value = 92,description = "hand control over to an external controller")
	MAV_CMD_NAV_GUIDED_ENABLE(),
	
	/**
	 * Delay the next navigation command a number of seconds or until a specified time
	 */
	@MavlinkEnumEntry(value = 93,description = "Delay the next navigation command a number of seconds or until a specified time")
	MAV_CMD_NAV_DELAY(),
	
	/**
	 * Descend and place payload. Vehicle moves to specified location, descends until it detects a hanging payload has reached the ground, and then releases the payload. If ground is not detected before the reaching the maximum descent value (param1), the command will complete without releasing the payload.
	 */
	@MavlinkEnumEntry(value = 94,description = "Descend and place payload. Vehicle moves to specified location, descends until it detects a hanging payload has reached the ground, and then releases the payload. If ground is not detected before the reaching the maximum descent value (param1), the command will complete without releasing the payload.")
	MAV_CMD_NAV_PAYLOAD_PLACE(),
	
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
	 * Ascend/descend to target altitude at specified rate. Delay mission state machine until desired altitude reached.
	 */
	@MavlinkEnumEntry(value = 113,description = "Ascend/descend to target altitude at specified rate. Delay mission state machine until desired altitude reached.")
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
	 * Cycle a relay on and off for a desired number of cycles with a desired period.
	 */
	@MavlinkEnumEntry(value = 182,description = "Cycle a relay on and off for a desired number of cycles with a desired period.")
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
	 * Change altitude set point.
	 */
	@MavlinkEnumEntry(value = 186,description = "Change altitude set point.")
	MAV_CMD_DO_CHANGE_ALTITUDE(),
	
	/**
	 * Sets actuators (e.g. servos) to a desired value. The actuator numbers are mapped to specific outputs (e.g. on any MAIN or AUX PWM or UAVCAN) using a flight-stack specific mechanism (i.e. a parameter).
	 */
	@MavlinkEnumEntry(value = 187,description = "Sets actuators (e.g. servos) to a desired value. The actuator numbers are mapped to specific outputs (e.g. on any MAIN or AUX PWM or UAVCAN) using a flight-stack specific mechanism (i.e. a parameter).")
	MAV_CMD_DO_SET_ACTUATOR(),
	
	/**
	 * Mission command to perform a landing. This is used as a marker in a mission to tell the autopilot where a sequence of mission items that represents a landing starts. It may also be sent via a COMMAND_LONG to trigger a landing, in which case the nearest (geographically) landing sequence in the mission will be used. The Latitude/Longitude is optional, and may be set to 0 if not needed. If specified then it will be used to help find the closest landing sequence.
	 */
	@MavlinkEnumEntry(value = 189,description = "Mission command to perform a landing. This is used as a marker in a mission to tell the autopilot where a sequence of mission items that represents a landing starts. It may also be sent via a COMMAND_LONG to trigger a landing, in which case the nearest (geographically) landing sequence in the mission will be used. The Latitude/Longitude is optional, and may be set to 0 if not needed. If specified then it will be used to help find the closest landing sequence.")
	MAV_CMD_DO_LAND_START(),
	
	/**
	 * Mission command to perform a landing from a rally point.
	 */
	@MavlinkEnumEntry(value = 190,description = "Mission command to perform a landing from a rally point.")
	MAV_CMD_DO_RALLY_LAND(),
	
	/**
	 * Mission command to safely abort an autonomous landing.
	 */
	@MavlinkEnumEntry(value = 191,description = "Mission command to safely abort an autonomous landing.")
	MAV_CMD_DO_GO_AROUND(),
	
	/**
	 * Reposition the vehicle to a specific WGS84 global position.
	 */
	@MavlinkEnumEntry(value = 192,description = "Reposition the vehicle to a specific WGS84 global position.")
	MAV_CMD_DO_REPOSITION(),
	
	/**
	 * If in a GPS controlled position mode, hold the current position or continue.
	 */
	@MavlinkEnumEntry(value = 193,description = "If in a GPS controlled position mode, hold the current position or continue.")
	MAV_CMD_DO_PAUSE_CONTINUE(),
	
	/**
	 * Set moving direction to forward or reverse.
	 */
	@MavlinkEnumEntry(value = 194,description = "Set moving direction to forward or reverse.")
	MAV_CMD_DO_SET_REVERSE(),
	
	/**
	 * Sets the region of interest (ROI) to a location. This can then be used by the vehicle's control system to control the vehicle attitude and the attitude of various sensors such as cameras. This command can be sent to a gimbal manager but not to a gimbal device. A gimbal is not to react to this message.
	 */
	@MavlinkEnumEntry(value = 195,description = "Sets the region of interest (ROI) to a location. This can then be used by the vehicle's control system to control the vehicle attitude and the attitude of various sensors such as cameras. This command can be sent to a gimbal manager but not to a gimbal device. A gimbal is not to react to this message.")
	MAV_CMD_DO_SET_ROI_LOCATION(),
	
	/**
	 * Sets the region of interest (ROI) to be toward next waypoint, with optional pitch/roll/yaw offset. This can then be used by the vehicle's control system to control the vehicle attitude and the attitude of various sensors such as cameras. This command can be sent to a gimbal manager but not to a gimbal device. A gimbal device is not to react to this message.
	 */
	@MavlinkEnumEntry(value = 196,description = "Sets the region of interest (ROI) to be toward next waypoint, with optional pitch/roll/yaw offset. This can then be used by the vehicle's control system to control the vehicle attitude and the attitude of various sensors such as cameras. This command can be sent to a gimbal manager but not to a gimbal device. A gimbal device is not to react to this message.")
	MAV_CMD_DO_SET_ROI_WPNEXT_OFFSET(),
	
	/**
	 * Cancels any previous ROI command returning the vehicle/sensors to default flight characteristics. This can then be used by the vehicle's control system to control the vehicle attitude and the attitude of various sensors such as cameras. This command can be sent to a gimbal manager but not to a gimbal device. A gimbal device is not to react to this message. After this command the gimbal manager should go back to manual input if available, and otherwise assume a neutral position.
	 */
	@MavlinkEnumEntry(value = 197,description = "Cancels any previous ROI command returning the vehicle/sensors to default flight characteristics. This can then be used by the vehicle's control system to control the vehicle attitude and the attitude of various sensors such as cameras. This command can be sent to a gimbal manager but not to a gimbal device. A gimbal device is not to react to this message. After this command the gimbal manager should go back to manual input if available, and otherwise assume a neutral position.")
	MAV_CMD_DO_SET_ROI_NONE(),
	
	/**
	 * Mount tracks system with specified system ID. Determination of target vehicle position may be done with GLOBAL_POSITION_INT or any other means. This command can be sent to a gimbal manager but not to a gimbal device. A gimbal device is not to react to this message.
	 */
	@MavlinkEnumEntry(value = 198,description = "Mount tracks system with specified system ID. Determination of target vehicle position may be done with GLOBAL_POSITION_INT or any other means. This command can be sent to a gimbal manager but not to a gimbal device. A gimbal device is not to react to this message.")
	MAV_CMD_DO_SET_ROI_SYSID(),
	
	/**
	 * Control onboard camera system.
	 */
	@MavlinkEnumEntry(value = 200,description = "Control onboard camera system.")
	MAV_CMD_DO_CONTROL_VIDEO(),
	
	/**
	 * Sets the region of interest (ROI) for a sensor set or the vehicle itself. This can then be used by the vehicle's control system to control the vehicle attitude and the attitude of various sensors such as cameras.
	 */
	@MavlinkEnumEntry(value = 201,description = "Sets the region of interest (ROI) for a sensor set or the vehicle itself. This can then be used by the vehicle's control system to control the vehicle attitude and the attitude of various sensors such as cameras.")
	MAV_CMD_DO_SET_ROI(),
	
	/**
	 * Configure digital camera. This is a fallback message for systems that have not yet implemented PARAM_EXT_XXX messages and camera definition files (see https://mavlink.io/en/services/camera_def.html ).
	 */
	@MavlinkEnumEntry(value = 202,description = "Configure digital camera. This is a fallback message for systems that have not yet implemented PARAM_EXT_XXX messages and camera definition files (see https://mavlink.io/en/services/camera_def.html ).")
	MAV_CMD_DO_DIGICAM_CONFIGURE(),
	
	/**
	 * Control digital camera. This is a fallback message for systems that have not yet implemented PARAM_EXT_XXX messages and camera definition files (see https://mavlink.io/en/services/camera_def.html ).
	 */
	@MavlinkEnumEntry(value = 203,description = "Control digital camera. This is a fallback message for systems that have not yet implemented PARAM_EXT_XXX messages and camera definition files (see https://mavlink.io/en/services/camera_def.html ).")
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
	 * Mission command to set camera trigger distance for this flight. The camera is triggered each time this distance is exceeded. This command can also be used to set the shutter integration time for the camera.
	 */
	@MavlinkEnumEntry(value = 206,description = "Mission command to set camera trigger distance for this flight. The camera is triggered each time this distance is exceeded. This command can also be used to set the shutter integration time for the camera.")
	MAV_CMD_DO_SET_CAM_TRIGG_DIST(),
	
	/**
	 * Mission command to enable the geofence
	 */
	@MavlinkEnumEntry(value = 207,description = "Mission command to enable the geofence")
	MAV_CMD_DO_FENCE_ENABLE(),
	
	/**
	 * Mission item/command to release a parachute or enable/disable auto release.
	 */
	@MavlinkEnumEntry(value = 208,description = "Mission item/command to release a parachute or enable/disable auto release.")
	MAV_CMD_DO_PARACHUTE(),
	
	/**
	 * Mission command to perform motor test.
	 */
	@MavlinkEnumEntry(value = 209,description = "Mission command to perform motor test.")
	MAV_CMD_DO_MOTOR_TEST(),
	
	/**
	 * Change to/from inverted flight.
	 */
	@MavlinkEnumEntry(value = 210,description = "Change to/from inverted flight.")
	MAV_CMD_DO_INVERTED_FLIGHT(),
	
	/**
	 * Mission command to operate a gripper.
	 */
	@MavlinkEnumEntry(value = 211,description = "Mission command to operate a gripper.")
	MAV_CMD_DO_GRIPPER(),
	
	/**
	 * Sets a desired vehicle turn angle and speed change.
	 */
	@MavlinkEnumEntry(value = 213,description = "Sets a desired vehicle turn angle and speed change.")
	MAV_CMD_NAV_SET_YAW_SPEED(),
	
	/**
	 * Mission command to set camera trigger interval for this flight. If triggering is enabled, the camera is triggered each time this interval expires. This command can also be used to set the shutter integration time for the camera.
	 */
	@MavlinkEnumEntry(value = 214,description = "Mission command to set camera trigger interval for this flight. If triggering is enabled, the camera is triggered each time this interval expires. This command can also be used to set the shutter integration time for the camera.")
	MAV_CMD_DO_SET_CAM_TRIGG_INTERVAL(),
	
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
	 * Set limits for external control
	 */
	@MavlinkEnumEntry(value = 222,description = "Set limits for external control")
	MAV_CMD_DO_GUIDED_LIMITS(),
	
	/**
	 * Control vehicle engine. This is interpreted by the vehicles engine controller to change the target engine state. It is intended for vehicles with internal combustion engines
	 */
	@MavlinkEnumEntry(value = 223,description = "Control vehicle engine. This is interpreted by the vehicles engine controller to change the target engine state. It is intended for vehicles with internal combustion engines")
	MAV_CMD_DO_ENGINE_CONTROL(),
	
	/**
	 * Set the mission item with sequence number seq as current item. This means that the MAV will continue to this mission item on the shortest path (not following the mission items in-between).
	 */
	@MavlinkEnumEntry(value = 224,description = "Set the mission item with sequence number seq as current item. This means that the MAV will continue to this mission item on the shortest path (not following the mission items in-between).")
	MAV_CMD_DO_SET_MISSION_CURRENT(),
	
	/**
	 * NOP - This command is only used to mark the upper limit of the DO commands in the enumeration
	 */
	@MavlinkEnumEntry(value = 240,description = "NOP - This command is only used to mark the upper limit of the DO commands in the enumeration")
	MAV_CMD_DO_LAST(),
	
	/**
	 * Trigger calibration. This command will be only accepted if in pre-flight mode. Except for Temperature Calibration, only one sensor should be set in a single message and all others should be zero.
	 */
	@MavlinkEnumEntry(value = 241,description = "Trigger calibration. This command will be only accepted if in pre-flight mode. Except for Temperature Calibration, only one sensor should be set in a single message and all others should be zero.")
	MAV_CMD_PREFLIGHT_CALIBRATION(),
	
	/**
	 * Set sensor offsets. This command will be only accepted if in pre-flight mode.
	 */
	@MavlinkEnumEntry(value = 242,description = "Set sensor offsets. This command will be only accepted if in pre-flight mode.")
	MAV_CMD_PREFLIGHT_SET_SENSOR_OFFSETS(),
	
	/**
	 * Trigger UAVCAN configuration (actuator ID assignment and direction mapping). Note that this maps to the legacy UAVCAN v0 function UAVCAN_ENUMERATE, which is intended to be executed just once during initial vehicle configuration (it is not a normal pre-flight command and has been poorly named).
	 */
	@MavlinkEnumEntry(value = 243,description = "Trigger UAVCAN configuration (actuator ID assignment and direction mapping). Note that this maps to the legacy UAVCAN v0 function UAVCAN_ENUMERATE, which is intended to be executed just once during initial vehicle configuration (it is not a normal pre-flight command and has been poorly named).")
	MAV_CMD_PREFLIGHT_UAVCAN(),
	
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
	 * Request a target system to start an upgrade of one (or all) of its components. For example, the command might be sent to a companion computer to cause it to upgrade a connected flight controller. The system doing the upgrade will report progress using the normal command protocol sequence for a long running operation. Command protocol information: https://mavlink.io/en/services/command.html.
	 */
	@MavlinkEnumEntry(value = 247,description = "Request a target system to start an upgrade of one (or all) of its components. For example, the command might be sent to a companion computer to cause it to upgrade a connected flight controller. The system doing the upgrade will report progress using the normal command protocol sequence for a long running operation. Command protocol information: https://mavlink.io/en/services/command.html.")
	MAV_CMD_DO_UPGRADE(),
	
	/**
	 * Override current mission with command to pause mission, pause mission and move to position, continue/resume mission. When param 1 indicates that the mission is paused (MAV_GOTO_DO_HOLD), param 2 defines whether it holds in place or moves to another position.
	 */
	@MavlinkEnumEntry(value = 252,description = "Override current mission with command to pause mission, pause mission and move to position, continue/resume mission. When param 1 indicates that the mission is paused (MAV_GOTO_DO_HOLD), param 2 defines whether it holds in place or moves to another position.")
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
	 * Turns illuminators ON/OFF. An illuminator is a light source that is used for lighting up dark areas external to the sytstem: e.g. a torch or searchlight (as opposed to a light source for illuminating the system itself, e.g. an indicator light).
	 */
	@MavlinkEnumEntry(value = 405,description = "Turns illuminators ON/OFF. An illuminator is a light source that is used for lighting up dark areas external to the sytstem: e.g. a torch or searchlight (as opposed to a light source for illuminating the system itself, e.g. an indicator light).")
	MAV_CMD_ILLUMINATOR_ON_OFF(),
	
	/**
	 * Request the home position from the vehicle.
	 */
	@MavlinkEnumEntry(value = 410,description = "Request the home position from the vehicle.")
	MAV_CMD_GET_HOME_POSITION(),
	
	/**
	 * Inject artificial failure for testing purposes. Note that autopilots should implement an additional protection before accepting this command such as a specific param setting.
	 */
	@MavlinkEnumEntry(value = 420,description = "Inject artificial failure for testing purposes. Note that autopilots should implement an additional protection before accepting this command such as a specific param setting.")
	MAV_CMD_INJECT_FAILURE(),
	
	/**
	 * Starts receiver pairing.
	 */
	@MavlinkEnumEntry(value = 500,description = "Starts receiver pairing.")
	MAV_CMD_START_RX_PAIR(),
	
	/**
	 * Request the interval between messages for a particular MAVLink message ID. The receiver should ACK the command and then emit its response in a MESSAGE_INTERVAL message.
	 */
	@MavlinkEnumEntry(value = 510,description = "Request the interval between messages for a particular MAVLink message ID. The receiver should ACK the command and then emit its response in a MESSAGE_INTERVAL message.")
	MAV_CMD_GET_MESSAGE_INTERVAL(),
	
	/**
	 * Set the interval between messages for a particular MAVLink message ID. This interface replaces REQUEST_DATA_STREAM.
	 */
	@MavlinkEnumEntry(value = 511,description = "Set the interval between messages for a particular MAVLink message ID. This interface replaces REQUEST_DATA_STREAM.")
	MAV_CMD_SET_MESSAGE_INTERVAL(),
	
	/**
	 * Request MAVLink protocol version compatibility. All receivers should ACK the command and then emit their capabilities in an PROTOCOL_VERSION message
	 */
	@MavlinkEnumEntry(value = 519,description = "Request MAVLink protocol version compatibility. All receivers should ACK the command and then emit their capabilities in an PROTOCOL_VERSION message")
	MAV_CMD_REQUEST_PROTOCOL_VERSION(),
	
	/**
	 * Request autopilot capabilities. The receiver should ACK the command and then emit its capabilities in an AUTOPILOT_VERSION message
	 */
	@MavlinkEnumEntry(value = 520,description = "Request autopilot capabilities. The receiver should ACK the command and then emit its capabilities in an AUTOPILOT_VERSION message")
	MAV_CMD_REQUEST_AUTOPILOT_CAPABILITIES(),
	
	/**
	 * Request camera information (CAMERA_INFORMATION).
	 */
	@MavlinkEnumEntry(value = 521,description = "Request camera information (CAMERA_INFORMATION).")
	MAV_CMD_REQUEST_CAMERA_INFORMATION(),
	
	/**
	 * Request camera settings (CAMERA_SETTINGS).
	 */
	@MavlinkEnumEntry(value = 522,description = "Request camera settings (CAMERA_SETTINGS).")
	MAV_CMD_REQUEST_CAMERA_SETTINGS(),
	
	/**
	 * Request storage information (STORAGE_INFORMATION). Use the command's target_component to target a specific component's storage.
	 */
	@MavlinkEnumEntry(value = 525,description = "Request storage information (STORAGE_INFORMATION). Use the command's target_component to target a specific component's storage.")
	MAV_CMD_REQUEST_STORAGE_INFORMATION(),
	
	/**
	 * Format a storage medium. Once format is complete, a STORAGE_INFORMATION message is sent. Use the command's target_component to target a specific component's storage.
	 */
	@MavlinkEnumEntry(value = 526,description = "Format a storage medium. Once format is complete, a STORAGE_INFORMATION message is sent. Use the command's target_component to target a specific component's storage.")
	MAV_CMD_STORAGE_FORMAT(),
	
	/**
	 * Request camera capture status (CAMERA_CAPTURE_STATUS)
	 */
	@MavlinkEnumEntry(value = 527,description = "Request camera capture status (CAMERA_CAPTURE_STATUS)")
	MAV_CMD_REQUEST_CAMERA_CAPTURE_STATUS(),
	
	/**
	 * Request flight information (FLIGHT_INFORMATION)
	 */
	@MavlinkEnumEntry(value = 528,description = "Request flight information (FLIGHT_INFORMATION)")
	MAV_CMD_REQUEST_FLIGHT_INFORMATION(),
	
	/**
	 * Reset all camera settings to Factory Default
	 */
	@MavlinkEnumEntry(value = 529,description = "Reset all camera settings to Factory Default")
	MAV_CMD_RESET_CAMERA_SETTINGS(),
	
	/**
	 * Set camera running mode. Use NaN for reserved values. GCS will send a MAV_CMD_REQUEST_VIDEO_STREAM_STATUS command after a mode change if the camera supports video streaming.
	 */
	@MavlinkEnumEntry(value = 530,description = "Set camera running mode. Use NaN for reserved values. GCS will send a MAV_CMD_REQUEST_VIDEO_STREAM_STATUS command after a mode change if the camera supports video streaming.")
	MAV_CMD_SET_CAMERA_MODE(),
	
	/**
	 * Set camera zoom. Camera must respond with a CAMERA_SETTINGS message (on success).
	 */
	@MavlinkEnumEntry(value = 531,description = "Set camera zoom. Camera must respond with a CAMERA_SETTINGS message (on success).")
	MAV_CMD_SET_CAMERA_ZOOM(),
	
	/**
	 * Set camera focus. Camera must respond with a CAMERA_SETTINGS message (on success).
	 */
	@MavlinkEnumEntry(value = 532,description = "Set camera focus. Camera must respond with a CAMERA_SETTINGS message (on success).")
	MAV_CMD_SET_CAMERA_FOCUS(),
	
	/**
	 * Tagged jump target. Can be jumped to with MAV_CMD_DO_JUMP_TAG.
	 */
	@MavlinkEnumEntry(value = 600,description = "Tagged jump target. Can be jumped to with MAV_CMD_DO_JUMP_TAG.")
	MAV_CMD_JUMP_TAG(),
	
	/**
	 * Jump to the matching tag in the mission list. Repeat this action for the specified number of times. A mission should contain a single matching tag for each jump. If this is not the case then a jump to a missing tag should complete the mission, and a jump where there are multiple matching tags should always select the one with the lowest mission sequence number.
	 */
	@MavlinkEnumEntry(value = 601,description = "Jump to the matching tag in the mission list. Repeat this action for the specified number of times. A mission should contain a single matching tag for each jump. If this is not the case then a jump to a missing tag should complete the mission, and a jump where there are multiple matching tags should always select the one with the lowest mission sequence number.")
	MAV_CMD_DO_JUMP_TAG(),
	
	/**
	 * Request to start or end a parameter transaction. Multiple kinds of transport layers can be used to exchange parameters in the transaction (param, param_ext and mavftp). The command response can either be a success/failure or an in progress in case the receiving side takes some time to apply the parameters.
	 */
	@MavlinkEnumEntry(value = 900,description = "Request to start or end a parameter transaction. Multiple kinds of transport layers can be used to exchange parameters in the transaction (param, param_ext and mavftp). The command response can either be a success/failure or an in progress in case the receiving side takes some time to apply the parameters.")
	MAV_CMD_PARAM_TRANSACTION(),
	
	/**
	 * High level setpoint to be sent to a gimbal manager to set a gimbal attitude. It is possible to set combinations of the values below. E.g. an angle as well as a desired angular rate can be used to get to this angle at a certain angular rate, or an angular rate only will result in continuous turning. NaN is to be used to signal unset. Note: a gimbal is never to react to this command but only the gimbal manager.
	 */
	@MavlinkEnumEntry(value = 1000,description = "High level setpoint to be sent to a gimbal manager to set a gimbal attitude. It is possible to set combinations of the values below. E.g. an angle as well as a desired angular rate can be used to get to this angle at a certain angular rate, or an angular rate only will result in continuous turning. NaN is to be used to signal unset. Note: a gimbal is never to react to this command but only the gimbal manager.")
	MAV_CMD_DO_GIMBAL_MANAGER_PITCHYAW(),
	
	/**
	 * Gimbal configuration to set which sysid/compid is in primary and secondary control.
	 */
	@MavlinkEnumEntry(value = 1001,description = "Gimbal configuration to set which sysid/compid is in primary and secondary control.")
	MAV_CMD_DO_GIMBAL_MANAGER_CONFIGURE(),
	
	/**
	 * Start image capture sequence. Sends CAMERA_IMAGE_CAPTURED after each capture. Use NaN for reserved values.
	 */
	@MavlinkEnumEntry(value = 2000,description = "Start image capture sequence. Sends CAMERA_IMAGE_CAPTURED after each capture. Use NaN for reserved values.")
	MAV_CMD_IMAGE_START_CAPTURE(),
	
	/**
	 * Stop image capture sequence Use NaN for reserved values.
	 */
	@MavlinkEnumEntry(value = 2001,description = "Stop image capture sequence Use NaN for reserved values.")
	MAV_CMD_IMAGE_STOP_CAPTURE(),
	
	/**
	 * Re-request a CAMERA_IMAGE_CAPTURED message.
	 */
	@MavlinkEnumEntry(value = 2002,description = "Re-request a CAMERA_IMAGE_CAPTURED message.")
	MAV_CMD_REQUEST_CAMERA_IMAGE_CAPTURE(),
	
	/**
	 * Enable or disable on-board camera triggering system.
	 */
	@MavlinkEnumEntry(value = 2003,description = "Enable or disable on-board camera triggering system.")
	MAV_CMD_DO_TRIGGER_CONTROL(),
	
	/**
	 * If the camera supports point visual tracking (CAMERA_CAP_FLAGS_HAS_TRACKING_POINT is set), this command allows to initiate the tracking.
	 */
	@MavlinkEnumEntry(value = 2004,description = "If the camera supports point visual tracking (CAMERA_CAP_FLAGS_HAS_TRACKING_POINT is set), this command allows to initiate the tracking.")
	MAV_CMD_CAMERA_TRACK_POINT(),
	
	/**
	 * If the camera supports rectangle visual tracking (CAMERA_CAP_FLAGS_HAS_TRACKING_RECTANGLE is set), this command allows to initiate the tracking.
	 */
	@MavlinkEnumEntry(value = 2005,description = "If the camera supports rectangle visual tracking (CAMERA_CAP_FLAGS_HAS_TRACKING_RECTANGLE is set), this command allows to initiate the tracking.")
	MAV_CMD_CAMERA_TRACK_RECTANGLE(),
	
	/**
	 * Stops ongoing tracking.
	 */
	@MavlinkEnumEntry(value = 2010,description = "Stops ongoing tracking.")
	MAV_CMD_CAMERA_STOP_TRACKING(),
	
	/**
	 * Starts video capture (recording).
	 */
	@MavlinkEnumEntry(value = 2500,description = "Starts video capture (recording).")
	MAV_CMD_VIDEO_START_CAPTURE(),
	
	/**
	 * Stop the current video capture (recording).
	 */
	@MavlinkEnumEntry(value = 2501,description = "Stop the current video capture (recording).")
	MAV_CMD_VIDEO_STOP_CAPTURE(),
	
	/**
	 * Start video streaming
	 */
	@MavlinkEnumEntry(value = 2502,description = "Start video streaming")
	MAV_CMD_VIDEO_START_STREAMING(),
	
	/**
	 * Stop the given video stream
	 */
	@MavlinkEnumEntry(value = 2503,description = "Stop the given video stream")
	MAV_CMD_VIDEO_STOP_STREAMING(),
	
	/**
	 * Request video stream information (VIDEO_STREAM_INFORMATION)
	 */
	@MavlinkEnumEntry(value = 2504,description = "Request video stream information (VIDEO_STREAM_INFORMATION)")
	MAV_CMD_REQUEST_VIDEO_STREAM_INFORMATION(),
	
	/**
	 * Request video stream status (VIDEO_STREAM_STATUS)
	 */
	@MavlinkEnumEntry(value = 2505,description = "Request video stream status (VIDEO_STREAM_STATUS)")
	MAV_CMD_REQUEST_VIDEO_STREAM_STATUS(),
	
	/**
	 * Request to start streaming logging data over MAVLink (see also LOGGING_DATA message)
	 */
	@MavlinkEnumEntry(value = 2510,description = "Request to start streaming logging data over MAVLink (see also LOGGING_DATA message)")
	MAV_CMD_LOGGING_START(),
	
	/**
	 * Request to stop streaming log data over MAVLink
	 */
	@MavlinkEnumEntry(value = 2511,description = "Request to stop streaming log data over MAVLink")
	MAV_CMD_LOGGING_STOP(),
	
	/**
	 * 
	 */
	@MavlinkEnumEntry(value = 2520,description = "")
	MAV_CMD_AIRFRAME_CONFIGURATION(),
	
	/**
	 * Request to start/stop transmitting over the high latency telemetry
	 */
	@MavlinkEnumEntry(value = 2600,description = "Request to start/stop transmitting over the high latency telemetry")
	MAV_CMD_CONTROL_HIGH_LATENCY(),
	
	/**
	 * Create a panorama at the current position
	 */
	@MavlinkEnumEntry(value = 2800,description = "Create a panorama at the current position")
	MAV_CMD_PANORAMA_CREATE(),
	
	/**
	 * Request VTOL transition
	 */
	@MavlinkEnumEntry(value = 3000,description = "Request VTOL transition")
	MAV_CMD_DO_VTOL_TRANSITION(),
	
	/**
	 * Request authorization to arm the vehicle to a external entity, the arm authorizer is responsible to request all data that is needs from the vehicle before authorize or deny the request. If approved the progress of command_ack message should be set with period of time that this authorization is valid in seconds or in case it was denied it should be set with one of the reasons in ARM_AUTH_DENIED_REASON.
	 */
	@MavlinkEnumEntry(value = 3001,description = "Request authorization to arm the vehicle to a external entity, the arm authorizer is responsible to request all data that is needs from the vehicle before authorize or deny the request. If approved the progress of command_ack message should be set with period of time that this authorization is valid in seconds or in case it was denied it should be set with one of the reasons in ARM_AUTH_DENIED_REASON.")
	MAV_CMD_ARM_AUTHORIZATION_REQUEST(),
	
	/**
	 * This command sets the submode to standard guided when vehicle is in guided mode. The vehicle holds position and altitude and the user can input the desired velocities along all three axes.
	 */
	@MavlinkEnumEntry(value = 4000,description = "This command sets the submode to standard guided when vehicle is in guided mode. The vehicle holds position and altitude and the user can input the desired velocities along all three axes.")
	MAV_CMD_SET_GUIDED_SUBMODE_STANDARD(),
	
	/**
	 * This command sets submode circle when vehicle is in guided mode. Vehicle flies along a circle facing the center of the circle. The user can input the velocity along the circle and change the radius. If no input is given the vehicle will hold position.
	 */
	@MavlinkEnumEntry(value = 4001,description = "This command sets submode circle when vehicle is in guided mode. Vehicle flies along a circle facing the center of the circle. The user can input the velocity along the circle and change the radius. If no input is given the vehicle will hold position.")
	MAV_CMD_SET_GUIDED_SUBMODE_CIRCLE(),
	
	/**
	 * Delay mission state machine until gate has been reached.
	 */
	@MavlinkEnumEntry(value = 4501,description = "Delay mission state machine until gate has been reached.")
	MAV_CMD_CONDITION_GATE(),
	
	/**
	 * Fence return point. There can only be one fence return point.
	 */
	@MavlinkEnumEntry(value = 5000,description = "Fence return point. There can only be one fence return point.")
	MAV_CMD_NAV_FENCE_RETURN_POINT(),
	
	/**
	 * Fence vertex for an inclusion polygon (the polygon must not be self-intersecting). The vehicle must stay within this area. Minimum of 3 vertices required.
	 */
	@MavlinkEnumEntry(value = 5001,description = "Fence vertex for an inclusion polygon (the polygon must not be self-intersecting). The vehicle must stay within this area. Minimum of 3 vertices required.")
	MAV_CMD_NAV_FENCE_POLYGON_VERTEX_INCLUSION(),
	
	/**
	 * Fence vertex for an exclusion polygon (the polygon must not be self-intersecting). The vehicle must stay outside this area. Minimum of 3 vertices required.
	 */
	@MavlinkEnumEntry(value = 5002,description = "Fence vertex for an exclusion polygon (the polygon must not be self-intersecting). The vehicle must stay outside this area. Minimum of 3 vertices required.")
	MAV_CMD_NAV_FENCE_POLYGON_VERTEX_EXCLUSION(),
	
	/**
	 * Circular fence area. The vehicle must stay inside this area.
	 */
	@MavlinkEnumEntry(value = 5003,description = "Circular fence area. The vehicle must stay inside this area.")
	MAV_CMD_NAV_FENCE_CIRCLE_INCLUSION(),
	
	/**
	 * Circular fence area. The vehicle must stay outside this area.
	 */
	@MavlinkEnumEntry(value = 5004,description = "Circular fence area. The vehicle must stay outside this area.")
	MAV_CMD_NAV_FENCE_CIRCLE_EXCLUSION(),
	
	/**
	 * Rally point. You can have multiple rally points defined.
	 */
	@MavlinkEnumEntry(value = 5100,description = "Rally point. You can have multiple rally points defined.")
	MAV_CMD_NAV_RALLY_POINT(),
	
	/**
	 * Commands the vehicle to respond with a sequence of messages UAVCAN_NODE_INFO, one message per every UAVCAN node that is online. Note that some of the response messages can be lost, which the receiver can detect easily by checking whether every received UAVCAN_NODE_STATUS has a matching message UAVCAN_NODE_INFO received earlier; if not, this command should be sent again in order to request re-transmission of the node information messages.
	 */
	@MavlinkEnumEntry(value = 5200,description = "Commands the vehicle to respond with a sequence of messages UAVCAN_NODE_INFO, one message per every UAVCAN node that is online. Note that some of the response messages can be lost, which the receiver can detect easily by checking whether every received UAVCAN_NODE_STATUS has a matching message UAVCAN_NODE_INFO received earlier; if not, this command should be sent again in order to request re-transmission of the node information messages.")
	MAV_CMD_UAVCAN_GET_NODE_INFO(),
	
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
	
	/**
	 * Magnetometer calibration based on provided known yaw. This allows for fast calibration using WMM field tables in the vehicle, given only the known yaw of the vehicle. If Latitude and longitude are both zero then use the current vehicle location.
	 */
	@MavlinkEnumEntry(value = 42006,description = "Magnetometer calibration based on provided known yaw. This allows for fast calibration using WMM field tables in the vehicle, given only the known yaw of the vehicle. If Latitude and longitude are both zero then use the current vehicle location.")
	MAV_CMD_FIXED_MAG_CAL_YAW(),
	
	/**
	 * Command to operate winch.
	 */
	@MavlinkEnumEntry(value = 42600,description = "Command to operate winch.")
	MAV_CMD_DO_WINCH(),
	
	/**
	 * User defined waypoint item. Ground Station will show the Vehicle as flying through this item.
	 */
	@MavlinkEnumEntry(value = 31000,description = "User defined waypoint item. Ground Station will show the Vehicle as flying through this item.")
	MAV_CMD_WAYPOINT_USER_1(),
	
	/**
	 * User defined waypoint item. Ground Station will show the Vehicle as flying through this item.
	 */
	@MavlinkEnumEntry(value = 31001,description = "User defined waypoint item. Ground Station will show the Vehicle as flying through this item.")
	MAV_CMD_WAYPOINT_USER_2(),
	
	/**
	 * User defined waypoint item. Ground Station will show the Vehicle as flying through this item.
	 */
	@MavlinkEnumEntry(value = 31002,description = "User defined waypoint item. Ground Station will show the Vehicle as flying through this item.")
	MAV_CMD_WAYPOINT_USER_3(),
	
	/**
	 * User defined waypoint item. Ground Station will show the Vehicle as flying through this item.
	 */
	@MavlinkEnumEntry(value = 31003,description = "User defined waypoint item. Ground Station will show the Vehicle as flying through this item.")
	MAV_CMD_WAYPOINT_USER_4(),
	
	/**
	 * User defined waypoint item. Ground Station will show the Vehicle as flying through this item.
	 */
	@MavlinkEnumEntry(value = 31004,description = "User defined waypoint item. Ground Station will show the Vehicle as flying through this item.")
	MAV_CMD_WAYPOINT_USER_5(),
	
	/**
	 * User defined spatial item. Ground Station will not show the Vehicle as flying through this item. Example: ROI item.
	 */
	@MavlinkEnumEntry(value = 31005,description = "User defined spatial item. Ground Station will not show the Vehicle as flying through this item. Example: ROI item.")
	MAV_CMD_SPATIAL_USER_1(),
	
	/**
	 * User defined spatial item. Ground Station will not show the Vehicle as flying through this item. Example: ROI item.
	 */
	@MavlinkEnumEntry(value = 31006,description = "User defined spatial item. Ground Station will not show the Vehicle as flying through this item. Example: ROI item.")
	MAV_CMD_SPATIAL_USER_2(),
	
	/**
	 * User defined spatial item. Ground Station will not show the Vehicle as flying through this item. Example: ROI item.
	 */
	@MavlinkEnumEntry(value = 31007,description = "User defined spatial item. Ground Station will not show the Vehicle as flying through this item. Example: ROI item.")
	MAV_CMD_SPATIAL_USER_3(),
	
	/**
	 * User defined spatial item. Ground Station will not show the Vehicle as flying through this item. Example: ROI item.
	 */
	@MavlinkEnumEntry(value = 31008,description = "User defined spatial item. Ground Station will not show the Vehicle as flying through this item. Example: ROI item.")
	MAV_CMD_SPATIAL_USER_4(),
	
	/**
	 * User defined spatial item. Ground Station will not show the Vehicle as flying through this item. Example: ROI item.
	 */
	@MavlinkEnumEntry(value = 31009,description = "User defined spatial item. Ground Station will not show the Vehicle as flying through this item. Example: ROI item.")
	MAV_CMD_SPATIAL_USER_5(),
	
	/**
	 * User defined command. Ground Station will not show the Vehicle as flying through this item. Example: MAV_CMD_DO_SET_PARAMETER item.
	 */
	@MavlinkEnumEntry(value = 31010,description = "User defined command. Ground Station will not show the Vehicle as flying through this item. Example: MAV_CMD_DO_SET_PARAMETER item.")
	MAV_CMD_USER_1(),
	
	/**
	 * User defined command. Ground Station will not show the Vehicle as flying through this item. Example: MAV_CMD_DO_SET_PARAMETER item.
	 */
	@MavlinkEnumEntry(value = 31011,description = "User defined command. Ground Station will not show the Vehicle as flying through this item. Example: MAV_CMD_DO_SET_PARAMETER item.")
	MAV_CMD_USER_2(),
	
	/**
	 * User defined command. Ground Station will not show the Vehicle as flying through this item. Example: MAV_CMD_DO_SET_PARAMETER item.
	 */
	@MavlinkEnumEntry(value = 31012,description = "User defined command. Ground Station will not show the Vehicle as flying through this item. Example: MAV_CMD_DO_SET_PARAMETER item.")
	MAV_CMD_USER_3(),
	
	/**
	 * User defined command. Ground Station will not show the Vehicle as flying through this item. Example: MAV_CMD_DO_SET_PARAMETER item.
	 */
	@MavlinkEnumEntry(value = 31013,description = "User defined command. Ground Station will not show the Vehicle as flying through this item. Example: MAV_CMD_DO_SET_PARAMETER item.")
	MAV_CMD_USER_4(),
	
	/**
	 * User defined command. Ground Station will not show the Vehicle as flying through this item. Example: MAV_CMD_DO_SET_PARAMETER item.
	 */
	@MavlinkEnumEntry(value = 31014,description = "User defined command. Ground Station will not show the Vehicle as flying through this item. Example: MAV_CMD_DO_SET_PARAMETER item.")
	MAV_CMD_USER_5(),
}
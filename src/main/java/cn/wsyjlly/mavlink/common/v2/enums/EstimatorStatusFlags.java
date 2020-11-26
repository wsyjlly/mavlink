package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "ESTIMATOR_STATUS_FLAGS", bitmask = "true")
public enum  EstimatorStatusFlags {
	
	/**
	 * True if the attitude estimate is good
	 */
	@MavlinkEnumEntry(value = 1,description = "True if the attitude estimate is good")
	ESTIMATOR_ATTITUDE(),
	
	/**
	 * True if the horizontal velocity estimate is good
	 */
	@MavlinkEnumEntry(value = 2,description = "True if the horizontal velocity estimate is good")
	ESTIMATOR_VELOCITY_HORIZ(),
	
	/**
	 * True if the vertical velocity estimate is good
	 */
	@MavlinkEnumEntry(value = 4,description = "True if the vertical velocity estimate is good")
	ESTIMATOR_VELOCITY_VERT(),
	
	/**
	 * True if the horizontal position (relative) estimate is good
	 */
	@MavlinkEnumEntry(value = 8,description = "True if the horizontal position (relative) estimate is good")
	ESTIMATOR_POS_HORIZ_REL(),
	
	/**
	 * True if the horizontal position (absolute) estimate is good
	 */
	@MavlinkEnumEntry(value = 16,description = "True if the horizontal position (absolute) estimate is good")
	ESTIMATOR_POS_HORIZ_ABS(),
	
	/**
	 * True if the vertical position (absolute) estimate is good
	 */
	@MavlinkEnumEntry(value = 32,description = "True if the vertical position (absolute) estimate is good")
	ESTIMATOR_POS_VERT_ABS(),
	
	/**
	 * True if the vertical position (above ground) estimate is good
	 */
	@MavlinkEnumEntry(value = 64,description = "True if the vertical position (above ground) estimate is good")
	ESTIMATOR_POS_VERT_AGL(),
	
	/**
	 * True if the EKF is in a constant position mode and is not using external measurements (eg GPS or optical flow)
	 */
	@MavlinkEnumEntry(value = 128,description = "True if the EKF is in a constant position mode and is not using external measurements (eg GPS or optical flow)")
	ESTIMATOR_CONST_POS_MODE(),
	
	/**
	 * True if the EKF has sufficient data to enter a mode that will provide a (relative) position estimate
	 */
	@MavlinkEnumEntry(value = 256,description = "True if the EKF has sufficient data to enter a mode that will provide a (relative) position estimate")
	ESTIMATOR_PRED_POS_HORIZ_REL(),
	
	/**
	 * True if the EKF has sufficient data to enter a mode that will provide a (absolute) position estimate
	 */
	@MavlinkEnumEntry(value = 512,description = "True if the EKF has sufficient data to enter a mode that will provide a (absolute) position estimate")
	ESTIMATOR_PRED_POS_HORIZ_ABS(),
	
	/**
	 * True if the EKF has detected a GPS glitch
	 */
	@MavlinkEnumEntry(value = 1024,description = "True if the EKF has detected a GPS glitch")
	ESTIMATOR_GPS_GLITCH(),
	
	/**
	 * True if the EKF has detected bad accelerometer data
	 */
	@MavlinkEnumEntry(value = 2048,description = "True if the EKF has detected bad accelerometer data")
	ESTIMATOR_ACCEL_ERROR(),
}
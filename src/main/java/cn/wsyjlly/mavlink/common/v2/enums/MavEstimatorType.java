package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "MAV_ESTIMATOR_TYPE")
public enum  MavEstimatorType {
	
	/**
	 * Unknown type of the estimator.
	 */
	@MavlinkEnumEntry(value = 0,description = "Unknown type of the estimator.")
	MAV_ESTIMATOR_TYPE_UNKNOWN(),
	
	/**
	 * This is a naive estimator without any real covariance feedback.
	 */
	@MavlinkEnumEntry(value = 1,description = "This is a naive estimator without any real covariance feedback.")
	MAV_ESTIMATOR_TYPE_NAIVE(),
	
	/**
	 * Computer vision based estimate. Might be up to scale.
	 */
	@MavlinkEnumEntry(value = 2,description = "Computer vision based estimate. Might be up to scale.")
	MAV_ESTIMATOR_TYPE_VISION(),
	
	/**
	 * Visual-inertial estimate.
	 */
	@MavlinkEnumEntry(value = 3,description = "Visual-inertial estimate.")
	MAV_ESTIMATOR_TYPE_VIO(),
	
	/**
	 * Plain GPS estimate.
	 */
	@MavlinkEnumEntry(value = 4,description = "Plain GPS estimate.")
	MAV_ESTIMATOR_TYPE_GPS(),
	
	/**
	 * Estimator integrating GPS and inertial sensing.
	 */
	@MavlinkEnumEntry(value = 5,description = "Estimator integrating GPS and inertial sensing.")
	MAV_ESTIMATOR_TYPE_GPS_INS(),
	
	/**
	 * Estimate from external motion capturing system.
	 */
	@MavlinkEnumEntry(value = 6,description = "Estimate from external motion capturing system.")
	MAV_ESTIMATOR_TYPE_MOCAP(),
	
	/**
	 * Estimator based on lidar sensor input.
	 */
	@MavlinkEnumEntry(value = 7,description = "Estimator based on lidar sensor input.")
	MAV_ESTIMATOR_TYPE_LIDAR(),
	
	/**
	 * Estimator on autopilot.
	 */
	@MavlinkEnumEntry(value = 8,description = "Estimator on autopilot.")
	MAV_ESTIMATOR_TYPE_AUTOPILOT(),
}
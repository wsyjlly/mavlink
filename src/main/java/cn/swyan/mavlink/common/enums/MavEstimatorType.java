package cn.swyan.mavlink.common.enums;

import cn.swyan.mavlink.annotation.MavlinkEnum;
import cn.swyan.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * @Author YSW
 * @Description
 * @Date 2020.11.04 - 03:56
 *
 **********************************/

@MavlinkEnum(name = "MAV_ESTIMATOR_TYPE")
public enum  MavEstimatorType {
	
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
}
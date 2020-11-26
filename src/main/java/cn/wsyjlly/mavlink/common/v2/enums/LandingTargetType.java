package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "LANDING_TARGET_TYPE")
public enum  LandingTargetType {
	
	/**
	 * Landing target signaled by light beacon (ex: IR-LOCK)
	 */
	@MavlinkEnumEntry(value = 0,description = "Landing target signaled by light beacon (ex: IR-LOCK)")
	LANDING_TARGET_TYPE_LIGHT_BEACON(),
	
	/**
	 * Landing target signaled by radio beacon (ex: ILS, NDB)
	 */
	@MavlinkEnumEntry(value = 1,description = "Landing target signaled by radio beacon (ex: ILS, NDB)")
	LANDING_TARGET_TYPE_RADIO_BEACON(),
	
	/**
	 * Landing target represented by a fiducial marker (ex: ARTag)
	 */
	@MavlinkEnumEntry(value = 2,description = "Landing target represented by a fiducial marker (ex: ARTag)")
	LANDING_TARGET_TYPE_VISION_FIDUCIAL(),
	
	/**
	 * Landing target represented by a pre-defined visual shape/feature (ex: X-marker, H-marker, square)
	 */
	@MavlinkEnumEntry(value = 3,description = "Landing target represented by a pre-defined visual shape/feature (ex: X-marker, H-marker, square)")
	LANDING_TARGET_TYPE_VISION_OTHER(),
}
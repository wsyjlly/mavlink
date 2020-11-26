package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "UTM_DATA_AVAIL_FLAGS", bitmask = "true")
public enum  UtmDataAvailFlags {
	
	/**
	 * The field time contains valid data.
	 */
	@MavlinkEnumEntry(value = 1,description = "The field time contains valid data.")
	UTM_DATA_AVAIL_FLAGS_TIME_VALID(),
	
	/**
	 * The field uas_id contains valid data.
	 */
	@MavlinkEnumEntry(value = 2,description = "The field uas_id contains valid data.")
	UTM_DATA_AVAIL_FLAGS_UAS_ID_AVAILABLE(),
	
	/**
	 * The fields lat, lon and h_acc contain valid data.
	 */
	@MavlinkEnumEntry(value = 4,description = "The fields lat, lon and h_acc contain valid data.")
	UTM_DATA_AVAIL_FLAGS_POSITION_AVAILABLE(),
	
	/**
	 * The fields alt and v_acc contain valid data.
	 */
	@MavlinkEnumEntry(value = 8,description = "The fields alt and v_acc contain valid data.")
	UTM_DATA_AVAIL_FLAGS_ALTITUDE_AVAILABLE(),
	
	/**
	 * The field relative_alt contains valid data.
	 */
	@MavlinkEnumEntry(value = 16,description = "The field relative_alt contains valid data.")
	UTM_DATA_AVAIL_FLAGS_RELATIVE_ALTITUDE_AVAILABLE(),
	
	/**
	 * The fields vx and vy contain valid data.
	 */
	@MavlinkEnumEntry(value = 32,description = "The fields vx and vy contain valid data.")
	UTM_DATA_AVAIL_FLAGS_HORIZONTAL_VELO_AVAILABLE(),
	
	/**
	 * The field vz contains valid data.
	 */
	@MavlinkEnumEntry(value = 64,description = "The field vz contains valid data.")
	UTM_DATA_AVAIL_FLAGS_VERTICAL_VELO_AVAILABLE(),
	
	/**
	 * The fields next_lat, next_lon and next_alt contain valid data.
	 */
	@MavlinkEnumEntry(value = 128,description = "The fields next_lat, next_lon and next_alt contain valid data.")
	UTM_DATA_AVAIL_FLAGS_NEXT_WAYPOINT_AVAILABLE(),
}
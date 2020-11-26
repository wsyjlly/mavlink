package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "MAG_CAL_STATUS")
public enum  MagCalStatus {
	
	/**
	 * MAG_CAL_NOT_STARTED
	 */
	@MavlinkEnumEntry(value = 0)
	MAG_CAL_NOT_STARTED(),
	
	/**
	 * MAG_CAL_WAITING_TO_START
	 */
	@MavlinkEnumEntry(value = 1)
	MAG_CAL_WAITING_TO_START(),
	
	/**
	 * MAG_CAL_RUNNING_STEP_ONE
	 */
	@MavlinkEnumEntry(value = 2)
	MAG_CAL_RUNNING_STEP_ONE(),
	
	/**
	 * MAG_CAL_RUNNING_STEP_TWO
	 */
	@MavlinkEnumEntry(value = 3)
	MAG_CAL_RUNNING_STEP_TWO(),
	
	/**
	 * MAG_CAL_SUCCESS
	 */
	@MavlinkEnumEntry(value = 4)
	MAG_CAL_SUCCESS(),
	
	/**
	 * MAG_CAL_FAILED
	 */
	@MavlinkEnumEntry(value = 5)
	MAG_CAL_FAILED(),
	
	/**
	 * MAG_CAL_BAD_ORIENTATION
	 */
	@MavlinkEnumEntry(value = 6)
	MAG_CAL_BAD_ORIENTATION(),
	
	/**
	 * MAG_CAL_BAD_RADIUS
	 */
	@MavlinkEnumEntry(value = 7)
	MAG_CAL_BAD_RADIUS(),
}
package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "SET_FOCUS_TYPE")
public enum  SetFocusType {
	
	/**
	 * Focus one step increment (-1 for focusing in, 1 for focusing out towards infinity).
	 */
	@MavlinkEnumEntry(value = 0,description = "Focus one step increment (-1 for focusing in, 1 for focusing out towards infinity).")
	FOCUS_TYPE_STEP(),
	
	/**
	 * Continuous focus up/down until stopped (-1 for focusing in, 1 for focusing out towards infinity, 0 to stop focusing)
	 */
	@MavlinkEnumEntry(value = 1,description = "Continuous focus up/down until stopped (-1 for focusing in, 1 for focusing out towards infinity, 0 to stop focusing)")
	FOCUS_TYPE_CONTINUOUS(),
	
	/**
	 * Focus value as proportion of full camera focus range (a value between 0.0 and 100.0)
	 */
	@MavlinkEnumEntry(value = 2,description = "Focus value as proportion of full camera focus range (a value between 0.0 and 100.0)")
	FOCUS_TYPE_RANGE(),
	
	/**
	 * Focus value in metres. Note that there is no message to get the valid focus range of the camera, so this can type can only be used for cameras where the range is known (implying that this cannot reliably be used in a GCS for an arbitrary camera).
	 */
	@MavlinkEnumEntry(value = 3,description = "Focus value in metres. Note that there is no message to get the valid focus range of the camera, so this can type can only be used for cameras where the range is known (implying that this cannot reliably be used in a GCS for an arbitrary camera).")
	FOCUS_TYPE_METERS(),
}
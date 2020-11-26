package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "STORAGE_STATUS")
public enum  StorageStatus {
	
	/**
	 * Storage is missing (no microSD card loaded for example.)
	 */
	@MavlinkEnumEntry(value = 0,description = "Storage is missing (no microSD card loaded for example.)")
	STORAGE_STATUS_EMPTY(),
	
	/**
	 * Storage present but unformatted.
	 */
	@MavlinkEnumEntry(value = 1,description = "Storage present but unformatted.")
	STORAGE_STATUS_UNFORMATTED(),
	
	/**
	 * Storage present and ready.
	 */
	@MavlinkEnumEntry(value = 2,description = "Storage present and ready.")
	STORAGE_STATUS_READY(),
	
	/**
	 * Camera does not supply storage status information. Capacity information in STORAGE_INFORMATION fields will be ignored.
	 */
	@MavlinkEnumEntry(value = 3,description = "Camera does not supply storage status information. Capacity information in STORAGE_INFORMATION fields will be ignored.")
	STORAGE_STATUS_NOT_SUPPORTED(),
}
package cn.swyan.mavlink.common.enums;

import cn.swyan.mavlink.annotation.MavlinkEnum;
import cn.swyan.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * @Author YSW
 * @Description
 * @Date 2020.11.04 - 03:56
 *
 **********************************/

@MavlinkEnum(name = "MAV_POWER_STATUS")
public enum  MavPowerStatus {
	
	/**
	 * main brick power supply valid
	 */
	@MavlinkEnumEntry(value = 1,description = "main brick power supply valid")
	MAV_POWER_STATUS_BRICK_VALID(),
	
	/**
	 * main servo power supply valid for FMU
	 */
	@MavlinkEnumEntry(value = 2,description = "main servo power supply valid for FMU")
	MAV_POWER_STATUS_SERVO_VALID(),
	
	/**
	 * USB power is connected
	 */
	@MavlinkEnumEntry(value = 4,description = "USB power is connected")
	MAV_POWER_STATUS_USB_CONNECTED(),
	
	/**
	 * peripheral supply is in over-current state
	 */
	@MavlinkEnumEntry(value = 8,description = "peripheral supply is in over-current state")
	MAV_POWER_STATUS_PERIPH_OVERCURRENT(),
	
	/**
	 * hi-power peripheral supply is in over-current state
	 */
	@MavlinkEnumEntry(value = 16,description = "hi-power peripheral supply is in over-current state")
	MAV_POWER_STATUS_PERIPH_HIPOWER_OVERCURRENT(),
	
	/**
	 * Power status has changed since boot
	 */
	@MavlinkEnumEntry(value = 32,description = "Power status has changed since boot")
	MAV_POWER_STATUS_CHANGED(),
}
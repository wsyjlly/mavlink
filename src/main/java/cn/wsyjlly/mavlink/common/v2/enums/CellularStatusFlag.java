package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "CELLULAR_STATUS_FLAG")
public enum  CellularStatusFlag {
	
	/**
	 * State unknown or not reportable.
	 */
	@MavlinkEnumEntry(value = 0,description = "State unknown or not reportable.")
	CELLULAR_STATUS_FLAG_UNKNOWN(),
	
	/**
	 * Modem is unusable
	 */
	@MavlinkEnumEntry(value = 1,description = "Modem is unusable")
	CELLULAR_STATUS_FLAG_FAILED(),
	
	/**
	 * Modem is being initialized
	 */
	@MavlinkEnumEntry(value = 2,description = "Modem is being initialized")
	CELLULAR_STATUS_FLAG_INITIALIZING(),
	
	/**
	 * Modem is locked
	 */
	@MavlinkEnumEntry(value = 3,description = "Modem is locked")
	CELLULAR_STATUS_FLAG_LOCKED(),
	
	/**
	 * Modem is not enabled and is powered down
	 */
	@MavlinkEnumEntry(value = 4,description = "Modem is not enabled and is powered down")
	CELLULAR_STATUS_FLAG_DISABLED(),
	
	/**
	 * Modem is currently transitioning to the CELLULAR_STATUS_FLAG_DISABLED state
	 */
	@MavlinkEnumEntry(value = 5,description = "Modem is currently transitioning to the CELLULAR_STATUS_FLAG_DISABLED state")
	CELLULAR_STATUS_FLAG_DISABLING(),
	
	/**
	 * Modem is currently transitioning to the CELLULAR_STATUS_FLAG_ENABLED state
	 */
	@MavlinkEnumEntry(value = 6,description = "Modem is currently transitioning to the CELLULAR_STATUS_FLAG_ENABLED state")
	CELLULAR_STATUS_FLAG_ENABLING(),
	
	/**
	 * Modem is enabled and powered on but not registered with a network provider and not available for data connections
	 */
	@MavlinkEnumEntry(value = 7,description = "Modem is enabled and powered on but not registered with a network provider and not available for data connections")
	CELLULAR_STATUS_FLAG_ENABLED(),
	
	/**
	 * Modem is searching for a network provider to register
	 */
	@MavlinkEnumEntry(value = 8,description = "Modem is searching for a network provider to register")
	CELLULAR_STATUS_FLAG_SEARCHING(),
	
	/**
	 * Modem is registered with a network provider, and data connections and messaging may be available for use
	 */
	@MavlinkEnumEntry(value = 9,description = "Modem is registered with a network provider, and data connections and messaging may be available for use")
	CELLULAR_STATUS_FLAG_REGISTERED(),
	
	/**
	 * Modem is disconnecting and deactivating the last active packet data bearer. This state will not be entered if more than one packet data bearer is active and one of the active bearers is deactivated
	 */
	@MavlinkEnumEntry(value = 10,description = "Modem is disconnecting and deactivating the last active packet data bearer. This state will not be entered if more than one packet data bearer is active and one of the active bearers is deactivated")
	CELLULAR_STATUS_FLAG_DISCONNECTING(),
	
	/**
	 * Modem is activating and connecting the first packet data bearer. Subsequent bearer activations when another bearer is already active do not cause this state to be entered
	 */
	@MavlinkEnumEntry(value = 11,description = "Modem is activating and connecting the first packet data bearer. Subsequent bearer activations when another bearer is already active do not cause this state to be entered")
	CELLULAR_STATUS_FLAG_CONNECTING(),
	
	/**
	 * One or more packet data bearers is active and connected
	 */
	@MavlinkEnumEntry(value = 12,description = "One or more packet data bearers is active and connected")
	CELLULAR_STATUS_FLAG_CONNECTED(),
}
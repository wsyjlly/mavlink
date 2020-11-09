package cn.wsyjlly.mavlink.common.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.09 - 03:37
 *
 **********************************/

@MavlinkEnum(name = "SERIAL_CONTROL_FLAG")
public enum  SerialControlFlag {
	
	/**
	 * Set if this is a reply
	 */
	@MavlinkEnumEntry(value = 1,description = "Set if this is a reply")
	SERIAL_CONTROL_FLAG_REPLY(),
	
	/**
	 * Set if the sender wants the receiver to send a response as another SERIAL_CONTROL message
	 */
	@MavlinkEnumEntry(value = 2,description = "Set if the sender wants the receiver to send a response as another SERIAL_CONTROL message")
	SERIAL_CONTROL_FLAG_RESPOND(),
	
	/**
	 * Set if access to the serial port should be removed from whatever driver is currently using it, giving exclusive access to the SERIAL_CONTROL protocol. The port can be handed back by sending a request without this flag set
	 */
	@MavlinkEnumEntry(value = 4,description = "Set if access to the serial port should be removed from whatever driver is currently using it, giving exclusive access to the SERIAL_CONTROL protocol. The port can be handed back by sending a request without this flag set")
	SERIAL_CONTROL_FLAG_EXCLUSIVE(),
	
	/**
	 * Block on writes to the serial port
	 */
	@MavlinkEnumEntry(value = 8,description = "Block on writes to the serial port")
	SERIAL_CONTROL_FLAG_BLOCKING(),
	
	/**
	 * Send multiple replies until port is drained
	 */
	@MavlinkEnumEntry(value = 16,description = "Send multiple replies until port is drained")
	SERIAL_CONTROL_FLAG_MULTI(),
}
package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "MAV_TUNNEL_PAYLOAD_TYPE")
public enum  MavTunnelPayloadType {
	
	/**
	 * Encoding of payload unknown.
	 */
	@MavlinkEnumEntry(value = 0,description = "Encoding of payload unknown.")
	MAV_TUNNEL_PAYLOAD_TYPE_UNKNOWN(),
	
	/**
	 * Registered for STorM32 gimbal controller.
	 */
	@MavlinkEnumEntry(value = 200,description = "Registered for STorM32 gimbal controller.")
	MAV_TUNNEL_PAYLOAD_TYPE_STORM32_RESERVED0(),
	
	/**
	 * Registered for STorM32 gimbal controller.
	 */
	@MavlinkEnumEntry(value = 201,description = "Registered for STorM32 gimbal controller.")
	MAV_TUNNEL_PAYLOAD_TYPE_STORM32_RESERVED1(),
	
	/**
	 * Registered for STorM32 gimbal controller.
	 */
	@MavlinkEnumEntry(value = 202,description = "Registered for STorM32 gimbal controller.")
	MAV_TUNNEL_PAYLOAD_TYPE_STORM32_RESERVED2(),
	
	/**
	 * Registered for STorM32 gimbal controller.
	 */
	@MavlinkEnumEntry(value = 203,description = "Registered for STorM32 gimbal controller.")
	MAV_TUNNEL_PAYLOAD_TYPE_STORM32_RESERVED3(),
	
	/**
	 * Registered for STorM32 gimbal controller.
	 */
	@MavlinkEnumEntry(value = 204,description = "Registered for STorM32 gimbal controller.")
	MAV_TUNNEL_PAYLOAD_TYPE_STORM32_RESERVED4(),
	
	/**
	 * Registered for STorM32 gimbal controller.
	 */
	@MavlinkEnumEntry(value = 205,description = "Registered for STorM32 gimbal controller.")
	MAV_TUNNEL_PAYLOAD_TYPE_STORM32_RESERVED5(),
	
	/**
	 * Registered for STorM32 gimbal controller.
	 */
	@MavlinkEnumEntry(value = 206,description = "Registered for STorM32 gimbal controller.")
	MAV_TUNNEL_PAYLOAD_TYPE_STORM32_RESERVED6(),
	
	/**
	 * Registered for STorM32 gimbal controller.
	 */
	@MavlinkEnumEntry(value = 207,description = "Registered for STorM32 gimbal controller.")
	MAV_TUNNEL_PAYLOAD_TYPE_STORM32_RESERVED7(),
	
	/**
	 * Registered for STorM32 gimbal controller.
	 */
	@MavlinkEnumEntry(value = 208,description = "Registered for STorM32 gimbal controller.")
	MAV_TUNNEL_PAYLOAD_TYPE_STORM32_RESERVED8(),
	
	/**
	 * Registered for STorM32 gimbal controller.
	 */
	@MavlinkEnumEntry(value = 209,description = "Registered for STorM32 gimbal controller.")
	MAV_TUNNEL_PAYLOAD_TYPE_STORM32_RESERVED9(),
}
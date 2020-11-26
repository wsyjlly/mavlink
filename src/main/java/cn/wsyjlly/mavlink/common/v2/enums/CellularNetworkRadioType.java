package cn.wsyjlly.mavlink.common.v2.enums;

import cn.wsyjlly.mavlink.annotation.MavlinkEnum;
import cn.wsyjlly.mavlink.annotation.MavlinkEnumEntry;

/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 *
 **********************************/

@MavlinkEnum(name = "CELLULAR_NETWORK_RADIO_TYPE")
public enum  CellularNetworkRadioType {
	
	/**
	 * CELLULAR_NETWORK_RADIO_TYPE_NONE
	 */
	@MavlinkEnumEntry(value = 0)
	CELLULAR_NETWORK_RADIO_TYPE_NONE(),
	
	/**
	 * CELLULAR_NETWORK_RADIO_TYPE_GSM
	 */
	@MavlinkEnumEntry(value = 1)
	CELLULAR_NETWORK_RADIO_TYPE_GSM(),
	
	/**
	 * CELLULAR_NETWORK_RADIO_TYPE_CDMA
	 */
	@MavlinkEnumEntry(value = 2)
	CELLULAR_NETWORK_RADIO_TYPE_CDMA(),
	
	/**
	 * CELLULAR_NETWORK_RADIO_TYPE_WCDMA
	 */
	@MavlinkEnumEntry(value = 3)
	CELLULAR_NETWORK_RADIO_TYPE_WCDMA(),
	
	/**
	 * CELLULAR_NETWORK_RADIO_TYPE_LTE
	 */
	@MavlinkEnumEntry(value = 4)
	CELLULAR_NETWORK_RADIO_TYPE_LTE(),
}
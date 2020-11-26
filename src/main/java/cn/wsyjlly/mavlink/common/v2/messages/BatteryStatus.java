package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.MavBatteryChargeState;
import cn.wsyjlly.mavlink.common.v2.enums.MavBatteryMode;
import cn.wsyjlly.mavlink.common.v2.enums.MavBatteryType;
import cn.wsyjlly.mavlink.common.v2.enums.MavBatteryFunction;
import cn.wsyjlly.mavlink.common.v2.enums.MavBatteryFault;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
import java.util.Arrays;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 147,
		messagePayloadLength = 54,
		description = "Battery information. Updates GCS with flight controller battery status. Smart batteries also use this message, but may additionally send SMART_BATTERY_INFO."
)
public class BatteryStatus implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "Battery ID")
	private short id;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Function of the battery", enum0 = MavBatteryFunction.class)
	private short batteryFunction;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, description = "Type (chemistry) of the battery", enum0 = MavBatteryType.class)
	private short type;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 4, typeSize = 2, streamLength = 2, description = "Temperature of the battery. INT16_MAX for unknown temperature.", units = "cdegC")
	private short temperature;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 5, typeSize = 2, streamLength = 20, description = "Battery voltage of cells 1 to 10 (see voltages_ext for cells 11-14). Cells in this field above the valid cell count for this battery should have the UINT16_MAX value. If individual cell voltages are unknown or not measured for this battery, then the overall battery voltage should be filled in cell 0, with all others set to UINT16_MAX. If the voltage of the battery is greater than (UINT16_MAX - 1), then cell 0 should be set to (UINT16_MAX - 1), and cell 1 to the remaining voltage. This can be extended to multiple cells if the total voltage is greater than 2 * (UINT16_MAX - 1).", units = "mV")
	private int[] voltages = new int[10];

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 6, typeSize = 2, streamLength = 2, description = "Battery current, -1: autopilot does not measure the current", units = "cA")
	private short currentBattery;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 7, typeSize = 4, streamLength = 4, description = "Consumed charge, -1: autopilot does not provide consumption estimate", units = "mAh")
	private int currentConsumed;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 8, typeSize = 4, streamLength = 4, description = "Consumed energy, -1: autopilot does not provide energy consumption estimate", units = "hJ")
	private int energyConsumed;

	@MavlinkMessageParam(mavlinkType = "int8_t", position = 9, typeSize = 1, streamLength = 1, description = "Remaining battery energy. Values: [0-100], -1: autopilot does not estimate the remaining battery.", units = "%")
	private byte batteryRemaining;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 10, typeSize = 4, streamLength = 4, description = "Remaining battery time, 0: autopilot does not provide remaining battery time estimate", units = "s")
	private int timeRemaining;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 11, typeSize = 1, streamLength = 1, description = "State for extent of discharge, provided by autopilot for warning or external reactions", enum0 = MavBatteryChargeState.class)
	private short chargeState;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 12, typeSize = 2, streamLength = 8, description = "Battery voltages for cells 11 to 14. Cells above the valid cell count for this battery should have a value of 0, where zero indicates not supported (note, this is different than for the voltages field and allows empty byte truncation). If the measured value is 0 then 1 should be sent instead.", units = "mV")
	private int[] voltagesExt = new int[4];

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 13, typeSize = 1, streamLength = 1, description = "Battery mode. Default (0) is that battery mode reporting is not supported or battery is in normal-use mode.", enum0 = MavBatteryMode.class)
	private short mode;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 14, typeSize = 4, streamLength = 4, description = "Fault/health indications. These should be set when charge_state is MAV_BATTERY_CHARGE_STATE_FAILED or MAV_BATTERY_CHARGE_STATE_UNHEALTHY (if not, fault reporting is not supported).", enum0 = MavBatteryFault.class)
	private long faultBitmask;

	private final int messagePayloadLength = 54;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public BatteryStatus(short id, short batteryFunction, short type, short temperature, int[] voltages, short currentBattery, int currentConsumed, int energyConsumed, byte batteryRemaining, int timeRemaining, short chargeState, int[] voltagesExt, short mode, long faultBitmask) {
		this.id = id;
		this.batteryFunction = batteryFunction;
		this.type = type;
		this.temperature = temperature;
		this.voltages = voltages;
		this.currentBattery = currentBattery;
		this.currentConsumed = currentConsumed;
		this.energyConsumed = energyConsumed;
		this.batteryRemaining = batteryRemaining;
		this.timeRemaining = timeRemaining;
		this.chargeState = chargeState;
		this.voltagesExt = voltagesExt;
		this.mode = mode;
		this.faultBitmask = faultBitmask;
	}

	public BatteryStatus(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 54！");
		}
		messagePayload(messagePayload);
	}

	public BatteryStatus(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		id = byteArray.getUnsignedInt8(0);
		batteryFunction = byteArray.getUnsignedInt8(1);
		type = byteArray.getUnsignedInt8(2);
		temperature = byteArray.getInt16(3);
		voltages = byteArray.getUnsignedInt16Array(5,10);
		currentBattery = byteArray.getInt16(25);
		currentConsumed = byteArray.getInt32(27);
		energyConsumed = byteArray.getInt32(31);
		batteryRemaining = byteArray.getInt8(35);
		timeRemaining = byteArray.getInt32(36);
		chargeState = byteArray.getUnsignedInt8(40);
		voltagesExt = byteArray.getUnsignedInt16Array(41,4);
		mode = byteArray.getUnsignedInt8(49);
		faultBitmask = byteArray.getUnsignedInt32(50);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(id,0);
		byteArray.putUnsignedInt8(batteryFunction,1);
		byteArray.putUnsignedInt8(type,2);
		byteArray.putInt16(temperature,3);
		byteArray.putUnsignedInt16Array(voltages,5);
		byteArray.putInt16(currentBattery,25);
		byteArray.putInt32(currentConsumed,27);
		byteArray.putInt32(energyConsumed,31);
		byteArray.putInt8(batteryRemaining,35);
		byteArray.putInt32(timeRemaining,36);
		byteArray.putUnsignedInt8(chargeState,40);
		byteArray.putUnsignedInt16Array(voltagesExt,41);
		byteArray.putUnsignedInt8(mode,49);
		byteArray.putUnsignedInt32(faultBitmask,50);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final BatteryStatus setId(short id) {
		this.id = id;
		return this;
	}

	public final short getId() {
		return id;
	}

	public final BatteryStatus setBatteryFunction(short batteryFunction) {
		this.batteryFunction = batteryFunction;
		return this;
	}

	public final short getBatteryFunction() {
		return batteryFunction;
	}

	public final BatteryStatus setType(short type) {
		this.type = type;
		return this;
	}

	public final short getType() {
		return type;
	}

	public final BatteryStatus setTemperature(short temperature) {
		this.temperature = temperature;
		return this;
	}

	public final short getTemperature() {
		return temperature;
	}

	public final BatteryStatus setVoltages(int[] voltages) {
		this.voltages = voltages;
		return this;
	}

	public final int[] getVoltages() {
		return voltages;
	}

	public final BatteryStatus setCurrentBattery(short currentBattery) {
		this.currentBattery = currentBattery;
		return this;
	}

	public final short getCurrentBattery() {
		return currentBattery;
	}

	public final BatteryStatus setCurrentConsumed(int currentConsumed) {
		this.currentConsumed = currentConsumed;
		return this;
	}

	public final int getCurrentConsumed() {
		return currentConsumed;
	}

	public final BatteryStatus setEnergyConsumed(int energyConsumed) {
		this.energyConsumed = energyConsumed;
		return this;
	}

	public final int getEnergyConsumed() {
		return energyConsumed;
	}

	public final BatteryStatus setBatteryRemaining(byte batteryRemaining) {
		this.batteryRemaining = batteryRemaining;
		return this;
	}

	public final byte getBatteryRemaining() {
		return batteryRemaining;
	}

	public final BatteryStatus setTimeRemaining(int timeRemaining) {
		this.timeRemaining = timeRemaining;
		return this;
	}

	public final int getTimeRemaining() {
		return timeRemaining;
	}

	public final BatteryStatus setChargeState(short chargeState) {
		this.chargeState = chargeState;
		return this;
	}

	public final short getChargeState() {
		return chargeState;
	}

	public final BatteryStatus setVoltagesExt(int[] voltagesExt) {
		this.voltagesExt = voltagesExt;
		return this;
	}

	public final int[] getVoltagesExt() {
		return voltagesExt;
	}

	public final BatteryStatus setMode(short mode) {
		this.mode = mode;
		return this;
	}

	public final short getMode() {
		return mode;
	}

	public final BatteryStatus setFaultBitmask(long faultBitmask) {
		this.faultBitmask = faultBitmask;
		return this;
	}

	public final long getFaultBitmask() {
		return faultBitmask;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			BatteryStatus other = (BatteryStatus)o;
			if (!Objects.deepEquals(this.id, other.id)) {
				return false;
			} else if (!Objects.deepEquals(this.batteryFunction, other.batteryFunction)) {
				return false;
			} else if (!Objects.deepEquals(this.type, other.type)) {
				return false;
			} else if (!Objects.deepEquals(this.temperature, other.temperature)) {
				return false;
			} else if (!Objects.deepEquals(this.voltages, other.voltages)) {
				return false;
			} else if (!Objects.deepEquals(this.currentBattery, other.currentBattery)) {
				return false;
			} else if (!Objects.deepEquals(this.currentConsumed, other.currentConsumed)) {
				return false;
			} else if (!Objects.deepEquals(this.energyConsumed, other.energyConsumed)) {
				return false;
			} else if (!Objects.deepEquals(this.batteryRemaining, other.batteryRemaining)) {
				return false;
			} else if (!Objects.deepEquals(this.timeRemaining, other.timeRemaining)) {
				return false;
			} else if (!Objects.deepEquals(this.chargeState, other.chargeState)) {
				return false;
			} else if (!Objects.deepEquals(this.voltagesExt, other.voltagesExt)) {
				return false;
			} else if (!Objects.deepEquals(this.mode, other.mode)) {
				return false;
			} else {
				return Objects.deepEquals(this.faultBitmask, other.faultBitmask);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.id);
		result = 31 * result + Objects.hashCode(this.batteryFunction);
		result = 31 * result + Objects.hashCode(this.type);
		result = 31 * result + Objects.hashCode(this.temperature);
		result = 31 * result + Objects.hashCode(this.voltages);
		result = 31 * result + Objects.hashCode(this.currentBattery);
		result = 31 * result + Objects.hashCode(this.currentConsumed);
		result = 31 * result + Objects.hashCode(this.energyConsumed);
		result = 31 * result + Objects.hashCode(this.batteryRemaining);
		result = 31 * result + Objects.hashCode(this.timeRemaining);
		result = 31 * result + Objects.hashCode(this.chargeState);
		result = 31 * result + Objects.hashCode(this.voltagesExt);
		result = 31 * result + Objects.hashCode(this.mode);
		result = 31 * result + Objects.hashCode(this.faultBitmask);
		return result;
	}

	@Override
	public String toString() {
		return "BatteryStatus{" +
				"id=" + id +
				", batteryFunction=" + batteryFunction +
				", type=" + type +
				", temperature=" + temperature +
				", voltages=" + Arrays.toString(voltages) +
				", currentBattery=" + currentBattery +
				", currentConsumed=" + currentConsumed +
				", energyConsumed=" + energyConsumed +
				", batteryRemaining=" + batteryRemaining +
				", timeRemaining=" + timeRemaining +
				", chargeState=" + chargeState +
				", voltagesExt=" + Arrays.toString(voltagesExt) +
				", mode=" + mode +
				", faultBitmask=" + faultBitmask +
				'}';
	}
}
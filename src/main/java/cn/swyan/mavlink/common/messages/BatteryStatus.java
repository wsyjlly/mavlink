package cn.swyan.mavlink.common.messages;

import cn.swyan.mavlink.annotation.MavlinkMessage;
import cn.swyan.mavlink.annotation.MavlinkMessageParam;
import cn.swyan.mavlink.common.Message;
import cn.swyan.mavlink.common.enums.MavBatteryType;
import cn.swyan.mavlink.common.enums.MavBatteryFunction;
import cn.swyan.mavlink.protocol.ByteArray;
import cn.swyan.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * @Author YSW
 * @Description
 * @Date 2020.11.04 - 03:56
 **********************************/

@MavlinkMessage(
		id = 147,
		messagePayloadLength = 36,
		description = "Battery information"
)
public class BatteryStatus implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1)
	private short id;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, enum0 = MavBatteryFunction.class)
	private short batteryFunction;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, enum0 = MavBatteryType.class)
	private short type;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 4, typeSize = 2, streamLength = 2)
	private short temperature;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 5, typeSize = 2, streamLength = 20)
	private int voltages;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 6, typeSize = 2, streamLength = 2)
	private short currentBattery;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 7, typeSize = 4, streamLength = 4)
	private int currentConsumed;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 8, typeSize = 4, streamLength = 4)
	private int energyConsumed;

	@MavlinkMessageParam(mavlinkType = "int8_t", position = 9, typeSize = 1, streamLength = 1)
	private byte batteryRemaining;

	private final int messagePayloadLength = 36;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public BatteryStatus(short id, short batteryFunction, short type, short temperature, int voltages, short currentBattery, int currentConsumed, int energyConsumed, byte batteryRemaining) {
		this.id = id;
		this.batteryFunction = batteryFunction;
		this.type = type;
		this.temperature = temperature;
		this.voltages = voltages;
		this.currentBattery = currentBattery;
		this.currentConsumed = currentConsumed;
		this.energyConsumed = energyConsumed;
		this.batteryRemaining = batteryRemaining;
	}

	public BatteryStatus(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 36！");
		}
		messagePayload(messagePayload);
	}

	public BatteryStatus(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.id = byteArray.getUnsignedInt8(0);
		this.batteryFunction = byteArray.getUnsignedInt8(1);
		this.type = byteArray.getUnsignedInt8(2);
		this.temperature = byteArray.getInt16(3);
		this.voltages = byteArray.getUnsignedInt16(5);
		this.currentBattery = byteArray.getInt16(7);
		this.currentConsumed = byteArray.getInt32(9);
		this.energyConsumed = byteArray.getInt32(13);
		this.batteryRemaining = byteArray.getInt8(17);
	}

	@Override
	public byte[] messagePayload() {
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

	public final BatteryStatus setVoltages(int voltages) {
		this.voltages = voltages;
		return this;
	}

	public final int getVoltages() {
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
			} else {
				return Objects.deepEquals(this.batteryRemaining, other.batteryRemaining);
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
		return result;
	}

	@Override
	public String toString() {
		return "BatteryStatus{" +
				"id=" + id +
				", batteryFunction=" + batteryFunction +
				", type=" + type +
				", temperature=" + temperature +
				", voltages=" + voltages +
				", currentBattery=" + currentBattery +
				", currentConsumed=" + currentConsumed +
				", energyConsumed=" + energyConsumed +
				", batteryRemaining=" + batteryRemaining +
				'}';
	}
}
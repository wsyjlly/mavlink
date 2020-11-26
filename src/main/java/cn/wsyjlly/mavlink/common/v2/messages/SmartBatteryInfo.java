package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.MavBatteryType;
import cn.wsyjlly.mavlink.common.v2.enums.MavBatteryFunction;
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
		id = 370,
		messagePayloadLength = 75,
		description = "Smart Battery information (static/infrequent update). Use for updates from: smart battery to flight stack, flight stack to GCS. Use BATTERY_STATUS for smart battery frequent updates."
)
public class SmartBatteryInfo implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "Battery ID")
	private short id;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Function of the battery", enum0 = MavBatteryFunction.class)
	private short batteryFunction;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, description = "Type (chemistry) of the battery", enum0 = MavBatteryType.class)
	private short type;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 4, typeSize = 4, streamLength = 4, description = "Capacity when full according to manufacturer, -1: field not provided.", units = "mAh")
	private int capacityFullSpecification;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 5, typeSize = 4, streamLength = 4, description = "Capacity when full (accounting for battery degradation), -1: field not provided.", units = "mAh")
	private int capacityFull;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 6, typeSize = 2, streamLength = 2, description = "Charge/discharge cycle count. -1: field not provided.")
	private int cycleCount;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 7, typeSize = 4, streamLength = 4, description = "Serial number. -1: field not provided.")
	private int serialNumber;

	@MavlinkMessageParam(mavlinkType = "char", position = 8, typeSize = 1, streamLength = 50, description = "Static device name. Encode as manufacturer and product names separated using an underscore.")
	private String deviceName;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 9, typeSize = 2, streamLength = 2, description = "Battery weight. 0: field not provided.", units = "g")
	private int weight;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 10, typeSize = 2, streamLength = 2, description = "Minimum per-cell voltage when discharging. If not supplied set to UINT16_MAX value.", units = "mV")
	private int dischargeMinimumVoltage;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 11, typeSize = 2, streamLength = 2, description = "Minimum per-cell voltage when charging. If not supplied set to UINT16_MAX value.", units = "mV")
	private int chargingMinimumVoltage;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 12, typeSize = 2, streamLength = 2, description = "Minimum per-cell voltage when resting. If not supplied set to UINT16_MAX value.", units = "mV")
	private int restingMinimumVoltage;

	private final int messagePayloadLength = 75;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public SmartBatteryInfo(short id, short batteryFunction, short type, int capacityFullSpecification, int capacityFull, int cycleCount, int serialNumber, String deviceName, int weight, int dischargeMinimumVoltage, int chargingMinimumVoltage, int restingMinimumVoltage) {
		this.id = id;
		this.batteryFunction = batteryFunction;
		this.type = type;
		this.capacityFullSpecification = capacityFullSpecification;
		this.capacityFull = capacityFull;
		this.cycleCount = cycleCount;
		this.serialNumber = serialNumber;
		this.deviceName = deviceName;
		this.weight = weight;
		this.dischargeMinimumVoltage = dischargeMinimumVoltage;
		this.chargingMinimumVoltage = chargingMinimumVoltage;
		this.restingMinimumVoltage = restingMinimumVoltage;
	}

	public SmartBatteryInfo(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 75！");
		}
		messagePayload(messagePayload);
	}

	public SmartBatteryInfo(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		id = byteArray.getUnsignedInt8(0);
		batteryFunction = byteArray.getUnsignedInt8(1);
		type = byteArray.getUnsignedInt8(2);
		capacityFullSpecification = byteArray.getInt32(3);
		capacityFull = byteArray.getInt32(7);
		cycleCount = byteArray.getUnsignedInt16(11);
		serialNumber = byteArray.getInt32(13);
		deviceName = byteArray.getChars(17,50);
		weight = byteArray.getUnsignedInt16(67);
		dischargeMinimumVoltage = byteArray.getUnsignedInt16(69);
		chargingMinimumVoltage = byteArray.getUnsignedInt16(71);
		restingMinimumVoltage = byteArray.getUnsignedInt16(73);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(id,0);
		byteArray.putUnsignedInt8(batteryFunction,1);
		byteArray.putUnsignedInt8(type,2);
		byteArray.putInt32(capacityFullSpecification,3);
		byteArray.putInt32(capacityFull,7);
		byteArray.putUnsignedInt16(cycleCount,11);
		byteArray.putInt32(serialNumber,13);
		byteArray.putChars(deviceName,17);
		byteArray.putUnsignedInt16(weight,67);
		byteArray.putUnsignedInt16(dischargeMinimumVoltage,69);
		byteArray.putUnsignedInt16(chargingMinimumVoltage,71);
		byteArray.putUnsignedInt16(restingMinimumVoltage,73);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final SmartBatteryInfo setId(short id) {
		this.id = id;
		return this;
	}

	public final short getId() {
		return id;
	}

	public final SmartBatteryInfo setBatteryFunction(short batteryFunction) {
		this.batteryFunction = batteryFunction;
		return this;
	}

	public final short getBatteryFunction() {
		return batteryFunction;
	}

	public final SmartBatteryInfo setType(short type) {
		this.type = type;
		return this;
	}

	public final short getType() {
		return type;
	}

	public final SmartBatteryInfo setCapacityFullSpecification(int capacityFullSpecification) {
		this.capacityFullSpecification = capacityFullSpecification;
		return this;
	}

	public final int getCapacityFullSpecification() {
		return capacityFullSpecification;
	}

	public final SmartBatteryInfo setCapacityFull(int capacityFull) {
		this.capacityFull = capacityFull;
		return this;
	}

	public final int getCapacityFull() {
		return capacityFull;
	}

	public final SmartBatteryInfo setCycleCount(int cycleCount) {
		this.cycleCount = cycleCount;
		return this;
	}

	public final int getCycleCount() {
		return cycleCount;
	}

	public final SmartBatteryInfo setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
		return this;
	}

	public final int getSerialNumber() {
		return serialNumber;
	}

	public final SmartBatteryInfo setDeviceName(String deviceName) {
		this.deviceName = deviceName;
		return this;
	}

	public final String getDeviceName() {
		return deviceName;
	}

	public final SmartBatteryInfo setWeight(int weight) {
		this.weight = weight;
		return this;
	}

	public final int getWeight() {
		return weight;
	}

	public final SmartBatteryInfo setDischargeMinimumVoltage(int dischargeMinimumVoltage) {
		this.dischargeMinimumVoltage = dischargeMinimumVoltage;
		return this;
	}

	public final int getDischargeMinimumVoltage() {
		return dischargeMinimumVoltage;
	}

	public final SmartBatteryInfo setChargingMinimumVoltage(int chargingMinimumVoltage) {
		this.chargingMinimumVoltage = chargingMinimumVoltage;
		return this;
	}

	public final int getChargingMinimumVoltage() {
		return chargingMinimumVoltage;
	}

	public final SmartBatteryInfo setRestingMinimumVoltage(int restingMinimumVoltage) {
		this.restingMinimumVoltage = restingMinimumVoltage;
		return this;
	}

	public final int getRestingMinimumVoltage() {
		return restingMinimumVoltage;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			SmartBatteryInfo other = (SmartBatteryInfo)o;
			if (!Objects.deepEquals(this.id, other.id)) {
				return false;
			} else if (!Objects.deepEquals(this.batteryFunction, other.batteryFunction)) {
				return false;
			} else if (!Objects.deepEquals(this.type, other.type)) {
				return false;
			} else if (!Objects.deepEquals(this.capacityFullSpecification, other.capacityFullSpecification)) {
				return false;
			} else if (!Objects.deepEquals(this.capacityFull, other.capacityFull)) {
				return false;
			} else if (!Objects.deepEquals(this.cycleCount, other.cycleCount)) {
				return false;
			} else if (!Objects.deepEquals(this.serialNumber, other.serialNumber)) {
				return false;
			} else if (!Objects.deepEquals(this.deviceName, other.deviceName)) {
				return false;
			} else if (!Objects.deepEquals(this.weight, other.weight)) {
				return false;
			} else if (!Objects.deepEquals(this.dischargeMinimumVoltage, other.dischargeMinimumVoltage)) {
				return false;
			} else if (!Objects.deepEquals(this.chargingMinimumVoltage, other.chargingMinimumVoltage)) {
				return false;
			} else {
				return Objects.deepEquals(this.restingMinimumVoltage, other.restingMinimumVoltage);
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
		result = 31 * result + Objects.hashCode(this.capacityFullSpecification);
		result = 31 * result + Objects.hashCode(this.capacityFull);
		result = 31 * result + Objects.hashCode(this.cycleCount);
		result = 31 * result + Objects.hashCode(this.serialNumber);
		result = 31 * result + Objects.hashCode(this.deviceName);
		result = 31 * result + Objects.hashCode(this.weight);
		result = 31 * result + Objects.hashCode(this.dischargeMinimumVoltage);
		result = 31 * result + Objects.hashCode(this.chargingMinimumVoltage);
		result = 31 * result + Objects.hashCode(this.restingMinimumVoltage);
		return result;
	}

	@Override
	public String toString() {
		return "SmartBatteryInfo{" +
				"id=" + id +
				", batteryFunction=" + batteryFunction +
				", type=" + type +
				", capacityFullSpecification=" + capacityFullSpecification +
				", capacityFull=" + capacityFull +
				", cycleCount=" + cycleCount +
				", serialNumber=" + serialNumber +
				", deviceName=" + deviceName +
				", weight=" + weight +
				", dischargeMinimumVoltage=" + dischargeMinimumVoltage +
				", chargingMinimumVoltage=" + chargingMinimumVoltage +
				", restingMinimumVoltage=" + restingMinimumVoltage +
				'}';
	}
}
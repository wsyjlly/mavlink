package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.MavGeneratorStatusFlag;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
import java.math.BigInteger;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 373,
		messagePayloadLength = 42,
		description = "Telemetry of power generation system. Alternator or mechanical generator."
)
public class GeneratorStatus implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8, description = "Status flags.", enum0 = MavGeneratorStatusFlag.class)
	private BigInteger status;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 2, typeSize = 2, streamLength = 2, description = "Speed of electrical generator or alternator. UINT16_MAX: field not provided.", units = "rpm")
	private int generatorSpeed;

	@MavlinkMessageParam(mavlinkType = "float", position = 3, typeSize = 4, streamLength = 4, description = "Current into/out of battery. Positive for out. Negative for in. NaN: field not provided.", units = "A")
	private float batteryCurrent;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4, description = "Current going to the UAV. If battery current not available this is the DC current from the generator. Positive for out. Negative for in. NaN: field not provided", units = "A")
	private float loadCurrent;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4, description = "The power being generated. NaN: field not provided", units = "W")
	private float powerGenerated;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4, description = "Voltage of the bus seen at the generator, or battery bus if battery bus is controlled by generator and at a different voltage to main bus.", units = "V")
	private float busVoltage;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 7, typeSize = 2, streamLength = 2, description = "The temperature of the rectifier or power converter. INT16_MAX: field not provided.", units = "degC")
	private short rectifierTemperature;

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 4, description = "The target battery current. Positive for out. Negative for in. NaN: field not provided", units = "A")
	private float batCurrentSetpoint;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 9, typeSize = 2, streamLength = 2, description = "The temperature of the mechanical motor, fuel cell core or generator. INT16_MAX: field not provided.", units = "degC")
	private short generatorTemperature;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 10, typeSize = 4, streamLength = 4, description = "Seconds this generator has run since it was rebooted. UINT32_MAX: field not provided.", units = "s")
	private long runtime;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 11, typeSize = 4, streamLength = 4, description = "Seconds until this generator requires maintenance. A negative value indicates maintenance is past-due. INT32_MAX: field not provided.", units = "s")
	private int timeUntilMaintenance;

	private final int messagePayloadLength = 42;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public GeneratorStatus(BigInteger status, int generatorSpeed, float batteryCurrent, float loadCurrent, float powerGenerated, float busVoltage, short rectifierTemperature, float batCurrentSetpoint, short generatorTemperature, long runtime, int timeUntilMaintenance) {
		this.status = status;
		this.generatorSpeed = generatorSpeed;
		this.batteryCurrent = batteryCurrent;
		this.loadCurrent = loadCurrent;
		this.powerGenerated = powerGenerated;
		this.busVoltage = busVoltage;
		this.rectifierTemperature = rectifierTemperature;
		this.batCurrentSetpoint = batCurrentSetpoint;
		this.generatorTemperature = generatorTemperature;
		this.runtime = runtime;
		this.timeUntilMaintenance = timeUntilMaintenance;
	}

	public GeneratorStatus(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 42！");
		}
		messagePayload(messagePayload);
	}

	public GeneratorStatus(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		status = byteArray.getUnsignedInt64(0);
		generatorSpeed = byteArray.getUnsignedInt16(8);
		batteryCurrent = byteArray.getFloat(10);
		loadCurrent = byteArray.getFloat(14);
		powerGenerated = byteArray.getFloat(18);
		busVoltage = byteArray.getFloat(22);
		rectifierTemperature = byteArray.getInt16(26);
		batCurrentSetpoint = byteArray.getFloat(28);
		generatorTemperature = byteArray.getInt16(32);
		runtime = byteArray.getUnsignedInt32(34);
		timeUntilMaintenance = byteArray.getInt32(38);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt64(status,0);
		byteArray.putUnsignedInt16(generatorSpeed,8);
		byteArray.putFloat(batteryCurrent,10);
		byteArray.putFloat(loadCurrent,14);
		byteArray.putFloat(powerGenerated,18);
		byteArray.putFloat(busVoltage,22);
		byteArray.putInt16(rectifierTemperature,26);
		byteArray.putFloat(batCurrentSetpoint,28);
		byteArray.putInt16(generatorTemperature,32);
		byteArray.putUnsignedInt32(runtime,34);
		byteArray.putInt32(timeUntilMaintenance,38);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final GeneratorStatus setStatus(BigInteger status) {
		this.status = status;
		return this;
	}

	public final BigInteger getStatus() {
		return status;
	}

	public final GeneratorStatus setGeneratorSpeed(int generatorSpeed) {
		this.generatorSpeed = generatorSpeed;
		return this;
	}

	public final int getGeneratorSpeed() {
		return generatorSpeed;
	}

	public final GeneratorStatus setBatteryCurrent(float batteryCurrent) {
		this.batteryCurrent = batteryCurrent;
		return this;
	}

	public final float getBatteryCurrent() {
		return batteryCurrent;
	}

	public final GeneratorStatus setLoadCurrent(float loadCurrent) {
		this.loadCurrent = loadCurrent;
		return this;
	}

	public final float getLoadCurrent() {
		return loadCurrent;
	}

	public final GeneratorStatus setPowerGenerated(float powerGenerated) {
		this.powerGenerated = powerGenerated;
		return this;
	}

	public final float getPowerGenerated() {
		return powerGenerated;
	}

	public final GeneratorStatus setBusVoltage(float busVoltage) {
		this.busVoltage = busVoltage;
		return this;
	}

	public final float getBusVoltage() {
		return busVoltage;
	}

	public final GeneratorStatus setRectifierTemperature(short rectifierTemperature) {
		this.rectifierTemperature = rectifierTemperature;
		return this;
	}

	public final short getRectifierTemperature() {
		return rectifierTemperature;
	}

	public final GeneratorStatus setBatCurrentSetpoint(float batCurrentSetpoint) {
		this.batCurrentSetpoint = batCurrentSetpoint;
		return this;
	}

	public final float getBatCurrentSetpoint() {
		return batCurrentSetpoint;
	}

	public final GeneratorStatus setGeneratorTemperature(short generatorTemperature) {
		this.generatorTemperature = generatorTemperature;
		return this;
	}

	public final short getGeneratorTemperature() {
		return generatorTemperature;
	}

	public final GeneratorStatus setRuntime(long runtime) {
		this.runtime = runtime;
		return this;
	}

	public final long getRuntime() {
		return runtime;
	}

	public final GeneratorStatus setTimeUntilMaintenance(int timeUntilMaintenance) {
		this.timeUntilMaintenance = timeUntilMaintenance;
		return this;
	}

	public final int getTimeUntilMaintenance() {
		return timeUntilMaintenance;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			GeneratorStatus other = (GeneratorStatus)o;
			if (!Objects.deepEquals(this.status, other.status)) {
				return false;
			} else if (!Objects.deepEquals(this.generatorSpeed, other.generatorSpeed)) {
				return false;
			} else if (!Objects.deepEquals(this.batteryCurrent, other.batteryCurrent)) {
				return false;
			} else if (!Objects.deepEquals(this.loadCurrent, other.loadCurrent)) {
				return false;
			} else if (!Objects.deepEquals(this.powerGenerated, other.powerGenerated)) {
				return false;
			} else if (!Objects.deepEquals(this.busVoltage, other.busVoltage)) {
				return false;
			} else if (!Objects.deepEquals(this.rectifierTemperature, other.rectifierTemperature)) {
				return false;
			} else if (!Objects.deepEquals(this.batCurrentSetpoint, other.batCurrentSetpoint)) {
				return false;
			} else if (!Objects.deepEquals(this.generatorTemperature, other.generatorTemperature)) {
				return false;
			} else if (!Objects.deepEquals(this.runtime, other.runtime)) {
				return false;
			} else {
				return Objects.deepEquals(this.timeUntilMaintenance, other.timeUntilMaintenance);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.status);
		result = 31 * result + Objects.hashCode(this.generatorSpeed);
		result = 31 * result + Objects.hashCode(this.batteryCurrent);
		result = 31 * result + Objects.hashCode(this.loadCurrent);
		result = 31 * result + Objects.hashCode(this.powerGenerated);
		result = 31 * result + Objects.hashCode(this.busVoltage);
		result = 31 * result + Objects.hashCode(this.rectifierTemperature);
		result = 31 * result + Objects.hashCode(this.batCurrentSetpoint);
		result = 31 * result + Objects.hashCode(this.generatorTemperature);
		result = 31 * result + Objects.hashCode(this.runtime);
		result = 31 * result + Objects.hashCode(this.timeUntilMaintenance);
		return result;
	}

	@Override
	public String toString() {
		return "GeneratorStatus{" +
				"status=" + status +
				", generatorSpeed=" + generatorSpeed +
				", batteryCurrent=" + batteryCurrent +
				", loadCurrent=" + loadCurrent +
				", powerGenerated=" + powerGenerated +
				", busVoltage=" + busVoltage +
				", rectifierTemperature=" + rectifierTemperature +
				", batCurrentSetpoint=" + batCurrentSetpoint +
				", generatorTemperature=" + generatorTemperature +
				", runtime=" + runtime +
				", timeUntilMaintenance=" + timeUntilMaintenance +
				'}';
	}
}
package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 225,
		messagePayloadLength = 65,
		description = "EFI status output"
)
public class EfiStatus implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "EFI health status")
	private short health;

	@MavlinkMessageParam(mavlinkType = "float", position = 2, typeSize = 4, streamLength = 4, description = "ECU index")
	private float ecuIndex;

	@MavlinkMessageParam(mavlinkType = "float", position = 3, typeSize = 4, streamLength = 4, description = "RPM")
	private float rpm;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4, description = "Fuel consumed", units = "g")
	private float fuelConsumed;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4, description = "Fuel flow rate", units = "g/min")
	private float fuelFlow;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4, description = "Engine load", units = "%")
	private float engineLoad;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4, description = "Throttle position", units = "%")
	private float throttlePosition;

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 4, description = "Spark dwell time", units = "ms")
	private float sparkDwellTime;

	@MavlinkMessageParam(mavlinkType = "float", position = 9, typeSize = 4, streamLength = 4, description = "Barometric pressure", units = "kPa")
	private float barometricPressure;

	@MavlinkMessageParam(mavlinkType = "float", position = 10, typeSize = 4, streamLength = 4, description = "Intake manifold pressure(", units = "kPa")
	private float intakeManifoldPressure;

	@MavlinkMessageParam(mavlinkType = "float", position = 11, typeSize = 4, streamLength = 4, description = "Intake manifold temperature", units = "degC")
	private float intakeManifoldTemperature;

	@MavlinkMessageParam(mavlinkType = "float", position = 12, typeSize = 4, streamLength = 4, description = "Cylinder head temperature", units = "degC")
	private float cylinderHeadTemperature;

	@MavlinkMessageParam(mavlinkType = "float", position = 13, typeSize = 4, streamLength = 4, description = "Ignition timing (Crank angle degrees)", units = "deg")
	private float ignitionTiming;

	@MavlinkMessageParam(mavlinkType = "float", position = 14, typeSize = 4, streamLength = 4, description = "Injection time", units = "ms")
	private float injectionTime;

	@MavlinkMessageParam(mavlinkType = "float", position = 15, typeSize = 4, streamLength = 4, description = "Exhaust gas temperature", units = "degC")
	private float exhaustGasTemperature;

	@MavlinkMessageParam(mavlinkType = "float", position = 16, typeSize = 4, streamLength = 4, description = "Output throttle", units = "%")
	private float throttleOut;

	@MavlinkMessageParam(mavlinkType = "float", position = 17, typeSize = 4, streamLength = 4, description = "Pressure/temperature compensation")
	private float ptCompensation;

	private final int messagePayloadLength = 65;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public EfiStatus(short health, float ecuIndex, float rpm, float fuelConsumed, float fuelFlow, float engineLoad, float throttlePosition, float sparkDwellTime, float barometricPressure, float intakeManifoldPressure, float intakeManifoldTemperature, float cylinderHeadTemperature, float ignitionTiming, float injectionTime, float exhaustGasTemperature, float throttleOut, float ptCompensation) {
		this.health = health;
		this.ecuIndex = ecuIndex;
		this.rpm = rpm;
		this.fuelConsumed = fuelConsumed;
		this.fuelFlow = fuelFlow;
		this.engineLoad = engineLoad;
		this.throttlePosition = throttlePosition;
		this.sparkDwellTime = sparkDwellTime;
		this.barometricPressure = barometricPressure;
		this.intakeManifoldPressure = intakeManifoldPressure;
		this.intakeManifoldTemperature = intakeManifoldTemperature;
		this.cylinderHeadTemperature = cylinderHeadTemperature;
		this.ignitionTiming = ignitionTiming;
		this.injectionTime = injectionTime;
		this.exhaustGasTemperature = exhaustGasTemperature;
		this.throttleOut = throttleOut;
		this.ptCompensation = ptCompensation;
	}

	public EfiStatus(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 65！");
		}
		messagePayload(messagePayload);
	}

	public EfiStatus(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		health = byteArray.getUnsignedInt8(0);
		ecuIndex = byteArray.getFloat(1);
		rpm = byteArray.getFloat(5);
		fuelConsumed = byteArray.getFloat(9);
		fuelFlow = byteArray.getFloat(13);
		engineLoad = byteArray.getFloat(17);
		throttlePosition = byteArray.getFloat(21);
		sparkDwellTime = byteArray.getFloat(25);
		barometricPressure = byteArray.getFloat(29);
		intakeManifoldPressure = byteArray.getFloat(33);
		intakeManifoldTemperature = byteArray.getFloat(37);
		cylinderHeadTemperature = byteArray.getFloat(41);
		ignitionTiming = byteArray.getFloat(45);
		injectionTime = byteArray.getFloat(49);
		exhaustGasTemperature = byteArray.getFloat(53);
		throttleOut = byteArray.getFloat(57);
		ptCompensation = byteArray.getFloat(61);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(health,0);
		byteArray.putFloat(ecuIndex,1);
		byteArray.putFloat(rpm,5);
		byteArray.putFloat(fuelConsumed,9);
		byteArray.putFloat(fuelFlow,13);
		byteArray.putFloat(engineLoad,17);
		byteArray.putFloat(throttlePosition,21);
		byteArray.putFloat(sparkDwellTime,25);
		byteArray.putFloat(barometricPressure,29);
		byteArray.putFloat(intakeManifoldPressure,33);
		byteArray.putFloat(intakeManifoldTemperature,37);
		byteArray.putFloat(cylinderHeadTemperature,41);
		byteArray.putFloat(ignitionTiming,45);
		byteArray.putFloat(injectionTime,49);
		byteArray.putFloat(exhaustGasTemperature,53);
		byteArray.putFloat(throttleOut,57);
		byteArray.putFloat(ptCompensation,61);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final EfiStatus setHealth(short health) {
		this.health = health;
		return this;
	}

	public final short getHealth() {
		return health;
	}

	public final EfiStatus setEcuIndex(float ecuIndex) {
		this.ecuIndex = ecuIndex;
		return this;
	}

	public final float getEcuIndex() {
		return ecuIndex;
	}

	public final EfiStatus setRpm(float rpm) {
		this.rpm = rpm;
		return this;
	}

	public final float getRpm() {
		return rpm;
	}

	public final EfiStatus setFuelConsumed(float fuelConsumed) {
		this.fuelConsumed = fuelConsumed;
		return this;
	}

	public final float getFuelConsumed() {
		return fuelConsumed;
	}

	public final EfiStatus setFuelFlow(float fuelFlow) {
		this.fuelFlow = fuelFlow;
		return this;
	}

	public final float getFuelFlow() {
		return fuelFlow;
	}

	public final EfiStatus setEngineLoad(float engineLoad) {
		this.engineLoad = engineLoad;
		return this;
	}

	public final float getEngineLoad() {
		return engineLoad;
	}

	public final EfiStatus setThrottlePosition(float throttlePosition) {
		this.throttlePosition = throttlePosition;
		return this;
	}

	public final float getThrottlePosition() {
		return throttlePosition;
	}

	public final EfiStatus setSparkDwellTime(float sparkDwellTime) {
		this.sparkDwellTime = sparkDwellTime;
		return this;
	}

	public final float getSparkDwellTime() {
		return sparkDwellTime;
	}

	public final EfiStatus setBarometricPressure(float barometricPressure) {
		this.barometricPressure = barometricPressure;
		return this;
	}

	public final float getBarometricPressure() {
		return barometricPressure;
	}

	public final EfiStatus setIntakeManifoldPressure(float intakeManifoldPressure) {
		this.intakeManifoldPressure = intakeManifoldPressure;
		return this;
	}

	public final float getIntakeManifoldPressure() {
		return intakeManifoldPressure;
	}

	public final EfiStatus setIntakeManifoldTemperature(float intakeManifoldTemperature) {
		this.intakeManifoldTemperature = intakeManifoldTemperature;
		return this;
	}

	public final float getIntakeManifoldTemperature() {
		return intakeManifoldTemperature;
	}

	public final EfiStatus setCylinderHeadTemperature(float cylinderHeadTemperature) {
		this.cylinderHeadTemperature = cylinderHeadTemperature;
		return this;
	}

	public final float getCylinderHeadTemperature() {
		return cylinderHeadTemperature;
	}

	public final EfiStatus setIgnitionTiming(float ignitionTiming) {
		this.ignitionTiming = ignitionTiming;
		return this;
	}

	public final float getIgnitionTiming() {
		return ignitionTiming;
	}

	public final EfiStatus setInjectionTime(float injectionTime) {
		this.injectionTime = injectionTime;
		return this;
	}

	public final float getInjectionTime() {
		return injectionTime;
	}

	public final EfiStatus setExhaustGasTemperature(float exhaustGasTemperature) {
		this.exhaustGasTemperature = exhaustGasTemperature;
		return this;
	}

	public final float getExhaustGasTemperature() {
		return exhaustGasTemperature;
	}

	public final EfiStatus setThrottleOut(float throttleOut) {
		this.throttleOut = throttleOut;
		return this;
	}

	public final float getThrottleOut() {
		return throttleOut;
	}

	public final EfiStatus setPtCompensation(float ptCompensation) {
		this.ptCompensation = ptCompensation;
		return this;
	}

	public final float getPtCompensation() {
		return ptCompensation;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			EfiStatus other = (EfiStatus)o;
			if (!Objects.deepEquals(this.health, other.health)) {
				return false;
			} else if (!Objects.deepEquals(this.ecuIndex, other.ecuIndex)) {
				return false;
			} else if (!Objects.deepEquals(this.rpm, other.rpm)) {
				return false;
			} else if (!Objects.deepEquals(this.fuelConsumed, other.fuelConsumed)) {
				return false;
			} else if (!Objects.deepEquals(this.fuelFlow, other.fuelFlow)) {
				return false;
			} else if (!Objects.deepEquals(this.engineLoad, other.engineLoad)) {
				return false;
			} else if (!Objects.deepEquals(this.throttlePosition, other.throttlePosition)) {
				return false;
			} else if (!Objects.deepEquals(this.sparkDwellTime, other.sparkDwellTime)) {
				return false;
			} else if (!Objects.deepEquals(this.barometricPressure, other.barometricPressure)) {
				return false;
			} else if (!Objects.deepEquals(this.intakeManifoldPressure, other.intakeManifoldPressure)) {
				return false;
			} else if (!Objects.deepEquals(this.intakeManifoldTemperature, other.intakeManifoldTemperature)) {
				return false;
			} else if (!Objects.deepEquals(this.cylinderHeadTemperature, other.cylinderHeadTemperature)) {
				return false;
			} else if (!Objects.deepEquals(this.ignitionTiming, other.ignitionTiming)) {
				return false;
			} else if (!Objects.deepEquals(this.injectionTime, other.injectionTime)) {
				return false;
			} else if (!Objects.deepEquals(this.exhaustGasTemperature, other.exhaustGasTemperature)) {
				return false;
			} else if (!Objects.deepEquals(this.throttleOut, other.throttleOut)) {
				return false;
			} else {
				return Objects.deepEquals(this.ptCompensation, other.ptCompensation);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.health);
		result = 31 * result + Objects.hashCode(this.ecuIndex);
		result = 31 * result + Objects.hashCode(this.rpm);
		result = 31 * result + Objects.hashCode(this.fuelConsumed);
		result = 31 * result + Objects.hashCode(this.fuelFlow);
		result = 31 * result + Objects.hashCode(this.engineLoad);
		result = 31 * result + Objects.hashCode(this.throttlePosition);
		result = 31 * result + Objects.hashCode(this.sparkDwellTime);
		result = 31 * result + Objects.hashCode(this.barometricPressure);
		result = 31 * result + Objects.hashCode(this.intakeManifoldPressure);
		result = 31 * result + Objects.hashCode(this.intakeManifoldTemperature);
		result = 31 * result + Objects.hashCode(this.cylinderHeadTemperature);
		result = 31 * result + Objects.hashCode(this.ignitionTiming);
		result = 31 * result + Objects.hashCode(this.injectionTime);
		result = 31 * result + Objects.hashCode(this.exhaustGasTemperature);
		result = 31 * result + Objects.hashCode(this.throttleOut);
		result = 31 * result + Objects.hashCode(this.ptCompensation);
		return result;
	}

	@Override
	public String toString() {
		return "EfiStatus{" +
				"health=" + health +
				", ecuIndex=" + ecuIndex +
				", rpm=" + rpm +
				", fuelConsumed=" + fuelConsumed +
				", fuelFlow=" + fuelFlow +
				", engineLoad=" + engineLoad +
				", throttlePosition=" + throttlePosition +
				", sparkDwellTime=" + sparkDwellTime +
				", barometricPressure=" + barometricPressure +
				", intakeManifoldPressure=" + intakeManifoldPressure +
				", intakeManifoldTemperature=" + intakeManifoldTemperature +
				", cylinderHeadTemperature=" + cylinderHeadTemperature +
				", ignitionTiming=" + ignitionTiming +
				", injectionTime=" + injectionTime +
				", exhaustGasTemperature=" + exhaustGasTemperature +
				", throttleOut=" + throttleOut +
				", ptCompensation=" + ptCompensation +
				'}';
	}
}
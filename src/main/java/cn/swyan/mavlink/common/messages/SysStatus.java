package cn.swyan.mavlink.common.messages;

import cn.swyan.mavlink.annotation.MavlinkMessage;
import cn.swyan.mavlink.annotation.MavlinkMessageParam;
import cn.swyan.mavlink.common.Message;
import cn.swyan.mavlink.protocol.ByteArray;
import cn.swyan.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * @Author YSW
 * @Description
 * @Date 2020.11.04 - 03:56
 **********************************/

@MavlinkMessage(
		id = 1,
		messagePayloadLength = 31,
		description = "The general system state. If the system is following the MAVLink standard, the system state is mainly defined by three orthogonal states/modes: The system mode, which is either LOCKED (motors shut down and locked), MANUAL (system under RC control), GUIDED (system with autonomous position control, position setpoint controlled manually) or AUTO (system guided by path/waypoint planner). The NAV_MODE defined the current flight state: LIFTOFF (often an open-loop maneuver), LANDING, WAYPOINTS or VECTOR. This represents the internal navigation state machine. The system status shows wether the system is currently active or not and if an emergency occured. During the CRITICAL and EMERGENCY states the MAV is still considered to be active, but should start emergency procedures autonomously. After a failure occured it should first move from active to critical to allow manual intervention and then move to emergency after a certain timeout."
)
public class SysStatus implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4)
	private long onboardControlSensorsPresent;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 2, typeSize = 4, streamLength = 4)
	private long onboardControlSensorsEnabled;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 3, typeSize = 4, streamLength = 4)
	private long onboardControlSensorsHealth;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 4, typeSize = 2, streamLength = 2)
	private int load;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 5, typeSize = 2, streamLength = 2)
	private int voltageBattery;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 6, typeSize = 2, streamLength = 2)
	private short currentBattery;

	@MavlinkMessageParam(mavlinkType = "int8_t", position = 7, typeSize = 1, streamLength = 1)
	private byte batteryRemaining;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 8, typeSize = 2, streamLength = 2)
	private int dropRateComm;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 9, typeSize = 2, streamLength = 2)
	private int errorsComm;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 10, typeSize = 2, streamLength = 2)
	private int errorsCount1;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 11, typeSize = 2, streamLength = 2)
	private int errorsCount2;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 12, typeSize = 2, streamLength = 2)
	private int errorsCount3;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 13, typeSize = 2, streamLength = 2)
	private int errorsCount4;

	private final int messagePayloadLength = 31;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public SysStatus(long onboardControlSensorsPresent, long onboardControlSensorsEnabled, long onboardControlSensorsHealth, int load, int voltageBattery, short currentBattery, byte batteryRemaining, int dropRateComm, int errorsComm, int errorsCount1, int errorsCount2, int errorsCount3, int errorsCount4) {
		this.onboardControlSensorsPresent = onboardControlSensorsPresent;
		this.onboardControlSensorsEnabled = onboardControlSensorsEnabled;
		this.onboardControlSensorsHealth = onboardControlSensorsHealth;
		this.load = load;
		this.voltageBattery = voltageBattery;
		this.currentBattery = currentBattery;
		this.batteryRemaining = batteryRemaining;
		this.dropRateComm = dropRateComm;
		this.errorsComm = errorsComm;
		this.errorsCount1 = errorsCount1;
		this.errorsCount2 = errorsCount2;
		this.errorsCount3 = errorsCount3;
		this.errorsCount4 = errorsCount4;
	}

	public SysStatus(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 31！");
		}
		messagePayload(messagePayload);
	}

	public SysStatus(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.onboardControlSensorsPresent = byteArray.getUnsignedInt32(0);
		this.onboardControlSensorsEnabled = byteArray.getUnsignedInt32(4);
		this.onboardControlSensorsHealth = byteArray.getUnsignedInt32(8);
		this.load = byteArray.getUnsignedInt16(12);
		this.voltageBattery = byteArray.getUnsignedInt16(14);
		this.currentBattery = byteArray.getInt16(16);
		this.batteryRemaining = byteArray.getInt8(18);
		this.dropRateComm = byteArray.getUnsignedInt16(19);
		this.errorsComm = byteArray.getUnsignedInt16(21);
		this.errorsCount1 = byteArray.getUnsignedInt16(23);
		this.errorsCount2 = byteArray.getUnsignedInt16(25);
		this.errorsCount3 = byteArray.getUnsignedInt16(27);
		this.errorsCount4 = byteArray.getUnsignedInt16(29);
	}

	@Override
	public byte[] messagePayload() {
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final SysStatus setOnboardControlSensorsPresent(long onboardControlSensorsPresent) {
		this.onboardControlSensorsPresent = onboardControlSensorsPresent;
		return this;
	}

	public final long getOnboardControlSensorsPresent() {
		return onboardControlSensorsPresent;
	}

	public final SysStatus setOnboardControlSensorsEnabled(long onboardControlSensorsEnabled) {
		this.onboardControlSensorsEnabled = onboardControlSensorsEnabled;
		return this;
	}

	public final long getOnboardControlSensorsEnabled() {
		return onboardControlSensorsEnabled;
	}

	public final SysStatus setOnboardControlSensorsHealth(long onboardControlSensorsHealth) {
		this.onboardControlSensorsHealth = onboardControlSensorsHealth;
		return this;
	}

	public final long getOnboardControlSensorsHealth() {
		return onboardControlSensorsHealth;
	}

	public final SysStatus setLoad(int load) {
		this.load = load;
		return this;
	}

	public final int getLoad() {
		return load;
	}

	public final SysStatus setVoltageBattery(int voltageBattery) {
		this.voltageBattery = voltageBattery;
		return this;
	}

	public final int getVoltageBattery() {
		return voltageBattery;
	}

	public final SysStatus setCurrentBattery(short currentBattery) {
		this.currentBattery = currentBattery;
		return this;
	}

	public final short getCurrentBattery() {
		return currentBattery;
	}

	public final SysStatus setBatteryRemaining(byte batteryRemaining) {
		this.batteryRemaining = batteryRemaining;
		return this;
	}

	public final byte getBatteryRemaining() {
		return batteryRemaining;
	}

	public final SysStatus setDropRateComm(int dropRateComm) {
		this.dropRateComm = dropRateComm;
		return this;
	}

	public final int getDropRateComm() {
		return dropRateComm;
	}

	public final SysStatus setErrorsComm(int errorsComm) {
		this.errorsComm = errorsComm;
		return this;
	}

	public final int getErrorsComm() {
		return errorsComm;
	}

	public final SysStatus setErrorsCount1(int errorsCount1) {
		this.errorsCount1 = errorsCount1;
		return this;
	}

	public final int getErrorsCount1() {
		return errorsCount1;
	}

	public final SysStatus setErrorsCount2(int errorsCount2) {
		this.errorsCount2 = errorsCount2;
		return this;
	}

	public final int getErrorsCount2() {
		return errorsCount2;
	}

	public final SysStatus setErrorsCount3(int errorsCount3) {
		this.errorsCount3 = errorsCount3;
		return this;
	}

	public final int getErrorsCount3() {
		return errorsCount3;
	}

	public final SysStatus setErrorsCount4(int errorsCount4) {
		this.errorsCount4 = errorsCount4;
		return this;
	}

	public final int getErrorsCount4() {
		return errorsCount4;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			SysStatus other = (SysStatus)o;
			if (!Objects.deepEquals(this.onboardControlSensorsPresent, other.onboardControlSensorsPresent)) {
				return false;
			} else if (!Objects.deepEquals(this.onboardControlSensorsEnabled, other.onboardControlSensorsEnabled)) {
				return false;
			} else if (!Objects.deepEquals(this.onboardControlSensorsHealth, other.onboardControlSensorsHealth)) {
				return false;
			} else if (!Objects.deepEquals(this.load, other.load)) {
				return false;
			} else if (!Objects.deepEquals(this.voltageBattery, other.voltageBattery)) {
				return false;
			} else if (!Objects.deepEquals(this.currentBattery, other.currentBattery)) {
				return false;
			} else if (!Objects.deepEquals(this.batteryRemaining, other.batteryRemaining)) {
				return false;
			} else if (!Objects.deepEquals(this.dropRateComm, other.dropRateComm)) {
				return false;
			} else if (!Objects.deepEquals(this.errorsComm, other.errorsComm)) {
				return false;
			} else if (!Objects.deepEquals(this.errorsCount1, other.errorsCount1)) {
				return false;
			} else if (!Objects.deepEquals(this.errorsCount2, other.errorsCount2)) {
				return false;
			} else if (!Objects.deepEquals(this.errorsCount3, other.errorsCount3)) {
				return false;
			} else {
				return Objects.deepEquals(this.errorsCount4, other.errorsCount4);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.onboardControlSensorsPresent);
		result = 31 * result + Objects.hashCode(this.onboardControlSensorsEnabled);
		result = 31 * result + Objects.hashCode(this.onboardControlSensorsHealth);
		result = 31 * result + Objects.hashCode(this.load);
		result = 31 * result + Objects.hashCode(this.voltageBattery);
		result = 31 * result + Objects.hashCode(this.currentBattery);
		result = 31 * result + Objects.hashCode(this.batteryRemaining);
		result = 31 * result + Objects.hashCode(this.dropRateComm);
		result = 31 * result + Objects.hashCode(this.errorsComm);
		result = 31 * result + Objects.hashCode(this.errorsCount1);
		result = 31 * result + Objects.hashCode(this.errorsCount2);
		result = 31 * result + Objects.hashCode(this.errorsCount3);
		result = 31 * result + Objects.hashCode(this.errorsCount4);
		return result;
	}

	@Override
	public String toString() {
		return "SysStatus{" +
				"onboardControlSensorsPresent=" + onboardControlSensorsPresent +
				", onboardControlSensorsEnabled=" + onboardControlSensorsEnabled +
				", onboardControlSensorsHealth=" + onboardControlSensorsHealth +
				", load=" + load +
				", voltageBattery=" + voltageBattery +
				", currentBattery=" + currentBattery +
				", batteryRemaining=" + batteryRemaining +
				", dropRateComm=" + dropRateComm +
				", errorsComm=" + errorsComm +
				", errorsCount1=" + errorsCount1 +
				", errorsCount2=" + errorsCount2 +
				", errorsCount3=" + errorsCount3 +
				", errorsCount4=" + errorsCount4 +
				'}';
	}
}
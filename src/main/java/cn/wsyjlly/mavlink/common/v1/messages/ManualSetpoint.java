package cn.wsyjlly.mavlink.common.v1.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:45
 **********************************/

@MavlinkMessage(
		id = 81,
		messagePayloadLength = 22,
		description = "Setpoint in roll, pitch, yaw and thrust from the operator"
)
public class ManualSetpoint implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4, description = "Timestamp in milliseconds since system boot")
	private long timeBootMs;

	@MavlinkMessageParam(mavlinkType = "float", position = 2, typeSize = 4, streamLength = 4, description = "Desired roll rate in radians per second")
	private float roll;

	@MavlinkMessageParam(mavlinkType = "float", position = 3, typeSize = 4, streamLength = 4, description = "Desired pitch rate in radians per second")
	private float pitch;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4, description = "Desired yaw rate in radians per second")
	private float yaw;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4, description = "Collective thrust, normalized to 0 .. 1")
	private float thrust;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 6, typeSize = 1, streamLength = 1, description = "Flight mode switch position, 0.. 255")
	private short modeSwitch;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 7, typeSize = 1, streamLength = 1, description = "Override mode switch position, 0.. 255")
	private short manualOverrideSwitch;

	private final int messagePayloadLength = 22;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public ManualSetpoint(long timeBootMs, float roll, float pitch, float yaw, float thrust, short modeSwitch, short manualOverrideSwitch) {
		this.timeBootMs = timeBootMs;
		this.roll = roll;
		this.pitch = pitch;
		this.yaw = yaw;
		this.thrust = thrust;
		this.modeSwitch = modeSwitch;
		this.manualOverrideSwitch = manualOverrideSwitch;
	}

	public ManualSetpoint(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 22！");
		}
		messagePayload(messagePayload);
	}

	public ManualSetpoint(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeBootMs = byteArray.getUnsignedInt32(0);
		roll = byteArray.getFloat(4);
		pitch = byteArray.getFloat(8);
		yaw = byteArray.getFloat(12);
		thrust = byteArray.getFloat(16);
		modeSwitch = byteArray.getUnsignedInt8(20);
		manualOverrideSwitch = byteArray.getUnsignedInt8(21);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt32(timeBootMs,0);
		byteArray.putFloat(roll,4);
		byteArray.putFloat(pitch,8);
		byteArray.putFloat(yaw,12);
		byteArray.putFloat(thrust,16);
		byteArray.putUnsignedInt8(modeSwitch,20);
		byteArray.putUnsignedInt8(manualOverrideSwitch,21);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final ManualSetpoint setTimeBootMs(long timeBootMs) {
		this.timeBootMs = timeBootMs;
		return this;
	}

	public final long getTimeBootMs() {
		return timeBootMs;
	}

	public final ManualSetpoint setRoll(float roll) {
		this.roll = roll;
		return this;
	}

	public final float getRoll() {
		return roll;
	}

	public final ManualSetpoint setPitch(float pitch) {
		this.pitch = pitch;
		return this;
	}

	public final float getPitch() {
		return pitch;
	}

	public final ManualSetpoint setYaw(float yaw) {
		this.yaw = yaw;
		return this;
	}

	public final float getYaw() {
		return yaw;
	}

	public final ManualSetpoint setThrust(float thrust) {
		this.thrust = thrust;
		return this;
	}

	public final float getThrust() {
		return thrust;
	}

	public final ManualSetpoint setModeSwitch(short modeSwitch) {
		this.modeSwitch = modeSwitch;
		return this;
	}

	public final short getModeSwitch() {
		return modeSwitch;
	}

	public final ManualSetpoint setManualOverrideSwitch(short manualOverrideSwitch) {
		this.manualOverrideSwitch = manualOverrideSwitch;
		return this;
	}

	public final short getManualOverrideSwitch() {
		return manualOverrideSwitch;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			ManualSetpoint other = (ManualSetpoint)o;
			if (!Objects.deepEquals(this.timeBootMs, other.timeBootMs)) {
				return false;
			} else if (!Objects.deepEquals(this.roll, other.roll)) {
				return false;
			} else if (!Objects.deepEquals(this.pitch, other.pitch)) {
				return false;
			} else if (!Objects.deepEquals(this.yaw, other.yaw)) {
				return false;
			} else if (!Objects.deepEquals(this.thrust, other.thrust)) {
				return false;
			} else if (!Objects.deepEquals(this.modeSwitch, other.modeSwitch)) {
				return false;
			} else {
				return Objects.deepEquals(this.manualOverrideSwitch, other.manualOverrideSwitch);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeBootMs);
		result = 31 * result + Objects.hashCode(this.roll);
		result = 31 * result + Objects.hashCode(this.pitch);
		result = 31 * result + Objects.hashCode(this.yaw);
		result = 31 * result + Objects.hashCode(this.thrust);
		result = 31 * result + Objects.hashCode(this.modeSwitch);
		result = 31 * result + Objects.hashCode(this.manualOverrideSwitch);
		return result;
	}

	@Override
	public String toString() {
		return "ManualSetpoint{" +
				"timeBootMs=" + timeBootMs +
				", roll=" + roll +
				", pitch=" + pitch +
				", yaw=" + yaw +
				", thrust=" + thrust +
				", modeSwitch=" + modeSwitch +
				", manualOverrideSwitch=" + manualOverrideSwitch +
				'}';
	}
}
package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.GimbalManagerFlags;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 288,
		messagePayloadLength = 23,
		description = "High level message to control a gimbal manually. The angles or angular rates are unitless; the actual rates will depend on internal gimbal manager settings/configuration (e.g. set by parameters). This message is to be sent to the gimbal manager (e.g. from a ground station). Angles and rates can be set to NaN according to use case."
)
public class GimbalManagerSetManualControl implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "System ID")
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Component ID")
	private short targetComponent;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 3, typeSize = 4, streamLength = 4, description = "High level gimbal manager flags.", enum0 = GimbalManagerFlags.class)
	private long flags;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 1, description = "Component ID of gimbal device to address (or 1-6 for non-MAVLink gimbal), 0 for all gimbal device components. Send command multiple times for more than one gimbal (but not all gimbals).")
	private short gimbalDeviceId;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4, description = "Pitch angle unitless (-1..1, positive: up, negative: down, NaN to be ignored).")
	private float pitch;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4, description = "Yaw angle unitless (-1..1, positive: to the right, negative: to the left, NaN to be ignored).")
	private float yaw;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4, description = "Pitch angular rate unitless (-1..1, positive: up, negative: down, NaN to be ignored).")
	private float pitchRate;

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 4, description = "Yaw angular rate unitless (-1..1, positive: to the right, negative: to the left, NaN to be ignored).")
	private float yawRate;

	private final int messagePayloadLength = 23;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public GimbalManagerSetManualControl(short targetSystem, short targetComponent, long flags, short gimbalDeviceId, float pitch, float yaw, float pitchRate, float yawRate) {
		this.targetSystem = targetSystem;
		this.targetComponent = targetComponent;
		this.flags = flags;
		this.gimbalDeviceId = gimbalDeviceId;
		this.pitch = pitch;
		this.yaw = yaw;
		this.pitchRate = pitchRate;
		this.yawRate = yawRate;
	}

	public GimbalManagerSetManualControl(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 23！");
		}
		messagePayload(messagePayload);
	}

	public GimbalManagerSetManualControl(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		targetSystem = byteArray.getUnsignedInt8(0);
		targetComponent = byteArray.getUnsignedInt8(1);
		flags = byteArray.getUnsignedInt32(2);
		gimbalDeviceId = byteArray.getUnsignedInt8(6);
		pitch = byteArray.getFloat(7);
		yaw = byteArray.getFloat(11);
		pitchRate = byteArray.getFloat(15);
		yawRate = byteArray.getFloat(19);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(targetSystem,0);
		byteArray.putUnsignedInt8(targetComponent,1);
		byteArray.putUnsignedInt32(flags,2);
		byteArray.putUnsignedInt8(gimbalDeviceId,6);
		byteArray.putFloat(pitch,7);
		byteArray.putFloat(yaw,11);
		byteArray.putFloat(pitchRate,15);
		byteArray.putFloat(yawRate,19);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final GimbalManagerSetManualControl setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final GimbalManagerSetManualControl setTargetComponent(short targetComponent) {
		this.targetComponent = targetComponent;
		return this;
	}

	public final short getTargetComponent() {
		return targetComponent;
	}

	public final GimbalManagerSetManualControl setFlags(long flags) {
		this.flags = flags;
		return this;
	}

	public final long getFlags() {
		return flags;
	}

	public final GimbalManagerSetManualControl setGimbalDeviceId(short gimbalDeviceId) {
		this.gimbalDeviceId = gimbalDeviceId;
		return this;
	}

	public final short getGimbalDeviceId() {
		return gimbalDeviceId;
	}

	public final GimbalManagerSetManualControl setPitch(float pitch) {
		this.pitch = pitch;
		return this;
	}

	public final float getPitch() {
		return pitch;
	}

	public final GimbalManagerSetManualControl setYaw(float yaw) {
		this.yaw = yaw;
		return this;
	}

	public final float getYaw() {
		return yaw;
	}

	public final GimbalManagerSetManualControl setPitchRate(float pitchRate) {
		this.pitchRate = pitchRate;
		return this;
	}

	public final float getPitchRate() {
		return pitchRate;
	}

	public final GimbalManagerSetManualControl setYawRate(float yawRate) {
		this.yawRate = yawRate;
		return this;
	}

	public final float getYawRate() {
		return yawRate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			GimbalManagerSetManualControl other = (GimbalManagerSetManualControl)o;
			if (!Objects.deepEquals(this.targetSystem, other.targetSystem)) {
				return false;
			} else if (!Objects.deepEquals(this.targetComponent, other.targetComponent)) {
				return false;
			} else if (!Objects.deepEquals(this.flags, other.flags)) {
				return false;
			} else if (!Objects.deepEquals(this.gimbalDeviceId, other.gimbalDeviceId)) {
				return false;
			} else if (!Objects.deepEquals(this.pitch, other.pitch)) {
				return false;
			} else if (!Objects.deepEquals(this.yaw, other.yaw)) {
				return false;
			} else if (!Objects.deepEquals(this.pitchRate, other.pitchRate)) {
				return false;
			} else {
				return Objects.deepEquals(this.yawRate, other.yawRate);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.targetSystem);
		result = 31 * result + Objects.hashCode(this.targetComponent);
		result = 31 * result + Objects.hashCode(this.flags);
		result = 31 * result + Objects.hashCode(this.gimbalDeviceId);
		result = 31 * result + Objects.hashCode(this.pitch);
		result = 31 * result + Objects.hashCode(this.yaw);
		result = 31 * result + Objects.hashCode(this.pitchRate);
		result = 31 * result + Objects.hashCode(this.yawRate);
		return result;
	}

	@Override
	public String toString() {
		return "GimbalManagerSetManualControl{" +
				"targetSystem=" + targetSystem +
				", targetComponent=" + targetComponent +
				", flags=" + flags +
				", gimbalDeviceId=" + gimbalDeviceId +
				", pitch=" + pitch +
				", yaw=" + yaw +
				", pitchRate=" + pitchRate +
				", yawRate=" + yawRate +
				'}';
	}
}
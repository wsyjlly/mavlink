package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.GimbalDeviceFlags;
import cn.wsyjlly.mavlink.common.v2.enums.GimbalDeviceErrorFlags;
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
		id = 285,
		messagePayloadLength = 40,
		description = "Message reporting the status of a gimbal device. This message should be broadcasted by a gimbal device component. The angles encoded in the quaternion are in the global frame (roll: positive is rolling to the right, pitch: positive is pitching up, yaw is turn to the right). This message should be broadcast at a low regular rate (e.g. 10Hz)."
)
public class GimbalDeviceAttitudeStatus implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "System ID")
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Component ID")
	private short targetComponent;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 3, typeSize = 4, streamLength = 4, description = "Timestamp (time since system boot).", units = "ms")
	private long timeBootMs;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 4, typeSize = 2, streamLength = 2, description = "Current gimbal flags set.", enum0 = GimbalDeviceFlags.class)
	private int flags;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 16, description = "Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation, the frame is depends on whether the flag GIMBAL_DEVICE_FLAGS_YAW_LOCK is set)")
	private float[] q = new float[4];

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4, description = "X component of angular velocity (NaN if unknown)", units = "rad/s")
	private float angularVelocityX;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4, description = "Y component of angular velocity (NaN if unknown)", units = "rad/s")
	private float angularVelocityY;

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 4, description = "Z component of angular velocity (NaN if unknown)", units = "rad/s")
	private float angularVelocityZ;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 9, typeSize = 4, streamLength = 4, description = "Failure flags (0 for no failure)", enum0 = GimbalDeviceErrorFlags.class)
	private long failureFlags;

	private final int messagePayloadLength = 40;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public GimbalDeviceAttitudeStatus(short targetSystem, short targetComponent, long timeBootMs, int flags, float[] q, float angularVelocityX, float angularVelocityY, float angularVelocityZ, long failureFlags) {
		this.targetSystem = targetSystem;
		this.targetComponent = targetComponent;
		this.timeBootMs = timeBootMs;
		this.flags = flags;
		this.q = q;
		this.angularVelocityX = angularVelocityX;
		this.angularVelocityY = angularVelocityY;
		this.angularVelocityZ = angularVelocityZ;
		this.failureFlags = failureFlags;
	}

	public GimbalDeviceAttitudeStatus(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 40！");
		}
		messagePayload(messagePayload);
	}

	public GimbalDeviceAttitudeStatus(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		targetSystem = byteArray.getUnsignedInt8(0);
		targetComponent = byteArray.getUnsignedInt8(1);
		timeBootMs = byteArray.getUnsignedInt32(2);
		flags = byteArray.getUnsignedInt16(6);
		q = byteArray.getFloatArray(8,4);
		angularVelocityX = byteArray.getFloat(24);
		angularVelocityY = byteArray.getFloat(28);
		angularVelocityZ = byteArray.getFloat(32);
		failureFlags = byteArray.getUnsignedInt32(36);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(targetSystem,0);
		byteArray.putUnsignedInt8(targetComponent,1);
		byteArray.putUnsignedInt32(timeBootMs,2);
		byteArray.putUnsignedInt16(flags,6);
		byteArray.putFloatArray(q,8);
		byteArray.putFloat(angularVelocityX,24);
		byteArray.putFloat(angularVelocityY,28);
		byteArray.putFloat(angularVelocityZ,32);
		byteArray.putUnsignedInt32(failureFlags,36);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final GimbalDeviceAttitudeStatus setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final GimbalDeviceAttitudeStatus setTargetComponent(short targetComponent) {
		this.targetComponent = targetComponent;
		return this;
	}

	public final short getTargetComponent() {
		return targetComponent;
	}

	public final GimbalDeviceAttitudeStatus setTimeBootMs(long timeBootMs) {
		this.timeBootMs = timeBootMs;
		return this;
	}

	public final long getTimeBootMs() {
		return timeBootMs;
	}

	public final GimbalDeviceAttitudeStatus setFlags(int flags) {
		this.flags = flags;
		return this;
	}

	public final int getFlags() {
		return flags;
	}

	public final GimbalDeviceAttitudeStatus setQ(float[] q) {
		this.q = q;
		return this;
	}

	public final float[] getQ() {
		return q;
	}

	public final GimbalDeviceAttitudeStatus setAngularVelocityX(float angularVelocityX) {
		this.angularVelocityX = angularVelocityX;
		return this;
	}

	public final float getAngularVelocityX() {
		return angularVelocityX;
	}

	public final GimbalDeviceAttitudeStatus setAngularVelocityY(float angularVelocityY) {
		this.angularVelocityY = angularVelocityY;
		return this;
	}

	public final float getAngularVelocityY() {
		return angularVelocityY;
	}

	public final GimbalDeviceAttitudeStatus setAngularVelocityZ(float angularVelocityZ) {
		this.angularVelocityZ = angularVelocityZ;
		return this;
	}

	public final float getAngularVelocityZ() {
		return angularVelocityZ;
	}

	public final GimbalDeviceAttitudeStatus setFailureFlags(long failureFlags) {
		this.failureFlags = failureFlags;
		return this;
	}

	public final long getFailureFlags() {
		return failureFlags;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			GimbalDeviceAttitudeStatus other = (GimbalDeviceAttitudeStatus)o;
			if (!Objects.deepEquals(this.targetSystem, other.targetSystem)) {
				return false;
			} else if (!Objects.deepEquals(this.targetComponent, other.targetComponent)) {
				return false;
			} else if (!Objects.deepEquals(this.timeBootMs, other.timeBootMs)) {
				return false;
			} else if (!Objects.deepEquals(this.flags, other.flags)) {
				return false;
			} else if (!Objects.deepEquals(this.q, other.q)) {
				return false;
			} else if (!Objects.deepEquals(this.angularVelocityX, other.angularVelocityX)) {
				return false;
			} else if (!Objects.deepEquals(this.angularVelocityY, other.angularVelocityY)) {
				return false;
			} else if (!Objects.deepEquals(this.angularVelocityZ, other.angularVelocityZ)) {
				return false;
			} else {
				return Objects.deepEquals(this.failureFlags, other.failureFlags);
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
		result = 31 * result + Objects.hashCode(this.timeBootMs);
		result = 31 * result + Objects.hashCode(this.flags);
		result = 31 * result + Objects.hashCode(this.q);
		result = 31 * result + Objects.hashCode(this.angularVelocityX);
		result = 31 * result + Objects.hashCode(this.angularVelocityY);
		result = 31 * result + Objects.hashCode(this.angularVelocityZ);
		result = 31 * result + Objects.hashCode(this.failureFlags);
		return result;
	}

	@Override
	public String toString() {
		return "GimbalDeviceAttitudeStatus{" +
				"targetSystem=" + targetSystem +
				", targetComponent=" + targetComponent +
				", timeBootMs=" + timeBootMs +
				", flags=" + flags +
				", q=" + Arrays.toString(q) +
				", angularVelocityX=" + angularVelocityX +
				", angularVelocityY=" + angularVelocityY +
				", angularVelocityZ=" + angularVelocityZ +
				", failureFlags=" + failureFlags +
				'}';
	}
}
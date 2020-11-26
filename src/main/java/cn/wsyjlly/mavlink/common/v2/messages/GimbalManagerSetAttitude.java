package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.GimbalManagerFlags;
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
		id = 282,
		messagePayloadLength = 35,
		description = "High level message to control a gimbal's attitude. This message is to be sent to the gimbal manager (e.g. from a ground station). Angles and rates can be set to NaN according to use case."
)
public class GimbalManagerSetAttitude implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "System ID")
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Component ID")
	private short targetComponent;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 3, typeSize = 4, streamLength = 4, description = "High level gimbal manager flags to use.", enum0 = GimbalManagerFlags.class)
	private long flags;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 1, description = "Component ID of gimbal device to address (or 1-6 for non-MAVLink gimbal), 0 for all gimbal device components. Send command multiple times for more than one gimbal (but not all gimbals).")
	private short gimbalDeviceId;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 16, description = "Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation, the frame is depends on whether the flag GIMBAL_MANAGER_FLAGS_YAW_LOCK is set)")
	private float[] q = new float[4];

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4, description = "X component of angular velocity, positive is rolling to the right, NaN to be ignored.", units = "rad/s")
	private float angularVelocityX;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4, description = "Y component of angular velocity, positive is pitching up, NaN to be ignored.", units = "rad/s")
	private float angularVelocityY;

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 4, description = "Z component of angular velocity, positive is yawing to the right, NaN to be ignored.", units = "rad/s")
	private float angularVelocityZ;

	private final int messagePayloadLength = 35;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public GimbalManagerSetAttitude(short targetSystem, short targetComponent, long flags, short gimbalDeviceId, float[] q, float angularVelocityX, float angularVelocityY, float angularVelocityZ) {
		this.targetSystem = targetSystem;
		this.targetComponent = targetComponent;
		this.flags = flags;
		this.gimbalDeviceId = gimbalDeviceId;
		this.q = q;
		this.angularVelocityX = angularVelocityX;
		this.angularVelocityY = angularVelocityY;
		this.angularVelocityZ = angularVelocityZ;
	}

	public GimbalManagerSetAttitude(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 35！");
		}
		messagePayload(messagePayload);
	}

	public GimbalManagerSetAttitude(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		targetSystem = byteArray.getUnsignedInt8(0);
		targetComponent = byteArray.getUnsignedInt8(1);
		flags = byteArray.getUnsignedInt32(2);
		gimbalDeviceId = byteArray.getUnsignedInt8(6);
		q = byteArray.getFloatArray(7,4);
		angularVelocityX = byteArray.getFloat(23);
		angularVelocityY = byteArray.getFloat(27);
		angularVelocityZ = byteArray.getFloat(31);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(targetSystem,0);
		byteArray.putUnsignedInt8(targetComponent,1);
		byteArray.putUnsignedInt32(flags,2);
		byteArray.putUnsignedInt8(gimbalDeviceId,6);
		byteArray.putFloatArray(q,7);
		byteArray.putFloat(angularVelocityX,23);
		byteArray.putFloat(angularVelocityY,27);
		byteArray.putFloat(angularVelocityZ,31);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final GimbalManagerSetAttitude setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final GimbalManagerSetAttitude setTargetComponent(short targetComponent) {
		this.targetComponent = targetComponent;
		return this;
	}

	public final short getTargetComponent() {
		return targetComponent;
	}

	public final GimbalManagerSetAttitude setFlags(long flags) {
		this.flags = flags;
		return this;
	}

	public final long getFlags() {
		return flags;
	}

	public final GimbalManagerSetAttitude setGimbalDeviceId(short gimbalDeviceId) {
		this.gimbalDeviceId = gimbalDeviceId;
		return this;
	}

	public final short getGimbalDeviceId() {
		return gimbalDeviceId;
	}

	public final GimbalManagerSetAttitude setQ(float[] q) {
		this.q = q;
		return this;
	}

	public final float[] getQ() {
		return q;
	}

	public final GimbalManagerSetAttitude setAngularVelocityX(float angularVelocityX) {
		this.angularVelocityX = angularVelocityX;
		return this;
	}

	public final float getAngularVelocityX() {
		return angularVelocityX;
	}

	public final GimbalManagerSetAttitude setAngularVelocityY(float angularVelocityY) {
		this.angularVelocityY = angularVelocityY;
		return this;
	}

	public final float getAngularVelocityY() {
		return angularVelocityY;
	}

	public final GimbalManagerSetAttitude setAngularVelocityZ(float angularVelocityZ) {
		this.angularVelocityZ = angularVelocityZ;
		return this;
	}

	public final float getAngularVelocityZ() {
		return angularVelocityZ;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			GimbalManagerSetAttitude other = (GimbalManagerSetAttitude)o;
			if (!Objects.deepEquals(this.targetSystem, other.targetSystem)) {
				return false;
			} else if (!Objects.deepEquals(this.targetComponent, other.targetComponent)) {
				return false;
			} else if (!Objects.deepEquals(this.flags, other.flags)) {
				return false;
			} else if (!Objects.deepEquals(this.gimbalDeviceId, other.gimbalDeviceId)) {
				return false;
			} else if (!Objects.deepEquals(this.q, other.q)) {
				return false;
			} else if (!Objects.deepEquals(this.angularVelocityX, other.angularVelocityX)) {
				return false;
			} else if (!Objects.deepEquals(this.angularVelocityY, other.angularVelocityY)) {
				return false;
			} else {
				return Objects.deepEquals(this.angularVelocityZ, other.angularVelocityZ);
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
		result = 31 * result + Objects.hashCode(this.q);
		result = 31 * result + Objects.hashCode(this.angularVelocityX);
		result = 31 * result + Objects.hashCode(this.angularVelocityY);
		result = 31 * result + Objects.hashCode(this.angularVelocityZ);
		return result;
	}

	@Override
	public String toString() {
		return "GimbalManagerSetAttitude{" +
				"targetSystem=" + targetSystem +
				", targetComponent=" + targetComponent +
				", flags=" + flags +
				", gimbalDeviceId=" + gimbalDeviceId +
				", q=" + Arrays.toString(q) +
				", angularVelocityX=" + angularVelocityX +
				", angularVelocityY=" + angularVelocityY +
				", angularVelocityZ=" + angularVelocityZ +
				'}';
	}
}
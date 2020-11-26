package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.GimbalDeviceFlags;
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
		id = 284,
		messagePayloadLength = 32,
		description = "Low level message to control a gimbal device's attitude. This message is to be sent from the gimbal manager to the gimbal device component. Angles and rates can be set to NaN according to use case."
)
public class GimbalDeviceSetAttitude implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "System ID")
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Component ID")
	private short targetComponent;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 3, typeSize = 2, streamLength = 2, description = "Low level gimbal flags.", enum0 = GimbalDeviceFlags.class)
	private int flags;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 16, description = "Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation, the frame is depends on whether the flag GIMBAL_DEVICE_FLAGS_YAW_LOCK is set, set all fields to NaN if only angular velocity should be used)")
	private float[] q = new float[4];

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4, description = "X component of angular velocity, positive is rolling to the right, NaN to be ignored.", units = "rad/s")
	private float angularVelocityX;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4, description = "Y component of angular velocity, positive is pitching up, NaN to be ignored.", units = "rad/s")
	private float angularVelocityY;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4, description = "Z component of angular velocity, positive is yawing to the right, NaN to be ignored.", units = "rad/s")
	private float angularVelocityZ;

	private final int messagePayloadLength = 32;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public GimbalDeviceSetAttitude(short targetSystem, short targetComponent, int flags, float[] q, float angularVelocityX, float angularVelocityY, float angularVelocityZ) {
		this.targetSystem = targetSystem;
		this.targetComponent = targetComponent;
		this.flags = flags;
		this.q = q;
		this.angularVelocityX = angularVelocityX;
		this.angularVelocityY = angularVelocityY;
		this.angularVelocityZ = angularVelocityZ;
	}

	public GimbalDeviceSetAttitude(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 32！");
		}
		messagePayload(messagePayload);
	}

	public GimbalDeviceSetAttitude(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		targetSystem = byteArray.getUnsignedInt8(0);
		targetComponent = byteArray.getUnsignedInt8(1);
		flags = byteArray.getUnsignedInt16(2);
		q = byteArray.getFloatArray(4,4);
		angularVelocityX = byteArray.getFloat(20);
		angularVelocityY = byteArray.getFloat(24);
		angularVelocityZ = byteArray.getFloat(28);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(targetSystem,0);
		byteArray.putUnsignedInt8(targetComponent,1);
		byteArray.putUnsignedInt16(flags,2);
		byteArray.putFloatArray(q,4);
		byteArray.putFloat(angularVelocityX,20);
		byteArray.putFloat(angularVelocityY,24);
		byteArray.putFloat(angularVelocityZ,28);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final GimbalDeviceSetAttitude setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final GimbalDeviceSetAttitude setTargetComponent(short targetComponent) {
		this.targetComponent = targetComponent;
		return this;
	}

	public final short getTargetComponent() {
		return targetComponent;
	}

	public final GimbalDeviceSetAttitude setFlags(int flags) {
		this.flags = flags;
		return this;
	}

	public final int getFlags() {
		return flags;
	}

	public final GimbalDeviceSetAttitude setQ(float[] q) {
		this.q = q;
		return this;
	}

	public final float[] getQ() {
		return q;
	}

	public final GimbalDeviceSetAttitude setAngularVelocityX(float angularVelocityX) {
		this.angularVelocityX = angularVelocityX;
		return this;
	}

	public final float getAngularVelocityX() {
		return angularVelocityX;
	}

	public final GimbalDeviceSetAttitude setAngularVelocityY(float angularVelocityY) {
		this.angularVelocityY = angularVelocityY;
		return this;
	}

	public final float getAngularVelocityY() {
		return angularVelocityY;
	}

	public final GimbalDeviceSetAttitude setAngularVelocityZ(float angularVelocityZ) {
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
			GimbalDeviceSetAttitude other = (GimbalDeviceSetAttitude)o;
			if (!Objects.deepEquals(this.targetSystem, other.targetSystem)) {
				return false;
			} else if (!Objects.deepEquals(this.targetComponent, other.targetComponent)) {
				return false;
			} else if (!Objects.deepEquals(this.flags, other.flags)) {
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
		result = 31 * result + Objects.hashCode(this.q);
		result = 31 * result + Objects.hashCode(this.angularVelocityX);
		result = 31 * result + Objects.hashCode(this.angularVelocityY);
		result = 31 * result + Objects.hashCode(this.angularVelocityZ);
		return result;
	}

	@Override
	public String toString() {
		return "GimbalDeviceSetAttitude{" +
				"targetSystem=" + targetSystem +
				", targetComponent=" + targetComponent +
				", flags=" + flags +
				", q=" + Arrays.toString(q) +
				", angularVelocityX=" + angularVelocityX +
				", angularVelocityY=" + angularVelocityY +
				", angularVelocityZ=" + angularVelocityZ +
				'}';
	}
}
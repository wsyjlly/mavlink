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
		id = 265,
		messagePayloadLength = 20,
		description = "Orientation of a mount"
)
public class MountOrientation implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4, description = "Timestamp (time since system boot).", units = "ms")
	private long timeBootMs;

	@MavlinkMessageParam(mavlinkType = "float", position = 2, typeSize = 4, streamLength = 4, description = "Roll in global frame (set to NaN for invalid).", units = "deg")
	private float roll;

	@MavlinkMessageParam(mavlinkType = "float", position = 3, typeSize = 4, streamLength = 4, description = "Pitch in global frame (set to NaN for invalid).", units = "deg")
	private float pitch;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4, description = "Yaw relative to vehicle (set to NaN for invalid).", units = "deg")
	private float yaw;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4, description = "Yaw in absolute frame relative to Earth's North, north is 0 (set to NaN for invalid).", units = "deg")
	private float yawAbsolute;

	private final int messagePayloadLength = 20;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public MountOrientation(long timeBootMs, float roll, float pitch, float yaw, float yawAbsolute) {
		this.timeBootMs = timeBootMs;
		this.roll = roll;
		this.pitch = pitch;
		this.yaw = yaw;
		this.yawAbsolute = yawAbsolute;
	}

	public MountOrientation(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 20！");
		}
		messagePayload(messagePayload);
	}

	public MountOrientation(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeBootMs = byteArray.getUnsignedInt32(0);
		roll = byteArray.getFloat(4);
		pitch = byteArray.getFloat(8);
		yaw = byteArray.getFloat(12);
		yawAbsolute = byteArray.getFloat(16);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt32(timeBootMs,0);
		byteArray.putFloat(roll,4);
		byteArray.putFloat(pitch,8);
		byteArray.putFloat(yaw,12);
		byteArray.putFloat(yawAbsolute,16);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final MountOrientation setTimeBootMs(long timeBootMs) {
		this.timeBootMs = timeBootMs;
		return this;
	}

	public final long getTimeBootMs() {
		return timeBootMs;
	}

	public final MountOrientation setRoll(float roll) {
		this.roll = roll;
		return this;
	}

	public final float getRoll() {
		return roll;
	}

	public final MountOrientation setPitch(float pitch) {
		this.pitch = pitch;
		return this;
	}

	public final float getPitch() {
		return pitch;
	}

	public final MountOrientation setYaw(float yaw) {
		this.yaw = yaw;
		return this;
	}

	public final float getYaw() {
		return yaw;
	}

	public final MountOrientation setYawAbsolute(float yawAbsolute) {
		this.yawAbsolute = yawAbsolute;
		return this;
	}

	public final float getYawAbsolute() {
		return yawAbsolute;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			MountOrientation other = (MountOrientation)o;
			if (!Objects.deepEquals(this.timeBootMs, other.timeBootMs)) {
				return false;
			} else if (!Objects.deepEquals(this.roll, other.roll)) {
				return false;
			} else if (!Objects.deepEquals(this.pitch, other.pitch)) {
				return false;
			} else if (!Objects.deepEquals(this.yaw, other.yaw)) {
				return false;
			} else {
				return Objects.deepEquals(this.yawAbsolute, other.yawAbsolute);
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
		result = 31 * result + Objects.hashCode(this.yawAbsolute);
		return result;
	}

	@Override
	public String toString() {
		return "MountOrientation{" +
				"timeBootMs=" + timeBootMs +
				", roll=" + roll +
				", pitch=" + pitch +
				", yaw=" + yaw +
				", yawAbsolute=" + yawAbsolute +
				'}';
	}
}
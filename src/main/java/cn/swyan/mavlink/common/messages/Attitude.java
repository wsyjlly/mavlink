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
		id = 30,
		messagePayloadLength = 28,
		description = "The attitude in the aeronautical frame (right-handed, Z-down, X-front, Y-right)."
)
public class Attitude implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4)
	private long timeBootMs;

	@MavlinkMessageParam(mavlinkType = "float", position = 2, typeSize = 4, streamLength = 4)
	private float roll;

	@MavlinkMessageParam(mavlinkType = "float", position = 3, typeSize = 4, streamLength = 4)
	private float pitch;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4)
	private float yaw;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4)
	private float rollspeed;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4)
	private float pitchspeed;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4)
	private float yawspeed;

	private final int messagePayloadLength = 28;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public Attitude(long timeBootMs, float roll, float pitch, float yaw, float rollspeed, float pitchspeed, float yawspeed) {
		this.timeBootMs = timeBootMs;
		this.roll = roll;
		this.pitch = pitch;
		this.yaw = yaw;
		this.rollspeed = rollspeed;
		this.pitchspeed = pitchspeed;
		this.yawspeed = yawspeed;
	}

	public Attitude(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 28！");
		}
		messagePayload(messagePayload);
	}

	public Attitude(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.timeBootMs = byteArray.getUnsignedInt32(0);
		this.roll = byteArray.getFloat(4);
		this.pitch = byteArray.getFloat(8);
		this.yaw = byteArray.getFloat(12);
		this.rollspeed = byteArray.getFloat(16);
		this.pitchspeed = byteArray.getFloat(20);
		this.yawspeed = byteArray.getFloat(24);
	}

	@Override
	public byte[] messagePayload() {
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final Attitude setTimeBootMs(long timeBootMs) {
		this.timeBootMs = timeBootMs;
		return this;
	}

	public final long getTimeBootMs() {
		return timeBootMs;
	}

	public final Attitude setRoll(float roll) {
		this.roll = roll;
		return this;
	}

	public final float getRoll() {
		return roll;
	}

	public final Attitude setPitch(float pitch) {
		this.pitch = pitch;
		return this;
	}

	public final float getPitch() {
		return pitch;
	}

	public final Attitude setYaw(float yaw) {
		this.yaw = yaw;
		return this;
	}

	public final float getYaw() {
		return yaw;
	}

	public final Attitude setRollspeed(float rollspeed) {
		this.rollspeed = rollspeed;
		return this;
	}

	public final float getRollspeed() {
		return rollspeed;
	}

	public final Attitude setPitchspeed(float pitchspeed) {
		this.pitchspeed = pitchspeed;
		return this;
	}

	public final float getPitchspeed() {
		return pitchspeed;
	}

	public final Attitude setYawspeed(float yawspeed) {
		this.yawspeed = yawspeed;
		return this;
	}

	public final float getYawspeed() {
		return yawspeed;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			Attitude other = (Attitude)o;
			if (!Objects.deepEquals(this.timeBootMs, other.timeBootMs)) {
				return false;
			} else if (!Objects.deepEquals(this.roll, other.roll)) {
				return false;
			} else if (!Objects.deepEquals(this.pitch, other.pitch)) {
				return false;
			} else if (!Objects.deepEquals(this.yaw, other.yaw)) {
				return false;
			} else if (!Objects.deepEquals(this.rollspeed, other.rollspeed)) {
				return false;
			} else if (!Objects.deepEquals(this.pitchspeed, other.pitchspeed)) {
				return false;
			} else {
				return Objects.deepEquals(this.yawspeed, other.yawspeed);
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
		result = 31 * result + Objects.hashCode(this.rollspeed);
		result = 31 * result + Objects.hashCode(this.pitchspeed);
		result = 31 * result + Objects.hashCode(this.yawspeed);
		return result;
	}

	@Override
	public String toString() {
		return "Attitude{" +
				"timeBootMs=" + timeBootMs +
				", roll=" + roll +
				", pitch=" + pitch +
				", yaw=" + yaw +
				", rollspeed=" + rollspeed +
				", pitchspeed=" + pitchspeed +
				", yawspeed=" + yawspeed +
				'}';
	}
}
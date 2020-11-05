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
		id = 31,
		messagePayloadLength = 32,
		description = "The attitude in the aeronautical frame (right-handed, Z-down, X-front, Y-right), expressed as quaternion. Quaternion order is w, x, y, z and a zero rotation would be expressed as (1 0 0 0)."
)
public class AttitudeQuaternion implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4)
	private long timeBootMs;

	@MavlinkMessageParam(mavlinkType = "float", position = 2, typeSize = 4, streamLength = 4)
	private float q1;

	@MavlinkMessageParam(mavlinkType = "float", position = 3, typeSize = 4, streamLength = 4)
	private float q2;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4)
	private float q3;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4)
	private float q4;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4)
	private float rollspeed;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4)
	private float pitchspeed;

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 4)
	private float yawspeed;

	private final int messagePayloadLength = 32;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public AttitudeQuaternion(long timeBootMs, float q1, float q2, float q3, float q4, float rollspeed, float pitchspeed, float yawspeed) {
		this.timeBootMs = timeBootMs;
		this.q1 = q1;
		this.q2 = q2;
		this.q3 = q3;
		this.q4 = q4;
		this.rollspeed = rollspeed;
		this.pitchspeed = pitchspeed;
		this.yawspeed = yawspeed;
	}

	public AttitudeQuaternion(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 32！");
		}
		messagePayload(messagePayload);
	}

	public AttitudeQuaternion(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.timeBootMs = byteArray.getUnsignedInt32(0);
		this.q1 = byteArray.getFloat(4);
		this.q2 = byteArray.getFloat(8);
		this.q3 = byteArray.getFloat(12);
		this.q4 = byteArray.getFloat(16);
		this.rollspeed = byteArray.getFloat(20);
		this.pitchspeed = byteArray.getFloat(24);
		this.yawspeed = byteArray.getFloat(28);
	}

	@Override
	public byte[] messagePayload() {
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final AttitudeQuaternion setTimeBootMs(long timeBootMs) {
		this.timeBootMs = timeBootMs;
		return this;
	}

	public final long getTimeBootMs() {
		return timeBootMs;
	}

	public final AttitudeQuaternion setQ1(float q1) {
		this.q1 = q1;
		return this;
	}

	public final float getQ1() {
		return q1;
	}

	public final AttitudeQuaternion setQ2(float q2) {
		this.q2 = q2;
		return this;
	}

	public final float getQ2() {
		return q2;
	}

	public final AttitudeQuaternion setQ3(float q3) {
		this.q3 = q3;
		return this;
	}

	public final float getQ3() {
		return q3;
	}

	public final AttitudeQuaternion setQ4(float q4) {
		this.q4 = q4;
		return this;
	}

	public final float getQ4() {
		return q4;
	}

	public final AttitudeQuaternion setRollspeed(float rollspeed) {
		this.rollspeed = rollspeed;
		return this;
	}

	public final float getRollspeed() {
		return rollspeed;
	}

	public final AttitudeQuaternion setPitchspeed(float pitchspeed) {
		this.pitchspeed = pitchspeed;
		return this;
	}

	public final float getPitchspeed() {
		return pitchspeed;
	}

	public final AttitudeQuaternion setYawspeed(float yawspeed) {
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
			AttitudeQuaternion other = (AttitudeQuaternion)o;
			if (!Objects.deepEquals(this.timeBootMs, other.timeBootMs)) {
				return false;
			} else if (!Objects.deepEquals(this.q1, other.q1)) {
				return false;
			} else if (!Objects.deepEquals(this.q2, other.q2)) {
				return false;
			} else if (!Objects.deepEquals(this.q3, other.q3)) {
				return false;
			} else if (!Objects.deepEquals(this.q4, other.q4)) {
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
		result = 31 * result + Objects.hashCode(this.q1);
		result = 31 * result + Objects.hashCode(this.q2);
		result = 31 * result + Objects.hashCode(this.q3);
		result = 31 * result + Objects.hashCode(this.q4);
		result = 31 * result + Objects.hashCode(this.rollspeed);
		result = 31 * result + Objects.hashCode(this.pitchspeed);
		result = 31 * result + Objects.hashCode(this.yawspeed);
		return result;
	}

	@Override
	public String toString() {
		return "AttitudeQuaternion{" +
				"timeBootMs=" + timeBootMs +
				", q1=" + q1 +
				", q2=" + q2 +
				", q3=" + q3 +
				", q4=" + q4 +
				", rollspeed=" + rollspeed +
				", pitchspeed=" + pitchspeed +
				", yawspeed=" + yawspeed +
				'}';
	}
}
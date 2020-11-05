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
		id = 61,
		messagePayloadLength = 68,
		description = "The attitude in the aeronautical frame (right-handed, Z-down, X-front, Y-right), expressed as quaternion. Quaternion order is w, x, y, z and a zero rotation would be expressed as (1 0 0 0)."
)
public class AttitudeQuaternionCov implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4)
	private long timeBootMs;

	@MavlinkMessageParam(mavlinkType = "float", position = 2, typeSize = 4, streamLength = 16)
	private float q;

	@MavlinkMessageParam(mavlinkType = "float", position = 3, typeSize = 4, streamLength = 4)
	private float rollspeed;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4)
	private float pitchspeed;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4)
	private float yawspeed;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 36)
	private float covariance;

	private final int messagePayloadLength = 68;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public AttitudeQuaternionCov(long timeBootMs, float q, float rollspeed, float pitchspeed, float yawspeed, float covariance) {
		this.timeBootMs = timeBootMs;
		this.q = q;
		this.rollspeed = rollspeed;
		this.pitchspeed = pitchspeed;
		this.yawspeed = yawspeed;
		this.covariance = covariance;
	}

	public AttitudeQuaternionCov(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 68！");
		}
		messagePayload(messagePayload);
	}

	public AttitudeQuaternionCov(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.timeBootMs = byteArray.getUnsignedInt32(0);
		this.q = byteArray.getFloat(4);
		this.rollspeed = byteArray.getFloat(8);
		this.pitchspeed = byteArray.getFloat(12);
		this.yawspeed = byteArray.getFloat(16);
		this.covariance = byteArray.getFloat(20);
	}

	@Override
	public byte[] messagePayload() {
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final AttitudeQuaternionCov setTimeBootMs(long timeBootMs) {
		this.timeBootMs = timeBootMs;
		return this;
	}

	public final long getTimeBootMs() {
		return timeBootMs;
	}

	public final AttitudeQuaternionCov setQ(float q) {
		this.q = q;
		return this;
	}

	public final float getQ() {
		return q;
	}

	public final AttitudeQuaternionCov setRollspeed(float rollspeed) {
		this.rollspeed = rollspeed;
		return this;
	}

	public final float getRollspeed() {
		return rollspeed;
	}

	public final AttitudeQuaternionCov setPitchspeed(float pitchspeed) {
		this.pitchspeed = pitchspeed;
		return this;
	}

	public final float getPitchspeed() {
		return pitchspeed;
	}

	public final AttitudeQuaternionCov setYawspeed(float yawspeed) {
		this.yawspeed = yawspeed;
		return this;
	}

	public final float getYawspeed() {
		return yawspeed;
	}

	public final AttitudeQuaternionCov setCovariance(float covariance) {
		this.covariance = covariance;
		return this;
	}

	public final float getCovariance() {
		return covariance;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			AttitudeQuaternionCov other = (AttitudeQuaternionCov)o;
			if (!Objects.deepEquals(this.timeBootMs, other.timeBootMs)) {
				return false;
			} else if (!Objects.deepEquals(this.q, other.q)) {
				return false;
			} else if (!Objects.deepEquals(this.rollspeed, other.rollspeed)) {
				return false;
			} else if (!Objects.deepEquals(this.pitchspeed, other.pitchspeed)) {
				return false;
			} else if (!Objects.deepEquals(this.yawspeed, other.yawspeed)) {
				return false;
			} else {
				return Objects.deepEquals(this.covariance, other.covariance);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeBootMs);
		result = 31 * result + Objects.hashCode(this.q);
		result = 31 * result + Objects.hashCode(this.rollspeed);
		result = 31 * result + Objects.hashCode(this.pitchspeed);
		result = 31 * result + Objects.hashCode(this.yawspeed);
		result = 31 * result + Objects.hashCode(this.covariance);
		return result;
	}

	@Override
	public String toString() {
		return "AttitudeQuaternionCov{" +
				"timeBootMs=" + timeBootMs +
				", q=" + q +
				", rollspeed=" + rollspeed +
				", pitchspeed=" + pitchspeed +
				", yawspeed=" + yawspeed +
				", covariance=" + covariance +
				'}';
	}
}
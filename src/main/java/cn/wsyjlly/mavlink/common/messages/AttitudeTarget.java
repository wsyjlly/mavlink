package cn.wsyjlly.mavlink.common.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.09 - 03:37
 **********************************/

@MavlinkMessage(
		id = 83,
		messagePayloadLength = 37,
		description = "Set the vehicle attitude and body angular rates."
)
public class AttitudeTarget implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4)
	private long timeBootMs;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1)
	private short typeMask;

	@MavlinkMessageParam(mavlinkType = "float", position = 3, typeSize = 4, streamLength = 16)
	private float q;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4)
	private float bodyRollRate;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4)
	private float bodyPitchRate;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4)
	private float bodyYawRate;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4)
	private float thrust;

	private final int messagePayloadLength = 37;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public AttitudeTarget(long timeBootMs, short typeMask, float q, float bodyRollRate, float bodyPitchRate, float bodyYawRate, float thrust) {
		this.timeBootMs = timeBootMs;
		this.typeMask = typeMask;
		this.q = q;
		this.bodyRollRate = bodyRollRate;
		this.bodyPitchRate = bodyPitchRate;
		this.bodyYawRate = bodyYawRate;
		this.thrust = thrust;
	}

	public AttitudeTarget(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 37！");
		}
		messagePayload(messagePayload);
	}

	public AttitudeTarget(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.timeBootMs = byteArray.getUnsignedInt32(0);
		this.typeMask = byteArray.getUnsignedInt8(4);
		this.q = byteArray.getFloat(5);
		this.bodyRollRate = byteArray.getFloat(9);
		this.bodyPitchRate = byteArray.getFloat(13);
		this.bodyYawRate = byteArray.getFloat(17);
		this.thrust = byteArray.getFloat(21);
	}

	@Override
	public byte[] messagePayload() {
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final AttitudeTarget setTimeBootMs(long timeBootMs) {
		this.timeBootMs = timeBootMs;
		return this;
	}

	public final long getTimeBootMs() {
		return timeBootMs;
	}

	public final AttitudeTarget setTypeMask(short typeMask) {
		this.typeMask = typeMask;
		return this;
	}

	public final short getTypeMask() {
		return typeMask;
	}

	public final AttitudeTarget setQ(float q) {
		this.q = q;
		return this;
	}

	public final float getQ() {
		return q;
	}

	public final AttitudeTarget setBodyRollRate(float bodyRollRate) {
		this.bodyRollRate = bodyRollRate;
		return this;
	}

	public final float getBodyRollRate() {
		return bodyRollRate;
	}

	public final AttitudeTarget setBodyPitchRate(float bodyPitchRate) {
		this.bodyPitchRate = bodyPitchRate;
		return this;
	}

	public final float getBodyPitchRate() {
		return bodyPitchRate;
	}

	public final AttitudeTarget setBodyYawRate(float bodyYawRate) {
		this.bodyYawRate = bodyYawRate;
		return this;
	}

	public final float getBodyYawRate() {
		return bodyYawRate;
	}

	public final AttitudeTarget setThrust(float thrust) {
		this.thrust = thrust;
		return this;
	}

	public final float getThrust() {
		return thrust;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			AttitudeTarget other = (AttitudeTarget)o;
			if (!Objects.deepEquals(this.timeBootMs, other.timeBootMs)) {
				return false;
			} else if (!Objects.deepEquals(this.typeMask, other.typeMask)) {
				return false;
			} else if (!Objects.deepEquals(this.q, other.q)) {
				return false;
			} else if (!Objects.deepEquals(this.bodyRollRate, other.bodyRollRate)) {
				return false;
			} else if (!Objects.deepEquals(this.bodyPitchRate, other.bodyPitchRate)) {
				return false;
			} else if (!Objects.deepEquals(this.bodyYawRate, other.bodyYawRate)) {
				return false;
			} else {
				return Objects.deepEquals(this.thrust, other.thrust);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeBootMs);
		result = 31 * result + Objects.hashCode(this.typeMask);
		result = 31 * result + Objects.hashCode(this.q);
		result = 31 * result + Objects.hashCode(this.bodyRollRate);
		result = 31 * result + Objects.hashCode(this.bodyPitchRate);
		result = 31 * result + Objects.hashCode(this.bodyYawRate);
		result = 31 * result + Objects.hashCode(this.thrust);
		return result;
	}

	@Override
	public String toString() {
		return "AttitudeTarget{" +
				"timeBootMs=" + timeBootMs +
				", typeMask=" + typeMask +
				", q=" + q +
				", bodyRollRate=" + bodyRollRate +
				", bodyPitchRate=" + bodyPitchRate +
				", bodyYawRate=" + bodyYawRate +
				", thrust=" + thrust +
				'}';
	}
}
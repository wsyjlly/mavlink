package cn.wsyjlly.mavlink.common.v1.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
import java.util.Arrays;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:45
 **********************************/

@MavlinkMessage(
		id = 83,
		messagePayloadLength = 37,
		description = "Set the vehicle attitude and body angular rates."
)
public class AttitudeTarget implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4, description = "Timestamp in milliseconds since system boot")
	private long timeBootMs;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Mappings: If any of these bits are set, the corresponding input should be ignored: bit 1: body roll rate, bit 2: body pitch rate, bit 3: body yaw rate. bit 4-bit 7: reserved, bit 8: attitude")
	private short typeMask;

	@MavlinkMessageParam(mavlinkType = "float", position = 3, typeSize = 4, streamLength = 16, description = "Attitude quaternion (w, x, y, z order, zero-rotation is 1, 0, 0, 0)")
	private float[] q = new float[4];

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4, description = "Body roll rate in radians per second")
	private float bodyRollRate;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4, description = "Body roll rate in radians per second")
	private float bodyPitchRate;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4, description = "Body roll rate in radians per second")
	private float bodyYawRate;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4, description = "Collective thrust, normalized to 0 .. 1 (-1 .. 1 for vehicles capable of reverse trust)")
	private float thrust;

	private final int messagePayloadLength = 37;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public AttitudeTarget(long timeBootMs, short typeMask, float[] q, float bodyRollRate, float bodyPitchRate, float bodyYawRate, float thrust) {
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
		timeBootMs = byteArray.getUnsignedInt32(0);
		typeMask = byteArray.getUnsignedInt8(4);
		q = byteArray.getFloatArray(5,4);
		bodyRollRate = byteArray.getFloat(21);
		bodyPitchRate = byteArray.getFloat(25);
		bodyYawRate = byteArray.getFloat(29);
		thrust = byteArray.getFloat(33);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt32(timeBootMs,0);
		byteArray.putUnsignedInt8(typeMask,4);
		byteArray.putFloatArray(q,5);
		byteArray.putFloat(bodyRollRate,21);
		byteArray.putFloat(bodyPitchRate,25);
		byteArray.putFloat(bodyYawRate,29);
		byteArray.putFloat(thrust,33);
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

	public final AttitudeTarget setQ(float[] q) {
		this.q = q;
		return this;
	}

	public final float[] getQ() {
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
				", q=" + Arrays.toString(q) +
				", bodyRollRate=" + bodyRollRate +
				", bodyPitchRate=" + bodyPitchRate +
				", bodyYawRate=" + bodyYawRate +
				", thrust=" + thrust +
				'}';
	}
}
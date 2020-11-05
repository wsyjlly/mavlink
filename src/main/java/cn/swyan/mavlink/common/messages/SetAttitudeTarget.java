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
		id = 82,
		messagePayloadLength = 39,
		description = "Set the vehicle attitude and body angular rates."
)
public class SetAttitudeTarget implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4)
	private long timeBootMs;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1)
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1)
	private short targetComponent;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 1)
	private short typeMask;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 16)
	private float q;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4)
	private float bodyRollRate;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4)
	private float bodyPitchRate;

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 4)
	private float bodyYawRate;

	@MavlinkMessageParam(mavlinkType = "float", position = 9, typeSize = 4, streamLength = 4)
	private float thrust;

	private final int messagePayloadLength = 39;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public SetAttitudeTarget(long timeBootMs, short targetSystem, short targetComponent, short typeMask, float q, float bodyRollRate, float bodyPitchRate, float bodyYawRate, float thrust) {
		this.timeBootMs = timeBootMs;
		this.targetSystem = targetSystem;
		this.targetComponent = targetComponent;
		this.typeMask = typeMask;
		this.q = q;
		this.bodyRollRate = bodyRollRate;
		this.bodyPitchRate = bodyPitchRate;
		this.bodyYawRate = bodyYawRate;
		this.thrust = thrust;
	}

	public SetAttitudeTarget(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 39！");
		}
		messagePayload(messagePayload);
	}

	public SetAttitudeTarget(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.timeBootMs = byteArray.getUnsignedInt32(0);
		this.targetSystem = byteArray.getUnsignedInt8(4);
		this.targetComponent = byteArray.getUnsignedInt8(5);
		this.typeMask = byteArray.getUnsignedInt8(6);
		this.q = byteArray.getFloat(7);
		this.bodyRollRate = byteArray.getFloat(11);
		this.bodyPitchRate = byteArray.getFloat(15);
		this.bodyYawRate = byteArray.getFloat(19);
		this.thrust = byteArray.getFloat(23);
	}

	@Override
	public byte[] messagePayload() {
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final SetAttitudeTarget setTimeBootMs(long timeBootMs) {
		this.timeBootMs = timeBootMs;
		return this;
	}

	public final long getTimeBootMs() {
		return timeBootMs;
	}

	public final SetAttitudeTarget setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final SetAttitudeTarget setTargetComponent(short targetComponent) {
		this.targetComponent = targetComponent;
		return this;
	}

	public final short getTargetComponent() {
		return targetComponent;
	}

	public final SetAttitudeTarget setTypeMask(short typeMask) {
		this.typeMask = typeMask;
		return this;
	}

	public final short getTypeMask() {
		return typeMask;
	}

	public final SetAttitudeTarget setQ(float q) {
		this.q = q;
		return this;
	}

	public final float getQ() {
		return q;
	}

	public final SetAttitudeTarget setBodyRollRate(float bodyRollRate) {
		this.bodyRollRate = bodyRollRate;
		return this;
	}

	public final float getBodyRollRate() {
		return bodyRollRate;
	}

	public final SetAttitudeTarget setBodyPitchRate(float bodyPitchRate) {
		this.bodyPitchRate = bodyPitchRate;
		return this;
	}

	public final float getBodyPitchRate() {
		return bodyPitchRate;
	}

	public final SetAttitudeTarget setBodyYawRate(float bodyYawRate) {
		this.bodyYawRate = bodyYawRate;
		return this;
	}

	public final float getBodyYawRate() {
		return bodyYawRate;
	}

	public final SetAttitudeTarget setThrust(float thrust) {
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
			SetAttitudeTarget other = (SetAttitudeTarget)o;
			if (!Objects.deepEquals(this.timeBootMs, other.timeBootMs)) {
				return false;
			} else if (!Objects.deepEquals(this.targetSystem, other.targetSystem)) {
				return false;
			} else if (!Objects.deepEquals(this.targetComponent, other.targetComponent)) {
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
		result = 31 * result + Objects.hashCode(this.targetSystem);
		result = 31 * result + Objects.hashCode(this.targetComponent);
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
		return "SetAttitudeTarget{" +
				"timeBootMs=" + timeBootMs +
				", targetSystem=" + targetSystem +
				", targetComponent=" + targetComponent +
				", typeMask=" + typeMask +
				", q=" + q +
				", bodyRollRate=" + bodyRollRate +
				", bodyPitchRate=" + bodyPitchRate +
				", bodyYawRate=" + bodyYawRate +
				", thrust=" + thrust +
				'}';
	}
}
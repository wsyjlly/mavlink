package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.MavCollisionSrc;
import cn.wsyjlly.mavlink.common.v2.enums.MavCollisionAction;
import cn.wsyjlly.mavlink.common.v2.enums.MavCollisionThreatLevel;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 247,
		messagePayloadLength = 19,
		description = "Information about a potential collision"
)
public class Collision implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "Collision data source", enum0 = MavCollisionSrc.class)
	private short src;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 2, typeSize = 4, streamLength = 4, description = "Unique identifier, domain based on src field")
	private long id;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, description = "Action that is being taken to avoid this collision", enum0 = MavCollisionAction.class)
	private short action;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 1, description = "How concerned the aircraft is about this collision", enum0 = MavCollisionThreatLevel.class)
	private short threatLevel;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4, description = "Estimated time until collision occurs", units = "s")
	private float timeToMinimumDelta;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4, description = "Closest vertical distance between vehicle and object", units = "m")
	private float altitudeMinimumDelta;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4, description = "Closest horizontal distance between vehicle and object", units = "m")
	private float horizontalMinimumDelta;

	private final int messagePayloadLength = 19;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public Collision(short src, long id, short action, short threatLevel, float timeToMinimumDelta, float altitudeMinimumDelta, float horizontalMinimumDelta) {
		this.src = src;
		this.id = id;
		this.action = action;
		this.threatLevel = threatLevel;
		this.timeToMinimumDelta = timeToMinimumDelta;
		this.altitudeMinimumDelta = altitudeMinimumDelta;
		this.horizontalMinimumDelta = horizontalMinimumDelta;
	}

	public Collision(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 19！");
		}
		messagePayload(messagePayload);
	}

	public Collision(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		src = byteArray.getUnsignedInt8(0);
		id = byteArray.getUnsignedInt32(1);
		action = byteArray.getUnsignedInt8(5);
		threatLevel = byteArray.getUnsignedInt8(6);
		timeToMinimumDelta = byteArray.getFloat(7);
		altitudeMinimumDelta = byteArray.getFloat(11);
		horizontalMinimumDelta = byteArray.getFloat(15);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(src,0);
		byteArray.putUnsignedInt32(id,1);
		byteArray.putUnsignedInt8(action,5);
		byteArray.putUnsignedInt8(threatLevel,6);
		byteArray.putFloat(timeToMinimumDelta,7);
		byteArray.putFloat(altitudeMinimumDelta,11);
		byteArray.putFloat(horizontalMinimumDelta,15);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final Collision setSrc(short src) {
		this.src = src;
		return this;
	}

	public final short getSrc() {
		return src;
	}

	public final Collision setId(long id) {
		this.id = id;
		return this;
	}

	public final long getId() {
		return id;
	}

	public final Collision setAction(short action) {
		this.action = action;
		return this;
	}

	public final short getAction() {
		return action;
	}

	public final Collision setThreatLevel(short threatLevel) {
		this.threatLevel = threatLevel;
		return this;
	}

	public final short getThreatLevel() {
		return threatLevel;
	}

	public final Collision setTimeToMinimumDelta(float timeToMinimumDelta) {
		this.timeToMinimumDelta = timeToMinimumDelta;
		return this;
	}

	public final float getTimeToMinimumDelta() {
		return timeToMinimumDelta;
	}

	public final Collision setAltitudeMinimumDelta(float altitudeMinimumDelta) {
		this.altitudeMinimumDelta = altitudeMinimumDelta;
		return this;
	}

	public final float getAltitudeMinimumDelta() {
		return altitudeMinimumDelta;
	}

	public final Collision setHorizontalMinimumDelta(float horizontalMinimumDelta) {
		this.horizontalMinimumDelta = horizontalMinimumDelta;
		return this;
	}

	public final float getHorizontalMinimumDelta() {
		return horizontalMinimumDelta;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			Collision other = (Collision)o;
			if (!Objects.deepEquals(this.src, other.src)) {
				return false;
			} else if (!Objects.deepEquals(this.id, other.id)) {
				return false;
			} else if (!Objects.deepEquals(this.action, other.action)) {
				return false;
			} else if (!Objects.deepEquals(this.threatLevel, other.threatLevel)) {
				return false;
			} else if (!Objects.deepEquals(this.timeToMinimumDelta, other.timeToMinimumDelta)) {
				return false;
			} else if (!Objects.deepEquals(this.altitudeMinimumDelta, other.altitudeMinimumDelta)) {
				return false;
			} else {
				return Objects.deepEquals(this.horizontalMinimumDelta, other.horizontalMinimumDelta);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.src);
		result = 31 * result + Objects.hashCode(this.id);
		result = 31 * result + Objects.hashCode(this.action);
		result = 31 * result + Objects.hashCode(this.threatLevel);
		result = 31 * result + Objects.hashCode(this.timeToMinimumDelta);
		result = 31 * result + Objects.hashCode(this.altitudeMinimumDelta);
		result = 31 * result + Objects.hashCode(this.horizontalMinimumDelta);
		return result;
	}

	@Override
	public String toString() {
		return "Collision{" +
				"src=" + src +
				", id=" + id +
				", action=" + action +
				", threatLevel=" + threatLevel +
				", timeToMinimumDelta=" + timeToMinimumDelta +
				", altitudeMinimumDelta=" + altitudeMinimumDelta +
				", horizontalMinimumDelta=" + horizontalMinimumDelta +
				'}';
	}
}
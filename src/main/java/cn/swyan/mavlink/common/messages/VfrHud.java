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
		id = 74,
		messagePayloadLength = 20,
		description = "Metrics typically displayed on a HUD for fixed wing aircraft"
)
public class VfrHud implements Message {
	@MavlinkMessageParam(mavlinkType = "float", position = 1, typeSize = 4, streamLength = 4)
	private float airspeed;

	@MavlinkMessageParam(mavlinkType = "float", position = 2, typeSize = 4, streamLength = 4)
	private float groundspeed;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 3, typeSize = 2, streamLength = 2)
	private short heading;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 4, typeSize = 2, streamLength = 2)
	private int throttle;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4)
	private float alt;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4)
	private float climb;

	private final int messagePayloadLength = 20;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public VfrHud(float airspeed, float groundspeed, short heading, int throttle, float alt, float climb) {
		this.airspeed = airspeed;
		this.groundspeed = groundspeed;
		this.heading = heading;
		this.throttle = throttle;
		this.alt = alt;
		this.climb = climb;
	}

	public VfrHud(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 20！");
		}
		messagePayload(messagePayload);
	}

	public VfrHud(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.airspeed = byteArray.getFloat(0);
		this.groundspeed = byteArray.getFloat(4);
		this.heading = byteArray.getInt16(8);
		this.throttle = byteArray.getUnsignedInt16(10);
		this.alt = byteArray.getFloat(12);
		this.climb = byteArray.getFloat(16);
	}

	@Override
	public byte[] messagePayload() {
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final VfrHud setAirspeed(float airspeed) {
		this.airspeed = airspeed;
		return this;
	}

	public final float getAirspeed() {
		return airspeed;
	}

	public final VfrHud setGroundspeed(float groundspeed) {
		this.groundspeed = groundspeed;
		return this;
	}

	public final float getGroundspeed() {
		return groundspeed;
	}

	public final VfrHud setHeading(short heading) {
		this.heading = heading;
		return this;
	}

	public final short getHeading() {
		return heading;
	}

	public final VfrHud setThrottle(int throttle) {
		this.throttle = throttle;
		return this;
	}

	public final int getThrottle() {
		return throttle;
	}

	public final VfrHud setAlt(float alt) {
		this.alt = alt;
		return this;
	}

	public final float getAlt() {
		return alt;
	}

	public final VfrHud setClimb(float climb) {
		this.climb = climb;
		return this;
	}

	public final float getClimb() {
		return climb;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			VfrHud other = (VfrHud)o;
			if (!Objects.deepEquals(this.airspeed, other.airspeed)) {
				return false;
			} else if (!Objects.deepEquals(this.groundspeed, other.groundspeed)) {
				return false;
			} else if (!Objects.deepEquals(this.heading, other.heading)) {
				return false;
			} else if (!Objects.deepEquals(this.throttle, other.throttle)) {
				return false;
			} else if (!Objects.deepEquals(this.alt, other.alt)) {
				return false;
			} else {
				return Objects.deepEquals(this.climb, other.climb);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.airspeed);
		result = 31 * result + Objects.hashCode(this.groundspeed);
		result = 31 * result + Objects.hashCode(this.heading);
		result = 31 * result + Objects.hashCode(this.throttle);
		result = 31 * result + Objects.hashCode(this.alt);
		result = 31 * result + Objects.hashCode(this.climb);
		return result;
	}

	@Override
	public String toString() {
		return "VfrHud{" +
				"airspeed=" + airspeed +
				", groundspeed=" + groundspeed +
				", heading=" + heading +
				", throttle=" + throttle +
				", alt=" + alt +
				", climb=" + climb +
				'}';
	}
}
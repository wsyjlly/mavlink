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
		id = 74,
		messagePayloadLength = 20,
		description = "Metrics typically displayed on a HUD for fixed wing aircraft."
)
public class VfrHud implements Message {
	@MavlinkMessageParam(mavlinkType = "float", position = 1, typeSize = 4, streamLength = 4, description = "Vehicle speed in form appropriate for vehicle type. For standard aircraft this is typically calibrated airspeed (CAS) or indicated airspeed (IAS) - either of which can be used by a pilot to estimate stall speed.", units = "m/s")
	private float airspeed;

	@MavlinkMessageParam(mavlinkType = "float", position = 2, typeSize = 4, streamLength = 4, description = "Current ground speed.", units = "m/s")
	private float groundspeed;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 3, typeSize = 2, streamLength = 2, description = "Current heading in compass units (0-360, 0=north).", units = "deg")
	private short heading;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 4, typeSize = 2, streamLength = 2, description = "Current throttle setting (0 to 100).", units = "%")
	private int throttle;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4, description = "Current altitude (MSL).", units = "m")
	private float alt;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4, description = "Current climb rate.", units = "m/s")
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
		airspeed = byteArray.getFloat(0);
		groundspeed = byteArray.getFloat(4);
		heading = byteArray.getInt16(8);
		throttle = byteArray.getUnsignedInt16(10);
		alt = byteArray.getFloat(12);
		climb = byteArray.getFloat(16);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putFloat(airspeed,0);
		byteArray.putFloat(groundspeed,4);
		byteArray.putInt16(heading,8);
		byteArray.putUnsignedInt16(throttle,10);
		byteArray.putFloat(alt,12);
		byteArray.putFloat(climb,16);
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
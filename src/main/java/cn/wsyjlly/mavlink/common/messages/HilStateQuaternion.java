package cn.wsyjlly.mavlink.common.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
import java.math.BigInteger;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.09 - 03:37
 **********************************/

@MavlinkMessage(
		id = 115,
		messagePayloadLength = 64,
		description = "Sent from simulation to autopilot, avoids in contrast to HIL_STATE singularities. This packet is useful for high throughput applications such as hardware in the loop simulations."
)
public class HilStateQuaternion implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8)
	private BigInteger timeUsec;

	@MavlinkMessageParam(mavlinkType = "float", position = 2, typeSize = 4, streamLength = 16)
	private float attitudeQuaternion;

	@MavlinkMessageParam(mavlinkType = "float", position = 3, typeSize = 4, streamLength = 4)
	private float rollspeed;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4)
	private float pitchspeed;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4)
	private float yawspeed;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 6, typeSize = 4, streamLength = 4)
	private int lat;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 7, typeSize = 4, streamLength = 4)
	private int lon;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 8, typeSize = 4, streamLength = 4)
	private int alt;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 9, typeSize = 2, streamLength = 2)
	private short vx;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 10, typeSize = 2, streamLength = 2)
	private short vy;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 11, typeSize = 2, streamLength = 2)
	private short vz;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 12, typeSize = 2, streamLength = 2)
	private int indAirspeed;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 13, typeSize = 2, streamLength = 2)
	private int trueAirspeed;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 14, typeSize = 2, streamLength = 2)
	private short xacc;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 15, typeSize = 2, streamLength = 2)
	private short yacc;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 16, typeSize = 2, streamLength = 2)
	private short zacc;

	private final int messagePayloadLength = 64;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public HilStateQuaternion(BigInteger timeUsec, float attitudeQuaternion, float rollspeed, float pitchspeed, float yawspeed, int lat, int lon, int alt, short vx, short vy, short vz, int indAirspeed, int trueAirspeed, short xacc, short yacc, short zacc) {
		this.timeUsec = timeUsec;
		this.attitudeQuaternion = attitudeQuaternion;
		this.rollspeed = rollspeed;
		this.pitchspeed = pitchspeed;
		this.yawspeed = yawspeed;
		this.lat = lat;
		this.lon = lon;
		this.alt = alt;
		this.vx = vx;
		this.vy = vy;
		this.vz = vz;
		this.indAirspeed = indAirspeed;
		this.trueAirspeed = trueAirspeed;
		this.xacc = xacc;
		this.yacc = yacc;
		this.zacc = zacc;
	}

	public HilStateQuaternion(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 64！");
		}
		messagePayload(messagePayload);
	}

	public HilStateQuaternion(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.timeUsec = byteArray.getUnsignedInt64(0);
		this.attitudeQuaternion = byteArray.getFloat(8);
		this.rollspeed = byteArray.getFloat(12);
		this.pitchspeed = byteArray.getFloat(16);
		this.yawspeed = byteArray.getFloat(20);
		this.lat = byteArray.getInt32(24);
		this.lon = byteArray.getInt32(28);
		this.alt = byteArray.getInt32(32);
		this.vx = byteArray.getInt16(36);
		this.vy = byteArray.getInt16(38);
		this.vz = byteArray.getInt16(40);
		this.indAirspeed = byteArray.getUnsignedInt16(42);
		this.trueAirspeed = byteArray.getUnsignedInt16(44);
		this.xacc = byteArray.getInt16(46);
		this.yacc = byteArray.getInt16(48);
		this.zacc = byteArray.getInt16(50);
	}

	@Override
	public byte[] messagePayload() {
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final HilStateQuaternion setTimeUsec(BigInteger timeUsec) {
		this.timeUsec = timeUsec;
		return this;
	}

	public final BigInteger getTimeUsec() {
		return timeUsec;
	}

	public final HilStateQuaternion setAttitudeQuaternion(float attitudeQuaternion) {
		this.attitudeQuaternion = attitudeQuaternion;
		return this;
	}

	public final float getAttitudeQuaternion() {
		return attitudeQuaternion;
	}

	public final HilStateQuaternion setRollspeed(float rollspeed) {
		this.rollspeed = rollspeed;
		return this;
	}

	public final float getRollspeed() {
		return rollspeed;
	}

	public final HilStateQuaternion setPitchspeed(float pitchspeed) {
		this.pitchspeed = pitchspeed;
		return this;
	}

	public final float getPitchspeed() {
		return pitchspeed;
	}

	public final HilStateQuaternion setYawspeed(float yawspeed) {
		this.yawspeed = yawspeed;
		return this;
	}

	public final float getYawspeed() {
		return yawspeed;
	}

	public final HilStateQuaternion setLat(int lat) {
		this.lat = lat;
		return this;
	}

	public final int getLat() {
		return lat;
	}

	public final HilStateQuaternion setLon(int lon) {
		this.lon = lon;
		return this;
	}

	public final int getLon() {
		return lon;
	}

	public final HilStateQuaternion setAlt(int alt) {
		this.alt = alt;
		return this;
	}

	public final int getAlt() {
		return alt;
	}

	public final HilStateQuaternion setVx(short vx) {
		this.vx = vx;
		return this;
	}

	public final short getVx() {
		return vx;
	}

	public final HilStateQuaternion setVy(short vy) {
		this.vy = vy;
		return this;
	}

	public final short getVy() {
		return vy;
	}

	public final HilStateQuaternion setVz(short vz) {
		this.vz = vz;
		return this;
	}

	public final short getVz() {
		return vz;
	}

	public final HilStateQuaternion setIndAirspeed(int indAirspeed) {
		this.indAirspeed = indAirspeed;
		return this;
	}

	public final int getIndAirspeed() {
		return indAirspeed;
	}

	public final HilStateQuaternion setTrueAirspeed(int trueAirspeed) {
		this.trueAirspeed = trueAirspeed;
		return this;
	}

	public final int getTrueAirspeed() {
		return trueAirspeed;
	}

	public final HilStateQuaternion setXacc(short xacc) {
		this.xacc = xacc;
		return this;
	}

	public final short getXacc() {
		return xacc;
	}

	public final HilStateQuaternion setYacc(short yacc) {
		this.yacc = yacc;
		return this;
	}

	public final short getYacc() {
		return yacc;
	}

	public final HilStateQuaternion setZacc(short zacc) {
		this.zacc = zacc;
		return this;
	}

	public final short getZacc() {
		return zacc;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			HilStateQuaternion other = (HilStateQuaternion)o;
			if (!Objects.deepEquals(this.timeUsec, other.timeUsec)) {
				return false;
			} else if (!Objects.deepEquals(this.attitudeQuaternion, other.attitudeQuaternion)) {
				return false;
			} else if (!Objects.deepEquals(this.rollspeed, other.rollspeed)) {
				return false;
			} else if (!Objects.deepEquals(this.pitchspeed, other.pitchspeed)) {
				return false;
			} else if (!Objects.deepEquals(this.yawspeed, other.yawspeed)) {
				return false;
			} else if (!Objects.deepEquals(this.lat, other.lat)) {
				return false;
			} else if (!Objects.deepEquals(this.lon, other.lon)) {
				return false;
			} else if (!Objects.deepEquals(this.alt, other.alt)) {
				return false;
			} else if (!Objects.deepEquals(this.vx, other.vx)) {
				return false;
			} else if (!Objects.deepEquals(this.vy, other.vy)) {
				return false;
			} else if (!Objects.deepEquals(this.vz, other.vz)) {
				return false;
			} else if (!Objects.deepEquals(this.indAirspeed, other.indAirspeed)) {
				return false;
			} else if (!Objects.deepEquals(this.trueAirspeed, other.trueAirspeed)) {
				return false;
			} else if (!Objects.deepEquals(this.xacc, other.xacc)) {
				return false;
			} else if (!Objects.deepEquals(this.yacc, other.yacc)) {
				return false;
			} else {
				return Objects.deepEquals(this.zacc, other.zacc);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeUsec);
		result = 31 * result + Objects.hashCode(this.attitudeQuaternion);
		result = 31 * result + Objects.hashCode(this.rollspeed);
		result = 31 * result + Objects.hashCode(this.pitchspeed);
		result = 31 * result + Objects.hashCode(this.yawspeed);
		result = 31 * result + Objects.hashCode(this.lat);
		result = 31 * result + Objects.hashCode(this.lon);
		result = 31 * result + Objects.hashCode(this.alt);
		result = 31 * result + Objects.hashCode(this.vx);
		result = 31 * result + Objects.hashCode(this.vy);
		result = 31 * result + Objects.hashCode(this.vz);
		result = 31 * result + Objects.hashCode(this.indAirspeed);
		result = 31 * result + Objects.hashCode(this.trueAirspeed);
		result = 31 * result + Objects.hashCode(this.xacc);
		result = 31 * result + Objects.hashCode(this.yacc);
		result = 31 * result + Objects.hashCode(this.zacc);
		return result;
	}

	@Override
	public String toString() {
		return "HilStateQuaternion{" +
				"timeUsec=" + timeUsec +
				", attitudeQuaternion=" + attitudeQuaternion +
				", rollspeed=" + rollspeed +
				", pitchspeed=" + pitchspeed +
				", yawspeed=" + yawspeed +
				", lat=" + lat +
				", lon=" + lon +
				", alt=" + alt +
				", vx=" + vx +
				", vy=" + vy +
				", vz=" + vz +
				", indAirspeed=" + indAirspeed +
				", trueAirspeed=" + trueAirspeed +
				", xacc=" + xacc +
				", yacc=" + yacc +
				", zacc=" + zacc +
				'}';
	}
}
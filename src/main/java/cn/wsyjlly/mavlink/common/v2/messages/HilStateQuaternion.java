package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
import java.util.Arrays;
import java.math.BigInteger;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 115,
		messagePayloadLength = 64,
		description = "Sent from simulation to autopilot, avoids in contrast to HIL_STATE singularities. This packet is useful for high throughput applications such as hardware in the loop simulations."
)
public class HilStateQuaternion implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8, description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.", units = "us")
	private BigInteger timeUsec;

	@MavlinkMessageParam(mavlinkType = "float", position = 2, typeSize = 4, streamLength = 16, description = "Vehicle attitude expressed as normalized quaternion in w, x, y, z order (with 1 0 0 0 being the null-rotation)")
	private float[] attitudeQuaternion = new float[4];

	@MavlinkMessageParam(mavlinkType = "float", position = 3, typeSize = 4, streamLength = 4, description = "Body frame roll / phi angular speed", units = "rad/s")
	private float rollspeed;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4, description = "Body frame pitch / theta angular speed", units = "rad/s")
	private float pitchspeed;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4, description = "Body frame yaw / psi angular speed", units = "rad/s")
	private float yawspeed;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 6, typeSize = 4, streamLength = 4, description = "Latitude", units = "degE7")
	private int lat;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 7, typeSize = 4, streamLength = 4, description = "Longitude", units = "degE7")
	private int lon;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 8, typeSize = 4, streamLength = 4, description = "Altitude", units = "mm")
	private int alt;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 9, typeSize = 2, streamLength = 2, description = "Ground X Speed (Latitude)", units = "cm/s")
	private short vx;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 10, typeSize = 2, streamLength = 2, description = "Ground Y Speed (Longitude)", units = "cm/s")
	private short vy;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 11, typeSize = 2, streamLength = 2, description = "Ground Z Speed (Altitude)", units = "cm/s")
	private short vz;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 12, typeSize = 2, streamLength = 2, description = "Indicated airspeed", units = "cm/s")
	private int indAirspeed;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 13, typeSize = 2, streamLength = 2, description = "True airspeed", units = "cm/s")
	private int trueAirspeed;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 14, typeSize = 2, streamLength = 2, description = "X acceleration", units = "mG")
	private short xacc;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 15, typeSize = 2, streamLength = 2, description = "Y acceleration", units = "mG")
	private short yacc;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 16, typeSize = 2, streamLength = 2, description = "Z acceleration", units = "mG")
	private short zacc;

	private final int messagePayloadLength = 64;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public HilStateQuaternion(BigInteger timeUsec, float[] attitudeQuaternion, float rollspeed, float pitchspeed, float yawspeed, int lat, int lon, int alt, short vx, short vy, short vz, int indAirspeed, int trueAirspeed, short xacc, short yacc, short zacc) {
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
		timeUsec = byteArray.getUnsignedInt64(0);
		attitudeQuaternion = byteArray.getFloatArray(8,4);
		rollspeed = byteArray.getFloat(24);
		pitchspeed = byteArray.getFloat(28);
		yawspeed = byteArray.getFloat(32);
		lat = byteArray.getInt32(36);
		lon = byteArray.getInt32(40);
		alt = byteArray.getInt32(44);
		vx = byteArray.getInt16(48);
		vy = byteArray.getInt16(50);
		vz = byteArray.getInt16(52);
		indAirspeed = byteArray.getUnsignedInt16(54);
		trueAirspeed = byteArray.getUnsignedInt16(56);
		xacc = byteArray.getInt16(58);
		yacc = byteArray.getInt16(60);
		zacc = byteArray.getInt16(62);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt64(timeUsec,0);
		byteArray.putFloatArray(attitudeQuaternion,8);
		byteArray.putFloat(rollspeed,24);
		byteArray.putFloat(pitchspeed,28);
		byteArray.putFloat(yawspeed,32);
		byteArray.putInt32(lat,36);
		byteArray.putInt32(lon,40);
		byteArray.putInt32(alt,44);
		byteArray.putInt16(vx,48);
		byteArray.putInt16(vy,50);
		byteArray.putInt16(vz,52);
		byteArray.putUnsignedInt16(indAirspeed,54);
		byteArray.putUnsignedInt16(trueAirspeed,56);
		byteArray.putInt16(xacc,58);
		byteArray.putInt16(yacc,60);
		byteArray.putInt16(zacc,62);
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

	public final HilStateQuaternion setAttitudeQuaternion(float[] attitudeQuaternion) {
		this.attitudeQuaternion = attitudeQuaternion;
		return this;
	}

	public final float[] getAttitudeQuaternion() {
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
				", attitudeQuaternion=" + Arrays.toString(attitudeQuaternion) +
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
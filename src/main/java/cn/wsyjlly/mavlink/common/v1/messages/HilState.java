package cn.wsyjlly.mavlink.common.v1.messages;

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
 * Date 2020.11.26 - 02:45
 **********************************/

@MavlinkMessage(
		id = 90,
		messagePayloadLength = 56,
		description = "DEPRECATED PACKET! Suffers from missing airspeed fields and singularities due to Euler angles. Please use HIL_STATE_QUATERNION instead. Sent from simulation to autopilot. This packet is useful for high throughput applications such as hardware in the loop simulations."
)
public class HilState implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8, description = "Timestamp (microseconds since UNIX epoch or microseconds since system boot)")
	private BigInteger timeUsec;

	@MavlinkMessageParam(mavlinkType = "float", position = 2, typeSize = 4, streamLength = 4, description = "Roll angle (rad)")
	private float roll;

	@MavlinkMessageParam(mavlinkType = "float", position = 3, typeSize = 4, streamLength = 4, description = "Pitch angle (rad)")
	private float pitch;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4, description = "Yaw angle (rad)")
	private float yaw;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4, description = "Body frame roll / phi angular speed (rad/s)")
	private float rollspeed;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4, description = "Body frame pitch / theta angular speed (rad/s)")
	private float pitchspeed;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4, description = "Body frame yaw / psi angular speed (rad/s)")
	private float yawspeed;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 8, typeSize = 4, streamLength = 4, description = "Latitude, expressed as * 1E7")
	private int lat;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 9, typeSize = 4, streamLength = 4, description = "Longitude, expressed as * 1E7")
	private int lon;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 10, typeSize = 4, streamLength = 4, description = "Altitude in meters, expressed as * 1000 (millimeters)")
	private int alt;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 11, typeSize = 2, streamLength = 2, description = "Ground X Speed (Latitude), expressed as m/s * 100")
	private short vx;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 12, typeSize = 2, streamLength = 2, description = "Ground Y Speed (Longitude), expressed as m/s * 100")
	private short vy;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 13, typeSize = 2, streamLength = 2, description = "Ground Z Speed (Altitude), expressed as m/s * 100")
	private short vz;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 14, typeSize = 2, streamLength = 2, description = "X acceleration (mg)")
	private short xacc;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 15, typeSize = 2, streamLength = 2, description = "Y acceleration (mg)")
	private short yacc;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 16, typeSize = 2, streamLength = 2, description = "Z acceleration (mg)")
	private short zacc;

	private final int messagePayloadLength = 56;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public HilState(BigInteger timeUsec, float roll, float pitch, float yaw, float rollspeed, float pitchspeed, float yawspeed, int lat, int lon, int alt, short vx, short vy, short vz, short xacc, short yacc, short zacc) {
		this.timeUsec = timeUsec;
		this.roll = roll;
		this.pitch = pitch;
		this.yaw = yaw;
		this.rollspeed = rollspeed;
		this.pitchspeed = pitchspeed;
		this.yawspeed = yawspeed;
		this.lat = lat;
		this.lon = lon;
		this.alt = alt;
		this.vx = vx;
		this.vy = vy;
		this.vz = vz;
		this.xacc = xacc;
		this.yacc = yacc;
		this.zacc = zacc;
	}

	public HilState(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 56！");
		}
		messagePayload(messagePayload);
	}

	public HilState(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeUsec = byteArray.getUnsignedInt64(0);
		roll = byteArray.getFloat(8);
		pitch = byteArray.getFloat(12);
		yaw = byteArray.getFloat(16);
		rollspeed = byteArray.getFloat(20);
		pitchspeed = byteArray.getFloat(24);
		yawspeed = byteArray.getFloat(28);
		lat = byteArray.getInt32(32);
		lon = byteArray.getInt32(36);
		alt = byteArray.getInt32(40);
		vx = byteArray.getInt16(44);
		vy = byteArray.getInt16(46);
		vz = byteArray.getInt16(48);
		xacc = byteArray.getInt16(50);
		yacc = byteArray.getInt16(52);
		zacc = byteArray.getInt16(54);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt64(timeUsec,0);
		byteArray.putFloat(roll,8);
		byteArray.putFloat(pitch,12);
		byteArray.putFloat(yaw,16);
		byteArray.putFloat(rollspeed,20);
		byteArray.putFloat(pitchspeed,24);
		byteArray.putFloat(yawspeed,28);
		byteArray.putInt32(lat,32);
		byteArray.putInt32(lon,36);
		byteArray.putInt32(alt,40);
		byteArray.putInt16(vx,44);
		byteArray.putInt16(vy,46);
		byteArray.putInt16(vz,48);
		byteArray.putInt16(xacc,50);
		byteArray.putInt16(yacc,52);
		byteArray.putInt16(zacc,54);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final HilState setTimeUsec(BigInteger timeUsec) {
		this.timeUsec = timeUsec;
		return this;
	}

	public final BigInteger getTimeUsec() {
		return timeUsec;
	}

	public final HilState setRoll(float roll) {
		this.roll = roll;
		return this;
	}

	public final float getRoll() {
		return roll;
	}

	public final HilState setPitch(float pitch) {
		this.pitch = pitch;
		return this;
	}

	public final float getPitch() {
		return pitch;
	}

	public final HilState setYaw(float yaw) {
		this.yaw = yaw;
		return this;
	}

	public final float getYaw() {
		return yaw;
	}

	public final HilState setRollspeed(float rollspeed) {
		this.rollspeed = rollspeed;
		return this;
	}

	public final float getRollspeed() {
		return rollspeed;
	}

	public final HilState setPitchspeed(float pitchspeed) {
		this.pitchspeed = pitchspeed;
		return this;
	}

	public final float getPitchspeed() {
		return pitchspeed;
	}

	public final HilState setYawspeed(float yawspeed) {
		this.yawspeed = yawspeed;
		return this;
	}

	public final float getYawspeed() {
		return yawspeed;
	}

	public final HilState setLat(int lat) {
		this.lat = lat;
		return this;
	}

	public final int getLat() {
		return lat;
	}

	public final HilState setLon(int lon) {
		this.lon = lon;
		return this;
	}

	public final int getLon() {
		return lon;
	}

	public final HilState setAlt(int alt) {
		this.alt = alt;
		return this;
	}

	public final int getAlt() {
		return alt;
	}

	public final HilState setVx(short vx) {
		this.vx = vx;
		return this;
	}

	public final short getVx() {
		return vx;
	}

	public final HilState setVy(short vy) {
		this.vy = vy;
		return this;
	}

	public final short getVy() {
		return vy;
	}

	public final HilState setVz(short vz) {
		this.vz = vz;
		return this;
	}

	public final short getVz() {
		return vz;
	}

	public final HilState setXacc(short xacc) {
		this.xacc = xacc;
		return this;
	}

	public final short getXacc() {
		return xacc;
	}

	public final HilState setYacc(short yacc) {
		this.yacc = yacc;
		return this;
	}

	public final short getYacc() {
		return yacc;
	}

	public final HilState setZacc(short zacc) {
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
			HilState other = (HilState)o;
			if (!Objects.deepEquals(this.timeUsec, other.timeUsec)) {
				return false;
			} else if (!Objects.deepEquals(this.roll, other.roll)) {
				return false;
			} else if (!Objects.deepEquals(this.pitch, other.pitch)) {
				return false;
			} else if (!Objects.deepEquals(this.yaw, other.yaw)) {
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
		result = 31 * result + Objects.hashCode(this.roll);
		result = 31 * result + Objects.hashCode(this.pitch);
		result = 31 * result + Objects.hashCode(this.yaw);
		result = 31 * result + Objects.hashCode(this.rollspeed);
		result = 31 * result + Objects.hashCode(this.pitchspeed);
		result = 31 * result + Objects.hashCode(this.yawspeed);
		result = 31 * result + Objects.hashCode(this.lat);
		result = 31 * result + Objects.hashCode(this.lon);
		result = 31 * result + Objects.hashCode(this.alt);
		result = 31 * result + Objects.hashCode(this.vx);
		result = 31 * result + Objects.hashCode(this.vy);
		result = 31 * result + Objects.hashCode(this.vz);
		result = 31 * result + Objects.hashCode(this.xacc);
		result = 31 * result + Objects.hashCode(this.yacc);
		result = 31 * result + Objects.hashCode(this.zacc);
		return result;
	}

	@Override
	public String toString() {
		return "HilState{" +
				"timeUsec=" + timeUsec +
				", roll=" + roll +
				", pitch=" + pitch +
				", yaw=" + yaw +
				", rollspeed=" + rollspeed +
				", pitchspeed=" + pitchspeed +
				", yawspeed=" + yawspeed +
				", lat=" + lat +
				", lon=" + lon +
				", alt=" + alt +
				", vx=" + vx +
				", vy=" + vy +
				", vz=" + vz +
				", xacc=" + xacc +
				", yacc=" + yacc +
				", zacc=" + zacc +
				'}';
	}
}
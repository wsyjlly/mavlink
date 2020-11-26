package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.UtmFlightState;
import cn.wsyjlly.mavlink.common.v2.enums.UtmDataAvailFlags;
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
		id = 340,
		messagePayloadLength = 70,
		description = "The global position resulting from GPS and sensor fusion."
)
public class UtmGlobalPosition implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8, description = "Time of applicability of position (microseconds since UNIX epoch).", units = "us")
	private BigInteger time;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 18, description = "Unique UAS ID.")
	private short[] uasId = new short[18];

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 3, typeSize = 4, streamLength = 4, description = "Latitude (WGS84)", units = "degE7")
	private int lat;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 4, typeSize = 4, streamLength = 4, description = "Longitude (WGS84)", units = "degE7")
	private int lon;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 5, typeSize = 4, streamLength = 4, description = "Altitude (WGS84)", units = "mm")
	private int alt;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 6, typeSize = 4, streamLength = 4, description = "Altitude above ground", units = "mm")
	private int relativeAlt;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 7, typeSize = 2, streamLength = 2, description = "Ground X speed (latitude, positive north)", units = "cm/s")
	private short vx;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 8, typeSize = 2, streamLength = 2, description = "Ground Y speed (longitude, positive east)", units = "cm/s")
	private short vy;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 9, typeSize = 2, streamLength = 2, description = "Ground Z speed (altitude, positive down)", units = "cm/s")
	private short vz;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 10, typeSize = 2, streamLength = 2, description = "Horizontal position uncertainty (standard deviation)", units = "mm")
	private int hAcc;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 11, typeSize = 2, streamLength = 2, description = "Altitude uncertainty (standard deviation)", units = "mm")
	private int vAcc;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 12, typeSize = 2, streamLength = 2, description = "Speed uncertainty (standard deviation)", units = "cm/s")
	private int velAcc;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 13, typeSize = 4, streamLength = 4, description = "Next waypoint, latitude (WGS84)", units = "degE7")
	private int nextLat;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 14, typeSize = 4, streamLength = 4, description = "Next waypoint, longitude (WGS84)", units = "degE7")
	private int nextLon;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 15, typeSize = 4, streamLength = 4, description = "Next waypoint, altitude (WGS84)", units = "mm")
	private int nextAlt;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 16, typeSize = 2, streamLength = 2, description = "Time until next update. Set to 0 if unknown or in data driven mode.", units = "cs")
	private int updateRate;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 17, typeSize = 1, streamLength = 1, description = "Flight state", enum0 = UtmFlightState.class)
	private short flightState;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 18, typeSize = 1, streamLength = 1, description = "Bitwise OR combination of the data available flags.", enum0 = UtmDataAvailFlags.class)
	private short flags;

	private final int messagePayloadLength = 70;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public UtmGlobalPosition(BigInteger time, short[] uasId, int lat, int lon, int alt, int relativeAlt, short vx, short vy, short vz, int hAcc, int vAcc, int velAcc, int nextLat, int nextLon, int nextAlt, int updateRate, short flightState, short flags) {
		this.time = time;
		this.uasId = uasId;
		this.lat = lat;
		this.lon = lon;
		this.alt = alt;
		this.relativeAlt = relativeAlt;
		this.vx = vx;
		this.vy = vy;
		this.vz = vz;
		this.hAcc = hAcc;
		this.vAcc = vAcc;
		this.velAcc = velAcc;
		this.nextLat = nextLat;
		this.nextLon = nextLon;
		this.nextAlt = nextAlt;
		this.updateRate = updateRate;
		this.flightState = flightState;
		this.flags = flags;
	}

	public UtmGlobalPosition(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 70！");
		}
		messagePayload(messagePayload);
	}

	public UtmGlobalPosition(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		time = byteArray.getUnsignedInt64(0);
		uasId = byteArray.getUnsignedInt8Array(8,18);
		lat = byteArray.getInt32(26);
		lon = byteArray.getInt32(30);
		alt = byteArray.getInt32(34);
		relativeAlt = byteArray.getInt32(38);
		vx = byteArray.getInt16(42);
		vy = byteArray.getInt16(44);
		vz = byteArray.getInt16(46);
		hAcc = byteArray.getUnsignedInt16(48);
		vAcc = byteArray.getUnsignedInt16(50);
		velAcc = byteArray.getUnsignedInt16(52);
		nextLat = byteArray.getInt32(54);
		nextLon = byteArray.getInt32(58);
		nextAlt = byteArray.getInt32(62);
		updateRate = byteArray.getUnsignedInt16(66);
		flightState = byteArray.getUnsignedInt8(68);
		flags = byteArray.getUnsignedInt8(69);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt64(time,0);
		byteArray.putUnsignedInt8Array(uasId,8);
		byteArray.putInt32(lat,26);
		byteArray.putInt32(lon,30);
		byteArray.putInt32(alt,34);
		byteArray.putInt32(relativeAlt,38);
		byteArray.putInt16(vx,42);
		byteArray.putInt16(vy,44);
		byteArray.putInt16(vz,46);
		byteArray.putUnsignedInt16(hAcc,48);
		byteArray.putUnsignedInt16(vAcc,50);
		byteArray.putUnsignedInt16(velAcc,52);
		byteArray.putInt32(nextLat,54);
		byteArray.putInt32(nextLon,58);
		byteArray.putInt32(nextAlt,62);
		byteArray.putUnsignedInt16(updateRate,66);
		byteArray.putUnsignedInt8(flightState,68);
		byteArray.putUnsignedInt8(flags,69);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final UtmGlobalPosition setTime(BigInteger time) {
		this.time = time;
		return this;
	}

	public final BigInteger getTime() {
		return time;
	}

	public final UtmGlobalPosition setUasId(short[] uasId) {
		this.uasId = uasId;
		return this;
	}

	public final short[] getUasId() {
		return uasId;
	}

	public final UtmGlobalPosition setLat(int lat) {
		this.lat = lat;
		return this;
	}

	public final int getLat() {
		return lat;
	}

	public final UtmGlobalPosition setLon(int lon) {
		this.lon = lon;
		return this;
	}

	public final int getLon() {
		return lon;
	}

	public final UtmGlobalPosition setAlt(int alt) {
		this.alt = alt;
		return this;
	}

	public final int getAlt() {
		return alt;
	}

	public final UtmGlobalPosition setRelativeAlt(int relativeAlt) {
		this.relativeAlt = relativeAlt;
		return this;
	}

	public final int getRelativeAlt() {
		return relativeAlt;
	}

	public final UtmGlobalPosition setVx(short vx) {
		this.vx = vx;
		return this;
	}

	public final short getVx() {
		return vx;
	}

	public final UtmGlobalPosition setVy(short vy) {
		this.vy = vy;
		return this;
	}

	public final short getVy() {
		return vy;
	}

	public final UtmGlobalPosition setVz(short vz) {
		this.vz = vz;
		return this;
	}

	public final short getVz() {
		return vz;
	}

	public final UtmGlobalPosition setHAcc(int hAcc) {
		this.hAcc = hAcc;
		return this;
	}

	public final int getHAcc() {
		return hAcc;
	}

	public final UtmGlobalPosition setVAcc(int vAcc) {
		this.vAcc = vAcc;
		return this;
	}

	public final int getVAcc() {
		return vAcc;
	}

	public final UtmGlobalPosition setVelAcc(int velAcc) {
		this.velAcc = velAcc;
		return this;
	}

	public final int getVelAcc() {
		return velAcc;
	}

	public final UtmGlobalPosition setNextLat(int nextLat) {
		this.nextLat = nextLat;
		return this;
	}

	public final int getNextLat() {
		return nextLat;
	}

	public final UtmGlobalPosition setNextLon(int nextLon) {
		this.nextLon = nextLon;
		return this;
	}

	public final int getNextLon() {
		return nextLon;
	}

	public final UtmGlobalPosition setNextAlt(int nextAlt) {
		this.nextAlt = nextAlt;
		return this;
	}

	public final int getNextAlt() {
		return nextAlt;
	}

	public final UtmGlobalPosition setUpdateRate(int updateRate) {
		this.updateRate = updateRate;
		return this;
	}

	public final int getUpdateRate() {
		return updateRate;
	}

	public final UtmGlobalPosition setFlightState(short flightState) {
		this.flightState = flightState;
		return this;
	}

	public final short getFlightState() {
		return flightState;
	}

	public final UtmGlobalPosition setFlags(short flags) {
		this.flags = flags;
		return this;
	}

	public final short getFlags() {
		return flags;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			UtmGlobalPosition other = (UtmGlobalPosition)o;
			if (!Objects.deepEquals(this.time, other.time)) {
				return false;
			} else if (!Objects.deepEquals(this.uasId, other.uasId)) {
				return false;
			} else if (!Objects.deepEquals(this.lat, other.lat)) {
				return false;
			} else if (!Objects.deepEquals(this.lon, other.lon)) {
				return false;
			} else if (!Objects.deepEquals(this.alt, other.alt)) {
				return false;
			} else if (!Objects.deepEquals(this.relativeAlt, other.relativeAlt)) {
				return false;
			} else if (!Objects.deepEquals(this.vx, other.vx)) {
				return false;
			} else if (!Objects.deepEquals(this.vy, other.vy)) {
				return false;
			} else if (!Objects.deepEquals(this.vz, other.vz)) {
				return false;
			} else if (!Objects.deepEquals(this.hAcc, other.hAcc)) {
				return false;
			} else if (!Objects.deepEquals(this.vAcc, other.vAcc)) {
				return false;
			} else if (!Objects.deepEquals(this.velAcc, other.velAcc)) {
				return false;
			} else if (!Objects.deepEquals(this.nextLat, other.nextLat)) {
				return false;
			} else if (!Objects.deepEquals(this.nextLon, other.nextLon)) {
				return false;
			} else if (!Objects.deepEquals(this.nextAlt, other.nextAlt)) {
				return false;
			} else if (!Objects.deepEquals(this.updateRate, other.updateRate)) {
				return false;
			} else if (!Objects.deepEquals(this.flightState, other.flightState)) {
				return false;
			} else {
				return Objects.deepEquals(this.flags, other.flags);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.time);
		result = 31 * result + Objects.hashCode(this.uasId);
		result = 31 * result + Objects.hashCode(this.lat);
		result = 31 * result + Objects.hashCode(this.lon);
		result = 31 * result + Objects.hashCode(this.alt);
		result = 31 * result + Objects.hashCode(this.relativeAlt);
		result = 31 * result + Objects.hashCode(this.vx);
		result = 31 * result + Objects.hashCode(this.vy);
		result = 31 * result + Objects.hashCode(this.vz);
		result = 31 * result + Objects.hashCode(this.hAcc);
		result = 31 * result + Objects.hashCode(this.vAcc);
		result = 31 * result + Objects.hashCode(this.velAcc);
		result = 31 * result + Objects.hashCode(this.nextLat);
		result = 31 * result + Objects.hashCode(this.nextLon);
		result = 31 * result + Objects.hashCode(this.nextAlt);
		result = 31 * result + Objects.hashCode(this.updateRate);
		result = 31 * result + Objects.hashCode(this.flightState);
		result = 31 * result + Objects.hashCode(this.flags);
		return result;
	}

	@Override
	public String toString() {
		return "UtmGlobalPosition{" +
				"time=" + time +
				", uasId=" + Arrays.toString(uasId) +
				", lat=" + lat +
				", lon=" + lon +
				", alt=" + alt +
				", relativeAlt=" + relativeAlt +
				", vx=" + vx +
				", vy=" + vy +
				", vz=" + vz +
				", hAcc=" + hAcc +
				", vAcc=" + vAcc +
				", velAcc=" + velAcc +
				", nextLat=" + nextLat +
				", nextLon=" + nextLon +
				", nextAlt=" + nextAlt +
				", updateRate=" + updateRate +
				", flightState=" + flightState +
				", flags=" + flags +
				'}';
	}
}
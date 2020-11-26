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
		id = 113,
		messagePayloadLength = 36,
		description = "The global position, as returned by the Global Positioning System (GPS). This is NOT the global position estimate of the sytem, but rather a RAW sensor value. See message GLOBAL_POSITION for the global position estimate. Coordinate frame is right-handed, Z-axis up (GPS frame)."
)
public class HilGps implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8, description = "Timestamp (microseconds since UNIX epoch or microseconds since system boot)")
	private BigInteger timeUsec;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "0-1: no fix, 2: 2D fix, 3: 3D fix. Some applications will not use the value of this field unless it is at least two, so always correctly fill in the fix.")
	private short fixType;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 3, typeSize = 4, streamLength = 4, description = "Latitude (WGS84), in degrees * 1E7")
	private int lat;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 4, typeSize = 4, streamLength = 4, description = "Longitude (WGS84), in degrees * 1E7")
	private int lon;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 5, typeSize = 4, streamLength = 4, description = "Altitude (WGS84), in meters * 1000 (positive for up)")
	private int alt;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 6, typeSize = 2, streamLength = 2, description = "GPS HDOP horizontal dilution of position in cm (m*100). If unknown, set to: 65535")
	private int eph;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 7, typeSize = 2, streamLength = 2, description = "GPS VDOP vertical dilution of position in cm (m*100). If unknown, set to: 65535")
	private int epv;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 8, typeSize = 2, streamLength = 2, description = "GPS ground speed (m/s * 100). If unknown, set to: 65535")
	private int vel;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 9, typeSize = 2, streamLength = 2, description = "GPS velocity in cm/s in NORTH direction in earth-fixed NED frame")
	private short vn;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 10, typeSize = 2, streamLength = 2, description = "GPS velocity in cm/s in EAST direction in earth-fixed NED frame")
	private short ve;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 11, typeSize = 2, streamLength = 2, description = "GPS velocity in cm/s in DOWN direction in earth-fixed NED frame")
	private short vd;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 12, typeSize = 2, streamLength = 2, description = "Course over ground (NOT heading, but direction of movement) in degrees * 100, 0.0..359.99 degrees. If unknown, set to: 65535")
	private int cog;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 13, typeSize = 1, streamLength = 1, description = "Number of satellites visible. If unknown, set to 255")
	private short satellitesVisible;

	private final int messagePayloadLength = 36;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public HilGps(BigInteger timeUsec, short fixType, int lat, int lon, int alt, int eph, int epv, int vel, short vn, short ve, short vd, int cog, short satellitesVisible) {
		this.timeUsec = timeUsec;
		this.fixType = fixType;
		this.lat = lat;
		this.lon = lon;
		this.alt = alt;
		this.eph = eph;
		this.epv = epv;
		this.vel = vel;
		this.vn = vn;
		this.ve = ve;
		this.vd = vd;
		this.cog = cog;
		this.satellitesVisible = satellitesVisible;
	}

	public HilGps(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 36！");
		}
		messagePayload(messagePayload);
	}

	public HilGps(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeUsec = byteArray.getUnsignedInt64(0);
		fixType = byteArray.getUnsignedInt8(8);
		lat = byteArray.getInt32(9);
		lon = byteArray.getInt32(13);
		alt = byteArray.getInt32(17);
		eph = byteArray.getUnsignedInt16(21);
		epv = byteArray.getUnsignedInt16(23);
		vel = byteArray.getUnsignedInt16(25);
		vn = byteArray.getInt16(27);
		ve = byteArray.getInt16(29);
		vd = byteArray.getInt16(31);
		cog = byteArray.getUnsignedInt16(33);
		satellitesVisible = byteArray.getUnsignedInt8(35);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt64(timeUsec,0);
		byteArray.putUnsignedInt8(fixType,8);
		byteArray.putInt32(lat,9);
		byteArray.putInt32(lon,13);
		byteArray.putInt32(alt,17);
		byteArray.putUnsignedInt16(eph,21);
		byteArray.putUnsignedInt16(epv,23);
		byteArray.putUnsignedInt16(vel,25);
		byteArray.putInt16(vn,27);
		byteArray.putInt16(ve,29);
		byteArray.putInt16(vd,31);
		byteArray.putUnsignedInt16(cog,33);
		byteArray.putUnsignedInt8(satellitesVisible,35);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final HilGps setTimeUsec(BigInteger timeUsec) {
		this.timeUsec = timeUsec;
		return this;
	}

	public final BigInteger getTimeUsec() {
		return timeUsec;
	}

	public final HilGps setFixType(short fixType) {
		this.fixType = fixType;
		return this;
	}

	public final short getFixType() {
		return fixType;
	}

	public final HilGps setLat(int lat) {
		this.lat = lat;
		return this;
	}

	public final int getLat() {
		return lat;
	}

	public final HilGps setLon(int lon) {
		this.lon = lon;
		return this;
	}

	public final int getLon() {
		return lon;
	}

	public final HilGps setAlt(int alt) {
		this.alt = alt;
		return this;
	}

	public final int getAlt() {
		return alt;
	}

	public final HilGps setEph(int eph) {
		this.eph = eph;
		return this;
	}

	public final int getEph() {
		return eph;
	}

	public final HilGps setEpv(int epv) {
		this.epv = epv;
		return this;
	}

	public final int getEpv() {
		return epv;
	}

	public final HilGps setVel(int vel) {
		this.vel = vel;
		return this;
	}

	public final int getVel() {
		return vel;
	}

	public final HilGps setVn(short vn) {
		this.vn = vn;
		return this;
	}

	public final short getVn() {
		return vn;
	}

	public final HilGps setVe(short ve) {
		this.ve = ve;
		return this;
	}

	public final short getVe() {
		return ve;
	}

	public final HilGps setVd(short vd) {
		this.vd = vd;
		return this;
	}

	public final short getVd() {
		return vd;
	}

	public final HilGps setCog(int cog) {
		this.cog = cog;
		return this;
	}

	public final int getCog() {
		return cog;
	}

	public final HilGps setSatellitesVisible(short satellitesVisible) {
		this.satellitesVisible = satellitesVisible;
		return this;
	}

	public final short getSatellitesVisible() {
		return satellitesVisible;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			HilGps other = (HilGps)o;
			if (!Objects.deepEquals(this.timeUsec, other.timeUsec)) {
				return false;
			} else if (!Objects.deepEquals(this.fixType, other.fixType)) {
				return false;
			} else if (!Objects.deepEquals(this.lat, other.lat)) {
				return false;
			} else if (!Objects.deepEquals(this.lon, other.lon)) {
				return false;
			} else if (!Objects.deepEquals(this.alt, other.alt)) {
				return false;
			} else if (!Objects.deepEquals(this.eph, other.eph)) {
				return false;
			} else if (!Objects.deepEquals(this.epv, other.epv)) {
				return false;
			} else if (!Objects.deepEquals(this.vel, other.vel)) {
				return false;
			} else if (!Objects.deepEquals(this.vn, other.vn)) {
				return false;
			} else if (!Objects.deepEquals(this.ve, other.ve)) {
				return false;
			} else if (!Objects.deepEquals(this.vd, other.vd)) {
				return false;
			} else if (!Objects.deepEquals(this.cog, other.cog)) {
				return false;
			} else {
				return Objects.deepEquals(this.satellitesVisible, other.satellitesVisible);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeUsec);
		result = 31 * result + Objects.hashCode(this.fixType);
		result = 31 * result + Objects.hashCode(this.lat);
		result = 31 * result + Objects.hashCode(this.lon);
		result = 31 * result + Objects.hashCode(this.alt);
		result = 31 * result + Objects.hashCode(this.eph);
		result = 31 * result + Objects.hashCode(this.epv);
		result = 31 * result + Objects.hashCode(this.vel);
		result = 31 * result + Objects.hashCode(this.vn);
		result = 31 * result + Objects.hashCode(this.ve);
		result = 31 * result + Objects.hashCode(this.vd);
		result = 31 * result + Objects.hashCode(this.cog);
		result = 31 * result + Objects.hashCode(this.satellitesVisible);
		return result;
	}

	@Override
	public String toString() {
		return "HilGps{" +
				"timeUsec=" + timeUsec +
				", fixType=" + fixType +
				", lat=" + lat +
				", lon=" + lon +
				", alt=" + alt +
				", eph=" + eph +
				", epv=" + epv +
				", vel=" + vel +
				", vn=" + vn +
				", ve=" + ve +
				", vd=" + vd +
				", cog=" + cog +
				", satellitesVisible=" + satellitesVisible +
				'}';
	}
}
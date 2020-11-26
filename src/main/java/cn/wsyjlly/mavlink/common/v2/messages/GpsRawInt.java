package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.GpsFixType;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
import java.math.BigInteger;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 24,
		messagePayloadLength = 52,
		description = "The global position, as returned by the Global Positioning System (GPS). This is NOT the global position estimate of the system, but rather a RAW sensor value. See message GLOBAL_POSITION for the global position estimate."
)
public class GpsRawInt implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8, description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.", units = "us")
	private BigInteger timeUsec;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "GPS fix type.", enum0 = GpsFixType.class)
	private short fixType;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 3, typeSize = 4, streamLength = 4, description = "Latitude (WGS84, EGM96 ellipsoid)", units = "degE7")
	private int lat;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 4, typeSize = 4, streamLength = 4, description = "Longitude (WGS84, EGM96 ellipsoid)", units = "degE7")
	private int lon;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 5, typeSize = 4, streamLength = 4, description = "Altitude (MSL). Positive for up. Note that virtually all GPS modules provide the MSL altitude in addition to the WGS84 altitude.", units = "mm")
	private int alt;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 6, typeSize = 2, streamLength = 2, description = "GPS HDOP horizontal dilution of position (unitless). If unknown, set to: UINT16_MAX")
	private int eph;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 7, typeSize = 2, streamLength = 2, description = "GPS VDOP vertical dilution of position (unitless). If unknown, set to: UINT16_MAX")
	private int epv;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 8, typeSize = 2, streamLength = 2, description = "GPS ground speed. If unknown, set to: UINT16_MAX", units = "cm/s")
	private int vel;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 9, typeSize = 2, streamLength = 2, description = "Course over ground (NOT heading, but direction of movement) in degrees * 100, 0.0..359.99 degrees. If unknown, set to: UINT16_MAX", units = "cdeg")
	private int cog;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 10, typeSize = 1, streamLength = 1, description = "Number of satellites visible. If unknown, set to 255")
	private short satellitesVisible;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 11, typeSize = 4, streamLength = 4, description = "Altitude (above WGS84, EGM96 ellipsoid). Positive for up.", units = "mm")
	private int altEllipsoid;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 12, typeSize = 4, streamLength = 4, description = "Position uncertainty.", units = "mm")
	private long hAcc;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 13, typeSize = 4, streamLength = 4, description = "Altitude uncertainty.", units = "mm")
	private long vAcc;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 14, typeSize = 4, streamLength = 4, description = "Speed uncertainty.", units = "mm")
	private long velAcc;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 15, typeSize = 4, streamLength = 4, description = "Heading / track uncertainty", units = "degE5")
	private long hdgAcc;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 16, typeSize = 2, streamLength = 2, description = "Yaw in earth frame from north. Use 0 if this GPS does not provide yaw. Use 65535 if this GPS is configured to provide yaw and is currently unable to provide it. Use 36000 for north.", units = "cdeg")
	private int yaw;

	private final int messagePayloadLength = 52;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public GpsRawInt(BigInteger timeUsec, short fixType, int lat, int lon, int alt, int eph, int epv, int vel, int cog, short satellitesVisible, int altEllipsoid, long hAcc, long vAcc, long velAcc, long hdgAcc, int yaw) {
		this.timeUsec = timeUsec;
		this.fixType = fixType;
		this.lat = lat;
		this.lon = lon;
		this.alt = alt;
		this.eph = eph;
		this.epv = epv;
		this.vel = vel;
		this.cog = cog;
		this.satellitesVisible = satellitesVisible;
		this.altEllipsoid = altEllipsoid;
		this.hAcc = hAcc;
		this.vAcc = vAcc;
		this.velAcc = velAcc;
		this.hdgAcc = hdgAcc;
		this.yaw = yaw;
	}

	public GpsRawInt(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 52！");
		}
		messagePayload(messagePayload);
	}

	public GpsRawInt(){ }

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
		cog = byteArray.getUnsignedInt16(27);
		satellitesVisible = byteArray.getUnsignedInt8(29);
		altEllipsoid = byteArray.getInt32(30);
		hAcc = byteArray.getUnsignedInt32(34);
		vAcc = byteArray.getUnsignedInt32(38);
		velAcc = byteArray.getUnsignedInt32(42);
		hdgAcc = byteArray.getUnsignedInt32(46);
		yaw = byteArray.getUnsignedInt16(50);
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
		byteArray.putUnsignedInt16(cog,27);
		byteArray.putUnsignedInt8(satellitesVisible,29);
		byteArray.putInt32(altEllipsoid,30);
		byteArray.putUnsignedInt32(hAcc,34);
		byteArray.putUnsignedInt32(vAcc,38);
		byteArray.putUnsignedInt32(velAcc,42);
		byteArray.putUnsignedInt32(hdgAcc,46);
		byteArray.putUnsignedInt16(yaw,50);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final GpsRawInt setTimeUsec(BigInteger timeUsec) {
		this.timeUsec = timeUsec;
		return this;
	}

	public final BigInteger getTimeUsec() {
		return timeUsec;
	}

	public final GpsRawInt setFixType(short fixType) {
		this.fixType = fixType;
		return this;
	}

	public final short getFixType() {
		return fixType;
	}

	public final GpsRawInt setLat(int lat) {
		this.lat = lat;
		return this;
	}

	public final int getLat() {
		return lat;
	}

	public final GpsRawInt setLon(int lon) {
		this.lon = lon;
		return this;
	}

	public final int getLon() {
		return lon;
	}

	public final GpsRawInt setAlt(int alt) {
		this.alt = alt;
		return this;
	}

	public final int getAlt() {
		return alt;
	}

	public final GpsRawInt setEph(int eph) {
		this.eph = eph;
		return this;
	}

	public final int getEph() {
		return eph;
	}

	public final GpsRawInt setEpv(int epv) {
		this.epv = epv;
		return this;
	}

	public final int getEpv() {
		return epv;
	}

	public final GpsRawInt setVel(int vel) {
		this.vel = vel;
		return this;
	}

	public final int getVel() {
		return vel;
	}

	public final GpsRawInt setCog(int cog) {
		this.cog = cog;
		return this;
	}

	public final int getCog() {
		return cog;
	}

	public final GpsRawInt setSatellitesVisible(short satellitesVisible) {
		this.satellitesVisible = satellitesVisible;
		return this;
	}

	public final short getSatellitesVisible() {
		return satellitesVisible;
	}

	public final GpsRawInt setAltEllipsoid(int altEllipsoid) {
		this.altEllipsoid = altEllipsoid;
		return this;
	}

	public final int getAltEllipsoid() {
		return altEllipsoid;
	}

	public final GpsRawInt setHAcc(long hAcc) {
		this.hAcc = hAcc;
		return this;
	}

	public final long getHAcc() {
		return hAcc;
	}

	public final GpsRawInt setVAcc(long vAcc) {
		this.vAcc = vAcc;
		return this;
	}

	public final long getVAcc() {
		return vAcc;
	}

	public final GpsRawInt setVelAcc(long velAcc) {
		this.velAcc = velAcc;
		return this;
	}

	public final long getVelAcc() {
		return velAcc;
	}

	public final GpsRawInt setHdgAcc(long hdgAcc) {
		this.hdgAcc = hdgAcc;
		return this;
	}

	public final long getHdgAcc() {
		return hdgAcc;
	}

	public final GpsRawInt setYaw(int yaw) {
		this.yaw = yaw;
		return this;
	}

	public final int getYaw() {
		return yaw;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			GpsRawInt other = (GpsRawInt)o;
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
			} else if (!Objects.deepEquals(this.cog, other.cog)) {
				return false;
			} else if (!Objects.deepEquals(this.satellitesVisible, other.satellitesVisible)) {
				return false;
			} else if (!Objects.deepEquals(this.altEllipsoid, other.altEllipsoid)) {
				return false;
			} else if (!Objects.deepEquals(this.hAcc, other.hAcc)) {
				return false;
			} else if (!Objects.deepEquals(this.vAcc, other.vAcc)) {
				return false;
			} else if (!Objects.deepEquals(this.velAcc, other.velAcc)) {
				return false;
			} else if (!Objects.deepEquals(this.hdgAcc, other.hdgAcc)) {
				return false;
			} else {
				return Objects.deepEquals(this.yaw, other.yaw);
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
		result = 31 * result + Objects.hashCode(this.cog);
		result = 31 * result + Objects.hashCode(this.satellitesVisible);
		result = 31 * result + Objects.hashCode(this.altEllipsoid);
		result = 31 * result + Objects.hashCode(this.hAcc);
		result = 31 * result + Objects.hashCode(this.vAcc);
		result = 31 * result + Objects.hashCode(this.velAcc);
		result = 31 * result + Objects.hashCode(this.hdgAcc);
		result = 31 * result + Objects.hashCode(this.yaw);
		return result;
	}

	@Override
	public String toString() {
		return "GpsRawInt{" +
				"timeUsec=" + timeUsec +
				", fixType=" + fixType +
				", lat=" + lat +
				", lon=" + lon +
				", alt=" + alt +
				", eph=" + eph +
				", epv=" + epv +
				", vel=" + vel +
				", cog=" + cog +
				", satellitesVisible=" + satellitesVisible +
				", altEllipsoid=" + altEllipsoid +
				", hAcc=" + hAcc +
				", vAcc=" + vAcc +
				", velAcc=" + velAcc +
				", hdgAcc=" + hdgAcc +
				", yaw=" + yaw +
				'}';
	}
}
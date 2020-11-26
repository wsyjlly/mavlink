package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.GpsInputIgnoreFlags;
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
		id = 232,
		messagePayloadLength = 65,
		description = "GPS sensor input message. This is a raw sensor value sent by the GPS. This is NOT the global position estimate of the system."
)
public class GpsInput implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8, description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.", units = "us")
	private BigInteger timeUsec;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "ID of the GPS for multiple GPS inputs")
	private short gpsId;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 3, typeSize = 2, streamLength = 2, description = "Bitmap indicating which GPS input flags fields to ignore. All other fields must be provided.", enum0 = GpsInputIgnoreFlags.class)
	private int ignoreFlags;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 4, typeSize = 4, streamLength = 4, description = "GPS time (from start of GPS week)", units = "ms")
	private long timeWeekMs;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 5, typeSize = 2, streamLength = 2, description = "GPS week number")
	private int timeWeek;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 6, typeSize = 1, streamLength = 1, description = "0-1: no fix, 2: 2D fix, 3: 3D fix. 4: 3D with DGPS. 5: 3D with RTK")
	private short fixType;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 7, typeSize = 4, streamLength = 4, description = "Latitude (WGS84)", units = "degE7")
	private int lat;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 8, typeSize = 4, streamLength = 4, description = "Longitude (WGS84)", units = "degE7")
	private int lon;

	@MavlinkMessageParam(mavlinkType = "float", position = 9, typeSize = 4, streamLength = 4, description = "Altitude (MSL). Positive for up.", units = "m")
	private float alt;

	@MavlinkMessageParam(mavlinkType = "float", position = 10, typeSize = 4, streamLength = 4, description = "GPS HDOP horizontal dilution of position", units = "m")
	private float hdop;

	@MavlinkMessageParam(mavlinkType = "float", position = 11, typeSize = 4, streamLength = 4, description = "GPS VDOP vertical dilution of position", units = "m")
	private float vdop;

	@MavlinkMessageParam(mavlinkType = "float", position = 12, typeSize = 4, streamLength = 4, description = "GPS velocity in north direction in earth-fixed NED frame", units = "m/s")
	private float vn;

	@MavlinkMessageParam(mavlinkType = "float", position = 13, typeSize = 4, streamLength = 4, description = "GPS velocity in east direction in earth-fixed NED frame", units = "m/s")
	private float ve;

	@MavlinkMessageParam(mavlinkType = "float", position = 14, typeSize = 4, streamLength = 4, description = "GPS velocity in down direction in earth-fixed NED frame", units = "m/s")
	private float vd;

	@MavlinkMessageParam(mavlinkType = "float", position = 15, typeSize = 4, streamLength = 4, description = "GPS speed accuracy", units = "m/s")
	private float speedAccuracy;

	@MavlinkMessageParam(mavlinkType = "float", position = 16, typeSize = 4, streamLength = 4, description = "GPS horizontal accuracy", units = "m")
	private float horizAccuracy;

	@MavlinkMessageParam(mavlinkType = "float", position = 17, typeSize = 4, streamLength = 4, description = "GPS vertical accuracy", units = "m")
	private float vertAccuracy;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 18, typeSize = 1, streamLength = 1, description = "Number of satellites visible.")
	private short satellitesVisible;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 19, typeSize = 2, streamLength = 2, description = "Yaw of vehicle relative to Earth's North, zero means not available, use 36000 for north", units = "cdeg")
	private int yaw;

	private final int messagePayloadLength = 65;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public GpsInput(BigInteger timeUsec, short gpsId, int ignoreFlags, long timeWeekMs, int timeWeek, short fixType, int lat, int lon, float alt, float hdop, float vdop, float vn, float ve, float vd, float speedAccuracy, float horizAccuracy, float vertAccuracy, short satellitesVisible, int yaw) {
		this.timeUsec = timeUsec;
		this.gpsId = gpsId;
		this.ignoreFlags = ignoreFlags;
		this.timeWeekMs = timeWeekMs;
		this.timeWeek = timeWeek;
		this.fixType = fixType;
		this.lat = lat;
		this.lon = lon;
		this.alt = alt;
		this.hdop = hdop;
		this.vdop = vdop;
		this.vn = vn;
		this.ve = ve;
		this.vd = vd;
		this.speedAccuracy = speedAccuracy;
		this.horizAccuracy = horizAccuracy;
		this.vertAccuracy = vertAccuracy;
		this.satellitesVisible = satellitesVisible;
		this.yaw = yaw;
	}

	public GpsInput(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 65！");
		}
		messagePayload(messagePayload);
	}

	public GpsInput(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeUsec = byteArray.getUnsignedInt64(0);
		gpsId = byteArray.getUnsignedInt8(8);
		ignoreFlags = byteArray.getUnsignedInt16(9);
		timeWeekMs = byteArray.getUnsignedInt32(11);
		timeWeek = byteArray.getUnsignedInt16(15);
		fixType = byteArray.getUnsignedInt8(17);
		lat = byteArray.getInt32(18);
		lon = byteArray.getInt32(22);
		alt = byteArray.getFloat(26);
		hdop = byteArray.getFloat(30);
		vdop = byteArray.getFloat(34);
		vn = byteArray.getFloat(38);
		ve = byteArray.getFloat(42);
		vd = byteArray.getFloat(46);
		speedAccuracy = byteArray.getFloat(50);
		horizAccuracy = byteArray.getFloat(54);
		vertAccuracy = byteArray.getFloat(58);
		satellitesVisible = byteArray.getUnsignedInt8(62);
		yaw = byteArray.getUnsignedInt16(63);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt64(timeUsec,0);
		byteArray.putUnsignedInt8(gpsId,8);
		byteArray.putUnsignedInt16(ignoreFlags,9);
		byteArray.putUnsignedInt32(timeWeekMs,11);
		byteArray.putUnsignedInt16(timeWeek,15);
		byteArray.putUnsignedInt8(fixType,17);
		byteArray.putInt32(lat,18);
		byteArray.putInt32(lon,22);
		byteArray.putFloat(alt,26);
		byteArray.putFloat(hdop,30);
		byteArray.putFloat(vdop,34);
		byteArray.putFloat(vn,38);
		byteArray.putFloat(ve,42);
		byteArray.putFloat(vd,46);
		byteArray.putFloat(speedAccuracy,50);
		byteArray.putFloat(horizAccuracy,54);
		byteArray.putFloat(vertAccuracy,58);
		byteArray.putUnsignedInt8(satellitesVisible,62);
		byteArray.putUnsignedInt16(yaw,63);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final GpsInput setTimeUsec(BigInteger timeUsec) {
		this.timeUsec = timeUsec;
		return this;
	}

	public final BigInteger getTimeUsec() {
		return timeUsec;
	}

	public final GpsInput setGpsId(short gpsId) {
		this.gpsId = gpsId;
		return this;
	}

	public final short getGpsId() {
		return gpsId;
	}

	public final GpsInput setIgnoreFlags(int ignoreFlags) {
		this.ignoreFlags = ignoreFlags;
		return this;
	}

	public final int getIgnoreFlags() {
		return ignoreFlags;
	}

	public final GpsInput setTimeWeekMs(long timeWeekMs) {
		this.timeWeekMs = timeWeekMs;
		return this;
	}

	public final long getTimeWeekMs() {
		return timeWeekMs;
	}

	public final GpsInput setTimeWeek(int timeWeek) {
		this.timeWeek = timeWeek;
		return this;
	}

	public final int getTimeWeek() {
		return timeWeek;
	}

	public final GpsInput setFixType(short fixType) {
		this.fixType = fixType;
		return this;
	}

	public final short getFixType() {
		return fixType;
	}

	public final GpsInput setLat(int lat) {
		this.lat = lat;
		return this;
	}

	public final int getLat() {
		return lat;
	}

	public final GpsInput setLon(int lon) {
		this.lon = lon;
		return this;
	}

	public final int getLon() {
		return lon;
	}

	public final GpsInput setAlt(float alt) {
		this.alt = alt;
		return this;
	}

	public final float getAlt() {
		return alt;
	}

	public final GpsInput setHdop(float hdop) {
		this.hdop = hdop;
		return this;
	}

	public final float getHdop() {
		return hdop;
	}

	public final GpsInput setVdop(float vdop) {
		this.vdop = vdop;
		return this;
	}

	public final float getVdop() {
		return vdop;
	}

	public final GpsInput setVn(float vn) {
		this.vn = vn;
		return this;
	}

	public final float getVn() {
		return vn;
	}

	public final GpsInput setVe(float ve) {
		this.ve = ve;
		return this;
	}

	public final float getVe() {
		return ve;
	}

	public final GpsInput setVd(float vd) {
		this.vd = vd;
		return this;
	}

	public final float getVd() {
		return vd;
	}

	public final GpsInput setSpeedAccuracy(float speedAccuracy) {
		this.speedAccuracy = speedAccuracy;
		return this;
	}

	public final float getSpeedAccuracy() {
		return speedAccuracy;
	}

	public final GpsInput setHorizAccuracy(float horizAccuracy) {
		this.horizAccuracy = horizAccuracy;
		return this;
	}

	public final float getHorizAccuracy() {
		return horizAccuracy;
	}

	public final GpsInput setVertAccuracy(float vertAccuracy) {
		this.vertAccuracy = vertAccuracy;
		return this;
	}

	public final float getVertAccuracy() {
		return vertAccuracy;
	}

	public final GpsInput setSatellitesVisible(short satellitesVisible) {
		this.satellitesVisible = satellitesVisible;
		return this;
	}

	public final short getSatellitesVisible() {
		return satellitesVisible;
	}

	public final GpsInput setYaw(int yaw) {
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
			GpsInput other = (GpsInput)o;
			if (!Objects.deepEquals(this.timeUsec, other.timeUsec)) {
				return false;
			} else if (!Objects.deepEquals(this.gpsId, other.gpsId)) {
				return false;
			} else if (!Objects.deepEquals(this.ignoreFlags, other.ignoreFlags)) {
				return false;
			} else if (!Objects.deepEquals(this.timeWeekMs, other.timeWeekMs)) {
				return false;
			} else if (!Objects.deepEquals(this.timeWeek, other.timeWeek)) {
				return false;
			} else if (!Objects.deepEquals(this.fixType, other.fixType)) {
				return false;
			} else if (!Objects.deepEquals(this.lat, other.lat)) {
				return false;
			} else if (!Objects.deepEquals(this.lon, other.lon)) {
				return false;
			} else if (!Objects.deepEquals(this.alt, other.alt)) {
				return false;
			} else if (!Objects.deepEquals(this.hdop, other.hdop)) {
				return false;
			} else if (!Objects.deepEquals(this.vdop, other.vdop)) {
				return false;
			} else if (!Objects.deepEquals(this.vn, other.vn)) {
				return false;
			} else if (!Objects.deepEquals(this.ve, other.ve)) {
				return false;
			} else if (!Objects.deepEquals(this.vd, other.vd)) {
				return false;
			} else if (!Objects.deepEquals(this.speedAccuracy, other.speedAccuracy)) {
				return false;
			} else if (!Objects.deepEquals(this.horizAccuracy, other.horizAccuracy)) {
				return false;
			} else if (!Objects.deepEquals(this.vertAccuracy, other.vertAccuracy)) {
				return false;
			} else if (!Objects.deepEquals(this.satellitesVisible, other.satellitesVisible)) {
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
		result = 31 * result + Objects.hashCode(this.gpsId);
		result = 31 * result + Objects.hashCode(this.ignoreFlags);
		result = 31 * result + Objects.hashCode(this.timeWeekMs);
		result = 31 * result + Objects.hashCode(this.timeWeek);
		result = 31 * result + Objects.hashCode(this.fixType);
		result = 31 * result + Objects.hashCode(this.lat);
		result = 31 * result + Objects.hashCode(this.lon);
		result = 31 * result + Objects.hashCode(this.alt);
		result = 31 * result + Objects.hashCode(this.hdop);
		result = 31 * result + Objects.hashCode(this.vdop);
		result = 31 * result + Objects.hashCode(this.vn);
		result = 31 * result + Objects.hashCode(this.ve);
		result = 31 * result + Objects.hashCode(this.vd);
		result = 31 * result + Objects.hashCode(this.speedAccuracy);
		result = 31 * result + Objects.hashCode(this.horizAccuracy);
		result = 31 * result + Objects.hashCode(this.vertAccuracy);
		result = 31 * result + Objects.hashCode(this.satellitesVisible);
		result = 31 * result + Objects.hashCode(this.yaw);
		return result;
	}

	@Override
	public String toString() {
		return "GpsInput{" +
				"timeUsec=" + timeUsec +
				", gpsId=" + gpsId +
				", ignoreFlags=" + ignoreFlags +
				", timeWeekMs=" + timeWeekMs +
				", timeWeek=" + timeWeek +
				", fixType=" + fixType +
				", lat=" + lat +
				", lon=" + lon +
				", alt=" + alt +
				", hdop=" + hdop +
				", vdop=" + vdop +
				", vn=" + vn +
				", ve=" + ve +
				", vd=" + vd +
				", speedAccuracy=" + speedAccuracy +
				", horizAccuracy=" + horizAccuracy +
				", vertAccuracy=" + vertAccuracy +
				", satellitesVisible=" + satellitesVisible +
				", yaw=" + yaw +
				'}';
	}
}
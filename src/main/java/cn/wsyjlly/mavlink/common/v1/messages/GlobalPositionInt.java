package cn.wsyjlly.mavlink.common.v1.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:45
 **********************************/

@MavlinkMessage(
		id = 33,
		messagePayloadLength = 28,
		description = "The filtered global position (e.g. fused GPS and accelerometers). The position is in GPS-frame (right-handed, Z-up). It is designed as scaled integer message since the resolution of float is not sufficient."
)
public class GlobalPositionInt implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4, description = "Timestamp (milliseconds since system boot)")
	private long timeBootMs;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 2, typeSize = 4, streamLength = 4, description = "Latitude, expressed as * 1E7")
	private int lat;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 3, typeSize = 4, streamLength = 4, description = "Longitude, expressed as * 1E7")
	private int lon;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 4, typeSize = 4, streamLength = 4, description = "Altitude in meters, expressed as * 1000 (millimeters), WGS84 (not AMSL)")
	private int alt;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 5, typeSize = 4, streamLength = 4, description = "Altitude above ground in meters, expressed as * 1000 (millimeters)")
	private int relativeAlt;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 6, typeSize = 2, streamLength = 2, description = "Ground X Speed (Latitude), expressed as m/s * 100")
	private short vx;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 7, typeSize = 2, streamLength = 2, description = "Ground Y Speed (Longitude), expressed as m/s * 100")
	private short vy;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 8, typeSize = 2, streamLength = 2, description = "Ground Z Speed (Altitude), expressed as m/s * 100")
	private short vz;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 9, typeSize = 2, streamLength = 2, description = "Compass heading in degrees * 100, 0.0..359.99 degrees. If unknown, set to: UINT16_MAX")
	private int hdg;

	private final int messagePayloadLength = 28;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public GlobalPositionInt(long timeBootMs, int lat, int lon, int alt, int relativeAlt, short vx, short vy, short vz, int hdg) {
		this.timeBootMs = timeBootMs;
		this.lat = lat;
		this.lon = lon;
		this.alt = alt;
		this.relativeAlt = relativeAlt;
		this.vx = vx;
		this.vy = vy;
		this.vz = vz;
		this.hdg = hdg;
	}

	public GlobalPositionInt(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 28！");
		}
		messagePayload(messagePayload);
	}

	public GlobalPositionInt(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeBootMs = byteArray.getUnsignedInt32(0);
		lat = byteArray.getInt32(4);
		lon = byteArray.getInt32(8);
		alt = byteArray.getInt32(12);
		relativeAlt = byteArray.getInt32(16);
		vx = byteArray.getInt16(20);
		vy = byteArray.getInt16(22);
		vz = byteArray.getInt16(24);
		hdg = byteArray.getUnsignedInt16(26);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt32(timeBootMs,0);
		byteArray.putInt32(lat,4);
		byteArray.putInt32(lon,8);
		byteArray.putInt32(alt,12);
		byteArray.putInt32(relativeAlt,16);
		byteArray.putInt16(vx,20);
		byteArray.putInt16(vy,22);
		byteArray.putInt16(vz,24);
		byteArray.putUnsignedInt16(hdg,26);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final GlobalPositionInt setTimeBootMs(long timeBootMs) {
		this.timeBootMs = timeBootMs;
		return this;
	}

	public final long getTimeBootMs() {
		return timeBootMs;
	}

	public final GlobalPositionInt setLat(int lat) {
		this.lat = lat;
		return this;
	}

	public final int getLat() {
		return lat;
	}

	public final GlobalPositionInt setLon(int lon) {
		this.lon = lon;
		return this;
	}

	public final int getLon() {
		return lon;
	}

	public final GlobalPositionInt setAlt(int alt) {
		this.alt = alt;
		return this;
	}

	public final int getAlt() {
		return alt;
	}

	public final GlobalPositionInt setRelativeAlt(int relativeAlt) {
		this.relativeAlt = relativeAlt;
		return this;
	}

	public final int getRelativeAlt() {
		return relativeAlt;
	}

	public final GlobalPositionInt setVx(short vx) {
		this.vx = vx;
		return this;
	}

	public final short getVx() {
		return vx;
	}

	public final GlobalPositionInt setVy(short vy) {
		this.vy = vy;
		return this;
	}

	public final short getVy() {
		return vy;
	}

	public final GlobalPositionInt setVz(short vz) {
		this.vz = vz;
		return this;
	}

	public final short getVz() {
		return vz;
	}

	public final GlobalPositionInt setHdg(int hdg) {
		this.hdg = hdg;
		return this;
	}

	public final int getHdg() {
		return hdg;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			GlobalPositionInt other = (GlobalPositionInt)o;
			if (!Objects.deepEquals(this.timeBootMs, other.timeBootMs)) {
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
			} else {
				return Objects.deepEquals(this.hdg, other.hdg);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeBootMs);
		result = 31 * result + Objects.hashCode(this.lat);
		result = 31 * result + Objects.hashCode(this.lon);
		result = 31 * result + Objects.hashCode(this.alt);
		result = 31 * result + Objects.hashCode(this.relativeAlt);
		result = 31 * result + Objects.hashCode(this.vx);
		result = 31 * result + Objects.hashCode(this.vy);
		result = 31 * result + Objects.hashCode(this.vz);
		result = 31 * result + Objects.hashCode(this.hdg);
		return result;
	}

	@Override
	public String toString() {
		return "GlobalPositionInt{" +
				"timeBootMs=" + timeBootMs +
				", lat=" + lat +
				", lon=" + lon +
				", alt=" + alt +
				", relativeAlt=" + relativeAlt +
				", vx=" + vx +
				", vy=" + vy +
				", vz=" + vz +
				", hdg=" + hdg +
				'}';
	}
}
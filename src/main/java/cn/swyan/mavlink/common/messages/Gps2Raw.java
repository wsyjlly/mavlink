package cn.swyan.mavlink.common.messages;

import cn.swyan.mavlink.annotation.MavlinkMessage;
import cn.swyan.mavlink.annotation.MavlinkMessageParam;
import cn.swyan.mavlink.common.Message;
import cn.swyan.mavlink.protocol.ByteArray;
import cn.swyan.mavlink.protocol.util.ByteModel;

import java.util.Objects;
import java.math.BigInteger;
/**********************************
 * @Author YSW
 * @Description
 * @Date 2020.11.04 - 03:56
 **********************************/

@MavlinkMessage(
		id = 124,
		messagePayloadLength = 35,
		description = "Second GPS data. Coordinate frame is right-handed, Z-axis up (GPS frame)."
)
public class Gps2Raw implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8)
	private BigInteger timeUsec;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1)
	private short fixType;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 3, typeSize = 4, streamLength = 4)
	private int lat;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 4, typeSize = 4, streamLength = 4)
	private int lon;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 5, typeSize = 4, streamLength = 4)
	private int alt;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 6, typeSize = 2, streamLength = 2)
	private int eph;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 7, typeSize = 2, streamLength = 2)
	private int epv;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 8, typeSize = 2, streamLength = 2)
	private int vel;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 9, typeSize = 2, streamLength = 2)
	private int cog;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 10, typeSize = 1, streamLength = 1)
	private short satellitesVisible;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 11, typeSize = 1, streamLength = 1)
	private short dgpsNumch;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 12, typeSize = 4, streamLength = 4)
	private long dgpsAge;

	private final int messagePayloadLength = 35;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public Gps2Raw(BigInteger timeUsec, short fixType, int lat, int lon, int alt, int eph, int epv, int vel, int cog, short satellitesVisible, short dgpsNumch, long dgpsAge) {
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
		this.dgpsNumch = dgpsNumch;
		this.dgpsAge = dgpsAge;
	}

	public Gps2Raw(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 35！");
		}
		messagePayload(messagePayload);
	}

	public Gps2Raw(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.timeUsec = byteArray.getUnsignedInt64(0);
		this.fixType = byteArray.getUnsignedInt8(8);
		this.lat = byteArray.getInt32(9);
		this.lon = byteArray.getInt32(13);
		this.alt = byteArray.getInt32(17);
		this.eph = byteArray.getUnsignedInt16(21);
		this.epv = byteArray.getUnsignedInt16(23);
		this.vel = byteArray.getUnsignedInt16(25);
		this.cog = byteArray.getUnsignedInt16(27);
		this.satellitesVisible = byteArray.getUnsignedInt8(29);
		this.dgpsNumch = byteArray.getUnsignedInt8(30);
		this.dgpsAge = byteArray.getUnsignedInt32(31);
	}

	@Override
	public byte[] messagePayload() {
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final Gps2Raw setTimeUsec(BigInteger timeUsec) {
		this.timeUsec = timeUsec;
		return this;
	}

	public final BigInteger getTimeUsec() {
		return timeUsec;
	}

	public final Gps2Raw setFixType(short fixType) {
		this.fixType = fixType;
		return this;
	}

	public final short getFixType() {
		return fixType;
	}

	public final Gps2Raw setLat(int lat) {
		this.lat = lat;
		return this;
	}

	public final int getLat() {
		return lat;
	}

	public final Gps2Raw setLon(int lon) {
		this.lon = lon;
		return this;
	}

	public final int getLon() {
		return lon;
	}

	public final Gps2Raw setAlt(int alt) {
		this.alt = alt;
		return this;
	}

	public final int getAlt() {
		return alt;
	}

	public final Gps2Raw setEph(int eph) {
		this.eph = eph;
		return this;
	}

	public final int getEph() {
		return eph;
	}

	public final Gps2Raw setEpv(int epv) {
		this.epv = epv;
		return this;
	}

	public final int getEpv() {
		return epv;
	}

	public final Gps2Raw setVel(int vel) {
		this.vel = vel;
		return this;
	}

	public final int getVel() {
		return vel;
	}

	public final Gps2Raw setCog(int cog) {
		this.cog = cog;
		return this;
	}

	public final int getCog() {
		return cog;
	}

	public final Gps2Raw setSatellitesVisible(short satellitesVisible) {
		this.satellitesVisible = satellitesVisible;
		return this;
	}

	public final short getSatellitesVisible() {
		return satellitesVisible;
	}

	public final Gps2Raw setDgpsNumch(short dgpsNumch) {
		this.dgpsNumch = dgpsNumch;
		return this;
	}

	public final short getDgpsNumch() {
		return dgpsNumch;
	}

	public final Gps2Raw setDgpsAge(long dgpsAge) {
		this.dgpsAge = dgpsAge;
		return this;
	}

	public final long getDgpsAge() {
		return dgpsAge;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			Gps2Raw other = (Gps2Raw)o;
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
			} else if (!Objects.deepEquals(this.dgpsNumch, other.dgpsNumch)) {
				return false;
			} else {
				return Objects.deepEquals(this.dgpsAge, other.dgpsAge);
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
		result = 31 * result + Objects.hashCode(this.dgpsNumch);
		result = 31 * result + Objects.hashCode(this.dgpsAge);
		return result;
	}

	@Override
	public String toString() {
		return "Gps2Raw{" +
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
				", dgpsNumch=" + dgpsNumch +
				", dgpsAge=" + dgpsAge +
				'}';
	}
}
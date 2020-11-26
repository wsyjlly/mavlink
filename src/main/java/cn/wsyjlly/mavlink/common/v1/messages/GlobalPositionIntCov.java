package cn.wsyjlly.mavlink.common.v1.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v1.enums.MavEstimatorType;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
import java.util.Arrays;
import java.math.BigInteger;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:45
 **********************************/

@MavlinkMessage(
		id = 63,
		messagePayloadLength = 185,
		description = "The filtered global position (e.g. fused GPS and accelerometers). The position is in GPS-frame (right-handed, Z-up). It is designed as scaled integer message since the resolution of float is not sufficient. NOTE: This message is intended for onboard networks / companion computers and higher-bandwidth links and optimized for accuracy and completeness. Please use the GLOBAL_POSITION_INT message for a minimal subset."
)
public class GlobalPositionIntCov implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4, description = "Timestamp (milliseconds since system boot)")
	private long timeBootMs;

	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 2, typeSize = 8, streamLength = 8, description = "Timestamp (microseconds since UNIX epoch) in UTC. 0 for unknown. Commonly filled by the precision time source of a GPS receiver.")
	private BigInteger timeUtc;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, description = "Class id of the estimator this estimate originated from.", enum0 = MavEstimatorType.class)
	private short estimatorType;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 4, typeSize = 4, streamLength = 4, description = "Latitude, expressed as degrees * 1E7")
	private int lat;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 5, typeSize = 4, streamLength = 4, description = "Longitude, expressed as degrees * 1E7")
	private int lon;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 6, typeSize = 4, streamLength = 4, description = "Altitude in meters, expressed as * 1000 (millimeters), above MSL")
	private int alt;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 7, typeSize = 4, streamLength = 4, description = "Altitude above ground in meters, expressed as * 1000 (millimeters)")
	private int relativeAlt;

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 4, description = "Ground X Speed (Latitude), expressed as m/s")
	private float vx;

	@MavlinkMessageParam(mavlinkType = "float", position = 9, typeSize = 4, streamLength = 4, description = "Ground Y Speed (Longitude), expressed as m/s")
	private float vy;

	@MavlinkMessageParam(mavlinkType = "float", position = 10, typeSize = 4, streamLength = 4, description = "Ground Z Speed (Altitude), expressed as m/s")
	private float vz;

	@MavlinkMessageParam(mavlinkType = "float", position = 11, typeSize = 4, streamLength = 144, description = "Covariance matrix (first six entries are the first ROW, next six entries are the second row, etc.)")
	private float[] covariance = new float[36];

	private final int messagePayloadLength = 185;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public GlobalPositionIntCov(long timeBootMs, BigInteger timeUtc, short estimatorType, int lat, int lon, int alt, int relativeAlt, float vx, float vy, float vz, float[] covariance) {
		this.timeBootMs = timeBootMs;
		this.timeUtc = timeUtc;
		this.estimatorType = estimatorType;
		this.lat = lat;
		this.lon = lon;
		this.alt = alt;
		this.relativeAlt = relativeAlt;
		this.vx = vx;
		this.vy = vy;
		this.vz = vz;
		this.covariance = covariance;
	}

	public GlobalPositionIntCov(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 185！");
		}
		messagePayload(messagePayload);
	}

	public GlobalPositionIntCov(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeBootMs = byteArray.getUnsignedInt32(0);
		timeUtc = byteArray.getUnsignedInt64(4);
		estimatorType = byteArray.getUnsignedInt8(12);
		lat = byteArray.getInt32(13);
		lon = byteArray.getInt32(17);
		alt = byteArray.getInt32(21);
		relativeAlt = byteArray.getInt32(25);
		vx = byteArray.getFloat(29);
		vy = byteArray.getFloat(33);
		vz = byteArray.getFloat(37);
		covariance = byteArray.getFloatArray(41,36);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt32(timeBootMs,0);
		byteArray.putUnsignedInt64(timeUtc,4);
		byteArray.putUnsignedInt8(estimatorType,12);
		byteArray.putInt32(lat,13);
		byteArray.putInt32(lon,17);
		byteArray.putInt32(alt,21);
		byteArray.putInt32(relativeAlt,25);
		byteArray.putFloat(vx,29);
		byteArray.putFloat(vy,33);
		byteArray.putFloat(vz,37);
		byteArray.putFloatArray(covariance,41);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final GlobalPositionIntCov setTimeBootMs(long timeBootMs) {
		this.timeBootMs = timeBootMs;
		return this;
	}

	public final long getTimeBootMs() {
		return timeBootMs;
	}

	public final GlobalPositionIntCov setTimeUtc(BigInteger timeUtc) {
		this.timeUtc = timeUtc;
		return this;
	}

	public final BigInteger getTimeUtc() {
		return timeUtc;
	}

	public final GlobalPositionIntCov setEstimatorType(short estimatorType) {
		this.estimatorType = estimatorType;
		return this;
	}

	public final short getEstimatorType() {
		return estimatorType;
	}

	public final GlobalPositionIntCov setLat(int lat) {
		this.lat = lat;
		return this;
	}

	public final int getLat() {
		return lat;
	}

	public final GlobalPositionIntCov setLon(int lon) {
		this.lon = lon;
		return this;
	}

	public final int getLon() {
		return lon;
	}

	public final GlobalPositionIntCov setAlt(int alt) {
		this.alt = alt;
		return this;
	}

	public final int getAlt() {
		return alt;
	}

	public final GlobalPositionIntCov setRelativeAlt(int relativeAlt) {
		this.relativeAlt = relativeAlt;
		return this;
	}

	public final int getRelativeAlt() {
		return relativeAlt;
	}

	public final GlobalPositionIntCov setVx(float vx) {
		this.vx = vx;
		return this;
	}

	public final float getVx() {
		return vx;
	}

	public final GlobalPositionIntCov setVy(float vy) {
		this.vy = vy;
		return this;
	}

	public final float getVy() {
		return vy;
	}

	public final GlobalPositionIntCov setVz(float vz) {
		this.vz = vz;
		return this;
	}

	public final float getVz() {
		return vz;
	}

	public final GlobalPositionIntCov setCovariance(float[] covariance) {
		this.covariance = covariance;
		return this;
	}

	public final float[] getCovariance() {
		return covariance;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			GlobalPositionIntCov other = (GlobalPositionIntCov)o;
			if (!Objects.deepEquals(this.timeBootMs, other.timeBootMs)) {
				return false;
			} else if (!Objects.deepEquals(this.timeUtc, other.timeUtc)) {
				return false;
			} else if (!Objects.deepEquals(this.estimatorType, other.estimatorType)) {
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
				return Objects.deepEquals(this.covariance, other.covariance);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeBootMs);
		result = 31 * result + Objects.hashCode(this.timeUtc);
		result = 31 * result + Objects.hashCode(this.estimatorType);
		result = 31 * result + Objects.hashCode(this.lat);
		result = 31 * result + Objects.hashCode(this.lon);
		result = 31 * result + Objects.hashCode(this.alt);
		result = 31 * result + Objects.hashCode(this.relativeAlt);
		result = 31 * result + Objects.hashCode(this.vx);
		result = 31 * result + Objects.hashCode(this.vy);
		result = 31 * result + Objects.hashCode(this.vz);
		result = 31 * result + Objects.hashCode(this.covariance);
		return result;
	}

	@Override
	public String toString() {
		return "GlobalPositionIntCov{" +
				"timeBootMs=" + timeBootMs +
				", timeUtc=" + timeUtc +
				", estimatorType=" + estimatorType +
				", lat=" + lat +
				", lon=" + lon +
				", alt=" + alt +
				", relativeAlt=" + relativeAlt +
				", vx=" + vx +
				", vy=" + vy +
				", vz=" + vz +
				", covariance=" + Arrays.toString(covariance) +
				'}';
	}
}
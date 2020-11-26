package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.MavEstimatorType;
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
		id = 63,
		messagePayloadLength = 181,
		description = "The filtered global position (e.g. fused GPS and accelerometers). The position is in GPS-frame (right-handed, Z-up). It is designed as scaled integer message since the resolution of float is not sufficient. NOTE: This message is intended for onboard networks / companion computers and higher-bandwidth links and optimized for accuracy and completeness. Please use the GLOBAL_POSITION_INT message for a minimal subset."
)
public class GlobalPositionIntCov implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8, description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.", units = "us")
	private BigInteger timeUsec;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Class id of the estimator this estimate originated from.", enum0 = MavEstimatorType.class)
	private short estimatorType;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 3, typeSize = 4, streamLength = 4, description = "Latitude", units = "degE7")
	private int lat;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 4, typeSize = 4, streamLength = 4, description = "Longitude", units = "degE7")
	private int lon;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 5, typeSize = 4, streamLength = 4, description = "Altitude in meters above MSL", units = "mm")
	private int alt;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 6, typeSize = 4, streamLength = 4, description = "Altitude above ground", units = "mm")
	private int relativeAlt;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4, description = "Ground X Speed (Latitude)", units = "m/s")
	private float vx;

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 4, description = "Ground Y Speed (Longitude)", units = "m/s")
	private float vy;

	@MavlinkMessageParam(mavlinkType = "float", position = 9, typeSize = 4, streamLength = 4, description = "Ground Z Speed (Altitude)", units = "m/s")
	private float vz;

	@MavlinkMessageParam(mavlinkType = "float", position = 10, typeSize = 4, streamLength = 144, description = "Row-major representation of a 6x6 position and velocity 6x6 cross-covariance matrix (states: lat, lon, alt, vx, vy, vz; first six entries are the first ROW, next six entries are the second row, etc.). If unknown, assign NaN value to first element in the array.")
	private float[] covariance = new float[36];

	private final int messagePayloadLength = 181;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public GlobalPositionIntCov(BigInteger timeUsec, short estimatorType, int lat, int lon, int alt, int relativeAlt, float vx, float vy, float vz, float[] covariance) {
		this.timeUsec = timeUsec;
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
			throw new IllegalArgumentException("Byte array length is not equal to 181！");
		}
		messagePayload(messagePayload);
	}

	public GlobalPositionIntCov(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeUsec = byteArray.getUnsignedInt64(0);
		estimatorType = byteArray.getUnsignedInt8(8);
		lat = byteArray.getInt32(9);
		lon = byteArray.getInt32(13);
		alt = byteArray.getInt32(17);
		relativeAlt = byteArray.getInt32(21);
		vx = byteArray.getFloat(25);
		vy = byteArray.getFloat(29);
		vz = byteArray.getFloat(33);
		covariance = byteArray.getFloatArray(37,36);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt64(timeUsec,0);
		byteArray.putUnsignedInt8(estimatorType,8);
		byteArray.putInt32(lat,9);
		byteArray.putInt32(lon,13);
		byteArray.putInt32(alt,17);
		byteArray.putInt32(relativeAlt,21);
		byteArray.putFloat(vx,25);
		byteArray.putFloat(vy,29);
		byteArray.putFloat(vz,33);
		byteArray.putFloatArray(covariance,37);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final GlobalPositionIntCov setTimeUsec(BigInteger timeUsec) {
		this.timeUsec = timeUsec;
		return this;
	}

	public final BigInteger getTimeUsec() {
		return timeUsec;
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
			if (!Objects.deepEquals(this.timeUsec, other.timeUsec)) {
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
		result = 31 * result + Objects.hashCode(this.timeUsec);
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
				"timeUsec=" + timeUsec +
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
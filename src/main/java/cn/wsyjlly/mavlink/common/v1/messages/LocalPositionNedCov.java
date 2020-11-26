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
		id = 64,
		messagePayloadLength = 181,
		description = "The filtered local position (e.g. fused computer vision and accelerometers). Coordinate frame is right-handed, Z-axis down (aeronautical frame, NED / north-east-down convention)"
)
public class LocalPositionNedCov implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4, description = "Timestamp (milliseconds since system boot)")
	private long timeBootMs;

	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 2, typeSize = 8, streamLength = 8, description = "Timestamp (microseconds since UNIX epoch) in UTC. 0 for unknown. Commonly filled by the precision time source of a GPS receiver.")
	private BigInteger timeUtc;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, description = "Class id of the estimator this estimate originated from.", enum0 = MavEstimatorType.class)
	private short estimatorType;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4, description = "X Position")
	private float x;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4, description = "Y Position")
	private float y;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4, description = "Z Position")
	private float z;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4, description = "X Speed")
	private float vx;

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 4, description = "Y Speed")
	private float vy;

	@MavlinkMessageParam(mavlinkType = "float", position = 9, typeSize = 4, streamLength = 4, description = "Z Speed")
	private float vz;

	@MavlinkMessageParam(mavlinkType = "float", position = 10, typeSize = 4, streamLength = 144, description = "Covariance matrix (first six entries are the first ROW, next six entries are the second row, etc.)")
	private float[] covariance = new float[36];

	private final int messagePayloadLength = 181;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public LocalPositionNedCov(long timeBootMs, BigInteger timeUtc, short estimatorType, float x, float y, float z, float vx, float vy, float vz, float[] covariance) {
		this.timeBootMs = timeBootMs;
		this.timeUtc = timeUtc;
		this.estimatorType = estimatorType;
		this.x = x;
		this.y = y;
		this.z = z;
		this.vx = vx;
		this.vy = vy;
		this.vz = vz;
		this.covariance = covariance;
	}

	public LocalPositionNedCov(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 181！");
		}
		messagePayload(messagePayload);
	}

	public LocalPositionNedCov(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeBootMs = byteArray.getUnsignedInt32(0);
		timeUtc = byteArray.getUnsignedInt64(4);
		estimatorType = byteArray.getUnsignedInt8(12);
		x = byteArray.getFloat(13);
		y = byteArray.getFloat(17);
		z = byteArray.getFloat(21);
		vx = byteArray.getFloat(25);
		vy = byteArray.getFloat(29);
		vz = byteArray.getFloat(33);
		covariance = byteArray.getFloatArray(37,36);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt32(timeBootMs,0);
		byteArray.putUnsignedInt64(timeUtc,4);
		byteArray.putUnsignedInt8(estimatorType,12);
		byteArray.putFloat(x,13);
		byteArray.putFloat(y,17);
		byteArray.putFloat(z,21);
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

	public final LocalPositionNedCov setTimeBootMs(long timeBootMs) {
		this.timeBootMs = timeBootMs;
		return this;
	}

	public final long getTimeBootMs() {
		return timeBootMs;
	}

	public final LocalPositionNedCov setTimeUtc(BigInteger timeUtc) {
		this.timeUtc = timeUtc;
		return this;
	}

	public final BigInteger getTimeUtc() {
		return timeUtc;
	}

	public final LocalPositionNedCov setEstimatorType(short estimatorType) {
		this.estimatorType = estimatorType;
		return this;
	}

	public final short getEstimatorType() {
		return estimatorType;
	}

	public final LocalPositionNedCov setX(float x) {
		this.x = x;
		return this;
	}

	public final float getX() {
		return x;
	}

	public final LocalPositionNedCov setY(float y) {
		this.y = y;
		return this;
	}

	public final float getY() {
		return y;
	}

	public final LocalPositionNedCov setZ(float z) {
		this.z = z;
		return this;
	}

	public final float getZ() {
		return z;
	}

	public final LocalPositionNedCov setVx(float vx) {
		this.vx = vx;
		return this;
	}

	public final float getVx() {
		return vx;
	}

	public final LocalPositionNedCov setVy(float vy) {
		this.vy = vy;
		return this;
	}

	public final float getVy() {
		return vy;
	}

	public final LocalPositionNedCov setVz(float vz) {
		this.vz = vz;
		return this;
	}

	public final float getVz() {
		return vz;
	}

	public final LocalPositionNedCov setCovariance(float[] covariance) {
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
			LocalPositionNedCov other = (LocalPositionNedCov)o;
			if (!Objects.deepEquals(this.timeBootMs, other.timeBootMs)) {
				return false;
			} else if (!Objects.deepEquals(this.timeUtc, other.timeUtc)) {
				return false;
			} else if (!Objects.deepEquals(this.estimatorType, other.estimatorType)) {
				return false;
			} else if (!Objects.deepEquals(this.x, other.x)) {
				return false;
			} else if (!Objects.deepEquals(this.y, other.y)) {
				return false;
			} else if (!Objects.deepEquals(this.z, other.z)) {
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
		result = 31 * result + Objects.hashCode(this.x);
		result = 31 * result + Objects.hashCode(this.y);
		result = 31 * result + Objects.hashCode(this.z);
		result = 31 * result + Objects.hashCode(this.vx);
		result = 31 * result + Objects.hashCode(this.vy);
		result = 31 * result + Objects.hashCode(this.vz);
		result = 31 * result + Objects.hashCode(this.covariance);
		return result;
	}

	@Override
	public String toString() {
		return "LocalPositionNedCov{" +
				"timeBootMs=" + timeBootMs +
				", timeUtc=" + timeUtc +
				", estimatorType=" + estimatorType +
				", x=" + x +
				", y=" + y +
				", z=" + z +
				", vx=" + vx +
				", vy=" + vy +
				", vz=" + vz +
				", covariance=" + Arrays.toString(covariance) +
				'}';
	}
}
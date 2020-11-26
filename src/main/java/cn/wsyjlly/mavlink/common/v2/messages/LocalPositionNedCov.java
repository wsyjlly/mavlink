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
		id = 64,
		messagePayloadLength = 225,
		description = "The filtered local position (e.g. fused computer vision and accelerometers). Coordinate frame is right-handed, Z-axis down (aeronautical frame, NED / north-east-down convention)"
)
public class LocalPositionNedCov implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8, description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.", units = "us")
	private BigInteger timeUsec;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Class id of the estimator this estimate originated from.", enum0 = MavEstimatorType.class)
	private short estimatorType;

	@MavlinkMessageParam(mavlinkType = "float", position = 3, typeSize = 4, streamLength = 4, description = "X Position", units = "m")
	private float x;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4, description = "Y Position", units = "m")
	private float y;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4, description = "Z Position", units = "m")
	private float z;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4, description = "X Speed", units = "m/s")
	private float vx;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4, description = "Y Speed", units = "m/s")
	private float vy;

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 4, description = "Z Speed", units = "m/s")
	private float vz;

	@MavlinkMessageParam(mavlinkType = "float", position = 9, typeSize = 4, streamLength = 4, description = "X Acceleration", units = "m/s/s")
	private float ax;

	@MavlinkMessageParam(mavlinkType = "float", position = 10, typeSize = 4, streamLength = 4, description = "Y Acceleration", units = "m/s/s")
	private float ay;

	@MavlinkMessageParam(mavlinkType = "float", position = 11, typeSize = 4, streamLength = 4, description = "Z Acceleration", units = "m/s/s")
	private float az;

	@MavlinkMessageParam(mavlinkType = "float", position = 12, typeSize = 4, streamLength = 180, description = "Row-major representation of position, velocity and acceleration 9x9 cross-covariance matrix upper right triangle (states: x, y, z, vx, vy, vz, ax, ay, az; first nine entries are the first ROW, next eight entries are the second row, etc.). If unknown, assign NaN value to first element in the array.")
	private float[] covariance = new float[45];

	private final int messagePayloadLength = 225;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public LocalPositionNedCov(BigInteger timeUsec, short estimatorType, float x, float y, float z, float vx, float vy, float vz, float ax, float ay, float az, float[] covariance) {
		this.timeUsec = timeUsec;
		this.estimatorType = estimatorType;
		this.x = x;
		this.y = y;
		this.z = z;
		this.vx = vx;
		this.vy = vy;
		this.vz = vz;
		this.ax = ax;
		this.ay = ay;
		this.az = az;
		this.covariance = covariance;
	}

	public LocalPositionNedCov(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 225！");
		}
		messagePayload(messagePayload);
	}

	public LocalPositionNedCov(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeUsec = byteArray.getUnsignedInt64(0);
		estimatorType = byteArray.getUnsignedInt8(8);
		x = byteArray.getFloat(9);
		y = byteArray.getFloat(13);
		z = byteArray.getFloat(17);
		vx = byteArray.getFloat(21);
		vy = byteArray.getFloat(25);
		vz = byteArray.getFloat(29);
		ax = byteArray.getFloat(33);
		ay = byteArray.getFloat(37);
		az = byteArray.getFloat(41);
		covariance = byteArray.getFloatArray(45,45);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt64(timeUsec,0);
		byteArray.putUnsignedInt8(estimatorType,8);
		byteArray.putFloat(x,9);
		byteArray.putFloat(y,13);
		byteArray.putFloat(z,17);
		byteArray.putFloat(vx,21);
		byteArray.putFloat(vy,25);
		byteArray.putFloat(vz,29);
		byteArray.putFloat(ax,33);
		byteArray.putFloat(ay,37);
		byteArray.putFloat(az,41);
		byteArray.putFloatArray(covariance,45);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final LocalPositionNedCov setTimeUsec(BigInteger timeUsec) {
		this.timeUsec = timeUsec;
		return this;
	}

	public final BigInteger getTimeUsec() {
		return timeUsec;
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

	public final LocalPositionNedCov setAx(float ax) {
		this.ax = ax;
		return this;
	}

	public final float getAx() {
		return ax;
	}

	public final LocalPositionNedCov setAy(float ay) {
		this.ay = ay;
		return this;
	}

	public final float getAy() {
		return ay;
	}

	public final LocalPositionNedCov setAz(float az) {
		this.az = az;
		return this;
	}

	public final float getAz() {
		return az;
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
			if (!Objects.deepEquals(this.timeUsec, other.timeUsec)) {
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
			} else if (!Objects.deepEquals(this.ax, other.ax)) {
				return false;
			} else if (!Objects.deepEquals(this.ay, other.ay)) {
				return false;
			} else if (!Objects.deepEquals(this.az, other.az)) {
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
		result = 31 * result + Objects.hashCode(this.x);
		result = 31 * result + Objects.hashCode(this.y);
		result = 31 * result + Objects.hashCode(this.z);
		result = 31 * result + Objects.hashCode(this.vx);
		result = 31 * result + Objects.hashCode(this.vy);
		result = 31 * result + Objects.hashCode(this.vz);
		result = 31 * result + Objects.hashCode(this.ax);
		result = 31 * result + Objects.hashCode(this.ay);
		result = 31 * result + Objects.hashCode(this.az);
		result = 31 * result + Objects.hashCode(this.covariance);
		return result;
	}

	@Override
	public String toString() {
		return "LocalPositionNedCov{" +
				"timeUsec=" + timeUsec +
				", estimatorType=" + estimatorType +
				", x=" + x +
				", y=" + y +
				", z=" + z +
				", vx=" + vx +
				", vy=" + vy +
				", vz=" + vz +
				", ax=" + ax +
				", ay=" + ay +
				", az=" + az +
				", covariance=" + Arrays.toString(covariance) +
				'}';
	}
}
package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
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
		id = 138,
		messagePayloadLength = 120,
		description = "Motion capture attitude and position"
)
public class AttPosMocap implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8, description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.", units = "us")
	private BigInteger timeUsec;

	@MavlinkMessageParam(mavlinkType = "float", position = 2, typeSize = 4, streamLength = 16, description = "Attitude quaternion (w, x, y, z order, zero-rotation is 1, 0, 0, 0)")
	private float[] q = new float[4];

	@MavlinkMessageParam(mavlinkType = "float", position = 3, typeSize = 4, streamLength = 4, description = "X position (NED)", units = "m")
	private float x;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4, description = "Y position (NED)", units = "m")
	private float y;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4, description = "Z position (NED)", units = "m")
	private float z;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 84, description = "Row-major representation of a pose 6x6 cross-covariance matrix upper right triangle (states: x, y, z, roll, pitch, yaw; first six entries are the first ROW, next five entries are the second ROW, etc.). If unknown, assign NaN value to first element in the array.")
	private float[] covariance = new float[21];

	private final int messagePayloadLength = 120;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public AttPosMocap(BigInteger timeUsec, float[] q, float x, float y, float z, float[] covariance) {
		this.timeUsec = timeUsec;
		this.q = q;
		this.x = x;
		this.y = y;
		this.z = z;
		this.covariance = covariance;
	}

	public AttPosMocap(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 120！");
		}
		messagePayload(messagePayload);
	}

	public AttPosMocap(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeUsec = byteArray.getUnsignedInt64(0);
		q = byteArray.getFloatArray(8,4);
		x = byteArray.getFloat(24);
		y = byteArray.getFloat(28);
		z = byteArray.getFloat(32);
		covariance = byteArray.getFloatArray(36,21);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt64(timeUsec,0);
		byteArray.putFloatArray(q,8);
		byteArray.putFloat(x,24);
		byteArray.putFloat(y,28);
		byteArray.putFloat(z,32);
		byteArray.putFloatArray(covariance,36);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final AttPosMocap setTimeUsec(BigInteger timeUsec) {
		this.timeUsec = timeUsec;
		return this;
	}

	public final BigInteger getTimeUsec() {
		return timeUsec;
	}

	public final AttPosMocap setQ(float[] q) {
		this.q = q;
		return this;
	}

	public final float[] getQ() {
		return q;
	}

	public final AttPosMocap setX(float x) {
		this.x = x;
		return this;
	}

	public final float getX() {
		return x;
	}

	public final AttPosMocap setY(float y) {
		this.y = y;
		return this;
	}

	public final float getY() {
		return y;
	}

	public final AttPosMocap setZ(float z) {
		this.z = z;
		return this;
	}

	public final float getZ() {
		return z;
	}

	public final AttPosMocap setCovariance(float[] covariance) {
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
			AttPosMocap other = (AttPosMocap)o;
			if (!Objects.deepEquals(this.timeUsec, other.timeUsec)) {
				return false;
			} else if (!Objects.deepEquals(this.q, other.q)) {
				return false;
			} else if (!Objects.deepEquals(this.x, other.x)) {
				return false;
			} else if (!Objects.deepEquals(this.y, other.y)) {
				return false;
			} else if (!Objects.deepEquals(this.z, other.z)) {
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
		result = 31 * result + Objects.hashCode(this.q);
		result = 31 * result + Objects.hashCode(this.x);
		result = 31 * result + Objects.hashCode(this.y);
		result = 31 * result + Objects.hashCode(this.z);
		result = 31 * result + Objects.hashCode(this.covariance);
		return result;
	}

	@Override
	public String toString() {
		return "AttPosMocap{" +
				"timeUsec=" + timeUsec +
				", q=" + Arrays.toString(q) +
				", x=" + x +
				", y=" + y +
				", z=" + z +
				", covariance=" + Arrays.toString(covariance) +
				'}';
	}
}
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
		id = 104,
		messagePayloadLength = 116,
		description = "Global position estimate from a Vicon motion system source."
)
public class ViconPositionEstimate implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8, description = "Timestamp (UNIX time or time since system boot)", units = "us")
	private BigInteger usec;

	@MavlinkMessageParam(mavlinkType = "float", position = 2, typeSize = 4, streamLength = 4, description = "Global X position", units = "m")
	private float x;

	@MavlinkMessageParam(mavlinkType = "float", position = 3, typeSize = 4, streamLength = 4, description = "Global Y position", units = "m")
	private float y;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4, description = "Global Z position", units = "m")
	private float z;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4, description = "Roll angle", units = "rad")
	private float roll;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4, description = "Pitch angle", units = "rad")
	private float pitch;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4, description = "Yaw angle", units = "rad")
	private float yaw;

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 84, description = "Row-major representation of 6x6 pose cross-covariance matrix upper right triangle (states: x, y, z, roll, pitch, yaw; first six entries are the first ROW, next five entries are the second ROW, etc.). If unknown, assign NaN value to first element in the array.")
	private float[] covariance = new float[21];

	private final int messagePayloadLength = 116;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public ViconPositionEstimate(BigInteger usec, float x, float y, float z, float roll, float pitch, float yaw, float[] covariance) {
		this.usec = usec;
		this.x = x;
		this.y = y;
		this.z = z;
		this.roll = roll;
		this.pitch = pitch;
		this.yaw = yaw;
		this.covariance = covariance;
	}

	public ViconPositionEstimate(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 116！");
		}
		messagePayload(messagePayload);
	}

	public ViconPositionEstimate(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		usec = byteArray.getUnsignedInt64(0);
		x = byteArray.getFloat(8);
		y = byteArray.getFloat(12);
		z = byteArray.getFloat(16);
		roll = byteArray.getFloat(20);
		pitch = byteArray.getFloat(24);
		yaw = byteArray.getFloat(28);
		covariance = byteArray.getFloatArray(32,21);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt64(usec,0);
		byteArray.putFloat(x,8);
		byteArray.putFloat(y,12);
		byteArray.putFloat(z,16);
		byteArray.putFloat(roll,20);
		byteArray.putFloat(pitch,24);
		byteArray.putFloat(yaw,28);
		byteArray.putFloatArray(covariance,32);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final ViconPositionEstimate setUsec(BigInteger usec) {
		this.usec = usec;
		return this;
	}

	public final BigInteger getUsec() {
		return usec;
	}

	public final ViconPositionEstimate setX(float x) {
		this.x = x;
		return this;
	}

	public final float getX() {
		return x;
	}

	public final ViconPositionEstimate setY(float y) {
		this.y = y;
		return this;
	}

	public final float getY() {
		return y;
	}

	public final ViconPositionEstimate setZ(float z) {
		this.z = z;
		return this;
	}

	public final float getZ() {
		return z;
	}

	public final ViconPositionEstimate setRoll(float roll) {
		this.roll = roll;
		return this;
	}

	public final float getRoll() {
		return roll;
	}

	public final ViconPositionEstimate setPitch(float pitch) {
		this.pitch = pitch;
		return this;
	}

	public final float getPitch() {
		return pitch;
	}

	public final ViconPositionEstimate setYaw(float yaw) {
		this.yaw = yaw;
		return this;
	}

	public final float getYaw() {
		return yaw;
	}

	public final ViconPositionEstimate setCovariance(float[] covariance) {
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
			ViconPositionEstimate other = (ViconPositionEstimate)o;
			if (!Objects.deepEquals(this.usec, other.usec)) {
				return false;
			} else if (!Objects.deepEquals(this.x, other.x)) {
				return false;
			} else if (!Objects.deepEquals(this.y, other.y)) {
				return false;
			} else if (!Objects.deepEquals(this.z, other.z)) {
				return false;
			} else if (!Objects.deepEquals(this.roll, other.roll)) {
				return false;
			} else if (!Objects.deepEquals(this.pitch, other.pitch)) {
				return false;
			} else if (!Objects.deepEquals(this.yaw, other.yaw)) {
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
		result = 31 * result + Objects.hashCode(this.usec);
		result = 31 * result + Objects.hashCode(this.x);
		result = 31 * result + Objects.hashCode(this.y);
		result = 31 * result + Objects.hashCode(this.z);
		result = 31 * result + Objects.hashCode(this.roll);
		result = 31 * result + Objects.hashCode(this.pitch);
		result = 31 * result + Objects.hashCode(this.yaw);
		result = 31 * result + Objects.hashCode(this.covariance);
		return result;
	}

	@Override
	public String toString() {
		return "ViconPositionEstimate{" +
				"usec=" + usec +
				", x=" + x +
				", y=" + y +
				", z=" + z +
				", roll=" + roll +
				", pitch=" + pitch +
				", yaw=" + yaw +
				", covariance=" + Arrays.toString(covariance) +
				'}';
	}
}
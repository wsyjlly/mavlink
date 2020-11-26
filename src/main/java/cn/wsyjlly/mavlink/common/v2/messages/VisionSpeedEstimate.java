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
		id = 103,
		messagePayloadLength = 57,
		description = "Speed estimate from a vision source."
)
public class VisionSpeedEstimate implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8, description = "Timestamp (UNIX time or time since system boot)", units = "us")
	private BigInteger usec;

	@MavlinkMessageParam(mavlinkType = "float", position = 2, typeSize = 4, streamLength = 4, description = "Global X speed", units = "m/s")
	private float x;

	@MavlinkMessageParam(mavlinkType = "float", position = 3, typeSize = 4, streamLength = 4, description = "Global Y speed", units = "m/s")
	private float y;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4, description = "Global Z speed", units = "m/s")
	private float z;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 36, description = "Row-major representation of 3x3 linear velocity covariance matrix (states: vx, vy, vz; 1st three entries - 1st row, etc.). If unknown, assign NaN value to first element in the array.")
	private float[] covariance = new float[9];

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 6, typeSize = 1, streamLength = 1, description = "Estimate reset counter. This should be incremented when the estimate resets in any of the dimensions (position, velocity, attitude, angular speed). This is designed to be used when e.g an external SLAM system detects a loop-closure and the estimate jumps.")
	private short resetCounter;

	private final int messagePayloadLength = 57;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public VisionSpeedEstimate(BigInteger usec, float x, float y, float z, float[] covariance, short resetCounter) {
		this.usec = usec;
		this.x = x;
		this.y = y;
		this.z = z;
		this.covariance = covariance;
		this.resetCounter = resetCounter;
	}

	public VisionSpeedEstimate(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 57！");
		}
		messagePayload(messagePayload);
	}

	public VisionSpeedEstimate(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		usec = byteArray.getUnsignedInt64(0);
		x = byteArray.getFloat(8);
		y = byteArray.getFloat(12);
		z = byteArray.getFloat(16);
		covariance = byteArray.getFloatArray(20,9);
		resetCounter = byteArray.getUnsignedInt8(56);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt64(usec,0);
		byteArray.putFloat(x,8);
		byteArray.putFloat(y,12);
		byteArray.putFloat(z,16);
		byteArray.putFloatArray(covariance,20);
		byteArray.putUnsignedInt8(resetCounter,56);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final VisionSpeedEstimate setUsec(BigInteger usec) {
		this.usec = usec;
		return this;
	}

	public final BigInteger getUsec() {
		return usec;
	}

	public final VisionSpeedEstimate setX(float x) {
		this.x = x;
		return this;
	}

	public final float getX() {
		return x;
	}

	public final VisionSpeedEstimate setY(float y) {
		this.y = y;
		return this;
	}

	public final float getY() {
		return y;
	}

	public final VisionSpeedEstimate setZ(float z) {
		this.z = z;
		return this;
	}

	public final float getZ() {
		return z;
	}

	public final VisionSpeedEstimate setCovariance(float[] covariance) {
		this.covariance = covariance;
		return this;
	}

	public final float[] getCovariance() {
		return covariance;
	}

	public final VisionSpeedEstimate setResetCounter(short resetCounter) {
		this.resetCounter = resetCounter;
		return this;
	}

	public final short getResetCounter() {
		return resetCounter;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			VisionSpeedEstimate other = (VisionSpeedEstimate)o;
			if (!Objects.deepEquals(this.usec, other.usec)) {
				return false;
			} else if (!Objects.deepEquals(this.x, other.x)) {
				return false;
			} else if (!Objects.deepEquals(this.y, other.y)) {
				return false;
			} else if (!Objects.deepEquals(this.z, other.z)) {
				return false;
			} else if (!Objects.deepEquals(this.covariance, other.covariance)) {
				return false;
			} else {
				return Objects.deepEquals(this.resetCounter, other.resetCounter);
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
		result = 31 * result + Objects.hashCode(this.covariance);
		result = 31 * result + Objects.hashCode(this.resetCounter);
		return result;
	}

	@Override
	public String toString() {
		return "VisionSpeedEstimate{" +
				"usec=" + usec +
				", x=" + x +
				", y=" + y +
				", z=" + z +
				", covariance=" + Arrays.toString(covariance) +
				", resetCounter=" + resetCounter +
				'}';
	}
}
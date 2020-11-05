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
		id = 104,
		messagePayloadLength = 32,
		description = "Optical flow from a flow sensor (e.g. optical mouse sensor)"
)
public class ViconPositionEstimate implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8)
	private BigInteger usec;

	@MavlinkMessageParam(mavlinkType = "float", position = 2, typeSize = 4, streamLength = 4)
	private float x;

	@MavlinkMessageParam(mavlinkType = "float", position = 3, typeSize = 4, streamLength = 4)
	private float y;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4)
	private float z;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4)
	private float roll;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4)
	private float pitch;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4)
	private float yaw;

	private final int messagePayloadLength = 32;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public ViconPositionEstimate(BigInteger usec, float x, float y, float z, float roll, float pitch, float yaw) {
		this.usec = usec;
		this.x = x;
		this.y = y;
		this.z = z;
		this.roll = roll;
		this.pitch = pitch;
		this.yaw = yaw;
	}

	public ViconPositionEstimate(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 32！");
		}
		messagePayload(messagePayload);
	}

	public ViconPositionEstimate(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.usec = byteArray.getUnsignedInt64(0);
		this.x = byteArray.getFloat(8);
		this.y = byteArray.getFloat(12);
		this.z = byteArray.getFloat(16);
		this.roll = byteArray.getFloat(20);
		this.pitch = byteArray.getFloat(24);
		this.yaw = byteArray.getFloat(28);
	}

	@Override
	public byte[] messagePayload() {
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
		result = 31 * result + Objects.hashCode(this.usec);
		result = 31 * result + Objects.hashCode(this.x);
		result = 31 * result + Objects.hashCode(this.y);
		result = 31 * result + Objects.hashCode(this.z);
		result = 31 * result + Objects.hashCode(this.roll);
		result = 31 * result + Objects.hashCode(this.pitch);
		result = 31 * result + Objects.hashCode(this.yaw);
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
				'}';
	}
}
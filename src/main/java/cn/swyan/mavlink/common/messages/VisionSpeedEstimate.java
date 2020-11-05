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
		id = 103,
		messagePayloadLength = 20,
		description = "Optical flow from a flow sensor (e.g. optical mouse sensor)"
)
public class VisionSpeedEstimate implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8)
	private BigInteger usec;

	@MavlinkMessageParam(mavlinkType = "float", position = 2, typeSize = 4, streamLength = 4)
	private float x;

	@MavlinkMessageParam(mavlinkType = "float", position = 3, typeSize = 4, streamLength = 4)
	private float y;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4)
	private float z;

	private final int messagePayloadLength = 20;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public VisionSpeedEstimate(BigInteger usec, float x, float y, float z) {
		this.usec = usec;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public VisionSpeedEstimate(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 20！");
		}
		messagePayload(messagePayload);
	}

	public VisionSpeedEstimate(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.usec = byteArray.getUnsignedInt64(0);
		this.x = byteArray.getFloat(8);
		this.y = byteArray.getFloat(12);
		this.z = byteArray.getFloat(16);
	}

	@Override
	public byte[] messagePayload() {
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
			} else {
				return Objects.deepEquals(this.z, other.z);
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
		return result;
	}

	@Override
	public String toString() {
		return "VisionSpeedEstimate{" +
				"usec=" + usec +
				", x=" + x +
				", y=" + y +
				", z=" + z +
				'}';
	}
}
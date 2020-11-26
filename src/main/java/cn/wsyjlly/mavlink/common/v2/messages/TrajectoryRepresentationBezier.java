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
		id = 333,
		messagePayloadLength = 109,
		description = "Describe a trajectory using an array of up-to 5 bezier control points in the local frame (MAV_FRAME_LOCAL_NED)."
)
public class TrajectoryRepresentationBezier implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8, description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.", units = "us")
	private BigInteger timeUsec;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Number of valid control points (up-to 5 points are possible)")
	private short validPoints;

	@MavlinkMessageParam(mavlinkType = "float", position = 3, typeSize = 4, streamLength = 20, description = "X-coordinate of bezier control points. Set to NaN if not being used", units = "m")
	private float[] posX = new float[5];

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 20, description = "Y-coordinate of bezier control points. Set to NaN if not being used", units = "m")
	private float[] posY = new float[5];

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 20, description = "Z-coordinate of bezier control points. Set to NaN if not being used", units = "m")
	private float[] posZ = new float[5];

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 20, description = "Bezier time horizon. Set to NaN if velocity/acceleration should not be incorporated", units = "s")
	private float[] delta = new float[5];

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 20, description = "Yaw. Set to NaN for unchanged", units = "rad")
	private float[] posYaw = new float[5];

	private final int messagePayloadLength = 109;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public TrajectoryRepresentationBezier(BigInteger timeUsec, short validPoints, float[] posX, float[] posY, float[] posZ, float[] delta, float[] posYaw) {
		this.timeUsec = timeUsec;
		this.validPoints = validPoints;
		this.posX = posX;
		this.posY = posY;
		this.posZ = posZ;
		this.delta = delta;
		this.posYaw = posYaw;
	}

	public TrajectoryRepresentationBezier(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 109！");
		}
		messagePayload(messagePayload);
	}

	public TrajectoryRepresentationBezier(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeUsec = byteArray.getUnsignedInt64(0);
		validPoints = byteArray.getUnsignedInt8(8);
		posX = byteArray.getFloatArray(9,5);
		posY = byteArray.getFloatArray(29,5);
		posZ = byteArray.getFloatArray(49,5);
		delta = byteArray.getFloatArray(69,5);
		posYaw = byteArray.getFloatArray(89,5);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt64(timeUsec,0);
		byteArray.putUnsignedInt8(validPoints,8);
		byteArray.putFloatArray(posX,9);
		byteArray.putFloatArray(posY,29);
		byteArray.putFloatArray(posZ,49);
		byteArray.putFloatArray(delta,69);
		byteArray.putFloatArray(posYaw,89);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final TrajectoryRepresentationBezier setTimeUsec(BigInteger timeUsec) {
		this.timeUsec = timeUsec;
		return this;
	}

	public final BigInteger getTimeUsec() {
		return timeUsec;
	}

	public final TrajectoryRepresentationBezier setValidPoints(short validPoints) {
		this.validPoints = validPoints;
		return this;
	}

	public final short getValidPoints() {
		return validPoints;
	}

	public final TrajectoryRepresentationBezier setPosX(float[] posX) {
		this.posX = posX;
		return this;
	}

	public final float[] getPosX() {
		return posX;
	}

	public final TrajectoryRepresentationBezier setPosY(float[] posY) {
		this.posY = posY;
		return this;
	}

	public final float[] getPosY() {
		return posY;
	}

	public final TrajectoryRepresentationBezier setPosZ(float[] posZ) {
		this.posZ = posZ;
		return this;
	}

	public final float[] getPosZ() {
		return posZ;
	}

	public final TrajectoryRepresentationBezier setDelta(float[] delta) {
		this.delta = delta;
		return this;
	}

	public final float[] getDelta() {
		return delta;
	}

	public final TrajectoryRepresentationBezier setPosYaw(float[] posYaw) {
		this.posYaw = posYaw;
		return this;
	}

	public final float[] getPosYaw() {
		return posYaw;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			TrajectoryRepresentationBezier other = (TrajectoryRepresentationBezier)o;
			if (!Objects.deepEquals(this.timeUsec, other.timeUsec)) {
				return false;
			} else if (!Objects.deepEquals(this.validPoints, other.validPoints)) {
				return false;
			} else if (!Objects.deepEquals(this.posX, other.posX)) {
				return false;
			} else if (!Objects.deepEquals(this.posY, other.posY)) {
				return false;
			} else if (!Objects.deepEquals(this.posZ, other.posZ)) {
				return false;
			} else if (!Objects.deepEquals(this.delta, other.delta)) {
				return false;
			} else {
				return Objects.deepEquals(this.posYaw, other.posYaw);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeUsec);
		result = 31 * result + Objects.hashCode(this.validPoints);
		result = 31 * result + Objects.hashCode(this.posX);
		result = 31 * result + Objects.hashCode(this.posY);
		result = 31 * result + Objects.hashCode(this.posZ);
		result = 31 * result + Objects.hashCode(this.delta);
		result = 31 * result + Objects.hashCode(this.posYaw);
		return result;
	}

	@Override
	public String toString() {
		return "TrajectoryRepresentationBezier{" +
				"timeUsec=" + timeUsec +
				", validPoints=" + validPoints +
				", posX=" + Arrays.toString(posX) +
				", posY=" + Arrays.toString(posY) +
				", posZ=" + Arrays.toString(posZ) +
				", delta=" + Arrays.toString(delta) +
				", posYaw=" + Arrays.toString(posYaw) +
				'}';
	}
}
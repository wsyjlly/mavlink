package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.LandingTargetType;
import cn.wsyjlly.mavlink.common.v2.enums.MavFrame;
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
		id = 149,
		messagePayloadLength = 60,
		description = "The location of a landing target. See: https://mavlink.io/en/services/landing_target.html"
)
public class LandingTarget implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8, description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.", units = "us")
	private BigInteger timeUsec;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "The ID of the target if multiple targets are present")
	private short targetNum;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, description = "Coordinate frame used for following fields.", enum0 = MavFrame.class)
	private short frame;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4, description = "X-axis angular offset of the target from the center of the image", units = "rad")
	private float angleX;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4, description = "Y-axis angular offset of the target from the center of the image", units = "rad")
	private float angleY;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4, description = "Distance to the target from the vehicle", units = "m")
	private float distance;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4, description = "Size of target along x-axis", units = "rad")
	private float sizeX;

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 4, description = "Size of target along y-axis", units = "rad")
	private float sizeY;

	@MavlinkMessageParam(mavlinkType = "float", position = 9, typeSize = 4, streamLength = 4, description = "X Position of the landing target in MAV_FRAME", units = "m")
	private float x;

	@MavlinkMessageParam(mavlinkType = "float", position = 10, typeSize = 4, streamLength = 4, description = "Y Position of the landing target in MAV_FRAME", units = "m")
	private float y;

	@MavlinkMessageParam(mavlinkType = "float", position = 11, typeSize = 4, streamLength = 4, description = "Z Position of the landing target in MAV_FRAME", units = "m")
	private float z;

	@MavlinkMessageParam(mavlinkType = "float", position = 12, typeSize = 4, streamLength = 16, description = "Quaternion of landing target orientation (w, x, y, z order, zero-rotation is 1, 0, 0, 0)")
	private float[] q = new float[4];

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 13, typeSize = 1, streamLength = 1, description = "Type of landing target", enum0 = LandingTargetType.class)
	private short type;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 14, typeSize = 1, streamLength = 1, description = "Boolean indicating whether the position fields (x, y, z, q, type) contain valid target position information (valid: 1, invalid: 0). Default is 0 (invalid).")
	private short positionValid;

	private final int messagePayloadLength = 60;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public LandingTarget(BigInteger timeUsec, short targetNum, short frame, float angleX, float angleY, float distance, float sizeX, float sizeY, float x, float y, float z, float[] q, short type, short positionValid) {
		this.timeUsec = timeUsec;
		this.targetNum = targetNum;
		this.frame = frame;
		this.angleX = angleX;
		this.angleY = angleY;
		this.distance = distance;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.x = x;
		this.y = y;
		this.z = z;
		this.q = q;
		this.type = type;
		this.positionValid = positionValid;
	}

	public LandingTarget(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 60！");
		}
		messagePayload(messagePayload);
	}

	public LandingTarget(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeUsec = byteArray.getUnsignedInt64(0);
		targetNum = byteArray.getUnsignedInt8(8);
		frame = byteArray.getUnsignedInt8(9);
		angleX = byteArray.getFloat(10);
		angleY = byteArray.getFloat(14);
		distance = byteArray.getFloat(18);
		sizeX = byteArray.getFloat(22);
		sizeY = byteArray.getFloat(26);
		x = byteArray.getFloat(30);
		y = byteArray.getFloat(34);
		z = byteArray.getFloat(38);
		q = byteArray.getFloatArray(42,4);
		type = byteArray.getUnsignedInt8(58);
		positionValid = byteArray.getUnsignedInt8(59);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt64(timeUsec,0);
		byteArray.putUnsignedInt8(targetNum,8);
		byteArray.putUnsignedInt8(frame,9);
		byteArray.putFloat(angleX,10);
		byteArray.putFloat(angleY,14);
		byteArray.putFloat(distance,18);
		byteArray.putFloat(sizeX,22);
		byteArray.putFloat(sizeY,26);
		byteArray.putFloat(x,30);
		byteArray.putFloat(y,34);
		byteArray.putFloat(z,38);
		byteArray.putFloatArray(q,42);
		byteArray.putUnsignedInt8(type,58);
		byteArray.putUnsignedInt8(positionValid,59);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final LandingTarget setTimeUsec(BigInteger timeUsec) {
		this.timeUsec = timeUsec;
		return this;
	}

	public final BigInteger getTimeUsec() {
		return timeUsec;
	}

	public final LandingTarget setTargetNum(short targetNum) {
		this.targetNum = targetNum;
		return this;
	}

	public final short getTargetNum() {
		return targetNum;
	}

	public final LandingTarget setFrame(short frame) {
		this.frame = frame;
		return this;
	}

	public final short getFrame() {
		return frame;
	}

	public final LandingTarget setAngleX(float angleX) {
		this.angleX = angleX;
		return this;
	}

	public final float getAngleX() {
		return angleX;
	}

	public final LandingTarget setAngleY(float angleY) {
		this.angleY = angleY;
		return this;
	}

	public final float getAngleY() {
		return angleY;
	}

	public final LandingTarget setDistance(float distance) {
		this.distance = distance;
		return this;
	}

	public final float getDistance() {
		return distance;
	}

	public final LandingTarget setSizeX(float sizeX) {
		this.sizeX = sizeX;
		return this;
	}

	public final float getSizeX() {
		return sizeX;
	}

	public final LandingTarget setSizeY(float sizeY) {
		this.sizeY = sizeY;
		return this;
	}

	public final float getSizeY() {
		return sizeY;
	}

	public final LandingTarget setX(float x) {
		this.x = x;
		return this;
	}

	public final float getX() {
		return x;
	}

	public final LandingTarget setY(float y) {
		this.y = y;
		return this;
	}

	public final float getY() {
		return y;
	}

	public final LandingTarget setZ(float z) {
		this.z = z;
		return this;
	}

	public final float getZ() {
		return z;
	}

	public final LandingTarget setQ(float[] q) {
		this.q = q;
		return this;
	}

	public final float[] getQ() {
		return q;
	}

	public final LandingTarget setType(short type) {
		this.type = type;
		return this;
	}

	public final short getType() {
		return type;
	}

	public final LandingTarget setPositionValid(short positionValid) {
		this.positionValid = positionValid;
		return this;
	}

	public final short getPositionValid() {
		return positionValid;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			LandingTarget other = (LandingTarget)o;
			if (!Objects.deepEquals(this.timeUsec, other.timeUsec)) {
				return false;
			} else if (!Objects.deepEquals(this.targetNum, other.targetNum)) {
				return false;
			} else if (!Objects.deepEquals(this.frame, other.frame)) {
				return false;
			} else if (!Objects.deepEquals(this.angleX, other.angleX)) {
				return false;
			} else if (!Objects.deepEquals(this.angleY, other.angleY)) {
				return false;
			} else if (!Objects.deepEquals(this.distance, other.distance)) {
				return false;
			} else if (!Objects.deepEquals(this.sizeX, other.sizeX)) {
				return false;
			} else if (!Objects.deepEquals(this.sizeY, other.sizeY)) {
				return false;
			} else if (!Objects.deepEquals(this.x, other.x)) {
				return false;
			} else if (!Objects.deepEquals(this.y, other.y)) {
				return false;
			} else if (!Objects.deepEquals(this.z, other.z)) {
				return false;
			} else if (!Objects.deepEquals(this.q, other.q)) {
				return false;
			} else if (!Objects.deepEquals(this.type, other.type)) {
				return false;
			} else {
				return Objects.deepEquals(this.positionValid, other.positionValid);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeUsec);
		result = 31 * result + Objects.hashCode(this.targetNum);
		result = 31 * result + Objects.hashCode(this.frame);
		result = 31 * result + Objects.hashCode(this.angleX);
		result = 31 * result + Objects.hashCode(this.angleY);
		result = 31 * result + Objects.hashCode(this.distance);
		result = 31 * result + Objects.hashCode(this.sizeX);
		result = 31 * result + Objects.hashCode(this.sizeY);
		result = 31 * result + Objects.hashCode(this.x);
		result = 31 * result + Objects.hashCode(this.y);
		result = 31 * result + Objects.hashCode(this.z);
		result = 31 * result + Objects.hashCode(this.q);
		result = 31 * result + Objects.hashCode(this.type);
		result = 31 * result + Objects.hashCode(this.positionValid);
		return result;
	}

	@Override
	public String toString() {
		return "LandingTarget{" +
				"timeUsec=" + timeUsec +
				", targetNum=" + targetNum +
				", frame=" + frame +
				", angleX=" + angleX +
				", angleY=" + angleY +
				", distance=" + distance +
				", sizeX=" + sizeX +
				", sizeY=" + sizeY +
				", x=" + x +
				", y=" + y +
				", z=" + z +
				", q=" + Arrays.toString(q) +
				", type=" + type +
				", positionValid=" + positionValid +
				'}';
	}
}
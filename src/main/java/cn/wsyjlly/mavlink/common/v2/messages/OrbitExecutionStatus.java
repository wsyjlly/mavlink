package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.MavFrame;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
import java.math.BigInteger;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 360,
		messagePayloadLength = 25,
		description = "Vehicle status report that is sent out while orbit execution is in progress (see MAV_CMD_DO_ORBIT)."
)
public class OrbitExecutionStatus implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8, description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.", units = "us")
	private BigInteger timeUsec;

	@MavlinkMessageParam(mavlinkType = "float", position = 2, typeSize = 4, streamLength = 4, description = "Radius of the orbit circle. Positive values orbit clockwise, negative values orbit counter-clockwise.", units = "m")
	private float radius;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, description = "The coordinate system of the fields: x, y, z.", enum0 = MavFrame.class)
	private short frame;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 4, typeSize = 4, streamLength = 4, description = "X coordinate of center point. Coordinate system depends on frame field: local = x position in meters * 1e4, global = latitude in degrees * 1e7.")
	private int x;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 5, typeSize = 4, streamLength = 4, description = "Y coordinate of center point. Coordinate system depends on frame field: local = x position in meters * 1e4, global = latitude in degrees * 1e7.")
	private int y;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4, description = "Altitude of center point. Coordinate system depends on frame field.", units = "m")
	private float z;

	private final int messagePayloadLength = 25;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public OrbitExecutionStatus(BigInteger timeUsec, float radius, short frame, int x, int y, float z) {
		this.timeUsec = timeUsec;
		this.radius = radius;
		this.frame = frame;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public OrbitExecutionStatus(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 25！");
		}
		messagePayload(messagePayload);
	}

	public OrbitExecutionStatus(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeUsec = byteArray.getUnsignedInt64(0);
		radius = byteArray.getFloat(8);
		frame = byteArray.getUnsignedInt8(12);
		x = byteArray.getInt32(13);
		y = byteArray.getInt32(17);
		z = byteArray.getFloat(21);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt64(timeUsec,0);
		byteArray.putFloat(radius,8);
		byteArray.putUnsignedInt8(frame,12);
		byteArray.putInt32(x,13);
		byteArray.putInt32(y,17);
		byteArray.putFloat(z,21);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final OrbitExecutionStatus setTimeUsec(BigInteger timeUsec) {
		this.timeUsec = timeUsec;
		return this;
	}

	public final BigInteger getTimeUsec() {
		return timeUsec;
	}

	public final OrbitExecutionStatus setRadius(float radius) {
		this.radius = radius;
		return this;
	}

	public final float getRadius() {
		return radius;
	}

	public final OrbitExecutionStatus setFrame(short frame) {
		this.frame = frame;
		return this;
	}

	public final short getFrame() {
		return frame;
	}

	public final OrbitExecutionStatus setX(int x) {
		this.x = x;
		return this;
	}

	public final int getX() {
		return x;
	}

	public final OrbitExecutionStatus setY(int y) {
		this.y = y;
		return this;
	}

	public final int getY() {
		return y;
	}

	public final OrbitExecutionStatus setZ(float z) {
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
			OrbitExecutionStatus other = (OrbitExecutionStatus)o;
			if (!Objects.deepEquals(this.timeUsec, other.timeUsec)) {
				return false;
			} else if (!Objects.deepEquals(this.radius, other.radius)) {
				return false;
			} else if (!Objects.deepEquals(this.frame, other.frame)) {
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
		result = 31 * result + Objects.hashCode(this.timeUsec);
		result = 31 * result + Objects.hashCode(this.radius);
		result = 31 * result + Objects.hashCode(this.frame);
		result = 31 * result + Objects.hashCode(this.x);
		result = 31 * result + Objects.hashCode(this.y);
		result = 31 * result + Objects.hashCode(this.z);
		return result;
	}

	@Override
	public String toString() {
		return "OrbitExecutionStatus{" +
				"timeUsec=" + timeUsec +
				", radius=" + radius +
				", frame=" + frame +
				", x=" + x +
				", y=" + y +
				", z=" + z +
				'}';
	}
}
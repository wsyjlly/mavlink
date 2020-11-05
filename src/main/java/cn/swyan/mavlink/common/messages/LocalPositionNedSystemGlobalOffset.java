package cn.swyan.mavlink.common.messages;

import cn.swyan.mavlink.annotation.MavlinkMessage;
import cn.swyan.mavlink.annotation.MavlinkMessageParam;
import cn.swyan.mavlink.common.Message;
import cn.swyan.mavlink.protocol.ByteArray;
import cn.swyan.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * @Author YSW
 * @Description
 * @Date 2020.11.04 - 03:56
 **********************************/

@MavlinkMessage(
		id = 89,
		messagePayloadLength = 28,
		description = "The offset in X, Y, Z and yaw between the LOCAL_POSITION_NED messages of MAV X and the global coordinate frame in NED coordinates. Coordinate frame is right-handed, Z-axis down (aeronautical frame, NED / north-east-down convention)"
)
public class LocalPositionNedSystemGlobalOffset implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4)
	private long timeBootMs;

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

	private final int messagePayloadLength = 28;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public LocalPositionNedSystemGlobalOffset(long timeBootMs, float x, float y, float z, float roll, float pitch, float yaw) {
		this.timeBootMs = timeBootMs;
		this.x = x;
		this.y = y;
		this.z = z;
		this.roll = roll;
		this.pitch = pitch;
		this.yaw = yaw;
	}

	public LocalPositionNedSystemGlobalOffset(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 28！");
		}
		messagePayload(messagePayload);
	}

	public LocalPositionNedSystemGlobalOffset(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.timeBootMs = byteArray.getUnsignedInt32(0);
		this.x = byteArray.getFloat(4);
		this.y = byteArray.getFloat(8);
		this.z = byteArray.getFloat(12);
		this.roll = byteArray.getFloat(16);
		this.pitch = byteArray.getFloat(20);
		this.yaw = byteArray.getFloat(24);
	}

	@Override
	public byte[] messagePayload() {
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final LocalPositionNedSystemGlobalOffset setTimeBootMs(long timeBootMs) {
		this.timeBootMs = timeBootMs;
		return this;
	}

	public final long getTimeBootMs() {
		return timeBootMs;
	}

	public final LocalPositionNedSystemGlobalOffset setX(float x) {
		this.x = x;
		return this;
	}

	public final float getX() {
		return x;
	}

	public final LocalPositionNedSystemGlobalOffset setY(float y) {
		this.y = y;
		return this;
	}

	public final float getY() {
		return y;
	}

	public final LocalPositionNedSystemGlobalOffset setZ(float z) {
		this.z = z;
		return this;
	}

	public final float getZ() {
		return z;
	}

	public final LocalPositionNedSystemGlobalOffset setRoll(float roll) {
		this.roll = roll;
		return this;
	}

	public final float getRoll() {
		return roll;
	}

	public final LocalPositionNedSystemGlobalOffset setPitch(float pitch) {
		this.pitch = pitch;
		return this;
	}

	public final float getPitch() {
		return pitch;
	}

	public final LocalPositionNedSystemGlobalOffset setYaw(float yaw) {
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
			LocalPositionNedSystemGlobalOffset other = (LocalPositionNedSystemGlobalOffset)o;
			if (!Objects.deepEquals(this.timeBootMs, other.timeBootMs)) {
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
		result = 31 * result + Objects.hashCode(this.timeBootMs);
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
		return "LocalPositionNedSystemGlobalOffset{" +
				"timeBootMs=" + timeBootMs +
				", x=" + x +
				", y=" + y +
				", z=" + z +
				", roll=" + roll +
				", pitch=" + pitch +
				", yaw=" + yaw +
				'}';
	}
}
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
		id = 32,
		messagePayloadLength = 28,
		description = "The filtered local position (e.g. fused computer vision and accelerometers). Coordinate frame is right-handed, Z-axis down (aeronautical frame, NED / north-east-down convention)"
)
public class LocalPositionNed implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4)
	private long timeBootMs;

	@MavlinkMessageParam(mavlinkType = "float", position = 2, typeSize = 4, streamLength = 4)
	private float x;

	@MavlinkMessageParam(mavlinkType = "float", position = 3, typeSize = 4, streamLength = 4)
	private float y;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4)
	private float z;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4)
	private float vx;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4)
	private float vy;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4)
	private float vz;

	private final int messagePayloadLength = 28;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public LocalPositionNed(long timeBootMs, float x, float y, float z, float vx, float vy, float vz) {
		this.timeBootMs = timeBootMs;
		this.x = x;
		this.y = y;
		this.z = z;
		this.vx = vx;
		this.vy = vy;
		this.vz = vz;
	}

	public LocalPositionNed(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 28！");
		}
		messagePayload(messagePayload);
	}

	public LocalPositionNed(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.timeBootMs = byteArray.getUnsignedInt32(0);
		this.x = byteArray.getFloat(4);
		this.y = byteArray.getFloat(8);
		this.z = byteArray.getFloat(12);
		this.vx = byteArray.getFloat(16);
		this.vy = byteArray.getFloat(20);
		this.vz = byteArray.getFloat(24);
	}

	@Override
	public byte[] messagePayload() {
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final LocalPositionNed setTimeBootMs(long timeBootMs) {
		this.timeBootMs = timeBootMs;
		return this;
	}

	public final long getTimeBootMs() {
		return timeBootMs;
	}

	public final LocalPositionNed setX(float x) {
		this.x = x;
		return this;
	}

	public final float getX() {
		return x;
	}

	public final LocalPositionNed setY(float y) {
		this.y = y;
		return this;
	}

	public final float getY() {
		return y;
	}

	public final LocalPositionNed setZ(float z) {
		this.z = z;
		return this;
	}

	public final float getZ() {
		return z;
	}

	public final LocalPositionNed setVx(float vx) {
		this.vx = vx;
		return this;
	}

	public final float getVx() {
		return vx;
	}

	public final LocalPositionNed setVy(float vy) {
		this.vy = vy;
		return this;
	}

	public final float getVy() {
		return vy;
	}

	public final LocalPositionNed setVz(float vz) {
		this.vz = vz;
		return this;
	}

	public final float getVz() {
		return vz;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			LocalPositionNed other = (LocalPositionNed)o;
			if (!Objects.deepEquals(this.timeBootMs, other.timeBootMs)) {
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
			} else {
				return Objects.deepEquals(this.vz, other.vz);
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
		result = 31 * result + Objects.hashCode(this.vx);
		result = 31 * result + Objects.hashCode(this.vy);
		result = 31 * result + Objects.hashCode(this.vz);
		return result;
	}

	@Override
	public String toString() {
		return "LocalPositionNed{" +
				"timeBootMs=" + timeBootMs +
				", x=" + x +
				", y=" + y +
				", z=" + z +
				", vx=" + vx +
				", vy=" + vy +
				", vz=" + vz +
				'}';
	}
}
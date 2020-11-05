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
		id = 250,
		messagePayloadLength = 30,
		description = "Send raw controller memory. The use of this message is discouraged for normal packets, but a quite efficient way for testing new messages and getting experimental debug output."
)
public class DebugVect implements Message {
	@MavlinkMessageParam(mavlinkType = "char", position = 1, typeSize = 1, streamLength = 10)
	private String name;

	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 2, typeSize = 8, streamLength = 8)
	private BigInteger timeUsec;

	@MavlinkMessageParam(mavlinkType = "float", position = 3, typeSize = 4, streamLength = 4)
	private float x;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4)
	private float y;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4)
	private float z;

	private final int messagePayloadLength = 30;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public DebugVect(String name, BigInteger timeUsec, float x, float y, float z) {
		this.name = name;
		this.timeUsec = timeUsec;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public DebugVect(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 30！");
		}
		messagePayload(messagePayload);
	}

	public DebugVect(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.name = byteArray.getChars(0,10);
		this.timeUsec = byteArray.getUnsignedInt64(1);
		this.x = byteArray.getFloat(9);
		this.y = byteArray.getFloat(13);
		this.z = byteArray.getFloat(17);
	}

	@Override
	public byte[] messagePayload() {
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final DebugVect setName(String name) {
		this.name = name;
		return this;
	}

	public final String getName() {
		return name;
	}

	public final DebugVect setTimeUsec(BigInteger timeUsec) {
		this.timeUsec = timeUsec;
		return this;
	}

	public final BigInteger getTimeUsec() {
		return timeUsec;
	}

	public final DebugVect setX(float x) {
		this.x = x;
		return this;
	}

	public final float getX() {
		return x;
	}

	public final DebugVect setY(float y) {
		this.y = y;
		return this;
	}

	public final float getY() {
		return y;
	}

	public final DebugVect setZ(float z) {
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
			DebugVect other = (DebugVect)o;
			if (!Objects.deepEquals(this.name, other.name)) {
				return false;
			} else if (!Objects.deepEquals(this.timeUsec, other.timeUsec)) {
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
		result = 31 * result + Objects.hashCode(this.name);
		result = 31 * result + Objects.hashCode(this.timeUsec);
		result = 31 * result + Objects.hashCode(this.x);
		result = 31 * result + Objects.hashCode(this.y);
		result = 31 * result + Objects.hashCode(this.z);
		return result;
	}

	@Override
	public String toString() {
		return "DebugVect{" +
				"name=" + name +
				", timeUsec=" + timeUsec +
				", x=" + x +
				", y=" + y +
				", z=" + z +
				'}';
	}
}
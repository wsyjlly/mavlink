package cn.wsyjlly.mavlink.common.v1.messages;

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
 * Date 2020.11.26 - 02:45
 **********************************/

@MavlinkMessage(
		id = 250,
		messagePayloadLength = 30,
		description = "Send raw controller memory. The use of this message is discouraged for normal packets, but a quite efficient way for testing new messages and getting experimental debug output."
)
public class DebugVect implements Message {
	@MavlinkMessageParam(mavlinkType = "char", position = 1, typeSize = 1, streamLength = 10, description = "Name")
	private String name;

	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 2, typeSize = 8, streamLength = 8, description = "Timestamp")
	private BigInteger timeUsec;

	@MavlinkMessageParam(mavlinkType = "float", position = 3, typeSize = 4, streamLength = 4, description = "x")
	private float x;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4, description = "y")
	private float y;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4, description = "z")
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
		name = byteArray.getChars(0,10);
		timeUsec = byteArray.getUnsignedInt64(10);
		x = byteArray.getFloat(18);
		y = byteArray.getFloat(22);
		z = byteArray.getFloat(26);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putChars(name,0);
		byteArray.putUnsignedInt64(timeUsec,10);
		byteArray.putFloat(x,18);
		byteArray.putFloat(y,22);
		byteArray.putFloat(z,26);
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
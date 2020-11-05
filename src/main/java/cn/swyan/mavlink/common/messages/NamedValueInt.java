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
		id = 252,
		messagePayloadLength = 18,
		description = "Send a key-value pair as integer. The use of this message is discouraged for normal packets, but a quite efficient way for testing new messages and getting experimental debug output."
)
public class NamedValueInt implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4)
	private long timeBootMs;

	@MavlinkMessageParam(mavlinkType = "char", position = 2, typeSize = 1, streamLength = 10)
	private String name;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 3, typeSize = 4, streamLength = 4)
	private int value;

	private final int messagePayloadLength = 18;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public NamedValueInt(long timeBootMs, String name, int value) {
		this.timeBootMs = timeBootMs;
		this.name = name;
		this.value = value;
	}

	public NamedValueInt(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 18！");
		}
		messagePayload(messagePayload);
	}

	public NamedValueInt(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.timeBootMs = byteArray.getUnsignedInt32(0);
		this.name = byteArray.getChars(4,10);
		this.value = byteArray.getInt32(5);
	}

	@Override
	public byte[] messagePayload() {
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final NamedValueInt setTimeBootMs(long timeBootMs) {
		this.timeBootMs = timeBootMs;
		return this;
	}

	public final long getTimeBootMs() {
		return timeBootMs;
	}

	public final NamedValueInt setName(String name) {
		this.name = name;
		return this;
	}

	public final String getName() {
		return name;
	}

	public final NamedValueInt setValue(int value) {
		this.value = value;
		return this;
	}

	public final int getValue() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			NamedValueInt other = (NamedValueInt)o;
			if (!Objects.deepEquals(this.timeBootMs, other.timeBootMs)) {
				return false;
			} else if (!Objects.deepEquals(this.name, other.name)) {
				return false;
			} else {
				return Objects.deepEquals(this.value, other.value);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeBootMs);
		result = 31 * result + Objects.hashCode(this.name);
		result = 31 * result + Objects.hashCode(this.value);
		return result;
	}

	@Override
	public String toString() {
		return "NamedValueInt{" +
				"timeBootMs=" + timeBootMs +
				", name=" + name +
				", value=" + value +
				'}';
	}
}
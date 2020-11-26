package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
import java.util.Arrays;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 251,
		messagePayloadLength = 18,
		description = "Send a key-value pair as float. The use of this message is discouraged for normal packets, but a quite efficient way for testing new messages and getting experimental debug output."
)
public class NamedValueFloat implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4, description = "Timestamp (time since system boot).", units = "ms")
	private long timeBootMs;

	@MavlinkMessageParam(mavlinkType = "char", position = 2, typeSize = 1, streamLength = 10, description = "Name of the debug variable")
	private String name;

	@MavlinkMessageParam(mavlinkType = "float", position = 3, typeSize = 4, streamLength = 4, description = "Floating point value")
	private float value;

	private final int messagePayloadLength = 18;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public NamedValueFloat(long timeBootMs, String name, float value) {
		this.timeBootMs = timeBootMs;
		this.name = name;
		this.value = value;
	}

	public NamedValueFloat(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 18！");
		}
		messagePayload(messagePayload);
	}

	public NamedValueFloat(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeBootMs = byteArray.getUnsignedInt32(0);
		name = byteArray.getChars(4,10);
		value = byteArray.getFloat(14);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt32(timeBootMs,0);
		byteArray.putChars(name,4);
		byteArray.putFloat(value,14);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final NamedValueFloat setTimeBootMs(long timeBootMs) {
		this.timeBootMs = timeBootMs;
		return this;
	}

	public final long getTimeBootMs() {
		return timeBootMs;
	}

	public final NamedValueFloat setName(String name) {
		this.name = name;
		return this;
	}

	public final String getName() {
		return name;
	}

	public final NamedValueFloat setValue(float value) {
		this.value = value;
		return this;
	}

	public final float getValue() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			NamedValueFloat other = (NamedValueFloat)o;
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
		return "NamedValueFloat{" +
				"timeBootMs=" + timeBootMs +
				", name=" + name +
				", value=" + value +
				'}';
	}
}
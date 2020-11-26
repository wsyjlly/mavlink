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
		id = 350,
		messagePayloadLength = 252,
		description = "Large debug/prototyping array. The message uses the maximum available payload for data. The array_id and name fields are used to discriminate between messages in code and in user interfaces (respectively). Do not use in production code."
)
public class DebugFloatArray implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8, description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.", units = "us")
	private BigInteger timeUsec;

	@MavlinkMessageParam(mavlinkType = "char", position = 2, typeSize = 1, streamLength = 10, description = "Name, for human-friendly display in a Ground Control Station")
	private String name;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 3, typeSize = 2, streamLength = 2, description = "Unique ID used to discriminate between arrays")
	private int arrayId;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 232, description = "data")
	private float[] data = new float[58];

	private final int messagePayloadLength = 252;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public DebugFloatArray(BigInteger timeUsec, String name, int arrayId, float[] data) {
		this.timeUsec = timeUsec;
		this.name = name;
		this.arrayId = arrayId;
		this.data = data;
	}

	public DebugFloatArray(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 252！");
		}
		messagePayload(messagePayload);
	}

	public DebugFloatArray(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeUsec = byteArray.getUnsignedInt64(0);
		name = byteArray.getChars(8,10);
		arrayId = byteArray.getUnsignedInt16(18);
		data = byteArray.getFloatArray(20,58);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt64(timeUsec,0);
		byteArray.putChars(name,8);
		byteArray.putUnsignedInt16(arrayId,18);
		byteArray.putFloatArray(data,20);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final DebugFloatArray setTimeUsec(BigInteger timeUsec) {
		this.timeUsec = timeUsec;
		return this;
	}

	public final BigInteger getTimeUsec() {
		return timeUsec;
	}

	public final DebugFloatArray setName(String name) {
		this.name = name;
		return this;
	}

	public final String getName() {
		return name;
	}

	public final DebugFloatArray setArrayId(int arrayId) {
		this.arrayId = arrayId;
		return this;
	}

	public final int getArrayId() {
		return arrayId;
	}

	public final DebugFloatArray setData(float[] data) {
		this.data = data;
		return this;
	}

	public final float[] getData() {
		return data;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			DebugFloatArray other = (DebugFloatArray)o;
			if (!Objects.deepEquals(this.timeUsec, other.timeUsec)) {
				return false;
			} else if (!Objects.deepEquals(this.name, other.name)) {
				return false;
			} else if (!Objects.deepEquals(this.arrayId, other.arrayId)) {
				return false;
			} else {
				return Objects.deepEquals(this.data, other.data);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeUsec);
		result = 31 * result + Objects.hashCode(this.name);
		result = 31 * result + Objects.hashCode(this.arrayId);
		result = 31 * result + Objects.hashCode(this.data);
		return result;
	}

	@Override
	public String toString() {
		return "DebugFloatArray{" +
				"timeUsec=" + timeUsec +
				", name=" + name +
				", arrayId=" + arrayId +
				", data=" + Arrays.toString(data) +
				'}';
	}
}
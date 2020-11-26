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
		id = 267,
		messagePayloadLength = 255,
		description = "A message containing logged data which requires a LOGGING_ACK to be sent back"
)
public class LoggingDataAcked implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "system ID of the target")
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "component ID of the target")
	private short targetComponent;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 3, typeSize = 2, streamLength = 2, description = "sequence number (can wrap)")
	private int sequence;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 1, description = "data length", units = "bytes")
	private short length;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 5, typeSize = 1, streamLength = 1, description = "offset into data where first message starts. This can be used for recovery, when a previous message got lost (set to 255 if no start exists).", units = "bytes")
	private short firstMessageOffset;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 6, typeSize = 1, streamLength = 249, description = "logged data")
	private short[] data = new short[249];

	private final int messagePayloadLength = 255;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public LoggingDataAcked(short targetSystem, short targetComponent, int sequence, short length, short firstMessageOffset, short[] data) {
		this.targetSystem = targetSystem;
		this.targetComponent = targetComponent;
		this.sequence = sequence;
		this.length = length;
		this.firstMessageOffset = firstMessageOffset;
		this.data = data;
	}

	public LoggingDataAcked(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 255！");
		}
		messagePayload(messagePayload);
	}

	public LoggingDataAcked(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		targetSystem = byteArray.getUnsignedInt8(0);
		targetComponent = byteArray.getUnsignedInt8(1);
		sequence = byteArray.getUnsignedInt16(2);
		length = byteArray.getUnsignedInt8(4);
		firstMessageOffset = byteArray.getUnsignedInt8(5);
		data = byteArray.getUnsignedInt8Array(6,249);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(targetSystem,0);
		byteArray.putUnsignedInt8(targetComponent,1);
		byteArray.putUnsignedInt16(sequence,2);
		byteArray.putUnsignedInt8(length,4);
		byteArray.putUnsignedInt8(firstMessageOffset,5);
		byteArray.putUnsignedInt8Array(data,6);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final LoggingDataAcked setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final LoggingDataAcked setTargetComponent(short targetComponent) {
		this.targetComponent = targetComponent;
		return this;
	}

	public final short getTargetComponent() {
		return targetComponent;
	}

	public final LoggingDataAcked setSequence(int sequence) {
		this.sequence = sequence;
		return this;
	}

	public final int getSequence() {
		return sequence;
	}

	public final LoggingDataAcked setLength(short length) {
		this.length = length;
		return this;
	}

	public final short getLength() {
		return length;
	}

	public final LoggingDataAcked setFirstMessageOffset(short firstMessageOffset) {
		this.firstMessageOffset = firstMessageOffset;
		return this;
	}

	public final short getFirstMessageOffset() {
		return firstMessageOffset;
	}

	public final LoggingDataAcked setData(short[] data) {
		this.data = data;
		return this;
	}

	public final short[] getData() {
		return data;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			LoggingDataAcked other = (LoggingDataAcked)o;
			if (!Objects.deepEquals(this.targetSystem, other.targetSystem)) {
				return false;
			} else if (!Objects.deepEquals(this.targetComponent, other.targetComponent)) {
				return false;
			} else if (!Objects.deepEquals(this.sequence, other.sequence)) {
				return false;
			} else if (!Objects.deepEquals(this.length, other.length)) {
				return false;
			} else if (!Objects.deepEquals(this.firstMessageOffset, other.firstMessageOffset)) {
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
		result = 31 * result + Objects.hashCode(this.targetSystem);
		result = 31 * result + Objects.hashCode(this.targetComponent);
		result = 31 * result + Objects.hashCode(this.sequence);
		result = 31 * result + Objects.hashCode(this.length);
		result = 31 * result + Objects.hashCode(this.firstMessageOffset);
		result = 31 * result + Objects.hashCode(this.data);
		return result;
	}

	@Override
	public String toString() {
		return "LoggingDataAcked{" +
				"targetSystem=" + targetSystem +
				", targetComponent=" + targetComponent +
				", sequence=" + sequence +
				", length=" + length +
				", firstMessageOffset=" + firstMessageOffset +
				", data=" + Arrays.toString(data) +
				'}';
	}
}
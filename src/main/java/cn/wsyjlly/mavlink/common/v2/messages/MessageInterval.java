package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 244,
		messagePayloadLength = 6,
		description = "The interval between messages for a particular MAVLink message ID. This message is the response to the MAV_CMD_GET_MESSAGE_INTERVAL command. This interface replaces DATA_STREAM."
)
public class MessageInterval implements Message {
	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 1, typeSize = 2, streamLength = 2, description = "The ID of the requested MAVLink message. v1.0 is limited to 254 messages.")
	private int messageId;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 2, typeSize = 4, streamLength = 4, description = "The interval between two messages. A value of -1 indicates this stream is disabled, 0 indicates it is not available, > 0 indicates the interval at which it is sent.", units = "us")
	private int intervalUs;

	private final int messagePayloadLength = 6;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public MessageInterval(int messageId, int intervalUs) {
		this.messageId = messageId;
		this.intervalUs = intervalUs;
	}

	public MessageInterval(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 6！");
		}
		messagePayload(messagePayload);
	}

	public MessageInterval(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		messageId = byteArray.getUnsignedInt16(0);
		intervalUs = byteArray.getInt32(2);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt16(messageId,0);
		byteArray.putInt32(intervalUs,2);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final MessageInterval setMessageId(int messageId) {
		this.messageId = messageId;
		return this;
	}

	public final int getMessageId() {
		return messageId;
	}

	public final MessageInterval setIntervalUs(int intervalUs) {
		this.intervalUs = intervalUs;
		return this;
	}

	public final int getIntervalUs() {
		return intervalUs;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			MessageInterval other = (MessageInterval)o;
			if (!Objects.deepEquals(this.messageId, other.messageId)) {
				return false;
			} else {
				return Objects.deepEquals(this.intervalUs, other.intervalUs);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.messageId);
		result = 31 * result + Objects.hashCode(this.intervalUs);
		return result;
	}

	@Override
	public String toString() {
		return "MessageInterval{" +
				"messageId=" + messageId +
				", intervalUs=" + intervalUs +
				'}';
	}
}
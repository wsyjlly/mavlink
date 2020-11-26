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
		id = 67,
		messagePayloadLength = 4,
		description = "Data stream status information."
)
public class DataStream implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "The ID of the requested data stream")
	private short streamId;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 2, typeSize = 2, streamLength = 2, description = "The message rate", units = "Hz")
	private int messageRate;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, description = "1 stream is enabled, 0 stream is stopped.")
	private short onOff;

	private final int messagePayloadLength = 4;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public DataStream(short streamId, int messageRate, short onOff) {
		this.streamId = streamId;
		this.messageRate = messageRate;
		this.onOff = onOff;
	}

	public DataStream(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 4！");
		}
		messagePayload(messagePayload);
	}

	public DataStream(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		streamId = byteArray.getUnsignedInt8(0);
		messageRate = byteArray.getUnsignedInt16(1);
		onOff = byteArray.getUnsignedInt8(3);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(streamId,0);
		byteArray.putUnsignedInt16(messageRate,1);
		byteArray.putUnsignedInt8(onOff,3);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final DataStream setStreamId(short streamId) {
		this.streamId = streamId;
		return this;
	}

	public final short getStreamId() {
		return streamId;
	}

	public final DataStream setMessageRate(int messageRate) {
		this.messageRate = messageRate;
		return this;
	}

	public final int getMessageRate() {
		return messageRate;
	}

	public final DataStream setOnOff(short onOff) {
		this.onOff = onOff;
		return this;
	}

	public final short getOnOff() {
		return onOff;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			DataStream other = (DataStream)o;
			if (!Objects.deepEquals(this.streamId, other.streamId)) {
				return false;
			} else if (!Objects.deepEquals(this.messageRate, other.messageRate)) {
				return false;
			} else {
				return Objects.deepEquals(this.onOff, other.onOff);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.streamId);
		result = 31 * result + Objects.hashCode(this.messageRate);
		result = 31 * result + Objects.hashCode(this.onOff);
		return result;
	}

	@Override
	public String toString() {
		return "DataStream{" +
				"streamId=" + streamId +
				", messageRate=" + messageRate +
				", onOff=" + onOff +
				'}';
	}
}
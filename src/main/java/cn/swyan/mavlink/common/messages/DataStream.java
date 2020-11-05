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
		id = 67,
		messagePayloadLength = 4,
		description = "The PPM values of the RC channels received. The standard PPM modulation is as follows: 1000 microseconds: 0%, 2000 microseconds: 100%. Individual receivers/transmitters might violate this specification."
)
public class DataStream implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1)
	private short streamId;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 2, typeSize = 2, streamLength = 2)
	private int messageRate;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1)
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
		this.streamId = byteArray.getUnsignedInt8(0);
		this.messageRate = byteArray.getUnsignedInt16(1);
		this.onOff = byteArray.getUnsignedInt8(3);
	}

	@Override
	public byte[] messagePayload() {
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
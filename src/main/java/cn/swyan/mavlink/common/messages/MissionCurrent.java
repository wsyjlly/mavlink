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
		id = 42,
		messagePayloadLength = 2,
		description = "Message that announces the sequence number of the current active mission item. The MAV will fly towards this mission item."
)
public class MissionCurrent implements Message {
	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 1, typeSize = 2, streamLength = 2)
	private int seq;

	private final int messagePayloadLength = 2;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public MissionCurrent(int seq) {
		this.seq = seq;
	}

	public MissionCurrent(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 2！");
		}
		messagePayload(messagePayload);
	}

	public MissionCurrent(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.seq = byteArray.getUnsignedInt16(0);
	}

	@Override
	public byte[] messagePayload() {
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final MissionCurrent setSeq(int seq) {
		this.seq = seq;
		return this;
	}

	public final int getSeq() {
		return seq;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			MissionCurrent other = (MissionCurrent)o;
			return Objects.deepEquals(this.seq, other.seq);		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.seq);
		return result;
	}

	@Override
	public String toString() {
		return "MissionCurrent{" +
				"seq=" + seq +
				'}';
	}
}
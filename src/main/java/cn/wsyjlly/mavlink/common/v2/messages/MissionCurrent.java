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
		id = 42,
		messagePayloadLength = 2,
		description = "Message that announces the sequence number of the current active mission item. The MAV will fly towards this mission item."
)
public class MissionCurrent implements Message {
	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 1, typeSize = 2, streamLength = 2, description = "Sequence")
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
		seq = byteArray.getUnsignedInt16(0);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt16(seq,0);
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
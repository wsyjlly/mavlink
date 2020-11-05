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
		id = 6,
		messagePayloadLength = 3,
		description = "Accept / deny control of this MAV"
)
public class ChangeOperatorControlAck implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1)
	private short gcsSystemId;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1)
	private short controlRequest;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1)
	private short ack;

	private final int messagePayloadLength = 3;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public ChangeOperatorControlAck(short gcsSystemId, short controlRequest, short ack) {
		this.gcsSystemId = gcsSystemId;
		this.controlRequest = controlRequest;
		this.ack = ack;
	}

	public ChangeOperatorControlAck(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 3！");
		}
		messagePayload(messagePayload);
	}

	public ChangeOperatorControlAck(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.gcsSystemId = byteArray.getUnsignedInt8(0);
		this.controlRequest = byteArray.getUnsignedInt8(1);
		this.ack = byteArray.getUnsignedInt8(2);
	}

	@Override
	public byte[] messagePayload() {
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final ChangeOperatorControlAck setGcsSystemId(short gcsSystemId) {
		this.gcsSystemId = gcsSystemId;
		return this;
	}

	public final short getGcsSystemId() {
		return gcsSystemId;
	}

	public final ChangeOperatorControlAck setControlRequest(short controlRequest) {
		this.controlRequest = controlRequest;
		return this;
	}

	public final short getControlRequest() {
		return controlRequest;
	}

	public final ChangeOperatorControlAck setAck(short ack) {
		this.ack = ack;
		return this;
	}

	public final short getAck() {
		return ack;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			ChangeOperatorControlAck other = (ChangeOperatorControlAck)o;
			if (!Objects.deepEquals(this.gcsSystemId, other.gcsSystemId)) {
				return false;
			} else if (!Objects.deepEquals(this.controlRequest, other.controlRequest)) {
				return false;
			} else {
				return Objects.deepEquals(this.ack, other.ack);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.gcsSystemId);
		result = 31 * result + Objects.hashCode(this.controlRequest);
		result = 31 * result + Objects.hashCode(this.ack);
		return result;
	}

	@Override
	public String toString() {
		return "ChangeOperatorControlAck{" +
				"gcsSystemId=" + gcsSystemId +
				", controlRequest=" + controlRequest +
				", ack=" + ack +
				'}';
	}
}
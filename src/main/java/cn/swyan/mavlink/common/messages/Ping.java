package cn.swyan.mavlink.common.messages;

import cn.swyan.mavlink.annotation.MavlinkMessage;
import cn.swyan.mavlink.annotation.MavlinkMessageParam;
import cn.swyan.mavlink.common.Message;
import cn.swyan.mavlink.protocol.ByteArray;
import cn.swyan.mavlink.protocol.util.ByteModel;

import java.util.Objects;
import java.math.BigInteger;
/**********************************
 * @Author YSW
 * @Description
 * @Date 2020.11.04 - 03:56
 **********************************/

@MavlinkMessage(
		id = 4,
		messagePayloadLength = 14,
		description = "A ping message either requesting or responding to a ping. This allows to measure the system latencies, including serial port, radio modem and UDP connections."
)
public class Ping implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8)
	private BigInteger timeUsec;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 2, typeSize = 4, streamLength = 4)
	private long seq;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1)
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 1)
	private short targetComponent;

	private final int messagePayloadLength = 14;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public Ping(BigInteger timeUsec, long seq, short targetSystem, short targetComponent) {
		this.timeUsec = timeUsec;
		this.seq = seq;
		this.targetSystem = targetSystem;
		this.targetComponent = targetComponent;
	}

	public Ping(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 14！");
		}
		messagePayload(messagePayload);
	}

	public Ping(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.timeUsec = byteArray.getUnsignedInt64(0);
		this.seq = byteArray.getUnsignedInt32(8);
		this.targetSystem = byteArray.getUnsignedInt8(12);
		this.targetComponent = byteArray.getUnsignedInt8(13);
	}

	@Override
	public byte[] messagePayload() {
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final Ping setTimeUsec(BigInteger timeUsec) {
		this.timeUsec = timeUsec;
		return this;
	}

	public final BigInteger getTimeUsec() {
		return timeUsec;
	}

	public final Ping setSeq(long seq) {
		this.seq = seq;
		return this;
	}

	public final long getSeq() {
		return seq;
	}

	public final Ping setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final Ping setTargetComponent(short targetComponent) {
		this.targetComponent = targetComponent;
		return this;
	}

	public final short getTargetComponent() {
		return targetComponent;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			Ping other = (Ping)o;
			if (!Objects.deepEquals(this.timeUsec, other.timeUsec)) {
				return false;
			} else if (!Objects.deepEquals(this.seq, other.seq)) {
				return false;
			} else if (!Objects.deepEquals(this.targetSystem, other.targetSystem)) {
				return false;
			} else {
				return Objects.deepEquals(this.targetComponent, other.targetComponent);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeUsec);
		result = 31 * result + Objects.hashCode(this.seq);
		result = 31 * result + Objects.hashCode(this.targetSystem);
		result = 31 * result + Objects.hashCode(this.targetComponent);
		return result;
	}

	@Override
	public String toString() {
		return "Ping{" +
				"timeUsec=" + timeUsec +
				", seq=" + seq +
				", targetSystem=" + targetSystem +
				", targetComponent=" + targetComponent +
				'}';
	}
}
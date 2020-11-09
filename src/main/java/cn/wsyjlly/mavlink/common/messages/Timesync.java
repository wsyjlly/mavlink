package cn.wsyjlly.mavlink.common.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.09 - 03:37
 **********************************/

@MavlinkMessage(
		id = 111,
		messagePayloadLength = 16,
		description = "Time synchronization message."
)
public class Timesync implements Message {
	@MavlinkMessageParam(mavlinkType = "int64_t", position = 1, typeSize = 8, streamLength = 8)
	private long tc1;

	@MavlinkMessageParam(mavlinkType = "int64_t", position = 2, typeSize = 8, streamLength = 8)
	private long ts1;

	private final int messagePayloadLength = 16;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public Timesync(long tc1, long ts1) {
		this.tc1 = tc1;
		this.ts1 = ts1;
	}

	public Timesync(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 16！");
		}
		messagePayload(messagePayload);
	}

	public Timesync(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.tc1 = byteArray.getInt64(0);
		this.ts1 = byteArray.getInt64(8);
	}

	@Override
	public byte[] messagePayload() {
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final Timesync setTc1(long tc1) {
		this.tc1 = tc1;
		return this;
	}

	public final long getTc1() {
		return tc1;
	}

	public final Timesync setTs1(long ts1) {
		this.ts1 = ts1;
		return this;
	}

	public final long getTs1() {
		return ts1;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			Timesync other = (Timesync)o;
			if (!Objects.deepEquals(this.tc1, other.tc1)) {
				return false;
			} else {
				return Objects.deepEquals(this.ts1, other.ts1);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.tc1);
		result = 31 * result + Objects.hashCode(this.ts1);
		return result;
	}

	@Override
	public String toString() {
		return "Timesync{" +
				"tc1=" + tc1 +
				", ts1=" + ts1 +
				'}';
	}
}
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
		id = 2,
		messagePayloadLength = 12,
		description = "The system time is the time of the master clock, typically the computer clock of the main onboard computer."
)
public class SystemTime implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8)
	private BigInteger timeUnixUsec;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 2, typeSize = 4, streamLength = 4)
	private long timeBootMs;

	private final int messagePayloadLength = 12;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public SystemTime(BigInteger timeUnixUsec, long timeBootMs) {
		this.timeUnixUsec = timeUnixUsec;
		this.timeBootMs = timeBootMs;
	}

	public SystemTime(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 12！");
		}
		messagePayload(messagePayload);
	}

	public SystemTime(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.timeUnixUsec = byteArray.getUnsignedInt64(0);
		this.timeBootMs = byteArray.getUnsignedInt32(8);
	}

	@Override
	public byte[] messagePayload() {
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final SystemTime setTimeUnixUsec(BigInteger timeUnixUsec) {
		this.timeUnixUsec = timeUnixUsec;
		return this;
	}

	public final BigInteger getTimeUnixUsec() {
		return timeUnixUsec;
	}

	public final SystemTime setTimeBootMs(long timeBootMs) {
		this.timeBootMs = timeBootMs;
		return this;
	}

	public final long getTimeBootMs() {
		return timeBootMs;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			SystemTime other = (SystemTime)o;
			if (!Objects.deepEquals(this.timeUnixUsec, other.timeUnixUsec)) {
				return false;
			} else {
				return Objects.deepEquals(this.timeBootMs, other.timeBootMs);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeUnixUsec);
		result = 31 * result + Objects.hashCode(this.timeBootMs);
		return result;
	}

	@Override
	public String toString() {
		return "SystemTime{" +
				"timeUnixUsec=" + timeUnixUsec +
				", timeBootMs=" + timeBootMs +
				'}';
	}
}
package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
import java.math.BigInteger;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 2,
		messagePayloadLength = 12,
		description = "The system time is the time of the master clock, typically the computer clock of the main onboard computer."
)
public class SystemTime implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8, description = "Timestamp (UNIX epoch time).", units = "us")
	private BigInteger timeUnixUsec;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 2, typeSize = 4, streamLength = 4, description = "Timestamp (time since system boot).", units = "ms")
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
		timeUnixUsec = byteArray.getUnsignedInt64(0);
		timeBootMs = byteArray.getUnsignedInt32(8);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt64(timeUnixUsec,0);
		byteArray.putUnsignedInt32(timeBootMs,8);
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
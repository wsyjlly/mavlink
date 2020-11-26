package cn.wsyjlly.mavlink.common.v1.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:45
 **********************************/

@MavlinkMessage(
		id = 118,
		messagePayloadLength = 14,
		description = "Reply to LOG_REQUEST_LIST"
)
public class LogEntry implements Message {
	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 1, typeSize = 2, streamLength = 2, description = "Log id")
	private int id;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 2, typeSize = 2, streamLength = 2, description = "Total number of logs")
	private int numLogs;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 3, typeSize = 2, streamLength = 2, description = "High log number")
	private int lastLogNum;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 4, typeSize = 4, streamLength = 4, description = "UTC timestamp of log in seconds since 1970, or 0 if not available")
	private long timeUtc;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 5, typeSize = 4, streamLength = 4, description = "Size of the log (may be approximate) in bytes")
	private long size;

	private final int messagePayloadLength = 14;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public LogEntry(int id, int numLogs, int lastLogNum, long timeUtc, long size) {
		this.id = id;
		this.numLogs = numLogs;
		this.lastLogNum = lastLogNum;
		this.timeUtc = timeUtc;
		this.size = size;
	}

	public LogEntry(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 14！");
		}
		messagePayload(messagePayload);
	}

	public LogEntry(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		id = byteArray.getUnsignedInt16(0);
		numLogs = byteArray.getUnsignedInt16(2);
		lastLogNum = byteArray.getUnsignedInt16(4);
		timeUtc = byteArray.getUnsignedInt32(6);
		size = byteArray.getUnsignedInt32(10);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt16(id,0);
		byteArray.putUnsignedInt16(numLogs,2);
		byteArray.putUnsignedInt16(lastLogNum,4);
		byteArray.putUnsignedInt32(timeUtc,6);
		byteArray.putUnsignedInt32(size,10);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final LogEntry setId(int id) {
		this.id = id;
		return this;
	}

	public final int getId() {
		return id;
	}

	public final LogEntry setNumLogs(int numLogs) {
		this.numLogs = numLogs;
		return this;
	}

	public final int getNumLogs() {
		return numLogs;
	}

	public final LogEntry setLastLogNum(int lastLogNum) {
		this.lastLogNum = lastLogNum;
		return this;
	}

	public final int getLastLogNum() {
		return lastLogNum;
	}

	public final LogEntry setTimeUtc(long timeUtc) {
		this.timeUtc = timeUtc;
		return this;
	}

	public final long getTimeUtc() {
		return timeUtc;
	}

	public final LogEntry setSize(long size) {
		this.size = size;
		return this;
	}

	public final long getSize() {
		return size;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			LogEntry other = (LogEntry)o;
			if (!Objects.deepEquals(this.id, other.id)) {
				return false;
			} else if (!Objects.deepEquals(this.numLogs, other.numLogs)) {
				return false;
			} else if (!Objects.deepEquals(this.lastLogNum, other.lastLogNum)) {
				return false;
			} else if (!Objects.deepEquals(this.timeUtc, other.timeUtc)) {
				return false;
			} else {
				return Objects.deepEquals(this.size, other.size);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.id);
		result = 31 * result + Objects.hashCode(this.numLogs);
		result = 31 * result + Objects.hashCode(this.lastLogNum);
		result = 31 * result + Objects.hashCode(this.timeUtc);
		result = 31 * result + Objects.hashCode(this.size);
		return result;
	}

	@Override
	public String toString() {
		return "LogEntry{" +
				"id=" + id +
				", numLogs=" + numLogs +
				", lastLogNum=" + lastLogNum +
				", timeUtc=" + timeUtc +
				", size=" + size +
				'}';
	}
}
package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
import java.util.Arrays;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 120,
		messagePayloadLength = 97,
		description = "Reply to LOG_REQUEST_DATA"
)
public class LogData implements Message {
	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 1, typeSize = 2, streamLength = 2, description = "Log id (from LOG_ENTRY reply)")
	private int id;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 2, typeSize = 4, streamLength = 4, description = "Offset into the log")
	private long ofs;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, description = "Number of bytes (zero for end of log)", units = "bytes")
	private short count;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 90, description = "log data")
	private short[] data = new short[90];

	private final int messagePayloadLength = 97;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public LogData(int id, long ofs, short count, short[] data) {
		this.id = id;
		this.ofs = ofs;
		this.count = count;
		this.data = data;
	}

	public LogData(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 97！");
		}
		messagePayload(messagePayload);
	}

	public LogData(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		id = byteArray.getUnsignedInt16(0);
		ofs = byteArray.getUnsignedInt32(2);
		count = byteArray.getUnsignedInt8(6);
		data = byteArray.getUnsignedInt8Array(7,90);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt16(id,0);
		byteArray.putUnsignedInt32(ofs,2);
		byteArray.putUnsignedInt8(count,6);
		byteArray.putUnsignedInt8Array(data,7);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final LogData setId(int id) {
		this.id = id;
		return this;
	}

	public final int getId() {
		return id;
	}

	public final LogData setOfs(long ofs) {
		this.ofs = ofs;
		return this;
	}

	public final long getOfs() {
		return ofs;
	}

	public final LogData setCount(short count) {
		this.count = count;
		return this;
	}

	public final short getCount() {
		return count;
	}

	public final LogData setData(short[] data) {
		this.data = data;
		return this;
	}

	public final short[] getData() {
		return data;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			LogData other = (LogData)o;
			if (!Objects.deepEquals(this.id, other.id)) {
				return false;
			} else if (!Objects.deepEquals(this.ofs, other.ofs)) {
				return false;
			} else if (!Objects.deepEquals(this.count, other.count)) {
				return false;
			} else {
				return Objects.deepEquals(this.data, other.data);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.id);
		result = 31 * result + Objects.hashCode(this.ofs);
		result = 31 * result + Objects.hashCode(this.count);
		result = 31 * result + Objects.hashCode(this.data);
		return result;
	}

	@Override
	public String toString() {
		return "LogData{" +
				"id=" + id +
				", ofs=" + ofs +
				", count=" + count +
				", data=" + Arrays.toString(data) +
				'}';
	}
}
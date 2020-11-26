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
		id = 119,
		messagePayloadLength = 12,
		description = "Request a chunk of a log"
)
public class LogRequestData implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "System ID")
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Component ID")
	private short targetComponent;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 3, typeSize = 2, streamLength = 2, description = "Log id (from LOG_ENTRY reply)")
	private int id;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 4, typeSize = 4, streamLength = 4, description = "Offset into the log")
	private long ofs;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 5, typeSize = 4, streamLength = 4, description = "Number of bytes")
	private long count;

	private final int messagePayloadLength = 12;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public LogRequestData(short targetSystem, short targetComponent, int id, long ofs, long count) {
		this.targetSystem = targetSystem;
		this.targetComponent = targetComponent;
		this.id = id;
		this.ofs = ofs;
		this.count = count;
	}

	public LogRequestData(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 12！");
		}
		messagePayload(messagePayload);
	}

	public LogRequestData(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		targetSystem = byteArray.getUnsignedInt8(0);
		targetComponent = byteArray.getUnsignedInt8(1);
		id = byteArray.getUnsignedInt16(2);
		ofs = byteArray.getUnsignedInt32(4);
		count = byteArray.getUnsignedInt32(8);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(targetSystem,0);
		byteArray.putUnsignedInt8(targetComponent,1);
		byteArray.putUnsignedInt16(id,2);
		byteArray.putUnsignedInt32(ofs,4);
		byteArray.putUnsignedInt32(count,8);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final LogRequestData setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final LogRequestData setTargetComponent(short targetComponent) {
		this.targetComponent = targetComponent;
		return this;
	}

	public final short getTargetComponent() {
		return targetComponent;
	}

	public final LogRequestData setId(int id) {
		this.id = id;
		return this;
	}

	public final int getId() {
		return id;
	}

	public final LogRequestData setOfs(long ofs) {
		this.ofs = ofs;
		return this;
	}

	public final long getOfs() {
		return ofs;
	}

	public final LogRequestData setCount(long count) {
		this.count = count;
		return this;
	}

	public final long getCount() {
		return count;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			LogRequestData other = (LogRequestData)o;
			if (!Objects.deepEquals(this.targetSystem, other.targetSystem)) {
				return false;
			} else if (!Objects.deepEquals(this.targetComponent, other.targetComponent)) {
				return false;
			} else if (!Objects.deepEquals(this.id, other.id)) {
				return false;
			} else if (!Objects.deepEquals(this.ofs, other.ofs)) {
				return false;
			} else {
				return Objects.deepEquals(this.count, other.count);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.targetSystem);
		result = 31 * result + Objects.hashCode(this.targetComponent);
		result = 31 * result + Objects.hashCode(this.id);
		result = 31 * result + Objects.hashCode(this.ofs);
		result = 31 * result + Objects.hashCode(this.count);
		return result;
	}

	@Override
	public String toString() {
		return "LogRequestData{" +
				"targetSystem=" + targetSystem +
				", targetComponent=" + targetComponent +
				", id=" + id +
				", ofs=" + ofs +
				", count=" + count +
				'}';
	}
}
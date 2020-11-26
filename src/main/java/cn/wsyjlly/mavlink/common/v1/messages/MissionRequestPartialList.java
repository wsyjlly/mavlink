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
		id = 37,
		messagePayloadLength = 6,
		description = "Request a partial list of mission items from the system/component. http://qgroundcontrol.org/mavlink/waypoint_protocol. If start and end index are the same, just send one waypoint."
)
public class MissionRequestPartialList implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "System ID")
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Component ID")
	private short targetComponent;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 3, typeSize = 2, streamLength = 2, description = "Start index, 0 by default")
	private short startIndex;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 4, typeSize = 2, streamLength = 2, description = "End index, -1 by default (-1: send list to end). Else a valid index of the list")
	private short endIndex;

	private final int messagePayloadLength = 6;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public MissionRequestPartialList(short targetSystem, short targetComponent, short startIndex, short endIndex) {
		this.targetSystem = targetSystem;
		this.targetComponent = targetComponent;
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}

	public MissionRequestPartialList(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 6！");
		}
		messagePayload(messagePayload);
	}

	public MissionRequestPartialList(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		targetSystem = byteArray.getUnsignedInt8(0);
		targetComponent = byteArray.getUnsignedInt8(1);
		startIndex = byteArray.getInt16(2);
		endIndex = byteArray.getInt16(4);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(targetSystem,0);
		byteArray.putUnsignedInt8(targetComponent,1);
		byteArray.putInt16(startIndex,2);
		byteArray.putInt16(endIndex,4);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final MissionRequestPartialList setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final MissionRequestPartialList setTargetComponent(short targetComponent) {
		this.targetComponent = targetComponent;
		return this;
	}

	public final short getTargetComponent() {
		return targetComponent;
	}

	public final MissionRequestPartialList setStartIndex(short startIndex) {
		this.startIndex = startIndex;
		return this;
	}

	public final short getStartIndex() {
		return startIndex;
	}

	public final MissionRequestPartialList setEndIndex(short endIndex) {
		this.endIndex = endIndex;
		return this;
	}

	public final short getEndIndex() {
		return endIndex;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			MissionRequestPartialList other = (MissionRequestPartialList)o;
			if (!Objects.deepEquals(this.targetSystem, other.targetSystem)) {
				return false;
			} else if (!Objects.deepEquals(this.targetComponent, other.targetComponent)) {
				return false;
			} else if (!Objects.deepEquals(this.startIndex, other.startIndex)) {
				return false;
			} else {
				return Objects.deepEquals(this.endIndex, other.endIndex);
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
		result = 31 * result + Objects.hashCode(this.startIndex);
		result = 31 * result + Objects.hashCode(this.endIndex);
		return result;
	}

	@Override
	public String toString() {
		return "MissionRequestPartialList{" +
				"targetSystem=" + targetSystem +
				", targetComponent=" + targetComponent +
				", startIndex=" + startIndex +
				", endIndex=" + endIndex +
				'}';
	}
}
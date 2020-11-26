package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.MavMissionType;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 38,
		messagePayloadLength = 7,
		description = "This message is sent to the MAV to write a partial list. If start index == end index, only one item will be transmitted / updated. If the start index is NOT 0 and above the current list size, this request should be REJECTED!"
)
public class MissionWritePartialList implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "System ID")
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Component ID")
	private short targetComponent;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 3, typeSize = 2, streamLength = 2, description = "Start index. Must be smaller / equal to the largest index of the current onboard list.")
	private short startIndex;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 4, typeSize = 2, streamLength = 2, description = "End index, equal or greater than start index.")
	private short endIndex;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 5, typeSize = 1, streamLength = 1, description = "Mission type.", enum0 = MavMissionType.class)
	private short missionType;

	private final int messagePayloadLength = 7;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public MissionWritePartialList(short targetSystem, short targetComponent, short startIndex, short endIndex, short missionType) {
		this.targetSystem = targetSystem;
		this.targetComponent = targetComponent;
		this.startIndex = startIndex;
		this.endIndex = endIndex;
		this.missionType = missionType;
	}

	public MissionWritePartialList(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 7！");
		}
		messagePayload(messagePayload);
	}

	public MissionWritePartialList(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		targetSystem = byteArray.getUnsignedInt8(0);
		targetComponent = byteArray.getUnsignedInt8(1);
		startIndex = byteArray.getInt16(2);
		endIndex = byteArray.getInt16(4);
		missionType = byteArray.getUnsignedInt8(6);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(targetSystem,0);
		byteArray.putUnsignedInt8(targetComponent,1);
		byteArray.putInt16(startIndex,2);
		byteArray.putInt16(endIndex,4);
		byteArray.putUnsignedInt8(missionType,6);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final MissionWritePartialList setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final MissionWritePartialList setTargetComponent(short targetComponent) {
		this.targetComponent = targetComponent;
		return this;
	}

	public final short getTargetComponent() {
		return targetComponent;
	}

	public final MissionWritePartialList setStartIndex(short startIndex) {
		this.startIndex = startIndex;
		return this;
	}

	public final short getStartIndex() {
		return startIndex;
	}

	public final MissionWritePartialList setEndIndex(short endIndex) {
		this.endIndex = endIndex;
		return this;
	}

	public final short getEndIndex() {
		return endIndex;
	}

	public final MissionWritePartialList setMissionType(short missionType) {
		this.missionType = missionType;
		return this;
	}

	public final short getMissionType() {
		return missionType;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			MissionWritePartialList other = (MissionWritePartialList)o;
			if (!Objects.deepEquals(this.targetSystem, other.targetSystem)) {
				return false;
			} else if (!Objects.deepEquals(this.targetComponent, other.targetComponent)) {
				return false;
			} else if (!Objects.deepEquals(this.startIndex, other.startIndex)) {
				return false;
			} else if (!Objects.deepEquals(this.endIndex, other.endIndex)) {
				return false;
			} else {
				return Objects.deepEquals(this.missionType, other.missionType);
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
		result = 31 * result + Objects.hashCode(this.missionType);
		return result;
	}

	@Override
	public String toString() {
		return "MissionWritePartialList{" +
				"targetSystem=" + targetSystem +
				", targetComponent=" + targetComponent +
				", startIndex=" + startIndex +
				", endIndex=" + endIndex +
				", missionType=" + missionType +
				'}';
	}
}
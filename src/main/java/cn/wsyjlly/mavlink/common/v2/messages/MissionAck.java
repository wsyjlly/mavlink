package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.MavMissionResult;
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
		id = 47,
		messagePayloadLength = 4,
		description = "Acknowledgment message during waypoint handling. The type field states if this message is a positive ack (type=0) or if an error happened (type=non-zero)."
)
public class MissionAck implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "System ID")
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Component ID")
	private short targetComponent;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, description = "Mission result.", enum0 = MavMissionResult.class)
	private short type;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 1, description = "Mission type.", enum0 = MavMissionType.class)
	private short missionType;

	private final int messagePayloadLength = 4;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public MissionAck(short targetSystem, short targetComponent, short type, short missionType) {
		this.targetSystem = targetSystem;
		this.targetComponent = targetComponent;
		this.type = type;
		this.missionType = missionType;
	}

	public MissionAck(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 4！");
		}
		messagePayload(messagePayload);
	}

	public MissionAck(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		targetSystem = byteArray.getUnsignedInt8(0);
		targetComponent = byteArray.getUnsignedInt8(1);
		type = byteArray.getUnsignedInt8(2);
		missionType = byteArray.getUnsignedInt8(3);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(targetSystem,0);
		byteArray.putUnsignedInt8(targetComponent,1);
		byteArray.putUnsignedInt8(type,2);
		byteArray.putUnsignedInt8(missionType,3);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final MissionAck setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final MissionAck setTargetComponent(short targetComponent) {
		this.targetComponent = targetComponent;
		return this;
	}

	public final short getTargetComponent() {
		return targetComponent;
	}

	public final MissionAck setType(short type) {
		this.type = type;
		return this;
	}

	public final short getType() {
		return type;
	}

	public final MissionAck setMissionType(short missionType) {
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
			MissionAck other = (MissionAck)o;
			if (!Objects.deepEquals(this.targetSystem, other.targetSystem)) {
				return false;
			} else if (!Objects.deepEquals(this.targetComponent, other.targetComponent)) {
				return false;
			} else if (!Objects.deepEquals(this.type, other.type)) {
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
		result = 31 * result + Objects.hashCode(this.type);
		result = 31 * result + Objects.hashCode(this.missionType);
		return result;
	}

	@Override
	public String toString() {
		return "MissionAck{" +
				"targetSystem=" + targetSystem +
				", targetComponent=" + targetComponent +
				", type=" + type +
				", missionType=" + missionType +
				'}';
	}
}
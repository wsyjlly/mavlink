package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.MavComponent;
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
		id = 52,
		messagePayloadLength = 7,
		description = "A broadcast message to notify any ground station or SDK if a mission, geofence or safe points have changed on the vehicle."
)
public class MissionChanged implements Message {
	@MavlinkMessageParam(mavlinkType = "int16_t", position = 1, typeSize = 2, streamLength = 2, description = "Start index for partial mission change (-1 for all items).")
	private short startIndex;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 2, typeSize = 2, streamLength = 2, description = "End index of a partial mission change. -1 is a synonym for the last mission item (i.e. selects all items from start_index). Ignore field if start_index=-1.")
	private short endIndex;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, description = "System ID of the author of the new mission.")
	private short originSysid;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 1, description = "Compnent ID of the author of the new mission.", enum0 = MavComponent.class)
	private short originCompid;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 5, typeSize = 1, streamLength = 1, description = "Mission type.", enum0 = MavMissionType.class)
	private short missionType;

	private final int messagePayloadLength = 7;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public MissionChanged(short startIndex, short endIndex, short originSysid, short originCompid, short missionType) {
		this.startIndex = startIndex;
		this.endIndex = endIndex;
		this.originSysid = originSysid;
		this.originCompid = originCompid;
		this.missionType = missionType;
	}

	public MissionChanged(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 7！");
		}
		messagePayload(messagePayload);
	}

	public MissionChanged(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		startIndex = byteArray.getInt16(0);
		endIndex = byteArray.getInt16(2);
		originSysid = byteArray.getUnsignedInt8(4);
		originCompid = byteArray.getUnsignedInt8(5);
		missionType = byteArray.getUnsignedInt8(6);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putInt16(startIndex,0);
		byteArray.putInt16(endIndex,2);
		byteArray.putUnsignedInt8(originSysid,4);
		byteArray.putUnsignedInt8(originCompid,5);
		byteArray.putUnsignedInt8(missionType,6);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final MissionChanged setStartIndex(short startIndex) {
		this.startIndex = startIndex;
		return this;
	}

	public final short getStartIndex() {
		return startIndex;
	}

	public final MissionChanged setEndIndex(short endIndex) {
		this.endIndex = endIndex;
		return this;
	}

	public final short getEndIndex() {
		return endIndex;
	}

	public final MissionChanged setOriginSysid(short originSysid) {
		this.originSysid = originSysid;
		return this;
	}

	public final short getOriginSysid() {
		return originSysid;
	}

	public final MissionChanged setOriginCompid(short originCompid) {
		this.originCompid = originCompid;
		return this;
	}

	public final short getOriginCompid() {
		return originCompid;
	}

	public final MissionChanged setMissionType(short missionType) {
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
			MissionChanged other = (MissionChanged)o;
			if (!Objects.deepEquals(this.startIndex, other.startIndex)) {
				return false;
			} else if (!Objects.deepEquals(this.endIndex, other.endIndex)) {
				return false;
			} else if (!Objects.deepEquals(this.originSysid, other.originSysid)) {
				return false;
			} else if (!Objects.deepEquals(this.originCompid, other.originCompid)) {
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
		result = 31 * result + Objects.hashCode(this.startIndex);
		result = 31 * result + Objects.hashCode(this.endIndex);
		result = 31 * result + Objects.hashCode(this.originSysid);
		result = 31 * result + Objects.hashCode(this.originCompid);
		result = 31 * result + Objects.hashCode(this.missionType);
		return result;
	}

	@Override
	public String toString() {
		return "MissionChanged{" +
				"startIndex=" + startIndex +
				", endIndex=" + endIndex +
				", originSysid=" + originSysid +
				", originCompid=" + originCompid +
				", missionType=" + missionType +
				'}';
	}
}
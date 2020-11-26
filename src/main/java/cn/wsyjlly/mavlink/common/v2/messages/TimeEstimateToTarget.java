package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 380,
		messagePayloadLength = 20,
		description = "Time/duration estimates for various events and actions given the current vehicle state and position."
)
public class TimeEstimateToTarget implements Message {
	@MavlinkMessageParam(mavlinkType = "int32_t", position = 1, typeSize = 4, streamLength = 4, description = "Estimated time to complete the vehicle's configured 'safe return' action from its current position (e.g. RTL, Smart RTL, etc.). -1 indicates that the vehicle is landed, or that no time estimate available.", units = "s")
	private int safeReturn;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 2, typeSize = 4, streamLength = 4, description = "Estimated time for vehicle to complete the LAND action from its current position. -1 indicates that the vehicle is landed, or that no time estimate available.", units = "s")
	private int land;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 3, typeSize = 4, streamLength = 4, description = "Estimated time for reaching/completing the currently active mission item. -1 means no time estimate available.", units = "s")
	private int missionNextItem;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 4, typeSize = 4, streamLength = 4, description = "Estimated time for completing the current mission. -1 means no mission active and/or no estimate available.", units = "s")
	private int missionEnd;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 5, typeSize = 4, streamLength = 4, description = "Estimated time for completing the current commanded action (i.e. Go To, Takeoff, Land, etc.). -1 means no action active and/or no estimate available.", units = "s")
	private int commandedAction;

	private final int messagePayloadLength = 20;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public TimeEstimateToTarget(int safeReturn, int land, int missionNextItem, int missionEnd, int commandedAction) {
		this.safeReturn = safeReturn;
		this.land = land;
		this.missionNextItem = missionNextItem;
		this.missionEnd = missionEnd;
		this.commandedAction = commandedAction;
	}

	public TimeEstimateToTarget(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 20！");
		}
		messagePayload(messagePayload);
	}

	public TimeEstimateToTarget(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		safeReturn = byteArray.getInt32(0);
		land = byteArray.getInt32(4);
		missionNextItem = byteArray.getInt32(8);
		missionEnd = byteArray.getInt32(12);
		commandedAction = byteArray.getInt32(16);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putInt32(safeReturn,0);
		byteArray.putInt32(land,4);
		byteArray.putInt32(missionNextItem,8);
		byteArray.putInt32(missionEnd,12);
		byteArray.putInt32(commandedAction,16);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final TimeEstimateToTarget setSafeReturn(int safeReturn) {
		this.safeReturn = safeReturn;
		return this;
	}

	public final int getSafeReturn() {
		return safeReturn;
	}

	public final TimeEstimateToTarget setLand(int land) {
		this.land = land;
		return this;
	}

	public final int getLand() {
		return land;
	}

	public final TimeEstimateToTarget setMissionNextItem(int missionNextItem) {
		this.missionNextItem = missionNextItem;
		return this;
	}

	public final int getMissionNextItem() {
		return missionNextItem;
	}

	public final TimeEstimateToTarget setMissionEnd(int missionEnd) {
		this.missionEnd = missionEnd;
		return this;
	}

	public final int getMissionEnd() {
		return missionEnd;
	}

	public final TimeEstimateToTarget setCommandedAction(int commandedAction) {
		this.commandedAction = commandedAction;
		return this;
	}

	public final int getCommandedAction() {
		return commandedAction;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			TimeEstimateToTarget other = (TimeEstimateToTarget)o;
			if (!Objects.deepEquals(this.safeReturn, other.safeReturn)) {
				return false;
			} else if (!Objects.deepEquals(this.land, other.land)) {
				return false;
			} else if (!Objects.deepEquals(this.missionNextItem, other.missionNextItem)) {
				return false;
			} else if (!Objects.deepEquals(this.missionEnd, other.missionEnd)) {
				return false;
			} else {
				return Objects.deepEquals(this.commandedAction, other.commandedAction);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.safeReturn);
		result = 31 * result + Objects.hashCode(this.land);
		result = 31 * result + Objects.hashCode(this.missionNextItem);
		result = 31 * result + Objects.hashCode(this.missionEnd);
		result = 31 * result + Objects.hashCode(this.commandedAction);
		return result;
	}

	@Override
	public String toString() {
		return "TimeEstimateToTarget{" +
				"safeReturn=" + safeReturn +
				", land=" + land +
				", missionNextItem=" + missionNextItem +
				", missionEnd=" + missionEnd +
				", commandedAction=" + commandedAction +
				'}';
	}
}
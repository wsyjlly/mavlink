package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.GimbalManagerFlags;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 281,
		messagePayloadLength = 13,
		description = "Current status about a high level gimbal manager. This message should be broadcast at a low regular rate (e.g. 5Hz)."
)
public class GimbalManagerStatus implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4, description = "Timestamp (time since system boot).", units = "ms")
	private long timeBootMs;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 2, typeSize = 4, streamLength = 4, description = "High level gimbal manager flags currently applied.", enum0 = GimbalManagerFlags.class)
	private long flags;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, description = "Gimbal device ID that this gimbal manager is responsible for.")
	private short gimbalDeviceId;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 1, description = "System ID of MAVLink component with primary control, 0 for none.")
	private short primaryControlSysid;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 5, typeSize = 1, streamLength = 1, description = "Component ID of MAVLink component with primary control, 0 for none.")
	private short primaryControlCompid;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 6, typeSize = 1, streamLength = 1, description = "System ID of MAVLink component with secondary control, 0 for none.")
	private short secondaryControlSysid;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 7, typeSize = 1, streamLength = 1, description = "Component ID of MAVLink component with secondary control, 0 for none.")
	private short secondaryControlCompid;

	private final int messagePayloadLength = 13;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public GimbalManagerStatus(long timeBootMs, long flags, short gimbalDeviceId, short primaryControlSysid, short primaryControlCompid, short secondaryControlSysid, short secondaryControlCompid) {
		this.timeBootMs = timeBootMs;
		this.flags = flags;
		this.gimbalDeviceId = gimbalDeviceId;
		this.primaryControlSysid = primaryControlSysid;
		this.primaryControlCompid = primaryControlCompid;
		this.secondaryControlSysid = secondaryControlSysid;
		this.secondaryControlCompid = secondaryControlCompid;
	}

	public GimbalManagerStatus(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 13！");
		}
		messagePayload(messagePayload);
	}

	public GimbalManagerStatus(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeBootMs = byteArray.getUnsignedInt32(0);
		flags = byteArray.getUnsignedInt32(4);
		gimbalDeviceId = byteArray.getUnsignedInt8(8);
		primaryControlSysid = byteArray.getUnsignedInt8(9);
		primaryControlCompid = byteArray.getUnsignedInt8(10);
		secondaryControlSysid = byteArray.getUnsignedInt8(11);
		secondaryControlCompid = byteArray.getUnsignedInt8(12);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt32(timeBootMs,0);
		byteArray.putUnsignedInt32(flags,4);
		byteArray.putUnsignedInt8(gimbalDeviceId,8);
		byteArray.putUnsignedInt8(primaryControlSysid,9);
		byteArray.putUnsignedInt8(primaryControlCompid,10);
		byteArray.putUnsignedInt8(secondaryControlSysid,11);
		byteArray.putUnsignedInt8(secondaryControlCompid,12);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final GimbalManagerStatus setTimeBootMs(long timeBootMs) {
		this.timeBootMs = timeBootMs;
		return this;
	}

	public final long getTimeBootMs() {
		return timeBootMs;
	}

	public final GimbalManagerStatus setFlags(long flags) {
		this.flags = flags;
		return this;
	}

	public final long getFlags() {
		return flags;
	}

	public final GimbalManagerStatus setGimbalDeviceId(short gimbalDeviceId) {
		this.gimbalDeviceId = gimbalDeviceId;
		return this;
	}

	public final short getGimbalDeviceId() {
		return gimbalDeviceId;
	}

	public final GimbalManagerStatus setPrimaryControlSysid(short primaryControlSysid) {
		this.primaryControlSysid = primaryControlSysid;
		return this;
	}

	public final short getPrimaryControlSysid() {
		return primaryControlSysid;
	}

	public final GimbalManagerStatus setPrimaryControlCompid(short primaryControlCompid) {
		this.primaryControlCompid = primaryControlCompid;
		return this;
	}

	public final short getPrimaryControlCompid() {
		return primaryControlCompid;
	}

	public final GimbalManagerStatus setSecondaryControlSysid(short secondaryControlSysid) {
		this.secondaryControlSysid = secondaryControlSysid;
		return this;
	}

	public final short getSecondaryControlSysid() {
		return secondaryControlSysid;
	}

	public final GimbalManagerStatus setSecondaryControlCompid(short secondaryControlCompid) {
		this.secondaryControlCompid = secondaryControlCompid;
		return this;
	}

	public final short getSecondaryControlCompid() {
		return secondaryControlCompid;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			GimbalManagerStatus other = (GimbalManagerStatus)o;
			if (!Objects.deepEquals(this.timeBootMs, other.timeBootMs)) {
				return false;
			} else if (!Objects.deepEquals(this.flags, other.flags)) {
				return false;
			} else if (!Objects.deepEquals(this.gimbalDeviceId, other.gimbalDeviceId)) {
				return false;
			} else if (!Objects.deepEquals(this.primaryControlSysid, other.primaryControlSysid)) {
				return false;
			} else if (!Objects.deepEquals(this.primaryControlCompid, other.primaryControlCompid)) {
				return false;
			} else if (!Objects.deepEquals(this.secondaryControlSysid, other.secondaryControlSysid)) {
				return false;
			} else {
				return Objects.deepEquals(this.secondaryControlCompid, other.secondaryControlCompid);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeBootMs);
		result = 31 * result + Objects.hashCode(this.flags);
		result = 31 * result + Objects.hashCode(this.gimbalDeviceId);
		result = 31 * result + Objects.hashCode(this.primaryControlSysid);
		result = 31 * result + Objects.hashCode(this.primaryControlCompid);
		result = 31 * result + Objects.hashCode(this.secondaryControlSysid);
		result = 31 * result + Objects.hashCode(this.secondaryControlCompid);
		return result;
	}

	@Override
	public String toString() {
		return "GimbalManagerStatus{" +
				"timeBootMs=" + timeBootMs +
				", flags=" + flags +
				", gimbalDeviceId=" + gimbalDeviceId +
				", primaryControlSysid=" + primaryControlSysid +
				", primaryControlCompid=" + primaryControlCompid +
				", secondaryControlSysid=" + secondaryControlSysid +
				", secondaryControlCompid=" + secondaryControlCompid +
				'}';
	}
}
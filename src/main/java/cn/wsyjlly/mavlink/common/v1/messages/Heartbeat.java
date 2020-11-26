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
		id = 0,
		messagePayloadLength = 9,
		description = "The heartbeat message shows that a system is present and responding. The type of the MAV and Autopilot hardware allow the receiving system to treat further messages from this system appropriate (e.g. by laying out the user interface based on the autopilot)."
)
public class Heartbeat implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "Type of the MAV (quadrotor, helicopter, etc., up to 15 types, defined in MAV_TYPE ENUM)")
	private short type;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Autopilot type / class. defined in MAV_AUTOPILOT ENUM")
	private short autopilot;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, description = "System mode bitfield, see MAV_MODE_FLAG ENUM in mavlink/include/mavlink_types.h")
	private short baseMode;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 4, typeSize = 4, streamLength = 4, description = "A bitfield for use for autopilot-specific flags.")
	private long customMode;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 5, typeSize = 1, streamLength = 1, description = "System status flag, see MAV_STATE ENUM")
	private short systemStatus;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 6, typeSize = 1, streamLength = 1, description = "MAVLink version, not writable by user, gets added by protocol because of magic data type: uint8_t_mavlink_version")
	private short mavlinkVersion;

	private final int messagePayloadLength = 9;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public Heartbeat(short type, short autopilot, short baseMode, long customMode, short systemStatus, short mavlinkVersion) {
		this.type = type;
		this.autopilot = autopilot;
		this.baseMode = baseMode;
		this.customMode = customMode;
		this.systemStatus = systemStatus;
		this.mavlinkVersion = mavlinkVersion;
	}

	public Heartbeat(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 9！");
		}
		messagePayload(messagePayload);
	}

	public Heartbeat(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		type = byteArray.getUnsignedInt8(0);
		autopilot = byteArray.getUnsignedInt8(1);
		baseMode = byteArray.getUnsignedInt8(2);
		customMode = byteArray.getUnsignedInt32(3);
		systemStatus = byteArray.getUnsignedInt8(7);
		mavlinkVersion = byteArray.getUnsignedInt8(8);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(type,0);
		byteArray.putUnsignedInt8(autopilot,1);
		byteArray.putUnsignedInt8(baseMode,2);
		byteArray.putUnsignedInt32(customMode,3);
		byteArray.putUnsignedInt8(systemStatus,7);
		byteArray.putUnsignedInt8(mavlinkVersion,8);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final Heartbeat setType(short type) {
		this.type = type;
		return this;
	}

	public final short getType() {
		return type;
	}

	public final Heartbeat setAutopilot(short autopilot) {
		this.autopilot = autopilot;
		return this;
	}

	public final short getAutopilot() {
		return autopilot;
	}

	public final Heartbeat setBaseMode(short baseMode) {
		this.baseMode = baseMode;
		return this;
	}

	public final short getBaseMode() {
		return baseMode;
	}

	public final Heartbeat setCustomMode(long customMode) {
		this.customMode = customMode;
		return this;
	}

	public final long getCustomMode() {
		return customMode;
	}

	public final Heartbeat setSystemStatus(short systemStatus) {
		this.systemStatus = systemStatus;
		return this;
	}

	public final short getSystemStatus() {
		return systemStatus;
	}

	public final Heartbeat setMavlinkVersion(short mavlinkVersion) {
		this.mavlinkVersion = mavlinkVersion;
		return this;
	}

	public final short getMavlinkVersion() {
		return mavlinkVersion;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			Heartbeat other = (Heartbeat)o;
			if (!Objects.deepEquals(this.type, other.type)) {
				return false;
			} else if (!Objects.deepEquals(this.autopilot, other.autopilot)) {
				return false;
			} else if (!Objects.deepEquals(this.baseMode, other.baseMode)) {
				return false;
			} else if (!Objects.deepEquals(this.customMode, other.customMode)) {
				return false;
			} else if (!Objects.deepEquals(this.systemStatus, other.systemStatus)) {
				return false;
			} else {
				return Objects.deepEquals(this.mavlinkVersion, other.mavlinkVersion);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.type);
		result = 31 * result + Objects.hashCode(this.autopilot);
		result = 31 * result + Objects.hashCode(this.baseMode);
		result = 31 * result + Objects.hashCode(this.customMode);
		result = 31 * result + Objects.hashCode(this.systemStatus);
		result = 31 * result + Objects.hashCode(this.mavlinkVersion);
		return result;
	}

	@Override
	public String toString() {
		return "Heartbeat{" +
				"type=" + type +
				", autopilot=" + autopilot +
				", baseMode=" + baseMode +
				", customMode=" + customMode +
				", systemStatus=" + systemStatus +
				", mavlinkVersion=" + mavlinkVersion +
				'}';
	}
}
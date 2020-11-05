package cn.swyan.mavlink.common.messages;

import cn.swyan.mavlink.annotation.MavlinkMessage;
import cn.swyan.mavlink.annotation.MavlinkMessageParam;
import cn.swyan.mavlink.common.Message;
import cn.swyan.mavlink.common.enums.MavMode;
import cn.swyan.mavlink.protocol.ByteArray;
import cn.swyan.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * @Author YSW
 * @Description
 * @Date 2020.11.04 - 03:56
 **********************************/

@MavlinkMessage(
		id = 11,
		messagePayloadLength = 6,
		description = "Set the system mode, as defined by enum MAV_MODE. There is no target component id as the mode is by definition for the overall aircraft, not only for one component."
)
public class SetMode implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1)
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, enum0 = MavMode.class)
	private short baseMode;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 3, typeSize = 4, streamLength = 4)
	private long customMode;

	private final int messagePayloadLength = 6;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public SetMode(short targetSystem, short baseMode, long customMode) {
		this.targetSystem = targetSystem;
		this.baseMode = baseMode;
		this.customMode = customMode;
	}

	public SetMode(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 6！");
		}
		messagePayload(messagePayload);
	}

	public SetMode(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.targetSystem = byteArray.getUnsignedInt8(0);
		this.baseMode = byteArray.getUnsignedInt8(1);
		this.customMode = byteArray.getUnsignedInt32(2);
	}

	@Override
	public byte[] messagePayload() {
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final SetMode setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final SetMode setBaseMode(short baseMode) {
		this.baseMode = baseMode;
		return this;
	}

	public final short getBaseMode() {
		return baseMode;
	}

	public final SetMode setCustomMode(long customMode) {
		this.customMode = customMode;
		return this;
	}

	public final long getCustomMode() {
		return customMode;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			SetMode other = (SetMode)o;
			if (!Objects.deepEquals(this.targetSystem, other.targetSystem)) {
				return false;
			} else if (!Objects.deepEquals(this.baseMode, other.baseMode)) {
				return false;
			} else {
				return Objects.deepEquals(this.customMode, other.customMode);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.targetSystem);
		result = 31 * result + Objects.hashCode(this.baseMode);
		result = 31 * result + Objects.hashCode(this.customMode);
		return result;
	}

	@Override
	public String toString() {
		return "SetMode{" +
				"targetSystem=" + targetSystem +
				", baseMode=" + baseMode +
				", customMode=" + customMode +
				'}';
	}
}
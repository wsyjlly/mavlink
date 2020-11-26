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
		id = 320,
		messagePayloadLength = 21,
		description = "Request to read the value of a parameter with either the param_id string id or param_index. PARAM_EXT_VALUE or PARAM_EXT_VALUE_TRIMMED should be emitted in response (see field: trimmed)."
)
public class ParamExtRequestRead implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "System ID")
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Component ID")
	private short targetComponent;

	@MavlinkMessageParam(mavlinkType = "char", position = 3, typeSize = 1, streamLength = 16, description = "Parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 16+1 bytes storage if the ID is stored as string")
	private String paramId;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 4, typeSize = 2, streamLength = 2, description = "Parameter index. Set to -1 to use the Parameter ID field as identifier (else param_id will be ignored)")
	private short paramIndex;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 5, typeSize = 1, streamLength = 1, description = "Request _TRIMMED variants of PARAM_EXT_ messages. Set to 1 if _TRIMMED message variants are supported, and 0 otherwise. This signals the recipient that _TRIMMED messages are supported by the sender (and should be used if supported by the recipient).")
	private short trimmed;

	private final int messagePayloadLength = 21;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public ParamExtRequestRead(short targetSystem, short targetComponent, String paramId, short paramIndex, short trimmed) {
		this.targetSystem = targetSystem;
		this.targetComponent = targetComponent;
		this.paramId = paramId;
		this.paramIndex = paramIndex;
		this.trimmed = trimmed;
	}

	public ParamExtRequestRead(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 21！");
		}
		messagePayload(messagePayload);
	}

	public ParamExtRequestRead(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		targetSystem = byteArray.getUnsignedInt8(0);
		targetComponent = byteArray.getUnsignedInt8(1);
		paramId = byteArray.getChars(2,16);
		paramIndex = byteArray.getInt16(18);
		trimmed = byteArray.getUnsignedInt8(20);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(targetSystem,0);
		byteArray.putUnsignedInt8(targetComponent,1);
		byteArray.putChars(paramId,2);
		byteArray.putInt16(paramIndex,18);
		byteArray.putUnsignedInt8(trimmed,20);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final ParamExtRequestRead setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final ParamExtRequestRead setTargetComponent(short targetComponent) {
		this.targetComponent = targetComponent;
		return this;
	}

	public final short getTargetComponent() {
		return targetComponent;
	}

	public final ParamExtRequestRead setParamId(String paramId) {
		this.paramId = paramId;
		return this;
	}

	public final String getParamId() {
		return paramId;
	}

	public final ParamExtRequestRead setParamIndex(short paramIndex) {
		this.paramIndex = paramIndex;
		return this;
	}

	public final short getParamIndex() {
		return paramIndex;
	}

	public final ParamExtRequestRead setTrimmed(short trimmed) {
		this.trimmed = trimmed;
		return this;
	}

	public final short getTrimmed() {
		return trimmed;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			ParamExtRequestRead other = (ParamExtRequestRead)o;
			if (!Objects.deepEquals(this.targetSystem, other.targetSystem)) {
				return false;
			} else if (!Objects.deepEquals(this.targetComponent, other.targetComponent)) {
				return false;
			} else if (!Objects.deepEquals(this.paramId, other.paramId)) {
				return false;
			} else if (!Objects.deepEquals(this.paramIndex, other.paramIndex)) {
				return false;
			} else {
				return Objects.deepEquals(this.trimmed, other.trimmed);
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
		result = 31 * result + Objects.hashCode(this.paramId);
		result = 31 * result + Objects.hashCode(this.paramIndex);
		result = 31 * result + Objects.hashCode(this.trimmed);
		return result;
	}

	@Override
	public String toString() {
		return "ParamExtRequestRead{" +
				"targetSystem=" + targetSystem +
				", targetComponent=" + targetComponent +
				", paramId=" + paramId +
				", paramIndex=" + paramIndex +
				", trimmed=" + trimmed +
				'}';
	}
}
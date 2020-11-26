package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.MavParamExtType;
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
		id = 325,
		messagePayloadLength = 149,
		description = "Emit the value of a parameter. The inclusion of param_count and param_index in the message allows the recipient to keep track of received parameters and allows them to re-request missing parameters after a loss or timeout. Replacement for PARAM_EXT_VALUE."
)
public class ParamExtValueTrimmed implements Message {
	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 1, typeSize = 2, streamLength = 2, description = "Total number of parameters")
	private int paramCount;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 2, typeSize = 2, streamLength = 2, description = "Index of this parameter")
	private int paramIndex;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, description = "Parameter type.", enum0 = MavParamExtType.class)
	private short paramType;

	@MavlinkMessageParam(mavlinkType = "char", position = 4, typeSize = 1, streamLength = 16, description = "Parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 16+1 bytes storage if the ID is stored as string")
	private String paramId;

	@MavlinkMessageParam(mavlinkType = "char", position = 5, typeSize = 1, streamLength = 128, description = "Parameter value (zeros get trimmed)")
	private String paramValue;

	private final int messagePayloadLength = 149;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public ParamExtValueTrimmed(int paramCount, int paramIndex, short paramType, String paramId, String paramValue) {
		this.paramCount = paramCount;
		this.paramIndex = paramIndex;
		this.paramType = paramType;
		this.paramId = paramId;
		this.paramValue = paramValue;
	}

	public ParamExtValueTrimmed(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 149！");
		}
		messagePayload(messagePayload);
	}

	public ParamExtValueTrimmed(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		paramCount = byteArray.getUnsignedInt16(0);
		paramIndex = byteArray.getUnsignedInt16(2);
		paramType = byteArray.getUnsignedInt8(4);
		paramId = byteArray.getChars(5,16);
		paramValue = byteArray.getChars(21,128);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt16(paramCount,0);
		byteArray.putUnsignedInt16(paramIndex,2);
		byteArray.putUnsignedInt8(paramType,4);
		byteArray.putChars(paramId,5);
		byteArray.putChars(paramValue,21);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final ParamExtValueTrimmed setParamCount(int paramCount) {
		this.paramCount = paramCount;
		return this;
	}

	public final int getParamCount() {
		return paramCount;
	}

	public final ParamExtValueTrimmed setParamIndex(int paramIndex) {
		this.paramIndex = paramIndex;
		return this;
	}

	public final int getParamIndex() {
		return paramIndex;
	}

	public final ParamExtValueTrimmed setParamType(short paramType) {
		this.paramType = paramType;
		return this;
	}

	public final short getParamType() {
		return paramType;
	}

	public final ParamExtValueTrimmed setParamId(String paramId) {
		this.paramId = paramId;
		return this;
	}

	public final String getParamId() {
		return paramId;
	}

	public final ParamExtValueTrimmed setParamValue(String paramValue) {
		this.paramValue = paramValue;
		return this;
	}

	public final String getParamValue() {
		return paramValue;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			ParamExtValueTrimmed other = (ParamExtValueTrimmed)o;
			if (!Objects.deepEquals(this.paramCount, other.paramCount)) {
				return false;
			} else if (!Objects.deepEquals(this.paramIndex, other.paramIndex)) {
				return false;
			} else if (!Objects.deepEquals(this.paramType, other.paramType)) {
				return false;
			} else if (!Objects.deepEquals(this.paramId, other.paramId)) {
				return false;
			} else {
				return Objects.deepEquals(this.paramValue, other.paramValue);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.paramCount);
		result = 31 * result + Objects.hashCode(this.paramIndex);
		result = 31 * result + Objects.hashCode(this.paramType);
		result = 31 * result + Objects.hashCode(this.paramId);
		result = 31 * result + Objects.hashCode(this.paramValue);
		return result;
	}

	@Override
	public String toString() {
		return "ParamExtValueTrimmed{" +
				"paramCount=" + paramCount +
				", paramIndex=" + paramIndex +
				", paramType=" + paramType +
				", paramId=" + paramId +
				", paramValue=" + paramValue +
				'}';
	}
}
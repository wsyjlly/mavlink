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
		id = 322,
		messagePayloadLength = 149,
		description = "Emit the value of a parameter. The inclusion of param_count and param_index in the message allows the recipient to keep track of received parameters and allows them to re-request missing parameters after a loss or timeout."
)
public class ParamExtValue implements Message {
	@MavlinkMessageParam(mavlinkType = "char", position = 1, typeSize = 1, streamLength = 16, description = "Parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 16+1 bytes storage if the ID is stored as string")
	private String paramId;

	@MavlinkMessageParam(mavlinkType = "char", position = 2, typeSize = 1, streamLength = 128, description = "Parameter value")
	private String paramValue;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, description = "Parameter type.", enum0 = MavParamExtType.class)
	private short paramType;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 4, typeSize = 2, streamLength = 2, description = "Total number of parameters")
	private int paramCount;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 5, typeSize = 2, streamLength = 2, description = "Index of this parameter")
	private int paramIndex;

	private final int messagePayloadLength = 149;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public ParamExtValue(String paramId, String paramValue, short paramType, int paramCount, int paramIndex) {
		this.paramId = paramId;
		this.paramValue = paramValue;
		this.paramType = paramType;
		this.paramCount = paramCount;
		this.paramIndex = paramIndex;
	}

	public ParamExtValue(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 149！");
		}
		messagePayload(messagePayload);
	}

	public ParamExtValue(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		paramId = byteArray.getChars(0,16);
		paramValue = byteArray.getChars(16,128);
		paramType = byteArray.getUnsignedInt8(144);
		paramCount = byteArray.getUnsignedInt16(145);
		paramIndex = byteArray.getUnsignedInt16(147);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putChars(paramId,0);
		byteArray.putChars(paramValue,16);
		byteArray.putUnsignedInt8(paramType,144);
		byteArray.putUnsignedInt16(paramCount,145);
		byteArray.putUnsignedInt16(paramIndex,147);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final ParamExtValue setParamId(String paramId) {
		this.paramId = paramId;
		return this;
	}

	public final String getParamId() {
		return paramId;
	}

	public final ParamExtValue setParamValue(String paramValue) {
		this.paramValue = paramValue;
		return this;
	}

	public final String getParamValue() {
		return paramValue;
	}

	public final ParamExtValue setParamType(short paramType) {
		this.paramType = paramType;
		return this;
	}

	public final short getParamType() {
		return paramType;
	}

	public final ParamExtValue setParamCount(int paramCount) {
		this.paramCount = paramCount;
		return this;
	}

	public final int getParamCount() {
		return paramCount;
	}

	public final ParamExtValue setParamIndex(int paramIndex) {
		this.paramIndex = paramIndex;
		return this;
	}

	public final int getParamIndex() {
		return paramIndex;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			ParamExtValue other = (ParamExtValue)o;
			if (!Objects.deepEquals(this.paramId, other.paramId)) {
				return false;
			} else if (!Objects.deepEquals(this.paramValue, other.paramValue)) {
				return false;
			} else if (!Objects.deepEquals(this.paramType, other.paramType)) {
				return false;
			} else if (!Objects.deepEquals(this.paramCount, other.paramCount)) {
				return false;
			} else {
				return Objects.deepEquals(this.paramIndex, other.paramIndex);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.paramId);
		result = 31 * result + Objects.hashCode(this.paramValue);
		result = 31 * result + Objects.hashCode(this.paramType);
		result = 31 * result + Objects.hashCode(this.paramCount);
		result = 31 * result + Objects.hashCode(this.paramIndex);
		return result;
	}

	@Override
	public String toString() {
		return "ParamExtValue{" +
				"paramId=" + paramId +
				", paramValue=" + paramValue +
				", paramType=" + paramType +
				", paramCount=" + paramCount +
				", paramIndex=" + paramIndex +
				'}';
	}
}
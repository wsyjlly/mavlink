package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.ParamAck;
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
		id = 327,
		messagePayloadLength = 146,
		description = "Response from a PARAM_EXT_SET_TRIMMED message."
)
public class ParamExtAckTrimmed implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "Result code.", enum0 = ParamAck.class)
	private short paramResult;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Parameter type.", enum0 = MavParamExtType.class)
	private short paramType;

	@MavlinkMessageParam(mavlinkType = "char", position = 3, typeSize = 1, streamLength = 16, description = "Parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 16+1 bytes storage if the ID is stored as string")
	private String paramId;

	@MavlinkMessageParam(mavlinkType = "char", position = 4, typeSize = 1, streamLength = 128, description = "Parameter value (new value if PARAM_ACK_ACCEPTED, current value otherwise, zeros get trimmed)")
	private String paramValue;

	private final int messagePayloadLength = 146;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public ParamExtAckTrimmed(short paramResult, short paramType, String paramId, String paramValue) {
		this.paramResult = paramResult;
		this.paramType = paramType;
		this.paramId = paramId;
		this.paramValue = paramValue;
	}

	public ParamExtAckTrimmed(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 146！");
		}
		messagePayload(messagePayload);
	}

	public ParamExtAckTrimmed(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		paramResult = byteArray.getUnsignedInt8(0);
		paramType = byteArray.getUnsignedInt8(1);
		paramId = byteArray.getChars(2,16);
		paramValue = byteArray.getChars(18,128);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(paramResult,0);
		byteArray.putUnsignedInt8(paramType,1);
		byteArray.putChars(paramId,2);
		byteArray.putChars(paramValue,18);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final ParamExtAckTrimmed setParamResult(short paramResult) {
		this.paramResult = paramResult;
		return this;
	}

	public final short getParamResult() {
		return paramResult;
	}

	public final ParamExtAckTrimmed setParamType(short paramType) {
		this.paramType = paramType;
		return this;
	}

	public final short getParamType() {
		return paramType;
	}

	public final ParamExtAckTrimmed setParamId(String paramId) {
		this.paramId = paramId;
		return this;
	}

	public final String getParamId() {
		return paramId;
	}

	public final ParamExtAckTrimmed setParamValue(String paramValue) {
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
			ParamExtAckTrimmed other = (ParamExtAckTrimmed)o;
			if (!Objects.deepEquals(this.paramResult, other.paramResult)) {
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
		result = 31 * result + Objects.hashCode(this.paramResult);
		result = 31 * result + Objects.hashCode(this.paramType);
		result = 31 * result + Objects.hashCode(this.paramId);
		result = 31 * result + Objects.hashCode(this.paramValue);
		return result;
	}

	@Override
	public String toString() {
		return "ParamExtAckTrimmed{" +
				"paramResult=" + paramResult +
				", paramType=" + paramType +
				", paramId=" + paramId +
				", paramValue=" + paramValue +
				'}';
	}
}
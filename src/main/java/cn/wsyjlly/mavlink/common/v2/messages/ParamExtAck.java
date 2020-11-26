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
		id = 324,
		messagePayloadLength = 146,
		description = "Response from a PARAM_EXT_SET message."
)
public class ParamExtAck implements Message {
	@MavlinkMessageParam(mavlinkType = "char", position = 1, typeSize = 1, streamLength = 16, description = "Parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 16+1 bytes storage if the ID is stored as string")
	private String paramId;

	@MavlinkMessageParam(mavlinkType = "char", position = 2, typeSize = 1, streamLength = 128, description = "Parameter value (new value if PARAM_ACK_ACCEPTED, current value otherwise)")
	private String paramValue;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, description = "Parameter type.", enum0 = MavParamExtType.class)
	private short paramType;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 1, description = "Result code.", enum0 = ParamAck.class)
	private short paramResult;

	private final int messagePayloadLength = 146;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public ParamExtAck(String paramId, String paramValue, short paramType, short paramResult) {
		this.paramId = paramId;
		this.paramValue = paramValue;
		this.paramType = paramType;
		this.paramResult = paramResult;
	}

	public ParamExtAck(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 146！");
		}
		messagePayload(messagePayload);
	}

	public ParamExtAck(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		paramId = byteArray.getChars(0,16);
		paramValue = byteArray.getChars(16,128);
		paramType = byteArray.getUnsignedInt8(144);
		paramResult = byteArray.getUnsignedInt8(145);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putChars(paramId,0);
		byteArray.putChars(paramValue,16);
		byteArray.putUnsignedInt8(paramType,144);
		byteArray.putUnsignedInt8(paramResult,145);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final ParamExtAck setParamId(String paramId) {
		this.paramId = paramId;
		return this;
	}

	public final String getParamId() {
		return paramId;
	}

	public final ParamExtAck setParamValue(String paramValue) {
		this.paramValue = paramValue;
		return this;
	}

	public final String getParamValue() {
		return paramValue;
	}

	public final ParamExtAck setParamType(short paramType) {
		this.paramType = paramType;
		return this;
	}

	public final short getParamType() {
		return paramType;
	}

	public final ParamExtAck setParamResult(short paramResult) {
		this.paramResult = paramResult;
		return this;
	}

	public final short getParamResult() {
		return paramResult;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			ParamExtAck other = (ParamExtAck)o;
			if (!Objects.deepEquals(this.paramId, other.paramId)) {
				return false;
			} else if (!Objects.deepEquals(this.paramValue, other.paramValue)) {
				return false;
			} else if (!Objects.deepEquals(this.paramType, other.paramType)) {
				return false;
			} else {
				return Objects.deepEquals(this.paramResult, other.paramResult);
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
		result = 31 * result + Objects.hashCode(this.paramResult);
		return result;
	}

	@Override
	public String toString() {
		return "ParamExtAck{" +
				"paramId=" + paramId +
				", paramValue=" + paramValue +
				", paramType=" + paramType +
				", paramResult=" + paramResult +
				'}';
	}
}
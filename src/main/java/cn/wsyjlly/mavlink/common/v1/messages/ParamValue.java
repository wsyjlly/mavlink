package cn.wsyjlly.mavlink.common.v1.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v1.enums.MavParamType;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
import java.util.Arrays;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:45
 **********************************/

@MavlinkMessage(
		id = 22,
		messagePayloadLength = 25,
		description = "Emit the value of a onboard parameter. The inclusion of param_count and param_index in the message allows the recipient to keep track of received parameters and allows him to re-request missing parameters after a loss or timeout."
)
public class ParamValue implements Message {
	@MavlinkMessageParam(mavlinkType = "char", position = 1, typeSize = 1, streamLength = 16, description = "Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 16+1 bytes storage if the ID is stored as string")
	private String paramId;

	@MavlinkMessageParam(mavlinkType = "float", position = 2, typeSize = 4, streamLength = 4, description = "Onboard parameter value")
	private float paramValue;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, description = "Onboard parameter type: see the MAV_PARAM_TYPE enum for supported data types.", enum0 = MavParamType.class)
	private short paramType;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 4, typeSize = 2, streamLength = 2, description = "Total number of onboard parameters")
	private int paramCount;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 5, typeSize = 2, streamLength = 2, description = "Index of this onboard parameter")
	private int paramIndex;

	private final int messagePayloadLength = 25;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public ParamValue(String paramId, float paramValue, short paramType, int paramCount, int paramIndex) {
		this.paramId = paramId;
		this.paramValue = paramValue;
		this.paramType = paramType;
		this.paramCount = paramCount;
		this.paramIndex = paramIndex;
	}

	public ParamValue(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 25！");
		}
		messagePayload(messagePayload);
	}

	public ParamValue(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		paramId = byteArray.getChars(0,16);
		paramValue = byteArray.getFloat(16);
		paramType = byteArray.getUnsignedInt8(20);
		paramCount = byteArray.getUnsignedInt16(21);
		paramIndex = byteArray.getUnsignedInt16(23);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putChars(paramId,0);
		byteArray.putFloat(paramValue,16);
		byteArray.putUnsignedInt8(paramType,20);
		byteArray.putUnsignedInt16(paramCount,21);
		byteArray.putUnsignedInt16(paramIndex,23);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final ParamValue setParamId(String paramId) {
		this.paramId = paramId;
		return this;
	}

	public final String getParamId() {
		return paramId;
	}

	public final ParamValue setParamValue(float paramValue) {
		this.paramValue = paramValue;
		return this;
	}

	public final float getParamValue() {
		return paramValue;
	}

	public final ParamValue setParamType(short paramType) {
		this.paramType = paramType;
		return this;
	}

	public final short getParamType() {
		return paramType;
	}

	public final ParamValue setParamCount(int paramCount) {
		this.paramCount = paramCount;
		return this;
	}

	public final int getParamCount() {
		return paramCount;
	}

	public final ParamValue setParamIndex(int paramIndex) {
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
			ParamValue other = (ParamValue)o;
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
		return "ParamValue{" +
				"paramId=" + paramId +
				", paramValue=" + paramValue +
				", paramType=" + paramType +
				", paramCount=" + paramCount +
				", paramIndex=" + paramIndex +
				'}';
	}
}
package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.ParamAck;
import cn.wsyjlly.mavlink.common.v2.enums.MavParamType;
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
		id = 19,
		messagePayloadLength = 24,
		description = "Response from a PARAM_SET message when it is used in a transaction."
)
public class ParamAckTransaction implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "Id of system that sent PARAM_SET message.")
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Id of system that sent PARAM_SET message.")
	private short targetComponent;

	@MavlinkMessageParam(mavlinkType = "char", position = 3, typeSize = 1, streamLength = 16, description = "Parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 16+1 bytes storage if the ID is stored as string")
	private String paramId;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4, description = "Parameter value (new value if PARAM_ACCEPTED, current value otherwise)")
	private float paramValue;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 5, typeSize = 1, streamLength = 1, description = "Parameter type.", enum0 = MavParamType.class)
	private short paramType;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 6, typeSize = 1, streamLength = 1, description = "Result code.", enum0 = ParamAck.class)
	private short paramResult;

	private final int messagePayloadLength = 24;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public ParamAckTransaction(short targetSystem, short targetComponent, String paramId, float paramValue, short paramType, short paramResult) {
		this.targetSystem = targetSystem;
		this.targetComponent = targetComponent;
		this.paramId = paramId;
		this.paramValue = paramValue;
		this.paramType = paramType;
		this.paramResult = paramResult;
	}

	public ParamAckTransaction(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 24！");
		}
		messagePayload(messagePayload);
	}

	public ParamAckTransaction(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		targetSystem = byteArray.getUnsignedInt8(0);
		targetComponent = byteArray.getUnsignedInt8(1);
		paramId = byteArray.getChars(2,16);
		paramValue = byteArray.getFloat(18);
		paramType = byteArray.getUnsignedInt8(22);
		paramResult = byteArray.getUnsignedInt8(23);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(targetSystem,0);
		byteArray.putUnsignedInt8(targetComponent,1);
		byteArray.putChars(paramId,2);
		byteArray.putFloat(paramValue,18);
		byteArray.putUnsignedInt8(paramType,22);
		byteArray.putUnsignedInt8(paramResult,23);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final ParamAckTransaction setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final ParamAckTransaction setTargetComponent(short targetComponent) {
		this.targetComponent = targetComponent;
		return this;
	}

	public final short getTargetComponent() {
		return targetComponent;
	}

	public final ParamAckTransaction setParamId(String paramId) {
		this.paramId = paramId;
		return this;
	}

	public final String getParamId() {
		return paramId;
	}

	public final ParamAckTransaction setParamValue(float paramValue) {
		this.paramValue = paramValue;
		return this;
	}

	public final float getParamValue() {
		return paramValue;
	}

	public final ParamAckTransaction setParamType(short paramType) {
		this.paramType = paramType;
		return this;
	}

	public final short getParamType() {
		return paramType;
	}

	public final ParamAckTransaction setParamResult(short paramResult) {
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
			ParamAckTransaction other = (ParamAckTransaction)o;
			if (!Objects.deepEquals(this.targetSystem, other.targetSystem)) {
				return false;
			} else if (!Objects.deepEquals(this.targetComponent, other.targetComponent)) {
				return false;
			} else if (!Objects.deepEquals(this.paramId, other.paramId)) {
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
		result = 31 * result + Objects.hashCode(this.targetSystem);
		result = 31 * result + Objects.hashCode(this.targetComponent);
		result = 31 * result + Objects.hashCode(this.paramId);
		result = 31 * result + Objects.hashCode(this.paramValue);
		result = 31 * result + Objects.hashCode(this.paramType);
		result = 31 * result + Objects.hashCode(this.paramResult);
		return result;
	}

	@Override
	public String toString() {
		return "ParamAckTransaction{" +
				"targetSystem=" + targetSystem +
				", targetComponent=" + targetComponent +
				", paramId=" + paramId +
				", paramValue=" + paramValue +
				", paramType=" + paramType +
				", paramResult=" + paramResult +
				'}';
	}
}
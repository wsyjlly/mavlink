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
		id = 50,
		messagePayloadLength = 37,
		description = "Bind a RC channel to a parameter. The parameter should change according to the RC channel value."
)
public class ParamMapRc implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "System ID")
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Component ID")
	private short targetComponent;

	@MavlinkMessageParam(mavlinkType = "char", position = 3, typeSize = 1, streamLength = 16, description = "Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 16+1 bytes storage if the ID is stored as string")
	private String paramId;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 4, typeSize = 2, streamLength = 2, description = "Parameter index. Send -1 to use the param ID field as identifier (else the param id will be ignored), send -2 to disable any existing map for this rc_channel_index.")
	private short paramIndex;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 5, typeSize = 1, streamLength = 1, description = "Index of parameter RC channel. Not equal to the RC channel id. Typically corresponds to a potentiometer-knob on the RC.")
	private short parameterRcChannelIndex;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4, description = "Initial parameter value")
	private float paramValue0;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4, description = "Scale, maps the RC range [-1, 1] to a parameter value")
	private float scale;

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 4, description = "Minimum param value. The protocol does not define if this overwrites an onboard minimum value. (Depends on implementation)")
	private float paramValueMin;

	@MavlinkMessageParam(mavlinkType = "float", position = 9, typeSize = 4, streamLength = 4, description = "Maximum param value. The protocol does not define if this overwrites an onboard maximum value. (Depends on implementation)")
	private float paramValueMax;

	private final int messagePayloadLength = 37;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public ParamMapRc(short targetSystem, short targetComponent, String paramId, short paramIndex, short parameterRcChannelIndex, float paramValue0, float scale, float paramValueMin, float paramValueMax) {
		this.targetSystem = targetSystem;
		this.targetComponent = targetComponent;
		this.paramId = paramId;
		this.paramIndex = paramIndex;
		this.parameterRcChannelIndex = parameterRcChannelIndex;
		this.paramValue0 = paramValue0;
		this.scale = scale;
		this.paramValueMin = paramValueMin;
		this.paramValueMax = paramValueMax;
	}

	public ParamMapRc(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 37！");
		}
		messagePayload(messagePayload);
	}

	public ParamMapRc(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		targetSystem = byteArray.getUnsignedInt8(0);
		targetComponent = byteArray.getUnsignedInt8(1);
		paramId = byteArray.getChars(2,16);
		paramIndex = byteArray.getInt16(18);
		parameterRcChannelIndex = byteArray.getUnsignedInt8(20);
		paramValue0 = byteArray.getFloat(21);
		scale = byteArray.getFloat(25);
		paramValueMin = byteArray.getFloat(29);
		paramValueMax = byteArray.getFloat(33);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(targetSystem,0);
		byteArray.putUnsignedInt8(targetComponent,1);
		byteArray.putChars(paramId,2);
		byteArray.putInt16(paramIndex,18);
		byteArray.putUnsignedInt8(parameterRcChannelIndex,20);
		byteArray.putFloat(paramValue0,21);
		byteArray.putFloat(scale,25);
		byteArray.putFloat(paramValueMin,29);
		byteArray.putFloat(paramValueMax,33);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final ParamMapRc setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final ParamMapRc setTargetComponent(short targetComponent) {
		this.targetComponent = targetComponent;
		return this;
	}

	public final short getTargetComponent() {
		return targetComponent;
	}

	public final ParamMapRc setParamId(String paramId) {
		this.paramId = paramId;
		return this;
	}

	public final String getParamId() {
		return paramId;
	}

	public final ParamMapRc setParamIndex(short paramIndex) {
		this.paramIndex = paramIndex;
		return this;
	}

	public final short getParamIndex() {
		return paramIndex;
	}

	public final ParamMapRc setParameterRcChannelIndex(short parameterRcChannelIndex) {
		this.parameterRcChannelIndex = parameterRcChannelIndex;
		return this;
	}

	public final short getParameterRcChannelIndex() {
		return parameterRcChannelIndex;
	}

	public final ParamMapRc setParamValue0(float paramValue0) {
		this.paramValue0 = paramValue0;
		return this;
	}

	public final float getParamValue0() {
		return paramValue0;
	}

	public final ParamMapRc setScale(float scale) {
		this.scale = scale;
		return this;
	}

	public final float getScale() {
		return scale;
	}

	public final ParamMapRc setParamValueMin(float paramValueMin) {
		this.paramValueMin = paramValueMin;
		return this;
	}

	public final float getParamValueMin() {
		return paramValueMin;
	}

	public final ParamMapRc setParamValueMax(float paramValueMax) {
		this.paramValueMax = paramValueMax;
		return this;
	}

	public final float getParamValueMax() {
		return paramValueMax;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			ParamMapRc other = (ParamMapRc)o;
			if (!Objects.deepEquals(this.targetSystem, other.targetSystem)) {
				return false;
			} else if (!Objects.deepEquals(this.targetComponent, other.targetComponent)) {
				return false;
			} else if (!Objects.deepEquals(this.paramId, other.paramId)) {
				return false;
			} else if (!Objects.deepEquals(this.paramIndex, other.paramIndex)) {
				return false;
			} else if (!Objects.deepEquals(this.parameterRcChannelIndex, other.parameterRcChannelIndex)) {
				return false;
			} else if (!Objects.deepEquals(this.paramValue0, other.paramValue0)) {
				return false;
			} else if (!Objects.deepEquals(this.scale, other.scale)) {
				return false;
			} else if (!Objects.deepEquals(this.paramValueMin, other.paramValueMin)) {
				return false;
			} else {
				return Objects.deepEquals(this.paramValueMax, other.paramValueMax);
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
		result = 31 * result + Objects.hashCode(this.parameterRcChannelIndex);
		result = 31 * result + Objects.hashCode(this.paramValue0);
		result = 31 * result + Objects.hashCode(this.scale);
		result = 31 * result + Objects.hashCode(this.paramValueMin);
		result = 31 * result + Objects.hashCode(this.paramValueMax);
		return result;
	}

	@Override
	public String toString() {
		return "ParamMapRc{" +
				"targetSystem=" + targetSystem +
				", targetComponent=" + targetComponent +
				", paramId=" + paramId +
				", paramIndex=" + paramIndex +
				", parameterRcChannelIndex=" + parameterRcChannelIndex +
				", paramValue0=" + paramValue0 +
				", scale=" + scale +
				", paramValueMin=" + paramValueMin +
				", paramValueMax=" + paramValueMax +
				'}';
	}
}
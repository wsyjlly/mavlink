package cn.swyan.mavlink.common.messages;

import cn.swyan.mavlink.annotation.MavlinkMessage;
import cn.swyan.mavlink.annotation.MavlinkMessageParam;
import cn.swyan.mavlink.common.Message;
import cn.swyan.mavlink.protocol.ByteArray;
import cn.swyan.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * @Author YSW
 * @Description
 * @Date 2020.11.04 - 03:56
 **********************************/

@MavlinkMessage(
		id = 20,
		messagePayloadLength = 20,
		description = "Request to read the onboard parameter with the param_id string id. Onboard parameters are stored as key[const char*] -> value[float]. This allows to send a parameter to any other component (such as the GCS) without the need of previous knowledge of possible parameter names. Thus the same GCS can store different parameters for different autopilots. See also http://qgroundcontrol.org/parameter_interface for a full documentation of QGroundControl and IMU code."
)
public class ParamRequestRead implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1)
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1)
	private short targetComponent;

	@MavlinkMessageParam(mavlinkType = "char", position = 3, typeSize = 1, streamLength = 16)
	private String paramId;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 4, typeSize = 2, streamLength = 2)
	private short paramIndex;

	private final int messagePayloadLength = 20;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public ParamRequestRead(short targetSystem, short targetComponent, String paramId, short paramIndex) {
		this.targetSystem = targetSystem;
		this.targetComponent = targetComponent;
		this.paramId = paramId;
		this.paramIndex = paramIndex;
	}

	public ParamRequestRead(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 20！");
		}
		messagePayload(messagePayload);
	}

	public ParamRequestRead(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.targetSystem = byteArray.getUnsignedInt8(0);
		this.targetComponent = byteArray.getUnsignedInt8(1);
		this.paramId = byteArray.getChars(2,16);
		this.paramIndex = byteArray.getInt16(3);
	}

	@Override
	public byte[] messagePayload() {
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final ParamRequestRead setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final ParamRequestRead setTargetComponent(short targetComponent) {
		this.targetComponent = targetComponent;
		return this;
	}

	public final short getTargetComponent() {
		return targetComponent;
	}

	public final ParamRequestRead setParamId(String paramId) {
		this.paramId = paramId;
		return this;
	}

	public final String getParamId() {
		return paramId;
	}

	public final ParamRequestRead setParamIndex(short paramIndex) {
		this.paramIndex = paramIndex;
		return this;
	}

	public final short getParamIndex() {
		return paramIndex;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			ParamRequestRead other = (ParamRequestRead)o;
			if (!Objects.deepEquals(this.targetSystem, other.targetSystem)) {
				return false;
			} else if (!Objects.deepEquals(this.targetComponent, other.targetComponent)) {
				return false;
			} else if (!Objects.deepEquals(this.paramId, other.paramId)) {
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
		result = 31 * result + Objects.hashCode(this.targetSystem);
		result = 31 * result + Objects.hashCode(this.targetComponent);
		result = 31 * result + Objects.hashCode(this.paramId);
		result = 31 * result + Objects.hashCode(this.paramIndex);
		return result;
	}

	@Override
	public String toString() {
		return "ParamRequestRead{" +
				"targetSystem=" + targetSystem +
				", targetComponent=" + targetComponent +
				", paramId=" + paramId +
				", paramIndex=" + paramIndex +
				'}';
	}
}
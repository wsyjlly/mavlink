package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.MavOdidOperatorIdType;
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
		id = 12905,
		messagePayloadLength = 43,
		description = "Data for filling the OpenDroneID Operator ID message, which contains the CAA (Civil Aviation Authority) issued operator ID."
)
public class OpenDroneIdOperatorId implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "System ID (0 for broadcast).")
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Component ID (0 for broadcast).")
	private short targetComponent;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 20, description = "Only used for drone ID data received from other UAs. See detailed description at https://mavlink.io/en/services/opendroneid.html.")
	private short[] idOrMac = new short[20];

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 1, description = "Indicates the type of the operator_id field.", enum0 = MavOdidOperatorIdType.class)
	private short operatorIdType;

	@MavlinkMessageParam(mavlinkType = "char", position = 5, typeSize = 1, streamLength = 20, description = "Text description or numeric value expressed as ASCII characters. Shall be filled with nulls in the unused portion of the field.")
	private String operatorId;

	private final int messagePayloadLength = 43;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public OpenDroneIdOperatorId(short targetSystem, short targetComponent, short[] idOrMac, short operatorIdType, String operatorId) {
		this.targetSystem = targetSystem;
		this.targetComponent = targetComponent;
		this.idOrMac = idOrMac;
		this.operatorIdType = operatorIdType;
		this.operatorId = operatorId;
	}

	public OpenDroneIdOperatorId(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 43！");
		}
		messagePayload(messagePayload);
	}

	public OpenDroneIdOperatorId(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		targetSystem = byteArray.getUnsignedInt8(0);
		targetComponent = byteArray.getUnsignedInt8(1);
		idOrMac = byteArray.getUnsignedInt8Array(2,20);
		operatorIdType = byteArray.getUnsignedInt8(22);
		operatorId = byteArray.getChars(23,20);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(targetSystem,0);
		byteArray.putUnsignedInt8(targetComponent,1);
		byteArray.putUnsignedInt8Array(idOrMac,2);
		byteArray.putUnsignedInt8(operatorIdType,22);
		byteArray.putChars(operatorId,23);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final OpenDroneIdOperatorId setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final OpenDroneIdOperatorId setTargetComponent(short targetComponent) {
		this.targetComponent = targetComponent;
		return this;
	}

	public final short getTargetComponent() {
		return targetComponent;
	}

	public final OpenDroneIdOperatorId setIdOrMac(short[] idOrMac) {
		this.idOrMac = idOrMac;
		return this;
	}

	public final short[] getIdOrMac() {
		return idOrMac;
	}

	public final OpenDroneIdOperatorId setOperatorIdType(short operatorIdType) {
		this.operatorIdType = operatorIdType;
		return this;
	}

	public final short getOperatorIdType() {
		return operatorIdType;
	}

	public final OpenDroneIdOperatorId setOperatorId(String operatorId) {
		this.operatorId = operatorId;
		return this;
	}

	public final String getOperatorId() {
		return operatorId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			OpenDroneIdOperatorId other = (OpenDroneIdOperatorId)o;
			if (!Objects.deepEquals(this.targetSystem, other.targetSystem)) {
				return false;
			} else if (!Objects.deepEquals(this.targetComponent, other.targetComponent)) {
				return false;
			} else if (!Objects.deepEquals(this.idOrMac, other.idOrMac)) {
				return false;
			} else if (!Objects.deepEquals(this.operatorIdType, other.operatorIdType)) {
				return false;
			} else {
				return Objects.deepEquals(this.operatorId, other.operatorId);
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
		result = 31 * result + Objects.hashCode(this.idOrMac);
		result = 31 * result + Objects.hashCode(this.operatorIdType);
		result = 31 * result + Objects.hashCode(this.operatorId);
		return result;
	}

	@Override
	public String toString() {
		return "OpenDroneIdOperatorId{" +
				"targetSystem=" + targetSystem +
				", targetComponent=" + targetComponent +
				", idOrMac=" + Arrays.toString(idOrMac) +
				", operatorIdType=" + operatorIdType +
				", operatorId=" + operatorId +
				'}';
	}
}
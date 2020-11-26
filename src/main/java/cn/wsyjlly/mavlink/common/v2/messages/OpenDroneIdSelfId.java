package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.MavOdidDescType;
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
		id = 12903,
		messagePayloadLength = 46,
		description = "Data for filling the OpenDroneID Self ID message. The Self ID Message is an opportunity for the operator to (optionally) declare their identity and purpose of the flight. This message can provide additional information that could reduce the threat profile of a UA (Unmanned Aircraft) flying in a particular area or manner."
)
public class OpenDroneIdSelfId implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "System ID (0 for broadcast).")
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Component ID (0 for broadcast).")
	private short targetComponent;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 20, description = "Only used for drone ID data received from other UAs. See detailed description at https://mavlink.io/en/services/opendroneid.html.")
	private short[] idOrMac = new short[20];

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 1, description = "Indicates the type of the description field.", enum0 = MavOdidDescType.class)
	private short descriptionType;

	@MavlinkMessageParam(mavlinkType = "char", position = 5, typeSize = 1, streamLength = 23, description = "Text description or numeric value expressed as ASCII characters. Shall be filled with nulls in the unused portion of the field.")
	private String description;

	private final int messagePayloadLength = 46;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public OpenDroneIdSelfId(short targetSystem, short targetComponent, short[] idOrMac, short descriptionType, String description) {
		this.targetSystem = targetSystem;
		this.targetComponent = targetComponent;
		this.idOrMac = idOrMac;
		this.descriptionType = descriptionType;
		this.description = description;
	}

	public OpenDroneIdSelfId(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 46！");
		}
		messagePayload(messagePayload);
	}

	public OpenDroneIdSelfId(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		targetSystem = byteArray.getUnsignedInt8(0);
		targetComponent = byteArray.getUnsignedInt8(1);
		idOrMac = byteArray.getUnsignedInt8Array(2,20);
		descriptionType = byteArray.getUnsignedInt8(22);
		description = byteArray.getChars(23,23);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(targetSystem,0);
		byteArray.putUnsignedInt8(targetComponent,1);
		byteArray.putUnsignedInt8Array(idOrMac,2);
		byteArray.putUnsignedInt8(descriptionType,22);
		byteArray.putChars(description,23);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final OpenDroneIdSelfId setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final OpenDroneIdSelfId setTargetComponent(short targetComponent) {
		this.targetComponent = targetComponent;
		return this;
	}

	public final short getTargetComponent() {
		return targetComponent;
	}

	public final OpenDroneIdSelfId setIdOrMac(short[] idOrMac) {
		this.idOrMac = idOrMac;
		return this;
	}

	public final short[] getIdOrMac() {
		return idOrMac;
	}

	public final OpenDroneIdSelfId setDescriptionType(short descriptionType) {
		this.descriptionType = descriptionType;
		return this;
	}

	public final short getDescriptionType() {
		return descriptionType;
	}

	public final OpenDroneIdSelfId setDescription(String description) {
		this.description = description;
		return this;
	}

	public final String getDescription() {
		return description;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			OpenDroneIdSelfId other = (OpenDroneIdSelfId)o;
			if (!Objects.deepEquals(this.targetSystem, other.targetSystem)) {
				return false;
			} else if (!Objects.deepEquals(this.targetComponent, other.targetComponent)) {
				return false;
			} else if (!Objects.deepEquals(this.idOrMac, other.idOrMac)) {
				return false;
			} else if (!Objects.deepEquals(this.descriptionType, other.descriptionType)) {
				return false;
			} else {
				return Objects.deepEquals(this.description, other.description);
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
		result = 31 * result + Objects.hashCode(this.descriptionType);
		result = 31 * result + Objects.hashCode(this.description);
		return result;
	}

	@Override
	public String toString() {
		return "OpenDroneIdSelfId{" +
				"targetSystem=" + targetSystem +
				", targetComponent=" + targetComponent +
				", idOrMac=" + Arrays.toString(idOrMac) +
				", descriptionType=" + descriptionType +
				", description=" + description +
				'}';
	}
}
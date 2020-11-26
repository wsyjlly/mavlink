package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.MavOdidUaType;
import cn.wsyjlly.mavlink.common.v2.enums.MavOdidIdType;
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
		id = 12900,
		messagePayloadLength = 44,
		description = "Data for filling the OpenDroneID Basic ID message. This and the below messages are primarily meant for feeding data to/from an OpenDroneID implementation. E.g. https://github.com/opendroneid/opendroneid-core-c. These messages are compatible with the ASTM Remote ID standard at https://www.astm.org/Standards/F3411.htm and the ASD-STAN Direct Remote ID standard. The usage of these messages is documented at https://mavlink.io/en/services/opendroneid.html."
)
public class OpenDroneIdBasicId implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "System ID (0 for broadcast).")
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Component ID (0 for broadcast).")
	private short targetComponent;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 20, description = "Only used for drone ID data received from other UAs. See detailed description at https://mavlink.io/en/services/opendroneid.html.")
	private short[] idOrMac = new short[20];

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 1, description = "Indicates the format for the uas_id field of this message.", enum0 = MavOdidIdType.class)
	private short idType;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 5, typeSize = 1, streamLength = 1, description = "Indicates the type of UA (Unmanned Aircraft).", enum0 = MavOdidUaType.class)
	private short uaType;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 6, typeSize = 1, streamLength = 20, description = "UAS (Unmanned Aircraft System) ID following the format specified by id_type. Shall be filled with nulls in the unused portion of the field.")
	private short[] uasId = new short[20];

	private final int messagePayloadLength = 44;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public OpenDroneIdBasicId(short targetSystem, short targetComponent, short[] idOrMac, short idType, short uaType, short[] uasId) {
		this.targetSystem = targetSystem;
		this.targetComponent = targetComponent;
		this.idOrMac = idOrMac;
		this.idType = idType;
		this.uaType = uaType;
		this.uasId = uasId;
	}

	public OpenDroneIdBasicId(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 44！");
		}
		messagePayload(messagePayload);
	}

	public OpenDroneIdBasicId(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		targetSystem = byteArray.getUnsignedInt8(0);
		targetComponent = byteArray.getUnsignedInt8(1);
		idOrMac = byteArray.getUnsignedInt8Array(2,20);
		idType = byteArray.getUnsignedInt8(22);
		uaType = byteArray.getUnsignedInt8(23);
		uasId = byteArray.getUnsignedInt8Array(24,20);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(targetSystem,0);
		byteArray.putUnsignedInt8(targetComponent,1);
		byteArray.putUnsignedInt8Array(idOrMac,2);
		byteArray.putUnsignedInt8(idType,22);
		byteArray.putUnsignedInt8(uaType,23);
		byteArray.putUnsignedInt8Array(uasId,24);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final OpenDroneIdBasicId setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final OpenDroneIdBasicId setTargetComponent(short targetComponent) {
		this.targetComponent = targetComponent;
		return this;
	}

	public final short getTargetComponent() {
		return targetComponent;
	}

	public final OpenDroneIdBasicId setIdOrMac(short[] idOrMac) {
		this.idOrMac = idOrMac;
		return this;
	}

	public final short[] getIdOrMac() {
		return idOrMac;
	}

	public final OpenDroneIdBasicId setIdType(short idType) {
		this.idType = idType;
		return this;
	}

	public final short getIdType() {
		return idType;
	}

	public final OpenDroneIdBasicId setUaType(short uaType) {
		this.uaType = uaType;
		return this;
	}

	public final short getUaType() {
		return uaType;
	}

	public final OpenDroneIdBasicId setUasId(short[] uasId) {
		this.uasId = uasId;
		return this;
	}

	public final short[] getUasId() {
		return uasId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			OpenDroneIdBasicId other = (OpenDroneIdBasicId)o;
			if (!Objects.deepEquals(this.targetSystem, other.targetSystem)) {
				return false;
			} else if (!Objects.deepEquals(this.targetComponent, other.targetComponent)) {
				return false;
			} else if (!Objects.deepEquals(this.idOrMac, other.idOrMac)) {
				return false;
			} else if (!Objects.deepEquals(this.idType, other.idType)) {
				return false;
			} else if (!Objects.deepEquals(this.uaType, other.uaType)) {
				return false;
			} else {
				return Objects.deepEquals(this.uasId, other.uasId);
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
		result = 31 * result + Objects.hashCode(this.idType);
		result = 31 * result + Objects.hashCode(this.uaType);
		result = 31 * result + Objects.hashCode(this.uasId);
		return result;
	}

	@Override
	public String toString() {
		return "OpenDroneIdBasicId{" +
				"targetSystem=" + targetSystem +
				", targetComponent=" + targetComponent +
				", idOrMac=" + Arrays.toString(idOrMac) +
				", idType=" + idType +
				", uaType=" + uaType +
				", uasId=" + Arrays.toString(uasId) +
				'}';
	}
}
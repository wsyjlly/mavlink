package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.MavTunnelPayloadType;
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
		id = 385,
		messagePayloadLength = 133,
		description = "Message for transporting 'arbitrary' variable-length data from one component to another (broadcast is not forbidden, but discouraged). The encoding of the data is usually extension specific, i.e. determined by the source, and is usually not documented as part of the MAVLink specification."
)
public class Tunnel implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "System ID (can be 0 for broadcast, but this is discouraged)")
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Component ID (can be 0 for broadcast, but this is discouraged)")
	private short targetComponent;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 3, typeSize = 2, streamLength = 2, description = "A code that identifies the content of the payload (0 for unknown, which is the default). If this code is less than 32768, it is a 'registered' payload type and the corresponding code should be added to the MAV_TUNNEL_PAYLOAD_TYPE enum. Software creators can register blocks of types as needed. Codes greater than 32767 are considered local experiments and should not be checked in to any widely distributed codebase.", enum0 = MavTunnelPayloadType.class)
	private int payloadType;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 1, description = "Length of the data transported in payload")
	private short payloadLength;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 5, typeSize = 1, streamLength = 128, description = "Variable length payload. The payload length is defined by payload_length. The entire content of this block is opaque unless you understand the encoding specified by payload_type.")
	private short[] payload = new short[128];

	private final int messagePayloadLength = 133;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public Tunnel(short targetSystem, short targetComponent, int payloadType, short payloadLength, short[] payload) {
		this.targetSystem = targetSystem;
		this.targetComponent = targetComponent;
		this.payloadType = payloadType;
		this.payloadLength = payloadLength;
		this.payload = payload;
	}

	public Tunnel(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 133！");
		}
		messagePayload(messagePayload);
	}

	public Tunnel(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		targetSystem = byteArray.getUnsignedInt8(0);
		targetComponent = byteArray.getUnsignedInt8(1);
		payloadType = byteArray.getUnsignedInt16(2);
		payloadLength = byteArray.getUnsignedInt8(4);
		payload = byteArray.getUnsignedInt8Array(5,128);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(targetSystem,0);
		byteArray.putUnsignedInt8(targetComponent,1);
		byteArray.putUnsignedInt16(payloadType,2);
		byteArray.putUnsignedInt8(payloadLength,4);
		byteArray.putUnsignedInt8Array(payload,5);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final Tunnel setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final Tunnel setTargetComponent(short targetComponent) {
		this.targetComponent = targetComponent;
		return this;
	}

	public final short getTargetComponent() {
		return targetComponent;
	}

	public final Tunnel setPayloadType(int payloadType) {
		this.payloadType = payloadType;
		return this;
	}

	public final int getPayloadType() {
		return payloadType;
	}

	public final Tunnel setPayloadLength(short payloadLength) {
		this.payloadLength = payloadLength;
		return this;
	}

	public final short getPayloadLength() {
		return payloadLength;
	}

	public final Tunnel setPayload(short[] payload) {
		this.payload = payload;
		return this;
	}

	public final short[] getPayload() {
		return payload;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			Tunnel other = (Tunnel)o;
			if (!Objects.deepEquals(this.targetSystem, other.targetSystem)) {
				return false;
			} else if (!Objects.deepEquals(this.targetComponent, other.targetComponent)) {
				return false;
			} else if (!Objects.deepEquals(this.payloadType, other.payloadType)) {
				return false;
			} else if (!Objects.deepEquals(this.payloadLength, other.payloadLength)) {
				return false;
			} else {
				return Objects.deepEquals(this.payload, other.payload);
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
		result = 31 * result + Objects.hashCode(this.payloadType);
		result = 31 * result + Objects.hashCode(this.payloadLength);
		result = 31 * result + Objects.hashCode(this.payload);
		return result;
	}

	@Override
	public String toString() {
		return "Tunnel{" +
				"targetSystem=" + targetSystem +
				", targetComponent=" + targetComponent +
				", payloadType=" + payloadType +
				", payloadLength=" + payloadLength +
				", payload=" + Arrays.toString(payload) +
				'}';
	}
}
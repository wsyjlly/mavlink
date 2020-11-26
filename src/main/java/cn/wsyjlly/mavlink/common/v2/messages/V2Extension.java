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
		id = 248,
		messagePayloadLength = 254,
		description = "Message implementing parts of the V2 payload specs in V1 frames for transitional support."
)
public class V2Extension implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "Network ID (0 for broadcast)")
	private short targetNetwork;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "System ID (0 for broadcast)")
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, description = "Component ID (0 for broadcast)")
	private short targetComponent;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 4, typeSize = 2, streamLength = 2, description = "A code that identifies the software component that understands this message (analogous to USB device classes or mime type strings). If this code is less than 32768, it is considered a 'registered' protocol extension and the corresponding entry should be added to https://github.com/mavlink/mavlink/definition_files/extension_message_ids.xml. Software creators can register blocks of message IDs as needed (useful for GCS specific metadata, etc...). Message_types greater than 32767 are considered local experiments and should not be checked in to any widely distributed codebase.")
	private int messageType;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 5, typeSize = 1, streamLength = 249, description = "Variable length payload. The length must be encoded in the payload as part of the message_type protocol, e.g. by including the length as payload data, or by terminating the payload data with a non-zero marker. This is required in order to reconstruct zero-terminated payloads that are (or otherwise would be) trimmed by MAVLink 2 empty-byte truncation. The entire content of the payload block is opaque unless you understand the encoding message_type. The particular encoding used can be extension specific and might not always be documented as part of the MAVLink specification.")
	private short[] payload = new short[249];

	private final int messagePayloadLength = 254;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public V2Extension(short targetNetwork, short targetSystem, short targetComponent, int messageType, short[] payload) {
		this.targetNetwork = targetNetwork;
		this.targetSystem = targetSystem;
		this.targetComponent = targetComponent;
		this.messageType = messageType;
		this.payload = payload;
	}

	public V2Extension(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 254！");
		}
		messagePayload(messagePayload);
	}

	public V2Extension(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		targetNetwork = byteArray.getUnsignedInt8(0);
		targetSystem = byteArray.getUnsignedInt8(1);
		targetComponent = byteArray.getUnsignedInt8(2);
		messageType = byteArray.getUnsignedInt16(3);
		payload = byteArray.getUnsignedInt8Array(5,249);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(targetNetwork,0);
		byteArray.putUnsignedInt8(targetSystem,1);
		byteArray.putUnsignedInt8(targetComponent,2);
		byteArray.putUnsignedInt16(messageType,3);
		byteArray.putUnsignedInt8Array(payload,5);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final V2Extension setTargetNetwork(short targetNetwork) {
		this.targetNetwork = targetNetwork;
		return this;
	}

	public final short getTargetNetwork() {
		return targetNetwork;
	}

	public final V2Extension setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final V2Extension setTargetComponent(short targetComponent) {
		this.targetComponent = targetComponent;
		return this;
	}

	public final short getTargetComponent() {
		return targetComponent;
	}

	public final V2Extension setMessageType(int messageType) {
		this.messageType = messageType;
		return this;
	}

	public final int getMessageType() {
		return messageType;
	}

	public final V2Extension setPayload(short[] payload) {
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
			V2Extension other = (V2Extension)o;
			if (!Objects.deepEquals(this.targetNetwork, other.targetNetwork)) {
				return false;
			} else if (!Objects.deepEquals(this.targetSystem, other.targetSystem)) {
				return false;
			} else if (!Objects.deepEquals(this.targetComponent, other.targetComponent)) {
				return false;
			} else if (!Objects.deepEquals(this.messageType, other.messageType)) {
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
		result = 31 * result + Objects.hashCode(this.targetNetwork);
		result = 31 * result + Objects.hashCode(this.targetSystem);
		result = 31 * result + Objects.hashCode(this.targetComponent);
		result = 31 * result + Objects.hashCode(this.messageType);
		result = 31 * result + Objects.hashCode(this.payload);
		return result;
	}

	@Override
	public String toString() {
		return "V2Extension{" +
				"targetNetwork=" + targetNetwork +
				", targetSystem=" + targetSystem +
				", targetComponent=" + targetComponent +
				", messageType=" + messageType +
				", payload=" + Arrays.toString(payload) +
				'}';
	}
}
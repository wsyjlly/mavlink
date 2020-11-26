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
		id = 12915,
		messagePayloadLength = 254,
		description = "An OpenDroneID message pack is a container for multiple encoded OpenDroneID messages (i.e. not in the format given for the above messages descriptions but after encoding into the compressed OpenDroneID byte format). Used e.g. when transmitting on Bluetooth 5.0 Long Range/Extended Advertising or on WiFi Neighbor Aware Networking."
)
public class OpenDroneIdMessagePack implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "System ID (0 for broadcast).")
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Component ID (0 for broadcast).")
	private short targetComponent;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, description = "This field must currently always be equal to 25 (bytes), since all encoded OpenDroneID messages are specificed to have this length.", units = "bytes")
	private short singleMessageSize;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 1, description = "Number of encoded messages in the pack (not the number of bytes). Allowed range is 1 - 10.")
	private short msgPackSize;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 5, typeSize = 1, streamLength = 250, description = "Concatenation of encoded OpenDroneID messages. Shall be filled with nulls in the unused portion of the field.")
	private short[] messages = new short[250];

	private final int messagePayloadLength = 254;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public OpenDroneIdMessagePack(short targetSystem, short targetComponent, short singleMessageSize, short msgPackSize, short[] messages) {
		this.targetSystem = targetSystem;
		this.targetComponent = targetComponent;
		this.singleMessageSize = singleMessageSize;
		this.msgPackSize = msgPackSize;
		this.messages = messages;
	}

	public OpenDroneIdMessagePack(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 254！");
		}
		messagePayload(messagePayload);
	}

	public OpenDroneIdMessagePack(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		targetSystem = byteArray.getUnsignedInt8(0);
		targetComponent = byteArray.getUnsignedInt8(1);
		singleMessageSize = byteArray.getUnsignedInt8(2);
		msgPackSize = byteArray.getUnsignedInt8(3);
		messages = byteArray.getUnsignedInt8Array(4,250);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(targetSystem,0);
		byteArray.putUnsignedInt8(targetComponent,1);
		byteArray.putUnsignedInt8(singleMessageSize,2);
		byteArray.putUnsignedInt8(msgPackSize,3);
		byteArray.putUnsignedInt8Array(messages,4);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final OpenDroneIdMessagePack setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final OpenDroneIdMessagePack setTargetComponent(short targetComponent) {
		this.targetComponent = targetComponent;
		return this;
	}

	public final short getTargetComponent() {
		return targetComponent;
	}

	public final OpenDroneIdMessagePack setSingleMessageSize(short singleMessageSize) {
		this.singleMessageSize = singleMessageSize;
		return this;
	}

	public final short getSingleMessageSize() {
		return singleMessageSize;
	}

	public final OpenDroneIdMessagePack setMsgPackSize(short msgPackSize) {
		this.msgPackSize = msgPackSize;
		return this;
	}

	public final short getMsgPackSize() {
		return msgPackSize;
	}

	public final OpenDroneIdMessagePack setMessages(short[] messages) {
		this.messages = messages;
		return this;
	}

	public final short[] getMessages() {
		return messages;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			OpenDroneIdMessagePack other = (OpenDroneIdMessagePack)o;
			if (!Objects.deepEquals(this.targetSystem, other.targetSystem)) {
				return false;
			} else if (!Objects.deepEquals(this.targetComponent, other.targetComponent)) {
				return false;
			} else if (!Objects.deepEquals(this.singleMessageSize, other.singleMessageSize)) {
				return false;
			} else if (!Objects.deepEquals(this.msgPackSize, other.msgPackSize)) {
				return false;
			} else {
				return Objects.deepEquals(this.messages, other.messages);
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
		result = 31 * result + Objects.hashCode(this.singleMessageSize);
		result = 31 * result + Objects.hashCode(this.msgPackSize);
		result = 31 * result + Objects.hashCode(this.messages);
		return result;
	}

	@Override
	public String toString() {
		return "OpenDroneIdMessagePack{" +
				"targetSystem=" + targetSystem +
				", targetComponent=" + targetComponent +
				", singleMessageSize=" + singleMessageSize +
				", msgPackSize=" + msgPackSize +
				", messages=" + Arrays.toString(messages) +
				'}';
	}
}
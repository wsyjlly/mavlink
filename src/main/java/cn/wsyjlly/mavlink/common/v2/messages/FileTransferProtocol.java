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
		id = 110,
		messagePayloadLength = 254,
		description = "File transfer message"
)
public class FileTransferProtocol implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "Network ID (0 for broadcast)")
	private short targetNetwork;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "System ID (0 for broadcast)")
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, description = "Component ID (0 for broadcast)")
	private short targetComponent;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 251, description = "Variable length payload. The length is defined by the remaining message length when subtracting the header and other fields. The entire content of this block is opaque unless you understand any the encoding message_type. The particular encoding used can be extension specific and might not always be documented as part of the mavlink specification.")
	private short[] payload = new short[251];

	private final int messagePayloadLength = 254;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public FileTransferProtocol(short targetNetwork, short targetSystem, short targetComponent, short[] payload) {
		this.targetNetwork = targetNetwork;
		this.targetSystem = targetSystem;
		this.targetComponent = targetComponent;
		this.payload = payload;
	}

	public FileTransferProtocol(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 254！");
		}
		messagePayload(messagePayload);
	}

	public FileTransferProtocol(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		targetNetwork = byteArray.getUnsignedInt8(0);
		targetSystem = byteArray.getUnsignedInt8(1);
		targetComponent = byteArray.getUnsignedInt8(2);
		payload = byteArray.getUnsignedInt8Array(3,251);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(targetNetwork,0);
		byteArray.putUnsignedInt8(targetSystem,1);
		byteArray.putUnsignedInt8(targetComponent,2);
		byteArray.putUnsignedInt8Array(payload,3);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final FileTransferProtocol setTargetNetwork(short targetNetwork) {
		this.targetNetwork = targetNetwork;
		return this;
	}

	public final short getTargetNetwork() {
		return targetNetwork;
	}

	public final FileTransferProtocol setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final FileTransferProtocol setTargetComponent(short targetComponent) {
		this.targetComponent = targetComponent;
		return this;
	}

	public final short getTargetComponent() {
		return targetComponent;
	}

	public final FileTransferProtocol setPayload(short[] payload) {
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
			FileTransferProtocol other = (FileTransferProtocol)o;
			if (!Objects.deepEquals(this.targetNetwork, other.targetNetwork)) {
				return false;
			} else if (!Objects.deepEquals(this.targetSystem, other.targetSystem)) {
				return false;
			} else if (!Objects.deepEquals(this.targetComponent, other.targetComponent)) {
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
		result = 31 * result + Objects.hashCode(this.payload);
		return result;
	}

	@Override
	public String toString() {
		return "FileTransferProtocol{" +
				"targetNetwork=" + targetNetwork +
				", targetSystem=" + targetSystem +
				", targetComponent=" + targetComponent +
				", payload=" + Arrays.toString(payload) +
				'}';
	}
}
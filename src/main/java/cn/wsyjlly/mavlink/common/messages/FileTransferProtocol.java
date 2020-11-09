package cn.wsyjlly.mavlink.common.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.09 - 03:37
 **********************************/

@MavlinkMessage(
		id = 110,
		messagePayloadLength = 254,
		description = "File transfer message"
)
public class FileTransferProtocol implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1)
	private short targetNetwork;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1)
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1)
	private short targetComponent;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 251)
	private short payload;

	private final int messagePayloadLength = 254;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public FileTransferProtocol(short targetNetwork, short targetSystem, short targetComponent, short payload) {
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
		this.targetNetwork = byteArray.getUnsignedInt8(0);
		this.targetSystem = byteArray.getUnsignedInt8(1);
		this.targetComponent = byteArray.getUnsignedInt8(2);
		this.payload = byteArray.getUnsignedInt8(3);
	}

	@Override
	public byte[] messagePayload() {
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

	public final FileTransferProtocol setPayload(short payload) {
		this.payload = payload;
		return this;
	}

	public final short getPayload() {
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
				", payload=" + payload +
				'}';
	}
}
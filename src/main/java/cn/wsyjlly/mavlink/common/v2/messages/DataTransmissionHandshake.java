package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.MavlinkDataStreamType;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 130,
		messagePayloadLength = 13,
		description = "Handshake message to initiate, control and stop image streaming when using the Image Transmission Protocol: https://mavlink.io/en/services/image_transmission.html."
)
public class DataTransmissionHandshake implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "Type of requested/acknowledged data.", enum0 = MavlinkDataStreamType.class)
	private short type;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 2, typeSize = 4, streamLength = 4, description = "total data size (set on ACK only).", units = "bytes")
	private long size;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 3, typeSize = 2, streamLength = 2, description = "Width of a matrix or image.")
	private int width;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 4, typeSize = 2, streamLength = 2, description = "Height of a matrix or image.")
	private int height;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 5, typeSize = 2, streamLength = 2, description = "Number of packets being sent (set on ACK only).")
	private int packets;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 6, typeSize = 1, streamLength = 1, description = "Payload size per packet (normally 253 byte, see DATA field size in message ENCAPSULATED_DATA) (set on ACK only).", units = "bytes")
	private short payload;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 7, typeSize = 1, streamLength = 1, description = "JPEG quality. Values: [1-100].", units = "%")
	private short jpgQuality;

	private final int messagePayloadLength = 13;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public DataTransmissionHandshake(short type, long size, int width, int height, int packets, short payload, short jpgQuality) {
		this.type = type;
		this.size = size;
		this.width = width;
		this.height = height;
		this.packets = packets;
		this.payload = payload;
		this.jpgQuality = jpgQuality;
	}

	public DataTransmissionHandshake(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 13！");
		}
		messagePayload(messagePayload);
	}

	public DataTransmissionHandshake(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		type = byteArray.getUnsignedInt8(0);
		size = byteArray.getUnsignedInt32(1);
		width = byteArray.getUnsignedInt16(5);
		height = byteArray.getUnsignedInt16(7);
		packets = byteArray.getUnsignedInt16(9);
		payload = byteArray.getUnsignedInt8(11);
		jpgQuality = byteArray.getUnsignedInt8(12);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(type,0);
		byteArray.putUnsignedInt32(size,1);
		byteArray.putUnsignedInt16(width,5);
		byteArray.putUnsignedInt16(height,7);
		byteArray.putUnsignedInt16(packets,9);
		byteArray.putUnsignedInt8(payload,11);
		byteArray.putUnsignedInt8(jpgQuality,12);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final DataTransmissionHandshake setType(short type) {
		this.type = type;
		return this;
	}

	public final short getType() {
		return type;
	}

	public final DataTransmissionHandshake setSize(long size) {
		this.size = size;
		return this;
	}

	public final long getSize() {
		return size;
	}

	public final DataTransmissionHandshake setWidth(int width) {
		this.width = width;
		return this;
	}

	public final int getWidth() {
		return width;
	}

	public final DataTransmissionHandshake setHeight(int height) {
		this.height = height;
		return this;
	}

	public final int getHeight() {
		return height;
	}

	public final DataTransmissionHandshake setPackets(int packets) {
		this.packets = packets;
		return this;
	}

	public final int getPackets() {
		return packets;
	}

	public final DataTransmissionHandshake setPayload(short payload) {
		this.payload = payload;
		return this;
	}

	public final short getPayload() {
		return payload;
	}

	public final DataTransmissionHandshake setJpgQuality(short jpgQuality) {
		this.jpgQuality = jpgQuality;
		return this;
	}

	public final short getJpgQuality() {
		return jpgQuality;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			DataTransmissionHandshake other = (DataTransmissionHandshake)o;
			if (!Objects.deepEquals(this.type, other.type)) {
				return false;
			} else if (!Objects.deepEquals(this.size, other.size)) {
				return false;
			} else if (!Objects.deepEquals(this.width, other.width)) {
				return false;
			} else if (!Objects.deepEquals(this.height, other.height)) {
				return false;
			} else if (!Objects.deepEquals(this.packets, other.packets)) {
				return false;
			} else if (!Objects.deepEquals(this.payload, other.payload)) {
				return false;
			} else {
				return Objects.deepEquals(this.jpgQuality, other.jpgQuality);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.type);
		result = 31 * result + Objects.hashCode(this.size);
		result = 31 * result + Objects.hashCode(this.width);
		result = 31 * result + Objects.hashCode(this.height);
		result = 31 * result + Objects.hashCode(this.packets);
		result = 31 * result + Objects.hashCode(this.payload);
		result = 31 * result + Objects.hashCode(this.jpgQuality);
		return result;
	}

	@Override
	public String toString() {
		return "DataTransmissionHandshake{" +
				"type=" + type +
				", size=" + size +
				", width=" + width +
				", height=" + height +
				", packets=" + packets +
				", payload=" + payload +
				", jpgQuality=" + jpgQuality +
				'}';
	}
}
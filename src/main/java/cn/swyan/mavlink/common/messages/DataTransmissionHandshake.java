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
		id = 130,
		messagePayloadLength = 13,
		description = "RTK GPS data. Gives information on the relative baseline calculation the GPS is reporting"
)
public class DataTransmissionHandshake implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1)
	private short type;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 2, typeSize = 4, streamLength = 4)
	private long size;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 3, typeSize = 2, streamLength = 2)
	private int width;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 4, typeSize = 2, streamLength = 2)
	private int height;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 5, typeSize = 2, streamLength = 2)
	private int packets;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 6, typeSize = 1, streamLength = 1)
	private short payload;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 7, typeSize = 1, streamLength = 1)
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
		this.type = byteArray.getUnsignedInt8(0);
		this.size = byteArray.getUnsignedInt32(1);
		this.width = byteArray.getUnsignedInt16(5);
		this.height = byteArray.getUnsignedInt16(7);
		this.packets = byteArray.getUnsignedInt16(9);
		this.payload = byteArray.getUnsignedInt8(11);
		this.jpgQuality = byteArray.getUnsignedInt8(12);
	}

	@Override
	public byte[] messagePayload() {
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
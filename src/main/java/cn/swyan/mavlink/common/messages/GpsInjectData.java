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
		id = 123,
		messagePayloadLength = 113,
		description = "data for injecting into the onboard GPS (used for DGPS)"
)
public class GpsInjectData implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1)
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1)
	private short targetComponent;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1)
	private short len;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 110)
	private short data;

	private final int messagePayloadLength = 113;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public GpsInjectData(short targetSystem, short targetComponent, short len, short data) {
		this.targetSystem = targetSystem;
		this.targetComponent = targetComponent;
		this.len = len;
		this.data = data;
	}

	public GpsInjectData(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 113！");
		}
		messagePayload(messagePayload);
	}

	public GpsInjectData(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.targetSystem = byteArray.getUnsignedInt8(0);
		this.targetComponent = byteArray.getUnsignedInt8(1);
		this.len = byteArray.getUnsignedInt8(2);
		this.data = byteArray.getUnsignedInt8(3);
	}

	@Override
	public byte[] messagePayload() {
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final GpsInjectData setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final GpsInjectData setTargetComponent(short targetComponent) {
		this.targetComponent = targetComponent;
		return this;
	}

	public final short getTargetComponent() {
		return targetComponent;
	}

	public final GpsInjectData setLen(short len) {
		this.len = len;
		return this;
	}

	public final short getLen() {
		return len;
	}

	public final GpsInjectData setData(short data) {
		this.data = data;
		return this;
	}

	public final short getData() {
		return data;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			GpsInjectData other = (GpsInjectData)o;
			if (!Objects.deepEquals(this.targetSystem, other.targetSystem)) {
				return false;
			} else if (!Objects.deepEquals(this.targetComponent, other.targetComponent)) {
				return false;
			} else if (!Objects.deepEquals(this.len, other.len)) {
				return false;
			} else {
				return Objects.deepEquals(this.data, other.data);
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
		result = 31 * result + Objects.hashCode(this.len);
		result = 31 * result + Objects.hashCode(this.data);
		return result;
	}

	@Override
	public String toString() {
		return "GpsInjectData{" +
				"targetSystem=" + targetSystem +
				", targetComponent=" + targetComponent +
				", len=" + len +
				", data=" + data +
				'}';
	}
}
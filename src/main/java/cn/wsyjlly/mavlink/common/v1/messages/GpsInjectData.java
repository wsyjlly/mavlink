package cn.wsyjlly.mavlink.common.v1.messages;

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
 * Date 2020.11.26 - 02:45
 **********************************/

@MavlinkMessage(
		id = 123,
		messagePayloadLength = 113,
		description = "data for injecting into the onboard GPS (used for DGPS)"
)
public class GpsInjectData implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "System ID")
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Component ID")
	private short targetComponent;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, description = "data length")
	private short len;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 110, description = "raw data (110 is enough for 12 satellites of RTCMv2)")
	private short[] data = new short[110];

	private final int messagePayloadLength = 113;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public GpsInjectData(short targetSystem, short targetComponent, short len, short[] data) {
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
		targetSystem = byteArray.getUnsignedInt8(0);
		targetComponent = byteArray.getUnsignedInt8(1);
		len = byteArray.getUnsignedInt8(2);
		data = byteArray.getUnsignedInt8Array(3,110);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(targetSystem,0);
		byteArray.putUnsignedInt8(targetComponent,1);
		byteArray.putUnsignedInt8(len,2);
		byteArray.putUnsignedInt8Array(data,3);
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

	public final GpsInjectData setData(short[] data) {
		this.data = data;
		return this;
	}

	public final short[] getData() {
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
				", data=" + Arrays.toString(data) +
				'}';
	}
}
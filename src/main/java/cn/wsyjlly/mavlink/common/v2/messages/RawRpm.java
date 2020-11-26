package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 339,
		messagePayloadLength = 5,
		description = "RPM sensor data message."
)
public class RawRpm implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "Index of this RPM sensor (0-indexed)")
	private short index;

	@MavlinkMessageParam(mavlinkType = "float", position = 2, typeSize = 4, streamLength = 4, description = "Indicated rate", units = "rpm")
	private float frequency;

	private final int messagePayloadLength = 5;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public RawRpm(short index, float frequency) {
		this.index = index;
		this.frequency = frequency;
	}

	public RawRpm(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 5！");
		}
		messagePayload(messagePayload);
	}

	public RawRpm(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		index = byteArray.getUnsignedInt8(0);
		frequency = byteArray.getFloat(1);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(index,0);
		byteArray.putFloat(frequency,1);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final RawRpm setIndex(short index) {
		this.index = index;
		return this;
	}

	public final short getIndex() {
		return index;
	}

	public final RawRpm setFrequency(float frequency) {
		this.frequency = frequency;
		return this;
	}

	public final float getFrequency() {
		return frequency;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			RawRpm other = (RawRpm)o;
			if (!Objects.deepEquals(this.index, other.index)) {
				return false;
			} else {
				return Objects.deepEquals(this.frequency, other.frequency);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.index);
		result = 31 * result + Objects.hashCode(this.frequency);
		return result;
	}

	@Override
	public String toString() {
		return "RawRpm{" +
				"index=" + index +
				", frequency=" + frequency +
				'}';
	}
}
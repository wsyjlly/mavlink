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
		id = 254,
		messagePayloadLength = 9,
		description = "Send a debug value. The index is used to discriminate between values. These values show up in the plot of QGroundControl as DEBUG N."
)
public class Debug implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4)
	private long timeBootMs;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1)
	private short ind;

	@MavlinkMessageParam(mavlinkType = "float", position = 3, typeSize = 4, streamLength = 4)
	private float value;

	private final int messagePayloadLength = 9;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public Debug(long timeBootMs, short ind, float value) {
		this.timeBootMs = timeBootMs;
		this.ind = ind;
		this.value = value;
	}

	public Debug(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 9！");
		}
		messagePayload(messagePayload);
	}

	public Debug(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.timeBootMs = byteArray.getUnsignedInt32(0);
		this.ind = byteArray.getUnsignedInt8(4);
		this.value = byteArray.getFloat(5);
	}

	@Override
	public byte[] messagePayload() {
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final Debug setTimeBootMs(long timeBootMs) {
		this.timeBootMs = timeBootMs;
		return this;
	}

	public final long getTimeBootMs() {
		return timeBootMs;
	}

	public final Debug setInd(short ind) {
		this.ind = ind;
		return this;
	}

	public final short getInd() {
		return ind;
	}

	public final Debug setValue(float value) {
		this.value = value;
		return this;
	}

	public final float getValue() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			Debug other = (Debug)o;
			if (!Objects.deepEquals(this.timeBootMs, other.timeBootMs)) {
				return false;
			} else if (!Objects.deepEquals(this.ind, other.ind)) {
				return false;
			} else {
				return Objects.deepEquals(this.value, other.value);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeBootMs);
		result = 31 * result + Objects.hashCode(this.ind);
		result = 31 * result + Objects.hashCode(this.value);
		return result;
	}

	@Override
	public String toString() {
		return "Debug{" +
				"timeBootMs=" + timeBootMs +
				", ind=" + ind +
				", value=" + value +
				'}';
	}
}
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
		id = 29,
		messagePayloadLength = 14,
		description = "The pressure readings for the typical setup of one absolute and differential pressure sensor. The units are as specified in each field."
)
public class ScaledPressure implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4)
	private long timeBootMs;

	@MavlinkMessageParam(mavlinkType = "float", position = 2, typeSize = 4, streamLength = 4)
	private float pressAbs;

	@MavlinkMessageParam(mavlinkType = "float", position = 3, typeSize = 4, streamLength = 4)
	private float pressDiff;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 4, typeSize = 2, streamLength = 2)
	private short temperature;

	private final int messagePayloadLength = 14;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public ScaledPressure(long timeBootMs, float pressAbs, float pressDiff, short temperature) {
		this.timeBootMs = timeBootMs;
		this.pressAbs = pressAbs;
		this.pressDiff = pressDiff;
		this.temperature = temperature;
	}

	public ScaledPressure(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 14！");
		}
		messagePayload(messagePayload);
	}

	public ScaledPressure(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.timeBootMs = byteArray.getUnsignedInt32(0);
		this.pressAbs = byteArray.getFloat(4);
		this.pressDiff = byteArray.getFloat(8);
		this.temperature = byteArray.getInt16(12);
	}

	@Override
	public byte[] messagePayload() {
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final ScaledPressure setTimeBootMs(long timeBootMs) {
		this.timeBootMs = timeBootMs;
		return this;
	}

	public final long getTimeBootMs() {
		return timeBootMs;
	}

	public final ScaledPressure setPressAbs(float pressAbs) {
		this.pressAbs = pressAbs;
		return this;
	}

	public final float getPressAbs() {
		return pressAbs;
	}

	public final ScaledPressure setPressDiff(float pressDiff) {
		this.pressDiff = pressDiff;
		return this;
	}

	public final float getPressDiff() {
		return pressDiff;
	}

	public final ScaledPressure setTemperature(short temperature) {
		this.temperature = temperature;
		return this;
	}

	public final short getTemperature() {
		return temperature;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			ScaledPressure other = (ScaledPressure)o;
			if (!Objects.deepEquals(this.timeBootMs, other.timeBootMs)) {
				return false;
			} else if (!Objects.deepEquals(this.pressAbs, other.pressAbs)) {
				return false;
			} else if (!Objects.deepEquals(this.pressDiff, other.pressDiff)) {
				return false;
			} else {
				return Objects.deepEquals(this.temperature, other.temperature);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeBootMs);
		result = 31 * result + Objects.hashCode(this.pressAbs);
		result = 31 * result + Objects.hashCode(this.pressDiff);
		result = 31 * result + Objects.hashCode(this.temperature);
		return result;
	}

	@Override
	public String toString() {
		return "ScaledPressure{" +
				"timeBootMs=" + timeBootMs +
				", pressAbs=" + pressAbs +
				", pressDiff=" + pressDiff +
				", temperature=" + temperature +
				'}';
	}
}
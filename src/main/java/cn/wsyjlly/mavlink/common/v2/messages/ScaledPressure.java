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
		id = 29,
		messagePayloadLength = 16,
		description = "The pressure readings for the typical setup of one absolute and differential pressure sensor. The units are as specified in each field."
)
public class ScaledPressure implements Message {
	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 1, typeSize = 4, streamLength = 4, description = "Timestamp (time since system boot).", units = "ms")
	private long timeBootMs;

	@MavlinkMessageParam(mavlinkType = "float", position = 2, typeSize = 4, streamLength = 4, description = "Absolute pressure", units = "hPa")
	private float pressAbs;

	@MavlinkMessageParam(mavlinkType = "float", position = 3, typeSize = 4, streamLength = 4, description = "Differential pressure 1", units = "hPa")
	private float pressDiff;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 4, typeSize = 2, streamLength = 2, description = "Absolute pressure temperature", units = "cdegC")
	private short temperature;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 5, typeSize = 2, streamLength = 2, description = "Differential pressure temperature (0, if not available). Report values of 0 (or 1) as 1 cdegC.", units = "cdegC")
	private short temperaturePressDiff;

	private final int messagePayloadLength = 16;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public ScaledPressure(long timeBootMs, float pressAbs, float pressDiff, short temperature, short temperaturePressDiff) {
		this.timeBootMs = timeBootMs;
		this.pressAbs = pressAbs;
		this.pressDiff = pressDiff;
		this.temperature = temperature;
		this.temperaturePressDiff = temperaturePressDiff;
	}

	public ScaledPressure(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 16！");
		}
		messagePayload(messagePayload);
	}

	public ScaledPressure(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeBootMs = byteArray.getUnsignedInt32(0);
		pressAbs = byteArray.getFloat(4);
		pressDiff = byteArray.getFloat(8);
		temperature = byteArray.getInt16(12);
		temperaturePressDiff = byteArray.getInt16(14);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt32(timeBootMs,0);
		byteArray.putFloat(pressAbs,4);
		byteArray.putFloat(pressDiff,8);
		byteArray.putInt16(temperature,12);
		byteArray.putInt16(temperaturePressDiff,14);
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

	public final ScaledPressure setTemperaturePressDiff(short temperaturePressDiff) {
		this.temperaturePressDiff = temperaturePressDiff;
		return this;
	}

	public final short getTemperaturePressDiff() {
		return temperaturePressDiff;
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
			} else if (!Objects.deepEquals(this.temperature, other.temperature)) {
				return false;
			} else {
				return Objects.deepEquals(this.temperaturePressDiff, other.temperaturePressDiff);
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
		result = 31 * result + Objects.hashCode(this.temperaturePressDiff);
		return result;
	}

	@Override
	public String toString() {
		return "ScaledPressure{" +
				"timeBootMs=" + timeBootMs +
				", pressAbs=" + pressAbs +
				", pressDiff=" + pressDiff +
				", temperature=" + temperature +
				", temperaturePressDiff=" + temperaturePressDiff +
				'}';
	}
}
package cn.wsyjlly.mavlink.common.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
import java.math.BigInteger;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.09 - 03:37
 **********************************/

@MavlinkMessage(
		id = 28,
		messagePayloadLength = 16,
		description = "The RAW pressure readings for the typical setup of one absolute pressure and one differential pressure sensor. The sensor values should be the raw, UNSCALED ADC values."
)
public class RawPressure implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8)
	private BigInteger timeUsec;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 2, typeSize = 2, streamLength = 2)
	private short pressAbs;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 3, typeSize = 2, streamLength = 2)
	private short pressDiff1;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 4, typeSize = 2, streamLength = 2)
	private short pressDiff2;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 5, typeSize = 2, streamLength = 2)
	private short temperature;

	private final int messagePayloadLength = 16;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public RawPressure(BigInteger timeUsec, short pressAbs, short pressDiff1, short pressDiff2, short temperature) {
		this.timeUsec = timeUsec;
		this.pressAbs = pressAbs;
		this.pressDiff1 = pressDiff1;
		this.pressDiff2 = pressDiff2;
		this.temperature = temperature;
	}

	public RawPressure(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 16！");
		}
		messagePayload(messagePayload);
	}

	public RawPressure(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.timeUsec = byteArray.getUnsignedInt64(0);
		this.pressAbs = byteArray.getInt16(8);
		this.pressDiff1 = byteArray.getInt16(10);
		this.pressDiff2 = byteArray.getInt16(12);
		this.temperature = byteArray.getInt16(14);
	}

	@Override
	public byte[] messagePayload() {
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final RawPressure setTimeUsec(BigInteger timeUsec) {
		this.timeUsec = timeUsec;
		return this;
	}

	public final BigInteger getTimeUsec() {
		return timeUsec;
	}

	public final RawPressure setPressAbs(short pressAbs) {
		this.pressAbs = pressAbs;
		return this;
	}

	public final short getPressAbs() {
		return pressAbs;
	}

	public final RawPressure setPressDiff1(short pressDiff1) {
		this.pressDiff1 = pressDiff1;
		return this;
	}

	public final short getPressDiff1() {
		return pressDiff1;
	}

	public final RawPressure setPressDiff2(short pressDiff2) {
		this.pressDiff2 = pressDiff2;
		return this;
	}

	public final short getPressDiff2() {
		return pressDiff2;
	}

	public final RawPressure setTemperature(short temperature) {
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
			RawPressure other = (RawPressure)o;
			if (!Objects.deepEquals(this.timeUsec, other.timeUsec)) {
				return false;
			} else if (!Objects.deepEquals(this.pressAbs, other.pressAbs)) {
				return false;
			} else if (!Objects.deepEquals(this.pressDiff1, other.pressDiff1)) {
				return false;
			} else if (!Objects.deepEquals(this.pressDiff2, other.pressDiff2)) {
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
		result = 31 * result + Objects.hashCode(this.timeUsec);
		result = 31 * result + Objects.hashCode(this.pressAbs);
		result = 31 * result + Objects.hashCode(this.pressDiff1);
		result = 31 * result + Objects.hashCode(this.pressDiff2);
		result = 31 * result + Objects.hashCode(this.temperature);
		return result;
	}

	@Override
	public String toString() {
		return "RawPressure{" +
				"timeUsec=" + timeUsec +
				", pressAbs=" + pressAbs +
				", pressDiff1=" + pressDiff1 +
				", pressDiff2=" + pressDiff2 +
				", temperature=" + temperature +
				'}';
	}
}
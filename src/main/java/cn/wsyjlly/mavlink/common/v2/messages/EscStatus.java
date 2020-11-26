package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
import java.util.Arrays;
import java.math.BigInteger;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 291,
		messagePayloadLength = 57,
		description = "ESC information for higher rate streaming. Recommended streaming rate is ~10 Hz. Information that changes more slowly is sent in ESC_INFO. It should typically only be streamed on high-bandwidth links (i.e. to a companion computer)."
)
public class EscStatus implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "Index of the first ESC in this message. minValue = 0, maxValue = 60, increment = 4.")
	private short index;

	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 2, typeSize = 8, streamLength = 8, description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude the number.", units = "us")
	private BigInteger timeUsec;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 3, typeSize = 4, streamLength = 16, description = "Reported motor RPM from each ESC (negative for reverse rotation).", units = "rpm")
	private int[] rpm = new int[4];

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 16, description = "Voltage measured from each ESC.", units = "V")
	private float[] voltage = new float[4];

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 16, description = "Current measured from each ESC.", units = "A")
	private float[] current = new float[4];

	private final int messagePayloadLength = 57;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public EscStatus(short index, BigInteger timeUsec, int[] rpm, float[] voltage, float[] current) {
		this.index = index;
		this.timeUsec = timeUsec;
		this.rpm = rpm;
		this.voltage = voltage;
		this.current = current;
	}

	public EscStatus(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 57！");
		}
		messagePayload(messagePayload);
	}

	public EscStatus(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		index = byteArray.getUnsignedInt8(0);
		timeUsec = byteArray.getUnsignedInt64(1);
		rpm = byteArray.getInt32Array(9,4);
		voltage = byteArray.getFloatArray(25,4);
		current = byteArray.getFloatArray(41,4);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(index,0);
		byteArray.putUnsignedInt64(timeUsec,1);
		byteArray.putInt32Array(rpm,9);
		byteArray.putFloatArray(voltage,25);
		byteArray.putFloatArray(current,41);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final EscStatus setIndex(short index) {
		this.index = index;
		return this;
	}

	public final short getIndex() {
		return index;
	}

	public final EscStatus setTimeUsec(BigInteger timeUsec) {
		this.timeUsec = timeUsec;
		return this;
	}

	public final BigInteger getTimeUsec() {
		return timeUsec;
	}

	public final EscStatus setRpm(int[] rpm) {
		this.rpm = rpm;
		return this;
	}

	public final int[] getRpm() {
		return rpm;
	}

	public final EscStatus setVoltage(float[] voltage) {
		this.voltage = voltage;
		return this;
	}

	public final float[] getVoltage() {
		return voltage;
	}

	public final EscStatus setCurrent(float[] current) {
		this.current = current;
		return this;
	}

	public final float[] getCurrent() {
		return current;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			EscStatus other = (EscStatus)o;
			if (!Objects.deepEquals(this.index, other.index)) {
				return false;
			} else if (!Objects.deepEquals(this.timeUsec, other.timeUsec)) {
				return false;
			} else if (!Objects.deepEquals(this.rpm, other.rpm)) {
				return false;
			} else if (!Objects.deepEquals(this.voltage, other.voltage)) {
				return false;
			} else {
				return Objects.deepEquals(this.current, other.current);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.index);
		result = 31 * result + Objects.hashCode(this.timeUsec);
		result = 31 * result + Objects.hashCode(this.rpm);
		result = 31 * result + Objects.hashCode(this.voltage);
		result = 31 * result + Objects.hashCode(this.current);
		return result;
	}

	@Override
	public String toString() {
		return "EscStatus{" +
				"index=" + index +
				", timeUsec=" + timeUsec +
				", rpm=" + Arrays.toString(rpm) +
				", voltage=" + Arrays.toString(voltage) +
				", current=" + Arrays.toString(current) +
				'}';
	}
}
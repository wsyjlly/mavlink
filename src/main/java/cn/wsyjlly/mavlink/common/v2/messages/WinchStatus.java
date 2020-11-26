package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.MavWinchStatusFlag;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
import java.math.BigInteger;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 9005,
		messagePayloadLength = 34,
		description = "Winch status."
)
public class WinchStatus implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8, description = "Timestamp (synced to UNIX time or since system boot).", units = "us")
	private BigInteger timeUsec;

	@MavlinkMessageParam(mavlinkType = "float", position = 2, typeSize = 4, streamLength = 4, description = "Length of line released. NaN if unknown", units = "m")
	private float lineLength;

	@MavlinkMessageParam(mavlinkType = "float", position = 3, typeSize = 4, streamLength = 4, description = "Speed line is being released or retracted. Positive values if being released, negative values if being retracted, NaN if unknown", units = "m/s")
	private float speed;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4, description = "Tension on the line. NaN if unknown", units = "kg")
	private float tension;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4, description = "Voltage of the battery supplying the winch. NaN if unknown", units = "V")
	private float voltage;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4, description = "Current draw from the winch. NaN if unknown", units = "A")
	private float current;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 7, typeSize = 2, streamLength = 2, description = "Temperature of the motor. INT16_MAX if unknown", units = "degC")
	private short temperature;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 8, typeSize = 4, streamLength = 4, description = "Status flags", enum0 = MavWinchStatusFlag.class)
	private long status;

	private final int messagePayloadLength = 34;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public WinchStatus(BigInteger timeUsec, float lineLength, float speed, float tension, float voltage, float current, short temperature, long status) {
		this.timeUsec = timeUsec;
		this.lineLength = lineLength;
		this.speed = speed;
		this.tension = tension;
		this.voltage = voltage;
		this.current = current;
		this.temperature = temperature;
		this.status = status;
	}

	public WinchStatus(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 34！");
		}
		messagePayload(messagePayload);
	}

	public WinchStatus(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeUsec = byteArray.getUnsignedInt64(0);
		lineLength = byteArray.getFloat(8);
		speed = byteArray.getFloat(12);
		tension = byteArray.getFloat(16);
		voltage = byteArray.getFloat(20);
		current = byteArray.getFloat(24);
		temperature = byteArray.getInt16(28);
		status = byteArray.getUnsignedInt32(30);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt64(timeUsec,0);
		byteArray.putFloat(lineLength,8);
		byteArray.putFloat(speed,12);
		byteArray.putFloat(tension,16);
		byteArray.putFloat(voltage,20);
		byteArray.putFloat(current,24);
		byteArray.putInt16(temperature,28);
		byteArray.putUnsignedInt32(status,30);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final WinchStatus setTimeUsec(BigInteger timeUsec) {
		this.timeUsec = timeUsec;
		return this;
	}

	public final BigInteger getTimeUsec() {
		return timeUsec;
	}

	public final WinchStatus setLineLength(float lineLength) {
		this.lineLength = lineLength;
		return this;
	}

	public final float getLineLength() {
		return lineLength;
	}

	public final WinchStatus setSpeed(float speed) {
		this.speed = speed;
		return this;
	}

	public final float getSpeed() {
		return speed;
	}

	public final WinchStatus setTension(float tension) {
		this.tension = tension;
		return this;
	}

	public final float getTension() {
		return tension;
	}

	public final WinchStatus setVoltage(float voltage) {
		this.voltage = voltage;
		return this;
	}

	public final float getVoltage() {
		return voltage;
	}

	public final WinchStatus setCurrent(float current) {
		this.current = current;
		return this;
	}

	public final float getCurrent() {
		return current;
	}

	public final WinchStatus setTemperature(short temperature) {
		this.temperature = temperature;
		return this;
	}

	public final short getTemperature() {
		return temperature;
	}

	public final WinchStatus setStatus(long status) {
		this.status = status;
		return this;
	}

	public final long getStatus() {
		return status;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			WinchStatus other = (WinchStatus)o;
			if (!Objects.deepEquals(this.timeUsec, other.timeUsec)) {
				return false;
			} else if (!Objects.deepEquals(this.lineLength, other.lineLength)) {
				return false;
			} else if (!Objects.deepEquals(this.speed, other.speed)) {
				return false;
			} else if (!Objects.deepEquals(this.tension, other.tension)) {
				return false;
			} else if (!Objects.deepEquals(this.voltage, other.voltage)) {
				return false;
			} else if (!Objects.deepEquals(this.current, other.current)) {
				return false;
			} else if (!Objects.deepEquals(this.temperature, other.temperature)) {
				return false;
			} else {
				return Objects.deepEquals(this.status, other.status);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeUsec);
		result = 31 * result + Objects.hashCode(this.lineLength);
		result = 31 * result + Objects.hashCode(this.speed);
		result = 31 * result + Objects.hashCode(this.tension);
		result = 31 * result + Objects.hashCode(this.voltage);
		result = 31 * result + Objects.hashCode(this.current);
		result = 31 * result + Objects.hashCode(this.temperature);
		result = 31 * result + Objects.hashCode(this.status);
		return result;
	}

	@Override
	public String toString() {
		return "WinchStatus{" +
				"timeUsec=" + timeUsec +
				", lineLength=" + lineLength +
				", speed=" + speed +
				", tension=" + tension +
				", voltage=" + voltage +
				", current=" + current +
				", temperature=" + temperature +
				", status=" + status +
				'}';
	}
}
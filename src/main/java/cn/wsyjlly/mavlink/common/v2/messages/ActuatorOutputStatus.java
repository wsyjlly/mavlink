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
		id = 375,
		messagePayloadLength = 140,
		description = "The raw values of the actuator outputs (e.g. on Pixhawk, from MAIN, AUX ports). This message supersedes SERVO_OUTPUT_RAW."
)
public class ActuatorOutputStatus implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8, description = "Timestamp (since system boot).", units = "us")
	private BigInteger timeUsec;

	@MavlinkMessageParam(mavlinkType = "uint32_t", position = 2, typeSize = 4, streamLength = 4, description = "Active outputs")
	private long active;

	@MavlinkMessageParam(mavlinkType = "float", position = 3, typeSize = 4, streamLength = 128, description = "Servo / motor output array values. Zero values indicate unused channels.")
	private float[] actuator = new float[32];

	private final int messagePayloadLength = 140;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public ActuatorOutputStatus(BigInteger timeUsec, long active, float[] actuator) {
		this.timeUsec = timeUsec;
		this.active = active;
		this.actuator = actuator;
	}

	public ActuatorOutputStatus(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 140！");
		}
		messagePayload(messagePayload);
	}

	public ActuatorOutputStatus(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeUsec = byteArray.getUnsignedInt64(0);
		active = byteArray.getUnsignedInt32(8);
		actuator = byteArray.getFloatArray(12,32);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt64(timeUsec,0);
		byteArray.putUnsignedInt32(active,8);
		byteArray.putFloatArray(actuator,12);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final ActuatorOutputStatus setTimeUsec(BigInteger timeUsec) {
		this.timeUsec = timeUsec;
		return this;
	}

	public final BigInteger getTimeUsec() {
		return timeUsec;
	}

	public final ActuatorOutputStatus setActive(long active) {
		this.active = active;
		return this;
	}

	public final long getActive() {
		return active;
	}

	public final ActuatorOutputStatus setActuator(float[] actuator) {
		this.actuator = actuator;
		return this;
	}

	public final float[] getActuator() {
		return actuator;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			ActuatorOutputStatus other = (ActuatorOutputStatus)o;
			if (!Objects.deepEquals(this.timeUsec, other.timeUsec)) {
				return false;
			} else if (!Objects.deepEquals(this.active, other.active)) {
				return false;
			} else {
				return Objects.deepEquals(this.actuator, other.actuator);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeUsec);
		result = 31 * result + Objects.hashCode(this.active);
		result = 31 * result + Objects.hashCode(this.actuator);
		return result;
	}

	@Override
	public String toString() {
		return "ActuatorOutputStatus{" +
				"timeUsec=" + timeUsec +
				", active=" + active +
				", actuator=" + Arrays.toString(actuator) +
				'}';
	}
}
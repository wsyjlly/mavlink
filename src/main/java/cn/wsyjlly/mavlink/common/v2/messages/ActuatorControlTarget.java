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
		id = 140,
		messagePayloadLength = 41,
		description = "Set the vehicle attitude and body angular rates."
)
public class ActuatorControlTarget implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8, description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.", units = "us")
	private BigInteger timeUsec;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Actuator group. The '_mlx' indicates this is a multi-instance message and a MAVLink parser should use this field to difference between instances.")
	private short groupMlx;

	@MavlinkMessageParam(mavlinkType = "float", position = 3, typeSize = 4, streamLength = 32, description = "Actuator controls. Normed to -1..+1 where 0 is neutral position. Throttle for single rotation direction motors is 0..1, negative range for reverse direction. Standard mapping for attitude controls (group 0): (index 0-7): roll, pitch, yaw, throttle, flaps, spoilers, airbrakes, landing gear. Load a pass-through mixer to repurpose them as generic outputs.")
	private float[] controls = new float[8];

	private final int messagePayloadLength = 41;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public ActuatorControlTarget(BigInteger timeUsec, short groupMlx, float[] controls) {
		this.timeUsec = timeUsec;
		this.groupMlx = groupMlx;
		this.controls = controls;
	}

	public ActuatorControlTarget(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 41！");
		}
		messagePayload(messagePayload);
	}

	public ActuatorControlTarget(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeUsec = byteArray.getUnsignedInt64(0);
		groupMlx = byteArray.getUnsignedInt8(8);
		controls = byteArray.getFloatArray(9,8);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt64(timeUsec,0);
		byteArray.putUnsignedInt8(groupMlx,8);
		byteArray.putFloatArray(controls,9);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final ActuatorControlTarget setTimeUsec(BigInteger timeUsec) {
		this.timeUsec = timeUsec;
		return this;
	}

	public final BigInteger getTimeUsec() {
		return timeUsec;
	}

	public final ActuatorControlTarget setGroupMlx(short groupMlx) {
		this.groupMlx = groupMlx;
		return this;
	}

	public final short getGroupMlx() {
		return groupMlx;
	}

	public final ActuatorControlTarget setControls(float[] controls) {
		this.controls = controls;
		return this;
	}

	public final float[] getControls() {
		return controls;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			ActuatorControlTarget other = (ActuatorControlTarget)o;
			if (!Objects.deepEquals(this.timeUsec, other.timeUsec)) {
				return false;
			} else if (!Objects.deepEquals(this.groupMlx, other.groupMlx)) {
				return false;
			} else {
				return Objects.deepEquals(this.controls, other.controls);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeUsec);
		result = 31 * result + Objects.hashCode(this.groupMlx);
		result = 31 * result + Objects.hashCode(this.controls);
		return result;
	}

	@Override
	public String toString() {
		return "ActuatorControlTarget{" +
				"timeUsec=" + timeUsec +
				", groupMlx=" + groupMlx +
				", controls=" + Arrays.toString(controls) +
				'}';
	}
}
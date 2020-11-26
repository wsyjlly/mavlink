package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.MavModeFlag;
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
		id = 93,
		messagePayloadLength = 81,
		description = "Sent from autopilot to simulation. Hardware in the loop control outputs (replacement for HIL_CONTROLS)"
)
public class HilActuatorControls implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8, description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.", units = "us")
	private BigInteger timeUsec;

	@MavlinkMessageParam(mavlinkType = "float", position = 2, typeSize = 4, streamLength = 64, description = "Control outputs -1 .. 1. Channel assignment depends on the simulated hardware.")
	private float[] controls = new float[16];

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, description = "System mode. Includes arming state.", enum0 = MavModeFlag.class)
	private short mode;

	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 4, typeSize = 8, streamLength = 8, description = "Flags as bitfield, 1: indicate simulation using lockstep.")
	private BigInteger flags;

	private final int messagePayloadLength = 81;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public HilActuatorControls(BigInteger timeUsec, float[] controls, short mode, BigInteger flags) {
		this.timeUsec = timeUsec;
		this.controls = controls;
		this.mode = mode;
		this.flags = flags;
	}

	public HilActuatorControls(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 81！");
		}
		messagePayload(messagePayload);
	}

	public HilActuatorControls(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		timeUsec = byteArray.getUnsignedInt64(0);
		controls = byteArray.getFloatArray(8,16);
		mode = byteArray.getUnsignedInt8(72);
		flags = byteArray.getUnsignedInt64(73);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt64(timeUsec,0);
		byteArray.putFloatArray(controls,8);
		byteArray.putUnsignedInt8(mode,72);
		byteArray.putUnsignedInt64(flags,73);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final HilActuatorControls setTimeUsec(BigInteger timeUsec) {
		this.timeUsec = timeUsec;
		return this;
	}

	public final BigInteger getTimeUsec() {
		return timeUsec;
	}

	public final HilActuatorControls setControls(float[] controls) {
		this.controls = controls;
		return this;
	}

	public final float[] getControls() {
		return controls;
	}

	public final HilActuatorControls setMode(short mode) {
		this.mode = mode;
		return this;
	}

	public final short getMode() {
		return mode;
	}

	public final HilActuatorControls setFlags(BigInteger flags) {
		this.flags = flags;
		return this;
	}

	public final BigInteger getFlags() {
		return flags;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			HilActuatorControls other = (HilActuatorControls)o;
			if (!Objects.deepEquals(this.timeUsec, other.timeUsec)) {
				return false;
			} else if (!Objects.deepEquals(this.controls, other.controls)) {
				return false;
			} else if (!Objects.deepEquals(this.mode, other.mode)) {
				return false;
			} else {
				return Objects.deepEquals(this.flags, other.flags);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeUsec);
		result = 31 * result + Objects.hashCode(this.controls);
		result = 31 * result + Objects.hashCode(this.mode);
		result = 31 * result + Objects.hashCode(this.flags);
		return result;
	}

	@Override
	public String toString() {
		return "HilActuatorControls{" +
				"timeUsec=" + timeUsec +
				", controls=" + Arrays.toString(controls) +
				", mode=" + mode +
				", flags=" + flags +
				'}';
	}
}
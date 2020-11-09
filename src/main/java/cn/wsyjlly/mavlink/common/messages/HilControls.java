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
		id = 91,
		messagePayloadLength = 42,
		description = "Sent from autopilot to simulation. Hardware in the loop control outputs"
)
public class HilControls implements Message {
	@MavlinkMessageParam(mavlinkType = "uint64_t", position = 1, typeSize = 8, streamLength = 8)
	private BigInteger timeUsec;

	@MavlinkMessageParam(mavlinkType = "float", position = 2, typeSize = 4, streamLength = 4)
	private float rollAilerons;

	@MavlinkMessageParam(mavlinkType = "float", position = 3, typeSize = 4, streamLength = 4)
	private float pitchElevator;

	@MavlinkMessageParam(mavlinkType = "float", position = 4, typeSize = 4, streamLength = 4)
	private float yawRudder;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4)
	private float throttle;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4)
	private float aux1;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4)
	private float aux2;

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 4)
	private float aux3;

	@MavlinkMessageParam(mavlinkType = "float", position = 9, typeSize = 4, streamLength = 4)
	private float aux4;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 10, typeSize = 1, streamLength = 1)
	private short mode;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 11, typeSize = 1, streamLength = 1)
	private short navMode;

	private final int messagePayloadLength = 42;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public HilControls(BigInteger timeUsec, float rollAilerons, float pitchElevator, float yawRudder, float throttle, float aux1, float aux2, float aux3, float aux4, short mode, short navMode) {
		this.timeUsec = timeUsec;
		this.rollAilerons = rollAilerons;
		this.pitchElevator = pitchElevator;
		this.yawRudder = yawRudder;
		this.throttle = throttle;
		this.aux1 = aux1;
		this.aux2 = aux2;
		this.aux3 = aux3;
		this.aux4 = aux4;
		this.mode = mode;
		this.navMode = navMode;
	}

	public HilControls(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 42！");
		}
		messagePayload(messagePayload);
	}

	public HilControls(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.timeUsec = byteArray.getUnsignedInt64(0);
		this.rollAilerons = byteArray.getFloat(8);
		this.pitchElevator = byteArray.getFloat(12);
		this.yawRudder = byteArray.getFloat(16);
		this.throttle = byteArray.getFloat(20);
		this.aux1 = byteArray.getFloat(24);
		this.aux2 = byteArray.getFloat(28);
		this.aux3 = byteArray.getFloat(32);
		this.aux4 = byteArray.getFloat(36);
		this.mode = byteArray.getUnsignedInt8(40);
		this.navMode = byteArray.getUnsignedInt8(41);
	}

	@Override
	public byte[] messagePayload() {
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final HilControls setTimeUsec(BigInteger timeUsec) {
		this.timeUsec = timeUsec;
		return this;
	}

	public final BigInteger getTimeUsec() {
		return timeUsec;
	}

	public final HilControls setRollAilerons(float rollAilerons) {
		this.rollAilerons = rollAilerons;
		return this;
	}

	public final float getRollAilerons() {
		return rollAilerons;
	}

	public final HilControls setPitchElevator(float pitchElevator) {
		this.pitchElevator = pitchElevator;
		return this;
	}

	public final float getPitchElevator() {
		return pitchElevator;
	}

	public final HilControls setYawRudder(float yawRudder) {
		this.yawRudder = yawRudder;
		return this;
	}

	public final float getYawRudder() {
		return yawRudder;
	}

	public final HilControls setThrottle(float throttle) {
		this.throttle = throttle;
		return this;
	}

	public final float getThrottle() {
		return throttle;
	}

	public final HilControls setAux1(float aux1) {
		this.aux1 = aux1;
		return this;
	}

	public final float getAux1() {
		return aux1;
	}

	public final HilControls setAux2(float aux2) {
		this.aux2 = aux2;
		return this;
	}

	public final float getAux2() {
		return aux2;
	}

	public final HilControls setAux3(float aux3) {
		this.aux3 = aux3;
		return this;
	}

	public final float getAux3() {
		return aux3;
	}

	public final HilControls setAux4(float aux4) {
		this.aux4 = aux4;
		return this;
	}

	public final float getAux4() {
		return aux4;
	}

	public final HilControls setMode(short mode) {
		this.mode = mode;
		return this;
	}

	public final short getMode() {
		return mode;
	}

	public final HilControls setNavMode(short navMode) {
		this.navMode = navMode;
		return this;
	}

	public final short getNavMode() {
		return navMode;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			HilControls other = (HilControls)o;
			if (!Objects.deepEquals(this.timeUsec, other.timeUsec)) {
				return false;
			} else if (!Objects.deepEquals(this.rollAilerons, other.rollAilerons)) {
				return false;
			} else if (!Objects.deepEquals(this.pitchElevator, other.pitchElevator)) {
				return false;
			} else if (!Objects.deepEquals(this.yawRudder, other.yawRudder)) {
				return false;
			} else if (!Objects.deepEquals(this.throttle, other.throttle)) {
				return false;
			} else if (!Objects.deepEquals(this.aux1, other.aux1)) {
				return false;
			} else if (!Objects.deepEquals(this.aux2, other.aux2)) {
				return false;
			} else if (!Objects.deepEquals(this.aux3, other.aux3)) {
				return false;
			} else if (!Objects.deepEquals(this.aux4, other.aux4)) {
				return false;
			} else if (!Objects.deepEquals(this.mode, other.mode)) {
				return false;
			} else {
				return Objects.deepEquals(this.navMode, other.navMode);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.timeUsec);
		result = 31 * result + Objects.hashCode(this.rollAilerons);
		result = 31 * result + Objects.hashCode(this.pitchElevator);
		result = 31 * result + Objects.hashCode(this.yawRudder);
		result = 31 * result + Objects.hashCode(this.throttle);
		result = 31 * result + Objects.hashCode(this.aux1);
		result = 31 * result + Objects.hashCode(this.aux2);
		result = 31 * result + Objects.hashCode(this.aux3);
		result = 31 * result + Objects.hashCode(this.aux4);
		result = 31 * result + Objects.hashCode(this.mode);
		result = 31 * result + Objects.hashCode(this.navMode);
		return result;
	}

	@Override
	public String toString() {
		return "HilControls{" +
				"timeUsec=" + timeUsec +
				", rollAilerons=" + rollAilerons +
				", pitchElevator=" + pitchElevator +
				", yawRudder=" + yawRudder +
				", throttle=" + throttle +
				", aux1=" + aux1 +
				", aux2=" + aux2 +
				", aux3=" + aux3 +
				", aux4=" + aux4 +
				", mode=" + mode +
				", navMode=" + navMode +
				'}';
	}
}
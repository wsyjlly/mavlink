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
		id = 69,
		messagePayloadLength = 11,
		description = "This message provides an API for manually controlling the vehicle using standard joystick axes nomenclature, along with a joystick-like input device. Unused axes can be disabled an buttons are also transmit as boolean values of their"
)
public class ManualControl implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1)
	private short target;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 2, typeSize = 2, streamLength = 2)
	private short x;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 3, typeSize = 2, streamLength = 2)
	private short y;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 4, typeSize = 2, streamLength = 2)
	private short z;

	@MavlinkMessageParam(mavlinkType = "int16_t", position = 5, typeSize = 2, streamLength = 2)
	private short r;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 6, typeSize = 2, streamLength = 2)
	private int buttons;

	private final int messagePayloadLength = 11;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public ManualControl(short target, short x, short y, short z, short r, int buttons) {
		this.target = target;
		this.x = x;
		this.y = y;
		this.z = z;
		this.r = r;
		this.buttons = buttons;
	}

	public ManualControl(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 11！");
		}
		messagePayload(messagePayload);
	}

	public ManualControl(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.target = byteArray.getUnsignedInt8(0);
		this.x = byteArray.getInt16(1);
		this.y = byteArray.getInt16(3);
		this.z = byteArray.getInt16(5);
		this.r = byteArray.getInt16(7);
		this.buttons = byteArray.getUnsignedInt16(9);
	}

	@Override
	public byte[] messagePayload() {
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final ManualControl setTarget(short target) {
		this.target = target;
		return this;
	}

	public final short getTarget() {
		return target;
	}

	public final ManualControl setX(short x) {
		this.x = x;
		return this;
	}

	public final short getX() {
		return x;
	}

	public final ManualControl setY(short y) {
		this.y = y;
		return this;
	}

	public final short getY() {
		return y;
	}

	public final ManualControl setZ(short z) {
		this.z = z;
		return this;
	}

	public final short getZ() {
		return z;
	}

	public final ManualControl setR(short r) {
		this.r = r;
		return this;
	}

	public final short getR() {
		return r;
	}

	public final ManualControl setButtons(int buttons) {
		this.buttons = buttons;
		return this;
	}

	public final int getButtons() {
		return buttons;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			ManualControl other = (ManualControl)o;
			if (!Objects.deepEquals(this.target, other.target)) {
				return false;
			} else if (!Objects.deepEquals(this.x, other.x)) {
				return false;
			} else if (!Objects.deepEquals(this.y, other.y)) {
				return false;
			} else if (!Objects.deepEquals(this.z, other.z)) {
				return false;
			} else if (!Objects.deepEquals(this.r, other.r)) {
				return false;
			} else {
				return Objects.deepEquals(this.buttons, other.buttons);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.target);
		result = 31 * result + Objects.hashCode(this.x);
		result = 31 * result + Objects.hashCode(this.y);
		result = 31 * result + Objects.hashCode(this.z);
		result = 31 * result + Objects.hashCode(this.r);
		result = 31 * result + Objects.hashCode(this.buttons);
		return result;
	}

	@Override
	public String toString() {
		return "ManualControl{" +
				"target=" + target +
				", x=" + x +
				", y=" + y +
				", z=" + z +
				", r=" + r +
				", buttons=" + buttons +
				'}';
	}
}
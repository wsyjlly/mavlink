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
		id = 75,
		messagePayloadLength = 35,
		description = "Message encoding a command with parameters as scaled integers. Scaling depends on the actual command value."
)
public class CommandInt implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1)
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1)
	private short targetComponent;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1)
	private short frame;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 4, typeSize = 2, streamLength = 2)
	private int command;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 5, typeSize = 1, streamLength = 1)
	private short current;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 6, typeSize = 1, streamLength = 1)
	private short autocontinue;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4)
	private float param1;

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 4)
	private float param2;

	@MavlinkMessageParam(mavlinkType = "float", position = 9, typeSize = 4, streamLength = 4)
	private float param3;

	@MavlinkMessageParam(mavlinkType = "float", position = 10, typeSize = 4, streamLength = 4)
	private float param4;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 11, typeSize = 4, streamLength = 4)
	private int x;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 12, typeSize = 4, streamLength = 4)
	private int y;

	@MavlinkMessageParam(mavlinkType = "float", position = 13, typeSize = 4, streamLength = 4)
	private float z;

	private final int messagePayloadLength = 35;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public CommandInt(short targetSystem, short targetComponent, short frame, int command, short current, short autocontinue, float param1, float param2, float param3, float param4, int x, int y, float z) {
		this.targetSystem = targetSystem;
		this.targetComponent = targetComponent;
		this.frame = frame;
		this.command = command;
		this.current = current;
		this.autocontinue = autocontinue;
		this.param1 = param1;
		this.param2 = param2;
		this.param3 = param3;
		this.param4 = param4;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public CommandInt(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 35！");
		}
		messagePayload(messagePayload);
	}

	public CommandInt(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.targetSystem = byteArray.getUnsignedInt8(0);
		this.targetComponent = byteArray.getUnsignedInt8(1);
		this.frame = byteArray.getUnsignedInt8(2);
		this.command = byteArray.getUnsignedInt16(3);
		this.current = byteArray.getUnsignedInt8(5);
		this.autocontinue = byteArray.getUnsignedInt8(6);
		this.param1 = byteArray.getFloat(7);
		this.param2 = byteArray.getFloat(11);
		this.param3 = byteArray.getFloat(15);
		this.param4 = byteArray.getFloat(19);
		this.x = byteArray.getInt32(23);
		this.y = byteArray.getInt32(27);
		this.z = byteArray.getFloat(31);
	}

	@Override
	public byte[] messagePayload() {
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final CommandInt setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final CommandInt setTargetComponent(short targetComponent) {
		this.targetComponent = targetComponent;
		return this;
	}

	public final short getTargetComponent() {
		return targetComponent;
	}

	public final CommandInt setFrame(short frame) {
		this.frame = frame;
		return this;
	}

	public final short getFrame() {
		return frame;
	}

	public final CommandInt setCommand(int command) {
		this.command = command;
		return this;
	}

	public final int getCommand() {
		return command;
	}

	public final CommandInt setCurrent(short current) {
		this.current = current;
		return this;
	}

	public final short getCurrent() {
		return current;
	}

	public final CommandInt setAutocontinue(short autocontinue) {
		this.autocontinue = autocontinue;
		return this;
	}

	public final short getAutocontinue() {
		return autocontinue;
	}

	public final CommandInt setParam1(float param1) {
		this.param1 = param1;
		return this;
	}

	public final float getParam1() {
		return param1;
	}

	public final CommandInt setParam2(float param2) {
		this.param2 = param2;
		return this;
	}

	public final float getParam2() {
		return param2;
	}

	public final CommandInt setParam3(float param3) {
		this.param3 = param3;
		return this;
	}

	public final float getParam3() {
		return param3;
	}

	public final CommandInt setParam4(float param4) {
		this.param4 = param4;
		return this;
	}

	public final float getParam4() {
		return param4;
	}

	public final CommandInt setX(int x) {
		this.x = x;
		return this;
	}

	public final int getX() {
		return x;
	}

	public final CommandInt setY(int y) {
		this.y = y;
		return this;
	}

	public final int getY() {
		return y;
	}

	public final CommandInt setZ(float z) {
		this.z = z;
		return this;
	}

	public final float getZ() {
		return z;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			CommandInt other = (CommandInt)o;
			if (!Objects.deepEquals(this.targetSystem, other.targetSystem)) {
				return false;
			} else if (!Objects.deepEquals(this.targetComponent, other.targetComponent)) {
				return false;
			} else if (!Objects.deepEquals(this.frame, other.frame)) {
				return false;
			} else if (!Objects.deepEquals(this.command, other.command)) {
				return false;
			} else if (!Objects.deepEquals(this.current, other.current)) {
				return false;
			} else if (!Objects.deepEquals(this.autocontinue, other.autocontinue)) {
				return false;
			} else if (!Objects.deepEquals(this.param1, other.param1)) {
				return false;
			} else if (!Objects.deepEquals(this.param2, other.param2)) {
				return false;
			} else if (!Objects.deepEquals(this.param3, other.param3)) {
				return false;
			} else if (!Objects.deepEquals(this.param4, other.param4)) {
				return false;
			} else if (!Objects.deepEquals(this.x, other.x)) {
				return false;
			} else if (!Objects.deepEquals(this.y, other.y)) {
				return false;
			} else {
				return Objects.deepEquals(this.z, other.z);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.targetSystem);
		result = 31 * result + Objects.hashCode(this.targetComponent);
		result = 31 * result + Objects.hashCode(this.frame);
		result = 31 * result + Objects.hashCode(this.command);
		result = 31 * result + Objects.hashCode(this.current);
		result = 31 * result + Objects.hashCode(this.autocontinue);
		result = 31 * result + Objects.hashCode(this.param1);
		result = 31 * result + Objects.hashCode(this.param2);
		result = 31 * result + Objects.hashCode(this.param3);
		result = 31 * result + Objects.hashCode(this.param4);
		result = 31 * result + Objects.hashCode(this.x);
		result = 31 * result + Objects.hashCode(this.y);
		result = 31 * result + Objects.hashCode(this.z);
		return result;
	}

	@Override
	public String toString() {
		return "CommandInt{" +
				"targetSystem=" + targetSystem +
				", targetComponent=" + targetComponent +
				", frame=" + frame +
				", command=" + command +
				", current=" + current +
				", autocontinue=" + autocontinue +
				", param1=" + param1 +
				", param2=" + param2 +
				", param3=" + param3 +
				", param4=" + param4 +
				", x=" + x +
				", y=" + y +
				", z=" + z +
				'}';
	}
}
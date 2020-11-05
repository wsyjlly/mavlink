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
		id = 73,
		messagePayloadLength = 37,
		description = "Message encoding a mission item. This message is emitted to announce the presence of a mission item and to set a mission item on the system. The mission item can be either in x, y, z meters (type: LOCAL) or x:lat, y:lon, z:altitude. Local frame is Z-down, right handed (NED), global frame is Z-up, right handed (ENU). See alsohttp://qgroundcontrol.org/mavlink/waypoint_protocol."
)
public class MissionItemInt implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1)
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1)
	private short targetComponent;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 3, typeSize = 2, streamLength = 2)
	private int seq;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 1)
	private short frame;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 5, typeSize = 2, streamLength = 2)
	private int command;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 6, typeSize = 1, streamLength = 1)
	private short current;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 7, typeSize = 1, streamLength = 1)
	private short autocontinue;

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 4)
	private float param1;

	@MavlinkMessageParam(mavlinkType = "float", position = 9, typeSize = 4, streamLength = 4)
	private float param2;

	@MavlinkMessageParam(mavlinkType = "float", position = 10, typeSize = 4, streamLength = 4)
	private float param3;

	@MavlinkMessageParam(mavlinkType = "float", position = 11, typeSize = 4, streamLength = 4)
	private float param4;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 12, typeSize = 4, streamLength = 4)
	private int x;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 13, typeSize = 4, streamLength = 4)
	private int y;

	@MavlinkMessageParam(mavlinkType = "float", position = 14, typeSize = 4, streamLength = 4)
	private float z;

	private final int messagePayloadLength = 37;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public MissionItemInt(short targetSystem, short targetComponent, int seq, short frame, int command, short current, short autocontinue, float param1, float param2, float param3, float param4, int x, int y, float z) {
		this.targetSystem = targetSystem;
		this.targetComponent = targetComponent;
		this.seq = seq;
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

	public MissionItemInt(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 37！");
		}
		messagePayload(messagePayload);
	}

	public MissionItemInt(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.targetSystem = byteArray.getUnsignedInt8(0);
		this.targetComponent = byteArray.getUnsignedInt8(1);
		this.seq = byteArray.getUnsignedInt16(2);
		this.frame = byteArray.getUnsignedInt8(4);
		this.command = byteArray.getUnsignedInt16(5);
		this.current = byteArray.getUnsignedInt8(7);
		this.autocontinue = byteArray.getUnsignedInt8(8);
		this.param1 = byteArray.getFloat(9);
		this.param2 = byteArray.getFloat(13);
		this.param3 = byteArray.getFloat(17);
		this.param4 = byteArray.getFloat(21);
		this.x = byteArray.getInt32(25);
		this.y = byteArray.getInt32(29);
		this.z = byteArray.getFloat(33);
	}

	@Override
	public byte[] messagePayload() {
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final MissionItemInt setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final MissionItemInt setTargetComponent(short targetComponent) {
		this.targetComponent = targetComponent;
		return this;
	}

	public final short getTargetComponent() {
		return targetComponent;
	}

	public final MissionItemInt setSeq(int seq) {
		this.seq = seq;
		return this;
	}

	public final int getSeq() {
		return seq;
	}

	public final MissionItemInt setFrame(short frame) {
		this.frame = frame;
		return this;
	}

	public final short getFrame() {
		return frame;
	}

	public final MissionItemInt setCommand(int command) {
		this.command = command;
		return this;
	}

	public final int getCommand() {
		return command;
	}

	public final MissionItemInt setCurrent(short current) {
		this.current = current;
		return this;
	}

	public final short getCurrent() {
		return current;
	}

	public final MissionItemInt setAutocontinue(short autocontinue) {
		this.autocontinue = autocontinue;
		return this;
	}

	public final short getAutocontinue() {
		return autocontinue;
	}

	public final MissionItemInt setParam1(float param1) {
		this.param1 = param1;
		return this;
	}

	public final float getParam1() {
		return param1;
	}

	public final MissionItemInt setParam2(float param2) {
		this.param2 = param2;
		return this;
	}

	public final float getParam2() {
		return param2;
	}

	public final MissionItemInt setParam3(float param3) {
		this.param3 = param3;
		return this;
	}

	public final float getParam3() {
		return param3;
	}

	public final MissionItemInt setParam4(float param4) {
		this.param4 = param4;
		return this;
	}

	public final float getParam4() {
		return param4;
	}

	public final MissionItemInt setX(int x) {
		this.x = x;
		return this;
	}

	public final int getX() {
		return x;
	}

	public final MissionItemInt setY(int y) {
		this.y = y;
		return this;
	}

	public final int getY() {
		return y;
	}

	public final MissionItemInt setZ(float z) {
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
			MissionItemInt other = (MissionItemInt)o;
			if (!Objects.deepEquals(this.targetSystem, other.targetSystem)) {
				return false;
			} else if (!Objects.deepEquals(this.targetComponent, other.targetComponent)) {
				return false;
			} else if (!Objects.deepEquals(this.seq, other.seq)) {
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
		result = 31 * result + Objects.hashCode(this.seq);
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
		return "MissionItemInt{" +
				"targetSystem=" + targetSystem +
				", targetComponent=" + targetComponent +
				", seq=" + seq +
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
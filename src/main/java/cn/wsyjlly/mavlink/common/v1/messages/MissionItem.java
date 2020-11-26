package cn.wsyjlly.mavlink.common.v1.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:45
 **********************************/

@MavlinkMessage(
		id = 39,
		messagePayloadLength = 37,
		description = "Message encoding a mission item. This message is emitted to announce the presence of a mission item and to set a mission item on the system. The mission item can be either in x, y, z meters (type: LOCAL) or x:lat, y:lon, z:altitude. Local frame is Z-down, right handed (NED), global frame is Z-up, right handed (ENU). See also http://qgroundcontrol.org/mavlink/waypoint_protocol."
)
public class MissionItem implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1, description = "System ID")
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Component ID")
	private short targetComponent;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 3, typeSize = 2, streamLength = 2, description = "Sequence")
	private int seq;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 1, description = "The coordinate system of the MISSION. see MAV_FRAME in mavlink_types.h")
	private short frame;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 5, typeSize = 2, streamLength = 2, description = "The scheduled action for the MISSION. see MAV_CMD in common.xml MAVLink specs")
	private int command;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 6, typeSize = 1, streamLength = 1, description = "false:0, true:1")
	private short current;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 7, typeSize = 1, streamLength = 1, description = "autocontinue to next wp")
	private short autocontinue;

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 4, description = "PARAM1, see MAV_CMD enum")
	private float param1;

	@MavlinkMessageParam(mavlinkType = "float", position = 9, typeSize = 4, streamLength = 4, description = "PARAM2, see MAV_CMD enum")
	private float param2;

	@MavlinkMessageParam(mavlinkType = "float", position = 10, typeSize = 4, streamLength = 4, description = "PARAM3, see MAV_CMD enum")
	private float param3;

	@MavlinkMessageParam(mavlinkType = "float", position = 11, typeSize = 4, streamLength = 4, description = "PARAM4, see MAV_CMD enum")
	private float param4;

	@MavlinkMessageParam(mavlinkType = "float", position = 12, typeSize = 4, streamLength = 4, description = "PARAM5 / local: x position, global: latitude")
	private float x;

	@MavlinkMessageParam(mavlinkType = "float", position = 13, typeSize = 4, streamLength = 4, description = "PARAM6 / y position: global: longitude")
	private float y;

	@MavlinkMessageParam(mavlinkType = "float", position = 14, typeSize = 4, streamLength = 4, description = "PARAM7 / z position: global: altitude (relative or absolute, depending on frame.")
	private float z;

	private final int messagePayloadLength = 37;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public MissionItem(short targetSystem, short targetComponent, int seq, short frame, int command, short current, short autocontinue, float param1, float param2, float param3, float param4, float x, float y, float z) {
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

	public MissionItem(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 37！");
		}
		messagePayload(messagePayload);
	}

	public MissionItem(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		targetSystem = byteArray.getUnsignedInt8(0);
		targetComponent = byteArray.getUnsignedInt8(1);
		seq = byteArray.getUnsignedInt16(2);
		frame = byteArray.getUnsignedInt8(4);
		command = byteArray.getUnsignedInt16(5);
		current = byteArray.getUnsignedInt8(7);
		autocontinue = byteArray.getUnsignedInt8(8);
		param1 = byteArray.getFloat(9);
		param2 = byteArray.getFloat(13);
		param3 = byteArray.getFloat(17);
		param4 = byteArray.getFloat(21);
		x = byteArray.getFloat(25);
		y = byteArray.getFloat(29);
		z = byteArray.getFloat(33);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt8(targetSystem,0);
		byteArray.putUnsignedInt8(targetComponent,1);
		byteArray.putUnsignedInt16(seq,2);
		byteArray.putUnsignedInt8(frame,4);
		byteArray.putUnsignedInt16(command,5);
		byteArray.putUnsignedInt8(current,7);
		byteArray.putUnsignedInt8(autocontinue,8);
		byteArray.putFloat(param1,9);
		byteArray.putFloat(param2,13);
		byteArray.putFloat(param3,17);
		byteArray.putFloat(param4,21);
		byteArray.putFloat(x,25);
		byteArray.putFloat(y,29);
		byteArray.putFloat(z,33);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final MissionItem setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final MissionItem setTargetComponent(short targetComponent) {
		this.targetComponent = targetComponent;
		return this;
	}

	public final short getTargetComponent() {
		return targetComponent;
	}

	public final MissionItem setSeq(int seq) {
		this.seq = seq;
		return this;
	}

	public final int getSeq() {
		return seq;
	}

	public final MissionItem setFrame(short frame) {
		this.frame = frame;
		return this;
	}

	public final short getFrame() {
		return frame;
	}

	public final MissionItem setCommand(int command) {
		this.command = command;
		return this;
	}

	public final int getCommand() {
		return command;
	}

	public final MissionItem setCurrent(short current) {
		this.current = current;
		return this;
	}

	public final short getCurrent() {
		return current;
	}

	public final MissionItem setAutocontinue(short autocontinue) {
		this.autocontinue = autocontinue;
		return this;
	}

	public final short getAutocontinue() {
		return autocontinue;
	}

	public final MissionItem setParam1(float param1) {
		this.param1 = param1;
		return this;
	}

	public final float getParam1() {
		return param1;
	}

	public final MissionItem setParam2(float param2) {
		this.param2 = param2;
		return this;
	}

	public final float getParam2() {
		return param2;
	}

	public final MissionItem setParam3(float param3) {
		this.param3 = param3;
		return this;
	}

	public final float getParam3() {
		return param3;
	}

	public final MissionItem setParam4(float param4) {
		this.param4 = param4;
		return this;
	}

	public final float getParam4() {
		return param4;
	}

	public final MissionItem setX(float x) {
		this.x = x;
		return this;
	}

	public final float getX() {
		return x;
	}

	public final MissionItem setY(float y) {
		this.y = y;
		return this;
	}

	public final float getY() {
		return y;
	}

	public final MissionItem setZ(float z) {
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
			MissionItem other = (MissionItem)o;
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
		return "MissionItem{" +
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
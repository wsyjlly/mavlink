package cn.wsyjlly.mavlink.common.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.enums.MavCmd;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.09 - 03:37
 **********************************/

@MavlinkMessage(
		id = 76,
		messagePayloadLength = 33,
		description = "Send a command with up to seven parameters to the MAV"
)
public class CommandLong implements Message {
	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 1, typeSize = 1, streamLength = 1)
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1)
	private short targetComponent;

	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 3, typeSize = 2, streamLength = 2, enum0 = MavCmd.class)
	private int command;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 4, typeSize = 1, streamLength = 1)
	private short confirmation;

	@MavlinkMessageParam(mavlinkType = "float", position = 5, typeSize = 4, streamLength = 4)
	private float param1;

	@MavlinkMessageParam(mavlinkType = "float", position = 6, typeSize = 4, streamLength = 4)
	private float param2;

	@MavlinkMessageParam(mavlinkType = "float", position = 7, typeSize = 4, streamLength = 4)
	private float param3;

	@MavlinkMessageParam(mavlinkType = "float", position = 8, typeSize = 4, streamLength = 4)
	private float param4;

	@MavlinkMessageParam(mavlinkType = "float", position = 9, typeSize = 4, streamLength = 4)
	private float param5;

	@MavlinkMessageParam(mavlinkType = "float", position = 10, typeSize = 4, streamLength = 4)
	private float param6;

	@MavlinkMessageParam(mavlinkType = "float", position = 11, typeSize = 4, streamLength = 4)
	private float param7;

	private final int messagePayloadLength = 33;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public CommandLong(short targetSystem, short targetComponent, int command, short confirmation, float param1, float param2, float param3, float param4, float param5, float param6, float param7) {
		this.targetSystem = targetSystem;
		this.targetComponent = targetComponent;
		this.command = command;
		this.confirmation = confirmation;
		this.param1 = param1;
		this.param2 = param2;
		this.param3 = param3;
		this.param4 = param4;
		this.param5 = param5;
		this.param6 = param6;
		this.param7 = param7;
	}

	public CommandLong(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 33！");
		}
		messagePayload(messagePayload);
	}

	public CommandLong(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		this.targetSystem = byteArray.getUnsignedInt8(0);
		this.targetComponent = byteArray.getUnsignedInt8(1);
		this.command = byteArray.getUnsignedInt16(2);
		this.confirmation = byteArray.getUnsignedInt8(4);
		this.param1 = byteArray.getFloat(5);
		this.param2 = byteArray.getFloat(9);
		this.param3 = byteArray.getFloat(13);
		this.param4 = byteArray.getFloat(17);
		this.param5 = byteArray.getFloat(21);
		this.param6 = byteArray.getFloat(25);
		this.param7 = byteArray.getFloat(29);
	}

	@Override
	public byte[] messagePayload() {
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final CommandLong setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final CommandLong setTargetComponent(short targetComponent) {
		this.targetComponent = targetComponent;
		return this;
	}

	public final short getTargetComponent() {
		return targetComponent;
	}

	public final CommandLong setCommand(int command) {
		this.command = command;
		return this;
	}

	public final int getCommand() {
		return command;
	}

	public final CommandLong setConfirmation(short confirmation) {
		this.confirmation = confirmation;
		return this;
	}

	public final short getConfirmation() {
		return confirmation;
	}

	public final CommandLong setParam1(float param1) {
		this.param1 = param1;
		return this;
	}

	public final float getParam1() {
		return param1;
	}

	public final CommandLong setParam2(float param2) {
		this.param2 = param2;
		return this;
	}

	public final float getParam2() {
		return param2;
	}

	public final CommandLong setParam3(float param3) {
		this.param3 = param3;
		return this;
	}

	public final float getParam3() {
		return param3;
	}

	public final CommandLong setParam4(float param4) {
		this.param4 = param4;
		return this;
	}

	public final float getParam4() {
		return param4;
	}

	public final CommandLong setParam5(float param5) {
		this.param5 = param5;
		return this;
	}

	public final float getParam5() {
		return param5;
	}

	public final CommandLong setParam6(float param6) {
		this.param6 = param6;
		return this;
	}

	public final float getParam6() {
		return param6;
	}

	public final CommandLong setParam7(float param7) {
		this.param7 = param7;
		return this;
	}

	public final float getParam7() {
		return param7;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			CommandLong other = (CommandLong)o;
			if (!Objects.deepEquals(this.targetSystem, other.targetSystem)) {
				return false;
			} else if (!Objects.deepEquals(this.targetComponent, other.targetComponent)) {
				return false;
			} else if (!Objects.deepEquals(this.command, other.command)) {
				return false;
			} else if (!Objects.deepEquals(this.confirmation, other.confirmation)) {
				return false;
			} else if (!Objects.deepEquals(this.param1, other.param1)) {
				return false;
			} else if (!Objects.deepEquals(this.param2, other.param2)) {
				return false;
			} else if (!Objects.deepEquals(this.param3, other.param3)) {
				return false;
			} else if (!Objects.deepEquals(this.param4, other.param4)) {
				return false;
			} else if (!Objects.deepEquals(this.param5, other.param5)) {
				return false;
			} else if (!Objects.deepEquals(this.param6, other.param6)) {
				return false;
			} else {
				return Objects.deepEquals(this.param7, other.param7);
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
		result = 31 * result + Objects.hashCode(this.command);
		result = 31 * result + Objects.hashCode(this.confirmation);
		result = 31 * result + Objects.hashCode(this.param1);
		result = 31 * result + Objects.hashCode(this.param2);
		result = 31 * result + Objects.hashCode(this.param3);
		result = 31 * result + Objects.hashCode(this.param4);
		result = 31 * result + Objects.hashCode(this.param5);
		result = 31 * result + Objects.hashCode(this.param6);
		result = 31 * result + Objects.hashCode(this.param7);
		return result;
	}

	@Override
	public String toString() {
		return "CommandLong{" +
				"targetSystem=" + targetSystem +
				", targetComponent=" + targetComponent +
				", command=" + command +
				", confirmation=" + confirmation +
				", param1=" + param1 +
				", param2=" + param2 +
				", param3=" + param3 +
				", param4=" + param4 +
				", param5=" + param5 +
				", param6=" + param6 +
				", param7=" + param7 +
				'}';
	}
}
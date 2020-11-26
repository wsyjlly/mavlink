package cn.wsyjlly.mavlink.common.v2.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v2.enums.MavResult;
import cn.wsyjlly.mavlink.common.v2.enums.MavCmd;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:46
 **********************************/

@MavlinkMessage(
		id = 77,
		messagePayloadLength = 10,
		description = "Report status of a command. Includes feedback whether the command was executed. The command microservice is documented at https://mavlink.io/en/services/command.html"
)
public class CommandAck implements Message {
	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 1, typeSize = 2, streamLength = 2, description = "Command ID (of acknowledged command).", enum0 = MavCmd.class)
	private int command;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "Result of command.", enum0 = MavResult.class)
	private short result;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 3, typeSize = 1, streamLength = 1, description = "WIP: Also used as result_param1, it can be set with an enum containing the errors reasons of why the command was denied, or the progress percentage when result is MAV_RESULT_IN_PROGRESS (255 if the progress is unknown).")
	private short progress;

	@MavlinkMessageParam(mavlinkType = "int32_t", position = 4, typeSize = 4, streamLength = 4, description = "WIP: Additional parameter of the result, example: which parameter of MAV_CMD_NAV_WAYPOINT caused it to be denied.")
	private int resultParam2;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 5, typeSize = 1, streamLength = 1, description = "WIP: System ID of the target recipient. This is the ID of the system that sent the command for which this COMMAND_ACK is an acknowledgement.")
	private short targetSystem;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 6, typeSize = 1, streamLength = 1, description = "WIP: Component ID of the target recipient. This is the ID of the system that sent the command for which this COMMAND_ACK is an acknowledgement.")
	private short targetComponent;

	private final int messagePayloadLength = 10;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public CommandAck(int command, short result, short progress, int resultParam2, short targetSystem, short targetComponent) {
		this.command = command;
		this.result = result;
		this.progress = progress;
		this.resultParam2 = resultParam2;
		this.targetSystem = targetSystem;
		this.targetComponent = targetComponent;
	}

	public CommandAck(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 10！");
		}
		messagePayload(messagePayload);
	}

	public CommandAck(){ }

	@Override
	public void messagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
		ByteArray byteArray = new ByteArray(messagePayload);
		command = byteArray.getUnsignedInt16(0);
		result = byteArray.getUnsignedInt8(2);
		progress = byteArray.getUnsignedInt8(3);
		resultParam2 = byteArray.getInt32(4);
		targetSystem = byteArray.getUnsignedInt8(8);
		targetComponent = byteArray.getUnsignedInt8(9);
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt16(command,0);
		byteArray.putUnsignedInt8(result,2);
		byteArray.putUnsignedInt8(progress,3);
		byteArray.putInt32(resultParam2,4);
		byteArray.putUnsignedInt8(targetSystem,8);
		byteArray.putUnsignedInt8(targetComponent,9);
		return messagePayload;
	}
	
	@Override
	public String hexStringPayload() {
		return ByteModel.bytes2HexString(messagePayload);
	}

	public final CommandAck setCommand(int command) {
		this.command = command;
		return this;
	}

	public final int getCommand() {
		return command;
	}

	public final CommandAck setResult(short result) {
		this.result = result;
		return this;
	}

	public final short getResult() {
		return result;
	}

	public final CommandAck setProgress(short progress) {
		this.progress = progress;
		return this;
	}

	public final short getProgress() {
		return progress;
	}

	public final CommandAck setResultParam2(int resultParam2) {
		this.resultParam2 = resultParam2;
		return this;
	}

	public final int getResultParam2() {
		return resultParam2;
	}

	public final CommandAck setTargetSystem(short targetSystem) {
		this.targetSystem = targetSystem;
		return this;
	}

	public final short getTargetSystem() {
		return targetSystem;
	}

	public final CommandAck setTargetComponent(short targetComponent) {
		this.targetComponent = targetComponent;
		return this;
	}

	public final short getTargetComponent() {
		return targetComponent;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			CommandAck other = (CommandAck)o;
			if (!Objects.deepEquals(this.command, other.command)) {
				return false;
			} else if (!Objects.deepEquals(this.result, other.result)) {
				return false;
			} else if (!Objects.deepEquals(this.progress, other.progress)) {
				return false;
			} else if (!Objects.deepEquals(this.resultParam2, other.resultParam2)) {
				return false;
			} else if (!Objects.deepEquals(this.targetSystem, other.targetSystem)) {
				return false;
			} else {
				return Objects.deepEquals(this.targetComponent, other.targetComponent);
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + Objects.hashCode(this.command);
		result = 31 * result + Objects.hashCode(this.result);
		result = 31 * result + Objects.hashCode(this.progress);
		result = 31 * result + Objects.hashCode(this.resultParam2);
		result = 31 * result + Objects.hashCode(this.targetSystem);
		result = 31 * result + Objects.hashCode(this.targetComponent);
		return result;
	}

	@Override
	public String toString() {
		return "CommandAck{" +
				"command=" + command +
				", result=" + result +
				", progress=" + progress +
				", resultParam2=" + resultParam2 +
				", targetSystem=" + targetSystem +
				", targetComponent=" + targetComponent +
				'}';
	}
}
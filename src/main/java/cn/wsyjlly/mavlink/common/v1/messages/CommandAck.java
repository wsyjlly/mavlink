package cn.wsyjlly.mavlink.common.v1.messages;

import cn.wsyjlly.mavlink.annotation.MavlinkMessage;
import cn.wsyjlly.mavlink.annotation.MavlinkMessageParam;
import cn.wsyjlly.mavlink.common.Message;
import cn.wsyjlly.mavlink.common.v1.enums.MavCmd;
import cn.wsyjlly.mavlink.protocol.ByteArray;
import cn.wsyjlly.mavlink.protocol.util.ByteModel;

import java.util.Objects;
/**********************************
 * Author YSW
 * Description
 * Date 2020.11.26 - 02:45
 **********************************/

@MavlinkMessage(
		id = 77,
		messagePayloadLength = 3,
		description = "Report status of a command. Includes feedback wether the command was executed."
)
public class CommandAck implements Message {
	@MavlinkMessageParam(mavlinkType = "uint16_t", position = 1, typeSize = 2, streamLength = 2, description = "Command ID, as defined by MAV_CMD enum.", enum0 = MavCmd.class)
	private int command;

	@MavlinkMessageParam(mavlinkType = "uint8_t", position = 2, typeSize = 1, streamLength = 1, description = "See MAV_RESULT enum")
	private short result;

	private final int messagePayloadLength = 3;

	private byte[] messagePayload = new byte[messagePayloadLength];

	public CommandAck(int command, short result) {
		this.command = command;
		this.result = result;
	}

	public CommandAck(byte[] messagePayload) {
		if (messagePayload.length != messagePayloadLength){
			throw new IllegalArgumentException("Byte array length is not equal to 3！");
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
	}

	@Override
	public byte[] messagePayload() {
		ByteArray byteArray = new ByteArray(messagePayload);
		byteArray.putUnsignedInt16(command,0);
		byteArray.putUnsignedInt8(result,2);
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

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass().equals(o.getClass())) {
			CommandAck other = (CommandAck)o;
			if (!Objects.deepEquals(this.command, other.command)) {
				return false;
			} else {
				return Objects.deepEquals(this.result, other.result);
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
		return result;
	}

	@Override
	public String toString() {
		return "CommandAck{" +
				"command=" + command +
				", result=" + result +
				'}';
	}
}